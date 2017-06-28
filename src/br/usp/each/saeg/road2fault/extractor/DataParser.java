package br.usp.each.saeg.road2fault.extractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import br.usp.each.saeg.road2fault.extractor.ChartGenerator.ChartType;
import br.usp.each.saeg.road2fault.extractor.model.XmlClass;
import br.usp.each.saeg.road2fault.extractor.model.XmlMethod;
import br.usp.each.saeg.road2fault.extractor.model.XmlPackage;
import br.usp.each.saeg.road2fault.extractor.model.XmlTestCriteria;

public class DataParser {
	
	public List<XmlMethod> createCodeHierarchyMethodList(XmlTestCriteria criteria){
		List<XmlMethod> methodList = new ArrayList<XmlMethod>();
		
		for(XmlPackage pack : criteria.getPackages()){
			for(XmlClass clazz : pack.getClasses()){
				for(XmlMethod method : clazz.getMethods()){
					method.updateSignatureMethodName(clazz.getName());
					methodList.add(method);
				}
			}
		}
		
		return methodList;
	}
	
	/*public void createEffectivenessGraph(List<List<String>> matrix, String heuristic, String programName, String title, String xAxisTitle, String yAxisTitle, int beginIndex, int endIndex, String strategy, String requirement){
		
		List<List<String>> firstEffortDataset = new ArrayList<List<String>>();
		List<List<String>> lastEffortDataset = new ArrayList<List<String>>();
		List<String> dataset = new ArrayList<String>();
		ChartGenerator chart = new ChartGenerator();
		String analysisDescription = "effectiveness";
    	boolean getNextLine = false;
		final int icdFirstPart = beginIndex + 6;
		final int icdSecondPart = beginIndex + 14;
		final int blIndex = beginIndex + 15;
		final int mhsFirstPart = beginIndex + 22;
		
		for(List<String> line : matrix){
			if(programName.equals("all")){
				if(line.get(ColumnIndex.PROGRAM).equals("TOTAL") && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					getNextLine = true;
					continue;
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).startsWith("budget 1 - ")){
					for(int i = beginIndex; i <= endIndex; i++){
						dataset.add(line.get(i));
						dataset.add(matrix.get(0).get(i));
						dataset.add(line.get(ColumnIndex.PROGRAM).substring(line.get(ColumnIndex.PROGRAM).indexOf(" ")+1));
						if(i <= icdFirstPart){
							firstEffortDataset.add(dataset);
						}
						if(i > icdFirstPart && i <= icdSecondPart){
							lastEffortDataset.add(dataset);
						}
						if(i == blIndex){
							firstEffortDataset.add(dataset);
							lastEffortDataset.add(dataset);
						}
						if(i > blIndex && i <= mhsFirstPart){
							firstEffortDataset.add(dataset);
						}
						if(i > mhsFirstPart){
							lastEffortDataset.add(dataset);
						}
						dataset = new ArrayList<String>();
					}
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).equals("")){
					break;
				}
			}else{
				if(line.get(ColumnIndex.PROGRAM).equals(programName) && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					getNextLine = true;
					continue;
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).startsWith("budget 1 - ")){
					for(int i = beginIndex; i <= endIndex; i++){
						dataset.add(line.get(i));
						dataset.add(matrix.get(0).get(i));
						dataset.add(line.get(ColumnIndex.PROGRAM).substring(line.get(ColumnIndex.PROGRAM).indexOf(" ")+1));
						if(i <= icdFirstPart){
							firstEffortDataset.add(dataset);
						}
						if(i > icdFirstPart && i <= icdSecondPart){
							lastEffortDataset.add(dataset);
						}
						if(i == blIndex){
							firstEffortDataset.add(dataset);
							lastEffortDataset.add(dataset);
						}
						if(i > blIndex && i <= mhsFirstPart){
							firstEffortDataset.add(dataset);
						}
						if(i > mhsFirstPart){
							lastEffortDataset.add(dataset);
						}
						dataset = new ArrayList<String>();
					}
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).equals("")){
					break;
				}
			}
		}
		chart.loadBarChartDataset(firstEffortDataset, title, xAxisTitle, yAxisTitle, heuristic, programName, strategy+"_icd_0_15", requirement, analysisDescription);
		chart.loadBarChartDataset(lastEffortDataset, title, xAxisTitle, yAxisTitle, heuristic, programName, strategy+"_icd_20_75", requirement, analysisDescription);
	}*/
	
