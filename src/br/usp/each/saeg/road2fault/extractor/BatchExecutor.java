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

public class BatchExecutor {
	
	private final String PATHFILE="/home/higor/data/r2f/reports/";
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
	private final int PERCENTUAL_RANGES[] = {1,5,10,15,20,25,30,35,40,50,60,70,80,90,100};
	private final int DELTA_BUDGET_RANGES[] = {5,10,15,20,25,30,35,40,45,50,60,70,80,90,100};
	private boolean isDeltaBudget = false;
	private final int DB_METHOD_EFFORT_BUDGET_RANGES[] = {1,2,3,4,5,6,7,8,9,10,15,20,25,30,INFINITE};
	private final int DB_PERCENTUAL_RANGES[] = {1,5,10,15,20,25,30,35,40,50,60,70,80,90,100};
	
	private List<List<String>> matrix = new ArrayList<List<String>>();
	private List<String> csvLineAbsBlocks = new ArrayList<String>();
	private List<String> csvLineAbsMethods = new ArrayList<String>();
	private List<String> csvLinePercBlocks = new ArrayList<String>();
	private List<String> csvLinePercMethods = new ArrayList<String>();
	private List<String> logFileList = new ArrayList<String>();
	private int executedMethods;
	private int executedBlocks;
	
	public void execute(){
		isDeltaBudget = true;// to change the strategy between delta budget and the others
		if(!isDeltaBudget){
			makeHeader();
		}else{
			makeHeaderDB();
		}
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
		if(!isDeltaBudget){
			makeBudgets(TARANTULA,ANT);
			makeHeader();
		}else{
			makeBudgetsDB(TARANTULA,ANT);
			makeHeaderDB();
		}
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
		if(!isDeltaBudget){
			makeBudgets(TARANTULA,COMMONS_MATH);
			makeHeader();
		}else{
			makeBudgetsDB(TARANTULA,COMMONS_MATH);
			makeHeaderDB();
		}
		hsqldb_v1_JDBCCF_AK_1(TARANTULA);
		hsqldb_v2_EL_AK_1(TARANTULA);
		hsqldb_v2_QS_AK_1(TARANTULA);
		hsqldb_v2_QS_AK_2(TARANTULA);
		if(!isDeltaBudget){
			makeBudgets(TARANTULA,HSQLDB);
			makeHeader();
		}else{
			makeBudgetsDB(TARANTULA,HSQLDB);
			makeHeaderDB();
		}
		jtopas_v1_FAULT_5(TARANTULA);
		jtopas_v1_FAULT_6(TARANTULA);
		//jtopas_v2_FAULT_1(TARANTULA);
		jtopas_v3_FAULT_4(TARANTULA);
		if(!isDeltaBudget){
			makeBudgets(TARANTULA,JTOPAS);
			makeHeader();
		}else{
			makeBudgetsDB(TARANTULA,JTOPAS);
			makeHeaderDB();
		}
		pmd_v3_RV_AK_1(TARANTULA);
		pmd_v3_XMLR_AK_1(TARANTULA);
		if(!isDeltaBudget){
			makeBudgets(TARANTULA,PMD);
			makeHeader();
		}else{
			makeBudgetsDB(TARANTULA,PMD);
			makeHeaderDB();
		}
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
		if(!isDeltaBudget){
			makeBudgets(TARANTULA,XML_SECURITY);
			makeHeader();
		}else{
			makeBudgetsDB(TARANTULA,XML_SECURITY);
			makeHeaderDB();
		}
		xstream_v1_AM_AK_1(TARANTULA);
		if(!isDeltaBudget){
			makeBudgets(TARANTULA,XSTREAM);
			makeBudgets(TARANTULA,ALL_PROGRAMS);
			makeHeader();
		}else{
			makeBudgetsDB(TARANTULA,XSTREAM);
			makeBudgetsDB(TARANTULA,ALL_PROGRAMS);
			makeHeaderDB();
		}
		
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
		if(!isDeltaBudget){
			makeBudgets(OCHIAI,ANT);
			makeHeader();
		}else{
			makeBudgetsDB(OCHIAI,ANT);
			makeHeaderDB();
		}
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
		if(!isDeltaBudget){
			makeBudgets(OCHIAI,COMMONS_MATH);
			makeHeader();
		}else{
			makeBudgetsDB(OCHIAI,COMMONS_MATH);
			makeHeaderDB();
		}
		hsqldb_v1_JDBCCF_AK_1(OCHIAI);
		hsqldb_v2_EL_AK_1(OCHIAI);
		hsqldb_v2_QS_AK_1(OCHIAI);
		hsqldb_v2_QS_AK_2(OCHIAI);
		if(!isDeltaBudget){
			makeBudgets(OCHIAI,HSQLDB);
			makeHeader();
		}else{
			makeBudgetsDB(OCHIAI,HSQLDB);
			makeHeaderDB();
		}
		jtopas_v1_FAULT_5(OCHIAI);
		jtopas_v1_FAULT_6(OCHIAI);
		//jtopas_v2_FAULT_1(OCHIAI);
		jtopas_v3_FAULT_4(OCHIAI);
		if(!isDeltaBudget){
			makeBudgets(OCHIAI,JTOPAS);
			makeHeader();
		}else{
			makeBudgetsDB(OCHIAI,JTOPAS);
			makeHeaderDB();
		}
		pmd_v3_RV_AK_1(OCHIAI);
		pmd_v3_XMLR_AK_1(OCHIAI);
		if(!isDeltaBudget){
			makeBudgets(OCHIAI,PMD);
			makeHeader();
		}else{
			makeBudgetsDB(OCHIAI,PMD);
			makeHeaderDB();
		}
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
		if(!isDeltaBudget){
			makeBudgets(OCHIAI,XML_SECURITY);
			makeHeader();
		}else{
			makeBudgetsDB(OCHIAI,XML_SECURITY);
			makeHeaderDB();
		}
		xstream_v1_AM_AK_1(OCHIAI);
		if(!isDeltaBudget){
			makeBudgets(OCHIAI,XSTREAM);
			makeBudgets(OCHIAI,ALL_PROGRAMS);
		}else{
			makeBudgetsDB(OCHIAI,XSTREAM);
			makeBudgetsDB(OCHIAI,ALL_PROGRAMS);
		}
		
		makeEfficiency(TARANTULA, ALL_PROGRAMS);
		makeEfficiency(OCHIAI, ALL_PROGRAMS);
		makeEfficiency(TARANTULA, ANT);
		makeEfficiency(TARANTULA, COMMONS_MATH);
		makeEfficiency(TARANTULA, HSQLDB);
		makeEfficiency(TARANTULA, JTOPAS);
		makeEfficiency(TARANTULA, PMD);
		makeEfficiency(TARANTULA, XML_SECURITY);
		makeEfficiency(TARANTULA, XSTREAM);
		makeEfficiency(OCHIAI, ANT);
		makeEfficiency(OCHIAI, COMMONS_MATH);
		makeEfficiency(OCHIAI, HSQLDB);
		makeEfficiency(OCHIAI, JTOPAS);
		makeEfficiency(OCHIAI, PMD);
		makeEfficiency(OCHIAI, XML_SECURITY);
		makeEfficiency(OCHIAI, XSTREAM);
				
		generateCSVFile();
		
		generateCharts();
		//generateChartsForLevelScore();
		
	}
	
	public void calculatePerformance(XmlTestCriteria criteria,XmlMcpTestCriteria mcpCriteria, XmlBLReportFile blReportFile, FaultInfo faultInfo, String heuristic){
		csvLineAbsBlocks = new ArrayList<String>();
		csvLineAbsMethods = new ArrayList<String>();
		csvLinePercBlocks = new ArrayList<String>();
		csvLinePercMethods = new ArrayList<String>();
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
			csvLinePercBlocks.add(calculatePercentageBlockValue(InspectionStrategyLevelScorePerMethod.inspectedBlocksInMcp));
			csvLinePercMethods.add(calculatePercentageMethodValue(InspectionStrategyLevelScorePerMethod.inspectedMethodsInMcp));
			logFileList.addAll(InspectionStrategyLevelScorePerMethod.logFileList);
			InspectionStrategyLevelScorePerMethod.clear();
		}
		
		InspectionStrategyLevelScorePerMethod.calculateBlockListPerformance(blReportFile);
		csvLineAbsBlocks.add(String.valueOf(InspectionStrategyLevelScorePerMethod.inspectedBlocksInBL));
		csvLinePercBlocks.add(calculatePercentageBlockValue(InspectionStrategyLevelScorePerMethod.inspectedBlocksInBL));
		logFileList.addAll(InspectionStrategyLevelScorePerMethod.logFileList);
		InspectionStrategyLevelScorePerMethod.clear();
		
