package br.usp.each.dci;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.bcel.classfile.ClassFormatException;
import org.apache.bcel.classfile.ClassParser;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.LineNumberTable;
import org.apache.bcel.classfile.Method;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.generationjava.io.CsvWriter;

import br.usp.each.inss.RequirementExport;
import br.usp.each.opal.requirement.MethodCallPair;
import br.usp.each.opal.requirement.RequirementType;

public class MethodCallPairRequirementCoverageExportRMCP implements RequirementExport {
	
	private List<MethodCallPairRequirementCoverage> listRequirements;
	private RequirementType requirementType;
	private HeuristicType heuristicType;
	private File classesDirectory;
	private int position;
	private ListPosition listPosition;
	
	public MethodCallPairRequirementCoverageExportRMCP(List<MethodCallPairRequirementCoverage> lstRequirements, RequirementType reqType, HeuristicType heurType, File classDir) {
        this.listRequirements = lstRequirements;
        this.requirementType = reqType;
        this.heuristicType = heurType;
        this.classesDirectory = classDir;
        this.position = 1;
        listPosition = new ListPosition();
        listPosition.insertAbsolutePositionMCP(listRequirements);
    }
	
	@Override
	public byte[] export() throws IOException {

        Document doc = DocumentHelper.createDocument();
        doc.setXMLEncoding("ISO-8859-1");
        doc.addElement("FaultClassification-MethodCallPair");

        doRMCPList(doc);
        
        return doc.asXML().getBytes();
	}

	private void doRMCPList(Document doc){
		Map<String,Double> mapMCP = listPosition.getMCPMethodList(listRequirements);
		
		Element element = doc.getRootElement();
    	element.addAttribute("project", "fault localization");
    	Element elem = element.addElement("test-criteria").addAttribute("requirement-type", "RMCP");
    	
    	Set<String> setMethod = mapMCP.keySet();
		
		for(String mcpMethodName : setMethod)
		{
			elem.addElement("method").addAttribute("name", mcpMethodName)
									.addAttribute("suspicious", String.valueOf(mapMCP.get(mcpMethodName)))
									.addAttribute("position",String.valueOf(position++));
		}
		
	}
	 
	
}
