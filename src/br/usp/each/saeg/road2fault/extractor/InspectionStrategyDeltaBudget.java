package br.usp.each.saeg.road2fault.extractor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.usp.each.saeg.road2fault.extractor.model.McpMethod;
import br.usp.each.saeg.road2fault.extractor.model.XmlBLBlock;
import br.usp.each.saeg.road2fault.extractor.model.XmlBLReportFile;
import br.usp.each.saeg.road2fault.extractor.model.XmlBLTestCriteria;
import br.usp.each.saeg.road2fault.extractor.model.XmlBlock;
import br.usp.each.saeg.road2fault.extractor.model.XmlMcpReportFile;
import br.usp.each.saeg.road2fault.extractor.model.XmlMcpTestCriteria;
import br.usp.each.saeg.road2fault.extractor.model.XmlMethod;
import br.usp.each.saeg.road2fault.extractor.model.XmlTestCriteria;

public class InspectionStrategyDeltaBudget {
	
	public static int inspectedBlocksInBL=0;
	public static int inspectedMethodsInMcp=0;
	public static int inspectedBlocksInMcp=0;
	public static int inspectedMethodsInMethodHitSpectra=0;
	public static int inspectedBlocksInMethodHitSpectra=0;
	public static List<String> logFileList = new ArrayList<String>();
	
	public static void calculateBlockListPerformance(XmlBLReportFile report){
		double faultScore=-1;
		logFileList.add("");
		logFileList.add(">>>>>>>>>>>>>> Block List <<<<<<<<<<<<<<<<");
		logFileList.add("");
		for(XmlBLTestCriteria criteria : report.getBLTestCriteriaList()){
			for(XmlBLBlock block : criteria.getBLBlockList()){
				if(faultScore > block.getScore()){
					//System.out.println("inspected blocks: "+inspectedBlocksInBL);
					logFileList.add("");
					logFileList.add("");
					return;
				}
				inspectedBlocksInBL++;
				logFileList.add("inspected blocks: "+inspectedBlocksInBL+", susp: "+block.getScore()+" - block : "+block.getBlockId()+", "+block.getMethodName()+", "+block.getClassName());
				if(block.isFault()){
					faultScore = block.getScore();
					logFileList.add("+++fault found! inspected blocks: "+inspectedBlocksInBL+", susp: "+block.getScore()+" - block : "+block.getBlockId()+", "+block.getMethodName()+", "+block.getClassName());
					//System.out.println("faulty block :"+inspectedBlocksInBL);
				}
			}
		}
	}
	
