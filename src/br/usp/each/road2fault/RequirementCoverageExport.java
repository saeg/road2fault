package br.usp.each.road2fault;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.ClassFormatException;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.LineNumber;
import org.apache.bcel.classfile.LineNumberTable;
import org.apache.bcel.classfile.Method;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import br.usp.each.inss.RequirementExport;
import br.usp.each.opal.requirement.RequirementType;

public class RequirementCoverageExport implements RequirementExport {

	private List<RequirementCoverage> listRequirements;
	public Hashtable<String,Hashtable<Integer,List<RequirementCoverage>>> hashClasses;
	public Hashtable <String, List<String>> hashPackage;
	public Hashtable <String, Double> hashPackageSuspicious;
	public Hashtable <String, Integer> hashPackageNumberOfMaxSuspicious;
	private RequirementType requirementType;
	private HeuristicType heuristicType;
	private ListType listType;
	private File classesDirectory;


	public RequirementCoverageExport(List<RequirementCoverage> lstRequirements, RequirementType reqType, HeuristicType heurType, File classDir, ListType lstType) {
        this.listRequirements = lstRequirements;
        this.requirementType = reqType;
        this.heuristicType = heurType;
        this.listType = lstType;
        this.classesDirectory = classDir;
    }

	public RequirementCoverageExport(Hashtable<String,Hashtable<Integer,List<RequirementCoverage>>> hshClasses, RequirementType reqType, HeuristicType heurType, File classDir, ListType lstType) {
        this.hashClasses = hshClasses;
        this.requirementType = reqType;
        this.heuristicType = heurType;
        this.listType = lstType;
        this.classesDirectory = classDir;
    }

	public RequirementCoverageExport(Hashtable<String,Hashtable<Integer,List<RequirementCoverage>>> hshClasses, Hashtable <String, List<String>> hshPackage, Hashtable <String, Double> hshPackageSuspicious, Hashtable <String, Integer> hshPackageNumberOfMaxSuspicious, RequirementType reqType, HeuristicType heurType, File classDir, ListType lstType) {
        this.hashClasses = hshClasses;
        this.hashPackage = hshPackage;
        this.hashPackageSuspicious = hshPackageSuspicious;
        this.hashPackageNumberOfMaxSuspicious = hshPackageNumberOfMaxSuspicious;
        this.requirementType = reqType;
        this.heuristicType = heurType;
        this.listType = lstType;
        this.classesDirectory = classDir;
    }


