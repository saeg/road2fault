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

public class BatchExecutorLevelScoreMultipleFaults {
	
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
	
	public BatchExecutorLevelScoreMultipleFaults(String dirPath){
		PATHFILE = dirPath;
	}
	
	public void execute(){
		makeHeader();
		
		checkFaultPosition(OCHIAI,"ANT1_01",ANT,1,"CLJ_HD_1","org.apache.tools.ant.types","org.apache.tools.ant.types.CommandlineJava","getCommandline()",7);
		checkFaultPosition(OCHIAI,"ANT1_01",ANT,1,"PJH_AK_1","org.apache.tools.ant","org.apache.tools.ant.ProjectHelper","parse()",68);
		
		checkFaultPosition(OCHIAI,"ANT2_01",ANT,2,"CDJ_AK_1","org.apache.tools.ant.types","org.apache.tools.ant.types.CommandlineJava","getCommandline()",42);
		checkFaultPosition(OCHIAI,"ANT2_01",ANT,2,"PH_HD_1","org.apache.tools.ant","org.apache.tools.ant.ProjectHelper$TargetHandler","startElement(String,AttributeList)",0);
		
		checkFaultPosition(OCHIAI,"ANT3_01",ANT,3,"TG_HD_1","org.apache.tools.ant","org.apache.tools.ant.Target","setDepends(String)",7);
		checkFaultPosition(OCHIAI,"ANT3_01",ANT,3,"TG_HD_2","org.apache.tools.ant","org.apache.tools.ant.Target","setDepends(String)",92);
		
		checkFaultPosition(OCHIAI,"ANT4_01",ANT,4,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","isLegalCharacter(char)",20);
		checkFaultPosition(OCHIAI,"ANT4_01",ANT,4,"EA_HD_1","org.apache.tools.ant.types","org.apache.tools.ant.types.EnumeratedAttribute","setValue(String)",0);
		checkFaultPosition(OCHIAI,"ANT4_02",ANT,4,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","isLegalCharacter(char)",20);
		checkFaultPosition(OCHIAI,"ANT4_02",ANT,4,"FLU_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.FileUtils","getParentFile(File)",0);
		checkFaultPosition(OCHIAI,"ANT4_03",ANT,4,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","isLegalCharacter(char)",20);
		checkFaultPosition(OCHIAI,"ANT4_03",ANT,4,"SFS_HD_1","org.apache.tools.ant.util","org.apache.tools.ant.util.SourceFileScanner","restrict(String[],File,File,FileNameMapper)",113);
		checkFaultPosition(OCHIAI,"ANT4_04",ANT,4,"EA_HD_1","org.apache.tools.ant.types","org.apache.tools.ant.types.EnumeratedAttribute","setValue(String)",0);
		checkFaultPosition(OCHIAI,"ANT4_04",ANT,4,"FLU_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.FileUtils","getParentFile(File)",0);
		checkFaultPosition(OCHIAI,"ANT4_05",ANT,4,"EA_HD_1","org.apache.tools.ant.types","org.apache.tools.ant.types.EnumeratedAttribute","setValue(String)",0);
		checkFaultPosition(OCHIAI,"ANT4_05",ANT,4,"SFS_HD_1","org.apache.tools.ant.util","org.apache.tools.ant.util.SourceFileScanner","restrict(String[],File,File,FileNameMapper)",113);
		checkFaultPosition(OCHIAI,"ANT4_06",ANT,4,"FLU_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.FileUtils","getParentFile(File)",0);
		checkFaultPosition(OCHIAI,"ANT4_06",ANT,4,"SFS_HD_1","org.apache.tools.ant.util","org.apache.tools.ant.util.SourceFileScanner","restrict(String[],File,File,FileNameMapper)",113);
		checkFaultPosition(OCHIAI,"ANT4_07",ANT,4,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","isLegalCharacter(char)",20);
		checkFaultPosition(OCHIAI,"ANT4_07",ANT,4,"EA_HD_1","org.apache.tools.ant.types","org.apache.tools.ant.types.EnumeratedAttribute","setValue(String)",0);
		checkFaultPosition(OCHIAI,"ANT4_07",ANT,4,"FLU_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.FileUtils","getParentFile(File)",0);
		checkFaultPosition(OCHIAI,"ANT4_07",ANT,4,"SFS_HD_1","org.apache.tools.ant.util","org.apache.tools.ant.util.SourceFileScanner","restrict(String[],File,File,FileNameMapper)",113);
		
		checkFaultPosition(OCHIAI,"ANT5_01",ANT,5,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","encodedata(String)",67);
		checkFaultPosition(OCHIAI,"ANT5_01",ANT,5,"MNT_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.ManifestTask","execute()",41);
		checkFaultPosition(OCHIAI,"ANT5_02",ANT,5,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","encodedata(String)",67);
		checkFaultPosition(OCHIAI,"ANT5_02",ANT,5,"MST_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.Manifest","getDefaultManifest()",60);
		checkFaultPosition(OCHIAI,"ANT5_03",ANT,5,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","encodedata(String)",67);
		checkFaultPosition(OCHIAI,"ANT5_03",ANT,5,"PJ_HD_2","org.apache.tools.ant","org.apache.tools.ant.Project","addReference(String,Object)",31);
		checkFaultPosition(OCHIAI,"ANT5_04",ANT,5,"MNT_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.ManifestTask","execute()",41);
		checkFaultPosition(OCHIAI,"ANT5_04",ANT,5,"MST_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.Manifest","getDefaultManifest()",60);
		checkFaultPosition(OCHIAI,"ANT5_05",ANT,5,"MNT_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.ManifestTask","execute()",41);
		checkFaultPosition(OCHIAI,"ANT5_05",ANT,5,"PJ_HD_2","org.apache.tools.ant","org.apache.tools.ant.Project","addReference(String,Object)",31);
		checkFaultPosition(OCHIAI,"ANT5_06",ANT,5,"MST_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.Manifest","getDefaultManifest()",60);
		checkFaultPosition(OCHIAI,"ANT5_06",ANT,5,"PJ_HD_2","org.apache.tools.ant","org.apache.tools.ant.Project","addReference(String,Object)",31);
		checkFaultPosition(OCHIAI,"ANT5_07",ANT,5,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","encodedata(String)",67);
		checkFaultPosition(OCHIAI,"ANT5_07",ANT,5,"MNT_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.ManifestTask","execute()",41);
		checkFaultPosition(OCHIAI,"ANT5_07",ANT,5,"MST_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.Manifest","getDefaultManifest()",60);
		checkFaultPosition(OCHIAI,"ANT5_07",ANT,5,"PJ_HD_2","org.apache.tools.ant","org.apache.tools.ant.Project","addReference(String,Object)",31);
		
		checkFaultPosition(OCHIAI,"ANT7_01",ANT,7,"ACL_HD_2","org.apache.tools.ant","org.apache.tools.ant.AntClassLoader","setClassPath(Path)",0);
		checkFaultPosition(OCHIAI,"ANT7_01",ANT,7,"SLU_AK_1","org.apache.tools.ant.types.selectors","org.apache.tools.ant.types.selectors.SelectorUtils","matchPath(String,String,boolean)",130);
		
		makeBudgets(OCHIAI,ANT);
		makeBudgetsMultipleFaults(OCHIAI,ANT,true);
		makeBudgetsMultipleFaults(OCHIAI,ANT,false);
		
		makeHeader();
				
		checkFaultPosition(OCHIAI,"CM1_01",COMMONS_MATH,1,"C_AK_1","org.apache.commons.math.complex","org.apache.commons.math.complex.Complex","multiply(Complex)",18);
		checkFaultPosition(OCHIAI,"CM1_01",COMMONS_MATH,1,"EDI_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.EmpiricalDistributionImpl","load(URL)",51);
		checkFaultPosition(OCHIAI,"CM1_01",COMMONS_MATH,1,"F_AK_1","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","Fraction(double,double,int,int)",0);
		checkFaultPosition(OCHIAI,"CM1_01",COMMONS_MATH,1,"M_AK_1","org.apache.commons.math.stat.descriptive.moment","org.apache.commons.math.stat.descriptive.moment.Mean","evaluate(double[],int,int)",10);
		checkFaultPosition(OCHIAI,"CM1_02",COMMONS_MATH,1,"C_AK_1","org.apache.commons.math.complex","org.apache.commons.math.complex.Complex","multiply(Complex)",18);
		checkFaultPosition(OCHIAI,"CM1_02",COMMONS_MATH,1,"EDI_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.EmpiricalDistributionImpl","load(URL)",51);
		checkFaultPosition(OCHIAI,"CM1_02",COMMONS_MATH,1,"F_AK_1","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","Fraction(double,double,int,int)",0);
		checkFaultPosition(OCHIAI,"CM1_02",COMMONS_MATH,1,"VS_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.ValueServer","getNextReplay()",25);
		checkFaultPosition(OCHIAI,"CM1_03",COMMONS_MATH,1,"C_AK_1","org.apache.commons.math.complex","org.apache.commons.math.complex.Complex","multiply(Complex)",18);
		checkFaultPosition(OCHIAI,"CM1_03",COMMONS_MATH,1,"EDI_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.EmpiricalDistributionImpl","load(URL)",51);
		checkFaultPosition(OCHIAI,"CM1_03",COMMONS_MATH,1,"M_AK_1","org.apache.commons.math.stat.descriptive.moment","org.apache.commons.math.stat.descriptive.moment.Mean","evaluate(double[],int,int)",10);
		checkFaultPosition(OCHIAI,"CM1_03",COMMONS_MATH,1,"VS_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.ValueServer","getNextReplay()",25);
		checkFaultPosition(OCHIAI,"CM1_04",COMMONS_MATH,1,"C_AK_1","org.apache.commons.math.complex","org.apache.commons.math.complex.Complex","multiply(Complex)",18);
		checkFaultPosition(OCHIAI,"CM1_04",COMMONS_MATH,1,"F_AK_1","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","Fraction(double,double,int,int)",0);
		checkFaultPosition(OCHIAI,"CM1_04",COMMONS_MATH,1,"M_AK_1","org.apache.commons.math.stat.descriptive.moment","org.apache.commons.math.stat.descriptive.moment.Mean","evaluate(double[],int,int)",10);
		checkFaultPosition(OCHIAI,"CM1_04",COMMONS_MATH,1,"VS_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.ValueServer","getNextReplay()",25);
		checkFaultPosition(OCHIAI,"CM1_05",COMMONS_MATH,1,"EDI_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.EmpiricalDistributionImpl","load(URL)",51);
		checkFaultPosition(OCHIAI,"CM1_05",COMMONS_MATH,1,"F_AK_1","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","Fraction(double,double,int,int)",0);
		checkFaultPosition(OCHIAI,"CM1_05",COMMONS_MATH,1,"M_AK_1","org.apache.commons.math.stat.descriptive.moment","org.apache.commons.math.stat.descriptive.moment.Mean","evaluate(double[],int,int)",10);
		checkFaultPosition(OCHIAI,"CM1_05",COMMONS_MATH,1,"VS_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.ValueServer","getNextReplay()",25);
		
		checkFaultPosition(OCHIAI,"CM2_01",COMMONS_MATH,2,"ABI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.AdamsBashforthIntegrator","AdamsBashforthIntegrator(int,double,double,double,double)",0);
		checkFaultPosition(OCHIAI,"CM2_01",COMMONS_MATH,2,"CRVG_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.CorrelatedRandomVectorGenerator","decompose(RealMatrix,double)",539);
		checkFaultPosition(OCHIAI,"CM2_01",COMMONS_MATH,2,"MU_AK_4","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficientLog(int,int)",66);
		checkFaultPosition(OCHIAI,"CM2_01",COMMONS_MATH,2,"URSU_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils","bracket(UnivariateRealFunction,double,double,double,int)",174);
		checkFaultPosition(OCHIAI,"CM2_02",COMMONS_MATH,2,"AE_AK_1","org.apache.commons.math.estimation","org.apache.commons.math.estimation.AbstractEstimator","getCovariances(EstimationProblem)",0);
		checkFaultPosition(OCHIAI,"CM2_02",COMMONS_MATH,2,"CDI_AK_1","org.apache.commons.math.linear","org.apache.commons.math.linear.CholeskyDecompositionImpl","CholeskyDecompositionImpl(RealMatrix,double,double)",207);
		checkFaultPosition(OCHIAI,"CM2_02",COMMONS_MATH,2,"MU_AK_3","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficient(int,int)",58);
		checkFaultPosition(OCHIAI,"CM2_02",COMMONS_MATH,2,"MU_AK_6","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","equals(double,double,double)",0);
		checkFaultPosition(OCHIAI,"CM2_03",COMMONS_MATH,2,"CDI_AK_1","org.apache.commons.math.linear","org.apache.commons.math.linear.CholeskyDecompositionImpl","CholeskyDecompositionImpl(RealMatrix,double,double)",207);
		checkFaultPosition(OCHIAI,"CM2_03",COMMONS_MATH,2,"MU_AK_4","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficientLog(int,int)",66);
		checkFaultPosition(OCHIAI,"CM2_03",COMMONS_MATH,2,"MU_AK_5","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",8);
		checkFaultPosition(OCHIAI,"CM2_03",COMMONS_MATH,2,"MU_AK_6","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","equals(double,double,double)",0);
		checkFaultPosition(OCHIAI,"CM2_04",COMMONS_MATH,2,"CDI_AK_1","org.apache.commons.math.linear","org.apache.commons.math.linear.CholeskyDecompositionImpl","CholeskyDecompositionImpl(RealMatrix,double,double)",207);
		checkFaultPosition(OCHIAI,"CM2_04",COMMONS_MATH,2,"CRVG_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.CorrelatedRandomVectorGenerator","decompose(RealMatrix,double)",539);
		checkFaultPosition(OCHIAI,"CM2_04",COMMONS_MATH,2,"MU_AK_5","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",8);
		checkFaultPosition(OCHIAI,"CM2_04",COMMONS_MATH,2,"URSU_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils","bracket(UnivariateRealFunction,double,double,double,int)",174);
		checkFaultPosition(OCHIAI,"CM2_05",COMMONS_MATH,2,"CRVG_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.CorrelatedRandomVectorGenerator","decompose(RealMatrix,double)",539);
		checkFaultPosition(OCHIAI,"CM2_05",COMMONS_MATH,2,"F_AK_2","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","compareTo(Fraction)",39);
		checkFaultPosition(OCHIAI,"CM2_05",COMMONS_MATH,2,"MU_AK_5","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",8);
		checkFaultPosition(OCHIAI,"CM2_05",COMMONS_MATH,2,"MU_AK_6","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","equals(double,double,double)",0);
		checkFaultPosition(OCHIAI,"CM2_06",COMMONS_MATH,2,"F_AK_2","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","compareTo(Fraction)",39);
		checkFaultPosition(OCHIAI,"CM2_06",COMMONS_MATH,2,"MU_AK_3","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficient(int,int)",58);
		checkFaultPosition(OCHIAI,"CM2_06",COMMONS_MATH,2,"MU_AK_4","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficientLog(int,int)",66);
		checkFaultPosition(OCHIAI,"CM2_06",COMMONS_MATH,2,"URSU_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils","bracket(UnivariateRealFunction,double,double,double,int)",174);
		checkFaultPosition(OCHIAI,"CM2_07",COMMONS_MATH,2,"AE_AK_1","org.apache.commons.math.estimation","org.apache.commons.math.estimation.AbstractEstimator","getCovariances(EstimationProblem)",0);
		checkFaultPosition(OCHIAI,"CM2_07",COMMONS_MATH,2,"CRVG_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.CorrelatedRandomVectorGenerator","decompose(RealMatrix,double)",539);
		checkFaultPosition(OCHIAI,"CM2_07",COMMONS_MATH,2,"MU_AK_1","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",0);
		checkFaultPosition(OCHIAI,"CM2_07",COMMONS_MATH,2,"URSU_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils","bracket(UnivariateRealFunction,double,double,double,int)",174);
		checkFaultPosition(OCHIAI,"CM2_08",COMMONS_MATH,2,"AE_AK_1","org.apache.commons.math.estimation","org.apache.commons.math.estimation.AbstractEstimator","getCovariances(EstimationProblem)",0);
		checkFaultPosition(OCHIAI,"CM2_08",COMMONS_MATH,2,"MU_AK_5","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",8);
		checkFaultPosition(OCHIAI,"CM2_08",COMMONS_MATH,2,"MU_AK_6","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","equals(double,double,double)",0);
		checkFaultPosition(OCHIAI,"CM2_08",COMMONS_MATH,2,"URSU_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils","bracket(UnivariateRealFunction,double,double,double,int)",174);
		checkFaultPosition(OCHIAI,"CM2_09",COMMONS_MATH,2,"ABI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.AdamsBashforthIntegrator","AdamsBashforthIntegrator(int,double,double,double,double)",0);
		checkFaultPosition(OCHIAI,"CM2_09",COMMONS_MATH,2,"AE_AK_1","org.apache.commons.math.estimation","org.apache.commons.math.estimation.AbstractEstimator","getCovariances(EstimationProblem)",0);
		checkFaultPosition(OCHIAI,"CM2_09",COMMONS_MATH,2,"CRVG_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.CorrelatedRandomVectorGenerator","decompose(RealMatrix,double)",539);
		checkFaultPosition(OCHIAI,"CM2_09",COMMONS_MATH,2,"URSU_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils","bracket(UnivariateRealFunction,double,double,double,int)",174);
		checkFaultPosition(OCHIAI,"CM2_10",COMMONS_MATH,2,"ABI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.AdamsBashforthIntegrator","AdamsBashforthIntegrator(int,double,double,double,double)",0);
		checkFaultPosition(OCHIAI,"CM2_10",COMMONS_MATH,2,"AE_AK_1","org.apache.commons.math.estimation","org.apache.commons.math.estimation.AbstractEstimator","getCovariances(EstimationProblem)",0);
		checkFaultPosition(OCHIAI,"CM2_10",COMMONS_MATH,2,"CRVG_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.CorrelatedRandomVectorGenerator","decompose(RealMatrix,double)",539);
		checkFaultPosition(OCHIAI,"CM2_10",COMMONS_MATH,2,"F_AK_2","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","compareTo(Fraction)",39);
		checkFaultPosition(OCHIAI,"CM2_11",COMMONS_MATH,2,"ABI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.AdamsBashforthIntegrator","AdamsBashforthIntegrator(int,double,double,double,double)",0);
		checkFaultPosition(OCHIAI,"CM2_11",COMMONS_MATH,2,"F_AK_2","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","compareTo(Fraction)",39);
		checkFaultPosition(OCHIAI,"CM2_11",COMMONS_MATH,2,"MU_AK_5","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",8);
		checkFaultPosition(OCHIAI,"CM2_11",COMMONS_MATH,2,"URSU_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils","bracket(UnivariateRealFunction,double,double,double,int)",174);
		checkFaultPosition(OCHIAI,"CM2_12",COMMONS_MATH,2,"MU_AK_1","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",0);
		checkFaultPosition(OCHIAI,"CM2_12",COMMONS_MATH,2,"MU_AK_2","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","factorial(int)",26);
		checkFaultPosition(OCHIAI,"CM2_12",COMMONS_MATH,2,"MU_AK_4","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficientLog(int,int)",66);
		checkFaultPosition(OCHIAI,"CM2_12",COMMONS_MATH,2,"MU_AK_6","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","equals(double,double,double)",0);
		checkFaultPosition(OCHIAI,"CM2_13",COMMONS_MATH,2,"F_AK_2","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","compareTo(Fraction)",39);
		checkFaultPosition(OCHIAI,"CM2_13",COMMONS_MATH,2,"MU_AK_4","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficientLog(int,int)",66);
		checkFaultPosition(OCHIAI,"CM2_13",COMMONS_MATH,2,"MU_AK_5","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",8);
		checkFaultPosition(OCHIAI,"CM2_13",COMMONS_MATH,2,"MU_AK_6","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","equals(double,double,double)",0);
		checkFaultPosition(OCHIAI,"CM2_14",COMMONS_MATH,2,"AE_AK_1","org.apache.commons.math.estimation","org.apache.commons.math.estimation.AbstractEstimator","getCovariances(EstimationProblem)",0);
		checkFaultPosition(OCHIAI,"CM2_14",COMMONS_MATH,2,"MU_AK_1","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",0);
		checkFaultPosition(OCHIAI,"CM2_14",COMMONS_MATH,2,"MU_AK_2","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","factorial(int)",26);
		checkFaultPosition(OCHIAI,"CM2_14",COMMONS_MATH,2,"MU_AK_3","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficient(int,int)",58);
		checkFaultPosition(OCHIAI,"CM2_15",COMMONS_MATH,2,"CDI_AK_1","org.apache.commons.math.linear","org.apache.commons.math.linear.CholeskyDecompositionImpl","CholeskyDecompositionImpl(RealMatrix,double,double)",207);
		checkFaultPosition(OCHIAI,"CM2_15",COMMONS_MATH,2,"F_AK_2","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","compareTo(Fraction)",39);
		checkFaultPosition(OCHIAI,"CM2_15",COMMONS_MATH,2,"MU_AK_2","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","factorial(int)",26);
		checkFaultPosition(OCHIAI,"CM2_15",COMMONS_MATH,2,"MU_AK_3","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficient(int,int)",58);
		checkFaultPosition(OCHIAI,"CM2_16",COMMONS_MATH,2,"ABI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.AdamsBashforthIntegrator","AdamsBashforthIntegrator(int,double,double,double,double)",0);
		checkFaultPosition(OCHIAI,"CM2_16",COMMONS_MATH,2,"CDI_AK_1","org.apache.commons.math.linear","org.apache.commons.math.linear.CholeskyDecompositionImpl","CholeskyDecompositionImpl(RealMatrix,double,double)",207);
		checkFaultPosition(OCHIAI,"CM2_16",COMMONS_MATH,2,"MU_AK_2","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","factorial(int)",26);
		checkFaultPosition(OCHIAI,"CM2_16",COMMONS_MATH,2,"MU_AK_3","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficient(int,int)",58);
		
		checkFaultPosition(OCHIAI,"CM3_01",COMMONS_MATH,3,"BS_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.BrentSolver","solve(UnivariateRealFunction,double,double,double)",109);
		checkFaultPosition(OCHIAI,"CM3_01",COMMONS_MATH,3,"ERKI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.EmbeddedRungeKuttaIntegrator","integrate(FirstOrderDifferentialEquations,double,double[],double,double[])",727);
		checkFaultPosition(OCHIAI,"CM3_02",COMMONS_MATH,3,"BS_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.BrentSolver","solve(UnivariateRealFunction,double,double,double)",109);
		checkFaultPosition(OCHIAI,"CM3_02",COMMONS_MATH,3,"RKI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.RungeKuttaIntegrator","integrate(FirstOrderDifferentialEquations,double,double[],double,double[])",578);
		checkFaultPosition(OCHIAI,"CM3_03",COMMONS_MATH,3,"ERKI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.EmbeddedRungeKuttaIntegrator","integrate(FirstOrderDifferentialEquations,double,double[],double,double[])",727);
		checkFaultPosition(OCHIAI,"CM3_03",COMMONS_MATH,3,"RKI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.RungeKuttaIntegrator","integrate(FirstOrderDifferentialEquations,double,double[],double,double[])",578);
		
		makeBudgets(OCHIAI,COMMONS_MATH);
		makeBudgetsMultipleFaults(OCHIAI,COMMONS_MATH,true);
		makeBudgetsMultipleFaults(OCHIAI,COMMONS_MATH,false);
		
		makeHeader();
		
		checkFaultPosition(OCHIAI,"HS2_01",HSQLDB,2,"EL_AK_1","org.hsqldb","org.hsqldb.ExpressionLogical","resolveTypesForComparison(Session,Expression)",840);
		checkFaultPosition(OCHIAI,"HS2_01",HSQLDB,2,"QS_AK_1","org.hsqldb","org.hsqldb.QuerySpecification","setAggregateConditions(Session)",0);
		checkFaultPosition(OCHIAI,"HS2_02",HSQLDB,2,"EL_AK_1","org.hsqldb","org.hsqldb.ExpressionLogical","resolveTypesForComparison(Session,Expression)",840);
		checkFaultPosition(OCHIAI,"HS2_02",HSQLDB,2,"QS_AK_2","org.hsqldb","org.hsqldb.QuerySpecification","setDistinctConditions(Session)",123);
		checkFaultPosition(OCHIAI,"HS2_03",HSQLDB,2,"QS_AK_1","org.hsqldb","org.hsqldb.QuerySpecification","setAggregateConditions(Session)",0);
		checkFaultPosition(OCHIAI,"HS2_03",HSQLDB,2,"QS_AK_2","org.hsqldb","org.hsqldb.QuerySpecification","setDistinctConditions(Session)",123);
		
		makeBudgets(OCHIAI,HSQLDB);
		makeBudgetsMultipleFaults(OCHIAI,HSQLDB,true);
		makeBudgetsMultipleFaults(OCHIAI,HSQLDB,false);
		
		makeHeader();
				
		checkFaultPosition(OCHIAI,"JT1_01",JTOPAS,1,"FAULT_5","de.susebox.java.util","de.susebox.java.util.AbstractTokenizer","isKeyword(int,int)",20);
		checkFaultPosition(OCHIAI,"JT1_01",JTOPAS,1,"FAULT_6","de.susebox.java.util","de.susebox.java.util.AbstractTokenizer","test4Normal(Token)",82);
		
		makeBudgets(OCHIAI,JTOPAS);
		makeBudgetsMultipleFaults(OCHIAI,JTOPAS,true);
		makeBudgetsMultipleFaults(OCHIAI,JTOPAS,false);
		
		makeHeader();
		
		checkFaultPosition(OCHIAI,"PMD3_01",PMD,3,"RV_AK_1","net.sourceforge.pmd","net.sourceforge.pmd.RuleViolation","RuleViolation(Rule,RuleContext,SimpleNode,String)",431);
		checkFaultPosition(OCHIAI,"PMD3_01",PMD,3,"XMLR_AK_1","net.sourceforge.pmd.cpd","net.sourceforge.pmd.cpd.XMLRenderer","render(Iterator)",133);
		
		makeBudgets(OCHIAI,PMD);
		makeBudgetsMultipleFaults(OCHIAI,PMD,true);
		makeBudgetsMultipleFaults(OCHIAI,PMD,false);
		
		makeHeader();
		
		checkFaultPosition(OCHIAI,"XML1_01",XML_SECURITY,1,"CE_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","updateInscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",302);
		checkFaultPosition(OCHIAI,"XML1_01",XML_SECURITY,1,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","namespaceIsAbsolute(String)",42);
		checkFaultPosition(OCHIAI,"XML1_01",XML_SECURITY,1,"CN2_AK_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315","updateinscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",322);
		checkFaultPosition(OCHIAI,"XML1_01",XML_SECURITY,1,"CNC_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","XMLSignatureInput(Node,CachedXPathAPI)",0);
		checkFaultPosition(OCHIAI,"XML1_02",XML_SECURITY,1,"CE_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","updateInscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",302);
		checkFaultPosition(OCHIAI,"XML1_02",XML_SECURITY,1,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","namespaceIsAbsolute(String)",42);
		checkFaultPosition(OCHIAI,"XML1_02",XML_SECURITY,1,"CN2_AK_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315","updateinscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",322);
		checkFaultPosition(OCHIAI,"XML1_02",XML_SECURITY,1,"XSI_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","getNodeSet()",38);
		checkFaultPosition(OCHIAI,"XML1_03",XML_SECURITY,1,"CE_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","updateInscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",302);
		checkFaultPosition(OCHIAI,"XML1_03",XML_SECURITY,1,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","namespaceIsAbsolute(String)",42);
		checkFaultPosition(OCHIAI,"XML1_03",XML_SECURITY,1,"CNC_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","XMLSignatureInput(Node,CachedXPathAPI)",0);
		checkFaultPosition(OCHIAI,"XML1_03",XML_SECURITY,1,"XSI_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","getNodeSet()",38);
		checkFaultPosition(OCHIAI,"XML1_04",XML_SECURITY,1,"CE_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","updateInscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",302);
		checkFaultPosition(OCHIAI,"XML1_04",XML_SECURITY,1,"CN2_AK_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315","updateinscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",322);
		checkFaultPosition(OCHIAI,"XML1_04",XML_SECURITY,1,"CNC_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","XMLSignatureInput(Node,CachedXPathAPI)",0);
		checkFaultPosition(OCHIAI,"XML1_04",XML_SECURITY,1,"XSI_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","getNodeSet()",38);
		checkFaultPosition(OCHIAI,"XML1_05",XML_SECURITY,1,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","namespaceIsAbsolute(String)",42);
		checkFaultPosition(OCHIAI,"XML1_05",XML_SECURITY,1,"CN2_AK_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315","updateinscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",322);
		checkFaultPosition(OCHIAI,"XML1_05",XML_SECURITY,1,"CNC_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","XMLSignatureInput(Node,CachedXPathAPI)",0);
		checkFaultPosition(OCHIAI,"XML1_05",XML_SECURITY,1,"XSI_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","getNodeSet()",38);
		
		checkFaultPosition(OCHIAI,"XML2_01",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(OCHIAI,"XML2_01",XML_SECURITY,2,"CB_HD_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","getPositionRelativeToDocumentElement(Node)",56);
		checkFaultPosition(OCHIAI,"XML2_01",XML_SECURITY,2,"CB_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","outputPItoWriter(ProcessingInstruction)",87);
		checkFaultPosition(OCHIAI,"XML2_01",XML_SECURITY,2,"CH_HD_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",63);
		checkFaultPosition(OCHIAI,"XML2_02",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(OCHIAI,"XML2_02",XML_SECURITY,2,"CB_HD_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","getPositionRelativeToDocumentElement(Node)",56);
		checkFaultPosition(OCHIAI,"XML2_02",XML_SECURITY,2,"CB_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","outputPItoWriter(ProcessingInstruction)",87);
		checkFaultPosition(OCHIAI,"XML2_02",XML_SECURITY,2,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",159);
		checkFaultPosition(OCHIAI,"XML2_03",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(OCHIAI,"XML2_03",XML_SECURITY,2,"CB_HD_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","getPositionRelativeToDocumentElement(Node)",56);
		checkFaultPosition(OCHIAI,"XML2_03",XML_SECURITY,2,"CB_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","outputPItoWriter(ProcessingInstruction)",87);
		checkFaultPosition(OCHIAI,"XML2_03",XML_SECURITY,2,"RF_HD_2","org.apache.xml.security.signature","org.apache.xml.security.signature.Reference","dereferenceURIandPerformTransforms()",0);
		checkFaultPosition(OCHIAI,"XML2_04",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(OCHIAI,"XML2_04",XML_SECURITY,2,"CB_HD_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","getPositionRelativeToDocumentElement(Node)",56);
		checkFaultPosition(OCHIAI,"XML2_04",XML_SECURITY,2,"CH_HD_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",63);
		checkFaultPosition(OCHIAI,"XML2_04",XML_SECURITY,2,"RF_HD_2","org.apache.xml.security.signature","org.apache.xml.security.signature.Reference","dereferenceURIandPerformTransforms()",0);
		checkFaultPosition(OCHIAI,"XML2_05",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(OCHIAI,"XML2_05",XML_SECURITY,2,"CB_HD_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","getPositionRelativeToDocumentElement(Node)",56);
		checkFaultPosition(OCHIAI,"XML2_05",XML_SECURITY,2,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",159);
		checkFaultPosition(OCHIAI,"XML2_05",XML_SECURITY,2,"RF_HD_2","org.apache.xml.security.signature","org.apache.xml.security.signature.Reference","dereferenceURIandPerformTransforms()",0);
		checkFaultPosition(OCHIAI,"XML2_06",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(OCHIAI,"XML2_06",XML_SECURITY,2,"CB_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","outputPItoWriter(ProcessingInstruction)",87);
		checkFaultPosition(OCHIAI,"XML2_06",XML_SECURITY,2,"CH_HD_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",63);
		checkFaultPosition(OCHIAI,"XML2_06",XML_SECURITY,2,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",159);
		checkFaultPosition(OCHIAI,"XML2_07",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(OCHIAI,"XML2_07",XML_SECURITY,2,"CB_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","outputPItoWriter(ProcessingInstruction)",87);
		checkFaultPosition(OCHIAI,"XML2_07",XML_SECURITY,2,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",159);
		checkFaultPosition(OCHIAI,"XML2_07",XML_SECURITY,2,"RF_HD_2","org.apache.xml.security.signature","org.apache.xml.security.signature.Reference","dereferenceURIandPerformTransforms()",0);
		checkFaultPosition(OCHIAI,"XML2_08",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(OCHIAI,"XML2_08",XML_SECURITY,2,"CH_HD_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",63);
		checkFaultPosition(OCHIAI,"XML2_08",XML_SECURITY,2,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",159);
		checkFaultPosition(OCHIAI,"XML2_08",XML_SECURITY,2,"RF_HD_2","org.apache.xml.security.signature","org.apache.xml.security.signature.Reference","dereferenceURIandPerformTransforms()",0);
		checkFaultPosition(OCHIAI,"XML2_09",XML_SECURITY,2,"CB_HD_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","getPositionRelativeToDocumentElement(Node)",56);
		checkFaultPosition(OCHIAI,"XML2_09",XML_SECURITY,2,"CH_HD_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",63);
		checkFaultPosition(OCHIAI,"XML2_09",XML_SECURITY,2,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",159);
		checkFaultPosition(OCHIAI,"XML2_09",XML_SECURITY,2,"RF_HD_2","org.apache.xml.security.signature","org.apache.xml.security.signature.Reference","dereferenceURIandPerformTransforms()",0);
		
		checkFaultPosition(OCHIAI,"XML3_01",XML_SECURITY,3,"RF_HD_1","org.apache.xml.security.signature","org.apache.xml.security.signature.Reference","getDigestValue()",0);
		checkFaultPosition(OCHIAI,"XML3_01",XML_SECURITY,3,"XU_HD_2","org.apache.xml.security.utils","org.apache.xml.security.utils.XMLUtils","getOwnerDocument(Set)",18);
		
		makeBudgets(OCHIAI,XML_SECURITY);
		makeBudgetsMultipleFaults(OCHIAI,XML_SECURITY,true);
		makeBudgetsMultipleFaults(OCHIAI,XML_SECURITY,false);
		
		makeBudgets(OCHIAI,ALL_PROGRAMS);
		makeBudgetsMultipleFaults(OCHIAI,ALL_PROGRAMS,true);
		makeBudgetsMultipleFaults(OCHIAI,ALL_PROGRAMS,false);
		
		
		makeHeader();
		
		checkFaultPosition(TARANTULA,"ANT1_01",ANT,1,"CLJ_HD_1","org.apache.tools.ant.types","org.apache.tools.ant.types.CommandlineJava","getCommandline()",7);
		checkFaultPosition(TARANTULA,"ANT1_01",ANT,1,"PJH_AK_1","org.apache.tools.ant","org.apache.tools.ant.ProjectHelper","parse()",68);
		
		checkFaultPosition(TARANTULA,"ANT2_01",ANT,2,"CDJ_AK_1","org.apache.tools.ant.types","org.apache.tools.ant.types.CommandlineJava","getCommandline()",42);
		checkFaultPosition(TARANTULA,"ANT2_01",ANT,2,"PH_HD_1","org.apache.tools.ant","org.apache.tools.ant.ProjectHelper$TargetHandler","startElement(String,AttributeList)",0);
		
		checkFaultPosition(TARANTULA,"ANT3_01",ANT,3,"TG_HD_1","org.apache.tools.ant","org.apache.tools.ant.Target","setDepends(String)",7);
		checkFaultPosition(TARANTULA,"ANT3_01",ANT,3,"TG_HD_2","org.apache.tools.ant","org.apache.tools.ant.Target","setDepends(String)",92);
		
		checkFaultPosition(TARANTULA,"ANT4_01",ANT,4,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","isLegalCharacter(char)",20);
		checkFaultPosition(TARANTULA,"ANT4_01",ANT,4,"EA_HD_1","org.apache.tools.ant.types","org.apache.tools.ant.types.EnumeratedAttribute","setValue(String)",0);
		checkFaultPosition(TARANTULA,"ANT4_02",ANT,4,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","isLegalCharacter(char)",20);
		checkFaultPosition(TARANTULA,"ANT4_02",ANT,4,"FLU_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.FileUtils","getParentFile(File)",0);
		checkFaultPosition(TARANTULA,"ANT4_03",ANT,4,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","isLegalCharacter(char)",20);
		checkFaultPosition(TARANTULA,"ANT4_03",ANT,4,"SFS_HD_1","org.apache.tools.ant.util","org.apache.tools.ant.util.SourceFileScanner","restrict(String[],File,File,FileNameMapper)",113);
		checkFaultPosition(TARANTULA,"ANT4_04",ANT,4,"EA_HD_1","org.apache.tools.ant.types","org.apache.tools.ant.types.EnumeratedAttribute","setValue(String)",0);
		checkFaultPosition(TARANTULA,"ANT4_04",ANT,4,"FLU_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.FileUtils","getParentFile(File)",0);
		checkFaultPosition(TARANTULA,"ANT4_05",ANT,4,"EA_HD_1","org.apache.tools.ant.types","org.apache.tools.ant.types.EnumeratedAttribute","setValue(String)",0);
		checkFaultPosition(TARANTULA,"ANT4_05",ANT,4,"SFS_HD_1","org.apache.tools.ant.util","org.apache.tools.ant.util.SourceFileScanner","restrict(String[],File,File,FileNameMapper)",113);
		checkFaultPosition(TARANTULA,"ANT4_06",ANT,4,"FLU_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.FileUtils","getParentFile(File)",0);
		checkFaultPosition(TARANTULA,"ANT4_06",ANT,4,"SFS_HD_1","org.apache.tools.ant.util","org.apache.tools.ant.util.SourceFileScanner","restrict(String[],File,File,FileNameMapper)",113);
		checkFaultPosition(TARANTULA,"ANT4_07",ANT,4,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","isLegalCharacter(char)",20);
		checkFaultPosition(TARANTULA,"ANT4_07",ANT,4,"EA_HD_1","org.apache.tools.ant.types","org.apache.tools.ant.types.EnumeratedAttribute","setValue(String)",0);
		checkFaultPosition(TARANTULA,"ANT4_07",ANT,4,"FLU_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.FileUtils","getParentFile(File)",0);
		checkFaultPosition(TARANTULA,"ANT4_07",ANT,4,"SFS_HD_1","org.apache.tools.ant.util","org.apache.tools.ant.util.SourceFileScanner","restrict(String[],File,File,FileNameMapper)",113);
		
		checkFaultPosition(TARANTULA,"ANT5_01",ANT,5,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","encodedata(String)",67);
		checkFaultPosition(TARANTULA,"ANT5_01",ANT,5,"MNT_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.ManifestTask","execute()",41);
		checkFaultPosition(TARANTULA,"ANT5_02",ANT,5,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","encodedata(String)",67);
		checkFaultPosition(TARANTULA,"ANT5_02",ANT,5,"MST_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.Manifest","getDefaultManifest()",60);
		checkFaultPosition(TARANTULA,"ANT5_03",ANT,5,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","encodedata(String)",67);
		checkFaultPosition(TARANTULA,"ANT5_03",ANT,5,"PJ_HD_2","org.apache.tools.ant","org.apache.tools.ant.Project","addReference(String,Object)",31);
		checkFaultPosition(TARANTULA,"ANT5_04",ANT,5,"MNT_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.ManifestTask","execute()",41);
		checkFaultPosition(TARANTULA,"ANT5_04",ANT,5,"MST_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.Manifest","getDefaultManifest()",60);
		checkFaultPosition(TARANTULA,"ANT5_05",ANT,5,"MNT_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.ManifestTask","execute()",41);
		checkFaultPosition(TARANTULA,"ANT5_05",ANT,5,"PJ_HD_2","org.apache.tools.ant","org.apache.tools.ant.Project","addReference(String,Object)",31);
		checkFaultPosition(TARANTULA,"ANT5_06",ANT,5,"MST_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.Manifest","getDefaultManifest()",60);
		checkFaultPosition(TARANTULA,"ANT5_06",ANT,5,"PJ_HD_2","org.apache.tools.ant","org.apache.tools.ant.Project","addReference(String,Object)",31);
		checkFaultPosition(TARANTULA,"ANT5_07",ANT,5,"DEW_AK_1","org.apache.tools.ant.util","org.apache.tools.ant.util.DOMElementWriter","encodedata(String)",67);
		checkFaultPosition(TARANTULA,"ANT5_07",ANT,5,"MNT_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.ManifestTask","execute()",41);
		checkFaultPosition(TARANTULA,"ANT5_07",ANT,5,"MST_AK_1","org.apache.tools.ant.taskdefs","org.apache.tools.ant.taskdefs.Manifest","getDefaultManifest()",60);
		checkFaultPosition(TARANTULA,"ANT5_07",ANT,5,"PJ_HD_2","org.apache.tools.ant","org.apache.tools.ant.Project","addReference(String,Object)",31);
		
		checkFaultPosition(TARANTULA,"ANT7_01",ANT,7,"ACL_HD_2","org.apache.tools.ant","org.apache.tools.ant.AntClassLoader","setClassPath(Path)",0);
		checkFaultPosition(TARANTULA,"ANT7_01",ANT,7,"SLU_AK_1","org.apache.tools.ant.types.selectors","org.apache.tools.ant.types.selectors.SelectorUtils","matchPath(String,String,boolean)",130);
		
		makeBudgets(TARANTULA,ANT);
		makeBudgetsMultipleFaults(TARANTULA,ANT,true);
		makeBudgetsMultipleFaults(TARANTULA,ANT,false);
		
		makeHeader();
				
		checkFaultPosition(TARANTULA,"CM1_01",COMMONS_MATH,1,"C_AK_1","org.apache.commons.math.complex","org.apache.commons.math.complex.Complex","multiply(Complex)",18);
		checkFaultPosition(TARANTULA,"CM1_01",COMMONS_MATH,1,"EDI_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.EmpiricalDistributionImpl","load(URL)",51);
		checkFaultPosition(TARANTULA,"CM1_01",COMMONS_MATH,1,"F_AK_1","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","Fraction(double,double,int,int)",0);
		checkFaultPosition(TARANTULA,"CM1_01",COMMONS_MATH,1,"M_AK_1","org.apache.commons.math.stat.descriptive.moment","org.apache.commons.math.stat.descriptive.moment.Mean","evaluate(double[],int,int)",10);
		checkFaultPosition(TARANTULA,"CM1_02",COMMONS_MATH,1,"C_AK_1","org.apache.commons.math.complex","org.apache.commons.math.complex.Complex","multiply(Complex)",18);
		checkFaultPosition(TARANTULA,"CM1_02",COMMONS_MATH,1,"EDI_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.EmpiricalDistributionImpl","load(URL)",51);
		checkFaultPosition(TARANTULA,"CM1_02",COMMONS_MATH,1,"F_AK_1","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","Fraction(double,double,int,int)",0);
		checkFaultPosition(TARANTULA,"CM1_02",COMMONS_MATH,1,"VS_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.ValueServer","getNextReplay()",25);
		checkFaultPosition(TARANTULA,"CM1_03",COMMONS_MATH,1,"C_AK_1","org.apache.commons.math.complex","org.apache.commons.math.complex.Complex","multiply(Complex)",18);
		checkFaultPosition(TARANTULA,"CM1_03",COMMONS_MATH,1,"EDI_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.EmpiricalDistributionImpl","load(URL)",51);
		checkFaultPosition(TARANTULA,"CM1_03",COMMONS_MATH,1,"M_AK_1","org.apache.commons.math.stat.descriptive.moment","org.apache.commons.math.stat.descriptive.moment.Mean","evaluate(double[],int,int)",10);
		checkFaultPosition(TARANTULA,"CM1_03",COMMONS_MATH,1,"VS_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.ValueServer","getNextReplay()",25);
		checkFaultPosition(TARANTULA,"CM1_04",COMMONS_MATH,1,"C_AK_1","org.apache.commons.math.complex","org.apache.commons.math.complex.Complex","multiply(Complex)",18);
		checkFaultPosition(TARANTULA,"CM1_04",COMMONS_MATH,1,"F_AK_1","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","Fraction(double,double,int,int)",0);
		checkFaultPosition(TARANTULA,"CM1_04",COMMONS_MATH,1,"M_AK_1","org.apache.commons.math.stat.descriptive.moment","org.apache.commons.math.stat.descriptive.moment.Mean","evaluate(double[],int,int)",10);
		checkFaultPosition(TARANTULA,"CM1_04",COMMONS_MATH,1,"VS_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.ValueServer","getNextReplay()",25);
		checkFaultPosition(TARANTULA,"CM1_05",COMMONS_MATH,1,"EDI_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.EmpiricalDistributionImpl","load(URL)",51);
		checkFaultPosition(TARANTULA,"CM1_05",COMMONS_MATH,1,"F_AK_1","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","Fraction(double,double,int,int)",0);
		checkFaultPosition(TARANTULA,"CM1_05",COMMONS_MATH,1,"M_AK_1","org.apache.commons.math.stat.descriptive.moment","org.apache.commons.math.stat.descriptive.moment.Mean","evaluate(double[],int,int)",10);
		checkFaultPosition(TARANTULA,"CM1_05",COMMONS_MATH,1,"VS_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.ValueServer","getNextReplay()",25);
		
		checkFaultPosition(TARANTULA,"CM2_01",COMMONS_MATH,2,"ABI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.AdamsBashforthIntegrator","AdamsBashforthIntegrator(int,double,double,double,double)",0);
		checkFaultPosition(TARANTULA,"CM2_01",COMMONS_MATH,2,"CRVG_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.CorrelatedRandomVectorGenerator","decompose(RealMatrix,double)",539);
		checkFaultPosition(TARANTULA,"CM2_01",COMMONS_MATH,2,"MU_AK_4","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficientLog(int,int)",66);
		checkFaultPosition(TARANTULA,"CM2_01",COMMONS_MATH,2,"URSU_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils","bracket(UnivariateRealFunction,double,double,double,int)",174);
		checkFaultPosition(TARANTULA,"CM2_02",COMMONS_MATH,2,"AE_AK_1","org.apache.commons.math.estimation","org.apache.commons.math.estimation.AbstractEstimator","getCovariances(EstimationProblem)",0);
		checkFaultPosition(TARANTULA,"CM2_02",COMMONS_MATH,2,"CDI_AK_1","org.apache.commons.math.linear","org.apache.commons.math.linear.CholeskyDecompositionImpl","CholeskyDecompositionImpl(RealMatrix,double,double)",207);
		checkFaultPosition(TARANTULA,"CM2_02",COMMONS_MATH,2,"MU_AK_3","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficient(int,int)",58);
		checkFaultPosition(TARANTULA,"CM2_02",COMMONS_MATH,2,"MU_AK_6","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","equals(double,double,double)",0);
		checkFaultPosition(TARANTULA,"CM2_03",COMMONS_MATH,2,"CDI_AK_1","org.apache.commons.math.linear","org.apache.commons.math.linear.CholeskyDecompositionImpl","CholeskyDecompositionImpl(RealMatrix,double,double)",207);
		checkFaultPosition(TARANTULA,"CM2_03",COMMONS_MATH,2,"MU_AK_4","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficientLog(int,int)",66);
		checkFaultPosition(TARANTULA,"CM2_03",COMMONS_MATH,2,"MU_AK_5","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",8);
		checkFaultPosition(TARANTULA,"CM2_03",COMMONS_MATH,2,"MU_AK_6","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","equals(double,double,double)",0);
		checkFaultPosition(TARANTULA,"CM2_04",COMMONS_MATH,2,"CDI_AK_1","org.apache.commons.math.linear","org.apache.commons.math.linear.CholeskyDecompositionImpl","CholeskyDecompositionImpl(RealMatrix,double,double)",207);
		checkFaultPosition(TARANTULA,"CM2_04",COMMONS_MATH,2,"CRVG_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.CorrelatedRandomVectorGenerator","decompose(RealMatrix,double)",539);
		checkFaultPosition(TARANTULA,"CM2_04",COMMONS_MATH,2,"MU_AK_5","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",8);
		checkFaultPosition(TARANTULA,"CM2_04",COMMONS_MATH,2,"URSU_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils","bracket(UnivariateRealFunction,double,double,double,int)",174);
		checkFaultPosition(TARANTULA,"CM2_05",COMMONS_MATH,2,"CRVG_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.CorrelatedRandomVectorGenerator","decompose(RealMatrix,double)",539);
		checkFaultPosition(TARANTULA,"CM2_05",COMMONS_MATH,2,"F_AK_2","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","compareTo(Fraction)",39);
		checkFaultPosition(TARANTULA,"CM2_05",COMMONS_MATH,2,"MU_AK_5","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",8);
		checkFaultPosition(TARANTULA,"CM2_05",COMMONS_MATH,2,"MU_AK_6","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","equals(double,double,double)",0);
		checkFaultPosition(TARANTULA,"CM2_06",COMMONS_MATH,2,"F_AK_2","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","compareTo(Fraction)",39);
		checkFaultPosition(TARANTULA,"CM2_06",COMMONS_MATH,2,"MU_AK_3","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficient(int,int)",58);
		checkFaultPosition(TARANTULA,"CM2_06",COMMONS_MATH,2,"MU_AK_4","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficientLog(int,int)",66);
		checkFaultPosition(TARANTULA,"CM2_06",COMMONS_MATH,2,"URSU_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils","bracket(UnivariateRealFunction,double,double,double,int)",174);
		checkFaultPosition(TARANTULA,"CM2_07",COMMONS_MATH,2,"AE_AK_1","org.apache.commons.math.estimation","org.apache.commons.math.estimation.AbstractEstimator","getCovariances(EstimationProblem)",0);
		checkFaultPosition(TARANTULA,"CM2_07",COMMONS_MATH,2,"CRVG_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.CorrelatedRandomVectorGenerator","decompose(RealMatrix,double)",539);
		checkFaultPosition(TARANTULA,"CM2_07",COMMONS_MATH,2,"MU_AK_1","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",0);
		checkFaultPosition(TARANTULA,"CM2_07",COMMONS_MATH,2,"URSU_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils","bracket(UnivariateRealFunction,double,double,double,int)",174);
		checkFaultPosition(TARANTULA,"CM2_08",COMMONS_MATH,2,"AE_AK_1","org.apache.commons.math.estimation","org.apache.commons.math.estimation.AbstractEstimator","getCovariances(EstimationProblem)",0);
		checkFaultPosition(TARANTULA,"CM2_08",COMMONS_MATH,2,"MU_AK_5","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",8);
		checkFaultPosition(TARANTULA,"CM2_08",COMMONS_MATH,2,"MU_AK_6","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","equals(double,double,double)",0);
		checkFaultPosition(TARANTULA,"CM2_08",COMMONS_MATH,2,"URSU_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils","bracket(UnivariateRealFunction,double,double,double,int)",174);
		checkFaultPosition(TARANTULA,"CM2_09",COMMONS_MATH,2,"ABI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.AdamsBashforthIntegrator","AdamsBashforthIntegrator(int,double,double,double,double)",0);
		checkFaultPosition(TARANTULA,"CM2_09",COMMONS_MATH,2,"AE_AK_1","org.apache.commons.math.estimation","org.apache.commons.math.estimation.AbstractEstimator","getCovariances(EstimationProblem)",0);
		checkFaultPosition(TARANTULA,"CM2_09",COMMONS_MATH,2,"CRVG_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.CorrelatedRandomVectorGenerator","decompose(RealMatrix,double)",539);
		checkFaultPosition(TARANTULA,"CM2_09",COMMONS_MATH,2,"URSU_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils","bracket(UnivariateRealFunction,double,double,double,int)",174);
		checkFaultPosition(TARANTULA,"CM2_10",COMMONS_MATH,2,"ABI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.AdamsBashforthIntegrator","AdamsBashforthIntegrator(int,double,double,double,double)",0);
		checkFaultPosition(TARANTULA,"CM2_10",COMMONS_MATH,2,"AE_AK_1","org.apache.commons.math.estimation","org.apache.commons.math.estimation.AbstractEstimator","getCovariances(EstimationProblem)",0);
		checkFaultPosition(TARANTULA,"CM2_10",COMMONS_MATH,2,"CRVG_AK_1","org.apache.commons.math.random","org.apache.commons.math.random.CorrelatedRandomVectorGenerator","decompose(RealMatrix,double)",539);
		checkFaultPosition(TARANTULA,"CM2_10",COMMONS_MATH,2,"F_AK_2","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","compareTo(Fraction)",39);
		checkFaultPosition(TARANTULA,"CM2_11",COMMONS_MATH,2,"ABI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.AdamsBashforthIntegrator","AdamsBashforthIntegrator(int,double,double,double,double)",0);
		checkFaultPosition(TARANTULA,"CM2_11",COMMONS_MATH,2,"F_AK_2","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","compareTo(Fraction)",39);
		checkFaultPosition(TARANTULA,"CM2_11",COMMONS_MATH,2,"MU_AK_5","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",8);
		checkFaultPosition(TARANTULA,"CM2_11",COMMONS_MATH,2,"URSU_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.UnivariateRealSolverUtils","bracket(UnivariateRealFunction,double,double,double,int)",174);
		checkFaultPosition(TARANTULA,"CM2_12",COMMONS_MATH,2,"MU_AK_1","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",0);
		checkFaultPosition(TARANTULA,"CM2_12",COMMONS_MATH,2,"MU_AK_2","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","factorial(int)",26);
		checkFaultPosition(TARANTULA,"CM2_12",COMMONS_MATH,2,"MU_AK_4","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficientLog(int,int)",66);
		checkFaultPosition(TARANTULA,"CM2_12",COMMONS_MATH,2,"MU_AK_6","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","equals(double,double,double)",0);
		checkFaultPosition(TARANTULA,"CM2_13",COMMONS_MATH,2,"F_AK_2","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","compareTo(Fraction)",39);
		checkFaultPosition(TARANTULA,"CM2_13",COMMONS_MATH,2,"MU_AK_4","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficientLog(int,int)",66);
		checkFaultPosition(TARANTULA,"CM2_13",COMMONS_MATH,2,"MU_AK_5","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",8);
		checkFaultPosition(TARANTULA,"CM2_13",COMMONS_MATH,2,"MU_AK_6","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","equals(double,double,double)",0);
		checkFaultPosition(TARANTULA,"CM2_14",COMMONS_MATH,2,"AE_AK_1","org.apache.commons.math.estimation","org.apache.commons.math.estimation.AbstractEstimator","getCovariances(EstimationProblem)",0);
		checkFaultPosition(TARANTULA,"CM2_14",COMMONS_MATH,2,"MU_AK_1","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","gcd(int,int)",0);
		checkFaultPosition(TARANTULA,"CM2_14",COMMONS_MATH,2,"MU_AK_2","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","factorial(int)",26);
		checkFaultPosition(TARANTULA,"CM2_14",COMMONS_MATH,2,"MU_AK_3","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficient(int,int)",58);
		checkFaultPosition(TARANTULA,"CM2_15",COMMONS_MATH,2,"CDI_AK_1","org.apache.commons.math.linear","org.apache.commons.math.linear.CholeskyDecompositionImpl","CholeskyDecompositionImpl(RealMatrix,double,double)",207);
		checkFaultPosition(TARANTULA,"CM2_15",COMMONS_MATH,2,"F_AK_2","org.apache.commons.math.fraction","org.apache.commons.math.fraction.Fraction","compareTo(Fraction)",39);
		checkFaultPosition(TARANTULA,"CM2_15",COMMONS_MATH,2,"MU_AK_2","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","factorial(int)",26);
		checkFaultPosition(TARANTULA,"CM2_15",COMMONS_MATH,2,"MU_AK_3","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficient(int,int)",58);
		checkFaultPosition(TARANTULA,"CM2_16",COMMONS_MATH,2,"ABI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.AdamsBashforthIntegrator","AdamsBashforthIntegrator(int,double,double,double,double)",0);
		checkFaultPosition(TARANTULA,"CM2_16",COMMONS_MATH,2,"CDI_AK_1","org.apache.commons.math.linear","org.apache.commons.math.linear.CholeskyDecompositionImpl","CholeskyDecompositionImpl(RealMatrix,double,double)",207);
		checkFaultPosition(TARANTULA,"CM2_16",COMMONS_MATH,2,"MU_AK_2","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","factorial(int)",26);
		checkFaultPosition(TARANTULA,"CM2_16",COMMONS_MATH,2,"MU_AK_3","org.apache.commons.math.util","org.apache.commons.math.util.MathUtils","binomialCoefficient(int,int)",58);
		
		checkFaultPosition(TARANTULA,"CM3_01",COMMONS_MATH,3,"BS_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.BrentSolver","solve(UnivariateRealFunction,double,double,double)",109);
		checkFaultPosition(TARANTULA,"CM3_01",COMMONS_MATH,3,"ERKI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.EmbeddedRungeKuttaIntegrator","integrate(FirstOrderDifferentialEquations,double,double[],double,double[])",727);
		checkFaultPosition(TARANTULA,"CM3_02",COMMONS_MATH,3,"BS_AK_1","org.apache.commons.math.analysis.solvers","org.apache.commons.math.analysis.solvers.BrentSolver","solve(UnivariateRealFunction,double,double,double)",109);
		checkFaultPosition(TARANTULA,"CM3_02",COMMONS_MATH,3,"RKI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.RungeKuttaIntegrator","integrate(FirstOrderDifferentialEquations,double,double[],double,double[])",578);
		checkFaultPosition(TARANTULA,"CM3_03",COMMONS_MATH,3,"ERKI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.EmbeddedRungeKuttaIntegrator","integrate(FirstOrderDifferentialEquations,double,double[],double,double[])",727);
		checkFaultPosition(TARANTULA,"CM3_03",COMMONS_MATH,3,"RKI_AK_1","org.apache.commons.math.ode.nonstiff","org.apache.commons.math.ode.nonstiff.RungeKuttaIntegrator","integrate(FirstOrderDifferentialEquations,double,double[],double,double[])",578);
		
		makeBudgets(TARANTULA,COMMONS_MATH);
		makeBudgetsMultipleFaults(TARANTULA,COMMONS_MATH,true);
		makeBudgetsMultipleFaults(TARANTULA,COMMONS_MATH,false);
		
		makeHeader();
		
		checkFaultPosition(TARANTULA,"HS2_01",HSQLDB,2,"EL_AK_1","org.hsqldb","org.hsqldb.ExpressionLogical","resolveTypesForComparison(Session,Expression)",840);
		checkFaultPosition(TARANTULA,"HS2_01",HSQLDB,2,"QS_AK_1","org.hsqldb","org.hsqldb.QuerySpecification","setAggregateConditions(Session)",0);
		checkFaultPosition(TARANTULA,"HS2_02",HSQLDB,2,"EL_AK_1","org.hsqldb","org.hsqldb.ExpressionLogical","resolveTypesForComparison(Session,Expression)",840);
		checkFaultPosition(TARANTULA,"HS2_02",HSQLDB,2,"QS_AK_2","org.hsqldb","org.hsqldb.QuerySpecification","setDistinctConditions(Session)",123);
		checkFaultPosition(TARANTULA,"HS2_03",HSQLDB,2,"QS_AK_1","org.hsqldb","org.hsqldb.QuerySpecification","setAggregateConditions(Session)",0);
		checkFaultPosition(TARANTULA,"HS2_03",HSQLDB,2,"QS_AK_2","org.hsqldb","org.hsqldb.QuerySpecification","setDistinctConditions(Session)",123);
		
		makeBudgets(TARANTULA,HSQLDB);
		makeBudgetsMultipleFaults(TARANTULA,HSQLDB,true);
		makeBudgetsMultipleFaults(TARANTULA,HSQLDB,false);
		
		makeHeader();
				
		checkFaultPosition(TARANTULA,"JT1_01",JTOPAS,1,"FAULT_5","de.susebox.java.util","de.susebox.java.util.AbstractTokenizer","isKeyword(int,int)",20);
		checkFaultPosition(TARANTULA,"JT1_01",JTOPAS,1,"FAULT_6","de.susebox.java.util","de.susebox.java.util.AbstractTokenizer","test4Normal(Token)",82);
		
		makeBudgets(TARANTULA,JTOPAS);
		makeBudgetsMultipleFaults(TARANTULA,JTOPAS,true);
		makeBudgetsMultipleFaults(TARANTULA,JTOPAS,false);
		
		makeHeader();
		
		checkFaultPosition(TARANTULA,"PMD3_01",PMD,3,"RV_AK_1","net.sourceforge.pmd","net.sourceforge.pmd.RuleViolation","RuleViolation(Rule,RuleContext,SimpleNode,String)",431);
		checkFaultPosition(TARANTULA,"PMD3_01",PMD,3,"XMLR_AK_1","net.sourceforge.pmd.cpd","net.sourceforge.pmd.cpd.XMLRenderer","render(Iterator)",133);
		
		makeBudgets(TARANTULA,PMD);
		makeBudgetsMultipleFaults(TARANTULA,PMD,true);
		makeBudgetsMultipleFaults(TARANTULA,PMD,false);
		
		makeHeader();
		
		checkFaultPosition(TARANTULA,"XML1_01",XML_SECURITY,1,"CE_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","updateInscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",302);
		checkFaultPosition(TARANTULA,"XML1_01",XML_SECURITY,1,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","namespaceIsAbsolute(String)",42);
		checkFaultPosition(TARANTULA,"XML1_01",XML_SECURITY,1,"CN2_AK_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315","updateinscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",322);
		checkFaultPosition(TARANTULA,"XML1_01",XML_SECURITY,1,"CNC_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","XMLSignatureInput(Node,CachedXPathAPI)",0);
		checkFaultPosition(TARANTULA,"XML1_02",XML_SECURITY,1,"CE_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","updateInscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",302);
		checkFaultPosition(TARANTULA,"XML1_02",XML_SECURITY,1,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","namespaceIsAbsolute(String)",42);
		checkFaultPosition(TARANTULA,"XML1_02",XML_SECURITY,1,"CN2_AK_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315","updateinscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",322);
		checkFaultPosition(TARANTULA,"XML1_02",XML_SECURITY,1,"XSI_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","getNodeSet()",38);
		checkFaultPosition(TARANTULA,"XML1_03",XML_SECURITY,1,"CE_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","updateInscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",302);
		checkFaultPosition(TARANTULA,"XML1_03",XML_SECURITY,1,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","namespaceIsAbsolute(String)",42);
		checkFaultPosition(TARANTULA,"XML1_03",XML_SECURITY,1,"CNC_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","XMLSignatureInput(Node,CachedXPathAPI)",0);
		checkFaultPosition(TARANTULA,"XML1_03",XML_SECURITY,1,"XSI_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","getNodeSet()",38);
		checkFaultPosition(TARANTULA,"XML1_04",XML_SECURITY,1,"CE_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","updateInscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",302);
		checkFaultPosition(TARANTULA,"XML1_04",XML_SECURITY,1,"CN2_AK_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315","updateinscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",322);
		checkFaultPosition(TARANTULA,"XML1_04",XML_SECURITY,1,"CNC_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","XMLSignatureInput(Node,CachedXPathAPI)",0);
		checkFaultPosition(TARANTULA,"XML1_04",XML_SECURITY,1,"XSI_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","getNodeSet()",38);
		checkFaultPosition(TARANTULA,"XML1_05",XML_SECURITY,1,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","namespaceIsAbsolute(String)",42);
		checkFaultPosition(TARANTULA,"XML1_05",XML_SECURITY,1,"CN2_AK_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315","updateinscopeNamespacesAndReturnVisibleAttrs(Element,Map,Map)",322);
		checkFaultPosition(TARANTULA,"XML1_05",XML_SECURITY,1,"CNC_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","XMLSignatureInput(Node,CachedXPathAPI)",0);
		checkFaultPosition(TARANTULA,"XML1_05",XML_SECURITY,1,"XSI_AK_1","org.apache.xml.security.signature","org.apache.xml.security.signature.XMLSignatureInput","getNodeSet()",38);
		
		checkFaultPosition(TARANTULA,"XML2_01",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(TARANTULA,"XML2_01",XML_SECURITY,2,"CB_HD_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","getPositionRelativeToDocumentElement(Node)",56);
		checkFaultPosition(TARANTULA,"XML2_01",XML_SECURITY,2,"CB_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","outputPItoWriter(ProcessingInstruction)",87);
		checkFaultPosition(TARANTULA,"XML2_01",XML_SECURITY,2,"CH_HD_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",63);
		checkFaultPosition(TARANTULA,"XML2_02",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(TARANTULA,"XML2_02",XML_SECURITY,2,"CB_HD_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","getPositionRelativeToDocumentElement(Node)",56);
		checkFaultPosition(TARANTULA,"XML2_02",XML_SECURITY,2,"CB_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","outputPItoWriter(ProcessingInstruction)",87);
		checkFaultPosition(TARANTULA,"XML2_02",XML_SECURITY,2,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",159);
		checkFaultPosition(TARANTULA,"XML2_03",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(TARANTULA,"XML2_03",XML_SECURITY,2,"CB_HD_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","getPositionRelativeToDocumentElement(Node)",56);
		checkFaultPosition(TARANTULA,"XML2_03",XML_SECURITY,2,"CB_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","outputPItoWriter(ProcessingInstruction)",87);
		checkFaultPosition(TARANTULA,"XML2_03",XML_SECURITY,2,"RF_HD_2","org.apache.xml.security.signature","org.apache.xml.security.signature.Reference","dereferenceURIandPerformTransforms()",0);
		checkFaultPosition(TARANTULA,"XML2_04",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(TARANTULA,"XML2_04",XML_SECURITY,2,"CB_HD_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","getPositionRelativeToDocumentElement(Node)",56);
		checkFaultPosition(TARANTULA,"XML2_04",XML_SECURITY,2,"CH_HD_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",63);
		checkFaultPosition(TARANTULA,"XML2_04",XML_SECURITY,2,"RF_HD_2","org.apache.xml.security.signature","org.apache.xml.security.signature.Reference","dereferenceURIandPerformTransforms()",0);
		checkFaultPosition(TARANTULA,"XML2_05",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(TARANTULA,"XML2_05",XML_SECURITY,2,"CB_HD_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","getPositionRelativeToDocumentElement(Node)",56);
		checkFaultPosition(TARANTULA,"XML2_05",XML_SECURITY,2,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",159);
		checkFaultPosition(TARANTULA,"XML2_05",XML_SECURITY,2,"RF_HD_2","org.apache.xml.security.signature","org.apache.xml.security.signature.Reference","dereferenceURIandPerformTransforms()",0);
		checkFaultPosition(TARANTULA,"XML2_06",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(TARANTULA,"XML2_06",XML_SECURITY,2,"CB_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","outputPItoWriter(ProcessingInstruction)",87);
		checkFaultPosition(TARANTULA,"XML2_06",XML_SECURITY,2,"CH_HD_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",63);
		checkFaultPosition(TARANTULA,"XML2_06",XML_SECURITY,2,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",159);
		checkFaultPosition(TARANTULA,"XML2_07",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(TARANTULA,"XML2_07",XML_SECURITY,2,"CB_HD_3","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","outputPItoWriter(ProcessingInstruction)",87);
		checkFaultPosition(TARANTULA,"XML2_07",XML_SECURITY,2,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",159);
		checkFaultPosition(TARANTULA,"XML2_07",XML_SECURITY,2,"RF_HD_2","org.apache.xml.security.signature","org.apache.xml.security.signature.Reference","dereferenceURIandPerformTransforms()",0);
		checkFaultPosition(TARANTULA,"XML2_08",XML_SECURITY,2,"C2E_AK_1","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.Canonicalizer20010315Excl","handleAttributes(Element)",1732);
		checkFaultPosition(TARANTULA,"XML2_08",XML_SECURITY,2,"CH_HD_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",63);
		checkFaultPosition(TARANTULA,"XML2_08",XML_SECURITY,2,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",159);
		checkFaultPosition(TARANTULA,"XML2_08",XML_SECURITY,2,"RF_HD_2","org.apache.xml.security.signature","org.apache.xml.security.signature.Reference","dereferenceURIandPerformTransforms()",0);
		checkFaultPosition(TARANTULA,"XML2_09",XML_SECURITY,2,"CB_HD_2","org.apache.xml.security.c14n.implementations","org.apache.xml.security.c14n.implementations.CanonicalizerBase","getPositionRelativeToDocumentElement(Node)",56);
		checkFaultPosition(TARANTULA,"XML2_09",XML_SECURITY,2,"CH_HD_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",63);
		checkFaultPosition(TARANTULA,"XML2_09",XML_SECURITY,2,"CHP_AK_1","org.apache.xml.security.c14n.helper","org.apache.xml.security.c14n.helper.C14nHelper","sortAttributes(Object[])",159);
		checkFaultPosition(TARANTULA,"XML2_09",XML_SECURITY,2,"RF_HD_2","org.apache.xml.security.signature","org.apache.xml.security.signature.Reference","dereferenceURIandPerformTransforms()",0);
		
		checkFaultPosition(TARANTULA,"XML3_01",XML_SECURITY,3,"RF_HD_1","org.apache.xml.security.signature","org.apache.xml.security.signature.Reference","getDigestValue()",0);
		checkFaultPosition(TARANTULA,"XML3_01",XML_SECURITY,3,"XU_HD_2","org.apache.xml.security.utils","org.apache.xml.security.utils.XMLUtils","getOwnerDocument(Set)",18);
		
		makeBudgets(TARANTULA,XML_SECURITY);
		makeBudgetsMultipleFaults(TARANTULA,XML_SECURITY,true);
		makeBudgetsMultipleFaults(TARANTULA,XML_SECURITY,false);
		
		makeBudgets(TARANTULA,ALL_PROGRAMS);
		makeBudgetsMultipleFaults(TARANTULA,ALL_PROGRAMS,true);
		makeBudgetsMultipleFaults(TARANTULA,ALL_PROGRAMS,false);


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
		csvLineAbsBlocks.add(faultInfo.getFaultyTag());
		csvLineAbsBlocks.add(faultInfo.getFaultyClass());
		csvLineAbsBlocks.add(faultInfo.getFaultyMethod());
		csvLineAbsBlocks.add(String.valueOf(faultInfo.getFaultyBlock()));
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
	
	///multiple faults
	public void checkFaultPosition(String heuristic, String faultName, String programName, int programVersion, String faultyTag, String faultyPackage, String faultyClass, String faultyMethod, int faultyBlock){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName(faultName);
		faultInfo.setProgramName(programName);
		faultInfo.setProgramVersion(programVersion);
		faultInfo.setFaultyPackage(faultyPackage);
		faultInfo.setFaultyClass(faultyClass);
		faultInfo.setFaultyMethod(faultyMethod);
		faultInfo.setFaultyBlock(faultyBlock);
		faultInfo.setFaultyTag(faultyTag);
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
		header.add("fault-id");
		header.add("class");
		header.add("method");
		header.add("block");
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
		final int FIRST_BLANK_CELS = 10;
		int effortMethodIndex = 0;
		
		//add a header for ALL_PROGRAMS
		if(programName.equals(ALL_PROGRAMS)){
			rowBudget.add("TOTAL");
			for(int i = 1; i < ColumnIndexCHICDMultipleFaults.TOTAL_COLUMNS; i++){
				if(i == ColumnIndexCHICDMultipleFaults.HEURISTIC){
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
		for(int i = 0; i < ColumnIndexCHICDMultipleFaults.TOTAL_COLUMNS; i++){
			rowBudget.add("");
		}
		matrix.add(rowBudget);
		rowBudget = new ArrayList<String>();
	}
	
	
	//blockEffort: true for blocks and false for methods
	private List<String> sumEffortBudgetValuesPerBudget(String heuristic,int effortBudget, boolean blockEffort, String programName){
		List<List<Integer>> effortMatrix;
		if(blockEffort){
			effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndexCHICDMultipleFaults.ABS_BLOCKS_IDX_BEGIN,ColumnIndexCHICDMultipleFaults.ABS_BLOCKS_IDX_END,programName);
		}else{
			effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndexCHICDMultipleFaults.ABS_METHODS_IDX_BEGIN,ColumnIndexCHICDMultipleFaults.ABS_METHODS_IDX_END,programName);
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
					if(line.get(ColumnIndexCHICDMultipleFaults.HEURISTIC).equals(heuristic) && !line.get(ColumnIndexCHICDMultipleFaults.PROGRAM).equals("TOTAL")){
						column.add(Integer.parseInt(line.get(i)));
					}
				}else{
					if(line.get(ColumnIndexCHICDMultipleFaults.HEURISTIC).equals(heuristic) && line.get(ColumnIndexCHICDMultipleFaults.PROGRAM).equals(programName)){
						column.add(Integer.parseInt(line.get(i)));
					}
				}
			}
			effortColumns.add(column);
			column = new ArrayList<Integer>();
		}
		return effortColumns;
	}
	
///////////////////MULTIPLE FAULTS
	
	//best: true for best ranked fault and false for worst ranked
	private void makeBudgetsMultipleFaults(String heuristic, String programName, boolean best){
		List<String> rowBudget = new ArrayList<String>();
		final int FIRST_BLANK_CELS = 10;
		int effortMethodIndex = 0;
		
		//add a header for ALL_PROGRAMS
		if(programName.equals(ALL_PROGRAMS)){
			rowBudget.add("TOTAL");
			for(int i = 1; i < ColumnIndexCHICDMultipleFaults.TOTAL_COLUMNS; i++){
				if(i == ColumnIndexCHICDMultipleFaults.HEURISTIC){
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
				//add a header to identify the strategy: best or worst
				if(budget==EFFORT_BUDGET_RANGES[0] && i==0 && best){
					rowBudget.add("best");
				}
				else if(budget==EFFORT_BUDGET_RANGES[0] && i==0 && !best){
					rowBudget.add("worst");
				}else{
					rowBudget.add("");
				}
			}
			List<String> budgetValues = sumEffortBudgetValuesPerBudgetMultipleFaults(heuristic, budget,true,programName,best);
			for(String bud : budgetValues){
				rowBudget.add(bud);
			}
			rowBudget.add("met-budget "+((METHOD_EFFORT_BUDGET_RANGES[effortMethodIndex]==INFINITE) ? "30+" : METHOD_EFFORT_BUDGET_RANGES[effortMethodIndex]));
			List<String> methodBudgetValues = sumEffortBudgetValuesPerBudgetMultipleFaults(heuristic, METHOD_EFFORT_BUDGET_RANGES[effortMethodIndex],false,programName,best);
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
		for(int i = 0; i < ColumnIndexCHICDMultipleFaults.TOTAL_COLUMNS; i++){
			rowBudget.add("");
		}
		matrix.add(rowBudget);
		rowBudget = new ArrayList<String>();
	}
	
	//best: true for best ranked fault and false for worst ranked
	//blockEffort: true for blocks and false for methods
	private List<String> sumEffortBudgetValuesPerBudgetMultipleFaults(String heuristic,int effortBudget, boolean blockEffort, String programName, boolean best){
		List<List<Integer>> effortMatrix;
		if(blockEffort){
			effortMatrix = getEffortColumnsPerHeuristicMultipleFaults(heuristic,ColumnIndexCHICDMultipleFaults.ABS_BLOCKS_IDX_BEGIN,ColumnIndexCHICDMultipleFaults.ABS_BLOCKS_IDX_END,programName,best);
		}else{
			effortMatrix = getEffortColumnsPerHeuristicMultipleFaults(heuristic,ColumnIndexCHICDMultipleFaults.ABS_METHODS_IDX_BEGIN,ColumnIndexCHICDMultipleFaults.ABS_METHODS_IDX_END,programName,best);
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
	
	private List<List<Integer>> getEffortColumnsPerHeuristicMultipleFaults(String heuristic,int firstColIndex, int lastColIndex, String programName, boolean best){
		List<List<Integer>> effortColumns = new ArrayList<List<Integer>>();
		List<Integer> column = new ArrayList<Integer>();
		List<Integer> columnTemp = new ArrayList<Integer>();
		String currentFault = "";
		for(int i = firstColIndex; i <= lastColIndex; i++){
			for(List<String> line : matrix){
				if(programName.equals(ALL_PROGRAMS)){
					if(line.get(ColumnIndexCHICDMultipleFaults.HEURISTIC).equals(heuristic) && !line.get(ColumnIndexCHICDMultipleFaults.PROGRAM).equals("TOTAL")){
						column.add(Integer.parseInt(line.get(i)));
					}
				}else{
					if(line.get(ColumnIndexCHICDMultipleFaults.HEURISTIC).equals(heuristic) && line.get(ColumnIndexCHICDMultipleFaults.PROGRAM).equals(programName)){
						if(currentFault.isEmpty()){
							currentFault = line.get(ColumnIndexCHICDMultipleFaults.FAULT);
						}
						if(currentFault.equals(line.get(ColumnIndexCHICDMultipleFaults.FAULT))){
							columnTemp.add(Integer.parseInt(line.get(i)));
						}else{
							if(best){
								column.add(getBestRankedFault(columnTemp));
							}else{
								column.add(getWorstRankedFault(columnTemp));
							}
							columnTemp.clear();
							columnTemp.add(Integer.parseInt(line.get(i)));
							currentFault = line.get(ColumnIndexCHICDMultipleFaults.FAULT);
						}
					}
				}
				//when it is the last line of a fault version
				if(!line.get(ColumnIndexCHICDMultipleFaults.HEURISTIC).equals(heuristic) && !currentFault.isEmpty()){
					if(best){
						column.add(getBestRankedFault(columnTemp));
					}else{
						column.add(getWorstRankedFault(columnTemp));
					}
					columnTemp.clear();
					currentFault = "";
				}
			}
			effortColumns.add(column);
			column = new ArrayList<Integer>();
		}
		return effortColumns;
	}
	
	public int getBestRankedFault(List<Integer> rankingList){
		int best = 1000000000;
		for(int position : rankingList){
			if(position < best){
				best = position;
			}
		}
		return best;
	}
	
	public int getWorstRankedFault(List<Integer> rankingList){
		int worst = 0;
		for(int position : rankingList){
			if(position > worst){
				worst = position;
			}
		}
		return worst;
	}
	
	
	public void generateCSVFile(){
		try {
 			OutputStream os = new FileOutputStream(new File(PATHFILE+"ch-icd-output-ls-mult.csv"));
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
	
	public static void main(String[] args) {
		try{
			if(isDirValid(args[0])){
				String dirPath = args[0];
				
				//BatchExecutorLevelScoreMultipleFaults batch = new BatchExecutorLevelScoreMultipleFaults("/home/higor/data/r2f/reports-mf/");
				BatchExecutorLevelScoreMultipleFaults batch = new BatchExecutorLevelScoreMultipleFaults(dirPath);
				batch.execute();
				
			}else{
				System.out.println("Dir path is incorrect or it doesn't contain the right structure");
			}
		}catch(IndexOutOfBoundsException ex){
			System.out.println("Path argument not found!");
		}

	}

	private static boolean isDirValid(String strDir) {
		if(strDir == null || strDir.isEmpty()){
			return false;
		}
		File dir = new File(strDir);
		if(!dir.exists() || !dir.isDirectory()){
			return false;
		}
		return true;
	}

}
