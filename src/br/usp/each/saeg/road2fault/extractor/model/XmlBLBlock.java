package br.usp.each.saeg.road2fault.extractor.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "requirement")
public class XmlBLBlock {
		
	private String className;
	private int methodId;
	private String methodName;
	private int blockId;
	private int location = 0;
    private double score = 0.0;
    private boolean fault = false;
    
    @XmlAttribute(name="class")
    public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	@XmlAttribute(name="method-id")
	public int getMethodId() {
		return methodId;
	}
	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}
	
	@XmlAttribute(name="method")
	public String getMethodName() {
		return methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	@XmlAttribute(name="requirement")
	public int getBlockId() {
		return blockId;
	}
	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	
	@XmlAttribute(name="location")
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	
	@XmlAttribute(name="suspicious")
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
    
	public void updateMethodName(){
    	if(this.methodName.startsWith("<init>")){
	    	String signature = this.methodName.substring(this.methodName.indexOf("("));
			this.setMethodName(className.substring(className.lastIndexOf(".")+1)+signature);
    	}
    }
    
}
