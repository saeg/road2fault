# Road2Fault

Fault localization tool that implements and analyzes contextualization strategies.

Before running Road2Fault, you must run InSS to instrument and collecting spectra data from the subject program. 

## Collecting spectrum data with InSS

### Installing InSS:

Get the InSS project, available at https://github.com:higoramario/mis-mcp.git
README file has the instructions to compile the project and for its initial settings.


## Installing Road2Fault (linux and mac):

1. Run the Ant script (build.xml) to build the project.
```bash
ant dist
```

2. Create an enviroment variable for the 'build' folder
```bash
export ROAD2FAULT_HOME=/home/user/apps/road2fault/build
```
   
3. Give execution permissions for the files in the '$ROAD2FAULT_HOME/bin' folder
```bash
sudo chmod +x road2fault_unit road2fault_mcp road2fault_mct road2fault_rmcp
```

## Instrumenting and creating data-flow graphs with InSS:

1. set the InSS root folder 
```bash
export INSS_HOME=/home/user/apps/mis
```

2. Instrument the faulty program. 
```bash
${INSS_HOME}/bin/instrumenter --instrument ${PROGRAM_DIR}/target/classes/ --dest ${PROGRAM_DIR}/instrument/
```
..* **--instrument**: program's class folder
..* **--dest**: destination folder

3. Generate the program's data-flow graph
```bash
${INSS_HOME}/bin/defuse --file ${PROGRAM_DIR}/target/classes/ --dest ${PROGRAM_DIR}/gxl/
```
**--file**: program's class folder
**--dest**: destination folder


## Collecting spectra

1. Set the CLASSPATH, including the instrumented classes, test classes, junit library, and other libraries and folders from which the faulty program.
```bash
export CLASSPATH=${PROGRAM_DIR}:${PROGRAM_DIR}/instrument/:${PROGRAM_DIR}/target/test-classes/:${PROGRAM_DIR}/lib/junit.jar
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
   -'NodeDetermination' for node, mcp, or mct spectra
   -'DuaDetermination' for dua spectra
   -'EdgeDetermination' for branch spectra

**-Dinstrumentation.strategy**: choose one of the following options
   -'AllNodes' for node, mcp, or mct spectra
   -'CorrectedDemandDriven' for dua spectra
   -'AllEdges' for branch spectra
   
**-Dsimulator.strategy**: choose one of the following options
   -'SimpleSimulator' for node, dua, or branch spectra
   -'SimulatorMethodCallPair' for mcp spectra
   -'SimulatorMethodCallTriple' for mct spectra

The output is a file with the corresponding spectra extension (e.g., package.TestClass.mcp)

3. Save the spectra files in a specific folder.


## Running Road2Fault

1. Run the following command to execute Road2Fault 
```bash
${ROAD2FAULT_HOME}/bin/road2fault_mcp -r mcpspectra -rt mcp -hr ochiai -c target/classes -lt requirement
```
Set the desired road2fault program to collect spectra data:
  -'road2fault_mcp' for MCP spectra and the MCP roadmap
  -'road2fault_unit' for node, branch or dua spectra
  -'road2fault_mct' for MCT spectra
  -'road2fault_rmcp' for the unit list with method position

**-r**: the folder that contains the spectra files
**-rt**: type of requirement: mcp, mct, node, branch, or dua 
**-hr**: type of heuristic used to calculate the suspiciousness: ochiai, tarantula, drt, jaccard, zoltar, op, minus, kulczynski2, mccon, wong3
**-c**: path of the original classes of the subject program
**-lt**: type of list: requirement or csv for mcp or mct spectra; requirement, classes, packages or csv for node, branch or dua spectra

The output is an XML suspiciousness list organized by requirement, classes, or packages. The csv options generates the suspiciousness list in the csv format.

2. To generate the new unit list with the method position attribute, run:
```bash
$ROAD2FAULT_HOME/bin/road2fault_rmcp -uf list_dci_NODE_TARANTULA_BY_PACKAGE.xml -rf list_dci_RMCP_TARANTULA.xml
```
**-uf**: previous unit list created by the 'road2fault_unit' program 
**-rf**: roadmap


# CH-ICD results extractor

Road2Fault also extracts the effectiveness results of debugging filtering strategies from the xml report files (.xml-debug extension).
The tool generates the results in csv files and charts. It also generates log files to check if the strategies are working well.

## Current strategies:

### Level Score (LS)
**InspectionStrategyLevelScorePerMethod**: Get level scores based on levels of each method. 
This strategy gets each score from a method, at most 15 score levels.

### Fixed Budget (FB)
**InspectionStrategyDeltaBudget**: it uses the effort budget as a delta. If the budget is 5, 
   this strategy checks in the block list (BL) the score which contains 5 blocks, and this 
   score is used to inspect the blocks inside the methods indicated by the roadmap. 
   If the 1st score (highest) contains more blocks than the budget, such score is returned.

## Folder structure:
To run the extractor, the report files must be placed in the following structure: 
```
/home/user/experiments/{program-name}/{version_fault-name}
```
**- /home/user/experiments**: your local folder that contains the report files of all programs
**- program-name**: one folder for each program named with the program's name in lower case
**- version_fault-name**: one folder containing the .xml-debug files for each fault. 
  The folder must be named with the version number preceded by letter 'v', and 
  followed by '_' and the fault's description.
```
/home/user/experiments/ant/v1_CLJ_HD_1
```
## Report files:
The tool runs results for two ranking heuristics: Ochiai and Tarantula.
Three report files for each heuristic are needed to execute extract the results:
- list_dci_MCP_OCHIAI.xml-debug
- list_dci_NODE_OCHIAI_BY_PACKAGE.xml-debug
- list_dci_NODE_OCHIAI_BY_REQUIREMENT.xml-debug
* In case of Tarantula, the files has the description TARANTULA instead of OCHIAI.
* The report files of both heuristics must be inside the folder.

## Running the CH-ICD extractor from command line

1. There are two versions of the extractor: ch-icd-ls.jar and ch-icd-fb.jar
For both jars you must pass the path to the root folder that contains the report files.
```bash
java -jar ch-icd-ls.jar "/home/user/experiments/"
```

### CH-ICD extractor's output:
- A csv file (ch-icd-output-fb.csv or ch-icd-output-ls.csv) with the number of methods inspected 
by technique (CH, ICD, or BL), effort budget (1 - 100) and different values for LS (1 - 15) and 
FB (5 - 100). The file contains the values per fault and program for Ochiai and Tarantula.
- A log file containing all blocks and methods visited for all strategies per program, fault and heuristic.

The csv files contain 15 levels for LS, from 1 to 15; they also contain 15 budgets for FB 
(5,10,15,20,25,30,35,40,45,50,60,70,80,90,100). The results are the number of blocks/methods 
until reach the faulty one for ICD-LS, CH-LS, ICD-FB, CH-FB, and BL. 
The file contains the values per fault and program for Ochiai and Tarantula.
The csv files also contain the percentage of examined code to reach the faults.
The results are present by fault and summarized values by program and for all programs. 
We considered the worst case scenario to deal with ties, i.e., all blocks with score equal to 
the faulty one are included to determine the position of the faulty one block.

### Other strategies:
- InspectionStrategy: original strategy used in the 1st version of icd. Methods with the same 
name are included at once in th roadmap, no matter their signatures or classes. The score precision is fully.

## Experiment's data



## Citation
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