package br.usp.each.dci;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.GnuParser;

import br.usp.each.commons.logger.Log;
import br.usp.each.inss.ClassRequirementWrapper;
import br.usp.each.inss.MethodRequirementWrapper;
import br.usp.each.inss.RequirementReader;
import br.usp.each.inss.RequirementWrapper;
import br.usp.each.inss.cache.Requirements;
import br.usp.each.opal.requirement.Requirement;
import br.usp.each.opal.requirement.RequirementType;

public class RequirementCoverageReader {
	
	private static final Log log = new Log(RequirementReader.class);
    private static final Options options;
    private static final HelpFormatter formatter;
    
    //private 
    public static List<RequirementCoverage> listRequirementsBySuspiciousness;

    //private 
    public static Hashtable<String,Hashtable<Integer,List<RequirementCoverage>>> hashClasses = new Hashtable<String,Hashtable<Integer,List<RequirementCoverage>>>();
    
    public static Hashtable <String, List<String>> hashPackage = new Hashtable <String, List<String>>();
    
    public static Hashtable <String, Double> hashPackageSuspicious = new Hashtable <String, Double>();
    
    public static Hashtable <String, Integer> hashPackageNumberOfMaxSuspicious = new Hashtable <String, Integer>();
    
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
        
    //private
    public static File classesDirectory;
	    
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
    private static final ParseException INVALID_FILE_EXCEPTION = new ParseException("read <file> may be a valid file.");

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
		                		RequirementWrapper wrapper = new RequirementWrapper();
		                        FileInputStream fileIn = new FileInputStream(actualFile);
		                        ObjectInputStream in = new ObjectInputStream(fileIn);
		                        Requirements requirements = (Requirements) in.readObject();
		                        if(requirements.isFailed())
		                        {
		                        	updateFailedTestCases();
		                        }
		                        RequirementWrapper.load(requirements, wrapper);
		                        
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
                
                //classify other software components
                fillPackages();
                //printPackages();
                fillPackageSuspicious();
                
                //classify the requirements in matrix
                classifyRequirementsBySuspiciousness();
                
