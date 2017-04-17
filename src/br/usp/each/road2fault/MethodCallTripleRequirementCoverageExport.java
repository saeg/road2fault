package br.usp.each.road2fault;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.bcel.classfile.ClassFormatException;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import br.usp.each.inss.RequirementExport;
import br.usp.each.opal.requirement.RequirementType;

public class MethodCallTripleRequirementCoverageExport implements RequirementExport {
	
	private List<MethodCallTripleRequirementCoverage> listRequirements;
	private RequirementType requirementType;
	private HeuristicType heuristicType;
	private File classesDirectory;
	
	public MethodCallTripleRequirementCoverageExport(List<MethodCallTripleRequirementCoverage> lstRequirements, RequirementType reqType, HeuristicType heurType, File classDir) {
        this.listRequirements = lstRequirements;
        this.requirementType = reqType;
        this.heuristicType = heurType;
        this.classesDirectory = classDir;
    }
	
	
	@Override
	public byte[] export() throws IOException {

        Document doc = DocumentHelper.createDocument();
        doc.setXMLEncoding("ISO-8859-1");
        doc.addElement("FaultClassification-MethodCallTriple");

        doDebugReport(doc);
        
        return doc.asXML().getBytes();
	}

	private void doDebugReport(Document doc) {
        
		Element element = doc.getRootElement();
    	element.addAttribute("project", "fault localization");
    	Element elem = element.addElement("test-criteria").addAttribute("requirement-type", "METHODCALLTRIPLE");
    	
    	for(MethodCallTripleRequirementCoverage reqCoverage : listRequirements)
    	{
    		try
    		{
	    		getRequirementWithMethodName(reqCoverage);
	    		elem.addElement("triple").addAttribute("from-method", reqCoverage.getMethodIdCaller()+": "+reqCoverage.getMethodNameCaller())
									   .addAttribute("from-class", reqCoverage.getClassNameCaller())
									   .addAttribute("into-method", reqCoverage.getMethodIdCalledN1()+": "+reqCoverage.getMethodNameCalledN1())
									   .addAttribute("into-class", reqCoverage.getClassNameCalledN1())
									   .addAttribute("to-method", reqCoverage.getMethodIdCalledN2()+": "+reqCoverage.getMethodNameCalledN2())
									   .addAttribute("to-class", reqCoverage.getClassNameCalledN2())
									   .addAttribute("suspicious",String.valueOf(reqCoverage.getSuspicious()));
    		}
    		catch(IOException io)
    		{
    			System.out.println("An error occurs reading class directory.");
    		}
  	    }
    	
    }
	
	//Includes the name of methods in output.
	private void getRequirementWithMethodName(MethodCallTripleRequirementCoverage reqCoverage) throws ClassFormatException, IOException
	{
		File f;
		JavaClass javaClass;
		Method method;
		String signature;
		//getting caller method name
		//if there is not a method called by the testcase that fails
		if(!reqCoverage.getClassNameCaller().contains("0.TestCase.Sentinella")){
			f = new File(classesDirectory, reqCoverage.getClassNameCaller().replace('.', '/') + ".class");
			javaClass = new ClassParser(f.getAbsolutePath()).parse();
			
			method = javaClass.getMethods()[reqCoverage.getMethodIdCaller()];
			signature = formatSignature(method.getSignature());
			reqCoverage.setMethodNameCaller(method.getName()+signature);
		}
		else{//means that the testcase call a method that fails without form a triple
			reqCoverage.setMethodNameCaller("calledByTestCase()");
		}
		
		//getting calledN1 method name
		if(!reqCoverage.getClassNameCalledN1().contains("0.TestCase.Sentinella")){
			f = new File(classesDirectory, reqCoverage.getClassNameCalledN1().replace('.', '/') + ".class");
			javaClass = new ClassParser(f.getAbsolutePath()).parse();
			
			method = javaClass.getMethods()[reqCoverage.getMethodIdCalledN1()];
			signature = formatSignature(method.getSignature());
			reqCoverage.setMethodNameCalledN1(method.getName()+signature);
		}
		else{//means that the testcase call a method that fails without form a triple
			reqCoverage.setMethodNameCalledN1("calledByTestCase()");
		}
		
		//getting calledN2 method name
		f = new File(classesDirectory, reqCoverage.getClassNameCalledN2().replace('.', '/') + ".class");
		javaClass = new ClassParser(f.getAbsolutePath()).parse();
		
		method = javaClass.getMethods()[reqCoverage.getMethodIdCalledN2()];
		signature = formatSignature(method.getSignature());
		reqCoverage.setMethodNameCalledN2(method.getName()+signature);
	}
	
	//Adjust the signature of methods
    public String formatSignature(String strSignature)
    {
    	String sigTemp = strSignature;
    	String signature = "";
    	
    	sigTemp = sigTemp.substring(sigTemp.indexOf("(")+1, sigTemp.indexOf(")"));
    	
    	while(!sigTemp.isEmpty())
    	{
    		boolean isArray = false;
        	if(sigTemp.startsWith("["))
    		{
    			isArray = true;
    			sigTemp = sigTemp.substring(1);
    		}
    		if(sigTemp.startsWith("L"))
    		{
    			String strSig = sigTemp.substring(0,sigTemp.indexOf(";"));
    			signature = signature + strSig.substring(strSig.lastIndexOf("/")+1, strSig.length()) + (!isArray ? "," : "[],");
    			sigTemp = sigTemp.substring(sigTemp.indexOf(";")+1);
    		}
    		else
    		{
    			signature = signature + getPrimitiveType(sigTemp.charAt(0)) + (!isArray ? "," : "[],");
    			if(sigTemp.length() > 1){
    				sigTemp = sigTemp.substring(1);
    			}
    			else{
    				sigTemp = "";
    			}
    		}
    	}
    	
    	if(!signature.isEmpty())
    	{
    		signature = signature.substring(0, signature.lastIndexOf(","));
    	}
    	
    	signature = "("+signature+")";
    	
    	return signature;
    }
    
    public String getPrimitiveType(char cType)
    {
    	if(cType == 'I')
    	{
    		return "int";
    	}
    	if(cType == 'D')
    	{
    		return "double";
    	}
    	if(cType == 'F')
    	{
    		return "float";
    	}
    	if(cType == 'Z')
    	{
    		return "boolean";
    	}
    	if(cType == 'B')
    	{
    		return "byte";
    	}
    	if(cType == 'C')
    	{
    		return "char";
    	}
    	if(cType == 'S')
    	{
    		return "short";
    	}
    	if(cType == 'J')
    	{
    		return "long";
    	}
    	return "";
    }
    
}
