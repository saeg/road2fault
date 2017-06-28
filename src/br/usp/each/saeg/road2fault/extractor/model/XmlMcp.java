package br.usp.each.saeg.road2fault.extractor.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pair")
public class XmlMcp {
	private int callerId;
	private String callerName;
	private String callerClass;
	private int calleeId;
	private String calleeName;
	private String calleeClass;
	private double score;
	
	public int getCallerId() {
		return callerId;
	}
	public void setCallerId(int callerId) {
		this.callerId = callerId;
	}
	
	@XmlAttribute(name="from-method")
	public String getCallerName() {
		return callerName;
	}
	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}
	
	@XmlAttribute(name="class")
	public String getCallerClass() {
		return callerClass;
	}
	public void setCallerClass(String callerClass) {
		this.callerClass = callerClass;
	}
	public int getCalleeId() {
		return calleeId;
	}
	public void setCalleeId(int calleeId) {
		this.calleeId = calleeId;
	}
	
	@XmlAttribute(name="to-method")
	public String getCalleeName() {
		return calleeName;
	}
	public void setCalleeName(String calleeName) {
		this.calleeName = calleeName;
	}
	
	@XmlAttribute(name="to-class")
	public String getCalleeClass() {
		return calleeClass;
	}
	public void setCalleeClass(String calleeClass) {
		this.calleeClass = calleeClass;
	}
	
	@XmlAttribute(name="suspicious")
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	public void parseNameAndId(){
		this.callerId = Integer.parseInt(this.getCallerName().substring(0, this.getCallerName().indexOf(":")));
		this.callerName = this.getCallerName().substring(this.getCallerName().indexOf(":")+2);
		this.calleeId = Integer.parseInt(this.getCalleeName().substring(0, this.getCalleeName().indexOf(":")));
		this.calleeName = this.getCalleeName().substring(this.getCalleeName().indexOf(":")+2);
	}
	
	public void updateConstructorMethodName(){
		if(this.getCallerName().startsWith("<init>")){
			String signature = this.getCallerName().substring(this.getCallerName().indexOf("("));
			this.setCallerName(this.callerClass.substring(this.callerClass.lastIndexOf(".")+1)+signature);
		}
		if(this.getCalleeName().startsWith("<init>")){
			String signature = this.getCalleeName().substring(this.getCalleeName().indexOf("("));
			this.setCalleeName(this.calleeClass.substring(this.calleeClass.lastIndexOf(".")+1)+signature);
		}
	}
}