	/*
	 * Combining delta budget + method signature
	 * */
	public static void calculateMcpPerformance(XmlTestCriteria criteria, XmlMcpTestCriteria mcpCriteria, int budget, XmlBLReportFile blReportFile){
		DataParser dataParser = new DataParser();
		List<String> inspectedMethods = new ArrayList<String>();
		double faultScore=-1;
		double deltaBudget = getBudgetScore(blReportFile,budget);
		logFileList.add("");
		logFileList.add(">>>>>>>>>>>>>> ICD - Fixed Budget "+budget+"  <<<<<<<<<<<<<<<<");
		logFileList.add("");
		List<XmlMethod> methodList = dataParser.createCodeHierarchyMethodList(criteria);
		Collections.sort(methodList);
		for(McpMethod mcpMethod : mcpCriteria.getRoadmap()){
			double deltaScore = deltaBudget; // mcpMethod.getScore()-(mcpMethod.getScore()*(delta/100));
			//this is needed to avoid repetition. mcp list contains methods with equal name 
			//and different signature that are already included in matchedMethods
			if(checkInspectedMethods(inspectedMethods,mcpMethod.getName())){
				continue;
			}
			inspectedMethods.add(mcpMethod.getName());
			
			List<XmlMethod> matchedMethods = getMethodListByName(methodList,mcpMethod.getName());
			if(matchedMethods.size() > 1){//methods with equal name are count once
				inspectedMethodsInMcp -= countRepeatedMethodsWithScore(matchedMethods,deltaScore);
			}
						
			for(XmlMethod xmlMethod : matchedMethods){
				if(xmlMethod.getScore() >= deltaScore){
					inspectedMethodsInMcp++;//counting each matched method
					logFileList.add("inspected methods: "+inspectedMethodsInMcp+", susp: "+xmlMethod.getScore()+" - method : "+xmlMethod.getName()+", id: "+xmlMethod.getId());
				}
				for(XmlBlock block : xmlMethod.getBlocks()){
					if(block.getScore() >= deltaScore){
						inspectedBlocksInMcp++;
						logFileList.add(">>> inspected blocks: "+inspectedBlocksInMcp+", susp: "+block.getScore()+" - block : "+block.getId());
						if(block.isFault()){
							faultScore = block.getScore();
							logFileList.add("+++fault found! no. blocks inspected: "+inspectedBlocksInMcp+", susp: "+block.getScore()+" - block : "+block.getId());
							//System.out.println("inspected blocks :"+inspectedBlocksInMcp);
						}
					}
					else{
						break;
					}
					if(!mcpMethod.isFault() && xmlMethod.isFault()){//it is necessary when not using the whole signature name
						mcpMethod.setFault();
					}
				}
			}
			if(faultScore > -1){
				//System.out.println("inspected methods :"+inspectedMethodsInMcp);
				logFileList.add("");
				logFileList.add("");
				return;
			}
			if(mcpMethod.isFault()){
				inspectedBlocksInMcp = criteria.getTotalExecutedBlocks();
				inspectedMethodsInMcp = criteria.getTotalExecutedMethods();
				logFileList.add("+++ fault lost! faulty method: " + mcpMethod.getName() + " inspected blocks: "+inspectedBlocksInMethodHitSpectra);
				logFileList.add("");
				logFileList.add("");
				return;
			}
		}
	}
	
	private static double getBudgetScore(XmlBLReportFile blReportFile, int budget){
		int numberOfBlocks = 0;
		double deltaBudget = 0;
		for(XmlBLTestCriteria blCriteria : blReportFile.getBLTestCriteriaList()){
			numberOfBlocks += blCriteria.getBLBlockList().size();
			if(numberOfBlocks <= budget){
				deltaBudget = blCriteria.getScore();
			}else{
				if(deltaBudget == 0){
					deltaBudget = blCriteria.getScore();
				}else{
					return deltaBudget;
				}
			}
		}
		return deltaBudget;
	}
	
	private static int countRepeatedMethodsWithScore(List<XmlMethod> repeatedMethods, double score) {
		int count = 0;
		boolean ignoreFirst = true;
		for(XmlMethod method : repeatedMethods){	
			if(method.getScore() >= score){
				if(!ignoreFirst){
					count++;
				}
				else{
					ignoreFirst = false;
				}
			}
		}
		return count;
	}

	public static List<XmlMethod> getMethodListByName(List<XmlMethod> methodList, String methodName){
		List<XmlMethod> matchedMethods = new ArrayList<XmlMethod>();
		for(XmlMethod method : methodList){
			//if(method.getName().equals(methodName)){ //exact signature
			//we are not using the exact signature
			if(method.getName().substring(0, method.getName().indexOf("(")+1).equals(methodName.substring(0, methodName.indexOf("(")+1))){
				matchedMethods.add(method);
			}
		}
		return matchedMethods;
	}
	
	/*
	 * This strategy is considering all methods with the same of the suspicious block (max). To tie-break, we consider blocks with less suspicious blocks first
	 * */
	public static void calculateMethodHitSpectraPerformance(XmlTestCriteria criteria){
		DataParser dataParser = new DataParser();
		double faultScore=-1;
		logFileList.add("");
		logFileList.add(">>>>>>>>>>>>>> CodeHierarchy  - counting all method and blocks until the fault score  <<<<<<<<<<<<<<<<");
		logFileList.add("");
		List<XmlMethod> methodList = dataParser.createCodeHierarchyMethodList(criteria);
		Collections.sort(methodList);
		for(XmlMethod method : methodList){
			if(faultScore > method.getScore()){
				System.out.println("------ fault not found! inspected methods :"+inspectedMethodsInMethodHitSpectra);
				logFileList.add("");
				logFileList.add("");
				return;
			}
			inspectedMethodsInMethodHitSpectra++;
			logFileList.add("inspected methods: "+inspectedMethodsInMethodHitSpectra+" - method : "+method.getName()+", susp: "+method.getScore()+", id: "+method.getId());
			for(XmlBlock block : method.getBlocks()){
				if(block.isFault()){
					faultScore = block.getScore();
				}
			}
		}
	}
	
