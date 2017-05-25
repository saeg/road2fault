# Road2Fault

Fault localization tool that implements and analyzes contextualization strategies.

Before running Road2Fault, you must run InSS to instrument and collecting spectra data from the subject program. 

## Collecting spectrum data with InSS

### Installing InSS

Get the InSS project, available at https://github.com/higoramario/mis-mcp.git

This version of InSS contains the MCP and MCT strategies. 
README file has the instructions to compile the project and for its initial settings.


## Installing Road2Fault (linux and mac)

1. Run the Ant script (build.xml) to build the project.
```bash
ant
```

2. Create an enviroment variable for the 'build' folder.
```bash
export ROAD2FAULT_HOME=/home/user/apps/road2fault/build
```
   
3. Give execution permissions for the files in the **${ROAD2FAULT_HOME}/bin** folder.
```bash
sudo chmod +x ${ROAD2FAULT_HOME}/bin/*
```

## Instrumenting and creating data-flow graphs with InSS

1. set the InSS root folder.
```bash
export MIS_HOME=/home/user/apps/mis-mcp/build/mis
```

2. Instrument the faulty program.
```bash
${MIS_HOME}/bin/instrumenter --instrument ${PROGRAM_DIR}/target/classes/ --dest ${PROGRAM_DIR}/instrument/
```
**--instrument**: program's class folder

**--dest**: destination folder

3. Generate the program's data-flow graph.
```bash
${MIS_HOME}/bin/defuse --file ${PROGRAM_DIR}/target/classes/ --dest ${PROGRAM_DIR}/gxl/
```
**--file**: program's class folder

**--dest**: destination folder


## Collecting spectra

1. Set the CLASSPATH, including the instrumented classes, test classes, junit library, inss libraries (in ${MIS_HOME}/libs folder), and other libraries and folders from which the faulty program depends.
```bash
LIBS=
for i in `ls $MIS_HOME/libs/*.jar`
do
  LIBS=${LIBS}:${i}
done

export CLASSPATH=${PROGRAM_DIR}:${PROGRAM_DIR}/instrument/:${PROGRAM_DIR}/target/test-classes/:${PROGRAM_DIR}/lib/junit.jar${LIBS}
```

2. Collect the spectra for each test class running the following command:
```bash
   java -Dgxl.dir=${PROGRAM_DIR}/gxl \
   -Drequirement.determination=br.usp.each.opal.requirement.NodeDetermination \
   -Dinstrumentation.strategy=br.usp.each.inss.instrumentation.AllNodes \
   -Dsimulator.strategy=br.usp.each.inss.executor.SimulatorMethodCallPair \
   br.usp.each.inss.InSSTestRunner package.TestClass
```

**-Dgxl.dir**: directory that contains the data-flow graphs (gxl files) previously created

**-Drequirement.determination**: choose one of the following options 
- **NodeDetermination** for node, mcp, or mct spectra
- **DuaDetermination** for dua spectra
- **EdgeDetermination** for branch spectra

**-Dinstrumentation.strategy**: choose one of the following options
- **AllNodes** for node, mcp, or mct spectra
- **CorrectedDemandDriven** for dua spectra
- **AllEdges** for branch spectra
   
**-Dsimulator.strategy**: choose one of the following options
- **SimpleSimulator** for node, dua, or branch spectra
- **SimulatorMethodCallPair** for mcp spectra
- **SimulatorMethodCallTriple** for mct spectra

Insert the test class' name after **br.usp.each.inss.InSSTestRunner**.

The output is a file with the corresponding spectra extension (e.g., package.TestClass.mcp).

3. Save the spectra files in a specific folder.


## Running Road2Fault

1. Run the following command to execute Road2Fault.
```bash
${ROAD2FAULT_HOME}/bin/road2fault_mcp -r mcpspectra -rt mcp -hr ochiai -c ${PROGRAM_DIR}/target/classes -lt requirement
```
- Set the desired road2fault program to collect spectra data:
  ..- **road2fault_mcp** for MCP spectra and the MCP roadmap
  ..- **road2fault_unit** for node, branch or dua spectra
  ..- **road2fault_mct** for MCT spectra
  ..- **road2fault_rmcp** for the unit list with method position
- **-r**: the folder that contains the spectra files
- **-rt**: type of requirement: mcp, mct, node, branch, or dua 
- **-hr**: type of heuristic used to calculate the suspiciousness: ochiai, tarantula, drt, jaccard, zoltar, op, minus, kulczynski2, mccon, wong3
- **-c**: path of the original classes of the subject program
- **-lt**: type of list: requirement or csv for mcp or mct spectra; requirement, class, package or csv for node, branch or dua spectra

The output is an XML suspiciousness list organized by requirement, classes, or packages. The csv options generates the suspiciousness list in the csv format.
To run Road2Fault, it is necessary to remove files which the extension finish with '*-out'. These files contain the junit's output information and must not be processed by Road2Fault.

2. To generate the new unit list with the method position attribute, run:
```bash
$ROAD2FAULT_HOME/bin/road2fault_rmcp -uf list_dci_NODE_TARANTULA_BY_PACKAGE.xml-debug -rf list_dci_RMCP_TARANTULA.xml-debug
```
- **-uf**: previous unit list created by the 'road2fault_unit' program 
- **-rf**: roadmap

The position attribute was included for using in CodeForest.

# Filtering Strategies Calculator

Road2Fault extracts the fault localization results of debugging filtering strategies from the suspiciousness lists (.xml-debug extension).
The tool generates the results in csv files and also the log files to check if the strategies are working well.
It is also possible to plot bar charts with the results.

Currently, it is possible to extract results only for the faults used in the dataset we used in our experiment.  New faults can be added 
following the structure of **BatchExecutor**, since the faulty sites must be informed to calculate the results. 

## Current strategies

### Level Score (LS)
**InspectionStrategyLevelScorePerMethod**: Get level scores based on levels of each method. 
This strategy gets each score from a method, at most 15 score levels.

### Fixed Budget (FB)
**InspectionStrategyDeltaBudget**: it uses the effort budget as a delta. If the budget is 5, 
   this strategy checks in the block list (BL) the score which contains 5 blocks, and this 
   score is used to inspect the blocks inside the methods indicated by the roadmap. 
   If the 1st score (highest) contains more blocks than the budget, such score is returned.

## Folder structure
To run the extractor, the report files must be placed in the following structure: 
```
/home/user/experiments/{program-name}/{version_fault-name}
```
- **/home/user/experiments**: your local folder that contains the report files of all programs. 
- **program-name**: one folder for each program named with the program's name in lower case
- **version_fault-name**: one folder containing the *.xml-debug* files for each fault. 

