package br.usp.each.saeg.road2fault.extractor;

import java.io.File;

public class ReportGenerator {
	
	public static void main(String[] args) {
		
		try{
			if(isDirValid(args[0])){
				String dirPath = args[0];
				
				//BatchExecutorFixedBudget batch = new BatchExecutorFixedBudget("/home/higor/data/r2f/reports/");
				BatchExecutorFixedBudget batch = new BatchExecutorFixedBudget(dirPath);
				
				//BatchExecutorLevelScore batch = new BatchExecutorLevelScore("/home/higor/data/r2f/reports/");
				//BatchExecutorLevelScore batch = new BatchExecutorLevelScore(dirPath);
				batch.execute();
				
				/*final ChartGenerator demo = new ChartGenerator("Chart Demo");
		        demo.pack();
		        RefineryUtilities.centerFrameOnScreen(demo);
		        demo.setVisible(true);*/
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
