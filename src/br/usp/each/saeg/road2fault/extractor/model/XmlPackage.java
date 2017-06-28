package br.usp.each.saeg.road2fault.extractor.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "package")
public class XmlPackage implements Comparable<XmlPackage>{
	
	 	private String name;
	 	private int location = 0;
	    private double score = 0.0;
	    private int number;
	    private List<XmlClass> classes = new ArrayList<XmlClass>();
	    
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

	    @XmlElement(name="class")
	    public List<XmlClass> getClasses() {
	        return classes;
	    }
	    
	    public void setClasses(List<XmlClass> classes) {
	        this.classes = classes;
	    }

		@Override
		public int compareTo(XmlPackage other) {
			if (this.score > other.score) {
				return -1;
			} else if (this.score < other.score) {
				return 1;
			}
			return 0;
		}
		
		public XmlClass getClassByName(String className){
			for(XmlClass clz : classes){
				if(clz.getName().equals(className)){
					return clz;
				}
			}
			return null;
		}
}