                exportListRequirements();
                
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
		 			if(listType == ListType.PACKAGE){
		 				contents = new RequirementCoverageExport(hashClasses,hashPackage,hashPackageSuspicious,hashPackageNumberOfMaxSuspicious,requirementType,heuristicType,classesDirectory,listType).export();
			        }else if(listType == ListType.CLASS){
		 	        	contents = new RequirementCoverageExport(hashClasses,requirementType,heuristicType,classesDirectory,listType).export();
		 	        }else if(listType == ListType.CSV){
		 	        	contents = new RequirementCoverageExportCSV(listRequirementsBySuspiciousness,requirementType,heuristicType,classesDirectory,listType).export();
		 	        }else{
		 	        	contents = new RequirementCoverageExport(listRequirementsBySuspiciousness,requirementType,heuristicType,classesDirectory,listType).export();
		 	        }
			 		OutputStream os = new FileOutputStream(new File("list_dci_" + requirementType + "_" + heuristicType + "_BY_" + listType + (listType == ListType.CSV ? ".csv" : ".xml-debug")));
		            os.write(contents);
		            os.close();
		 	} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	//a method can be any requirements 
	public static void createCoverageMatrix(RequirementWrapper wrap)
	{
		//store the updated and new keys until update the classes that aren't present in the coverage file 
    	Hashtable<String,Hashtable<Integer,List<RequirementCoverage>>> hashClassesTemp = new Hashtable<String,Hashtable<Integer,List<RequirementCoverage>>>();
        
   	  	for(ClassRequirementWrapper classRequirementWrapper : wrap.getClasses())
    	{	
    		//update the class with new coverage of requirements
    		if(!hashClasses.isEmpty() && hashClasses.containsKey(classRequirementWrapper.getClassName())){
    			
    			Hashtable<Integer,List<RequirementCoverage>> hshMethodRequirements = hashClasses.get(classRequirementWrapper.getClassName());
    			List<Integer> listUpdatedMethods = new ArrayList<Integer>(); //store id of method updated below
				    			
    			for(MethodRequirementWrapper methodRequirementWrapper : classRequirementWrapper.getMethods())
	        	{
    				listUpdatedMethods.add(methodRequirementWrapper.getMethodId());
	    			
    				if(hshMethodRequirements.containsKey(methodRequirementWrapper.getMethodId())){ //if method exists
    				
	    				List<RequirementCoverage> listCovRequirements = hshMethodRequirements.get(methodRequirementWrapper.getMethodId()); //former list
				    	List<RequirementCoverage> listUpdatedCovRequirements = new ArrayList<RequirementCoverage>(); //updated list
				    	List<Requirement> lstRequirement = methodRequirementWrapper.getRequirements(requirementType); //actual list
	    				
	    				if(!lstRequirement.isEmpty()){
	    					if(listCovRequirements != null){ // update equal requirements, create new requirements and update previous requirement not actually present 
	    						
	    						List<RequirementCoverage> listRemainingCovRequirements = listCovRequirements; //store uncovered requirements
	    						    						
	    						for(Requirement requirement : lstRequirement)
	    						{
	    							String idRequirement = "";
	        						boolean isPresent = false;
	        						idRequirement = getStringRequirement(requirement.toString());
	        						
	        						for(RequirementCoverage reqCoverage : listCovRequirements)
	        						{
	        							if(reqCoverage.getRequirement().equals(idRequirement)) //update covered requirements
	        							{
	        								int countCoeficient = 0;
	            							if(requirement.isCovered()){
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
		        			    			}
	            							else
	            							{
	            								if(failedTestCases[actualTestCase])
		        			    				{
		        			    					countCoeficient = reqCoverage.getC_n_f();
		        				    				reqCoverage.setC_n_f(countCoeficient+1); 
		        			    				}
		        			    				else
		        			    				{
		        			    					countCoeficient = reqCoverage.getC_n_p();
		        				    				reqCoverage.setC_n_p(countCoeficient+1); 
		        			    				}
	            								reqCoverage.setCoverage(actualTestCase, false);
		        			    			}
	            							
	            							listRemainingCovRequirements.remove(reqCoverage);
	            							listUpdatedCovRequirements.add(reqCoverage);
	        								isPresent = true;
	        								break;
	        							}
	        						}
	        						if(!isPresent) //create a new coverage requirement
	        						{
	        							RequirementCoverage reqCoverage = new RequirementCoverage(totalTestCases);
	        							if(requirement.isCovered()){
	        								if(failedTestCases[actualTestCase]){
	        			    					reqCoverage.setC_e_f(1);
	        		    					}
	        		    					else{
	        		    						reqCoverage.setC_e_p(1);
	        		    					}
	        								reqCoverage.setCoverage(actualTestCase, true);
	        		    				}
	        		    				else
	        		    				{
	        		    					if(failedTestCases[actualTestCase]){
	        		    						reqCoverage.setC_n_f(1);
	        		    					}
	        		    					else{
	        		    						reqCoverage.setC_n_p(1);
	        		    					}
	    		    						reqCoverage.setCoverage(actualTestCase, false);
	    		    						
	        		    				}
	        		    				reqCoverage.setRequirement(idRequirement);
	        		    				reqCoverage.setClassName(classRequirementWrapper.getClassName());
    		    						reqCoverage.setMethodId(methodRequirementWrapper.getMethodId());
	        		    				updatePreviousTestCases(reqCoverage);
	        		    				//include in list
	        		    				listUpdatedCovRequirements.add(reqCoverage);
	        						}
	    						}
	    						if(!listRemainingCovRequirements.isEmpty())
	    						{
	    							for(RequirementCoverage remCoverage : listRemainingCovRequirements)
	    							{
	    								int countCoeficient = 0;
	    								if(failedTestCases[actualTestCase])
	    			    				{
	    			    					countCoeficient = remCoverage.getC_n_f();
	    				    				remCoverage.setC_n_f(countCoeficient+1);
	    			    				}
	    			    				else
	    			    				{
	    			    					countCoeficient = remCoverage.getC_n_p();
	    				    				remCoverage.setC_n_p(countCoeficient+1); 
	    			    				}
	    								remCoverage.setCoverage(actualTestCase, false);
	    								
	    								listUpdatedCovRequirements.add(remCoverage);
	    							}
	    						}
	    						
	    					}
	    					else{ //create new covered requirements
	    						
	    		    			for(Requirement requirement : methodRequirementWrapper.getRequirements(requirementType))
	    		    	    	{
	    		    				RequirementCoverage reqCoverage = new RequirementCoverage(totalTestCases);
	    		    				if(requirement.isCovered()){
	    		    					if(failedTestCases[actualTestCase]){
	    		    						reqCoverage.setC_e_f(1);
	    		    					}
	    		    					else{
	    		    						reqCoverage.setC_e_p(1);
	    		    					}
	    		    					reqCoverage.setCoverage(actualTestCase, true);
	    		    				}
	    		    				else{
	    		    					if(failedTestCases[actualTestCase]){
	    		    						reqCoverage.setC_n_f(1);
	    		    					}
	    		    					else{
	    		    						reqCoverage.setC_n_p(1);
	    		    					}
	    		    					reqCoverage.setCoverage(actualTestCase, false);
	    		    					
	    		    				}
	    		    				
	    		    				String strReq = getStringRequirement(requirement.toString());
	    		    				reqCoverage.setClassName(classRequirementWrapper.getClassName());
		    						reqCoverage.setMethodId(methodRequirementWrapper.getMethodId());
	    		    				reqCoverage.setRequirement(strReq);
	    		    				
	    		    				updatePreviousTestCases(reqCoverage);
	    		    				
	    		    				listUpdatedCovRequirements.add(reqCoverage);
	    		    			}
	    					}
	    				}
	    				else{
	    					if(listCovRequirements != null){ //update former requirements (c_n_f or/and c_n_p)
	    						
	    						for(RequirementCoverage reqCoverage : listCovRequirements)
	    		    	    	{
	    							int countCoeficient = 0;
	    							if(failedTestCases[actualTestCase])
				    				{
				    					countCoeficient = reqCoverage.getC_n_f();
					    				reqCoverage.setC_n_f(countCoeficient+1); 
				    				}
				    				else
				    				{
				    					countCoeficient = reqCoverage.getC_n_p();
					    				reqCoverage.setC_n_p(countCoeficient+1); 
				    				}
	    							reqCoverage.setCoverage(actualTestCase, false);
	    							
	    							listUpdatedCovRequirements.add(reqCoverage);
	    						}
	    					}
	    				}
	    				//Update hshMethodRequirements
	    				hshMethodRequirements.remove(methodRequirementWrapper.getMethodId());
			    		hshMethodRequirements.put(methodRequirementWrapper.getMethodId(), listUpdatedCovRequirements);
	        		}
    				else{ //method is new, create new requirements
    					
    					List<RequirementCoverage> listNewCovRequirements = new ArrayList<RequirementCoverage>(); //new requirements
	    				
	    				for(Requirement requirement : methodRequirementWrapper.getRequirements(requirementType))
	    	    	    {
	    					RequirementCoverage reqCoverage = new RequirementCoverage(totalTestCases);
	    					if(requirement.isCovered()){
	    						if(failedTestCases[actualTestCase]){
	    		    				reqCoverage.setC_e_f(1);
	    	    				}
	    	    				else{
	    	    					reqCoverage.setC_e_p(1);
	    	    				}
	    						reqCoverage.setCoverage(actualTestCase, true);
	    	    			}
	    	    			else
	    	    			{
	    	    				if(failedTestCases[actualTestCase]){
	    	    					reqCoverage.setC_n_f(1);
	    	    				}
	    	    				else{
	    	    					reqCoverage.setC_n_p(1);
	    	    				}
	        					reqCoverage.setCoverage(actualTestCase, false);
	    	    			}
	    	    			
	    	    			String strReq = getStringRequirement(requirement.toString());
	    	    			reqCoverage.setRequirement(strReq);
	    	    			reqCoverage.setClassName(classRequirementWrapper.getClassName());
    						reqCoverage.setMethodId(methodRequirementWrapper.getMethodId());
	    	    			
	    	    			updatePreviousTestCases(reqCoverage);
	    	    				
	    	    			listNewCovRequirements.add(reqCoverage);
	    	    		}
	    				hshMethodRequirements.put(methodRequirementWrapper.getMethodId(), listNewCovRequirements);
    				}
	        	} //for requirements
	    		
    			updateRemainingMethods(listUpdatedMethods,hshMethodRequirements);
    			
    			hashClassesTemp.put(classRequirementWrapper.getClassName(), hshMethodRequirements);
    			
    			hashClasses.remove(classRequirementWrapper.getClassName());
    		}
			else //create new item in hashClasses
			{
				Hashtable<Integer,List<RequirementCoverage>> hshMethodRequirements = new Hashtable<Integer,List<RequirementCoverage>>();
		    	
				for(MethodRequirementWrapper methodRequirementWrapper : classRequirementWrapper.getMethods())
	        	{
	    			List<RequirementCoverage> listRequirements = new ArrayList<RequirementCoverage>();
			    	
	    			for(Requirement requirement : methodRequirementWrapper.getRequirements(requirementType))
	    	    	{
	    				//for following serializables, if the class is new in hashClasses and other test cases are already verified
	    				//update the c_n_f and c_n_p coeficients
	    				//consider: total of test cases, number of actual test case and test cases that fail until the actual
	    				RequirementCoverage reqCoverage = new RequirementCoverage(totalTestCases);
						if(requirement.isCovered()){
							if(failedTestCases[actualTestCase]){
		    					reqCoverage.setC_e_f(1);
	    					}
	    					else{
	    						reqCoverage.setC_e_p(1);
	    					}
							reqCoverage.setCoverage(actualTestCase, true);
	    				}
	    				else
	    				{
	    					if(failedTestCases[actualTestCase]){
	    						reqCoverage.setC_n_f(1);
	    					}
	    					else{
	    						reqCoverage.setC_n_p(1);
	    					}
    						reqCoverage.setCoverage(actualTestCase, false);
	    				}
	    				
	    				String strReq = getStringRequirement(requirement.toString());
	    				reqCoverage.setRequirement(strReq);
	    				reqCoverage.setClassName(classRequirementWrapper.getClassName());
						reqCoverage.setMethodId(methodRequirementWrapper.getMethodId());
	    				
	    				updatePreviousTestCases(reqCoverage);
	    				
	    				listRequirements.add(reqCoverage);
	    				
	    			}
	    			//if method do not have requirements,listRequirements is null
	    			hshMethodRequirements.put(methodRequirementWrapper.getMethodId(), listRequirements);
	        	}
				hashClassesTemp.put(classRequirementWrapper.getClassName(), hshMethodRequirements);
	    		
			}
    		
    	}
    	
    	updateRemainingClasses();
    	hashClasses.putAll(hashClassesTemp);
    	
		//printHashClasses();
	}

	public static void printHashClasses()
	{
		Set<String> setClass = hashClasses.keySet();
		Iterator<String> itClass = setClass.iterator();
		
		while(itClass.hasNext())
		{
			String classKey = itClass.next();
			
			Hashtable<Integer,List<RequirementCoverage>> hashMethods = hashClasses.get(classKey);
			Set<Integer> setMethod = hashMethods.keySet();
			Iterator<Integer> itMethod = setMethod.iterator();
			
			while(itMethod.hasNext())
			{
				Integer methodKey = itMethod.next();
				List<RequirementCoverage> listCov = hashMethods.get(methodKey);
				
				for(RequirementCoverage reqCoverage : listCov)
				{
					System.out.println(classKey + " : " + methodKey + " : " + reqCoverage.getRequirement() + " = " + reqCoverage.getC_e_f() + ", " + reqCoverage.getC_e_p() + ", " + reqCoverage.getC_n_f() + ", " + reqCoverage.getC_n_p());
				}
			}
		}
	}
	
	public static void updateFailedTestCases()
	{
		failedTestCases[actualTestCase] = true;
	}
	
	//set coverage and coefficient values for classes, his methods and requirements that are not executed by actual test case.
	//private 
    public static void updateRemainingClasses()
	{
		Set<String> setClass = hashClasses.keySet();
		Iterator<String> itClass = setClass.iterator();
		
		while(itClass.hasNext())
		{
			String classKey = itClass.next();
			Hashtable<Integer,List<RequirementCoverage>> hashMethods = hashClasses.get(classKey);
			Set<Integer> setMethod = hashMethods.keySet();
			Iterator<Integer> itMethod = setMethod.iterator();
			
			while(itMethod.hasNext())
			{
				Integer methodKey = itMethod.next();
				List<RequirementCoverage> listCovRequirements = hashMethods.get(methodKey);
				
				for(RequirementCoverage reqCoverage : listCovRequirements)
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
		}
	}
	
    //private 
    public static void updatePreviousTestCases(RequirementCoverage reqCoverage)
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
    public static void calculateSuspiciousness()
    {
    	Heuristic heuristic = new Heuristic();
    	Set<String> setClass = hashClasses.keySet();
		Iterator<String> itClass = setClass.iterator();
		
		while(itClass.hasNext())
		{
			String classKey = itClass.next();
			
			Hashtable<Integer,List<RequirementCoverage>> hashMethods = hashClasses.get(classKey);
			Set<Integer> setMethod = hashMethods.keySet();
			Iterator<Integer> itMethod = setMethod.iterator();
			
			while(itMethod.hasNext())
			{
				Integer methodKey = itMethod.next();
				List<RequirementCoverage> listCovRequirements = hashMethods.get(methodKey);
				
				switch(heuristicType)
				{
				case DRT:
					for(RequirementCoverage reqCoverage : listCovRequirements)
					{
						reqCoverage.setSuspicious(heuristic.calculateDRT(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
					}
					break;
				case OCHIAI:
					for(RequirementCoverage reqCoverage : listCovRequirements)
					{
						reqCoverage.setSuspicious(heuristic.calculateOchiai(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
					}
					break;
				case JACCARD:
					for(RequirementCoverage reqCoverage : listCovRequirements)
					{
						reqCoverage.setSuspicious(heuristic.calculateJaccard(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
					}
					break;
				case ZOLTAR:
					for(RequirementCoverage reqCoverage : listCovRequirements)
					{
						reqCoverage.setSuspicious(heuristic.calculateZoltar(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
					}
					break;
				case OP:
					for(RequirementCoverage reqCoverage : listCovRequirements)
					{
						reqCoverage.setSuspicious(heuristic.calculateOp(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
					}
					break;
				case MINUS:
					for(RequirementCoverage reqCoverage : listCovRequirements)
					{
						reqCoverage.setSuspicious(heuristic.calculateMinus(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
					}
					break;
				case KULCZYNSKI2:
					for(RequirementCoverage reqCoverage : listCovRequirements)
					{
						reqCoverage.setSuspicious(heuristic.calculateKulczynski2(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
					}
					break;
				case MCCON:
					for(RequirementCoverage reqCoverage : listCovRequirements)
					{
						reqCoverage.setSuspicious(heuristic.calculateMcCon(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
					}
					break;
				case WONG3:
					for(RequirementCoverage reqCoverage : listCovRequirements)
					{
						reqCoverage.setSuspicious(heuristic.calculateWong3(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
					}
					break;
				default:
					for(RequirementCoverage reqCoverage : listCovRequirements)
					{
						reqCoverage.setSuspicious(heuristic.calculateTarantula(reqCoverage.getC_e_f(),reqCoverage.getC_n_f(),reqCoverage.getC_e_p(),reqCoverage.getC_n_p()));
					}
					break;
				}
			}
		}
    	
    }
	
    //private
    public static void updateRemainingMethods(List<Integer> listMethods,Hashtable<Integer,List<RequirementCoverage>> hshMethods)
    {
    	Set<Integer> setMethod = hshMethods.keySet();
		Iterator<Integer> itMethod = setMethod.iterator();
		
		while(itMethod.hasNext())
		{
			Integer methodKey = itMethod.next();
			
			if(!listMethods.contains(methodKey)){
				List<RequirementCoverage> listCovRequirements = hshMethods.get(methodKey);
				
				for(RequirementCoverage reqCoverage : listCovRequirements)
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
		}
    }
    
    //private
    public static void classifyRequirementsBySuspiciousness(){
    	
    	listRequirementsBySuspiciousness = new ArrayList<RequirementCoverage>();
    	
    	Set<String> setClass = hashClasses.keySet();
		Iterator<String> itClass = setClass.iterator();
		
		while(itClass.hasNext())
		{
			String classKey = itClass.next();
			
			Hashtable<Integer,List<RequirementCoverage>> hashMethods = hashClasses.get(classKey);
			Set<Integer> setMethod = hashMethods.keySet();
			Iterator<Integer> itMethod = setMethod.iterator();
			
			while(itMethod.hasNext())
			{
				Integer methodKey = itMethod.next();
				List<RequirementCoverage> listCovRequirements = hashMethods.get(methodKey);
				
				for(RequirementCoverage reqCoverage : listCovRequirements)
				{
					listRequirementsBySuspiciousness.add(reqCoverage);
				}
			}
		}
		
		Collections.sort(listRequirementsBySuspiciousness);
    }
    
    //Add a value of suspiciousness for classes based on its requirements values
    public static double calculateMaxSuspiciousnessByClass(String classKey){
		
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
    public static int calculateNumberOfMaxSuspiciousnessByClass(String classKey){
		
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
    public static double calculateMaxSuspiciousnessByMethod(String classKey, int methodKey){
		
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
    public static int calculateMaxNumberOfSuspiciousnessByMethod(String classKey, int methodKey){
		
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
    
    
    public static double calculateMaxSuspiciousnessByPackage(String packageName){
		
    	fillPackages();
    	
    	double suspiciousPackageValue = 0;

    	List<String> lstClasses = hashPackage.get(packageName);
    	
    	for(String className : lstClasses)
    	{
    		double suspiciousClassValue = calculateMaxSuspiciousnessByClass(className);
    		if(suspiciousClassValue > suspiciousPackageValue)
    		{
    			suspiciousPackageValue = suspiciousClassValue;
    		}
    	}
    	
    	return suspiciousPackageValue;
	}
    
    public static int calculateNumberOfMaxSuspiciousnessByPackage(String packageName){
		
    	double suspiciousPackageValue = 0;
    	int countMaxSuspiciousness = 0;
    	
    	List<String> lstClasses = hashPackage.get(packageName);
    	
    	for(String className : lstClasses)
    	{
    		double suspiciousClassValue = calculateMaxSuspiciousnessByClass(className);
    		int countSuspiciousClass = calculateNumberOfMaxSuspiciousnessByClass(className);
    		
    		if(suspiciousClassValue > suspiciousPackageValue)
    		{
    			suspiciousPackageValue = suspiciousClassValue;
    			countMaxSuspiciousness = countSuspiciousClass;
    		}
    		else if(suspiciousClassValue == suspiciousPackageValue)
    		{
    			countMaxSuspiciousness += countSuspiciousClass;
    		}
    	}
    	
    	return countMaxSuspiciousness;
	}
    
    //fill the suspiciousness values for each package 
    public static void fillPackageSuspicious(){
    	
    	Set<String> setPackage = hashPackage.keySet();
		Iterator<String> itPackage = setPackage.iterator();
		
		while(itPackage.hasNext())
		{
			String packageName = itPackage.next();
			double suspiciousPackage = 0;
			int countPackage = 0;
			suspiciousPackage = calculateMaxSuspiciousnessByPackage(packageName);
			countPackage = calculateNumberOfMaxSuspiciousnessByPackage(packageName);
	    	hashPackageSuspicious.put(packageName, suspiciousPackage);
	    	hashPackageNumberOfMaxSuspicious.put(packageName, countPackage);
		}
    }
    
    //fill a list of all packages and its classes
    public static void fillPackages()
    {
    	Hashtable <String, List<String>> hshPackage = new Hashtable <String, List<String>>();
    	List<String> listPack = new ArrayList<String>();
    	
    	Set<String> setClass = hashClasses.keySet();
		Iterator<String> itClass = setClass.iterator();
		
		while(itClass.hasNext())
		{
			String classKey = itClass.next();
			classKey = getPackageName(classKey);
			if(listPack.isEmpty()){
	    		listPack.add(classKey); 
	    	}
			if(!listPack.contains(classKey)){
				listPack.add(classKey);
			}
		}
    	
		for(String packName : listPack)
		{
			List<String> lstClasses = fillClasses(packName);
			Collections.sort(lstClasses);
			hshPackage.put(packName, lstClasses);
		}
    	hashPackage = hshPackage;
    }
    
    
    public static List<String> fillClasses(String packName)
    {
    	List<String> listPack = new ArrayList<String>();
    	
    	Set<String> setClass = hashClasses.keySet();
		Iterator<String> itClass = setClass.iterator();
		
		while(itClass.hasNext())
		{
			String className = itClass.next();
			if(packName.equals(getPackageName(className))){
	    		listPack.add(className);  
	    	}
		}
    	return listPack;
    }
    
    public static String getPackageName(String className)
    {
    	String packName = "";
    	int tempIndex = 0;
    	if(className.contains(".")){
    		tempIndex = className.lastIndexOf(".");
        	packName = className.substring(0, tempIndex);
        } 
    	return packName;
    }
    
    public static void printPackages()
    {
    	Set<String> setClass = hashPackage.keySet();
		Iterator<String> itClass = setClass.iterator();
		
		while(itClass.hasNext())
		{
			String className = itClass.next();
			List<String> lstClass = hashPackage.get(className);
			for(String str :lstClass)
				System.out.println("PACKAGES: " + className + " -- Classes:" + str);
		}
    }

	
}// END of class
