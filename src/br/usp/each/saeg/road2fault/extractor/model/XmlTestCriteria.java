package br.usp.each.saeg.road2fault.extractor.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "test-criteria")
public class XmlTestCriteria {
	
	private String requirementType;
	private String heuristicType;
	private List<XmlPackage> packages;
	private FaultInfo faultInfo;
	private MultipleFaultInfo multipleFaultInfo;
	
	
	@XmlAttribute(name = "heuristic-type")
	public String getHeuristicType() {
		return heuristicType;
	}

	public void setHeuristicType(String heuristicType) {
		this.heuristicType = heuristicType;
	}

	@XmlAttribute(name = "requirement-type")
	public String getRequirementType() {
		return requirementType;
	}

	public void setRequirementType(String requirementType) {
		this.requirementType = requirementType;
	}

	@XmlElement(name = "package")
	public List<XmlPackage> getPackages() {
		return packages;
	}

	public void setPackages(List<XmlPackage> packageSet) {
		this.packages = packageSet;
	}
	
	public XmlPackage getPackageByName(String packageName){
		for(XmlPackage pack : packages){
			if(pack.getName().equals(packageName)){
				return pack;
			}
		}
		return null;
	}
	
	public FaultInfo getFaultyInfo() {
		return faultInfo;
	}

	public void setFaultyInfo(FaultInfo faultyInfo) {
		this.faultInfo = faultyInfo;
	}

	public void setMultipleFaultyInfo(MultipleFaultInfo faultyInfo) {
		this.multipleFaultInfo = faultyInfo;
	}

	public void markAsFault(){
		
		XmlPackage pkg = getPackageByName(faultInfo.getFaultyPackage());
		XmlClass clz = pkg.getClassByName(faultInfo.getFaultyClass());
		XmlMethod method = clz.getMethodByName(faultInfo.getFaultyMethod());
		method.setFault();
		XmlBlock block = method.getBlockById(faultInfo.getFaultyBlock());
		block.setFault();
		
	}
	
	public void markAsMultipleFault(){
		
		for(int i = 0; i < multipleFaultInfo.getNumberOfFaults();i++){
			XmlPackage pkg = getPackageByName(multipleFaultInfo.getFaultyPackage(i));
			XmlClass clz = pkg.getClassByName(multipleFaultInfo.getFaultyClass(i));
			XmlMethod method = clz.getMethodByName(multipleFaultInfo.getFaultyMethod(i));
			method.setFault();
			XmlBlock block = method.getBlockById(multipleFaultInfo.getFaultyBlock(i));
			block.setFault();
		}
		
	}
	
	public void updateMethodList(){
		for(XmlPackage pack : packages){
			for(XmlClass clz : pack.getClasses()){
				for(XmlMethod method : clz.getMethods()){
					method.updateSignatureMethodName(clz.getName());
					method.setClassName(clz.getName());
				}
			}
		}
    }
	
	public double getFaultyBlockScore(){
		XmlPackage pkg = getPackageByName(faultInfo.getFaultyPackage());
		XmlClass clz = pkg.getClassByName(faultInfo.getFaultyClass());
		XmlMethod method = clz.getMethodByName(faultInfo.getFaultyMethod());
		XmlBlock block = method.getBlockById(faultInfo.getFaultyBlock());
		return block.getScore();
	}
	
	public double getMaxBlockScore(){
		XmlPackage pkg = getPackageByName(faultInfo.getFaultyPackage());
		XmlClass clz = pkg.getClassByName(faultInfo.getFaultyClass());
		XmlMethod method = clz.getMethodByName(faultInfo.getFaultyMethod());
		return method.getScore();
	}
	
	public int getTotalExecutedBlocks(){
		int blocks=0;
		for(XmlPackage pack : packages){
			for(XmlClass clz : pack.getClasses()){
				for(XmlMethod method : clz.getMethods()){
					blocks+=method.getBlocks().size();
				}
			}
		}
		return blocks;
	}
	
	public int getTotalExecutedMethods(){
		int methods=0;
		for(XmlPackage pack : packages){
			for(XmlClass clz : pack.getClasses()){
				methods+=clz.getMethods().size();
			}
		}
		return methods;
	}
	
}