The folder must be named with the version number preceded by letter *v*, and followed by '_' and the fault's description.
```
/home/user/experiments/ant/v1_CLJ_HD_1
```
## Report files
The tool runs results for two ranking heuristics: Ochiai and Tarantula.
Three report files for each heuristic are needed to execute extract the results:
- list_dci_MCP_OCHIAI.xml-debug
- list_dci_NODE_OCHIAI_BY_PACKAGE.xml-debug
- list_dci_NODE_OCHIAI_BY_REQUIREMENT.xml-debug

In case of Tarantula, the files has the description TARANTULA instead of OCHIAI.
The report files of all 62 faults from both heuristics must be inside the folder to execute the extractor.

## Running the Filtering Strategies Calculator from command line

1. There are two versions of the extractor: 
- **ch-icd-ls.jar**: Extract the results for the LS strategy, available [here](https://drive.google.com/open?id=0B2Vc3U9nBKO_TG44STZRdE9vdVU)
- **ch-icd-fb.jar**: Extract the results for the FB strategy, available [here](https://drive.google.com/open?id=0B2Vc3U9nBKO_Q1V3VmFpM25IRkU)

For both jars you must pass the path to the root folder that contains the report files.
```bash
java -jar ch-icd-ls.jar "/home/user/experiments/"
```

### Filtering Strategies Calculator's output:

1. A csv file (ch-icd-output-fb.csv or ch-icd-output-ls.csv) with the number of blocks and methods inspected until 
reach the fault by technique (ICD-LS, CH-LS, ICD-FB, CH-FB, and BL), by effort budget (1 - 100) and by different 
values for LS (1 - 15) and FB (5 - 100). The file contains the values for each program and fault, and summarized 
values by program and for all programs using Ochiai and Tarantula.
The csv files also contain the percentage of examined code to reach the faults.
We considered the worst case scenario to deal with ties, i.e., all blocks with score equal to the faulty one 
are included to determine the position of the faulty one block.

2. A log file containing all blocks and methods visited for all strategies per program, 
fault and heuristic. 

3. Bar plot charts with the results by program and for all programs, comparing CH-FB, ICD-FB, and BL, and also for 
CH-LS, ICD-LS, and BL. 

### Other strategies:
InspectionStrategy: original strategy used in the 1st version of icd. Methods with the same name are included at 
once in the roadmap, no matter their signatures or classes. The score precision is fully.

# Experiment's data and results

## Dataset 
We use 62 bugs in our experiments from the following projects.

| Project | # Faults |
|---------|---------:|
| Ant | 18 | 
| Commons-Math | 20 | 
| HSQLDB | 4 | 
| JTopas | 4 | 
| PMD | 2 | 
| XML-security | 13 | 
| XStream | 1 | 

Ant, JTopas, and XML-security were obtained from SIR (http://sir.unl.edu).
Commons-Math, HSQLDB, PMD, and XStream were obtained from their repositories.
We created a SIR-like structure to ease the insertion of faults for experiments. 
These latter ones are available [here](https://drive.google.com/open?id=0B2Vc3U9nBKO_M2JaMVNWUk5zSkk), along with instructions to insert the faults.

## Scripts

The scripts we used in the experiments are available [here](https://drive.google.com/open?id=0B2Vc3U9nBKO_MUpXU1c3TWFSUW8).

## Results

The main results of our experiments are available [here](https://drive.google.com/open?id=0B2Vc3U9nBKO_U0c4UGcxQVBFVTA). 
The [csv files and logs](https://drive.google.com/open?id=0B2Vc3U9nBKO_Q0w4SXpUR0hrRDg) generated by the calculator are also available.


# Citation
```
@article{
	title={Contextualizing Spectrum-based Fault Localization},
	author={Higor A. de Souza and Danilo Mutti and Marcos L. Chaim and Fabio Kon},
	journal={},
	year={},
	pages={},
	year={2017},
	note={submitted to Information and Software Technology}
}
```
