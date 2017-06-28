package br.usp.each.saeg.road2fault.extractor.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "test-criteria")
public class XmlBLTestCriteria {
	
	private String requirementType;
	private double score;
	private List<XmlBLBlock> blockList = new ArrayList<XmlBLBlock>();
		
	@XmlAttribute(name="requirement-type")
    public String getRequirementType() {
		return requirementType;
	}
	public void setRequirementType(String requirementType) {
		this.requirementType = requirementType;
	}
	
	@XmlAttribute(name="suspicious-value")
    public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	@XmlElement(name="requirement")
    public List<XmlBLBlock> getBLBlockList() {
		return blockList;
	}
	public void setBLBlockList(List<XmlBLBlock> blockList) {
		this.blockList = blockList;
	}
	
	public void updateBLMethodList(){
		for(XmlBLBlock block : blockList){
			block.updateMethodName();
		}
	}
	
}
