package br.usp.each.saeg.road2fault.extractor.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

public class XmlBlock {
	private int id;
 	private int location = 0;
    private double score = 0.0;
    private boolean fault = false;
    
    @XmlAttribute(name="name")
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @XmlAttribute(name="suspicious-value")
    public double getScore() {
        return score;
    }
    
    public void setScore(double score) {
        this.score = score;
    }
    
    @XmlAttribute(name="location")
    public int getLocation() {
        return location;
    }
    public void setLocation(int location) {
        this.location = location;
    }
    
    public boolean isFault(){
    	return fault;
    }
    
    public void setFault(){
    	fault = true;
    }
}
