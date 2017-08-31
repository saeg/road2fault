package br.usp.each.saeg.road2fault.extractor.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "test-criteria")
public class XmlMcpTestCriteria {
	
	private String requirementType;
	private List<XmlMcp> mcpMethodList = new ArrayList<XmlMcp>();
	private List<McpMethod> roadmap = new ArrayList<McpMethod>();
	private FaultInfo faultInfo;
	private MultipleFaultInfo multipleFaultInfo;
	
	public void setRoadmap(List<McpMethod> roadmap) {
		this.roadmap = roadmap;
	}
	@XmlAttribute(name="requirement-type")
	public String getRequirementType() {
		return requirementType;
	}
	public void setRequirementType(String requirementType) {
		this.requirementType = requirementType;
	}
	
	@XmlElement(name="pair")
	public List<XmlMcp> getMcpMethodList() {
		return mcpMethodList;
	}
	public void setMcpMethodList(List<XmlMcp> mcpMethodList) {
		this.mcpMethodList = mcpMethodList;
	}
	
	public List<McpMethod> getRoadmap() {
		return roadmap;
	}
	
	public void updateMcpMethodList(){
		for(XmlMcp mcp : mcpMethodList){
			mcp.parseNameAndId();
			mcp.updateConstructorMethodName();
		}
	}
	
	public void createRoadmap(){
		for(XmlMcp mcp : mcpMethodList){
			if(!mcp.getCallerClass().equals("0.TestCase.Sentinella")){
				if(!isInRoadmap(mcp.getCallerName())){
				//if(!isInRoadmap(mcp.getCallerName(),mcp.getCallerClass())){////to differ methods from distinct classes
					McpMethod newMethod = new McpMethod();
					newMethod.setName(mcp.getCallerName());
					newMethod.setScore(mcp.getScore());
					newMethod.setClassName(mcp.getCallerClass());
					roadmap.add(newMethod);
				}
			}
			if(!mcp.getCalleeClass().equals("0.TestCase.Sentinella")){
				if(!isInRoadmap(mcp.getCalleeName())){
				//if(!isInRoadmap(mcp.getCalleeName(),mcp.getCalleeClass())){////to differ methods from distinct classes
					McpMethod newMethod = new McpMethod();
					newMethod.setName(mcp.getCalleeName());
					newMethod.setScore(mcp.getScore());
					newMethod.setClassName(mcp.getCalleeClass());
					roadmap.add(newMethod);
				}
			}
		}
	}
	
	private boolean isInRoadmap(String methodName) {
		for(McpMethod method : roadmap){
			if(methodName.equals(method.getName())){
					return true;
			}
		}
		return false;
	}
	
	//to differ methods from distinct classes
	private boolean isInRoadmap(String methodName, String className) {
		for(McpMethod method : roadmap){
			if(methodName.equals(method.getName()) && className.equals(method.getClassName())){
					return true;
			}
		}
		return false;
	}
	
	public FaultInfo getFaultInfo() {
		return faultInfo;
	}
	public void setFaultInfo(FaultInfo faultInfo) {
		this.faultInfo = faultInfo;
	}
	
	public void setMultipleFaultyInfo(MultipleFaultInfo faultyInfo) {
		this.multipleFaultInfo = faultyInfo;
	}
	
	public void markAsFault(){
		for(McpMethod method : roadmap){
			if(faultInfo.getFaultyMethod().equals(method.getName())){
				method.setFault();
			}
		}
	}
	
	public void markAsMultipleFault(){
		for(McpMethod method : roadmap){
			for(int i = 0; i < multipleFaultInfo.getNumberOfFaults();i++){
				if(multipleFaultInfo.getFaultyMethod(i).equals(method.getName())){
					method.setFault();
				}
			}
		}
	}

	public void markAsFaultSignatureClass(){
		for(McpMethod method : roadmap){
			if(faultInfo.getFaultyMethod().equals(method.getName()) && faultInfo.getFaultyClass().equals(method.getClassName())){
				method.setFault();
			}
		}
	}
	
	public double getMcpFaultyMethodScore(){
		for(McpMethod method : roadmap){
			if(method.isFault()){
				return method.getScore();
			}
		}
		return 0.0;
	}
	
	//when methods with same name/signature are in the roadmap get the maximum value among them
	public double getMcpFaultyMethodScoreMax(String methodName){
		double maxScore = 0.0;
		for(XmlMcp mcp : mcpMethodList){
			if(mcp.getCallerName().substring(0, mcp.getCallerName().indexOf("(")+1).equals(methodName.substring(0, methodName.indexOf("(")+1))){
				if(mcp.getScore() > maxScore){
					maxScore = mcp.getScore();
				}
			}
			if(mcp.getCalleeName().substring(0, mcp.getCalleeName().indexOf("(")+1).equals(methodName.substring(0, methodName.indexOf("(")+1))){
				if(mcp.getScore() > maxScore){
					maxScore = mcp.getScore();
				}
			}
		}
		return maxScore;
	}
	
}
