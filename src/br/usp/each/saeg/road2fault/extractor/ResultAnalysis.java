package br.usp.each.saeg.road2fault.extractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultAnalysis {
	
	private String heuristicType;
	private String faultName;
	private int programVersion;
	private String programName;
	private String faultyPackage;
	private String faultyClass;
	private String faultyMethod;
	private int faultyBlock;
	private double mcpScore;
	private double blockListScore;
	private int icdInspectedMethods;
	private Map<Integer,Integer> icdInspectedBlocksPerDelta = new HashMap<Integer,Integer>();
	private int mhsInspectedMethods;
	private Map<Integer,Integer> mhsInspectedBlocksPerDelta = new HashMap<Integer,Integer>();
	private int blockListInspectedBlocks;
	private Map<Integer,Integer> faultsFoundPerBudget = new HashMap<Integer,Integer>();
	private List<String> inspectionLog = new ArrayList<String>();
	
	public String getHeuristicType() {
		return heuristicType;
	}
	public void setHeuristicType(String heuristicType) {
		this.heuristicType = heuristicType;
	}
	public String getFaultName() {
		return faultName;
	}
	public void setFaultName(String faultName) {
		this.faultName = faultName;
	}
	public int getProgramVersion() {
		return programVersion;
	}
	public void setProgramVersion(int programVersion) {
		this.programVersion = programVersion;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getFaultyPackage() {
		return faultyPackage;
	}
	public void setFaultyPackage(String faultyPackage) {
		this.faultyPackage = faultyPackage;
	}
	public String getFaultyClass() {
		return faultyClass;
	}
	public void setFaultyClass(String faultyClass) {
		this.faultyClass = faultyClass;
	}
	public String getFaultyMethod() {
		return faultyMethod;
	}
	public void setFaultyMethod(String faultyMethod) {
		this.faultyMethod = faultyMethod;
	}
	public int getFaultyBlock() {
		return faultyBlock;
	}
	public void setFaultyBlock(int faultyBlock) {
		this.faultyBlock = faultyBlock;
	}
	public int getInpectedMethods() {
		return icdInspectedMethods;
	}
	public void setInpectedMethods(int inpectedMethods) {
		this.icdInspectedMethods = inpectedMethods;
	}
	public double getMcpScore() {
		return mcpScore;
	}
	public void setMcpScore(double mcpScore) {
		this.mcpScore = mcpScore;
	}
	public double getBlockListScore() {
		return blockListScore;
	}
	public void setBlockListScore(double blockListScore) {
		this.blockListScore = blockListScore;
	}
	public Map<Integer, Integer> getBlocksPerDelta() {
		return icdInspectedBlocksPerDelta;
	}
	public void setBlocksPerDelta(Map<Integer, Integer> blocksPerDelta) {
		this.icdInspectedBlocksPerDelta = blocksPerDelta;
	}
	public int getBlockListInspectedBlocks() {
		return blockListInspectedBlocks;
	}
	public void setBlockListInspectedBlocks(int blockListInspectedBlocks) {
		this.blockListInspectedBlocks = blockListInspectedBlocks;
	}
	public Map<Integer, Integer> getFaultsFoundPerBudget() {
		return faultsFoundPerBudget;
	}
	public void setFaultsFoundPerBudget(Map<Integer, Integer> faultsFoundPerBudget) {
		this.faultsFoundPerBudget = faultsFoundPerBudget;
	}
	public List<String> getInspectionLog() {
		return inspectionLog;
	}
	public void setInspectionLog(List<String> inspectionLog) {
		this.inspectionLog = inspectionLog;
	}
	
	
}
