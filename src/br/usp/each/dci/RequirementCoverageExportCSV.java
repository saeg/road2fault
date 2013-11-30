package br.usp.each.dci;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Hashtable;
import java.util.List;

import org.apache.bcel.classfile.ClassFormatException;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.LineNumberTable;
import org.apache.bcel.classfile.Method;
import org.dom4j.Document;
import org.dom4j.Element;

import com.generationjava.io.CsvWriter;

import br.usp.each.inss.ClassRequirementWrapper;
import br.usp.each.inss.RequirementExport;
import br.usp.each.opal.requirement.RequirementType;

public class RequirementCoverageExportCSV implements RequirementExport {

	private List<RequirementCoverage> listRequirements;
	public Hashtable<String,Hashtable<Integer,List<RequirementCoverage>>> hashClasses;
	public Hashtable <String, List<String>> hashPackage;
	public Hashtable <String, Double> hashPackageSuspicious;
	public Hashtable <String, Integer> hashPackageNumberOfMaxSuspicious;
	private RequirementType requirementType;
	private HeuristicType heuristicType;
	private ListType listType;
	private File classesDirectory;
	private ListPosition listPosition;

	public RequirementCoverageExportCSV(List<RequirementCoverage> lstRequirements, RequirementType reqType, HeuristicType heurType, File classDir, ListType lstType) {
        this.listRequirements = lstRequirements;
        this.requirementType = reqType;
        this.heuristicType = heurType;
        this.listType = lstType;
        this.classesDirectory = classDir;
        listPosition = new ListPosition();
        listPosition.insertAbsolutePosition(listRequirements);
    }
		
	@Override
	public byte[] export() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		CsvWriter csv = new CsvWriter(new OutputStreamWriter(baos));
		csv.setFieldDelimiter(';');
		csv.setBlockDelimiter('\n');
		
		doHeader(csv);
		doDebugReportCSV(csv);
		
		csv.close();
		return baos.toByteArray();
	}
	
	private void doHeader(CsvWriter csv) throws IOException {
		csv.writeField("class");
		csv.writeField("method-id");
		csv.writeField("method");
		csv.writeField(requirementType.toString());
		csv.writeField("location");
		csv.writeField("suspicious");
		csv.writeField("pos-abs-name");
		csv.writeField("score-name");
		csv.writeField("pos-medium");
		csv.writeField("exam-medium");
		csv.writeField("pos-min");
		csv.writeField("exam-min");
		csv.writeField("pos-max");
		csv.writeField("exam-max");
		
		csv.endBlock();
	}
	
	
	private void doDebugReportCSV(CsvWriter csv) throws ClassFormatException, IOException {

		double tempValue = listRequirements.get(0).getSuspicious();

		File f = new File(classesDirectory, listRequirements.get(0).getClassName().replace('.', '/') + ".class");
		JavaClass javaClass = new ClassParser(f.getAbsolutePath()).parse();
		Method method = javaClass.getMethods()[listRequirements.get(0).getMethodId()];
		String signature = formatSignature(method.getSignature());
		LineNumberTable lineTable = method.getLineNumberTable();
		String line = "null";
		if(lineTable != null){
			line = getLineNumber(listRequirements.get(0).getRequirement(),lineTable);
		}
		
		for(int i = 0; i < listRequirements.size(); i++)
    	{
    		f = new File(classesDirectory, listRequirements.get(i).getClassName().replace('.', '/') + ".class");
    		javaClass = new ClassParser(f.getAbsolutePath()).parse();
    		method = javaClass.getMethods()[listRequirements.get(i).getMethodId()];
    		signature = formatSignature(method.getSignature());
    		lineTable = method.getLineNumberTable();
    		line = "null";
    		if(lineTable != null){
    			line = getLineNumber(listRequirements.get(i).getRequirement(),lineTable);
    		}
    		
    		csv.writeField(listRequirements.get(i).getClassName());
    		csv.writeField(String.valueOf(listRequirements.get(i).getMethodId()));
    		csv.writeField(method.getName()+signature);
    		csv.writeField(listRequirements.get(i).getRequirement());
    		csv.writeField(line);
    		csv.writeField(String.valueOf(listRequirements.get(i).getSuspicious()));
    		csv.writeField(String.valueOf(listRequirements.get(i).getAbsolutePosition()));
    		csv.writeField(String.valueOf((double)listRequirements.get(i).getAbsolutePosition()/listRequirements.size()));
    		csv.writeField(String.valueOf(listPosition.getMediumPosition(listRequirements.get(i).getSuspicious())));
    		csv.writeField(String.valueOf(listPosition.getMediumEXAMScore(listRequirements.get(i).getSuspicious(), listRequirements.size())));
    		csv.writeField(String.valueOf(listPosition.getMinPosition(listRequirements.get(i).getSuspicious())));
    		csv.writeField(String.valueOf(listPosition.getMinEXAMScore(listRequirements.get(i).getSuspicious(), listRequirements.size())));
    		csv.writeField(String.valueOf(listPosition.getMaxPosition(listRequirements.get(i).getSuspicious())));
    		csv.writeField(String.valueOf(listPosition.getMaxEXAMScore(listRequirements.get(i).getSuspicious(), listRequirements.size())));
    		csv.endBlock();
    	}

    }


	//Get the line number of the block for nodes, edges and duas considering the initial line of the block
	public String getLineNumber(String requirement,LineNumberTable lineTable)
	{
		String line = "";
		if(this.requirementType == RequirementType.NODE){
			line = String.valueOf(lineTable.getSourceLine(Integer.valueOf(requirement)));
		}
		else if(this.requirementType == RequirementType.EDGE)
		{
			line = String.valueOf(lineTable.getSourceLine(Integer.valueOf(requirement.substring(0,requirement.indexOf(",")))));
			line = line + " - " + String.valueOf(lineTable.getSourceLine(Integer.valueOf(requirement.substring(requirement.indexOf(",")+1,requirement.length()))));
			
		}
		else if(this.requirementType == RequirementType.DUA)
		{
			line = String.valueOf(lineTable.getSourceLine(Integer.valueOf(requirement.substring(0,requirement.indexOf(",")))))+", ";
			if(requirement.contains("(")){
				String lineTemp = requirement.substring(requirement.indexOf("(")+1,requirement.indexOf(")"));
				line = line + String.valueOf(lineTable.getSourceLine(Integer.valueOf(lineTemp.substring(0,lineTemp.indexOf(",")))));
				line = line + " - " + String.valueOf(lineTable.getSourceLine(Integer.valueOf(lineTemp.substring(lineTemp.indexOf(",")+1,lineTemp.length()))));
			}
			else{
				String lineTemp = requirement.substring(requirement.indexOf(",")+1,requirement.length());
				line = line + String.valueOf(lineTable.getSourceLine(Integer.valueOf(lineTemp.substring(0,lineTemp.indexOf(",")))));
			}
		}
		return line;
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
    
    //Approximates a value to the line method. Considers that a line of the method is above the first line of code  
    public String getLineMethodLocation(int sourceLine)
    {
    	String line = "0";
    	if(sourceLine > 0)
    	{
    		sourceLine--;
    		line = String.valueOf(sourceLine);
       	}
    	return line;
    }
	
}
