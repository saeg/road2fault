package br.usp.each.saeg.road2fault;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListPosition {

	//private int []startEndPosition = {0,0};
	private Map<Double,int[]> mapPosition = new HashMap<Double,int[]>();
	private final String METHOD_SENTINELLA = "calledByTestCase(";
	
	//The list must be ordered
	public void insertAbsolutePosition(List<RequirementCoverage> listRequirements)
	{
		Iterator<RequirementCoverage> itReqCoverage = listRequirements.iterator();
		int position = 1;
		int []startEndPosition = {1,1};
		double suspicious = listRequirements != null && listRequirements.size() > 0 ? listRequirements.get(0).getSuspicious() : 0;
		
		while(itReqCoverage.hasNext())
		{
			RequirementCoverage reqCoverage = itReqCoverage.next();
			reqCoverage.setAbsolutePosition(position);
			
			//put the start and end position for each suspicious value in a map
			if(reqCoverage.getSuspicious() == suspicious){
				startEndPosition[1] = position;
			}
			else if(reqCoverage.getSuspicious() < suspicious){
				if(startEndPosition[1] < startEndPosition[0])//if has only one requirement with a specific suspicious value...
				{
					startEndPosition[1] = startEndPosition[0];
				}
				mapPosition.put(suspicious, startEndPosition);
				startEndPosition = new int[]{0,0};
				suspicious = reqCoverage.getSuspicious();
				startEndPosition[0] = position;
			}
			
			if(!itReqCoverage.hasNext())
			{
				startEndPosition[1] = position;
				mapPosition.put(suspicious, startEndPosition);
			}
			
			position++;
		}
		//System.out.println("Map size: " + mapPosition.size());
		//printMapPosition();
	}

	//The list must be ordered
	public void insertAbsolutePositionMCP(List<MethodCallPairRequirementCoverage> listRequirements)
	{
		Iterator<MethodCallPairRequirementCoverage> itMCPCoverage = listRequirements.iterator();
		int position = 1;
		int []startEndPosition = {1,1};
		double suspicious = listRequirements != null && listRequirements.size() > 0 ? listRequirements.get(0).getSuspicious() : 0;
		
		while(itMCPCoverage.hasNext())
		{
			MethodCallPairRequirementCoverage mcpCoverage = itMCPCoverage.next();
			mcpCoverage.setAbsolutePosition(position);
			
			//put the start and end position for each suspicious value in a map
			if(mcpCoverage.getSuspicious() == suspicious){
				startEndPosition[1] = position;
			}
			else if(mcpCoverage.getSuspicious() < suspicious){
				if(startEndPosition[1] < startEndPosition[0])//if has only one requirement with a specific suspicious value...
				{
					startEndPosition[1] = startEndPosition[0];
				}
				mapPosition.put(suspicious, startEndPosition);
				startEndPosition = new int[]{0,0};
				suspicious = mcpCoverage.getSuspicious();
				startEndPosition[0] = position;
			}
			
			if(!itMCPCoverage.hasNext())
			{
				startEndPosition[1] = position;
				mapPosition.put(suspicious, startEndPosition);
			}
			
			position++;
		}
		System.out.println("Map size: " + mapPosition.size());
		printMapPosition();
	}
	
	//The list must be ordered
	public void insertAbsolutePositionMCT(List<MethodCallTripleRequirementCoverage> listRequirements)
	{
		Iterator<MethodCallTripleRequirementCoverage> itMCTCoverage = listRequirements.iterator();
		int position = 1;
		int []startEndPosition = {1,1};
		double suspicious = listRequirements != null && listRequirements.size() > 0 ? listRequirements.get(0).getSuspicious() : 0;
		
		while(itMCTCoverage.hasNext())
		{
			MethodCallTripleRequirementCoverage mctCoverage = itMCTCoverage.next();
			mctCoverage.setAbsolutePosition(position);
			
			//put the start and end position for each suspicious value in a map
			if(mctCoverage.getSuspicious() == suspicious){
				startEndPosition[1] = position;
			}
			else if(mctCoverage.getSuspicious() < suspicious){
				if(startEndPosition[1] < startEndPosition[0])//if has only one requirement with a specific suspicious value...
				{
					startEndPosition[1] = startEndPosition[0];
				}
				mapPosition.put(suspicious, startEndPosition);
				startEndPosition = new int[]{0,0};
				suspicious = mctCoverage.getSuspicious();
				startEndPosition[0] = position;
			}
			
			if(!itMCTCoverage.hasNext())
			{
				startEndPosition[1] = position;
				mapPosition.put(suspicious, startEndPosition);
			}
			
			position++;
		}
		System.out.println("Map size: " + mapPosition.size());
		printMapPosition();
	}
	
	public int getMediumPosition(double suspicious)
	{
		int []pos = {0,0};
		int medium = 0;
		pos = mapPosition.get(suspicious);
		medium = (pos[0] + pos[1])/2;
		return medium;
	}
		
	public int getMinPosition(double suspicious)
	{
		int []pos = {0,0};
		pos = mapPosition.get(suspicious);
		return pos[0];
	}
	
	public int getMaxPosition(double suspicious)
	{
		int []pos = {0,0};
		pos = mapPosition.get(suspicious);
		return pos[1];
	}
	
	
	public double getMediumEXAMScore(double suspicious, int size)
	{
		double score = 0;
		if(size > 0){
			score = (double)getMediumPosition(suspicious)/size;
		}
		return score;
	}
	
	public double getMinEXAMScore(double suspicious, int size)
	{
		double score = 0;
		if(size > 0){
			score = (double)getMinPosition(suspicious)/size;
		}
		return score;
	}
	
	public double getMaxEXAMScore(double suspicious, int size)
	{
		double score = 0;
		if(size > 0){
			score = (double)getMaxPosition(suspicious)/size;
		}
		return score;
	}
	
	public void printMapPosition()
	{
		Set<Double> setPosition = mapPosition.keySet();
		Iterator<Double> itSet = setPosition.iterator();
		
		while(itSet.hasNext())
		{
			double key = itSet.next();
			int []pos = mapPosition.get(key);
			System.out.println(key + ": " + pos[0] + " - " + pos[1]);
		}
	}
	
	public Map<String,Double> getMCPMethodList(List<MethodCallPairRequirementCoverage> listMCPRequirements)
	{
		Iterator<MethodCallPairRequirementCoverage> itMCPCoverage = listMCPRequirements.iterator();
		Map<String,Double> mapMCPMethods = new LinkedHashMap<String,Double>();
		
		while(itMCPCoverage.hasNext())
		{
			MethodCallPairRequirementCoverage mcp = itMCPCoverage.next();
			String mcpMethod = mcp.getMethodNameCaller();
			
			if(mcpMethod.startsWith("<init>")){
				mcpMethod = mcp.getClassNameCaller().substring(mcp.getClassNameCaller().lastIndexOf(".")+1) + "(";
			}
			else{
				mcpMethod = mcpMethod.substring(0, mcpMethod.indexOf("(")+1);
			}
			
			if(!mapMCPMethods.containsKey(mcpMethod) && !mcpMethod.startsWith(METHOD_SENTINELLA)){
				mapMCPMethods.put(mcpMethod,mcp.getSuspicious());
			}
			
			mcpMethod = mcp.getMethodNameCalled();
			if(mcpMethod.startsWith("<init>")){
				mcpMethod = mcp.getClassNameCalled().substring(mcp.getClassNameCalled().lastIndexOf(".")+1) + "(";
			}
			else{
				mcpMethod = mcpMethod.substring(0, mcpMethod.indexOf("(")+1);
			}
			
			if(!mapMCPMethods.containsKey(mcpMethod) && !mcpMethod.startsWith(METHOD_SENTINELLA)){
				mapMCPMethods.put(mcpMethod,mcp.getSuspicious());
			}
		}
		return mapMCPMethods;
	}
	
	public Map<String,Double> getMCTMethodList(List<MethodCallTripleRequirementCoverage> listMCTRequirements)
	{
		Iterator<MethodCallTripleRequirementCoverage> itMCTCoverage = listMCTRequirements.iterator();
		Map<String,Double> mapMCTMethods = new LinkedHashMap<String,Double>();
		
		while(itMCTCoverage.hasNext())
		{
			MethodCallTripleRequirementCoverage mct = itMCTCoverage.next();
			String mctMethod = mct.getMethodNameCaller();
			
			if(mctMethod.startsWith("<init>")){
				mctMethod = mct.getClassNameCaller().substring(mct.getClassNameCaller().lastIndexOf(".")+1) + "(";
			}
			else{
				mctMethod = mctMethod.substring(0, mctMethod.indexOf("(")+1);
			}
			
			if(!mapMCTMethods.containsKey(mctMethod) && !mctMethod.startsWith(METHOD_SENTINELLA)){
				mapMCTMethods.put(mctMethod,mct.getSuspicious());
			}
			
			mctMethod = mct.getMethodNameCalledN1();
			if(mctMethod.startsWith("<init>")){
				mctMethod = mct.getClassNameCalledN1().substring(mct.getClassNameCalledN1().lastIndexOf(".")+1) + "(";
			}
			else{
				mctMethod = mctMethod.substring(0, mctMethod.indexOf("(")+1);
			}
			
			if(!mapMCTMethods.containsKey(mctMethod) && !mctMethod.startsWith(METHOD_SENTINELLA)){
				mapMCTMethods.put(mctMethod,mct.getSuspicious());
			}
			
			mctMethod = mct.getMethodNameCalledN2();
			if(mctMethod.startsWith("<init>")){
				mctMethod = mct.getClassNameCalledN2().substring(mct.getClassNameCalledN2().lastIndexOf(".")+1) + "(";
			}
			else{
				mctMethod = mctMethod.substring(0, mctMethod.indexOf("(")+1);
			}
			
			if(!mapMCTMethods.containsKey(mctMethod) && !mctMethod.startsWith(METHOD_SENTINELLA)){
				mapMCTMethods.put(mctMethod,mct.getSuspicious());
			}
		}
		return mapMCTMethods;
	}
		
}
