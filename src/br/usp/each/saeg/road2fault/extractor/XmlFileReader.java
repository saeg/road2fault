package br.usp.each.saeg.road2fault.extractor;

import java.io.File;

import javax.xml.bind.JAXB;

import br.usp.each.saeg.road2fault.extractor.model.XmlBLReportFile;
import br.usp.each.saeg.road2fault.extractor.model.XmlBLTestCriteria;
import br.usp.each.saeg.road2fault.extractor.model.XmlMcpReportFile;
import br.usp.each.saeg.road2fault.extractor.model.XmlMcpTestCriteria;
import br.usp.each.saeg.road2fault.extractor.model.XmlReportFile;
import br.usp.each.saeg.road2fault.extractor.model.XmlTestCriteria;

public class XmlFileReader {
	
	private XmlReportFile xmlReportFile;
	private XmlMcpReportFile xmlMcpReportFile;
	private XmlBLReportFile xmlBLReportFile;
	//private final File testFile = new File("/home/higor/workspace/commons-math-sir/codeforest.xml");
	
	public XmlTestCriteria readCodeHierarchyXmlFile(File file){
		xmlReportFile = JAXB.unmarshal(file, XmlReportFile.class);
		XmlTestCriteria criteria =  xmlReportFile.getTestCriteria();
		return criteria;
	}	
	public XmlMcpTestCriteria readMcpXmlFile(File file){
		xmlMcpReportFile = JAXB.unmarshal(file, XmlMcpReportFile.class);
		XmlMcpTestCriteria criteria =  xmlMcpReportFile.getTestCriteria();
		return criteria;
	}
	public XmlBLReportFile readBLXmlFile(File file){
		xmlBLReportFile = JAXB.unmarshal(file, XmlBLReportFile.class);
		return  xmlBLReportFile;
	}
}
