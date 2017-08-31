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
import br.usp.each.saeg.road2fault.extractor.model.MultipleFaultInfo;
import br.usp.each.saeg.road2fault.extractor.model.XmlBLReportFile;
import br.usp.each.saeg.road2fault.extractor.model.XmlBLTestCriteria;
import br.usp.each.saeg.road2fault.extractor.model.XmlMcpTestCriteria;
import br.usp.each.saeg.road2fault.extractor.model.XmlTestCriteria;

public class BatchExecutorFixedBudgetMultipleFaults {
	
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
	private final int FIXED_BUDGET_RANGES[] = {5,10,15,20,25,30,35,40,45,50,60,70,80,90,100};
	private final int FB_METHOD_EFFORT_BUDGET_RANGES[] = {1,2,3,4,5,6,7,8,9,10,15,20,25,30,INFINITE};
	
	private List<List<String>> matrix = new ArrayList<List<String>>();
	private List<String> csvLineAbsBlocks = new ArrayList<String>();
	private List<String> csvLineAbsMethods = new ArrayList<String>();
	private List<String> logFileList = new ArrayList<String>();
	private int executedMethods;
	private int executedBlocks;
	
	public BatchExecutorFixedBudgetMultipleFaults(String dirPath){
		PATHFILE = dirPath;
	}
	
	public void execute(){
		makeHeaderFB();
		
		
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
		

		checkFaultPosition(TARANTULA,"HS2_01",HSQLDB,2,"EL_AK_1","org.hsqldb","org.hsqldb.ExpressionLogical","resolveTypesForComparison(Session,Expression)",840);
		checkFaultPosition(TARANTULA,"HS2_01",HSQLDB,2,"QS_AK_1","org.hsqldb","org.hsqldb.QuerySpecification","setAggregateConditions(Session)",0);
		
		checkFaultPosition(TARANTULA,"HS2_02",HSQLDB,2,"EL_AK_1","org.hsqldb","org.hsqldb.ExpressionLogical","resolveTypesForComparison(Session,Expression)",840);
		checkFaultPosition(TARANTULA,"HS2_02",HSQLDB,2,"QS_AK_2","org.hsqldb","org.hsqldb.QuerySpecification","setDistinctConditions(Session)",123);
		
		checkFaultPosition(TARANTULA,"HS2_03",HSQLDB,2,"QS_AK_1","org.hsqldb","org.hsqldb.QuerySpecification","setAggregateConditions(Session)",0);
		checkFaultPosition(TARANTULA,"HS2_03",HSQLDB,2,"QS_AK_2","org.hsqldb","org.hsqldb.QuerySpecification","setDistinctConditions(Session)",123);
		
		
		checkFaultPosition(TARANTULA,"JT1_01",JTOPAS,1,"FAULT_5","de.susebox.java.util","de.susebox.java.util.AbstractTokenizer","isKeyword(int,int)",20);
		checkFaultPosition(TARANTULA,"JT1_01",JTOPAS,1,"FAULT_6","de.susebox.java.util","de.susebox.java.util.AbstractTokenizer","test4Normal(Token)",82);
		
		
		checkFaultPosition(TARANTULA,"PMD3_01",PMD,3,"RV_AK_1","net.sourceforge.pmd","net.sourceforge.pmd.RuleViolation","RuleViolation(Rule,RuleContext,SimpleNode,String)",431);
		checkFaultPosition(TARANTULA,"PMD3_01",PMD,3,"XMLR_AK_1","net.sourceforge.pmd.cpd","net.sourceforge.pmd.cpd.XMLRenderer","render(Iterator)",133);
		
		
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
		
		makeBudgetsFB(TARANTULA,ANT);
		makeHeaderFB();
		
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
		
		makeBudgetsFB(TARANTULA,COMMONS_MATH);
		makeHeaderFB();
		
		hsqldb_v1_JDBCCF_AK_1(TARANTULA);
		hsqldb_v2_EL_AK_1(TARANTULA);
		hsqldb_v2_QS_AK_1(TARANTULA);
		hsqldb_v2_QS_AK_2(TARANTULA);
		
		makeBudgetsFB(TARANTULA,HSQLDB);
		makeHeaderFB();
		
		jtopas_v1_FAULT_5(TARANTULA);
		jtopas_v1_FAULT_6(TARANTULA);
		//jtopas_v2_FAULT_1(TARANTULA);
		jtopas_v3_FAULT_4(TARANTULA);

		makeBudgetsFB(TARANTULA,JTOPAS);
		makeHeaderFB();
		
		pmd_v3_RV_AK_1(TARANTULA);
		pmd_v3_XMLR_AK_1(TARANTULA);

		makeBudgetsFB(TARANTULA,PMD);
		makeHeaderFB();
		
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

		makeBudgetsFB(TARANTULA,XML_SECURITY);
		makeHeaderFB();
		
		xstream_v1_AM_AK_1(TARANTULA);

		makeBudgetsFB(TARANTULA,XSTREAM);
		makeBudgetsFB(TARANTULA,ALL_PROGRAMS);
		makeHeaderFB();
		
				
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
		
		makeBudgetsFB(OCHIAI,ANT);
		makeHeaderFB();
		
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

		makeBudgetsFB(OCHIAI,COMMONS_MATH);
		makeHeaderFB();
		
		hsqldb_v1_JDBCCF_AK_1(OCHIAI);
		hsqldb_v2_EL_AK_1(OCHIAI);
		hsqldb_v2_QS_AK_1(OCHIAI);
		hsqldb_v2_QS_AK_2(OCHIAI);

		makeBudgetsFB(OCHIAI,HSQLDB);
		makeHeaderFB();
		
		jtopas_v1_FAULT_5(OCHIAI);
		jtopas_v1_FAULT_6(OCHIAI);
		//jtopas_v2_FAULT_1(OCHIAI);
		jtopas_v3_FAULT_4(OCHIAI);

		makeBudgetsFB(OCHIAI,JTOPAS);
		makeHeaderFB();
		
		pmd_v3_RV_AK_1(OCHIAI);
		pmd_v3_XMLR_AK_1(OCHIAI);

		makeBudgetsFB(OCHIAI,PMD);
		makeHeaderFB();
		
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

		makeBudgetsFB(OCHIAI,XML_SECURITY);
		makeHeaderFB();
		
		xstream_v1_AM_AK_1(OCHIAI);

		makeBudgetsFB(OCHIAI,XSTREAM);
		makeBudgetsFB(OCHIAI,ALL_PROGRAMS);
				
		generateCSVFile();
		
		//generateCharts();
		//generateChartsForLevelScore();
		
	}
	
