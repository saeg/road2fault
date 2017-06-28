package br.usp.each.saeg.road2fault.extractor;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.generationjava.io.CsvWriter;

import br.usp.each.saeg.road2fault.extractor.ChartGenerator.ChartType;
import br.usp.each.saeg.road2fault.extractor.model.FaultInfo;
import br.usp.each.saeg.road2fault.extractor.model.XmlBLReportFile;
import br.usp.each.saeg.road2fault.extractor.model.XmlBLTestCriteria;
import br.usp.each.saeg.road2fault.extractor.model.XmlMcpTestCriteria;
import br.usp.each.saeg.road2fault.extractor.model.XmlTestCriteria;

public class BatchExecutorLevelScore {
	
	private String PATHFILE;//="/home/higor/data/r2f/reports/";
	private final String FILE_NODE_BEGIN="list_dci_NODE_";
	private final String FILE_NODE_END = "_BY_REQUIREMENT.xml-debug";
	private final String FILE_MCP_BEGIN="list_dci_MCP_";
	private final String FILE_MCP_END = ".xml-debug";
	private final String FILE_CH_BEGIN ="list_dci_NODE_";
	private final String FILE_CH_END = "_BY_PACKAGE.xml-debug";
	private final String ALL_PROGRAMS = "all";
	private final String ANT = "ant";
	private final String COMMONS_MATH = "commons-math";
	private final String HSQLDB = "hsqldb";
	private final String JTOPAS = "jtopas";
	private final String PMD = "pmd";
	private final String XML_SECURITY = "xml-security";
	private final String XSTREAM = "xstream";
	private final String TARANTULA = "TARANTULA";
	private final String OCHIAI = "OCHIAI";
	private final int INFINITE = 10000;//to check the maximum number of method inspected
	private final double DELTA_VALUES[] = {0,1,3,5,7,10,15,20,25,30,35,40,45,50,75};
	private final int EFFORT_BUDGET_RANGES[] = {5,10,15,20,25,30,35,40,45,50,60,70,80,90,100};
	private final int METHOD_EFFORT_BUDGET_RANGES[] = {1,2,3,4,5,6,7,8,9,10,15,20,25,30,INFINITE};
	
	private List<List<String>> matrix = new ArrayList<List<String>>();
	private List<String> csvLineAbsBlocks = new ArrayList<String>();
	private List<String> csvLineAbsMethods = new ArrayList<String>();
	private List<String> logFileList = new ArrayList<String>();
	private int executedMethods;
	private int executedBlocks;
	