	/*public void createMethodEffectivenessGraph(List<List<String>> matrix, String heuristic, String programName, String title, String xAxisTitle, String yAxisTitle, int beginIndex, int endIndex, String strategy, String requirement){
		
		List<List<String>> firstEffortDataset = new ArrayList<List<String>>();
		List<List<String>> lastEffortDataset = new ArrayList<List<String>>();
		List<String> dataset = new ArrayList<String>();
		ChartGenerator chart = new ChartGenerator();
		boolean getNextLine = false;
		String analysisDescription = "effectiveness";
    	final int icdFirstPart = beginIndex + 6;
		final int icdSecondPart = beginIndex + 14;
		final int mhsFirstPart = beginIndex + 21;
		
		for(List<String> line : matrix){
			if(programName.equals("all")){
				if(line.get(ColumnIndex.PROGRAM).equals("TOTAL") && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					getNextLine = true;
					continue;
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).startsWith("budget 1 - ")){
					String seriesNameValue = line.get(beginIndex-1);//get the method value
					seriesNameValue = seriesNameValue.substring(seriesNameValue.indexOf(" ")+1);
					for(int i = beginIndex; i <= endIndex; i++){
						dataset.add(line.get(i));
						dataset.add(matrix.get(0).get(i));
						dataset.add(seriesNameValue);
						if(i <= icdFirstPart){
							firstEffortDataset.add(dataset);
						}
						if(i > icdFirstPart && i <= icdSecondPart){
							lastEffortDataset.add(dataset);
						}
						if(i > icdSecondPart && i <= mhsFirstPart){
							firstEffortDataset.add(dataset);
						}
						if(i > mhsFirstPart){
							lastEffortDataset.add(dataset);
						}
						dataset = new ArrayList<String>();
					}
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).equals("")){
					break;
				}
			}else{
				if(line.get(ColumnIndex.PROGRAM).equals(programName) && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					getNextLine = true;
					continue;
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).startsWith("budget 1 - ")){
					String seriesNameValue = line.get(beginIndex-1);//get the method value
					seriesNameValue = seriesNameValue.substring(seriesNameValue.indexOf(" ")+1);
					for(int i = beginIndex; i <= endIndex; i++){
						dataset.add(line.get(i));
						dataset.add(matrix.get(0).get(i));
						dataset.add(seriesNameValue);
						if(i <= icdFirstPart){
							firstEffortDataset.add(dataset);
						}
						if(i > icdFirstPart && i <= icdSecondPart){
							lastEffortDataset.add(dataset);
						}
						if(i > icdSecondPart && i <= mhsFirstPart){
							firstEffortDataset.add(dataset);
						}
						if(i > mhsFirstPart){
							lastEffortDataset.add(dataset);
						}
						dataset = new ArrayList<String>();
					}
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).equals("")){
					break;
				}
			}
		}
		chart.loadBarChartDataset(firstEffortDataset, title, xAxisTitle, yAxisTitle, heuristic, programName, strategy+"_icd_0_15", requirement, analysisDescription);
		chart.loadBarChartDataset(lastEffortDataset, title, xAxisTitle, yAxisTitle, heuristic, programName, strategy+"_icd_20_75", requirement, analysisDescription);
	}*/
	