	@Override
	public byte[] export() throws IOException {

        Document doc = DocumentHelper.createDocument();
        doc.setXMLEncoding("ISO-8859-1");
        doc.addElement("FaultClassification");
        
        if(listType == ListType.PACKAGE){
        	doDebugReportByPackage(doc);
        }else if(listType == ListType.CLASS){
        	doDebugReportByClass(doc);
        }else{
        	doDebugReport(doc);
        }


        return doc.asXML().getBytes();
	}

		
	private void doDebugReport(Document doc) throws ClassFormatException, IOException {

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
		
    	Element element = doc.getRootElement();
    	element.addAttribute("project", "fault localization");
    	Element elem = element.addElement("test-criteria").addAttribute("requirement-type", requirementType.name())
    														.addAttribute("heuristic-type", heuristicType.name())
    														.addAttribute("suspicious-value", String.valueOf(tempValue));
    	elem.addElement("requirement").addAttribute("class", listRequirements.get(0).getClassName())
    									.addAttribute("method-id", String.valueOf(listRequirements.get(0).getMethodId()))
    									.addAttribute("method", method.getName()+signature)
    									.addAttribute("requirement", listRequirements.get(0).getRequirement())
    									.addAttribute("location", line)
    									.addAttribute("suspicious",String.valueOf(listRequirements.get(0).getSuspicious()));
    	for(int i = 1; i < listRequirements.size(); i++)
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
    		
    		//if suspicious values is different, create a new element for show this suspicious value
    		if(listRequirements.get(i).getSuspicious() < tempValue){
    			elem = element.addElement("test-criteria").addAttribute("requirement-type", requirementType.name())
	    												  .addAttribute("suspicious-value", String.valueOf(listRequirements.get(i).getSuspicious()));
	    		tempValue = listRequirements.get(i).getSuspicious();
    		}
    		elem.addElement("requirement").addAttribute("class", listRequirements.get(i).getClassName())
										  .addAttribute("method-id", String.valueOf(listRequirements.get(i).getMethodId()))
    									  .addAttribute("method", method.getName()+signature)
    									  .addAttribute("requirement", listRequirements.get(i).getRequirement())
    									  .addAttribute("location", line)
    									  .addAttribute("suspicious",String.valueOf(listRequirements.get(i).getSuspicious()));
	    }

    }

	private void doDebugReportByClass(Document doc)
	{
		Set<String> setClass = hashClasses.keySet();
		Iterator<String> itClass = setClass.iterator();

		Element element = doc.getRootElement();
    	element.addAttribute("project", "fault localization");
    	Element elem = element.addElement("test-criteria").addAttribute("requirement-type", requirementType.name())
    														.addAttribute("heuristic-type", heuristicType.name())
    														.addAttribute("suspicious-value", String.valueOf("0"));

		while(itClass.hasNext())
		{
			String classKey = itClass.next();

			Hashtable<Integer,List<RequirementCoverage>> hashMethods = hashClasses.get(classKey);
			Set<Integer> setMethod = hashMethods.keySet();
			Iterator<Integer> itMethod = setMethod.iterator();

			Element el = elem.addElement("class").addAttribute("name", classKey)
												 .addAttribute("suspicious-value", String.valueOf("0"));

			while(itMethod.hasNext())
			{
				Integer methodKey = itMethod.next();

				List<RequirementCoverage> listCov = hashMethods.get(methodKey);
				Collections.sort(listCov);

				Element e = el.addElement("method").addAttribute("id", String.valueOf(methodKey))
												   .addAttribute("suspicious-value", String.valueOf("0"));

				for(RequirementCoverage reqCoverage : listCov)
				{
					e.addElement("requirement").addAttribute("name", reqCoverage.getRequirement())
											   .addAttribute("suspicious-value", String.valueOf(reqCoverage.getSuspicious()));
				}
			}

		}

	}

	private void doDebugReportByPackage(Document doc) throws ClassFormatException, IOException
	{
		Set<String> setPackage = hashPackage.keySet();
		Iterator<String> itPackage = setPackage.iterator();

		Element element = doc.getRootElement();
    	element.addAttribute("project", "fault localization");
    	Element elem = element.addElement("test-criteria").addAttribute("requirement-type", requirementType.name())
    														.addAttribute("heuristic-type", heuristicType.name());

    	while(itPackage.hasNext())
    	{
    		String packName = itPackage.next();
    		List<String> lstClasses = hashPackage.get(packName);
    		double packageSuspiciousValue = hashPackageSuspicious.get(packName);
    		int packageNumberOfMaxSuspiciousValues = hashPackageNumberOfMaxSuspicious.get(packName);

    		Element elPack = elem.addElement("package").addAttribute("name", packName)
			 										   .addAttribute("suspicious-value", String.valueOf(packageSuspiciousValue))
    												   .addAttribute("number", String.valueOf(packageNumberOfMaxSuspiciousValues));

    		for(String classKey : lstClasses)
    		{

    			File f = new File(classesDirectory, classKey.replace('.', '/') + ".class");
    			//System.out.println(f);
    			JavaClass javaClass = new ClassParser(f.getAbsolutePath()).parse();
    			//System.out.println("pass:"+javaClass.getClassName()+", class name index:"+javaClass.getClassNameIndex());//HIGOR
    			
    			Hashtable<Integer,List<RequirementCoverage>> hashMethods = hashClasses.get(classKey);
    			Set<Integer> setMethod = hashMethods.keySet();
    			Iterator<Integer> itMethod = setMethod.iterator();
    			double classSuspiciousValue = calculateMaxSuspiciousnessByClass(classKey);
    			int classNumberOfMaxSuspiciousValue = calculateNumberOfMaxSuspiciousnessByClass(classKey);

    			Element el = elPack.addElement("class").addAttribute("name", classKey)
    												   .addAttribute("location", String.valueOf(javaClass.getClassNameIndex()))
    												   .addAttribute("suspicious-value", String.valueOf(classSuspiciousValue))
    												   .addAttribute("number", String.valueOf(classNumberOfMaxSuspiciousValue));

    			while(itMethod.hasNext())
    			{
    				Integer methodKey = itMethod.next();
    				Method method = javaClass.getMethods()[methodKey];
    				String signature = formatSignature(method.getSignature());
    				LineNumberTable lineTable = method.getLineNumberTable();

    				List<RequirementCoverage> listCov = hashMethods.get(methodKey);
    				Collections.sort(listCov);
    				double methodSuspiciousValue = calculateMaxSuspiciousnessByMethod(classKey,methodKey);
    				int methodNumberOfMaxSuspiciousValue = calculateMaxNumberOfSuspiciousnessByMethod(classKey,methodKey);

    				Element e = el.addElement("method").addAttribute("id", String.valueOf(methodKey))
					   								   .addAttribute("name", method.getName()+signature)
    												   .addAttribute("location", lineTable != null && lineTable.getLength() > 0 ? getLineMethodLocation(lineTable.getSourceLine(0)) : "1")
    												   .addAttribute("suspicious-value", String.valueOf(methodSuspiciousValue))
    												   .addAttribute("number", String.valueOf(methodNumberOfMaxSuspiciousValue));

    				for(RequirementCoverage reqCoverage : listCov)
    				{
    					String line = "1";//putting location = 1 if does not have lineTable to enable CodeForest (for node)
    					if(lineTable != null){
    						line = getLineNumber(reqCoverage.getRequirement(),lineTable);
    					}
    					e.addElement("requirement").addAttribute("name", reqCoverage.getRequirement())
						   						   .addAttribute("location", line)
    											   .addAttribute("suspicious-value", String.valueOf(reqCoverage.getSuspicious()));
    				}
    			}
    		}
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

	//////////////////////METHODS FROM REQUIREMENTEXPORTHEURISTIC

	//Add a value of suspiciousness for classes based on its requirements values
    public double calculateMaxSuspiciousnessByClass(String classKey){

    	double suspiciousClassValue = 0;

    	Hashtable<Integer,List<RequirementCoverage>> hashMethods = hashClasses.get(classKey);
		Set<Integer> setMethod = hashMethods.keySet();
		Iterator<Integer> itMethod = setMethod.iterator();

		while(itMethod.hasNext())
		{
			Integer methodKey = itMethod.next();
			List<RequirementCoverage> listCovRequirements = hashMethods.get(methodKey);

			Collections.sort(listCovRequirements);
			if(!listCovRequirements.isEmpty())
			if(suspiciousClassValue < listCovRequirements.get(0).getSuspicious())
			{
				suspiciousClassValue = listCovRequirements.get(0).getSuspicious();
			}
		}

		return suspiciousClassValue;
	}

    //Add the amount of requirements with the maximum suspiciousness values for classes based on its requirements values
    public int calculateNumberOfMaxSuspiciousnessByClass(String classKey){

    	double suspiciousClassValue = 0;
    	int countMaxSuspiciousness = 0;

    	Hashtable<Integer,List<RequirementCoverage>> hashMethods = hashClasses.get(classKey);
		Set<Integer> setMethod = hashMethods.keySet();
		Iterator<Integer> itMethod = setMethod.iterator();

		while(itMethod.hasNext())
		{
			Integer methodKey = itMethod.next();
			List<RequirementCoverage> listCovRequirements = hashMethods.get(methodKey);

			Collections.sort(listCovRequirements);

			if(!listCovRequirements.isEmpty())
			if(suspiciousClassValue < listCovRequirements.get(0).getSuspicious())
			{
				suspiciousClassValue = listCovRequirements.get(0).getSuspicious();
				countMaxSuspiciousness = 0;
			}

			for(RequirementCoverage reqCoverage : listCovRequirements)
			{
				if(suspiciousClassValue == reqCoverage.getSuspicious())
				{
					countMaxSuspiciousness++;
				}
				if(suspiciousClassValue > reqCoverage.getSuspicious())
				{
					break;
				}
			}
		}
		return countMaxSuspiciousness;
    }


  //Add a value of suspiciousness for methods based on its requirements values
    public double calculateMaxSuspiciousnessByMethod(String classKey, int methodKey){

    	double suspiciousMethodValue = 0;

    	Hashtable<Integer,List<RequirementCoverage>> hashMethod = hashClasses.get(classKey);
    	List<RequirementCoverage> listCovRequirements = hashMethod.get(methodKey);
    	Collections.sort(listCovRequirements);

    	if(!listCovRequirements.isEmpty()){
    		suspiciousMethodValue = listCovRequirements.get(0).getSuspicious();
		}

		return suspiciousMethodValue;
	}

  //Add a value of suspiciousness for methods based on its requirements values
    public int calculateMaxNumberOfSuspiciousnessByMethod(String classKey, int methodKey){

    	double suspiciousMethodValue = 0;
    	int countMaxSuspiciousness = 0;

    	Hashtable<Integer,List<RequirementCoverage>> hashMethod = hashClasses.get(classKey);
    	List<RequirementCoverage> listCovRequirements = hashMethod.get(methodKey);
    	Collections.sort(listCovRequirements);

    	if(!listCovRequirements.isEmpty()){
    		suspiciousMethodValue = listCovRequirements.get(0).getSuspicious();
		}

    	for(RequirementCoverage reqCoverage : listCovRequirements)
		{
			if(suspiciousMethodValue == reqCoverage.getSuspicious())
			{
				countMaxSuspiciousness++;
			}
			if(suspiciousMethodValue > reqCoverage.getSuspicious())
			{
				break;
			}
		}

    	return countMaxSuspiciousness;
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
