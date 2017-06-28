package br.usp.each.saeg.road2fault.extractor.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FaultClassification")
public class XmlMcpReportFile {
	
		private String project;
		private XmlMcpTestCriteria testCriteria;
		
		@XmlAttribute
		public String getProject() {
			return project;
		}

		public void setProject(String project) {
			this.project = project;
		}

		@XmlElement(name = "test-criteria")
		public XmlMcpTestCriteria getTestCriteria() {
			return testCriteria;
		}

		public void setTestCriteria(XmlMcpTestCriteria testCriteria) {
			this.testCriteria = testCriteria;
		}

}