	/*public void createEffectivenessDeltaBudgetGraph(List<List<String>> matrix, String heuristic, String programName, String title, String xAxisTitle, String yAxisTitle, int beginIndex, int endIndex, String strategy, String requirement){
		List<List<String>> effortDataset = new ArrayList<List<String>>();
		List<String> dataset = new ArrayList<String>();
		ChartGenerator chart = new ChartGenerator();
		boolean getNextLine = false;
		String analysisDescription = "effectiveness";
    	
		for(List<String> line : matrix){
			if(programName.equals("all")){
				if(line.get(ColumnIndex.PROGRAM).equals("TOTAL") && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					getNextLine = true;
					continue;
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).startsWith("budget 1 - ")){
					for(int i = beginIndex; i <= endIndex; i++){
						dataset.add(line.get(i));
						dataset.add(matrix.get(0).get(i));
						dataset.add(line.get(ColumnIndex.PROGRAM).substring(line.get(ColumnIndex.PROGRAM).indexOf(" ")+1));
						effortDataset.add(dataset);
						dataset = new ArrayList<String>();
					}
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).equals("")){
					break;
				}
			}else{
				if(line.get(ColumnIndex.PROGRAM).equals(programName) && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					getNextLine = true;
					continue;
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).startsWith("budget 1 - ")){
					for(int i = beginIndex; i <= endIndex; i++){
						dataset.add(line.get(i));
						dataset.add(matrix.get(0).get(i));
						dataset.add(line.get(ColumnIndex.PROGRAM).substring(line.get(ColumnIndex.PROGRAM).indexOf(" ")+1));
						effortDataset.add(dataset);
						dataset = new ArrayList<String>();
					}
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).equals("")){
					break;
				}
			}
		}
		chart.createLayeredData(effortDataset, title, xAxisTitle, yAxisTitle, heuristic, programName, strategy, requirement, analysisDescription);
		
	}*/
	
	
/*public void createEfficiencyGraph(List<List<String>> matrix, String heuristic, String programName, String title, String xAxisTitle, String yAxisTitle, int beginIndex, int endIndex,String strategy, String requirement){
		
		Map<String,List<List<String>>> icdBlList = new HashMap<String,List<List<String>>>();
		Map<String,List<List<String>>> icdMhsList = new HashMap<String,List<List<String>>>();
		Map<String,List<List<String>>> mhsBlList = new HashMap<String,List<List<String>>>();
		Map<String,List<List<String>>> icdBlMhsList = new HashMap<String,List<List<String>>>();
		List<List<String>> icdBlDataset = new ArrayList<List<String>>();
		List<List<String>> icdMhsDataset = new ArrayList<List<String>>();
		List<List<String>> mhsBlDataset = new ArrayList<List<String>>();
		List<List<String>> icdBlMhsDataset = new ArrayList<List<String>>();
		List<String> dataset = new ArrayList<String>();
		ChartGenerator chart = new ChartGenerator();
		boolean getEfficiencyLines = false;
		String analysisDescription = "efficiency";
    	final int icdBlLastIndex = beginIndex + 1;
		final int icdMhsLastIndex = beginIndex + 3;
		final int mhsBlLastIndex = beginIndex + 5;
		final int icdBlMhsLastIndex = beginIndex + 8;
		final int heuristicIndex = ColumnIndex.HEURISTIC - 1;
		final int newProgramIndex = ColumnIndex.PROGRAM + 1;
		String budgetName="";
		int actualHeader = 0;
		int countHeader = 0;
		
		for(List<String> line : matrix){
			if(programName.equals("all")){
				if(line.get(ColumnIndex.PROGRAM).equals("Efficiency") && line.get(newProgramIndex).equals("TOTAL") && line.get(heuristicIndex).equals(heuristic)){
					getEfficiencyLines = true;
					countHeader++;
					continue;
				}
				if(getEfficiencyLines && line.get(ColumnIndex.PROGRAM).startsWith("Delta")){
					if(!budgetName.equals("")){
						icdBlList.put(budgetName, icdBlDataset);
						icdMhsList.put(budgetName, icdMhsDataset);
						mhsBlList.put(budgetName, mhsBlDataset);
						icdBlMhsList.put(budgetName, icdBlMhsDataset);
						icdBlDataset = new ArrayList<List<String>>();
						icdMhsDataset = new ArrayList<List<String>>();
						mhsBlDataset = new ArrayList<List<String>>();
						icdBlMhsDataset = new ArrayList<List<String>>();
					}
					budgetName = line.get(ColumnIndex.PROGRAM).substring(line.get(ColumnIndex.PROGRAM).indexOf("b"));
					actualHeader = countHeader;
					countHeader++;
					continue;
				}
				if(getEfficiencyLines && StringUtils.isNumeric(line.get(newProgramIndex))){
					for(int i = beginIndex; i <= endIndex; i++){
						dataset.add(line.get(i));
						dataset.add(matrix.get(actualHeader).get(i));
						dataset.add(line.get(ColumnIndex.PROGRAM).substring(0, line.get(ColumnIndex.PROGRAM).indexOf(".")));
						if(i <= icdBlLastIndex){
							icdBlDataset.add(dataset);
						}
						if(i > icdBlLastIndex && i <= icdMhsLastIndex){
							icdMhsDataset.add(dataset);
						}
						if(i > icdMhsLastIndex && i <= mhsBlLastIndex){
							mhsBlDataset.add(dataset);
						}
						if(i > mhsBlLastIndex){
							icdBlMhsDataset.add(dataset);
						}
						dataset = new ArrayList<String>();
					}
				}
				if(getEfficiencyLines && line.get(ColumnIndex.PROGRAM).equals("")){
					if(budgetName.endsWith("100")){
						icdBlList.put(budgetName, icdBlDataset);
						icdMhsList.put(budgetName, icdMhsDataset);
						mhsBlList.put(budgetName, mhsBlDataset);
						icdBlMhsList.put(budgetName, icdBlMhsDataset);
						icdBlDataset = new ArrayList<List<String>>();
						icdMhsDataset = new ArrayList<List<String>>();
						mhsBlDataset = new ArrayList<List<String>>();
						icdBlMhsDataset = new ArrayList<List<String>>();
					}
					budgetName = "";
					break;
				}
			}else{
				if(line.get(ColumnIndex.PROGRAM).equals("Efficiency") && line.get(newProgramIndex).equals(programName) && line.get(heuristicIndex).equals(heuristic)){
					getEfficiencyLines = true;
					countHeader++;
					continue;
				}
				if(getEfficiencyLines && line.get(ColumnIndex.PROGRAM).startsWith("Delta")){
					if(!budgetName.equals("")){
						icdBlList.put(budgetName, icdBlDataset);
						icdMhsList.put(budgetName, icdMhsDataset);
						mhsBlList.put(budgetName, mhsBlDataset);
						icdBlMhsList.put(budgetName, icdBlMhsDataset);
						icdBlDataset = new ArrayList<List<String>>();
						icdMhsDataset = new ArrayList<List<String>>();
						mhsBlDataset = new ArrayList<List<String>>();
						icdBlMhsDataset = new ArrayList<List<String>>();
					}
					budgetName = line.get(ColumnIndex.PROGRAM).substring(line.get(ColumnIndex.PROGRAM).indexOf("b"));
					actualHeader = countHeader;
					countHeader++;
					continue;
				}
				if(getEfficiencyLines && StringUtils.isNumeric(line.get(ColumnIndex.PROGRAM))){
					for(int i = beginIndex; i <= endIndex; i++){
						dataset.add(line.get(i));
						dataset.add(matrix.get(actualHeader).get(i));
						dataset.add(line.get(ColumnIndex.PROGRAM).substring(0, line.get(ColumnIndex.PROGRAM).indexOf(".")));
						if(i <= icdBlLastIndex){
							icdBlDataset.add(dataset);
						}
						if(i > icdBlLastIndex && i <= icdMhsLastIndex){
							icdMhsDataset.add(dataset);
						}
						if(i > icdMhsLastIndex && i <= mhsBlLastIndex){
							mhsBlDataset.add(dataset);
						}
						if(i > mhsBlLastIndex){
							icdBlMhsDataset.add(dataset);
						}
						dataset = new ArrayList<String>();
					}
				}
				if(getEfficiencyLines && line.get(ColumnIndex.PROGRAM).equals("")){
					if(budgetName.endsWith("100")){
						icdBlList.put(budgetName, icdBlDataset);
						icdMhsList.put(budgetName, icdMhsDataset);
						mhsBlList.put(budgetName, mhsBlDataset);
						icdBlMhsList.put(budgetName, icdBlMhsDataset);
						icdBlDataset = new ArrayList<List<String>>();
						icdMhsDataset = new ArrayList<List<String>>();
						mhsBlDataset = new ArrayList<List<String>>();
						icdBlMhsDataset = new ArrayList<List<String>>();
					}
					budgetName = "";
					break;
				}
			}
			countHeader++;
		}
		
		Set<String> icdBlSet = icdBlList.keySet();
		Set<String> icdMhsSet = icdMhsList.keySet();
		Set<String> mhsBlSet = mhsBlList.keySet();
		Set<String> icdBlMhsSet = icdBlMhsList.keySet();
		
		for(String icdBlCategory : icdBlSet){
			List<List<String>> datasetList = icdBlList.get(icdBlCategory);
			chart.loadBarChartDataset(datasetList, title, xAxisTitle, yAxisTitle, heuristic, programName, strategy+"_icd_x_bl_"+icdBlCategory.replace(" ", ""), requirement, analysisDescription);
		}
		for(String icdMhsCategory : icdMhsSet){
			List<List<String>> datasetList = icdMhsList.get(icdMhsCategory);
			chart.loadBarChartDataset(datasetList, title, xAxisTitle, yAxisTitle, heuristic, programName, strategy+"_icd_x_mhs_"+icdMhsCategory.replace(" ", ""), requirement, analysisDescription);
		}
		for(String mhsBlCategory : mhsBlSet){
			List<List<String>> datasetList = mhsBlList.get(mhsBlCategory);
			chart.loadBarChartDataset(datasetList, title, xAxisTitle, yAxisTitle, heuristic, programName, strategy+"_mhs_x_bl_"+mhsBlCategory.replace(" ", ""), requirement, analysisDescription);
		}
		for(String icdBlMhsCategory : icdBlMhsSet){
			List<List<String>> datasetList = icdBlMhsList.get(icdBlMhsCategory);
			chart.loadBarChartDataset(datasetList, title, xAxisTitle, yAxisTitle, heuristic, programName, strategy+"_icd_x_bl_mhs_"+icdBlMhsCategory.replace(" ", ""), requirement, analysisDescription);
		}
		
	}*/

