package br.usp.each.saeg.road2fault.extractor.model;

public class FaultInfo {
	
	private String filePath;
	private String faultName;
	private int programVersion;
	private String programName;
	private String faultyPackage;
	private String faultyClass;
	private String faultyMethod;
	private int faultyBlock;
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
}
