package br.usp.each.saeg.road2fault.extractor.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FaultClassification")	
public class XmlBLReportFile {
	
			private String project;
			private List<XmlBLTestCriteria> blockListTestCriteriaList = new ArrayList<XmlBLTestCriteria>();
			private String heuristic;
			private FaultInfo faultInfo;
			private MultipleFaultInfo multipleFaultInfo;
			
			@XmlAttribute
			public String getProject() {
				return project;
			}

			public void setProject(String project) {
				this.project = project;
			}

			@XmlElement(name = "test-criteria")
			public List<XmlBLTestCriteria> getBLTestCriteriaList() {
				return blockListTestCriteriaList;
			}

			public void setBLTestCriteriaList(
					List<XmlBLTestCriteria> blockListTestCriteriaList) {
				this.blockListTestCriteriaList = blockListTestCriteriaList;
			}

			public String getHeuristic() {
				return heuristic;
			}

			public void setHeuristic(String heuristic) {
				this.heuristic = heuristic;
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
				for(XmlBLTestCriteria blCriteria : blockListTestCriteriaList){
					for(XmlBLBlock block : blCriteria.getBLBlockList()){
						if(block.getClassName().equals(faultInfo.getFaultyClass()) && 
								block.getMethodName().equals(faultInfo.getFaultyMethod()) && 
								block.getBlockId() == faultInfo.getFaultyBlock()){
							System.out.println("fault block : "+block.getMethodName());
							block.setFault();
						}
					}
				}
			}
			
			public void markAsMultipleFault(){
				for(XmlBLTestCriteria blCriteria : blockListTestCriteriaList){
					for(XmlBLBlock block : blCriteria.getBLBlockList()){
						for(int i = 0; i < multipleFaultInfo.getNumberOfFaults();i++){
							if(block.getClassName().equals(multipleFaultInfo.getFaultyClass(i)) && 
									block.getMethodName().equals(multipleFaultInfo.getFaultyMethod(i)) && 
									block.getBlockId() == multipleFaultInfo.getFaultyBlock(i)){
								System.out.println("fault block : "+block.getMethodName());
								block.setFault();
							}
						}
					}
				}
			}
}