	public void createEffectivenessPercentualGraph(List<List<String>> matrix, String heuristic, String programName, String title, String xAxisTitle, String yAxisTitle, int beginIndex, int endIndex, String strategy, String requirement){
		
		Map<String,List<String>> firstEffortMapDataset = new HashMap<String, List<String>>();
		Map<String,List<String>> secondEffortMapDataset = new HashMap<String, List<String>>();
		ChartGenerator chart = new ChartGenerator();
		boolean getNextLine = false;
		String analysisDescription = "%_effectiveness";
    	final int icdFirstPart = beginIndex + 6;
		final int icdSecondPart = beginIndex + 14;
		final int blIndex = beginIndex + 15;
		final int mhsFirstPart = beginIndex + 22;
		int faultNumber = getNumberOfFaults(matrix, programName, heuristic);
		
		//creating map keys
		for(int i = beginIndex; i <= endIndex; i++){
			if(i <= icdFirstPart){
				if(!firstEffortMapDataset.containsKey(matrix.get(0).get(i))){
					firstEffortMapDataset.put(matrix.get(0).get(i).replace("%", ""), new ArrayList<String>());
				}
			}
			if(i > icdFirstPart && i <= icdSecondPart){
				if(!secondEffortMapDataset.containsKey(matrix.get(0).get(i))){
					secondEffortMapDataset.put(matrix.get(0).get(i).replace("%", ""), new ArrayList<String>());
				}
			}
			if(i == blIndex){
				if(!firstEffortMapDataset.containsKey(matrix.get(0).get(i))){
					firstEffortMapDataset.put(matrix.get(0).get(i).replace("%", ""), new ArrayList<String>());
				}
				if(!secondEffortMapDataset.containsKey(matrix.get(0).get(i))){
					secondEffortMapDataset.put(matrix.get(0).get(i).replace("%", ""), new ArrayList<String>());
				}
			}
			if(i > blIndex && i <= mhsFirstPart){
				if(!firstEffortMapDataset.containsKey(matrix.get(0).get(i))){
					firstEffortMapDataset.put(matrix.get(0).get(i).replace("%", ""), new ArrayList<String>());
				}
			}
			if(i > mhsFirstPart){
				if(!secondEffortMapDataset.containsKey(matrix.get(0).get(i))){
					secondEffortMapDataset.put(matrix.get(0).get(i).replace("%", ""), new ArrayList<String>());
				}
			}
		}
				
		for(List<String> line : matrix){
			if(programName.equals("all")){
				if(line.get(ColumnIndex.PROGRAM).equals("TOTAL") && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					getNextLine = true;
					continue;
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).startsWith("budget 1 - ")){
					for(int i = beginIndex; i <= endIndex; i++){
						String seriesNameValue = line.get(beginIndex-1);//get the percentual value
						seriesNameValue = seriesNameValue.substring(seriesNameValue.indexOf("-")+1, seriesNameValue.indexOf("%"));
						if(firstEffortMapDataset.containsKey(matrix.get(0).get(i).replace("%", ""))){
							firstEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(seriesNameValue);
							firstEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(String.valueOf((Double.parseDouble(line.get(i))/faultNumber)*100));
						}
						if(secondEffortMapDataset.containsKey(matrix.get(0).get(i).replace("%", ""))){
							secondEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(seriesNameValue);
							secondEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(String.valueOf((Double.parseDouble(line.get(i))/faultNumber)*100));
						}
					}
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).equals("")){
					break;
				}
			}else{
				if(line.get(ColumnIndex.PROGRAM).equals(programName) && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					getNextLine = true;
					continue;
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).startsWith("budget 1 - ")){
					for(int i = beginIndex; i <= endIndex; i++){
						String seriesNameValue = line.get(beginIndex-1);//get the percentual value
						seriesNameValue = seriesNameValue.substring(seriesNameValue.indexOf("-")+1, seriesNameValue.indexOf("%"));
						if(firstEffortMapDataset.containsKey(matrix.get(0).get(i).replace("%", ""))){
							firstEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(seriesNameValue);
							firstEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(String.valueOf((Double.parseDouble(line.get(i))/faultNumber)*100));
						}
						if(secondEffortMapDataset.containsKey(matrix.get(0).get(i).replace("%", ""))){
							secondEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(seriesNameValue);
							secondEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(String.valueOf((Double.parseDouble(line.get(i))/faultNumber)*100));
						}
					}
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).equals("")){
					break;
				}
			}
		}
		//chart.loadLineChartDataset(firstEffortMapDataset, title, xAxisTitle, yAxisTitle, heuristic, programName, strategy+"_icd_0_15", requirement, analysisDescription);
		//chart.loadLineChartDataset(secondEffortMapDataset, title, xAxisTitle, yAxisTitle, heuristic, programName, strategy+"_icd_20_75", requirement, analysisDescription);
	}
	
	
	public void createEffectivenessMethodPercentualGraph(List<List<String>> matrix, String heuristic, String programName, String title, String xAxisTitle, String yAxisTitle, int beginIndex, int endIndex, String strategy, String requirement){
		
		Map<String,List<String>> firstEffortMapDataset = new HashMap<String, List<String>>();
		Map<String,List<String>> secondEffortMapDataset = new HashMap<String, List<String>>();
		ChartGenerator chart = new ChartGenerator();
		boolean getNextLine = false;
		String analysisDescription = "%_effectiveness";
    	final int icdFirstPart = beginIndex + 6;
		final int icdSecondPart = beginIndex + 14;
		final int mhsFirstPart = beginIndex + 21;
		int faultNumber = getNumberOfFaults(matrix, programName, heuristic);
		
		//creating map keys
		for(int i = beginIndex; i <= endIndex; i++){
			if(i <= icdFirstPart){
				if(!firstEffortMapDataset.containsKey(matrix.get(0).get(i))){
					firstEffortMapDataset.put(matrix.get(0).get(i).replace("%", ""), new ArrayList<String>());
				}
			}
			if(i > icdFirstPart && i <= icdSecondPart){
				if(!secondEffortMapDataset.containsKey(matrix.get(0).get(i))){
					secondEffortMapDataset.put(matrix.get(0).get(i).replace("%", ""), new ArrayList<String>());
				}
			}
			if(i > icdSecondPart && i <= mhsFirstPart){
				if(!firstEffortMapDataset.containsKey(matrix.get(0).get(i))){
					firstEffortMapDataset.put(matrix.get(0).get(i).replace("%", ""), new ArrayList<String>());
				}
			}
			if(i > mhsFirstPart){
				if(!secondEffortMapDataset.containsKey(matrix.get(0).get(i))){
					secondEffortMapDataset.put(matrix.get(0).get(i).replace("%", ""), new ArrayList<String>());
				}
			}
		}
				
		for(List<String> line : matrix){
			if(programName.equals("all")){
				if(line.get(ColumnIndex.PROGRAM).equals("TOTAL") && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					getNextLine = true;
					continue;
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).startsWith("budget 1 - ")){
					for(int i = beginIndex; i <= endIndex; i++){
						String seriesNameValue = line.get(beginIndex-1);//get the percentual value
						seriesNameValue = seriesNameValue.substring(seriesNameValue.indexOf("-")+1, seriesNameValue.indexOf("%"));
						if(firstEffortMapDataset.containsKey(matrix.get(0).get(i).replace("%", ""))){
							firstEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(seriesNameValue);
							firstEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(String.valueOf((Double.parseDouble(line.get(i))/faultNumber)*100));
						}
						if(secondEffortMapDataset.containsKey(matrix.get(0).get(i).replace("%", ""))){
							secondEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(seriesNameValue);
							secondEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(String.valueOf((Double.parseDouble(line.get(i))/faultNumber)*100));
						}
					}
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).equals("")){
					break;
				}
			}else{
				if(line.get(ColumnIndex.PROGRAM).equals(programName) && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					getNextLine = true;
					continue;
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).startsWith("budget 1 - ")){
					for(int i = beginIndex; i <= endIndex; i++){
						String seriesNameValue = line.get(beginIndex-1);//get the percentual value
						seriesNameValue = seriesNameValue.substring(seriesNameValue.indexOf("-")+1, seriesNameValue.indexOf("%"));
						if(firstEffortMapDataset.containsKey(matrix.get(0).get(i).replace("%", ""))){
							firstEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(seriesNameValue);
							firstEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(String.valueOf((Double.parseDouble(line.get(i))/faultNumber)*100));
						}
						if(secondEffortMapDataset.containsKey(matrix.get(0).get(i).replace("%", ""))){
							secondEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(seriesNameValue);
							secondEffortMapDataset.get(matrix.get(0).get(i).replace("%", "")).add(String.valueOf((Double.parseDouble(line.get(i))/faultNumber)*100));
						}
					}
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).equals("")){
					break;
				}
			}
		}
		//chart.loadLineChartDataset(firstEffortMapDataset, title, xAxisTitle, yAxisTitle, heuristic, programName, strategy+"_icd_0_15", requirement, analysisDescription);
		//chart.loadLineChartDataset(secondEffortMapDataset, title, xAxisTitle, yAxisTitle, heuristic, programName, strategy+"_icd_20_75", requirement, analysisDescription);
	}
	
	
	private int getNumberOfFaults(List<List<String>> matrix, String programName, String heuristic){
		int countFaults = 0;
		int faultIndex = ColumnIndex.HEURISTIC - 1;
		for(List<String> line : matrix){
			if(programName.equals("all")){
				if(!line.get(faultIndex).equals("") && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					countFaults++;
				}
			}else{
				if(!line.get(faultIndex).equals("") && line.get(ColumnIndex.HEURISTIC).equals(heuristic) && line.get(ColumnIndex.PROGRAM).equals(programName)){
					countFaults++;
				}
			}
		}
		return countFaults;
	}
	
	public List<List<String>> createEffectiveBarChartDataset(List<List<String>> matrix, String heuristic, String programName, List<Integer> columns, List<String> budgets){
		List<List<String>> effortDataset = new ArrayList<List<String>>();
		List<String> dataset = new ArrayList<String>();
		boolean getNextLine = false;
		
    	for(List<String> line : matrix){
			if(programName.equals("all")){
				if(line.get(ColumnIndex.PROGRAM).equals("TOTAL") && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					getNextLine = true;
					continue;
				}
				if(getNextLine && budgets.contains(line.get(ColumnIndex.PROGRAM))){
					for(Integer col : columns){
						dataset.add(line.get(col));
						dataset.add(matrix.get(0).get(col));
						dataset.add(line.get(ColumnIndex.PROGRAM).substring(line.get(ColumnIndex.PROGRAM).indexOf(" ")+1));
						effortDataset.add(dataset);
						dataset = new ArrayList<String>();
					}
				}
				if(getNextLine && budgets.contains(line.get(ColumnIndex.HEADER_MET))){
					for(Integer col : columns){
						dataset.add(line.get(col));
						dataset.add(matrix.get(0).get(col));
						dataset.add(line.get(ColumnIndex.HEADER_MET).substring(line.get(ColumnIndex.HEADER_MET).indexOf(" ")+1));
						effortDataset.add(dataset);
						dataset = new ArrayList<String>();
					}
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).equals("")){
					break;
				}
			}else{
				if(line.get(ColumnIndex.PROGRAM).equals(programName) && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					getNextLine = true;
					continue;
				}
				if(getNextLine && budgets.contains(line.get(ColumnIndex.PROGRAM))){
					for(Integer col : columns){
						dataset.add(line.get(col));
						dataset.add(matrix.get(0).get(col));
						dataset.add(line.get(ColumnIndex.PROGRAM).substring(line.get(ColumnIndex.PROGRAM).indexOf(" ")+1));
						effortDataset.add(dataset);
						dataset = new ArrayList<String>();
					}
				}
				if(getNextLine && budgets.contains(line.get(ColumnIndex.HEADER_MET))){
					for(Integer col : columns){
						dataset.add(line.get(col));
						dataset.add(matrix.get(0).get(col));
						dataset.add(line.get(ColumnIndex.HEADER_MET).substring(line.get(ColumnIndex.HEADER_MET).indexOf(" ")+1));
						effortDataset.add(dataset);
						dataset = new ArrayList<String>();
					}
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).equals("")){
					break;
				}
			}
		}
		return effortDataset;
	}
	
	public Map<String,List<String>> createLineChartDataset(List<List<String>> matrix, String heuristic, String programName, List<Integer> columns, List<String> budgets){
		Map<String,List<String>> effortMapDataset = new HashMap<String, List<String>>();
		boolean getNextLine = false;
		int faultNumber = getNumberOfFaults(matrix, programName, heuristic);
		
		//creating map keys
    	for(Integer index : columns){
    		if(!effortMapDataset.containsKey(matrix.get(0).get(index))){
    			effortMapDataset.put(matrix.get(0).get(index).replace("%", ""), new ArrayList<String>());
    		}
    	}
						
		for(List<String> line : matrix){
			if(programName.equals("all")){
				if(line.get(ColumnIndex.PROGRAM).equals("TOTAL") && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					getNextLine = true;
					continue;
				}
				if(getNextLine && budgets.contains(line.get(ColumnIndex.HEADER_PERC))){
					for(Integer index : columns){
						String seriesNameValue = line.get(ColumnIndex.HEADER_PERC);//get the percentual value header
						seriesNameValue = seriesNameValue.substring(seriesNameValue.indexOf("-")+1, seriesNameValue.indexOf("%"));
						if(effortMapDataset.containsKey(matrix.get(0).get(index).replace("%", ""))){
							effortMapDataset.get(matrix.get(0).get(index).replace("%", "")).add(seriesNameValue);
							effortMapDataset.get(matrix.get(0).get(index).replace("%", "")).add(String.valueOf((Double.parseDouble(line.get(index))/faultNumber)*100));
						}
					}
				}
				if(getNextLine && budgets.contains(line.get(ColumnIndex.HEADER_MET_PERC))){
					for(Integer index : columns){
						String seriesNameValue = line.get(ColumnIndex.HEADER_MET_PERC);//get the percentual value header
						seriesNameValue = seriesNameValue.substring(seriesNameValue.indexOf("-")+1, seriesNameValue.indexOf("%"));
						if(effortMapDataset.containsKey(matrix.get(0).get(index).replace("%", ""))){
							effortMapDataset.get(matrix.get(0).get(index).replace("%", "")).add(seriesNameValue);
							effortMapDataset.get(matrix.get(0).get(index).replace("%", "")).add(String.valueOf((Double.parseDouble(line.get(index))/faultNumber)*100));
						}
					}
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).equals("")){
					break;
				}
			}else{
				if(line.get(ColumnIndex.PROGRAM).equals(programName) && line.get(ColumnIndex.HEURISTIC).equals(heuristic)){
					getNextLine = true;
					continue;
				}
				if(getNextLine && budgets.contains(line.get(ColumnIndex.HEADER_PERC))){
					for(Integer index : columns){
						String seriesNameValue = line.get(ColumnIndex.HEADER_PERC);//get the percentual value header
						seriesNameValue = seriesNameValue.substring(seriesNameValue.indexOf("-")+1, seriesNameValue.indexOf("%"));
						if(effortMapDataset.containsKey(matrix.get(0).get(index).replace("%", ""))){
							effortMapDataset.get(matrix.get(0).get(index).replace("%", "")).add(seriesNameValue);
							effortMapDataset.get(matrix.get(0).get(index).replace("%", "")).add(String.valueOf((Double.parseDouble(line.get(index))/faultNumber)*100));
						}
					}
				}
				if(getNextLine && budgets.contains(line.get(ColumnIndex.HEADER_MET_PERC))){
					for(Integer index : columns){
						String seriesNameValue = line.get(ColumnIndex.HEADER_MET_PERC);//get the percentual value header
						seriesNameValue = seriesNameValue.substring(seriesNameValue.indexOf("-")+1, seriesNameValue.indexOf("%"));
						if(effortMapDataset.containsKey(matrix.get(0).get(index).replace("%", ""))){
							effortMapDataset.get(matrix.get(0).get(index).replace("%", "")).add(seriesNameValue);
							effortMapDataset.get(matrix.get(0).get(index).replace("%", "")).add(String.valueOf((Double.parseDouble(line.get(index))/faultNumber)*100));
						}
					}
				}
				if(getNextLine && line.get(ColumnIndex.PROGRAM).equals("")){
					break;
				}
			}
		}
		return effortMapDataset;
	}
	
	public Map<String,List<List<String>>> createEfficiencyBarChartDataset(List<List<String>> matrix, String heuristic, String programName, List<Integer> columns, List<Integer> budgets){
		Map<String,List<List<String>>> effortDatasetMap = new HashMap<String,List<List<String>>>();
		List<List<String>> effortDataset = new ArrayList<List<String>>();
		List<String> dataset = new ArrayList<String>();
		boolean getEfficiencyLines = false;
		int newProgramIndex = ColumnIndex.PROGRAM + 1;
		int heuristicIndex = ColumnIndex.HEURISTIC - 1;
		String budgetName="";
		int countHeader = 0;
		int currentHeader = 0;
		
    	for(List<String> line : matrix){
			if(programName.equals("all")){
				if(line.get(ColumnIndex.PROGRAM).equals("Efficiency") && line.get(newProgramIndex).equals("TOTAL") && line.get(heuristicIndex).equals(heuristic)){
					getEfficiencyLines = true;
					countHeader++;
					continue;
				}
				if(getEfficiencyLines && line.get(ColumnIndex.PROGRAM).startsWith("Delta")){
					if(!budgetName.equals("")){
						effortDatasetMap.put(budgetName, effortDataset);
						effortDataset = new ArrayList<List<String>>();
					}
					budgetName = line.get(ColumnIndex.PROGRAM).substring(line.get(ColumnIndex.PROGRAM).indexOf("b"));
					currentHeader = countHeader;
					countHeader++;
					continue;
				}
				if(getEfficiencyLines && StringUtils.isNumeric(line.get(newProgramIndex))){
					if(budgets.contains(Integer.parseInt(line.get(ColumnIndex.PROGRAM).substring(0,line.get(ColumnIndex.PROGRAM).indexOf("."))))){
						for(Integer index : columns){
							dataset.add(line.get(index));
							dataset.add(matrix.get(currentHeader).get(index));
							dataset.add(line.get(ColumnIndex.PROGRAM).substring(0, line.get(ColumnIndex.PROGRAM).indexOf(".")));
							effortDataset.add(dataset);
							dataset = new ArrayList<String>();
						}
					}
				}
				if(getEfficiencyLines && line.get(ColumnIndex.PROGRAM).equals("")){
					if(budgetName.endsWith("100")){
						effortDatasetMap.put(budgetName, effortDataset);
						effortDataset = new ArrayList<List<String>>();
					}
					budgetName = "";
					break;
				}
			}else{
				if(line.get(ColumnIndex.PROGRAM).equals("Efficiency") && line.get(newProgramIndex).equals(programName) && line.get(heuristicIndex).equals(heuristic)){
					getEfficiencyLines = true;
					countHeader++;
					continue;
				}
				if(getEfficiencyLines && line.get(ColumnIndex.PROGRAM).startsWith("Delta")){
					if(!budgetName.equals("")){
						effortDatasetMap.put(budgetName, effortDataset);
						effortDataset = new ArrayList<List<String>>();
					}
					budgetName = line.get(ColumnIndex.PROGRAM).substring(line.get(ColumnIndex.PROGRAM).indexOf("b"));
					currentHeader = countHeader;
					countHeader++;
					continue;
				}
				if(getEfficiencyLines && StringUtils.isNumeric(line.get(newProgramIndex))){
					if(budgets.contains(Integer.parseInt(line.get(ColumnIndex.PROGRAM).substring(0,line.get(ColumnIndex.PROGRAM).indexOf("."))))){
						for(Integer index : columns){
							dataset.add(line.get(index));
							dataset.add(matrix.get(currentHeader).get(index));
							dataset.add(line.get(ColumnIndex.PROGRAM).substring(0, line.get(ColumnIndex.PROGRAM).indexOf(".")));
							effortDataset.add(dataset);
							dataset = new ArrayList<String>();
						}
					}
				}
				if(getEfficiencyLines && line.get(ColumnIndex.PROGRAM).equals("")){
					if(budgetName.endsWith("100")){
						effortDatasetMap.put(budgetName, effortDataset);
						effortDataset = new ArrayList<List<String>>();
					}
					budgetName = "";
					break;
				}
			}
			countHeader++;
		}
		return effortDatasetMap;
	}

}