		for(double delta : DELTA_VALUES){
			InspectionStrategyLevelScorePerMethod.calculateMethodHitSpectraPerformanceForBlocksAndDelta(criteria, delta);
			csvLineAbsBlocks.add(String.valueOf(InspectionStrategyLevelScorePerMethod.inspectedBlocksInMethodHitSpectra));
			csvLineAbsMethods.add(String.valueOf(InspectionStrategyLevelScorePerMethod.inspectedMethodsInMethodHitSpectra));
			csvLinePercBlocks.add(calculatePercentageBlockValue(InspectionStrategyLevelScorePerMethod.inspectedBlocksInMethodHitSpectra));
			csvLinePercMethods.add(calculatePercentageMethodValue(InspectionStrategyLevelScorePerMethod.inspectedMethodsInMethodHitSpectra));
			logFileList.addAll(InspectionStrategyLevelScorePerMethod.logFileList);
			InspectionStrategyLevelScorePerMethod.clear();
		}
		generateLogFile(faultInfo,heuristic);
		csvLineAbsBlocks.add(faultInfo.getFaultName());
		csvLineAbsBlocks.addAll(csvLineAbsMethods);
		csvLineAbsBlocks.add(faultInfo.getFaultName());
		csvLineAbsBlocks.addAll(csvLinePercBlocks);
		csvLineAbsBlocks.add(faultInfo.getFaultName());
		csvLineAbsBlocks.addAll(csvLinePercMethods);
		csvLineAbsBlocks.add(String.valueOf(executedBlocks));
		csvLineAbsBlocks.add(String.valueOf(executedMethods));
		csvLineAbsBlocks.addAll(calculateEfficiency(csvLineAbsBlocks));
		matrix.add(csvLineAbsBlocks);
	}
	/*
	 * Use for DeltaBudget strategies
	 * */
	public void calculatePerformanceDeltaBudget(XmlTestCriteria criteria,XmlMcpTestCriteria mcpCriteria, XmlBLReportFile blReportFile, FaultInfo faultInfo, String heuristic){
		csvLineAbsBlocks = new ArrayList<String>();
		csvLineAbsMethods = new ArrayList<String>();
		csvLinePercBlocks = new ArrayList<String>();
		csvLinePercMethods = new ArrayList<String>();
		csvLineAbsBlocks.add(faultInfo.getProgramName());
		csvLineAbsBlocks.add(String.valueOf(faultInfo.getProgramVersion()));
		csvLineAbsBlocks.add(faultInfo.getFaultName());
		csvLineAbsBlocks.add(heuristic);
		csvLineAbsBlocks.add(String.valueOf(mcpCriteria.getMcpFaultyMethodScoreMax(faultInfo.getFaultyMethod())));
		csvLineAbsBlocks.add(String.valueOf(criteria.getFaultyBlockScore()));
		csvLineAbsBlocks.add(String.valueOf(criteria.getMaxBlockScore()));
		csvLineAbsBlocks.add("-");
		csvLineAbsBlocks.add("-");
		csvLineAbsBlocks.add("-");
		csvLineAbsBlocks.add("-");
		csvLineAbsBlocks.add("-");
		csvLineAbsBlocks.add("-");
		csvLineAbsBlocks.add("-");
		csvLineAbsBlocks.add("-");
		csvLineAbsBlocks.add("-");
		csvLineAbsBlocks.add("-");
		for(int deltaBudget : DELTA_BUDGET_RANGES){
			InspectionStrategyDeltaBudget.calculateMcpPerformance(criteria, mcpCriteria, deltaBudget, blReportFile); //only for InspectionStrategyDeltaBudget
			csvLineAbsBlocks.add(String.valueOf(InspectionStrategyDeltaBudget.inspectedBlocksInMcp));
			csvLineAbsMethods.add(String.valueOf(InspectionStrategyDeltaBudget.inspectedMethodsInMcp));
			csvLinePercBlocks.add(calculatePercentageBlockValue(InspectionStrategyDeltaBudget.inspectedBlocksInMcp));
			csvLinePercMethods.add(calculatePercentageMethodValue(InspectionStrategyDeltaBudget.inspectedMethodsInMcp));
			logFileList.addAll(InspectionStrategyDeltaBudget.logFileList);
			InspectionStrategyDeltaBudget.clear();
		}
		
		InspectionStrategyDeltaBudget.calculateBlockListPerformance(blReportFile);
		csvLineAbsBlocks.add(String.valueOf(InspectionStrategyDeltaBudget.inspectedBlocksInBL));
		csvLinePercBlocks.add(calculatePercentageBlockValue(InspectionStrategyDeltaBudget.inspectedBlocksInBL));
		logFileList.addAll(InspectionStrategyDeltaBudget.logFileList);
		InspectionStrategyDeltaBudget.clear();
		
		for(int deltaBudget : DELTA_BUDGET_RANGES){
			InspectionStrategyDeltaBudget.calculateMethodHitSpectraPerformanceForBlocksAndDelta(criteria, deltaBudget, blReportFile); //only for InspectionStrategyDeltaBudget
			csvLineAbsBlocks.add(String.valueOf(InspectionStrategyDeltaBudget.inspectedBlocksInMethodHitSpectra));
			csvLineAbsMethods.add(String.valueOf(InspectionStrategyDeltaBudget.inspectedMethodsInMethodHitSpectra));
			csvLinePercBlocks.add(calculatePercentageBlockValue(InspectionStrategyDeltaBudget.inspectedBlocksInMethodHitSpectra));
			csvLinePercMethods.add(calculatePercentageMethodValue(InspectionStrategyDeltaBudget.inspectedMethodsInMethodHitSpectra));
			logFileList.addAll(InspectionStrategyDeltaBudget.logFileList);
			InspectionStrategyDeltaBudget.clear();
		}
		generateLogFile(faultInfo,heuristic);
		csvLineAbsBlocks.add(faultInfo.getFaultName());
		csvLineAbsBlocks.addAll(csvLineAbsMethods);
		csvLineAbsBlocks.add(faultInfo.getFaultName());
		csvLineAbsBlocks.addAll(csvLinePercBlocks);
		csvLineAbsBlocks.add(faultInfo.getFaultName());
		csvLineAbsBlocks.addAll(csvLinePercMethods);
		csvLineAbsBlocks.add(String.valueOf(executedBlocks));
		csvLineAbsBlocks.add(String.valueOf(executedMethods));
		csvLineAbsBlocks.addAll(calculateEfficiency(csvLineAbsBlocks));
		matrix.add(csvLineAbsBlocks);
	}
	
	private String calculatePercentageBlockValue(int absolute){
		Double percentage = new Double(0);
		percentage = (double)absolute/executedBlocks;
		return String.format("%.2f", percentage);
	}
	
	private String calculatePercentageMethodValue(int absolute){
		Double percentage = new Double(0);
		percentage = (double)absolute/executedMethods;
		return String.format("%.2f", percentage);
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
		
		if(!isDeltaBudget){
			calculatePerformance(criteria,mcpCriteria,blReportFile,faultInfo,heuristic);
		}else{
			calculatePerformanceDeltaBudget(criteria,mcpCriteria,blReportFile,faultInfo,heuristic);
		}
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
		for(double delta : DELTA_VALUES){
			header.add("icd-"+(int)delta);
		}
		header.add("bl");
		for(double delta : DELTA_VALUES){
			header.add("mhs-"+(int)delta);
		}
		header.add("met-budgets");
		for(double delta : DELTA_VALUES){
			header.add("icd-"+(int)delta);
		}
		for(double delta : DELTA_VALUES){
			header.add("mhs-"+(int)delta);
		}
		//percentages
		header.add("blocks-%");
		for(double delta : DELTA_VALUES){
			header.add("%icd-"+(int)delta);
		}
		header.add("%bl");
		for(double delta : DELTA_VALUES){
			header.add("%mhs-"+(int)delta);
		}
		header.add("methods-%");
		for(double delta : DELTA_VALUES){
			header.add("%icd-"+(int)delta);
		}
		for(double delta : DELTA_VALUES){
			header.add("%mhs-"+(int)delta);
		}
		header.add("exec blocks");
		header.add("exec methods");
		for(double delta : DELTA_VALUES){
			header.add("icd-ef-"+(int)delta);
			header.add("bl-"+(int)delta);
		}
		for(double delta : DELTA_VALUES){
			header.add("icd-ef-"+(int)delta);
			header.add("mhs-ef-"+(int)delta);
		}
		for(double delta : DELTA_VALUES){
			header.add("mhs-ef-"+(int)delta);
			header.add("bl-"+(int)delta);
		}
		for(double delta : DELTA_VALUES){
			header.add("icd-ef-"+(int)delta);
			header.add("bl-"+(int)delta);
			header.add("mhs-ef-"+(int)delta);
		}
		matrix.add(header);
	}
	
	private void makeHeaderDB(){
		List<String> header = new ArrayList<String>();
		header.add("program");
		header.add("v");
		header.add("fault");
		header.add("heuristic");
		header.add("score-mcp");
		header.add("score-bl");
		header.add("score-max");
		header.add("icd");
		header.add("bl");
		header.add("mhs");
		header.add("icd-met");
		header.add("mhs-met");
		header.add("%icd");
		header.add("%bl");
		header.add("%mhs");
		header.add("%icd-met");
		header.add("%mhs-met");
		for(double delta : DELTA_BUDGET_RANGES){
			header.add("icd-budget-"+(int)delta);
		}
		header.add("bl");
		for(double delta : DELTA_BUDGET_RANGES){
			header.add("mhs-budget-"+(int)delta);
		}
		header.add("met-budgets");
		for(double delta : DELTA_BUDGET_RANGES){
			header.add("icd-"+(int)delta);
		}
		for(double delta : DELTA_BUDGET_RANGES){
			header.add("mhs-"+(int)delta);
		}
		//percentages
		header.add("blocks-%");
		for(double delta : DELTA_BUDGET_RANGES){
			header.add("%icd-"+(int)delta);
		}
		header.add("%bl");
		for(double delta : DELTA_BUDGET_RANGES){
			header.add("%mhs-"+(int)delta);
		}
		header.add("methods-%");
		for(double delta : DELTA_BUDGET_RANGES){
			header.add("%icd-"+(int)delta);
		}
		for(double delta : DELTA_BUDGET_RANGES){
			header.add("%mhs-"+(int)delta);
		}
		header.add("exec blocks");
		header.add("exec methods");
		for(double delta : DELTA_BUDGET_RANGES){
			header.add("icd-ef-"+(int)delta);
			header.add("bl-"+(int)delta);
		}
		for(double delta : DELTA_BUDGET_RANGES){
			header.add("icd-ef-"+(int)delta);
			header.add("mhs-ef-"+(int)delta);
		}
		for(double delta : DELTA_BUDGET_RANGES){
			header.add("mhs-ef-"+(int)delta);
			header.add("bl-"+(int)delta);
		}
		for(double delta : DELTA_BUDGET_RANGES){
			header.add("icd-ef-"+(int)delta);
			header.add("bl-"+(int)delta);
			header.add("mhs-ef-"+(int)delta);
		}
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
			for(int i = 1; i < ColumnIndex.TOTAL_COLUMNS; i++){
				if(i == ColumnIndex.HEURISTIC){
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
			//percentages
			rowBudget.add("block-"+PERCENTUAL_RANGES[effortMethodIndex]+"%");
			List<String> blockPercValues = sumPercentageValuesPerBudget(heuristic, PERCENTUAL_RANGES[effortMethodIndex],true,programName);
			for(String percBlock : blockPercValues){
				rowBudget.add(percBlock);
			}
			rowBudget.add("met-"+PERCENTUAL_RANGES[effortMethodIndex]+"%");
			List<String> methodPercValues = sumPercentageValuesPerBudget(heuristic, PERCENTUAL_RANGES[effortMethodIndex],false,programName);
			for(String percMet : methodPercValues){
				rowBudget.add(percMet);
			}
			
			//total of executed blocks and methods
			rowBudget.add("");
			rowBudget.add("");
			
			//efficiency fields, only in 1st line
			//if(budget == EFFORT_BUDGET_RANGES[0]){
				rowBudget.addAll(sumEfficiency(heuristic, programName,budget));
			//}
			
			effortMethodIndex++;
			
			matrix.add(rowBudget);
			rowBudget = new ArrayList<String>();
		}
		//blank line between the heuristics
		for(int i = 0; i < ColumnIndex.TOTAL_COLUMNS; i++){
			rowBudget.add("");
		}
		matrix.add(rowBudget);
		rowBudget = new ArrayList<String>();
	}
	
	private void makeBudgetsDB(String heuristic, String programName){
		List<String> rowBudget = new ArrayList<String>();
		final int FIRST_BLANK_CELS = 6;
		int effortMethodIndex = 0;
		
		//add a header for ALL_PROGRAMS
		if(programName.equals(ALL_PROGRAMS)){
			rowBudget.add("TOTAL");
			for(int i = 1; i < ColumnIndex.DB_TOTAL_COLUMNS; i++){
				if(i == ColumnIndex.HEURISTIC){
					rowBudget.add(heuristic);
				}else{
					rowBudget.add("");
				}
			}
			matrix.add(rowBudget);
			rowBudget = new ArrayList<String>();
			makeHeaderDB();
		}
		
		//block absolute budgets
		for(int budget : DELTA_BUDGET_RANGES){
			rowBudget.add("budget 1 - "+budget);
			for(int i = 0; i < FIRST_BLANK_CELS; i++){
				rowBudget.add("");
			}
			//delta budget summaries
			List<String> budgetAbsDB = sumEffortBudgetDB(heuristic, budget,true,programName);
			for(String bud : budgetAbsDB){
				rowBudget.add(bud);
			}
			List<String> methodAbsDB = sumEffortBudgetMethodAverageDB(heuristic, budget,false,programName);//sumEffortBudgetDB(heuristic, budget,false,programName);
			for(String bud : methodAbsDB){
				rowBudget.add(bud);
			}
			List<String> blockPercValuesDB = sumPercentageEffortAverageDB(heuristic, budget,true,programName);
			for(String percBlock : blockPercValuesDB){
				rowBudget.add(percBlock);
			}
			List<String> methodPercDB = sumPercentageMethodAverageDB(heuristic, budget,true,programName);
			for(String percMet : methodPercDB){
				rowBudget.add(percMet);
			}
			//effort values for blocks, methods, and percentuals
			List<String> budgetValues = sumEffortBudgetValuesPerBudget(heuristic, budget,true,programName);
			for(String bud : budgetValues){
				rowBudget.add(bud);
			}
			
			rowBudget.add("met-budget "+((DB_METHOD_EFFORT_BUDGET_RANGES[effortMethodIndex]==INFINITE) ? "30+" : DB_METHOD_EFFORT_BUDGET_RANGES[effortMethodIndex]));
			
			
			List<String> methodBudgetValues = sumEffortBudgetValuesPerBudget(heuristic, DB_METHOD_EFFORT_BUDGET_RANGES[effortMethodIndex],false,programName);
			for(String metBud : methodBudgetValues){
				rowBudget.add(metBud);
			}
			//percentages
			rowBudget.add("block-"+DB_PERCENTUAL_RANGES[effortMethodIndex]+"%");
			List<String> blockPercValues = sumPercentageValuesPerBudget(heuristic, DB_PERCENTUAL_RANGES[effortMethodIndex],true,programName);
			for(String percBlock : blockPercValues){
				rowBudget.add(percBlock);
			}
			
			rowBudget.add("met-"+DB_PERCENTUAL_RANGES[effortMethodIndex]+"%");
			List<String> methodPercValues = sumPercentageValuesPerBudget(heuristic, DB_PERCENTUAL_RANGES[effortMethodIndex],false,programName);
			for(String percMet : methodPercValues){
				rowBudget.add(percMet);
			}
			
			//total of executed blocks and methods
			rowBudget.add("");
			rowBudget.add("");
			
			//efficiency fields, only in 1st line
			//if(budget == DELTA_BUDGET_RANGES[0]){
				rowBudget.addAll(sumEfficiency(heuristic, programName,budget));
			//}
			
			effortMethodIndex++;
			
			matrix.add(rowBudget);
			rowBudget = new ArrayList<String>();
		}
		//blank line between the heuristics
		for(int i = 0; i < ColumnIndex.DB_TOTAL_COLUMNS; i++){
			rowBudget.add("");
		}
		matrix.add(rowBudget);
		rowBudget = new ArrayList<String>();
	}
	
	private void makeEfficiency(String heuristic, String programName){
		List<String> rowEfficiency = new ArrayList<String>();
		List<List<String>> efficiencyLines = new ArrayList<List<String>>();
		
		if(!isDeltaBudget){
			efficiencyLines = getEfficiencyLinesPerHeuristic(heuristic,ColumnIndex.EFFICIENCY_IDX_BEGIN,ColumnIndex.EFFICIENCY_IDX_END,programName);
		}else{
			efficiencyLines = getEfficiencyLinesPerHeuristic(heuristic,ColumnIndex.DB_EFFICIENCY_IDX_BEGIN,ColumnIndex.DB_EFFICIENCY_IDX_END,programName);
		}
		for(List<String> line : efficiencyLines){
			matrix.add(line);
		}
	}
	
	
	//blockEffort: true for blocks and false for methods
	private List<String> sumEffortBudgetValuesPerBudget(String heuristic,int effortBudget, boolean blockEffort, String programName){
		List<List<Integer>> effortMatrix;
		if(blockEffort){
			if(!isDeltaBudget){
				effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndex.ABS_BLOCKS_IDX_BEGIN,ColumnIndex.ABS_BLOCKS_IDX_END,programName);
			}else{
				effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndex.DB_ABS_BLOCKS_IDX_BEGIN,ColumnIndex.DB_ABS_BLOCKS_IDX_END,programName);
			}
		}else{
			if(!isDeltaBudget){
				effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndex.ABS_METHODS_IDX_BEGIN,ColumnIndex.ABS_METHODS_IDX_END,programName);
			}else{
				effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndex.DB_ABS_METHODS_IDX_BEGIN,ColumnIndex.DB_ABS_METHODS_IDX_END,programName);
			}
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
	
	//blockEffort: true for blocks and false for methods
	private List<String> sumPercentageValuesPerBudget(String heuristic,int effortBudget, boolean blockEffort, String programName){
		List<List<Double>> effortMatrix;
		if(blockEffort){
			if(!isDeltaBudget){
				effortMatrix = getEffortColumnsPercentagePerHeuristic(heuristic,ColumnIndex.PERC_BLOCKS_IDX_BEGIN,ColumnIndex.PERC_BLOCKS_IDX_END,programName);
			}else{
				effortMatrix = getEffortColumnsPercentagePerHeuristic(heuristic,ColumnIndex.DB_PERC_BLOCKS_IDX_BEGIN,ColumnIndex.DB_PERC_BLOCKS_IDX_END,programName);
			}
		}else{
			if(!isDeltaBudget){
				effortMatrix = getEffortColumnsPercentagePerHeuristic(heuristic,ColumnIndex.PERC_METHODS_IDX_BEGIN,ColumnIndex.PERC_METHODS_IDX_END,programName);
			}else{
				effortMatrix = getEffortColumnsPercentagePerHeuristic(heuristic,ColumnIndex.DB_PERC_METHODS_IDX_BEGIN,ColumnIndex.DB_PERC_METHODS_IDX_END,programName);
			}
		}
		List<String> effortBudgetRow = new ArrayList<String>();
		int effortOccurrences = 0;
		for(List<Double> effortColumn : effortMatrix){
			for(Double effort : effortColumn){
				if(effort <= (double)effortBudget/100){
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
					if(line.get(ColumnIndex.HEURISTIC).equals(heuristic) && !line.get(ColumnIndex.PROGRAM).equals("TOTAL")){
						column.add(Integer.parseInt(line.get(i)));
					}
				}else{
					if(line.get(ColumnIndex.HEURISTIC).equals(heuristic) && line.get(ColumnIndex.PROGRAM).equals(programName)){
						column.add(Integer.parseInt(line.get(i)));
					}
				}
			}
			effortColumns.add(column);
			column = new ArrayList<Integer>();
		}
		return effortColumns;
	}
	
	//if programName = all get all programs, else get the specified program
	private List<List<Double>> getEffortColumnsPercentagePerHeuristic(String heuristic,int firstColIndex, int lastColIndex, String programName){
		List<List<Double>> effortColumns = new ArrayList<List<Double>>();
		List<Double> column = new ArrayList<Double>();
		for(int i = firstColIndex; i <= lastColIndex; i++){
			for(List<String> line : matrix){
				if(programName.equals(ALL_PROGRAMS)){
					if(line.get(ColumnIndex.HEURISTIC).equals(heuristic) && !line.get(ColumnIndex.PROGRAM).equals("TOTAL")){
						column.add(Double.parseDouble(line.get(i)));
					}
				}else{
					if(line.get(ColumnIndex.HEURISTIC).equals(heuristic) && line.get(ColumnIndex.PROGRAM).equals(programName)){
						column.add(Double.parseDouble(line.get(i)));
					}
				}
			}
			effortColumns.add(column);
			column = new ArrayList<Double>();
		}
		return effortColumns;
	}
	
	private List<List<String>> getEfficiencyLinesPerHeuristic(String heuristic,int firstColIndex, int lastColIndex, String programName){
		List<List<String>> efficiencyLines = new ArrayList<List<String>>();
		List<String> newLine = new ArrayList<String>();
		boolean closeToLine = false;
		int columns;
		if(!isDeltaBudget){
			columns = ColumnIndex.TOTAL_COLUMNS;
		}else{
			columns = ColumnIndex.DB_TOTAL_COLUMNS;
		}
		newLine.add("Efficiency");
		if(programName.equals(ALL_PROGRAMS)){
			newLine.add("TOTAL");
		}else{
			newLine.add(programName);
		}
		newLine.add(heuristic);
		for(int i = 1; i < columns-3; i++){
			newLine.add("");
		}
		efficiencyLines.add(newLine);
		newLine = new ArrayList<String>();
		
		for(List<String> line : matrix){
			if(programName.equals(ALL_PROGRAMS)){
				if(line.get(ColumnIndex.PROGRAM).equals("TOTAL") && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					closeToLine = true;
					continue;
				}
				if(closeToLine && line.get(ColumnIndex.PROGRAM).startsWith("budget 1 - ")){
					newLine.add("Delta, "+line.get(ColumnIndex.PROGRAM));
					newLine.add("icd");
					newLine.add("bl");
					newLine.add("icd");
					newLine.add("mhs");
					newLine.add("mhs");
					newLine.add("bl");
					newLine.add("icd");
					newLine.add("bl");
					newLine.add("mhs");
					
					efficiencyLines.add(newLine);
					newLine = new ArrayList<String>();
					for(int i = firstColIndex; i <= lastColIndex; i++){
						newLine.add(line.get(i));
					}
					efficiencyLines.addAll(getEfficiencyPerDelta(newLine));
					
					newLine = new ArrayList<String>();
				}
				if(closeToLine && (!line.get(ColumnIndex.PROGRAM).startsWith("budget 1 - ")) && efficiencyLines.size() > 1){
					closeToLine = false;
					break;
				}
				/*if(line.get(PROGRAM_COL).startsWith("program") && line.get(HEUR_COL).equals("heuristic") && efficiencyLines.size() == 1){
					closeToLine = true;
				}*/
			}else{
				if(line.get(ColumnIndex.PROGRAM).equals(programName) && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					closeToLine = true;
					continue;
				}
				if(closeToLine && line.get(ColumnIndex.PROGRAM).startsWith("budget 1 - ")){
					newLine.add("Delta, "+line.get(ColumnIndex.PROGRAM));
					newLine.add("icd");
					newLine.add("bl");
					newLine.add("icd");
					newLine.add("mhs");
					newLine.add("mhs");
					newLine.add("bl");
					newLine.add("icd");
					newLine.add("bl");
					newLine.add("mhs");
					
					efficiencyLines.add(newLine);
					newLine = new ArrayList<String>();
					for(int i = firstColIndex; i <= lastColIndex; i++){
						newLine.add(line.get(i));
					}
					efficiencyLines.addAll(getEfficiencyPerDelta(newLine));
					
					newLine = new ArrayList<String>();
				}
				if(closeToLine && (!line.get(ColumnIndex.PROGRAM).startsWith("budget 1 - "))){
					closeToLine = false;
					break;
				}
			}
		}
		newLine = new ArrayList<String>();
		for(int i = 1; i < columns; i++){
			newLine.add("");
		}
		efficiencyLines.add(newLine);
				
		return efficiencyLines;
	}
	
	private List<List<String>> getEfficiencyPerDelta(List<String> efficiencyLine){
		List<String> line = new ArrayList<String>();
		List<List<String>> convertedLines = new ArrayList<List<String>>();
		int j = 0;
		int i = 0;
		if(!isDeltaBudget){
			for(int delta = 0; delta < DELTA_VALUES.length; delta++){
				line.add(String.valueOf(DELTA_VALUES[delta]));
				line.add(efficiencyLine.get(i));
				line.add(efficiencyLine.get(i+1));
				line.add(efficiencyLine.get(i+30));
				line.add(efficiencyLine.get(i+31));
				line.add(efficiencyLine.get(i+60));
				line.add(efficiencyLine.get(i+61));
				line.add(efficiencyLine.get(j+90));
				line.add(efficiencyLine.get(j+91));
				line.add(efficiencyLine.get(j+92));
				i += 2;
				j += 3;
				convertedLines.add(line);
				line = new ArrayList<String>();
			}
		}else{
			for(int delta = 0; delta < DELTA_BUDGET_RANGES.length; delta++){
				line.add(String.valueOf(DELTA_BUDGET_RANGES[delta]));
				line.add(efficiencyLine.get(i));
				line.add(efficiencyLine.get(i+1));
				line.add(efficiencyLine.get(i+30));
				line.add(efficiencyLine.get(i+31));
				line.add(efficiencyLine.get(i+60));
				line.add(efficiencyLine.get(i+61));
				line.add(efficiencyLine.get(j+90));
				line.add(efficiencyLine.get(j+91));
				line.add(efficiencyLine.get(j+92));
				i += 2;
				j += 3;
				convertedLines.add(line);
				line = new ArrayList<String>();
			}
		}
		return convertedLines;
	}
	
	//for DeltaBudget
	private List<String> sumEffortBudgetDB(String heuristic,int effortBudget, boolean blockEffort, String programName){
		List<List<Integer>> effortMatrix;
		int icdIndex;
		int blIndex;
		int mhsIndex;
		int indexEffortBudget = 0;
		for(int i : DELTA_BUDGET_RANGES){
			if(i == effortBudget){
				break;
			}
			indexEffortBudget++;
		}
		if(blockEffort){
			effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndex.DB_ABS_BLOCKS_IDX_BEGIN,ColumnIndex.DB_ABS_BLOCKS_IDX_END,programName);
			icdIndex = indexEffortBudget;//DB_ABS_BLOCKS_IDX_BEGIN + indexEffortBudget;
			blIndex = 15;//DB_ABS_BLOCKS_IDX_BEGIN + 15;
			mhsIndex = icdIndex+16;//DB_ABS_BLOCKS_IDX_BEGIN + 15 + indexEffortBudget + 1;
		}else{
			effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndex.DB_ABS_METHODS_IDX_BEGIN,ColumnIndex.DB_ABS_METHODS_IDX_END,programName);
			icdIndex = indexEffortBudget;//DB_ABS_METHODS_IDX_BEGIN + indexEffortBudget;
			blIndex = -1;//DB_ABS_METHODS_IDX_BEGIN + 15;
			mhsIndex = icdIndex+15;//DB_ABS_METHODS_IDX_BEGIN + 15 + indexEffortBudget;
		}
		List<String> effortBudgetRow = new ArrayList<String>();
		int effortOccurrences = 0;
		int effortBudgetIndex = 0;
		for(List<Integer> effortColumn : effortMatrix){
			if(effortBudgetIndex == icdIndex || effortBudgetIndex == blIndex || effortBudgetIndex == mhsIndex){
				for(Integer effort : effortColumn){
					if(effort <= effortBudget){
						effortOccurrences++;
					}
				}
				effortBudgetRow.add(String.valueOf(effortOccurrences));
				effortOccurrences = 0;
			}
			effortBudgetIndex++;
		}
		return effortBudgetRow;
	}
	
	
		
	//for DeltaBudget
	private List<String> sumEffortBudgetMethodAverageDB(String heuristic,int effortBudget, boolean blockEffort, String programName){
		List<List<Integer>> effortMatrix;
		List<List<Integer>> effortMatrixMethods;
		int icdIndex;
		int blIndex;
		int mhsIndex;
		int indexEffortBudget = 0;
		for(int i : DELTA_BUDGET_RANGES){
			if(i == effortBudget){
				break;
			}
			indexEffortBudget++;
		}
		effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndex.DB_ABS_BLOCKS_IDX_BEGIN,ColumnIndex.DB_ABS_BLOCKS_IDX_END,programName);
		effortMatrixMethods = getEffortColumnsPerHeuristic(heuristic,ColumnIndex.DB_ABS_METHODS_IDX_BEGIN,ColumnIndex.DB_ABS_METHODS_IDX_END,programName);
		icdIndex = indexEffortBudget;
		blIndex = 15;
		mhsIndex = icdIndex+16;
		List<String> effortBudgetRow = new ArrayList<String>();
		int examinedMethods = 0;
		int effortOccurrences = 0;
		int effortBudgetIndex = 0;
		for(List<Integer> effortColumn : effortMatrix){
			if(effortBudgetIndex == icdIndex){
				int line = 0;
				for(Integer effort : effortColumn){
					if(effort <= effortBudget){
						effortOccurrences++;
						examinedMethods += ((List<Integer>)effortMatrixMethods.get(effortBudgetIndex)).get(line);
					}
					line++;
				}
				effortBudgetRow.add(String.format("%.2f",((double)examinedMethods/effortOccurrences)));
				effortOccurrences = 0;
				examinedMethods = 0;
			}
			if(effortBudgetIndex == mhsIndex){
				int line = 0;
				for(Integer effort : effortColumn){
					if(effort <= effortBudget){
						effortOccurrences++;
						examinedMethods += ((List<Integer>)effortMatrixMethods.get(effortBudgetIndex-1)).get(line);
					}
					line++;
				}
				effortBudgetRow.add(String.format("%.2f",((double)examinedMethods/effortOccurrences)));
				effortOccurrences = 0;
				examinedMethods = 0;
			}
			effortBudgetIndex++;
		}
		return effortBudgetRow;
	}
	
	//for DeltaBudget
	private List<String> sumPercentageEffortAverageDB(String heuristic,int effortBudget, boolean blockEffort, String programName){
		List<List<Double>> effortMatrix;
		List<List<Double>> effortMatrixPercentage;
		int icdIndex;
		int blIndex;
		int mhsIndex;
		int indexEffortBudget = 0;
		for(int i : DELTA_BUDGET_RANGES){
			if(i == effortBudget){
				break;
			}
			indexEffortBudget++;
		}
		effortMatrix = getEffortColumnsPercentagePerHeuristic(heuristic,ColumnIndex.DB_ABS_BLOCKS_IDX_BEGIN,ColumnIndex.DB_ABS_BLOCKS_IDX_END,programName);
		effortMatrixPercentage = getEffortColumnsPercentagePerHeuristic(heuristic,ColumnIndex.DB_PERC_BLOCKS_IDX_BEGIN,ColumnIndex.DB_PERC_BLOCKS_IDX_END,programName);
		icdIndex = indexEffortBudget;
		blIndex = 15;
		mhsIndex = icdIndex+16;
		List<String> effortBudgetRow = new ArrayList<String>();
		double examinedMethods = 0;
		int effortOccurrences = 0;
		int effortBudgetIndex = 0;
		for(List<Double> effortColumn : effortMatrix){
			if(effortBudgetIndex == icdIndex || effortBudgetIndex == blIndex  || effortBudgetIndex == mhsIndex){
				int line = 0;
				for(Double effort : effortColumn){
					if(effort <= effortBudget){
						effortOccurrences++;
						examinedMethods += ((List<Double>)effortMatrixPercentage.get(effortBudgetIndex)).get(line);
					}
					line++;
				}
				effortBudgetRow.add(String.format("%.4f",(examinedMethods/effortOccurrences)));
				effortOccurrences = 0;
				examinedMethods = 0;
			}
			effortBudgetIndex++;
		}
		return effortBudgetRow;
	}
	
	//for DeltaBudget
	private List<String> sumPercentageMethodAverageDB(String heuristic,int effortBudget, boolean blockEffort, String programName){
		List<List<Double>> effortMatrix;
		List<List<Double>> effortMatrixPercentage;
		int icdIndex;
		int blIndex;
		int mhsIndex;
		int indexEffortBudget = 0;
		for(int i : DELTA_BUDGET_RANGES){
			if(i == effortBudget){
				break;
			}
			indexEffortBudget++;
		}
		effortMatrix = getEffortColumnsPercentagePerHeuristic(heuristic,ColumnIndex.DB_ABS_BLOCKS_IDX_BEGIN,ColumnIndex.DB_ABS_BLOCKS_IDX_END,programName);
		effortMatrixPercentage = getEffortColumnsPercentagePerHeuristic(heuristic,ColumnIndex.DB_PERC_METHODS_IDX_BEGIN,ColumnIndex.DB_PERC_METHODS_IDX_END,programName);
		icdIndex = indexEffortBudget;
		blIndex = 15;
		mhsIndex = icdIndex+16;
		List<String> effortBudgetRow = new ArrayList<String>();
		double examinedMethods = 0;
		int effortOccurrences = 0;
		int effortBudgetIndex = 0;
		for(List<Double> effortColumn : effortMatrix){
			if(effortBudgetIndex == icdIndex){
				int line = 0;
				for(Double effort : effortColumn){
					if(effort <= effortBudget){
						effortOccurrences++;
						examinedMethods += ((List<Double>)effortMatrixPercentage.get(effortBudgetIndex)).get(line);
					}
					line++;
				}
				effortBudgetRow.add(String.format("%.4f",(examinedMethods/effortOccurrences)));
				effortOccurrences = 0;
				examinedMethods = 0;
			}
			if(effortBudgetIndex == mhsIndex){
				int line = 0;
				for(Double effort : effortColumn){
					if(effort <= effortBudget){
						effortOccurrences++;
						examinedMethods += ((List<Double>)effortMatrixPercentage.get(effortBudgetIndex-1)).get(line);
					}
					line++;
				}
				effortBudgetRow.add(String.format("%.4f",(examinedMethods/effortOccurrences)));
				effortOccurrences = 0;
				examinedMethods = 0;
			}
			effortBudgetIndex++;
		}
		return effortBudgetRow;
	}	
	
	private List<String> calculateEfficiency(List<String> effortRow){
		List<String> efficiencyRow = new ArrayList<String>();
		int icdIndex = 17;
		int blIndex = 32;
		int mhsIndex = 33;
		if(!isDeltaBudget){
			icdIndex = 7;
			blIndex = 22;
			mhsIndex = 23;
		}
		for(int budgetIndex = 0; budgetIndex < DELTA_BUDGET_RANGES.length; budgetIndex++){
			int icdEffort = Integer.parseInt(effortRow.get(icdIndex+budgetIndex));
			int blEffort = Integer.parseInt(effortRow.get(blIndex));
			if(icdEffort > 100 && blEffort > 100){ //both numbers must be lower than 101
				efficiencyRow.add("0");
				efficiencyRow.add("0");
				continue;
			}
			if(icdEffort < blEffort){
				efficiencyRow.add("1");
				efficiencyRow.add("0");
			}else if(icdEffort > blEffort){
				efficiencyRow.add("0");
				efficiencyRow.add("1");
			}else{
				efficiencyRow.add("0");
				efficiencyRow.add("0");
			}
		}
		for(int budgetIndex = 0; budgetIndex < DELTA_BUDGET_RANGES.length; budgetIndex++){
			int icdEffort = Integer.parseInt(effortRow.get(icdIndex+budgetIndex));
			int mhsEffort = Integer.parseInt(effortRow.get(mhsIndex+budgetIndex));
			if(icdEffort > 100 && mhsEffort > 100){ //both numbers must be lower than 101
				efficiencyRow.add("0");
				efficiencyRow.add("0");
				continue;
			}
			if(icdEffort < mhsEffort){
				efficiencyRow.add("1");
				efficiencyRow.add("0");
			}else if(icdEffort > mhsEffort){
				efficiencyRow.add("0");
				efficiencyRow.add("1");
			}else{
				efficiencyRow.add("0");
				efficiencyRow.add("0");
			}
		}
		for(int budgetIndex = 0; budgetIndex < DELTA_BUDGET_RANGES.length; budgetIndex++){
			int mhsEffort = Integer.parseInt(effortRow.get(mhsIndex+budgetIndex));
			int blEffort = Integer.parseInt(effortRow.get(blIndex));
			if(mhsEffort > 100 && blEffort > 100){ //both numbers must be lower than 101
				efficiencyRow.add("0");
				efficiencyRow.add("0");
				continue;
			}
			if(mhsEffort < blEffort){
				efficiencyRow.add("1");
				efficiencyRow.add("0");
			}else if(mhsEffort > blEffort){
				efficiencyRow.add("0");
				efficiencyRow.add("1");
			}else{
				efficiencyRow.add("0");
				efficiencyRow.add("0");
			}
		}
		for(int budgetIndex = 0; budgetIndex < DELTA_BUDGET_RANGES.length; budgetIndex++){
			int icdEffort = Integer.parseInt(effortRow.get(icdIndex+budgetIndex));
			int blEffort = Integer.parseInt(effortRow.get(blIndex));
			int mhsEffort = Integer.parseInt(effortRow.get(mhsIndex+budgetIndex));
			if(icdEffort > 100 && blEffort > 100 && mhsEffort > 100){ //both numbers must be lower than 101
				efficiencyRow.add("0");
				efficiencyRow.add("0");
				efficiencyRow.add("0");
				continue;
			}
			if(icdEffort < blEffort){
				if(icdEffort < mhsEffort){
					efficiencyRow.add("1");
					efficiencyRow.add("0");
					efficiencyRow.add("0");
				}else if(icdEffort > mhsEffort){
					efficiencyRow.add("0");
					efficiencyRow.add("0");
					efficiencyRow.add("1");
				}else{
					efficiencyRow.add("1");
					efficiencyRow.add("0");
					efficiencyRow.add("1");
				}
			}else if(icdEffort > blEffort){
				if(blEffort < mhsEffort){
					efficiencyRow.add("0");
					efficiencyRow.add("1");
					efficiencyRow.add("0");
				}else if(blEffort > mhsEffort){
					efficiencyRow.add("0");
					efficiencyRow.add("0");
					efficiencyRow.add("1");
				}else{
					efficiencyRow.add("0");
					efficiencyRow.add("1");
					efficiencyRow.add("1");
				}
			}else{
				if(blEffort < mhsEffort){
					efficiencyRow.add("1");
					efficiencyRow.add("1");
					efficiencyRow.add("0");
				}else if(blEffort > mhsEffort){
					efficiencyRow.add("0");
					efficiencyRow.add("0");
					efficiencyRow.add("1");
				}else{
					efficiencyRow.add("0");
					efficiencyRow.add("0");
					efficiencyRow.add("0");
				}
			}
		}
		return efficiencyRow;
	}
	
	private List<String> sumEfficiency(String heuristic,String programName, int budget){
		List<List<Integer>> efficiencyMatrix;
		List<List<Integer>> effortMatrix;
		if(!isDeltaBudget){
			efficiencyMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndex.EFFICIENCY_IDX_BEGIN,ColumnIndex.EFFICIENCY_IDX_END,programName);
			effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndex.ABS_BLOCKS_IDX_BEGIN,ColumnIndex.ABS_BLOCKS_IDX_END,programName);
		}else{
			efficiencyMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndex.DB_EFFICIENCY_IDX_BEGIN,ColumnIndex.DB_EFFICIENCY_IDX_END,programName);
			effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndex.DB_ABS_BLOCKS_IDX_BEGIN,ColumnIndex.DB_ABS_BLOCKS_IDX_END,programName);
		}
		List<String> efficiencyRow = new ArrayList<String>();
		int countEfficiency = 0;
		for(int i = 0; i < efficiencyMatrix.size();i++){
			List<Integer> efficiencyColumn = efficiencyMatrix.get(i);
			if(i >= 0 && i < 30){ //ICD x BL
				if(i%2==0){//if pair is ICD column
					for(int j = 0;j < efficiencyColumn.size();j++){
						Integer efficiency = efficiencyColumn.get(j);
						if(efficiency == 1 && effortMatrix.get(i/2).get(j)<= budget){
							countEfficiency++;
						}
					}
				}else{// odd is BL
					for(int j = 0;j < efficiencyColumn.size();j++){
						Integer efficiency = efficiencyColumn.get(j);
						if(efficiency == 1 && effortMatrix.get(15).get(j)<= budget){
							countEfficiency++;
						}
					}
				}
			}
			if(i >= 30 && i < 60){ //ICD x MHS
				int index = i - 30;
				if(index%2==0){//if pair is ICD column
					for(int j = 0;j < efficiencyColumn.size();j++){
						Integer efficiency = efficiencyColumn.get(j);
						if(efficiency == 1 && effortMatrix.get(index/2).get(j)<= budget){
							countEfficiency++;
						}
					}
				}else{// odd is MHS
					for(int j = 0;j < efficiencyColumn.size();j++){
						Integer efficiency = efficiencyColumn.get(j);
						if(efficiency == 1 && effortMatrix.get(index/2+16).get(j)<= budget){
							countEfficiency++;
						}
					}
				}
			}
			if(i >= 60 && i < 90){ //MHS x BL
				int index = i - 60;
				if(index%2==0){//if pair is MHS column
					for(int j = 0;j < efficiencyColumn.size();j++){
						Integer efficiency = efficiencyColumn.get(j);
						if(efficiency == 1 && effortMatrix.get(index/2+16).get(j)<= budget){
							countEfficiency++;
						}
					}
				}else{// odd is BL
					for(int j = 0;j < efficiencyColumn.size();j++){
						Integer efficiency = efficiencyColumn.get(j);
						if(efficiency == 1 && effortMatrix.get(15).get(j)<= budget){
							countEfficiency++;
						}
					}
				}
			}
			if(i >= 90){ //ICD x BL x MHS
				int index = i - 90;
				if(index%3==0){// is MHS column
					for(int j = 0;j < efficiencyColumn.size();j++){
						Integer efficiency = efficiencyColumn.get(j);
						if(efficiency == 1 && effortMatrix.get(index/3).get(j)<= budget){
							countEfficiency++;
						}
					}
				}else if((index+2)%3==0){// is BL
					for(int j = 0;j < efficiencyColumn.size();j++){
						Integer efficiency = efficiencyColumn.get(j);
						if(efficiency == 1 && effortMatrix.get(15).get(j)<= budget){
							countEfficiency++;
						}
					}
				}else{
					for(int j = 0;j < efficiencyColumn.size();j++){
						Integer efficiency = efficiencyColumn.get(j);
						if(efficiency == 1 && effortMatrix.get(index/3+16).get(j)<= budget){
							countEfficiency++;
						}
					}
				}
			}
			efficiencyRow.add(String.valueOf(countEfficiency));
			countEfficiency = 0;
		}
		/*for(List<Integer> efficiencyColumn : efficiencyMatrix){
			for(Integer effort : efficiencyColumn){
				countEfficiency +=effort;
			}
			efficiencyRow.add(String.valueOf(countEfficiency));
			countEfficiency = 0;
		}*/
		return efficiencyRow;
	}
	
	private List<String> sumPercentageDB(String heuristic,int effortBudget, boolean blockEffort, String programName){
		List<List<Double>> effortMatrix;
		int icdIndex;
		int blIndex;
		int mhsIndex;
		int indexEffortBudget = 0;
		for(int i : DB_PERCENTUAL_RANGES){
			if(i == effortBudget){
				break;
			}
			indexEffortBudget++;
		}
		if(blockEffort){
			effortMatrix = getEffortColumnsPercentagePerHeuristic(heuristic,ColumnIndex.DB_PERC_BLOCKS_IDX_BEGIN,ColumnIndex.DB_PERC_BLOCKS_IDX_END,programName);
			icdIndex = indexEffortBudget;//DB_PERC_BLOCKS_IDX_BEGIN + indexEffortBudget;
			blIndex = 15;//DB_PERC_BLOCKS_IDX_BEGIN + 15;
			mhsIndex = icdIndex+16;//DB_PERC_BLOCKS_IDX_BEGIN + 15 + indexEffortBudget + 1;
		}else{
			effortMatrix = getEffortColumnsPercentagePerHeuristic(heuristic,ColumnIndex.DB_PERC_METHODS_IDX_BEGIN,ColumnIndex.DB_PERC_METHODS_IDX_END,programName);
			icdIndex = indexEffortBudget;//DB_PERC_METHODS_IDX_BEGIN + indexEffortBudget;
			blIndex = -1;//DB_PERC_METHODS_IDX_BEGIN + 15;
			mhsIndex = icdIndex+15;//DB_PERC_METHODS_IDX_BEGIN + 15 + indexEffortBudget + 1;
		}
		List<String> effortBudgetRow = new ArrayList<String>();
		int effortOccurrences = 0;
		int effortBudgetIndex = 0;
		for(List<Double> effortColumn : effortMatrix){
			if(effortBudgetIndex == icdIndex || effortBudgetIndex == blIndex || effortBudgetIndex == mhsIndex){
				for(Double effort : effortColumn){
					if(effort <= (double)effortBudget/100){
						effortOccurrences++;
					}
				}
				effortBudgetRow.add(String.valueOf(effortOccurrences));
				effortOccurrences = 0;
			}
			effortBudgetIndex++;
		}
		return effortBudgetRow;
	}
	
	
	public void generateCSVFile(){
		try {
 			OutputStream os = new FileOutputStream(new File(PATHFILE+"icd-output.csv"));
            os.write(export());
            os.close();
	 	} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void generateLogFile(FaultInfo faultInfo,String heuristic){
		File logFile = new File(PATHFILE+"icd-inspection-log_"+faultInfo.getProgramName()+"_"+faultInfo.getProgramVersion()+"_"+faultInfo.getFaultName()+"_"+heuristic+".txt");
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
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, RangeIndex.icd_bl_mhs_0_7(),RangeIndex.budget_5_100());
		range = "delta_0_7";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, RangeIndex.icd_bl_mhs_10_30(),RangeIndex.budget_5_100());
		range = "delta_10_30";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, RangeIndex.icd_bl_mhs_35_75(),RangeIndex.budget_5_100());
		range = "delta_35_75";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		//effectiveness - methods - absolute
		requirement = "methods";
		xAxis = "Inspected methods";
		fileName = strategy+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
		//chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, RangeIndex.icd_mhs_met_0_7(),RangeIndex.method_row_header_1_30_plus());
		range = "delta_0_7";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, RangeIndex.icd_mhs_met_10_30(),RangeIndex.method_row_header_1_30_plus());
		range = "delta_10_30";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, RangeIndex.icd_mhs_met_35_75(),RangeIndex.method_row_header_1_30_plus());
		range = "delta_35_75";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
	}
	
	private void generatePercentualEffectivenessCharts(String heuristic, String programName, String strategy){
		DataParser parser = new DataParser();
		String analysisType = "%_effectiveness";
		String xAxis = "Inspected Blocks (%)";
		String yAxis = "Effort (%)";
		String requirement = "blocks";
		String range;
		String fileName = "";
		String chartTitle = "";
		ChartGenerator chart = new ChartGenerator();
		Map<String,List<String>> effortMapPercentualDataset = new HashMap<String,List<String>>();
		
		//effectiveness - blocks - percentual
		fileName = strategy+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
		chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
		
		effortMapPercentualDataset = parser.createLineChartDataset(matrix, heuristic, programName, RangeIndex.icd_bl_mhs_perc_0_7(), RangeIndex.perc_block_row_header_1_100());
		range = "delta_0_7";
		chart.loadLineChartDataset(effortMapPercentualDataset,analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortMapPercentualDataset = parser.createLineChartDataset(matrix, heuristic, programName, RangeIndex.icd_bl_mhs_perc_10_30(), RangeIndex.perc_block_row_header_1_100());
		range = "delta_10_30";
		chart.loadLineChartDataset(effortMapPercentualDataset,analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortMapPercentualDataset = parser.createLineChartDataset(matrix, heuristic, programName, RangeIndex.icd_bl_mhs_perc_35_75(), RangeIndex.perc_block_row_header_1_100());
		range = "delta_35_75";
		chart.loadLineChartDataset(effortMapPercentualDataset,analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		
		//effectiveness - methods - percentual
		xAxis = "Inspected Methods (%)";
		requirement = "methods";
		fileName = strategy+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
		chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
		
		effortMapPercentualDataset = parser.createLineChartDataset(matrix, heuristic, programName, RangeIndex.icd_mhs_met_perc_0_7(), RangeIndex.perc_method_row_header_1_100());
		range = "delta_0_7";
		chart.loadLineChartDataset(effortMapPercentualDataset,analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortMapPercentualDataset = parser.createLineChartDataset(matrix, heuristic, programName, RangeIndex.icd_mhs_met_perc_10_30(), RangeIndex.perc_method_row_header_1_100());
		range = "delta_10_30";
		chart.loadLineChartDataset(effortMapPercentualDataset,analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortMapPercentualDataset = parser.createLineChartDataset(matrix, heuristic, programName, RangeIndex.icd_mhs_met_perc_35_75(), RangeIndex.perc_method_row_header_1_100());
		range = "delta_35_75";
		chart.loadLineChartDataset(effortMapPercentualDataset,analysisType, xAxis, yAxis, chartTitle, fileName+range);
	}
	
	private void generateEfficiencyCharts(String heuristic, String programName, String strategy){
		DataParser parser = new DataParser();
		String analysisType = "efficiency";
		String xAxis = "Delta Budget";
		String yAxis = "Faults found";
		String requirement = "blocks";
		String fileName = "";
		String chartTitle = "";
		String comparison = "";
		ChartGenerator chart = new ChartGenerator();
		List<List<String>> effortDataset;
		Map<String,List<List<String>>> effortMapEfficiencyDataset = new HashMap<String,List<List<String>>>();
		Set<String> effortSet;
		ChartType chartType = ChartType.LayeredBarChart;
		
		//icd x bl
		effortMapEfficiencyDataset = parser.createEfficiencyBarChartDataset(matrix, heuristic, programName, RangeIndex.efficiency_icd_bl(), RangeIndex.efficiency_delta_0_100());
		effortSet = effortMapEfficiencyDataset.keySet();
		comparison = "icd_x_bl_";
		
		for(String effortCategory : effortSet){
			effortDataset = effortMapEfficiencyDataset.get(effortCategory);
			String details = comparison+effortCategory.replace(" ", "");
			fileName = strategy+"_"+details+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
			chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
			chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName);
		}
		
		//icd x mhs
		effortMapEfficiencyDataset = parser.createEfficiencyBarChartDataset(matrix, heuristic, programName, RangeIndex.efficiency_icd_mhs(), RangeIndex.efficiency_delta_0_100());
		effortSet = effortMapEfficiencyDataset.keySet();
		comparison = "icd_x_mhs_";
		
		for(String effortCategory : effortSet){
			effortDataset = effortMapEfficiencyDataset.get(effortCategory);
			String details = comparison+effortCategory.replace(" ", "");
			fileName = strategy+"_"+details+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
			chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
			chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName);
		}
		
		//mhs x bl
		effortMapEfficiencyDataset = parser.createEfficiencyBarChartDataset(matrix, heuristic, programName, RangeIndex.efficiency_mhs_bl(), RangeIndex.efficiency_delta_0_100());
		effortSet = effortMapEfficiencyDataset.keySet();
		comparison = "mhs_x_bl_";
		
		for(String effortCategory : effortSet){
			effortDataset = effortMapEfficiencyDataset.get(effortCategory);
			String details = comparison+effortCategory.replace(" ", "");
			fileName = strategy+"_"+details+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
			chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
			chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName);
		}
		
		//icd x bl x mhs
		effortMapEfficiencyDataset = parser.createEfficiencyBarChartDataset(matrix, heuristic, programName, RangeIndex.efficiency_icd_bl_mhs(), RangeIndex.efficiency_delta_0_100());
		effortSet = effortMapEfficiencyDataset.keySet();
		comparison = "icd_x_bl_x_mhs_";
		
		for(String effortCategory : effortSet){
			effortDataset = effortMapEfficiencyDataset.get(effortCategory);
			String details = comparison+effortCategory.replace(" ", "");
			fileName = strategy+"_"+details+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
			chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
			chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName);
		}
	}
	
	private void generateDeltaBudgetEffectivenessCharts(String heuristic, String programName, String strategy){
		DataParser parser = new DataParser();
		String analysisType = "effectiveness";
		String xAxis = "Budgets";
		String yAxis = "Effort";
		String requirement = "blocks";
		String fileName = "";
		String chartTitle = "";
		ChartGenerator chart = new ChartGenerator();
		List<List<String>> effortDataset;
		ChartType chartType = ChartType.LayeredBarChart;
		
		fileName = strategy+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
		chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, RangeIndex.delta_budget_icd_bl_mhs(), RangeIndex.budget_5_100());
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName);

	}
	
	private void generateCharts() {
		String heuristic = TARANTULA;
		String strategy = "original";
		if(!isDeltaBudget){
			generateAbsoluteEffectivenessCharts(heuristic,ANT,strategy);
			generateAbsoluteEffectivenessCharts(heuristic,COMMONS_MATH,strategy);
			generateAbsoluteEffectivenessCharts(heuristic,HSQLDB,strategy);
			generateAbsoluteEffectivenessCharts(heuristic,JTOPAS,strategy);
			generateAbsoluteEffectivenessCharts(heuristic,PMD,strategy);
			generateAbsoluteEffectivenessCharts(heuristic,XML_SECURITY,strategy);
			generateAbsoluteEffectivenessCharts(heuristic,XSTREAM,strategy);
			generateAbsoluteEffectivenessCharts(heuristic,ALL_PROGRAMS,strategy);
			generatePercentualEffectivenessCharts(heuristic,ANT,strategy);
			generatePercentualEffectivenessCharts(heuristic,COMMONS_MATH,strategy);
			generatePercentualEffectivenessCharts(heuristic,HSQLDB,strategy);
			generatePercentualEffectivenessCharts(heuristic,JTOPAS,strategy);
			generatePercentualEffectivenessCharts(heuristic,PMD,strategy);
			generatePercentualEffectivenessCharts(heuristic,XML_SECURITY,strategy);
			generatePercentualEffectivenessCharts(heuristic,XSTREAM,strategy);
			generatePercentualEffectivenessCharts(heuristic,ALL_PROGRAMS,strategy);
			generateEfficiencyCharts(heuristic,ANT,strategy);
			generateEfficiencyCharts(heuristic,COMMONS_MATH,strategy);
			generateEfficiencyCharts(heuristic,HSQLDB,strategy);
			generateEfficiencyCharts(heuristic,JTOPAS,strategy);
			generateEfficiencyCharts(heuristic,PMD,strategy);
			generateEfficiencyCharts(heuristic,XML_SECURITY,strategy);
			generateEfficiencyCharts(heuristic,XSTREAM,strategy);
			generateEfficiencyCharts(heuristic,ALL_PROGRAMS,strategy);
			heuristic = OCHIAI;
			generateAbsoluteEffectivenessCharts(heuristic,ANT,strategy);
			generateAbsoluteEffectivenessCharts(heuristic,COMMONS_MATH,strategy);
			generateAbsoluteEffectivenessCharts(heuristic,HSQLDB,strategy);
			generateAbsoluteEffectivenessCharts(heuristic,JTOPAS,strategy);
			generateAbsoluteEffectivenessCharts(heuristic,PMD,strategy);
			generateAbsoluteEffectivenessCharts(heuristic,XML_SECURITY,strategy);
			generateAbsoluteEffectivenessCharts(heuristic,XSTREAM,strategy);
			generateAbsoluteEffectivenessCharts(heuristic,ALL_PROGRAMS,strategy);
			generatePercentualEffectivenessCharts(heuristic,ANT,strategy);
			generatePercentualEffectivenessCharts(heuristic,COMMONS_MATH,strategy);
			generatePercentualEffectivenessCharts(heuristic,HSQLDB,strategy);
			generatePercentualEffectivenessCharts(heuristic,JTOPAS,strategy);
			generatePercentualEffectivenessCharts(heuristic,PMD,strategy);
			generatePercentualEffectivenessCharts(heuristic,XML_SECURITY,strategy);
			generatePercentualEffectivenessCharts(heuristic,XSTREAM,strategy);
			generatePercentualEffectivenessCharts(heuristic,ALL_PROGRAMS,strategy);
			generateEfficiencyCharts(heuristic,ANT,strategy);
			generateEfficiencyCharts(heuristic,COMMONS_MATH,strategy);
			generateEfficiencyCharts(heuristic,HSQLDB,strategy);
			generateEfficiencyCharts(heuristic,JTOPAS,strategy);
			generateEfficiencyCharts(heuristic,PMD,strategy);
			generateEfficiencyCharts(heuristic,XML_SECURITY,strategy);
			generateEfficiencyCharts(heuristic,XSTREAM,strategy);
			generateEfficiencyCharts(heuristic,ALL_PROGRAMS,strategy);
						
		}else{
			strategy = "delta_budget";
			generateDeltaBudgetEffectivenessCharts(heuristic,ANT,strategy);
			generateDeltaBudgetEffectivenessCharts(heuristic,COMMONS_MATH,strategy);
			generateDeltaBudgetEffectivenessCharts(heuristic,HSQLDB,strategy);
			generateDeltaBudgetEffectivenessCharts(heuristic,JTOPAS,strategy);
			generateDeltaBudgetEffectivenessCharts(heuristic,PMD,strategy);
			generateDeltaBudgetEffectivenessCharts(heuristic,XML_SECURITY,strategy);
			generateDeltaBudgetEffectivenessCharts(heuristic,XSTREAM,strategy);
			generateDeltaBudgetEffectivenessCharts(heuristic,ALL_PROGRAMS,strategy);
			heuristic = OCHIAI;
			generateDeltaBudgetEffectivenessCharts(heuristic,ANT,strategy);
			generateDeltaBudgetEffectivenessCharts(heuristic,COMMONS_MATH,strategy);
			generateDeltaBudgetEffectivenessCharts(heuristic,HSQLDB,strategy);
			generateDeltaBudgetEffectivenessCharts(heuristic,JTOPAS,strategy);
			generateDeltaBudgetEffectivenessCharts(heuristic,PMD,strategy);
			generateDeltaBudgetEffectivenessCharts(heuristic,XML_SECURITY,strategy);
			generateDeltaBudgetEffectivenessCharts(heuristic,XSTREAM,strategy);
			generateDeltaBudgetEffectivenessCharts(heuristic,ALL_PROGRAMS,strategy);
		}
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
		reducedLevels_1_2.add(ColumnIndex.ICD_0);
		reducedLevels_1_2.add(ColumnIndex.ICD_1);
		reducedLevels_1_2.add(ColumnIndex.BL);
		reducedLevels_1_2.add(ColumnIndex.MHS_0);
		reducedLevels_1_2.add(ColumnIndex.MHS_1);
		List<Integer> reducedLevels_1_3 = new ArrayList<Integer>();
		reducedLevels_1_3.add(ColumnIndex.ICD_0);
		reducedLevels_1_3.add(ColumnIndex.ICD_1);
		reducedLevels_1_3.add(ColumnIndex.ICD_3);
		reducedLevels_1_3.add(ColumnIndex.BL);
		reducedLevels_1_3.add(ColumnIndex.MHS_0);
		reducedLevels_1_3.add(ColumnIndex.MHS_1);
		reducedLevels_1_3.add(ColumnIndex.MHS_3);
		List<Integer> reducedLevels_1_2_Methods = new ArrayList<Integer>();
		reducedLevels_1_2_Methods.add(ColumnIndex.ICD_MET_0);
		reducedLevels_1_2_Methods.add(ColumnIndex.ICD_MET_1);
		reducedLevels_1_2_Methods.add(ColumnIndex.MHS_MET_0);
		reducedLevels_1_2_Methods.add(ColumnIndex.MHS_MET_1);
		List<Integer> reducedLevels_1_3_Methods = new ArrayList<Integer>();
		reducedLevels_1_3_Methods.add(ColumnIndex.ICD_MET_0);
		reducedLevels_1_3_Methods.add(ColumnIndex.ICD_MET_1);
		reducedLevels_1_3_Methods.add(ColumnIndex.ICD_MET_3);
		reducedLevels_1_3_Methods.add(ColumnIndex.MHS_MET_0);
		reducedLevels_1_3_Methods.add(ColumnIndex.MHS_MET_1);
		reducedLevels_1_3_Methods.add(ColumnIndex.MHS_MET_3);
		
		
		//effectiveness - blocks - absolute
		fileName = strategy+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
		chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, reducedLevels_1_2,RangeIndex.budget_5_100());
		range = "levels_1_2";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, reducedLevels_1_3,RangeIndex.budget_5_100());
		range = "levels_1_3";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		//effectiveness - methods - absolute
		requirement = "methods";
		xAxis = "Inspected methods";
		fileName = strategy+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
		//chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, reducedLevels_1_2_Methods,RangeIndex.method_row_header_1_30_plus());
		range = "levels_1_2";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, reducedLevels_1_3_Methods,RangeIndex.method_row_header_1_30_plus());
		range = "levels_1_3";
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		
	}
	
	private void generateChartsForLevelScore() {
		String heuristic = TARANTULA;
		String strategy = "level_method_score";
		if(!isDeltaBudget){
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,ANT,strategy);
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,COMMONS_MATH,strategy);
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,HSQLDB,strategy);
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,JTOPAS,strategy);
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,PMD,strategy);
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,XML_SECURITY,strategy);
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,XSTREAM,strategy);
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,ALL_PROGRAMS,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,ANT,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,COMMONS_MATH,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,HSQLDB,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,JTOPAS,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,PMD,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,XML_SECURITY,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,XSTREAM,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,ALL_PROGRAMS,strategy);
			heuristic = OCHIAI;
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,ANT,strategy);
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,COMMONS_MATH,strategy);
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,HSQLDB,strategy);
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,JTOPAS,strategy);
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,PMD,strategy);
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,XML_SECURITY,strategy);
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,XSTREAM,strategy);
			generateAbsoluteEffectivenessChartsForLevelScore(heuristic,ALL_PROGRAMS,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,ANT,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,COMMONS_MATH,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,HSQLDB,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,JTOPAS,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,PMD,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,XML_SECURITY,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,XSTREAM,strategy);
			generateEfficiencyChartsForLevelScore(heuristic,ALL_PROGRAMS,strategy);
						
		}
	}
	
	private void generateEfficiencyChartsForLevelScore(String heuristic, String programName, String strategy){
		DataParser parser = new DataParser();
		String analysisType = "efficiency";
		String xAxis = "Delta Budget";
		String yAxis = "Faults found";
		String requirement = "blocks";
		String fileName = "";
		String chartTitle = "";
		String comparison = "";
		String range = "levels_1_3";
		ChartGenerator chart = new ChartGenerator();
		List<List<String>> effortDataset;
		Map<String,List<List<String>>> effortMapEfficiencyDataset = new HashMap<String,List<List<String>>>();
		Set<String> effortSet;
		ChartType chartType = ChartType.LayeredBarChart;
		
		//icd x mhs
		effortMapEfficiencyDataset = parser.createEfficiencyBarChartDataset(matrix, heuristic, programName, RangeIndex.efficiency_icd_mhs(), RangeIndex.efficiency_delta_0_3());
		effortSet = effortMapEfficiencyDataset.keySet();
		comparison = "icd_x_mhs_";
		
		for(String effortCategory : effortSet){
			effortDataset = effortMapEfficiencyDataset.get(effortCategory);
			String details = comparison+effortCategory.replace(" ", "");
			fileName = strategy+"_"+details+"_"+analysisType+"_"+requirement+"_"+programName+"_"+heuristic+"_";
			chartTitle = strategy +" - "+ analysisType+" - "+programName+" - "+heuristic;
			chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName+range);
		}
		
	}
	
	private List<Integer> getSequentialColumns(int beginIndex, int endIndex){
		List<Integer> columnList = new ArrayList<Integer>();
		for(int i = beginIndex; i <= endIndex; i++){
			columnList.add(i);
		}
		return columnList;
	}
	
}
