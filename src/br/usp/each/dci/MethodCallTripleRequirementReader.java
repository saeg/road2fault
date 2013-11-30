package br.usp.each.dci;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import br.usp.each.commons.logger.Log;
import br.usp.each.inss.cache.MethodCallTripleRequirements;
import br.usp.each.opal.requirement.MethodCallTriple;
import br.usp.each.opal.requirement.RequirementType;

public class MethodCallTripleRequirementReader {

	private static final Log log = new Log(MethodCallTripleRequirementReader.class);
    private static final Options options;
    private static final HelpFormatter formatter;
    
    private static List<MethodCallTripleRequirementCoverage> listMethodCallRequirement = new ArrayList<MethodCallTripleRequirementCoverage>();
	
    //private 
    public static List<MethodCallTripleRequirementCoverage> listRequirementsBySuspiciousness;

    //private 
    public static int totalTestCases = 0;
    //private 
    public static int actualTestCase = 0;
		
    //private 
    public static boolean []failedTestCases;
	
    //private 
    public static RequirementType requirementType;
	
    //private
    public static HeuristicType heuristicType;
	
    //private
    public static ListType listType;
    
    private static final ParseException INVALID_FILE_EXCEPTION = new ParseException("read <file> may be a valid file.");

    //private
    public static File classesDirectory;
	
	public MethodCallTripleRequirementReader(){
	}
		
	static {
        @SuppressWarnings("static-access")
        Option path = OptionBuilder.withArgName("file")
        						   .withLongOpt("read")
        						   .hasArg()
        						   .withDescription("requirement file to read")
        						   .isRequired()
        						   .create("r");

        @SuppressWarnings("static-access")
        Option classDir = OptionBuilder.withArgName("class")
        						 .withLongOpt("class-dir")
        						 .hasArg()
        						 .withDescription("dir with original classes")
        						 .create("c");
        
        @SuppressWarnings("static-access")
        Option reqType = OptionBuilder.withArgName("reqtype")
        						 .withLongOpt("requirement-type")
        						 .hasArg()
        						 .withDescription("indicate the type of requirement")
        						 .create("rt");
        
        @SuppressWarnings("static-access")
        Option heuristicType = OptionBuilder.withArgName("heuristictype")
        						 .withLongOpt("heuristic-type")
        						 .hasArg()
        						 .withDescription("indicate the type of heuristic to be used")
        						 .create("hr");
        
        @SuppressWarnings("static-access")
        Option listType = OptionBuilder.withArgName("listtype")
        						 .withLongOpt("list-type")
        						 .hasArg()
        						 .withDescription("type of list returned")
        						 .create("lt");
        
        options = new Options();
        options.addOption(path);
        options.addOption(classDir);
        options.addOption(reqType);
        options.addOption(heuristicType);
        options.addOption(listType);
        formatter = new HelpFormatter();
    }

