package br.usp.each.saeg.road2fault.extractor.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "method")
public class XmlMethod  implements Comparable<XmlMethod> {
	
	private int id;
	private String name;
 	private int location = 0;
    private double score = 0.0;
    private int number;
    private List<XmlBlock> blocks = new ArrayList<XmlBlock>();
    private boolean fault = false;
    private String className;
    
    @XmlAttribute(name="id")
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @XmlAttribute(name="name")
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name="suspicious-value")
    public double getScore() {
        return score;
    }
    
    public void setScore(double score) {
        this.score = score;
    }
    
    @XmlAttribute(name="number")
    public int getNumber() {
        return number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    @XmlAttribute(name="location")
    public int getLocation() {
        return location;
    }
    public void setLocation(int location) {
        this.location = location;
    }

    @XmlElement(name="requirement")
    public List<XmlBlock> getBlocks() {
        return blocks;
    }
    
    public void setBlocks(List<XmlBlock> blocks) {
        this.blocks = blocks;
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
    
    public void updateSignatureMethodName(String className){
    	if(this.getName().startsWith("<init>")){
	    	String signature = this.getName().substring(this.getName().indexOf("("));
			this.setName(className.substring(className.lastIndexOf(".")+1)+signature);
    	}
    }
    
    public XmlBlock getBlockById(int blockId){
		for(XmlBlock block : blocks){
			if(block.getId() == blockId){
				return block;
			}
		}
		return null;
	}

	@Override
	public int compareTo(XmlMethod otherMethod) {
		int compare = 0;
		if(otherMethod.score < this.score)
		{
			compare = -1;
		}
		else if(otherMethod.score > this.score)
		{
			compare = 1;
		}
		if(otherMethod.score == this.score)
		{
			if(otherMethod.number > this.number){
				compare = -1;
			}
			else if(otherMethod.number < this.number){
				compare = 1;
			}
			if(otherMethod.number == this.number)
			{
				if(otherMethod.id < this.id){
					compare = -1;
				}
				else{
					compare = 1;
				}
			}
		}
		return compare;
	}

}
