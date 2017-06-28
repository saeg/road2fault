package br.usp.each.saeg.road2fault.extractor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import br.usp.each.saeg.road2fault.extractor.model.McpMethod;
import br.usp.each.saeg.road2fault.extractor.model.XmlBLBlock;
import br.usp.each.saeg.road2fault.extractor.model.XmlBLReportFile;
import br.usp.each.saeg.road2fault.extractor.model.XmlBLTestCriteria;
import br.usp.each.saeg.road2fault.extractor.model.XmlBlock;
import br.usp.each.saeg.road2fault.extractor.model.XmlMcpTestCriteria;
import br.usp.each.saeg.road2fault.extractor.model.XmlMethod;
import br.usp.each.saeg.road2fault.extractor.model.XmlTestCriteria;

public class InspectionStrategyLevelScorePerMethod {
	
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
					System.out.println("faulty block :"+inspectedBlocksInBL);
				}
			}
		}
	}
	
	/*
	 * Get level scores based on levels of each method
	 * This strategy gets each score from a method, at most 15 score levels
	 * */
	public static void calculateMcpPerformance(XmlTestCriteria criteria, XmlMcpTestCriteria mcpCriteria, double delta){
		DataParser dataParser = new DataParser();
		List<String> inspectedMethods = new ArrayList<String>();
		List<Double> levelScore = new ArrayList<Double>();
		//this list is used to get the index which corresponds to the delta value parameter
		List<Double> deltaRange = new ArrayList<Double>();
		deltaRange.add(0d);
		deltaRange.add(1d);
		deltaRange.add(3d);
		deltaRange.add(5d);
		deltaRange.add(7d);
		deltaRange.add(10d);
		deltaRange.add(15d);
		deltaRange.add(20d);
		deltaRange.add(25d);
		deltaRange.add(30d);
		deltaRange.add(35d);
		deltaRange.add(40d);
		deltaRange.add(45d);
		deltaRange.add(50d);
		deltaRange.add(75d);
		int index = deltaRange.indexOf(delta);
		double faultScore=-1;
		logFileList.add("");
		logFileList.add(">>>>>>>>>>>>>> ICD - Level Score "+index+"  <<<<<<<<<<<<<<<<");
		logFileList.add("");
		List<XmlMethod> methodList = dataParser.createCodeHierarchyMethodList(criteria);
		Collections.sort(methodList);
		double deltaScore = 1.0;
		for(McpMethod mcpMethod : mcpCriteria.getRoadmap()){
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
				//get delta according to the level score
				levelScore = getMethodLevelScores(xmlMethod);
				if(!levelScore.isEmpty()){
					if(levelScore.size() <= index){
						deltaScore = levelScore.get(levelScore.size()-1);
					}else{
						deltaScore = levelScore.get(index);
					}
				}
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
	
	//get each score from the blocks of method list (i.e, all scores)
	private static List<Double> getMethodLevelScores(XmlMethod method){
		SortedSet<Double> levelScoreSet = new TreeSet<Double>();
		List<Double> levelScoreList = new ArrayList<Double>();
		for(XmlBlock block : method.getBlocks()){
			levelScoreSet.add(block.getScore());
		}
		levelScoreSet.remove(0d);
		levelScoreList.addAll(levelScoreSet);
		Collections.sort(levelScoreList,Collections.reverseOrder());
		return levelScoreList;
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
	 *  This strategy is fairer to compare with MCP, 
	 * */
	public static void calculateMethodHitSpectraPerformanceForBlocksAndDelta(XmlTestCriteria criteria, double delta){
		DataParser dataParser = new DataParser();
		List<Double> levelScore = new ArrayList<Double>();
		//this list is used to get the index which corresponds to the delta value parameter
		List<Double> deltaRange = new ArrayList<Double>();
		deltaRange.add(0d);
		deltaRange.add(1d);
		deltaRange.add(3d);
		deltaRange.add(5d);
		deltaRange.add(7d);
		deltaRange.add(10d);
		deltaRange.add(15d);
		deltaRange.add(20d);
		deltaRange.add(25d);
		deltaRange.add(30d);
		deltaRange.add(35d);
		deltaRange.add(40d);
		deltaRange.add(45d);
		deltaRange.add(50d);
		deltaRange.add(75d);
		int index = deltaRange.indexOf(delta);
		double faultScore=-1;
		List<String> inspectedMethods = new ArrayList<String>(); // to reduce methods that were already visited
		logFileList.add("");
		logFileList.add(">>>>>>>>>>>>>> CH  - Level Score "+index+" - Less blocks first  <<<<<<<<<<<<<<<<");
		logFileList.add("");
		List<XmlMethod> methodList = dataParser.createCodeHierarchyMethodList(criteria);
		Collections.sort(methodList);
		double deltaScore = 1.0;
		
		for(XmlMethod method : methodList){
			//get delta according to the level score
			levelScore = getMethodLevelScores(method);
			if(!levelScore.isEmpty()){
				if(levelScore.size() <= index){
					deltaScore = levelScore.get(levelScore.size()-1);
				}else{
					deltaScore = levelScore.get(index);
				}
			}
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