	/*
	 *  This strategy is fairer to compare with MCP, 
	 * */
	public static void calculateMethodHitSpectraPerformanceForBlocksAndDelta(XmlTestCriteria criteria, int budget, XmlBLReportFile blReportFile){
		DataParser dataParser = new DataParser();
		double faultScore=-1;
		double deltaBudget = getBudgetScore(blReportFile,budget);
		
		List<String> inspectedMethods = new ArrayList<String>(); // to reduce methods that were already visited
		logFileList.add("");
		logFileList.add(">>>>>>>>>>>>>> CH  - Fixed Budget "+budget+" - Less blocks first  <<<<<<<<<<<<<<<<");
		logFileList.add("");
		List<XmlMethod> methodList = dataParser.createCodeHierarchyMethodList(criteria);
		Collections.sort(methodList);
		for(XmlMethod method : methodList){
			double deltaScore = deltaBudget;//method.getScore()-(method.getScore()*(delta/100));
			if(!checkInspectedMethods(inspectedMethods,method.getName())){
				inspectedMethods.add(method.getName());
				inspectedMethodsInMethodHitSpectra++;
			}
			
			logFileList.add("inspected methods: "+inspectedMethodsInMethodHitSpectra+" - method : "+method.getName()+", susp: "+method.getScore()+", id: "+method.getId());
			for(XmlBlock block : method.getBlocks()){
				if(block.getScore() >= deltaScore){
					inspectedBlocksInMethodHitSpectra++;
					logFileList.add(">>> inspected blocks: "+inspectedBlocksInMethodHitSpectra+" - block : "+block.getId()+", susp: "+block.getScore());
					if(block.isFault()){
						faultScore = block.getScore();
						logFileList.add("+++ fault found! inspected blocks: "+inspectedBlocksInMethodHitSpectra+" - block : "+block.getId()+", susp: "+block.getScore());
						//System.out.println("inspected blocks :"+inspectedBlocksInMethodHitSpectra);
					}
				}
				else{
					break;
				}
			}
			if(faultScore > -1){//fault found
				//System.out.println("inspected methods :"+inspectedMethodsInMethodHitSpectra);
				logFileList.add("");
				logFileList.add("");
				return;
			}
			if(method.isFault()){//the fault was not found (it does not consider methods with same score below the faulty method
				inspectedBlocksInMethodHitSpectra = criteria.getTotalExecutedBlocks();
				inspectedMethodsInMethodHitSpectra = criteria.getTotalExecutedMethods();
				logFileList.add("+++ fault lost! faulty method: " + method.getName() + " inspected blocks: "+inspectedBlocksInMethodHitSpectra);
				logFileList.add("");
				logFileList.add("");
				return;
			}
		}
	}
	
	private static boolean checkInspectedMethods(List<String> inspectedMethods, String methodName){
		for(String name : inspectedMethods){
			//if(methodName.equals(name)){ //check for the complete signature
			if(methodName.substring(0, methodName.indexOf("(")+1).equals(name.substring(0, name.indexOf("(")+1))){
				return true;
			}
		}
		return false;
	}
	
	public static void clear(){
		inspectedBlocksInBL=0;
		inspectedMethodsInMcp=0;
		inspectedBlocksInMcp=0;
		inspectedMethodsInMethodHitSpectra=0;
		inspectedBlocksInMethodHitSpectra=0;
		logFileList.clear();
	}
	
	//to experiment with CF round
	public static double roundDoubleTwoDecimal(double score){
		double result=score; 
		String value  = String.valueOf(score);
		if(value.length()>3){
			value = value.substring(0, 4);
			result = Double.parseDouble(value);
		}
		return result;
	}
	
}