	/*
	 * Use for FixedBudget strategies
	 * */
	public void calculatePerformanceFixedBudget(XmlTestCriteria criteria,XmlMcpTestCriteria mcpCriteria, XmlBLReportFile blReportFile, MultipleFaultInfo multFaultInfo, String heuristic){
		csvLineAbsBlocks = new ArrayList<String>();
		csvLineAbsMethods = new ArrayList<String>();
		csvLineAbsBlocks.add(multFaultInfo.getProgramName());
		csvLineAbsBlocks.add(String.valueOf(multFaultInfo.getProgramVersion()));
		csvLineAbsBlocks.add(multFaultInfo.getFaultName());
		csvLineAbsBlocks.add(heuristic);
		csvLineAbsBlocks.add(String.valueOf(mcpCriteria.getMcpFaultyMethodScoreMax(faultInfo.getFaultyMethod())));
		csvLineAbsBlocks.add(String.valueOf(criteria.getFaultyBlockScore()));
		csvLineAbsBlocks.add(String.valueOf(criteria.getMaxBlockScore()));
		csvLineAbsBlocks.add("-");
		csvLineAbsBlocks.add("-");
		csvLineAbsBlocks.add("-");
		for(int deltaBudget : FIXED_BUDGET_RANGES){
			InspectionStrategyDeltaBudget.calculateMcpPerformance(criteria, mcpCriteria, deltaBudget, blReportFile); //only for InspectionStrategyDeltaBudget
			csvLineAbsBlocks.add(String.valueOf(InspectionStrategyDeltaBudget.inspectedBlocksInMcp));
			csvLineAbsMethods.add(String.valueOf(InspectionStrategyDeltaBudget.inspectedMethodsInMcp));
			logFileList.addAll(InspectionStrategyDeltaBudget.logFileList);
			InspectionStrategyDeltaBudget.clear();
		}
		
		InspectionStrategyDeltaBudget.calculateBlockListPerformance(blReportFile);
		csvLineAbsBlocks.add(String.valueOf(InspectionStrategyDeltaBudget.inspectedBlocksInBL));
		logFileList.addAll(InspectionStrategyDeltaBudget.logFileList);
		InspectionStrategyDeltaBudget.clear();
		
		for(int deltaBudget : FIXED_BUDGET_RANGES){
			InspectionStrategyDeltaBudget.calculateMethodHitSpectraPerformanceForBlocksAndDelta(criteria, deltaBudget, blReportFile); //only for InspectionStrategyDeltaBudget
			csvLineAbsBlocks.add(String.valueOf(InspectionStrategyDeltaBudget.inspectedBlocksInMethodHitSpectra));
			csvLineAbsMethods.add(String.valueOf(InspectionStrategyDeltaBudget.inspectedMethodsInMethodHitSpectra));
			logFileList.addAll(InspectionStrategyDeltaBudget.logFileList);
			InspectionStrategyDeltaBudget.clear();
		}
		generateLogFile(multFaultInfo,heuristic);
		csvLineAbsBlocks.add(multFaultInfo.getFaultName());
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
		criteria.markAsMultipleFault();
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
		blReportFile.markAsMultipleFault();
		
		executedBlocks = criteria.getTotalExecutedBlocks();
		executedMethods = criteria.getTotalExecutedMethods();
		
		logFileList.add("########## Fault: "+faultInfo.getFaultName() + ", "+ heuristic  + ", program: "+ faultInfo.getProgramName() + ", v"+faultInfo.getProgramVersion() + ", block: " + faultInfo.getFaultyBlock(i)  + ", " + faultInfo.getFaultyMethod(i) + ", " + faultInfo.getFaultyClass(i));
		System.out.println("Fault: "+faultInfo.getFaultName() + ", "+ heuristic  + ", program: "+ faultInfo.getProgramName() + ", v"+faultInfo.getProgramVersion() + ", block: " + faultInfo.getFaultyBlock(i)  + ", " + faultInfo.getFaultyMethod(i) + ", " + faultInfo.getFaultyClass(i));
		
		calculatePerformanceFixedBudget(criteria,mcpCriteria,blReportFile,faultInfo,heuristic);
		
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

	public void ANT1_00(String heuristic){
		FaultInfo faultInfo = new FaultInfo();
		faultInfo.setFaultName("");
		faultInfo.setProgramName(ANT);
		faultInfo.setProgramVersion(1);
		faultInfo.setFaultyPackage("");
		faultInfo.setFaultyClass("");
		faultInfo.setFaultyMethod("");
		faultInfo.setFaultyBlock(0);
		faultAnalysis(faultInfo,heuristic);
	}
	
	public void ANT1_01(String heuristic){
		MultipleFaultInfo multFaultInfo = new MultipleFaultInfo();
		multFaultInfo.setFaultyPackage("org.apache.tools.ant");
		multFaultInfo.setFaultyClass("org.apache.tools.ant.ProjectHelper");
		multFaultInfo.setFaultyMethod("parse()");
		multFaultInfo.setFaultyBlock(68);
		faultAnalysis(multFaultInfo,heuristic);
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
	
	
	private void makeHeaderFB(){
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
		header.add("ch");
		for(double delta : FIXED_BUDGET_RANGES){
			header.add("icd-fb-"+(int)delta);
		}
		header.add("bl");
		for(double delta : FIXED_BUDGET_RANGES){
			header.add("ch-fb-"+(int)delta);
		}
		header.add("met-budgets");
		for(double delta : FIXED_BUDGET_RANGES){
			header.add("icd-fb-"+(int)delta);
		}
		for(double delta : FIXED_BUDGET_RANGES){
			header.add("ch-fb-"+(int)delta);
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
	
	private void makeBudgetsFB(String heuristic, String programName){
		List<String> rowBudget = new ArrayList<String>();
		final int FIRST_BLANK_CELS = 6;
		int effortMethodIndex = 0;
		
		//add a header for ALL_PROGRAMS
		if(programName.equals(ALL_PROGRAMS)){
			rowBudget.add("TOTAL");
			for(int i = 1; i < ColumnIndexCHICD.DB_TOTAL_COLUMNS; i++){
				if(i == ColumnIndexCHICD.HEURISTIC){
					rowBudget.add(heuristic);
				}else{
					rowBudget.add("");
				}
			}
			matrix.add(rowBudget);
			rowBudget = new ArrayList<String>();
			makeHeaderFB();
		}
		
		//block absolute budgets
		for(int budget : FIXED_BUDGET_RANGES){
			rowBudget.add("budget 1 - "+budget);
			for(int i = 0; i < FIRST_BLANK_CELS; i++){
				rowBudget.add("");
			}
			//delta budget summaries
			List<String> budgetAbsDB = sumEffortBudgetDB(heuristic, budget,true,programName);
			for(String bud : budgetAbsDB){
				rowBudget.add(bud);
			}
			//effort values for blocks, methods, and percentuals
			List<String> budgetValues = sumEffortBudgetValuesPerBudget(heuristic, budget,true,programName);
			for(String bud : budgetValues){
				rowBudget.add(bud);
			}
			
			rowBudget.add("met-budget "+((FB_METHOD_EFFORT_BUDGET_RANGES[effortMethodIndex]==INFINITE) ? "30+" : FB_METHOD_EFFORT_BUDGET_RANGES[effortMethodIndex]));
			
			
			List<String> methodBudgetValues = sumEffortBudgetValuesPerBudget(heuristic, FB_METHOD_EFFORT_BUDGET_RANGES[effortMethodIndex],false,programName);
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
		for(int i = 0; i < ColumnIndexCHICD.DB_TOTAL_COLUMNS; i++){
			rowBudget.add("");
		}
		matrix.add(rowBudget);
		rowBudget = new ArrayList<String>();
	}
	
	//blockEffort: true for blocks and false for methods
	private List<String> sumEffortBudgetValuesPerBudget(String heuristic,int effortBudget, boolean blockEffort, String programName){
		List<List<Integer>> effortMatrix;
		if(blockEffort){
			effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndexCHICD.DB_ABS_BLOCKS_IDX_BEGIN,ColumnIndexCHICD.DB_ABS_BLOCKS_IDX_END,programName);
		}else{
			effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndexCHICD.DB_ABS_METHODS_IDX_BEGIN,ColumnIndexCHICD.DB_ABS_METHODS_IDX_END,programName);
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
	
	//for DeltaBudget
	private List<String> sumEffortBudgetDB(String heuristic,int effortBudget, boolean blockEffort, String programName){
		List<List<Integer>> effortMatrix;
		int icdIndex = 0;
		int blIndex = 15;
		int mhsIndex = 16;
		int icdMhsColumnSize = 15;
		
		if(blockEffort){
			effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndexCHICD.DB_ABS_BLOCKS_IDX_BEGIN,ColumnIndexCHICD.DB_ABS_BLOCKS_IDX_END,programName);
		}else{
			effortMatrix = getEffortColumnsPerHeuristic(heuristic,ColumnIndexCHICD.DB_ABS_METHODS_IDX_BEGIN,ColumnIndexCHICD.DB_ABS_METHODS_IDX_END,programName);
			blIndex = -1;
			mhsIndex = 15;
		}
		List<String> effortBudgetRow = new ArrayList<String>();
		List<Integer> countedRows = new ArrayList<Integer>();
		int countRowIndex = 0;
		int effortOccurrences = 0;
		int effortBudgetIndex = 0;
		for(List<Integer> effortColumn : effortMatrix){
			countRowIndex = 0;
			if(effortBudgetIndex < (icdIndex+icdMhsColumnSize)){
				for(Integer effort : effortColumn){
					if(!countedRows.contains(countRowIndex)){
						if(effort <= effortBudget){
							effortOccurrences++;
							countedRows.add(countRowIndex);
						}
					}
					countRowIndex++;
				}
				
			}
			else if(effortBudgetIndex == blIndex){
				//storing results from ich
				effortBudgetRow.add(String.valueOf(effortOccurrences));
				effortOccurrences = 0;
				//reseting from ich before using ch
				countedRows.clear();
				
				for(Integer effort : effortColumn){
					if(effort <= effortBudget){
						effortOccurrences++;
					}
				}
				effortBudgetRow.add(String.valueOf(effortOccurrences));
				effortOccurrences = 0;
			}else if(effortBudgetIndex >= mhsIndex && effortBudgetIndex < (mhsIndex+icdMhsColumnSize)){
				//storing results and reseting from ich before using ch when not passing on bl 
				if(blIndex == -1){
					effortBudgetRow.add(String.valueOf(effortOccurrences));
					effortOccurrences = 0;
					countedRows.clear();
				}

				for(Integer effort : effortColumn){
					if(!countedRows.contains(countRowIndex)){
						if(effort <= effortBudget){
							effortOccurrences++;
							countedRows.add(countRowIndex);
						}
					}
					countRowIndex++;
				}
				
			}
			effortBudgetIndex++;
		}
		effortBudgetRow.add(String.valueOf(effortOccurrences));
		effortOccurrences = 0;
		return effortBudgetRow;
	}
			
	
	
	public void generateCSVFile(){
		try {
 			OutputStream os = new FileOutputStream(new File(PATHFILE+"ch-icd-output-fb.csv"));
            os.write(export());
            os.close();
	 	} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void generateLogFile(MultipleFaultInfo multFaultInfo,String heuristic){
		File logFile = new File(PATHFILE+"ch-icd-fb-inspection-log_"+multFaultInfo.getProgramName()+"_"+multFaultInfo.getProgramVersion()+"_"+multFaultInfo.getFaultName()+"_"+heuristic+".txt");
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
		
		effortDataset = parser.createEffectiveBarChartDataset(matrix, heuristic, programName, RangeIndexCHICD.delta_budget_icd_bl_ch(), RangeIndexCHICD.budget_5_100());
		chart.loadBarChartDataset(effortDataset, chartType, analysisType, xAxis, yAxis, chartTitle, fileName);

	}
	
	private void generateCharts() {
		String heuristic = TARANTULA;
		String strategy = "delta_budget";
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