	public static void main(String[] args) throws IOException {
        
    	// create the parser
        CommandLineParser parser = new GnuParser();
    	try {
            CommandLine line = parser.parse(options, args);
            
            requirementType = selectRequirementType(line.getOptionValue("requirement-type"));
            heuristicType = selectHeuristicType(line.getOptionValue("heuristic-type"));
            listType = selectListType(line.getOptionValue("list-type"));
            
            try {
            	
            	classesDirectory = new File(line.getOptionValue("class-dir"));
            	
                //////////////READ FOLDER////////////////////
                File file = new File(line.getOptionValue("read"));
                
                if (file.isDirectory()) {
    				File[] files = file.listFiles();
    				List<File> listFile  = new ArrayList<File>();
    				
    				for(int i = 0; i < files.length; i++){
    					listFile.add(files[i]);
    				}
    				Collections.sort(listFile);
    				
    				totalTestCases = listFile.size();
        			
    				failedTestCases = new boolean[totalTestCases];
    				    				
    				if (listFile.size() > 0){
    					System.out.println("Coverage files:");
		                for (File actualFile : listFile) {
		                    
		                	if (actualFile.isFile()) {
		                		MethodCallTripleRequirementWrapper wrapper = new MethodCallTripleRequirementWrapper();
		                        FileInputStream fileIn = new FileInputStream(actualFile);
		                        ObjectInputStream in = new ObjectInputStream(fileIn);
		                        MethodCallTripleRequirements requirements = (MethodCallTripleRequirements) in.readObject();
		                        if(requirements.isFailed())
		                        {
		                        	updateFailedTestCases();
		                        }
		                        MethodCallTripleRequirementWrapper.load(requirements, wrapper);
		                        
		                        System.out.println("--> " + actualFile.getName());
		                        
		                        //insert in matrix
		                        createCoverageMatrix(wrapper);
		                        actualTestCase++;
		                        
		                    } else {
		                        throw INVALID_FILE_EXCEPTION;
		                    }
		                }
    				}
    			}
    			    
                //read the matrix to calculate the suspiciousness
                calculateSuspiciousness();
                
                //classify the requirements in matrix
                classifyRequirementsBySuspiciousness();
                
                Collections.sort(listMethodCallRequirement);
                
                exportListRequirements();
                
                //printAllRequirements();
                
                System.out.println("End");
                
            } 
            catch (ClassNotFoundException e) {
                throw INVALID_FILE_EXCEPTION;
            }
        } catch (ParseException exp) {
            log.info("Failed!  Reason: " + exp.getMessage());
            formatter.printHelp("Requirement", options);
        }
    }
	
	
	public static void exportListRequirements()
	{
		 	try {
		 			byte[] contents;
		 			if(listType == ListType.CSV){
		 	        	contents = new MethodCallTripleRequirementCoverageExportCSV(listMethodCallRequirement,requirementType,heuristicType,classesDirectory).export();
		 	        }else{
		 	        	contents = new MethodCallTripleRequirementCoverageExport(listMethodCallRequirement,requirementType,heuristicType,classesDirectory).export();
		 	        }
		            OutputStream os = new FileOutputStream(new File("list_dci_" + "MCT" + "_" + heuristicType + (listType == ListType.CSV ? ".csv" : ".xml-debug")));
		            os.write(contents);
		            os.close();
		 	} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	//a method can be any requirements 
	public static void createCoverageMatrix(MethodCallTripleRequirementWrapper wrap)
	{
		//System.out.println("Enter in createcoveragematrix");
		//store the updated and new keys until update the classes that aren't present in the coverage file 
    	List<MethodCallTripleRequirementCoverage> listMethodCallRequirementTemp = new ArrayList<MethodCallTripleRequirementCoverage>();
    	
   	  	for(MethodCallTriple methodCallTriple : wrap.getRequirements())
    	{	
   	  		//System.out.println("Enter in in for");
   	  		//update new coverage of requirements
    		if(!listMethodCallRequirement.isEmpty() && exists(methodCallTriple)){
   	  		
    			//System.out.println("Enter in in if");
				
    			MethodCallTripleRequirementCoverage reqCoverage = getReqCoverage(methodCallTriple);
    			int countCoeficient = 0;
    			
    			if(failedTestCases[actualTestCase])
				{
					countCoeficient = reqCoverage.getC_e_f();
    				reqCoverage.setC_e_f(countCoeficient+1); 
				}
				else
				{
					countCoeficient = reqCoverage.getC_e_p();
    				reqCoverage.setC_e_p(countCoeficient+1); 
				}
				reqCoverage.setCoverage(actualTestCase, true);
	    		
    			listMethodCallRequirementTemp.add(reqCoverage);
    			listMethodCallRequirement.remove(reqCoverage);
    		}
			else //create new requirements
			{
				MethodCallTripleRequirementCoverage reqCoverage = new MethodCallTripleRequirementCoverage(totalTestCases);
				//System.out.println("Enter in in else");
				
				if(failedTestCases[actualTestCase]){
    				reqCoverage.setC_e_f(1);
				}
				else{
					reqCoverage.setC_e_p(1);
				}
				reqCoverage.setCoverage(actualTestCase, true);
				
				reqCoverage.setClassNameCaller(methodCallTriple.getClassCaller());
				reqCoverage.setMethodIdCaller(methodCallTriple.getIdMethodCaller());
				reqCoverage.setClassNameCalledN1(methodCallTriple.getClassCalledN1());
				reqCoverage.setMethodIdCalledN1(methodCallTriple.getIdMethodCalledN1());
				reqCoverage.setClassNameCalledN2(methodCallTriple.getClassCalledN2());
				reqCoverage.setMethodIdCalledN2(methodCallTriple.getIdMethodCalledN2());
				
				updatePreviousTestCases(reqCoverage);
				
				listMethodCallRequirementTemp.add(reqCoverage);
				
			}
    		
    	}
   	  	updateRemainingRequirements();
   	  	listMethodCallRequirement.addAll(listMethodCallRequirementTemp);
    	
		//printHashClasses();
	}
	
	
	//private 
    public static void updatePreviousTestCases(MethodCallTripleRequirementCoverage reqCoverage)
	{
		
		if(actualTestCase > 0){
			
			for(int i = 0; i < actualTestCase; i++){
				
				int countCoeficient = 0;
				
				if(failedTestCases[i]){
					countCoeficient = reqCoverage.getC_n_f();
					reqCoverage.setC_n_f(countCoeficient+1); 
				}
				else{
					countCoeficient = reqCoverage.getC_n_p();
					reqCoverage.setC_n_p(countCoeficient+1); 
				}
				reqCoverage.setCoverage(i, false);
			}
		}
	}
	
    
    //set coverage and coefficient values for classes, his methods and requirements that are not executed by actual test case.
	//private 
    public static void updateRemainingRequirements()
	{
		for(MethodCallTripleRequirementCoverage reqCoverage : listMethodCallRequirement)
		{
			int countCoeficient = 0;
			
			if(failedTestCases[actualTestCase]){
				countCoeficient = reqCoverage.getC_n_f();
    			reqCoverage.setC_n_f(countCoeficient+1); 
			}
			else{
				countCoeficient = reqCoverage.getC_n_p();
    			reqCoverage.setC_n_p(countCoeficient+1); 
			}
			reqCoverage.setCoverage(actualTestCase, false);
		}
	}
    
    //private
    public static boolean exists(MethodCallTriple mct)
    {
    	for(MethodCallTripleRequirementCoverage m : listMethodCallRequirement)
    	{
    		if(mct.getClassCaller().contains(m.getClassNameCaller()) && mct.getClassCalledN1().contains(m.getClassNameCalledN1()) 
    				&& mct.getClassCalledN2().contains(m.getClassNameCalledN2()) && mct.getIdMethodCaller() == m.getMethodIdCaller() 
    				&& mct.getIdMethodCalledN1() == m.getMethodIdCalledN1() && mct.getIdMethodCalledN2() == m.getMethodIdCalledN2()){
    			return true;
    		}
    	}
    	return false;
    }
    
  //private
    public static MethodCallTripleRequirementCoverage getReqCoverage(MethodCallTriple mct)
    {
    	for(MethodCallTripleRequirementCoverage m : listMethodCallRequirement)
    	{
    		if(mct.getClassCaller().contains(m.getClassNameCaller()) && mct.getClassCalledN1().contains(m.getClassNameCalledN1()) 
    				&& mct.getClassCalledN2().contains(m.getClassNameCalledN2()) && mct.getIdMethodCaller() == m.getMethodIdCaller() 
    				&& mct.getIdMethodCalledN1() == m.getMethodIdCalledN1() && mct.getIdMethodCalledN2() == m.getMethodIdCalledN2()){
    			return m;
    		}
    	}
    	return null;
    }
    
	//private 
    public static String getStringRequirement(String requirement)
	{
		String req = "";
		int coda = 0;
		
		if(!requirement.isEmpty() && requirement.contains(",")){
			coda = requirement.lastIndexOf(",");
			req = requirement.substring(1, coda);
		}
		return req;
	}
	
	public static void updateFailedTestCases()
	{
		failedTestCases[actualTestCase] = true;
	}
	
	//private 
    public static RequirementType selectRequirementType(String reqType)
	{
		RequirementType type = null;
		if(reqType.equals("node")){
			type = RequirementType.NODE;
		}
		if(reqType.equals("edge")){
			type = RequirementType.EDGE;
		}
		if(reqType.equals("dua")){
			type = RequirementType.DUA;
		}
		if(reqType.equals("mcp")){
			type = RequirementType.METHODCALLPAIR;
		}
		if(reqType.equals("mct")){
			type = RequirementType.METHODCALLTRIPLE;
		}
		return type;
	}
	
	//private 
    public static HeuristicType selectHeuristicType(String heuristicType)
	{
    	HeuristicType type = null;
		
    	if(heuristicType.equals("tarantula")){
			type = HeuristicType.TARANTULA;
		}
		if(heuristicType.equals("drt")){
			type = HeuristicType.DRT;
		}
		if(heuristicType.equals("ochiai")){
			type = HeuristicType.OCHIAI;
		}
		if(heuristicType.equals("jaccard")){
			type = HeuristicType.JACCARD;
		}
		if(heuristicType.equals("zoltar")){
			type = HeuristicType.ZOLTAR;
		}
		if(heuristicType.equals("op")){
			type = HeuristicType.OP;
		}
		if(heuristicType.equals("minus")){
			type = HeuristicType.MINUS;
		}
		if(heuristicType.equals("kulczynski2")){
			type = HeuristicType.KULCZYNSKI2;
		}
		if(heuristicType.equals("mccon")){
			type = HeuristicType.MCCON;
		}
		if(heuristicType.equals("wong3")){
			type = HeuristicType.WONG3;
		}
		return type;
	}
	
    //private 
    public static ListType selectListType(String listType)
	{
		ListType type = null;
		if(listType.equals("requirement")){
			type = ListType.REQUIREMENT;
		}
		if(listType.equals("class")){
			type = ListType.CLASS;
		}
		if(listType.equals("package")){
			type = ListType.PACKAGE;
		}
		if(listType.equals("csv")){
			type = ListType.CSV;
		}
		return type;
	}
    
    //private
    public static void calculateSuspiciousness()
    {
    	Heuristic heuristic = new Heuristic();
		
		switch(heuristicType)
		{
		case DRT:
			for(MethodCallTripleRequirementCoverage reqCoverage : listMethodCallRequirement)
			{
				reqCoverage.setSuspicious(heuristic.calculateDRT(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
			}
			break;
		case OCHIAI:
			for(MethodCallTripleRequirementCoverage reqCoverage : listMethodCallRequirement)
			{
				reqCoverage.setSuspicious(heuristic.calculateOchiai(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
			}
			break;
		case JACCARD:
			for(MethodCallTripleRequirementCoverage reqCoverage : listMethodCallRequirement)
			{
				reqCoverage.setSuspicious(heuristic.calculateJaccard(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
			}
			break;
		case ZOLTAR:
			for(MethodCallTripleRequirementCoverage reqCoverage : listMethodCallRequirement)
			{
				reqCoverage.setSuspicious(heuristic.calculateZoltar(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
			}
			break;
		case OP:
			for(MethodCallTripleRequirementCoverage reqCoverage : listMethodCallRequirement)
			{
				reqCoverage.setSuspicious(heuristic.calculateOp(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
			}
			break;
		case MINUS:
			for(MethodCallTripleRequirementCoverage reqCoverage : listMethodCallRequirement)
			{
				reqCoverage.setSuspicious(heuristic.calculateMinus(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
			}
			break;
		case KULCZYNSKI2:
			for(MethodCallTripleRequirementCoverage reqCoverage : listMethodCallRequirement)
			{
				reqCoverage.setSuspicious(heuristic.calculateKulczynski2(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
			}
			break;
		case MCCON:
			for(MethodCallTripleRequirementCoverage reqCoverage : listMethodCallRequirement)
			{
				reqCoverage.setSuspicious(heuristic.calculateMcCon(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
			}
			break;
		case WONG3:
			for(MethodCallTripleRequirementCoverage reqCoverage : listMethodCallRequirement)
			{
				reqCoverage.setSuspicious(heuristic.calculateWong3(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
			}
			break;
		default:
			for(MethodCallTripleRequirementCoverage reqCoverage : listMethodCallRequirement)
			{
				reqCoverage.setSuspicious(heuristic.calculateTarantula(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
			}
			break;
		}
    }
    
    
  //private
    public static void classifyRequirementsBySuspiciousness(){
    	
    	listRequirementsBySuspiciousness = new ArrayList<MethodCallTripleRequirementCoverage>();
    	
    	for(MethodCallTripleRequirementCoverage reqCoverage : listMethodCallRequirement)
		{
    		listRequirementsBySuspiciousness.add(reqCoverage);
		}
		Collections.sort(listRequirementsBySuspiciousness);
    }
    
    
    public static void printAllRequirements()
	{
		for(MethodCallTripleRequirementCoverage reqCoverage : listMethodCallRequirement)
		{
			System.out.println(reqCoverage.getMethodIdCaller() + "," + reqCoverage.getClassNameCaller() + "," + 
								reqCoverage.getMethodIdCalledN1() + "," +	reqCoverage.getClassNameCalledN1() + "," + 
								reqCoverage.getMethodIdCalledN2() + "," +	reqCoverage.getClassNameCalledN2() + " = " +
								reqCoverage.getC_e_f() + ", " + reqCoverage.getC_e_p() + ", " +	reqCoverage.getC_n_f() + ", " + 
								reqCoverage.getC_n_p() + " = " + reqCoverage.getSuspicious());
		}
	}
    
	
}

