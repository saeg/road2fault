package br.usp.each.dci;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.bcel.classfile.ClassFormatException;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.dom4j.Document;
import org.dom4j.Element;

import com.generationjava.io.CsvWriter;

import br.usp.each.inss.RequirementExport;
import br.usp.each.opal.requirement.RequirementType;

public class MethodCallTripleRequirementCoverageExportCSV implements RequirementExport {
	
	private List<MethodCallTripleRequirementCoverage> listRequirements;
	private RequirementType requirementType;
	private HeuristicType heuristicType;
	private File classesDirectory;
	private ListPosition listPosition;
	
	public MethodCallTripleRequirementCoverageExportCSV(List<MethodCallTripleRequirementCoverage> lstRequirements, RequirementType reqType, HeuristicType heurType, File classDir) {
        this.listRequirements = lstRequirements;
        this.requirementType = reqType;
        this.heuristicType = heurType;
        this.classesDirectory = classDir;
        listPosition = new ListPosition();
        listPosition.insertAbsolutePositionMCT(listRequirements);
    }
	
	@Override
	public byte[] export() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		CsvWriter csv = new CsvWriter(new OutputStreamWriter(baos));
		csv.setFieldDelimiter(';');
		csv.setBlockDelimiter('\n');
		
		doHeader(csv);
		doDebugReportCSV(csv);
		doMCTList(csv);
		
		csv.close();
		return baos.toByteArray();
	}
	
	private void doHeader(CsvWriter csv) throws IOException {
		csv.writeField("from-class");
		csv.writeField("from-method-id");
		csv.writeField("from-method");
		csv.writeField("into-class");
		csv.writeField("into-method-id");
		csv.writeField("into-method");
		csv.writeField("to-class");
		csv.writeField("to-method-id");
		csv.writeField("to-method");
		csv.writeField("suspicious");
		csv.writeField("pos-abs-name");
		csv.writeField("score-name");
		csv.writeField("pos-medium");
		csv.writeField("exam-medium");
		csv.writeField("pos-min");
		csv.writeField("exam-min");
		csv.writeField("pos-max");
		csv.writeField("exam-max");
		csv.writeField("count");
		csv.writeField("ini");
		csv.writeField("constructor/get");
		csv.writeField("list");
		
		csv.endBlock();
	}
	
	private void doDebugReportCSV(CsvWriter csv) {
        
		for(MethodCallTripleRequirementCoverage reqCoverage : listRequirements)
    	{
    		try
    		{
	    		getRequirementWithMethodName(reqCoverage);
	    		csv.writeField(reqCoverage.getClassNameCaller());
	    		csv.writeField(String.valueOf(reqCoverage.getMethodIdCaller()));
	    		csv.writeField(reqCoverage.getMethodNameCaller());
	    		csv.writeField(reqCoverage.getClassNameCalledN1());
	    		csv.writeField(String.valueOf(reqCoverage.getMethodIdCalledN1()));
	    		csv.writeField(reqCoverage.getMethodNameCalledN1());
	    		csv.writeField(reqCoverage.getClassNameCalledN2());
	    		csv.writeField(String.valueOf(reqCoverage.getMethodIdCalledN2()));
	    		csv.writeField(reqCoverage.getMethodNameCalledN2());
	    		csv.writeField(String.valueOf(reqCoverage.getSuspicious()));
	    		csv.writeField(String.valueOf(reqCoverage.getAbsolutePosition()));
	    		csv.writeField(String.valueOf((double)reqCoverage.getAbsolutePosition()/listRequirements.size()));
	    		csv.writeField(String.valueOf(listPosition.getMediumPosition(reqCoverage.getSuspicious())));
	    		csv.writeField(String.valueOf(listPosition.getMediumEXAMScore(reqCoverage.getSuspicious(), listRequirements.size())));
	    		csv.writeField(String.valueOf(listPosition.getMinPosition(reqCoverage.getSuspicious())));
	    		csv.writeField(String.valueOf(listPosition.getMinEXAMScore(reqCoverage.getSuspicious(), listRequirements.size())));
	    		csv.writeField(String.valueOf(listPosition.getMaxPosition(reqCoverage.getSuspicious())));
	    		csv.writeField(String.valueOf(listPosition.getMaxEXAMScore(reqCoverage.getSuspicious(), listRequirements.size())));
	    		csv.writeField("count");
	    		csv.writeField("ini");
	    		csv.writeField("constructor/get");
	    		csv.writeField("list");
	    		csv.endBlock();
    		}
    		catch(IOException io)
    		{
    			System.out.println("An error occurs reading class directory.");
    		}
  	    }
    	
    }
	
	private void doMCTList(CsvWriter csv){
		Map<String,Double> mapMCT = listPosition.getMCTMethodList(listRequirements);
		
		try {
			csv.writeField("");
			csv.endBlock();
			csv.writeField("List_of_MCT_methods");
			csv.writeField("suspicious");
			csv.endBlock();
			
			Set<String> setMethod = mapMCT.keySet();
			
			for(String mcpMethodName : setMethod)
			{
				csv.writeField(mcpMethodName);
				csv.writeField(String.valueOf(mapMCT.get(mcpMethodName)));
				csv.endBlock();
			}
			
			csv.writeField("TOTAL_METHODS");
			csv.writeField(String.valueOf(mapMCT.size()));
			
		}
		catch (IOException e) {
			System.out.println("An error occurs creating csv file.");
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
