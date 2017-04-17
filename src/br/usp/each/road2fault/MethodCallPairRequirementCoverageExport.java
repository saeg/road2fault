package br.usp.each.road2fault;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.bcel.classfile.ClassFormatException;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.LineNumberTable;
import org.apache.bcel.classfile.Method;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import br.usp.each.inss.RequirementExport;
import br.usp.each.opal.requirement.MethodCallPair;
import br.usp.each.opal.requirement.RequirementType;

public class MethodCallPairRequirementCoverageExport implements RequirementExport {
	
	private List<MethodCallPairRequirementCoverage> listRequirements;
	private RequirementType requirementType;
	private HeuristicType heuristicType;
	private File classesDirectory;

	
	public MethodCallPairRequirementCoverageExport(List<MethodCallPairRequirementCoverage> lstRequirements, RequirementType reqType, HeuristicType heurType, File classDir) {
        this.listRequirements = lstRequirements;
        this.requirementType = reqType;
        this.heuristicType = heurType;
        this.classesDirectory = classDir;
    }
	
	@Override
	public byte[] export() throws IOException {

        Document doc = DocumentHelper.createDocument();
        doc.setXMLEncoding("ISO-8859-1");
        doc.addElement("FaultClassification-MethodCallPair");

        doDebugReport(doc);
        
        return doc.asXML().getBytes();
	}

	private void doDebugReport(Document doc) {
        
		Element element = doc.getRootElement();
    	element.addAttribute("project", "fault localization");
    	Element elem = element.addElement("test-criteria").addAttribute("requirement-type", "METHODCALLPAIR");
    	
    	for(MethodCallPairRequirementCoverage reqCoverage : listRequirements)
    	{
    		try
    		{
	    		getRequirementWithMethodName(reqCoverage);
	    		elem.addElement("pair").addAttribute("from-method", reqCoverage.getMethodIdCaller()+": "+reqCoverage.getMethodNameCaller())
									   .addAttribute("class", reqCoverage.getClassNameCaller())
									   .addAttribute("to-method", reqCoverage.getMethodIdCalled()+": "+reqCoverage.getMethodNameCalled())
									   .addAttribute("to-class", reqCoverage.getClassNameCalled())
									   .addAttribute("suspicious",String.valueOf(reqCoverage.getSuspicious()));
    		}
    		catch(IOException io)
    		{
    			System.out.println("An error occurs reading class directory.");
    		}
  	    }
    	
    }
	
	//Includes the name of methods in output.
	private void getRequirementWithMethodName(MethodCallPairRequirementCoverage reqCoverage) throws ClassFormatException, IOException
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
		else{//means that the testcase call a method that fails without form a pair
			reqCoverage.setMethodNameCaller("calledByTestCase()");
		}
		
		//getting called method name
		f = new File(classesDirectory, reqCoverage.getClassNameCalled().replace('.', '/') + ".class");
		javaClass = new ClassParser(f.getAbsolutePath()).parse();
		
		method = javaClass.getMethods()[reqCoverage.getMethodIdCalled()];
		signature = formatSignature(method.getSignature());
		reqCoverage.setMethodNameCalled(method.getName()+signature);
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
