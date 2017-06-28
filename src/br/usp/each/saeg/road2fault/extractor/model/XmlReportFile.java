package br.usp.each.saeg.road2fault.extractor.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FaultClassification")
public class XmlReportFile {
	
		private String project;
		private XmlTestCriteria testCriteria;
		
		@XmlAttribute
		public String getProject() {
			return project;
		}

		public void setProject(String project) {
			this.project = project;
		}

		@XmlElement(name = "test-criteria")
		public XmlTestCriteria getTestCriteria() {
			return testCriteria;
		}

		public void setTestCriteria(XmlTestCriteria testCriteria) {
			this.testCriteria = testCriteria;
		}
	
}
