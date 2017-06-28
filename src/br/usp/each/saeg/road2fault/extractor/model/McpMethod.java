package br.usp.each.saeg.road2fault.extractor.model;

public class McpMethod {
	private String name;
	private double score;
	private boolean fault;
	private String className;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public boolean isFault(){
    	return fault;
    }
    
    public void setFault(){
    	fault = true;
    }
    
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
}