	private final double LEVEL_SCORES[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	
	public BatchExecutorLevelScore(String dirPath){
		PATHFILE = dirPath;
	}
	
	public void execute(){
		makeHeader();
		
		ant_v1_CLJ_HD_1(TARANTULA);
		ant_v1_PJH_AK_1(TARANTULA);
		ant_v2_CDJ_AK_1(TARANTULA);
		ant_v2_PH_HD_1(TARANTULA);
		ant_v3_TG_HD_1(TARANTULA);
		ant_v3_TG_HD_2(TARANTULA);
		ant_v4_DEW_AK_1(TARANTULA);
		ant_v4_EA_HD_1(TARANTULA);
		ant_v4_FLU_AK_1(TARANTULA);
		ant_v4_SFS_HD_1(TARANTULA);
		ant_v5_DEW_AK_1(TARANTULA);
		ant_v5_MNT_AK_1(TARANTULA);
		ant_v5_MST_AK_1(TARANTULA);
		ant_v5_PJ_HD_2(TARANTULA);
		ant_v6_MT_HD_1(TARANTULA);
		ant_v7_ACL_HD_2(TARANTULA);
		ant_v7_SLU_AK_1(TARANTULA);
		ant_v8_ZF_HD_1(TARANTULA);
		
		makeBudgets(TARANTULA,ANT);
		makeHeader();
		
		commonsMath_v1_C_AK_1(TARANTULA);
		commonsMath_v1_EDI_AK_1(TARANTULA);
		commonsMath_v1_F_AK_1(TARANTULA);
		commonsMath_v1_M_AK_1(TARANTULA);
		commonsMath_v1_VS_AK_1(TARANTULA);
		commonsMath_v2_ABI_AK_1(TARANTULA);
		commonsMath_v2_AE_AK_1(TARANTULA);
		commonsMath_v2_CDI_AK_1(TARANTULA);
		commonsMath_v2_CRVG_AK_1(TARANTULA);
		commonsMath_v2_F_AK_2(TARANTULA);
		commonsMath_v2_MU_AK_1(TARANTULA);
		commonsMath_v2_MU_AK_2(TARANTULA);
		commonsMath_v2_MU_AK_3(TARANTULA);
		commonsMath_v2_MU_AK_4(TARANTULA);
		commonsMath_v2_MU_AK_5(TARANTULA);
		commonsMath_v2_MU_AK_6(TARANTULA);
		commonsMath_v2_URSU_AK_1(TARANTULA);
		commonsMath_v3_BS_AK_1(TARANTULA);
		commonsMath_v3_ERKI_AK_1(TARANTULA);
		commonsMath_v3_RKI_AK_1(TARANTULA);
		
		makeBudgets(TARANTULA,COMMONS_MATH);
		makeHeader();
		
		hsqldb_v1_JDBCCF_AK_1(TARANTULA);
		hsqldb_v2_EL_AK_1(TARANTULA);
		hsqldb_v2_QS_AK_1(TARANTULA);
		hsqldb_v2_QS_AK_2(TARANTULA);
		
		makeBudgets(TARANTULA,HSQLDB);
		makeHeader();
		
		jtopas_v1_FAULT_5(TARANTULA);
		jtopas_v1_FAULT_6(TARANTULA);
		//jtopas_v2_FAULT_1(TARANTULA);
		jtopas_v3_FAULT_4(TARANTULA);
		
		makeBudgets(TARANTULA,JTOPAS);
		makeHeader();
		
		pmd_v3_RV_AK_1(TARANTULA);
		pmd_v3_XMLR_AK_1(TARANTULA);
		
		makeBudgets(TARANTULA,PMD);
		makeHeader();
		
		xmlSecurity_v1_CE_HD_3(TARANTULA);
		xmlSecurity_v1_CHP_AK_1(TARANTULA);
		xmlSecurity_v1_CN2_AK_2(TARANTULA);
		xmlSecurity_v1_CNC_AK_1(TARANTULA);
		xmlSecurity_v1_XSI_AK_1(TARANTULA);
		xmlSecurity_v2_C2E_AK_1(TARANTULA);
		xmlSecurity_v2_CB_HD_2(TARANTULA);
		xmlSecurity_v2_CB_HD_3(TARANTULA);
		xmlSecurity_v2_CH_HD_1(TARANTULA);
		xmlSecurity_v2_CHP_AK_1(TARANTULA);
		xmlSecurity_v2_RF_HD_2(TARANTULA);
		xmlSecurity_v3_RF_HD_1(TARANTULA);
		xmlSecurity_v3_XU_HD_2(TARANTULA);
		
		makeBudgets(TARANTULA,XML_SECURITY);
		makeHeader();
		
		xstream_v1_AM_AK_1(TARANTULA);
		
		makeBudgets(TARANTULA,XSTREAM);
		makeBudgets(TARANTULA,ALL_PROGRAMS);
		makeHeader();
		
		ant_v1_CLJ_HD_1(OCHIAI);
		ant_v1_PJH_AK_1(OCHIAI);
		ant_v2_CDJ_AK_1(OCHIAI);
		ant_v2_PH_HD_1(OCHIAI);
		ant_v3_TG_HD_1(OCHIAI);
		ant_v3_TG_HD_2(OCHIAI);
		ant_v4_DEW_AK_1(OCHIAI);
		ant_v4_EA_HD_1(OCHIAI);
		ant_v4_FLU_AK_1(OCHIAI);
		ant_v4_SFS_HD_1(OCHIAI);
		ant_v5_DEW_AK_1(OCHIAI);
		ant_v5_MNT_AK_1(OCHIAI);
		ant_v5_MST_AK_1(OCHIAI);
		ant_v5_PJ_HD_2(OCHIAI);
		ant_v6_MT_HD_1(OCHIAI);
		ant_v7_ACL_HD_2(OCHIAI);
		ant_v7_SLU_AK_1(OCHIAI);
		ant_v8_ZF_HD_1(OCHIAI);
		
		makeBudgets(OCHIAI,ANT);
		makeHeader();
		
		commonsMath_v1_C_AK_1(OCHIAI);
		commonsMath_v1_EDI_AK_1(OCHIAI);
		commonsMath_v1_F_AK_1(OCHIAI);
		commonsMath_v1_M_AK_1(OCHIAI);
		commonsMath_v1_VS_AK_1(OCHIAI);
		commonsMath_v2_ABI_AK_1(OCHIAI);
		commonsMath_v2_AE_AK_1(OCHIAI);
		commonsMath_v2_CDI_AK_1(OCHIAI);
		commonsMath_v2_CRVG_AK_1(OCHIAI);
		commonsMath_v2_F_AK_2(OCHIAI);
		commonsMath_v2_MU_AK_1(OCHIAI);
		commonsMath_v2_MU_AK_2(OCHIAI);
		commonsMath_v2_MU_AK_3(OCHIAI);
		commonsMath_v2_MU_AK_4(OCHIAI);
		commonsMath_v2_MU_AK_5(OCHIAI);
		commonsMath_v2_MU_AK_6(OCHIAI);
		commonsMath_v2_URSU_AK_1(OCHIAI);
		commonsMath_v3_BS_AK_1(OCHIAI);
		commonsMath_v3_ERKI_AK_1(OCHIAI);
		commonsMath_v3_RKI_AK_1(OCHIAI);
		
		makeBudgets(OCHIAI,COMMONS_MATH);
		makeHeader();
		
		hsqldb_v1_JDBCCF_AK_1(OCHIAI);
		hsqldb_v2_EL_AK_1(OCHIAI);
		hsqldb_v2_QS_AK_1(OCHIAI);
		hsqldb_v2_QS_AK_2(OCHIAI);
		
		makeBudgets(OCHIAI,HSQLDB);
		makeHeader();
		
		jtopas_v1_FAULT_5(OCHIAI);
		jtopas_v1_FAULT_6(OCHIAI);
		//jtopas_v2_FAULT_1(OCHIAI);
		jtopas_v3_FAULT_4(OCHIAI);
		
		makeBudgets(OCHIAI,JTOPAS);
		makeHeader();
		
		pmd_v3_RV_AK_1(OCHIAI);
		pmd_v3_XMLR_AK_1(OCHIAI);
		
		makeBudgets(OCHIAI,PMD);
		makeHeader();
		
		xmlSecurity_v1_CE_HD_3(OCHIAI);
		xmlSecurity_v1_CHP_AK_1(OCHIAI);
		xmlSecurity_v1_CN2_AK_2(OCHIAI);
		xmlSecurity_v1_CNC_AK_1(OCHIAI);
		xmlSecurity_v1_XSI_AK_1(OCHIAI);
		xmlSecurity_v2_C2E_AK_1(OCHIAI);
		xmlSecurity_v2_CB_HD_2(OCHIAI);
		xmlSecurity_v2_CB_HD_3(OCHIAI);
		xmlSecurity_v2_CH_HD_1(OCHIAI);
		xmlSecurity_v2_CHP_AK_1(OCHIAI);
		xmlSecurity_v2_RF_HD_2(OCHIAI);
		xmlSecurity_v3_RF_HD_1(OCHIAI);
		xmlSecurity_v3_XU_HD_2(OCHIAI);
		
		makeBudgets(OCHIAI,XML_SECURITY);
		makeHeader();
		
		xstream_v1_AM_AK_1(OCHIAI);
		
		makeBudgets(OCHIAI,XSTREAM);
		makeBudgets(OCHIAI,ALL_PROGRAMS);
		
		generateCSVFile();
		
		//generateCharts();
		//generateChartsForLevelScore();
		
	}
	
	public void calculatePerformance(XmlTestCriteria criteria,XmlMcpTestCriteria mcpCriteria, XmlBLReportFile blReportFile, FaultInfo faultInfo, String heuristic){
		csvLineAbsBlocks = new ArrayList<String>();
		csvLineAbsMethods = new ArrayList<String>();
		csvLineAbsBlocks.add(faultInfo.getProgramName());
		csvLineAbsBlocks.add(String.valueOf(faultInfo.getProgramVersion()));
		csvLineAbsBlocks.add(faultInfo.getFaultName());
		csvLineAbsBlocks.add(heuristic);
		csvLineAbsBlocks.add(String.valueOf(mcpCriteria.getMcpFaultyMethodScoreMax(faultInfo.getFaultyMethod())));
		csvLineAbsBlocks.add(String.valueOf(criteria.getFaultyBlockScore()));
		csvLineAbsBlocks.add(String.valueOf(criteria.getMaxBlockScore()));
		
		for(double delta : DELTA_VALUES){
			InspectionStrategyLevelScorePerMethod.calculateMcpPerformance(criteria, mcpCriteria, delta);
			csvLineAbsBlocks.add(String.valueOf(InspectionStrategyLevelScorePerMethod.inspectedBlocksInMcp));
			csvLineAbsMethods.add(String.valueOf(InspectionStrategyLevelScorePerMethod.inspectedMethodsInMcp));
			logFileList.addAll(InspectionStrategyLevelScorePerMethod.logFileList);
			InspectionStrategyLevelScorePerMethod.clear();
		}
		
		InspectionStrategyLevelScorePerMethod.calculateBlockListPerformance(blReportFile);
		csvLineAbsBlocks.add(String.valueOf(InspectionStrategyLevelScorePerMethod.inspectedBlocksInBL));
		logFileList.addAll(InspectionStrategyLevelScorePerMethod.logFileList);
		InspectionStrategyLevelScorePerMethod.clear();
		
		for(double delta : DELTA_VALUES){
			InspectionStrategyLevelScorePerMethod.calculateMethodHitSpectraPerformanceForBlocksAndDelta(criteria, delta);
			csvLineAbsBlocks.add(String.valueOf(InspectionStrategyLevelScorePerMethod.inspectedBlocksInMethodHitSpectra));
			csvLineAbsMethods.add(String.valueOf(InspectionStrategyLevelScorePerMethod.inspectedMethodsInMethodHitSpectra));
			logFileList.addAll(InspectionStrategyLevelScorePerMethod.logFileList);
			InspectionStrategyLevelScorePerMethod.clear();
		}
		generateLogFile(faultInfo,heuristic);
		csvLineAbsBlocks.add(faultInfo.getFaultName());
		csvLineAbsBlocks.addAll(csvLineAbsMethods);
		csvLineAbsBlocks.add(String.valueOf(executedBlocks));
		csvLineAbsBlocks.add(String.valueOf(executedMethods));
		matrix.add(csvLineAbsBlocks);
	}
	
	public void faultAnalysis(FaultInfo faultInfo, String heuristic){
		//csvLine = new ArrayList<String>();
		//String heuristicAbbr = heuristic.substring(0, 2);
		File fileCH = new File(PATHFILE+faultInfo.getProgramName()+"/"+"v"+faultInfo.getProgramVersion()+"_"+faultInfo.getFaultName()+"/"+FILE_CH_BEGIN+heuristic+FILE_CH_END);
		File fileMcp = new File(PATHFILE+faultInfo.getProgramName()+"/"+"v"+faultInfo.getProgramVersion()+"_"+faultInfo.getFaultName()+"/"+FILE_MCP_BEGIN+heuristic+FILE_MCP_END);
		File fileBL = new File(PATHFILE+faultInfo.getProgramName()+"/"+"v"+faultInfo.getProgramVersion()+"_"+faultInfo.getFaultName()+"/"+FILE_NODE_BEGIN+heuristic+FILE_NODE_END);
		XmlFileReader reader = new XmlFileReader();
		XmlTestCriteria criteria = reader.readCodeHierarchyXmlFile(fileCH);
		criteria.updateMethodList();
		criteria.setFaultyInfo(faultInfo);
		criteria.markAsFault();
		XmlMcpTestCriteria mcpCriteria = reader.readMcpXmlFile(fileMcp);
		mcpCriteria.updateMcpMethodList();
		mcpCriteria.createRoadmap();
		mcpCriteria.setFaultInfo(faultInfo);
		mcpCriteria.markAsFault();
		//mcpCriteria.markAsFaultSignatureClass();
		XmlBLReportFile blReportFile = reader.readBLXmlFile(fileBL);
		for(XmlBLTestCriteria blcriteria : blReportFile.getBLTestCriteriaList()){
			blcriteria.updateBLMethodList();
		}
		blReportFile.setFaultInfo(faultInfo);
		blReportFile.markAsFault();
		
		executedBlocks = criteria.getTotalExecutedBlocks();
		executedMethods = criteria.getTotalExecutedMethods();
		
		logFileList.add("########## Fault: "+faultInfo.getFaultName() + ", "+ heuristic  + ", program: "+ faultInfo.getProgramName() + ", v"+faultInfo.getProgramVersion() + ", block: " + faultInfo.getFaultyBlock()  + ", " + faultInfo.getFaultyMethod() + ", " + faultInfo.getFaultyClass());
		System.out.println("Fault: "+faultInfo.getFaultName() + ", "+ heuristic  + ", program: "+ faultInfo.getProgramName() + ", v"+faultInfo.getProgramVersion() + ", block: " + faultInfo.getFaultyBlock()  + ", " + faultInfo.getFaultyMethod() + ", " + faultInfo.getFaultyClass());
		
		calculatePerformance(criteria,mcpCriteria,blReportFile,faultInfo,heuristic);
	}
	
	public void ant_v1_CLJ_HD_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("CLJ_HD_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("org.apache.tools.ant.types");
		faultInfo.setFaultyClass("org.apache.tools.ant.types.CommandlineJava");
		faultInfo.setFaultyMethod("getCommandline()");
		faultInfo.setFaultyBlock(7);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v1_PJH_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("PJH_AK_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("org.apache.tools.ant");
		faultInfo.setFaultyClass("org.apache.tools.ant.ProjectHelper");
		faultInfo.setFaultyMethod("parse()");
		faultInfo.setFaultyBlock(68);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v2_CDJ_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("CDJ_AK_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.tools.ant.types");
		faultInfo.setFaultyClass("org.apache.tools.ant.types.CommandlineJava");
		faultInfo.setFaultyMethod("getCommandline()");
		faultInfo.setFaultyBlock(42);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v2_PH_HD_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("PH_HD_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.tools.ant");
		faultInfo.setFaultyClass("org.apache.tools.ant.ProjectHelper$TargetHandler");
		faultInfo.setFaultyMethod("startElement(String,AttributeList)");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v3_TG_HD_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("TG_HD_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(3);
		faultInfo.setFaultyPackage("org.apache.tools.ant");
		faultInfo.setFaultyClass("org.apache.tools.ant.Target");
		faultInfo.setFaultyMethod("setDepends(String)");
		faultInfo.setFaultyBlock(7);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v3_TG_HD_2(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("TG_HD_2");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(3);
		faultInfo.setFaultyPackage("org.apache.tools.ant");
		faultInfo.setFaultyClass("org.apache.tools.ant.Target");
		faultInfo.setFaultyMethod("setDepends(String)");
		faultInfo.setFaultyBlock(92);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v4_DEW_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("DEW_AK_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(4);
		faultInfo.setFaultyPackage("org.apache.tools.ant.util");
		faultInfo.setFaultyClass("org.apache.tools.ant.util.DOMElementWriter");
		faultInfo.setFaultyMethod("isLegalCharacter(char)");
		faultInfo.setFaultyBlock(20);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v4_EA_HD_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("EA_HD_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(4);
		faultInfo.setFaultyPackage("org.apache.tools.ant.types");
		faultInfo.setFaultyClass("org.apache.tools.ant.types.EnumeratedAttribute");
		faultInfo.setFaultyMethod("setValue(String)");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v4_FLU_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("FLU_AK_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(4);
		faultInfo.setFaultyPackage("org.apache.tools.ant.util");
		faultInfo.setFaultyClass("org.apache.tools.ant.util.FileUtils");
		faultInfo.setFaultyMethod("getParentFile(File)");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v4_SFS_HD_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("SFS_HD_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(4);
		faultInfo.setFaultyPackage("org.apache.tools.ant.util");
		faultInfo.setFaultyClass("org.apache.tools.ant.util.SourceFileScanner");
		faultInfo.setFaultyMethod("restrict(String[],File,File,FileNameMapper)");
		faultInfo.setFaultyBlock(113);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v5_DEW_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("DEW_AK_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(5);
		faultInfo.setFaultyPackage("org.apache.tools.ant.util");
		faultInfo.setFaultyClass("org.apache.tools.ant.util.DOMElementWriter");
		faultInfo.setFaultyMethod("encodedata(String)");
		faultInfo.setFaultyBlock(67);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v5_MNT_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("MNT_AK_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(5);
		faultInfo.setFaultyPackage("org.apache.tools.ant.taskdefs");
		faultInfo.setFaultyClass("org.apache.tools.ant.taskdefs.ManifestTask");
		faultInfo.setFaultyMethod("execute()");
		faultInfo.setFaultyBlock(41);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v5_MST_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("MST_AK_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(5);
		faultInfo.setFaultyPackage("org.apache.tools.ant.taskdefs");
		faultInfo.setFaultyClass("org.apache.tools.ant.taskdefs.Manifest");
		faultInfo.setFaultyMethod("getDefaultManifest()");
		faultInfo.setFaultyBlock(60);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v5_PJ_HD_2(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("PJ_HD_2");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(5);
		faultInfo.setFaultyPackage("org.apache.tools.ant");
		faultInfo.setFaultyClass("org.apache.tools.ant.Project");
		faultInfo.setFaultyMethod("addReference(String,Object)");
		faultInfo.setFaultyBlock(31);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v6_MT_HD_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("MT_HD_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(6);
		faultInfo.setFaultyPackage("org.apache.tools.ant.taskdefs");
		faultInfo.setFaultyClass("org.apache.tools.ant.taskdefs.ManifestTask");
		faultInfo.setFaultyMethod("execute()");
		faultInfo.setFaultyBlock(41);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v7_ACL_HD_2(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("ACL_HD_2");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(7);
		faultInfo.setFaultyPackage("org.apache.tools.ant");
		faultInfo.setFaultyClass("org.apache.tools.ant.AntClassLoader");
		faultInfo.setFaultyMethod("setClassPath(Path)");
		faultInfo.setFaultyBlock(0);//?
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v7_SLU_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("SLU_AK_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(7);
		faultInfo.setFaultyPackage("org.apache.tools.ant.types.selectors");
		faultInfo.setFaultyClass("org.apache.tools.ant.types.selectors.SelectorUtils");
		faultInfo.setFaultyMethod("matchPath(String,String,boolean)");
		faultInfo.setFaultyBlock(130);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ant_v8_ZF_HD_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("ZF_HD_1");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(8);
		faultInfo.setFaultyPackage("org.apache.tools.ant.types");
		faultInfo.setFaultyClass("org.apache.tools.ant.types.ZipFileSet");
		faultInfo.setFaultyMethod("setPrefix(String)");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v1_C_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("C_AK_1");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("org.apache.commons.math.complex");
		faultInfo.setFaultyClass("org.apache.commons.math.complex.Complex");
		faultInfo.setFaultyMethod("multiply(Complex)");
		faultInfo.setFaultyBlock(18);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v1_EDI_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("EDI_AK_1");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("org.apache.commons.math.random");
		faultInfo.setFaultyClass("org.apache.commons.math.random.EmpiricalDistributionImpl");
		faultInfo.setFaultyMethod("load(URL)");
		faultInfo.setFaultyBlock(51);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v1_F_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("F_AK_1");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("org.apache.commons.math.fraction");
		faultInfo.setFaultyClass("org.apache.commons.math.fraction.Fraction");
		faultInfo.setFaultyMethod("Fraction(double,double,int,int)");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v1_M_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("M_AK_1");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("org.apache.commons.math.stat.descriptive.moment");
		faultInfo.setFaultyClass("org.apache.commons.math.stat.descriptive.moment.Mean");
		faultInfo.setFaultyMethod("evaluate(double[],int,int)");
		faultInfo.setFaultyBlock(10);
		faultAnalysis(faultInfo,heuristic);
	}
		
	public void commonsMath_v1_VS_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("VS_AK_1");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("org.apache.commons.math.random");
		faultInfo.setFaultyClass("org.apache.commons.math.random.ValueServer");
		faultInfo.setFaultyMethod("getNextReplay()");
		faultInfo.setFaultyBlock(25);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v2_ABI_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("ABI_AK_1");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.commons.math.ode.nonstiff");
		faultInfo.setFaultyClass("org.apache.commons.math.ode.nonstiff.AdamsBashforthIntegrator");
		faultInfo.setFaultyMethod("AdamsBashforthIntegrator(int,double,double,double,double)");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v2_AE_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("AE_AK_1");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.commons.math.estimation");
		faultInfo.setFaultyClass("org.apache.commons.math.estimation.AbstractEstimator");
		faultInfo.setFaultyMethod("getCovariances(EstimationProblem)");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v2_CDI_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("CDI_AK_1");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.commons.math.linear");
		faultInfo.setFaultyClass("org.apache.commons.math.linear.CholeskyDecompositionImpl");
		faultInfo.setFaultyMethod("CholeskyDecompositionImpl(RealMatrix,double,double)");
		faultInfo.setFaultyBlock(207);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v2_CRVG_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("CRVG_AK_1");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.commons.math.random");
		faultInfo.setFaultyClass("org.apache.commons.math.random.CorrelatedRandomVectorGenerator");
		faultInfo.setFaultyMethod("decompose(RealMatrix,double)");
		faultInfo.setFaultyBlock(539);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v2_F_AK_2(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("F_AK_2");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.commons.math.fraction");
		faultInfo.setFaultyClass("org.apache.commons.math.fraction.Fraction");
		faultInfo.setFaultyMethod("compareTo(Fraction)");
		faultInfo.setFaultyBlock(39);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v2_MU_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("MU_AK_1");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.commons.math.util");
		faultInfo.setFaultyClass("org.apache.commons.math.util.MathUtils");
		faultInfo.setFaultyMethod("gcd(int,int)");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v2_MU_AK_2(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("MU_AK_2");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.commons.math.util");
		faultInfo.setFaultyClass("org.apache.commons.math.util.MathUtils");
		faultInfo.setFaultyMethod("factorial(int)");
		faultInfo.setFaultyBlock(26);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v2_MU_AK_3(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("MU_AK_3");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.commons.math.util");
		faultInfo.setFaultyClass("org.apache.commons.math.util.MathUtils");
		faultInfo.setFaultyMethod("binomialCoefficient(int,int)");
		faultInfo.setFaultyBlock(58);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v2_MU_AK_4(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("MU_AK_4");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.commons.math.util");
		faultInfo.setFaultyClass("org.apache.commons.math.util.MathUtils");
		faultInfo.setFaultyMethod("binomialCoefficientLog(int,int)");
		faultInfo.setFaultyBlock(66);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v2_MU_AK_5(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("MU_AK_5");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.commons.math.util");
		faultInfo.setFaultyClass("org.apache.commons.math.util.MathUtils");
		faultInfo.setFaultyMethod("gcd(int,int)");
		faultInfo.setFaultyBlock(8);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v2_MU_AK_6(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("MU_AK_6");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.commons.math.util");
		faultInfo.setFaultyClass("org.apache.commons.math.util.MathUtils");
		faultInfo.setFaultyMethod("equals(double,double,double)");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v2_URSU_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("URSU_AK_1");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.commons.math.analysis.solvers");
		faultInfo.setFaultyClass("org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils");
		faultInfo.setFaultyMethod("bracket(UnivariateRealFunction,double,double,double,int)");
		faultInfo.setFaultyBlock(174);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v3_BS_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("BS_AK_1");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(3);
		faultInfo.setFaultyPackage("org.apache.commons.math.analysis.solvers");
		faultInfo.setFaultyClass("org.apache.commons.math.analysis.solvers.BrentSolver");
		faultInfo.setFaultyMethod("solve(UnivariateRealFunction,double,double,double)");
		faultInfo.setFaultyBlock(109);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v3_ERKI_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("ERKI_AK_1");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(3);
		faultInfo.setFaultyPackage("org.apache.commons.math.ode.nonstiff");
		faultInfo.setFaultyClass("org.apache.commons.math.ode.nonstiff.EmbeddedRungeKuttaIntegrator");
		faultInfo.setFaultyMethod("integrate(FirstOrderDifferentialEquations,double,double[],double,double[])");
		faultInfo.setFaultyBlock(727);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void commonsMath_v3_RKI_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("RKI_AK_1");
		faultInfo.setProgramName(COMMONS_MATH);
		faultInfo.setProgramVersion(3);
		faultInfo.setFaultyPackage("org.apache.commons.math.ode.nonstiff");
		faultInfo.setFaultyClass("org.apache.commons.math.ode.nonstiff.RungeKuttaIntegrator");
		faultInfo.setFaultyMethod("integrate(FirstOrderDifferentialEquations,double,double[],double,double[])");
		faultInfo.setFaultyBlock(578);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void hsqldb_v1_JDBCCF_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("JDBCCF_AK_1");
		faultInfo.setProgramName(HSQLDB);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("org.hsqldb.jdbc");
		faultInfo.setFaultyClass("org.hsqldb.jdbc.JDBCClobFile");
		faultInfo.setFaultyMethod("length()");
		faultInfo.setFaultyBlock(11);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void hsqldb_v2_EL_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("EL_AK_1");
		faultInfo.setProgramName(HSQLDB);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.hsqldb");
		faultInfo.setFaultyClass("org.hsqldb.ExpressionLogical");
		faultInfo.setFaultyMethod("resolveTypesForComparison(Session,Expression)");
		faultInfo.setFaultyBlock(840);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void hsqldb_v2_QS_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("QS_AK_1");
		faultInfo.setProgramName(HSQLDB);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.hsqldb");
		faultInfo.setFaultyClass("org.hsqldb.QuerySpecification");
		faultInfo.setFaultyMethod("setAggregateConditions(Session)");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void hsqldb_v2_QS_AK_2(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("QS_AK_2");
		faultInfo.setProgramName(HSQLDB);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.hsqldb");
		faultInfo.setFaultyClass("org.hsqldb.QuerySpecification");
		faultInfo.setFaultyMethod("setDistinctConditions(Session)");
		faultInfo.setFaultyBlock(123);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void jtopas_v1_FAULT_5(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("FAULT_5");
		faultInfo.setProgramName(JTOPAS);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("de.susebox.java.util");
		faultInfo.setFaultyClass("de.susebox.java.util.AbstractTokenizer");
		faultInfo.setFaultyMethod("isKeyword(int,int)");
		faultInfo.setFaultyBlock(20);
		faultAnalysis(faultInfo,heuristic);
	}

	public void jtopas_v1_FAULT_6(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("FAULT_6");
		faultInfo.setProgramName(JTOPAS);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("de.susebox.java.util");
		faultInfo.setFaultyClass("de.susebox.java.util.AbstractTokenizer");
		faultInfo.setFaultyMethod("test4Normal(Token)");
		faultInfo.setFaultyBlock(82);
		faultAnalysis(faultInfo,heuristic);
	}

	public void jtopas_v2_FAULT_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("FAULT_1");
		faultInfo.setProgramName(JTOPAS);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("");
		faultInfo.setFaultyClass(".ExtIOException");
		faultInfo.setFaultyMethod("ExtIOException(Throwable,String,Object[])");
		faultInfo.setFaultyBlock(0);//not defined in the experiments
		faultAnalysis(faultInfo,heuristic);
	}

	public void jtopas_v3_FAULT_4(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("FAULT_4");
		faultInfo.setProgramName(JTOPAS);
		faultInfo.setProgramVersion(3);
		faultInfo.setFaultyPackage("de.susebox.jtopas");
		faultInfo.setFaultyClass("de.susebox.jtopas.PluginTokenizer");
		faultInfo.setFaultyMethod("setSource(TokenizerSource)");
		faultInfo.setFaultyBlock(0);//not defined in the experiments
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void pmd_v3_RV_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("RV_AK_1");
		faultInfo.setProgramName(PMD);
		faultInfo.setProgramVersion(3);
		faultInfo.setFaultyPackage("net.sourceforge.pmd");
		faultInfo.setFaultyClass("net.sourceforge.pmd.RuleViolation");
		faultInfo.setFaultyMethod("RuleViolation(Rule,RuleContext,SimpleNode,String)");
		faultInfo.setFaultyBlock(431);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void pmd_v3_XMLR_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("XMLR_AK_1");
		faultInfo.setProgramName(PMD);
		faultInfo.setProgramVersion(3);
		faultInfo.setFaultyPackage("net.sourceforge.pmd.cpd");
		faultInfo.setFaultyClass("net.sourceforge.pmd.cpd.XMLRenderer");
		faultInfo.setFaultyMethod("render(Iterator)");
		faultInfo.setFaultyBlock(133);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void xmlSecurity_v1_CE_HD_3(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("CE_HD_3");
		faultInfo.setProgramName(XML_SECURITY);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("org.apache.xml.security.c14n.implementations");
		faultInfo.setFaultyClass("org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl");
		faultInfo.setFaultyMethod("updateInscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)");
		faultInfo.setFaultyBlock(302);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void xmlSecurity_v1_CHP_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("CHP_AK_1");
		faultInfo.setProgramName(XML_SECURITY);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("org.apache.xml.security.c14n.helper");
		faultInfo.setFaultyClass("org.apache.xml.security.c14n.helper.C14nHelper");
		faultInfo.setFaultyMethod("namespaceIsAbsolute(String)");
		faultInfo.setFaultyBlock(42);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void xmlSecurity_v1_CN2_AK_2(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("CN2_AK_2");
		faultInfo.setProgramName(XML_SECURITY);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("org.apache.xml.security.c14n.implementations");
		faultInfo.setFaultyClass("org.apache.xml.security.c14n.implementations.Canonicalizer20010315");
		faultInfo.setFaultyMethod("updateinscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)");
		faultInfo.setFaultyBlock(322);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void xmlSecurity_v1_CNC_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("CNC_AK_1");
		faultInfo.setProgramName(XML_SECURITY);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("org.apache.xml.security.signature");
		faultInfo.setFaultyClass("org.apache.xml.security.signature.XMLSignatureInput");
		faultInfo.setFaultyMethod("XMLSignatureInput(Node,CachedXPathAPI)");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void xmlSecurity_v1_XSI_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("XSI_AK_1");
		faultInfo.setProgramName(XML_SECURITY);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("org.apache.xml.security.signature");
		faultInfo.setFaultyClass("org.apache.xml.security.signature.XMLSignatureInput");
		faultInfo.setFaultyMethod("getNodeSet()");
		faultInfo.setFaultyBlock(38);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void xmlSecurity_v2_C2E_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("C2E_AK_1");
		faultInfo.setProgramName(XML_SECURITY);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.xml.security.c14n.implementations");
		faultInfo.setFaultyClass("org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl");
		faultInfo.setFaultyMethod("handleAttributes(Element)");
		faultInfo.setFaultyBlock(1732);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void xmlSecurity_v2_CB_HD_2(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("CB_HD_2");
		faultInfo.setProgramName(XML_SECURITY);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.xml.security.c14n.implementations");
		faultInfo.setFaultyClass("org.apache.xml.security.c14n.implementations.CanonicalizerBase");
		faultInfo.setFaultyMethod("getPositionRelativeToDocumentElement(Node)");
		faultInfo.setFaultyBlock(56);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void xmlSecurity_v2_CB_HD_3(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("CB_HD_3");
		faultInfo.setProgramName(XML_SECURITY);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.xml.security.c14n.implementations");
		faultInfo.setFaultyClass("org.apache.xml.security.c14n.implementations.CanonicalizerBase");
		faultInfo.setFaultyMethod("outputPItoWriter(ProcessingInstruction)");
		faultInfo.setFaultyBlock(87);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void xmlSecurity_v2_CH_HD_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("CH_HD_1");
		faultInfo.setProgramName(XML_SECURITY);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.xml.security.c14n.helper");
		faultInfo.setFaultyClass("org.apache.xml.security.c14n.helper.C14nHelper");
		faultInfo.setFaultyMethod("sortAttributes(Object[])");
		faultInfo.setFaultyBlock(63);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void xmlSecurity_v2_CHP_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("CHP_AK_1");
		faultInfo.setProgramName(XML_SECURITY);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.xml.security.c14n.helper");
		faultInfo.setFaultyClass("org.apache.xml.security.c14n.helper.C14nHelper");
		faultInfo.setFaultyMethod("sortAttributes(Object[])");
		faultInfo.setFaultyBlock(159);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void xmlSecurity_v2_RF_HD_2(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("RF_HD_2");
		faultInfo.setProgramName(XML_SECURITY);
		faultInfo.setProgramVersion(2);
		faultInfo.setFaultyPackage("org.apache.xml.security.signature");
		faultInfo.setFaultyClass("org.apache.xml.security.signature.Reference");
		faultInfo.setFaultyMethod("dereferenceURIandPerformTransforms()");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void xmlSecurity_v3_RF_HD_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("RF_HD_1");
		faultInfo.setProgramName(XML_SECURITY);
		faultInfo.setProgramVersion(3);
		faultInfo.setFaultyPackage("org.apache.xml.security.signature");
		faultInfo.setFaultyClass("org.apache.xml.security.signature.Reference");
		faultInfo.setFaultyMethod("getDigestValue()");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void xmlSecurity_v3_XU_HD_2(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("XU_HD_2");
		faultInfo.setProgramName(XML_SECURITY);
		faultInfo.setProgramVersion(3);
		faultInfo.setFaultyPackage("org.apache.xml.security.utils");
		faultInfo.setFaultyClass("org.apache.xml.security.utils.XMLUtils");
		faultInfo.setFaultyMethod("getOwnerDocument(Set)");
		faultInfo.setFaultyBlock(18);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void xstream_v1_AM_AK_1(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("AM_AK_1");
		faultInfo.setProgramName(XSTREAM);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("com.thoughtworks.xstream.mapper");
		faultInfo.setFaultyClass("com.thoughtworks.xstream.mapper.AnnotationMapper");
		faultInfo.setFaultyMethod("cacheConverter(XStreamConverter,Class)");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	
	public byte[] export() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		CsvWriter csv = new CsvWriter(new OutputStreamWriter(baos));
		csv.setFieldDelimiter(';');
		csv.setBlockDelimiter('\n');
		
		//makeHeader(csv);
		makeCSV(csv);
		
		csv.close();
		return baos.toByteArray();
	}
	
	private void makeHeader(){
		List<String> header = new ArrayList<String>();
		header.add("program");
		header.add("v");
		header.add("fault");
		header.add("heuristic");
		header.add("score-mcp");
		header.add("score-bl");
		header.add("score-max");
		for(double delta : LEVEL_SCORES){
			header.add("icd-ls-"+(int)delta);
		}
		header.add("bl");
		for(double delta : LEVEL_SCORES){
			header.add("ch-ls-"+(int)delta);
		}
		header.add("methods");
		for(double delta : LEVEL_SCORES){
			header.add("icd-ls-"+(int)delta);
		}
		for(double delta : LEVEL_SCORES){
			header.add("ch-ls-"+(int)delta);
		}
		header.add("exec blocks");
		header.add("exec methods");
		matrix.add(header);
	}
	
	private void makeCSV(CsvWriter csv) throws IOException {
		for(List<String> line : matrix){
			for(String cel : line){
				csv.writeField(cel);
			}
			csv.endBlock();
		}
	}
	
	private void makeBudgets(String heuristic, String programName){
		List<String> rowBudget = new ArrayList<String>();
		final int FIRST_BLANK_CELS = 6;
		int effortMethodIndex = 0;
		
		//add a header for ALL_PROGRAMS
		if(programName.equals(ALL_PROGRAMS)){
			rowBudget.add("TOTAL");
			for(int i = 1; i < ColumnIndexCHICD.TOTAL_COLUMNS; i++){
				if(i == ColumnIndexCHICD.HEURISTIC){
					rowBudget.add(heuristic);
				}else{
					rowBudget.add("");
				}
			}
			matrix.add(rowBudget);
			rowBudget = new ArrayList<String>();
			makeHeader();
		}
		
		//block absolute budgets
		for(int budget : EFFORT_BUDGET_RANGES){
			rowBudget.add("budget 1 - "+budget);
			for(int i = 0; i < FIRST_BLANK_CELS; i++){
				rowBudget.add("");
			}
			List<String> budgetValues = sumEffortBudgetValuesPerBudget(heuristic, budget,true,programName);
			for(String bud : budgetValues){
				rowBudget.add(bud);
			}
			rowBudget.add("met-budget "+((METHOD_EFFORT_BUDGET_RANGES[effortMethodIndex]==INFINITE) ? "30+" : METHOD_EFFORT_BUDGET_RANGES[effortMethodIndex]));
			List<String> methodBudgetValues = sumEffortBudgetValuesPerBudget(heuristic, METHOD_EFFORT_BUDGET_RANGES[effortMethodIndex],false,programName);
			for(String metBud : methodBudgetValues){
				rowBudget.add(metBud);
			}
			//total of executed blocks and methods
			rowBudget.add("");
			rowBudget.add("");
			
			effortMethodIndex++;
			
			matrix.add(rowBudget);
			rowBudget = new ArrayList<String>();
		}
		//blank line between the heuristics
		for(int i = 0; i < ColumnIndexCHICD.TOTAL_COLUMNS; i++){
			rowBudget.add("");
		}
		matrix.add(rowBudget);
		rowBudget = new ArrayList<String>();
	}
	
	
	//blockEffort: true for blocks and false for methods
	private List<String> sumEffortBudgetValuesPerBudget(String heuristic,int effortBudget, boolean blockEffort, String programName){
		List<List<Integer>> effortMatrix;
		if(blockEffort){
			effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndexCHICD.ABS_BLOCKS_IDX_BEGIN,ColumnIndexCHICD.ABS_BLOCKS_IDX_END,programName);
		}else{
			effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndexCHICD.ABS_METHODS_IDX_BEGIN,ColumnIndexCHICD.ABS_METHODS_IDX_END,programName);
		}
		List<String> effortBudgetRow = new ArrayList<String>();
		int effortOccurrences = 0;
		for(List<Integer> effortColumn : effortMatrix){
			for(Integer effort : effortColumn){
				if(effort <= effortBudget){
					effortOccurrences++;
				}
			}
			effortBudgetRow.add(String.valueOf(effortOccurrences));
			effortOccurrences = 0;
		}
		return effortBudgetRow;
	}
	
	private List<List<Integer>> getEffortColumnsPerHeuristic(String heuristic,int firstColIndex, int lastColIndex, String programName){
		List<List<Integer>> effortColumns = new ArrayList<List<Integer>>();
		List<Integer> column = new ArrayList<Integer>();
		for(int i = firstColIndex; i <= lastColIndex; i++){
			for(List<String> line : matrix){
				if(programName.equals(ALL_PROGRAMS)){
					if(line.get(ColumnIndexCHICD.HEURISTIC).equals(heuristic) && !line.get(ColumnIndexCHICD.PROGRAM).equals("TOTAL")){
						column.add(Integer.parseInt(line.get(i)));
					}
				}else{
					if(line.get(ColumnIndexCHICD.HEURISTIC).equals(heuristic) && line.get(ColumnIndexCHICD.PROGRAM).equals(programName)){
						column.add(Integer.parseInt(line.get(i)));
					}
				}
			}
			effortColumns.add(column);
			column = new ArrayList<Integer>();
		}
		return effortColumns;
	}
	
	
	public void generateCSVFile(){
		try {
 			OutputStream os = new FileOutputStream(new File(PATHFILE+"ch-icd-output-ls.csv"));
            os.write(export());
            os.close();
	 	} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void generateLogFile(FaultInfo faultInfo,String heuristic){
		File logFile = new File(PATHFILE+"ch-icd-ls-inspection-log_"+faultInfo.getProgramName()+"_"+faultInfo.getProgramVersion()+"_"+faultInfo.getFaultName()+"_"+heuristic+".txt");
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(logFile,false));
			for(String logLine : logFileList){
				writer.write(logLine);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				writer.close();
				logFileList.clear();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	private void generateAbsoluteEffectivenessCharts(String heuristic, String programName, String strategy){
		DataParser parser = new DataParser();
		String analysisType = "effectiveness";
		String xAxis = "Budgets";
		String yAxis = "Effort";
		String requirement = "blocks";
		String range;
		String fileName = "";
		String chartTitle = "";
		ChartGenerator chart = new ChartGenerator();
		List<List<String>> effortDataset;
		ChartType chartType = ChartType.BarChart;
		
		//effectiveness - blocks - absolute
		fileName = strategy+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
		chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, RangeIndexCHICD.icd_bl_ch_0_7(),RangeIndexCHICD.budget_5_100());
		range = "delta_0_7";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, RangeIndexCHICD.icd_bl_ch_10_30(),RangeIndexCHICD.budget_5_100());
		range = "delta_10_30";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, RangeIndexCHICD.icd_bl_ch_35_75(),RangeIndexCHICD.budget_5_100());
		range = "delta_35_75";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		//effectiveness - methods - absolute
		requirement = "methods";
		xAxis = "Inspected methods";
		fileName = strategy+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
		//chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, RangeIndexCHICD.icd_ch_met_0_7(),RangeIndexCHICD.method_row_header_1_30_plus());
		range = "delta_0_7";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, RangeIndexCHICD.icd_ch_met_10_30(),RangeIndexCHICD.method_row_header_1_30_plus());
		range = "delta_10_30";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, RangeIndexCHICD.icd_ch_met_35_75(),RangeIndexCHICD.method_row_header_1_30_plus());
		range = "delta_35_75";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
	}
	
	private void generateCharts() {
		String heuristic = TARANTULA;
		String strategy = "original";
		generateAbsoluteEffectivenessCharts(heuristic,ANT,strategy);
		generateAbsoluteEffectivenessCharts(heuristic,COMMONS_MATH,strategy);
		generateAbsoluteEffectivenessCharts(heuristic,HSQLDB,strategy);
		generateAbsoluteEffectivenessCharts(heuristic,JTOPAS,strategy);
		generateAbsoluteEffectivenessCharts(heuristic,PMD,strategy);
		generateAbsoluteEffectivenessCharts(heuristic,XML_SECURITY,strategy);
		generateAbsoluteEffectivenessCharts(heuristic,XSTREAM,strategy);
		generateAbsoluteEffectivenessCharts(heuristic,ALL_PROGRAMS,strategy);
		heuristic = OCHIAI;
		generateAbsoluteEffectivenessCharts(heuristic,ANT,strategy);
		generateAbsoluteEffectivenessCharts(heuristic,COMMONS_MATH,strategy);
		generateAbsoluteEffectivenessCharts(heuristic,HSQLDB,strategy);
		generateAbsoluteEffectivenessCharts(heuristic,JTOPAS,strategy);
		generateAbsoluteEffectivenessCharts(heuristic,PMD,strategy);
		generateAbsoluteEffectivenessCharts(heuristic,XML_SECURITY,strategy);
		generateAbsoluteEffectivenessCharts(heuristic,XSTREAM,strategy);
		generateAbsoluteEffectivenessCharts(heuristic,ALL_PROGRAMS,strategy);
	}
	
	private void generateAbsoluteEffectivenessChartsForLevelScore(String heuristic, String programName, String strategy){
		DataParser parser = new DataParser();
		String analysisType = "effectiveness";
		String xAxis = "Budgets";
		String yAxis = "Effort";
		String requirement = "blocks";
		String range;
		String fileName = "";
		String chartTitle = "";
		ChartGenerator chart = new ChartGenerator();
		List<List<String>> effortDataset;
		ChartType chartType = ChartType.BarChart;
		List<Integer> reducedLevels_1_2 = new ArrayList<Integer>();
		reducedLevels_1_2.add(ColumnIndexCHICD.ICD_0);
		reducedLevels_1_2.add(ColumnIndexCHICD.ICD_1);
		reducedLevels_1_2.add(ColumnIndexCHICD.BL);
		reducedLevels_1_2.add(ColumnIndexCHICD.CH_0);
		reducedLevels_1_2.add(ColumnIndexCHICD.CH_1);
		List<Integer> reducedLevels_1_3 = new ArrayList<Integer>();
		reducedLevels_1_3.add(ColumnIndexCHICD.ICD_0);
		reducedLevels_1_3.add(ColumnIndexCHICD.ICD_1);
		reducedLevels_1_3.add(ColumnIndexCHICD.ICD_3);
		reducedLevels_1_3.add(ColumnIndexCHICD.BL);
		reducedLevels_1_3.add(ColumnIndexCHICD.CH_0);
		reducedLevels_1_3.add(ColumnIndexCHICD.CH_1);
		reducedLevels_1_3.add(ColumnIndexCHICD.CH_3);
		List<Integer> reducedLevels_1_2_Methods = new ArrayList<Integer>();
		reducedLevels_1_2_Methods.add(ColumnIndexCHICD.ICD_MET_0);
		reducedLevels_1_2_Methods.add(ColumnIndexCHICD.ICD_MET_1);
		reducedLevels_1_2_Methods.add(ColumnIndexCHICD.CH_MET_0);
		reducedLevels_1_2_Methods.add(ColumnIndexCHICD.CH_MET_1);
		List<Integer> reducedLevels_1_3_Methods = new ArrayList<Integer>();
		reducedLevels_1_3_Methods.add(ColumnIndexCHICD.ICD_MET_0);
		reducedLevels_1_3_Methods.add(ColumnIndexCHICD.ICD_MET_1);
		reducedLevels_1_3_Methods.add(ColumnIndexCHICD.ICD_MET_3);
		reducedLevels_1_3_Methods.add(ColumnIndexCHICD.CH_MET_0);
		reducedLevels_1_3_Methods.add(ColumnIndexCHICD.CH_MET_1);
		reducedLevels_1_3_Methods.add(ColumnIndexCHICD.CH_MET_3);
		
		
		//effectiveness - blocks - absolute
		fileName = strategy+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
		chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, reducedLevels_1_2,RangeIndexCHICD.budget_5_100());
		range = "levels_1_2";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, reducedLevels_1_3,RangeIndexCHICD.budget_5_100());
		range = "levels_1_3";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		//effectiveness - methods - absolute
		requirement = "methods";
		xAxis = "Inspected methods";
		fileName = strategy+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
		//chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, reducedLevels_1_2_Methods,RangeIndexCHICD.method_row_header_1_30_plus());
		range = "levels_1_2";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, reducedLevels_1_3_Methods,RangeIndexCHICD.method_row_header_1_30_plus());
		range = "levels_1_3";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
	}
	
	private void generateChartsForLevelScore() {
		String heuristic = TARANTULA;
		String strategy = "level_method_score";
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,ANT,strategy);
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,COMMONS_MATH,strategy);
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,HSQLDB,strategy);
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,JTOPAS,strategy);
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,PMD,strategy);
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,XML_SECURITY,strategy);
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,XSTREAM,strategy);
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,ALL_PROGRAMS,strategy);
		heuristic = OCHIAI;
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,ANT,strategy);
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,COMMONS_MATH,strategy);
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,HSQLDB,strategy);
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,JTOPAS,strategy);
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,PMD,strategy);
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,XML_SECURITY,strategy);
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,XSTREAM,strategy);
		generateAbsoluteEffectivenessChartsForLevelScore(heuristic,ALL_PROGRAMS,strategy);
	}
	
	private List<Integer> getSequentialColumns(int beginIndex, int endIndex){
		List<Integer> columnList = new ArrayList<Integer>();
		for(int i = beginIndex; i <= endIndex; i++){
			columnList.add(i);
		}
		return columnList;
	}
	
}
