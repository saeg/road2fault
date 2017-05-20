package br.usp.each.saeg.road2fault;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

import br.usp.each.commons.logger.Log;
import br.usp.each.opal.requirement.RequirementType;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class RoadmapMCP{

	
	private static final Log log = new Log(RoadmapMCP.class);
    private static final Options options;
    private static final HelpFormatter formatter;
    
    private static Map<String,String> rMcpMap;
    public static File unitFile;
    public static File rMcpFile;
	
    //private 
    public static List<MethodCallPairRequirementCoverage> listRequirementsBySuspiciousness;

    //private 
    public static int totalTestCases = 0;
    //private 
    public static int actualTestCase = 0;
		
    //private 
    public static boolean []failedTestCases;
	
    //private 
    public static RequirementType requirementType;
	
    //private
    public static HeuristicType heuristicType;
	
    //private
    public static ListType listType;
    
    private static final ParseException INVALID_FILE_EXCEPTION = new ParseException("read <file> may be a valid file.");

        
	public RoadmapMCP(){
	}
	
	static {
        @SuppressWarnings("static-access")
        Option unit = OptionBuilder.withArgName("ufile")
        						   .withLongOpt("unit-file")
        						   .hasArg()
        						   .withDescription("file with unit requirements")
        						   .isRequired()
        						   .create("uf");

        @SuppressWarnings("static-access")
        Option rmcp = OptionBuilder.withArgName("mcpfile")
        						 .withLongOpt("mcp-file")
        						 .hasArg()
        						 .withDescription("file with rmcp")
        						 .create("rf");
        options = new Options();
        options.addOption(unit);
        options.addOption(rmcp);
        formatter = new HelpFormatter();
    }

	public static void main(String[] args) throws IOException {
        
    	// create the parser
        CommandLineParser parser = new GnuParser();
		//CommandLineParser parser = new BasicParser();
    	try {
            CommandLine line = parser.parse(options, args);
            
            try {
            	
            	//unitFile = new File(line.getOptionValue("unit-file"));
            	//rMcpFile = new File(line.getOptionValue("mcp-file"));
            	
            	String sunitFile = line.getOptionValue("unit-file");
            	String srMcpFile = line.getOptionValue("mcp-file");
            	
            	
            	fillRMcpMap(srMcpFile);
            	readXmlPackage(sunitFile);
                     
                System.out.println("End");
                
            } 
            catch (Exception e) {
            	e.printStackTrace();
                //throw INVALID_FILE_EXCEPTION;
            }
        } catch (ParseException exp) {
        	log.info("Failed!  Reason: " + exp.getMessage());
            formatter.printHelp("Requirement", options);
            System.out.println(exp.getMessage());
        }
    }
	
	
	///////////////////////////////////////////////////////////
	
	public static void readXmlPackage(String sunitFile) throws SAXException, IOException, ParserConfigurationException{
		
		unitFile = new File(sunitFile);
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	Document oldDoc = dBuilder.parse(unitFile);
    	
    	oldDoc.getDocumentElement().normalize();
    	
    	//Element testCriteria = oldDoc.getElementById("test-criteria");
    	
    	Document newDoc = createNewXml();
    	
    	Node novo = newDoc.getFirstChild();
    	
    	NodeList nodeList = oldDoc.getElementsByTagName("package");
    	
    	for(int pac= 0; pac < nodeList.getLength(); pac++){
    		
    		Node nodePack = nodeList.item(pac);
    		NodeList nodeListClass = nodePack.getChildNodes();
    		
    		for(int clas=0; clas < nodeListClass.getLength(); clas++){
    			
    			Node nodeClas = nodeListClass.item(clas);
    			NodeList nodeListMethod = nodeClas.getChildNodes();
    			
    			for(int met=0; met < nodeListMethod.getLength(); met++){
    				
    				Node nodeMethod = nodeListMethod.item(met);
    				
    				Element elMethod = (Element) nodeMethod;
    				
    				String attrName = elMethod.getAttribute("name");
    				attrName = attrName.substring(0, attrName.indexOf("(")+1);
    				String pos = rMcpMap.get(attrName);
    				if(pos == null){
    					pos = "0";
    				}
    				elMethod.setAttribute("position",pos);
    				
    				//NodeList nodeListReq = nodeMethod.getChildNodes();
    				nodeClas.replaceChild(elMethod,nodeMethod);
    				//nodeClas.appendChild(elMethod);
    			}
    			
    			//nodePack.appendChild(nodeClas);
    			nodePack.replaceChild(nodeClas, nodeClas);
    		}
    		
    		//oldDoc.getFirstChild().getFirstChild().appendChild(nodePack);
    		oldDoc.getFirstChild().getFirstChild().replaceChild(nodePack, nodePack);
    		
    	}
    	
    	createXmlFile(oldDoc,unitFile);
		
	}
	
	
	
	private static void createXmlFile(Document newDoc, File unitFile) {
		try{
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			DOMSource domSource = new DOMSource(newDoc);
			StreamResult stream = new StreamResult(new File("new_"+unitFile.getName()));
			transformer.transform(domSource,stream);
			System.out.println("New list created");
		}
		catch(TransformerException tfe){
			tfe.printStackTrace();
		}
	}


	public static Document createNewXml() throws ParserConfigurationException{
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.newDocument();
		Element root = doc.createElement("FaultClassification");
		Attr rootAttr = doc.createAttribute("project");
		rootAttr.setValue("fault localization");
		root.setAttributeNode(rootAttr);
		doc.appendChild(root);
		
		Element testCriteria = doc.createElement("test-criteria");
		Attr reqTypeAttr = doc.createAttribute("requirement-type");
		Attr heurTypeAttr = doc.createAttribute("heuristic-type");
		reqTypeAttr.setValue("NODE");
		heurTypeAttr.setValue("DRT");
		testCriteria.setAttributeNode(reqTypeAttr);
		testCriteria.setAttributeNode(heurTypeAttr);
		
		root.appendChild(testCriteria);
		
		return doc;
		
	}
	
	
	public static void fillRMcpMap(String srMcpFile){
		
		rMcpFile = new File(srMcpFile);
		
		rMcpMap = new HashMap<String,String>();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document rMcpDoc;
			rMcpDoc = dBuilder.parse(rMcpFile);
			rMcpDoc.getDocumentElement().normalize();
	    	
	    	NodeList nodeList = rMcpDoc.getElementsByTagName("method");
	    	
	    	for(int item= 0; item < nodeList.getLength(); item++){
	    		
	    		Node node = nodeList.item(item);
	    		Element method = (Element) node;
	    		
	    		rMcpMap.put(method.getAttribute("name"),method.getAttribute("position"));
	    	}
	    	System.out.println("Map size:"+rMcpMap.size());
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
