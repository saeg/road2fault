package br.usp.each.saeg.road2fault.extractor.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "class")
public class XmlClass {
	
	private String name;
 	private int location = 0;
    private double score = 0.0;
    private int number;
    private List<XmlMethod> methods = new ArrayList<XmlMethod>();
    
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

    @XmlElement(name="method")
    public List<XmlMethod> getMethods() {
        return methods;
    }
    
    public void setMethods(List<XmlMethod> methods) {
        this.methods = methods;
    }
    
    public XmlMethod getMethodByName(String methodName){
		for(XmlMethod method : methods){
			if(method.getName().equals(methodName)){
				return method;
			}
		}
		return null;
	}
    
    //methods with different signature
    public List<XmlMethod> getMethodsWithSameName(String methodName){
    	List<XmlMethod> methodsWithEqualName = new ArrayList<XmlMethod>();
		for(XmlMethod method : methods){
			if(method.getName().substring(0, method.getName().indexOf("(")+1).equals(methodName.substring(0, methodName.indexOf("(")+1))){
				methodsWithEqualName.add(method);
			}
		}
		return methodsWithEqualName;
	}
    
}
