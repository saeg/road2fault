package br.usp.each.saeg.road2fault.extractor.model;

import java.util.ArrayList;
import java.util.List;

public class MultipleFaultInfo {
	
	private String faultName;
	private int programVersion;
	private String programName;
	private List<String> filePath;
	private List<String> faultyPackage;
	private List<String> faultyClass;
	private List<String> faultyMethod;
	private List<Integer> faultyMethodId;
	private List<Integer> faultyBlock;
	
	public MultipleFaultInfo(){
		faultyPackage = new ArrayList<String>();
		faultyClass = new ArrayList<String>();
		faultyMethod = new ArrayList<String>();
		faultyMethodId = new ArrayList<Integer>();
		faultyBlock = new ArrayList<Integer>();
	}
	
	public String getFilePath(int index) {
		return this.filePath.get(index);
	}

	public void setFilePath(String filePath) {
		this.filePath.add(filePath);
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

	public String getFaultyPackage(int index) {
		return this.faultyPackage.get(index);
	}

	public void setFaultyPackage(String faultyPackage) {
		this.faultyPackage.add(faultyPackage);
	}

	public String getFaultyClass(int index) {
		return this.faultyClass.get(index);
	}

	public void setFaultyClass(String faultyClass) {
		this.faultyClass.add(faultyClass);
	}

	public String getFaultyMethod(int index) {
		return this.faultyMethod.get(index);
	}

	public void setFaultyMethod(String faultyMethod) {
		this.faultyMethod.add(faultyMethod);
	}

	public String getFaultyMethodId(int index) {
		return this.faultyMethod.get(index);
	}

	public void setFaultyMethodId(int faultyMethodId) {
		this.faultyMethodId.add(faultyMethodId);
	}

	public int getFaultyBlock(int index) {
		return this.faultyBlock.get(index);
	}

	public void setFaultyBlock(int faultyBlock) {
		this.faultyBlock.add(faultyBlock);
	}
	
	public int getNumberOfFaults(){
		return faultyBlock.size();
	}
}
