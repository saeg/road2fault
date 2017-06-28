package br.usp.each.saeg.road2fault.extractor;

import java.util.ArrayList;
import java.util.List;

public class RangeIndexCHICD {
	
	//EFFECTIVENESS - DELTA BUDGET
	public static List<Integer> delta_budget_icd_bl_ch(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.DB_SUM_ICD);
		columns.add(ColumnIndexCHICD.DB_SUM_BL);
		columns.add(ColumnIndexCHICD.DB_SUM_CH);
		return columns;
	}
	
	//BUDGET ROWS
	public static List<String> budget_5(){
		List<String> rows = new ArrayList<String>();
		rows.add("budget 1 - 5");
		return rows;
	}
	
	public static List<String> budget_5_10(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(budget_5());
		rows.add("budget 1 - 10");
		return rows;
	}
	
	public static List<String> budget_5_15(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(budget_5_10());
		rows.add("budget 1 - 15");
		return rows;
	}
	
	public static List<String> budget_5_20(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(budget_5_15());
		rows.add("budget 1 - 20");
		return rows;
	}
	
	public static List<String> budget_5_25(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(budget_5_20());
		rows.add("budget 1 - 25");
		return rows;
	}
	
	public static List<String> budget_5_30(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(budget_5_25());
		rows.add("budget 1 - 30");
		return rows;
	}
	
	public static List<String> budget_5_35(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(budget_5_30());
		rows.add("budget 1 - 35");
		return rows;
	}
	
	public static List<String> budget_5_40(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(budget_5_35());
		rows.add("budget 1 - 40");
		return rows;
	}
	
	public static List<String> budget_5_45(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(budget_5_40());
		rows.add("budget 1 - 45");
		return rows;
	}
	
	public static List<String> budget_5_50(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(budget_5_45());
		rows.add("budget 1 - 50");
		return rows;
	}
	
	public static List<String> budget_5_60(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(budget_5_50());
		rows.add("budget 1 - 60");
		return rows;
	}
	
	public static List<String> budget_5_70(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(budget_5_60());
		rows.add("budget 1 - 70");
		return rows;
	}
	
	public static List<String> budget_5_80(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(budget_5_70());
		rows.add("budget 1 - 80");
		return rows;
	}
	
	public static List<String> budget_5_90(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(budget_5_80());
		rows.add("budget 1 - 90");
		return rows;
	}
	
	public static List<String> budget_5_100(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(budget_5_90());
		rows.add("budget 1 - 100");
		return rows;
	}
	
	
	//EFFECTIVENESS - BLOCKS
	public static List<Integer> icd_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.ICD_1);
		return columns;
	}
	
	public static List<Integer> icd_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.ICD_1);
		columns.add(ColumnIndexCHICD.ICD_3);
		return columns;
	}
	
	public static List<Integer> icd_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.ICD_1);
		columns.add(ColumnIndexCHICD.ICD_3);
		columns.add(ColumnIndexCHICD.ICD_5);
		return columns;
	}
	
	public static List<Integer> icd_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.ICD_1);
		columns.add(ColumnIndexCHICD.ICD_3);
		columns.add(ColumnIndexCHICD.ICD_5);
		columns.add(ColumnIndexCHICD.ICD_7);
		return columns;
	}
	
	public static List<Integer> icd_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.ICD_1);
		columns.add(ColumnIndexCHICD.ICD_3);
		columns.add(ColumnIndexCHICD.ICD_5);
		columns.add(ColumnIndexCHICD.ICD_7);
		columns.add(ColumnIndexCHICD.ICD_10);
		return columns;
	}
	
	public static List<Integer> icd_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.ICD_1);
		columns.add(ColumnIndexCHICD.ICD_3);
		columns.add(ColumnIndexCHICD.ICD_5);
		columns.add(ColumnIndexCHICD.ICD_7);
		columns.add(ColumnIndexCHICD.ICD_10);
		columns.add(ColumnIndexCHICD.ICD_15);
		return columns;
	}
	
	public static List<Integer> icd_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.ICD_1);
		columns.add(ColumnIndexCHICD.ICD_3);
		columns.add(ColumnIndexCHICD.ICD_5);
		columns.add(ColumnIndexCHICD.ICD_7);
		columns.add(ColumnIndexCHICD.ICD_10);
		columns.add(ColumnIndexCHICD.ICD_15);
		columns.add(ColumnIndexCHICD.ICD_20);
		return columns;
	}
	
	public static List<Integer> icd_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.ICD_1);
		columns.add(ColumnIndexCHICD.ICD_3);
		columns.add(ColumnIndexCHICD.ICD_5);
		columns.add(ColumnIndexCHICD.ICD_7);
		columns.add(ColumnIndexCHICD.ICD_10);
		columns.add(ColumnIndexCHICD.ICD_15);
		columns.add(ColumnIndexCHICD.ICD_20);
		columns.add(ColumnIndexCHICD.ICD_25);
		return columns;
	}
	
	public static List<Integer> icd_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.ICD_1);
		columns.add(ColumnIndexCHICD.ICD_3);
		columns.add(ColumnIndexCHICD.ICD_5);
		columns.add(ColumnIndexCHICD.ICD_7);
		columns.add(ColumnIndexCHICD.ICD_10);
		columns.add(ColumnIndexCHICD.ICD_15);
		columns.add(ColumnIndexCHICD.ICD_20);
		columns.add(ColumnIndexCHICD.ICD_25);
		columns.add(ColumnIndexCHICD.ICD_30);
		return columns;
	}
	
	public static List<Integer> icd_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.ICD_1);
		columns.add(ColumnIndexCHICD.ICD_3);
		columns.add(ColumnIndexCHICD.ICD_5);
		columns.add(ColumnIndexCHICD.ICD_7);
		columns.add(ColumnIndexCHICD.ICD_10);
		columns.add(ColumnIndexCHICD.ICD_15);
		columns.add(ColumnIndexCHICD.ICD_20);
		columns.add(ColumnIndexCHICD.ICD_25);
		columns.add(ColumnIndexCHICD.ICD_30);
		columns.add(ColumnIndexCHICD.ICD_35);
		return columns;
	}
	
	public static List<Integer> icd_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.ICD_1);
		columns.add(ColumnIndexCHICD.ICD_3);
		columns.add(ColumnIndexCHICD.ICD_5);
		columns.add(ColumnIndexCHICD.ICD_7);
		columns.add(ColumnIndexCHICD.ICD_10);
		columns.add(ColumnIndexCHICD.ICD_15);
		columns.add(ColumnIndexCHICD.ICD_20);
		columns.add(ColumnIndexCHICD.ICD_25);
		columns.add(ColumnIndexCHICD.ICD_30);
		columns.add(ColumnIndexCHICD.ICD_35);
		columns.add(ColumnIndexCHICD.ICD_40);
		return columns;
	}
	
	public static List<Integer> icd_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.ICD_1);
		columns.add(ColumnIndexCHICD.ICD_3);
		columns.add(ColumnIndexCHICD.ICD_5);
		columns.add(ColumnIndexCHICD.ICD_7);
		columns.add(ColumnIndexCHICD.ICD_10);
		columns.add(ColumnIndexCHICD.ICD_15);
		columns.add(ColumnIndexCHICD.ICD_20);
		columns.add(ColumnIndexCHICD.ICD_25);
		columns.add(ColumnIndexCHICD.ICD_30);
		columns.add(ColumnIndexCHICD.ICD_35);
		columns.add(ColumnIndexCHICD.ICD_40);
		columns.add(ColumnIndexCHICD.ICD_45);
		return columns;
	}
	
	public static List<Integer> icd_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.ICD_1);
		columns.add(ColumnIndexCHICD.ICD_3);
		columns.add(ColumnIndexCHICD.ICD_5);
		columns.add(ColumnIndexCHICD.ICD_7);
		columns.add(ColumnIndexCHICD.ICD_10);
		columns.add(ColumnIndexCHICD.ICD_15);
		columns.add(ColumnIndexCHICD.ICD_20);
		columns.add(ColumnIndexCHICD.ICD_25);
		columns.add(ColumnIndexCHICD.ICD_30);
		columns.add(ColumnIndexCHICD.ICD_35);
		columns.add(ColumnIndexCHICD.ICD_40);
		columns.add(ColumnIndexCHICD.ICD_45);
		columns.add(ColumnIndexCHICD.ICD_50);
		return columns;
	}
	
	public static List<Integer> icd_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.ICD_1);
		columns.add(ColumnIndexCHICD.ICD_3);
		columns.add(ColumnIndexCHICD.ICD_5);
		columns.add(ColumnIndexCHICD.ICD_7);
		columns.add(ColumnIndexCHICD.ICD_10);
		columns.add(ColumnIndexCHICD.ICD_15);
		columns.add(ColumnIndexCHICD.ICD_20);
		columns.add(ColumnIndexCHICD.ICD_25);
		columns.add(ColumnIndexCHICD.ICD_30);
		columns.add(ColumnIndexCHICD.ICD_35);
		columns.add(ColumnIndexCHICD.ICD_40);
		columns.add(ColumnIndexCHICD.ICD_45);
		columns.add(ColumnIndexCHICD.ICD_50);
		columns.add(ColumnIndexCHICD.ICD_75);
		return columns;
	}
	
	public static List<Integer> ch_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_0);
		columns.add(ColumnIndexCHICD.CH_1);
		return columns;
	}
	
	public static List<Integer> ch_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_0);
		columns.add(ColumnIndexCHICD.CH_1);
		columns.add(ColumnIndexCHICD.CH_3);
		return columns;
	}
	
	public static List<Integer> ch_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_0);
		columns.add(ColumnIndexCHICD.CH_1);
		columns.add(ColumnIndexCHICD.CH_3);
		columns.add(ColumnIndexCHICD.CH_5);
		return columns;
	}
	
	public static List<Integer> ch_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_0);
		columns.add(ColumnIndexCHICD.CH_1);
		columns.add(ColumnIndexCHICD.CH_3);
		columns.add(ColumnIndexCHICD.CH_5);
		columns.add(ColumnIndexCHICD.CH_7);
		return columns;
	}
	
	public static List<Integer> ch_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_0);
		columns.add(ColumnIndexCHICD.CH_1);
		columns.add(ColumnIndexCHICD.CH_3);
		columns.add(ColumnIndexCHICD.CH_5);
		columns.add(ColumnIndexCHICD.CH_7);
		columns.add(ColumnIndexCHICD.CH_10);
		return columns;
	}
	
	public static List<Integer> ch_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_0);
		columns.add(ColumnIndexCHICD.CH_1);
		columns.add(ColumnIndexCHICD.CH_3);
		columns.add(ColumnIndexCHICD.CH_5);
		columns.add(ColumnIndexCHICD.CH_7);
		columns.add(ColumnIndexCHICD.CH_10);
		columns.add(ColumnIndexCHICD.CH_15);
		return columns;
	}
	
	public static List<Integer> ch_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_0);
		columns.add(ColumnIndexCHICD.CH_1);
		columns.add(ColumnIndexCHICD.CH_3);
		columns.add(ColumnIndexCHICD.CH_5);
		columns.add(ColumnIndexCHICD.CH_7);
		columns.add(ColumnIndexCHICD.CH_10);
		columns.add(ColumnIndexCHICD.CH_15);
		columns.add(ColumnIndexCHICD.CH_20);
		return columns;
	}
	
	public static List<Integer> ch_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_0);
		columns.add(ColumnIndexCHICD.CH_1);
		columns.add(ColumnIndexCHICD.CH_3);
		columns.add(ColumnIndexCHICD.CH_5);
		columns.add(ColumnIndexCHICD.CH_7);
		columns.add(ColumnIndexCHICD.CH_10);
		columns.add(ColumnIndexCHICD.CH_15);
		columns.add(ColumnIndexCHICD.CH_20);
		columns.add(ColumnIndexCHICD.CH_25);
		return columns;
	}
	
	public static List<Integer> ch_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_0);
		columns.add(ColumnIndexCHICD.CH_1);
		columns.add(ColumnIndexCHICD.CH_3);
		columns.add(ColumnIndexCHICD.CH_5);
		columns.add(ColumnIndexCHICD.CH_7);
		columns.add(ColumnIndexCHICD.CH_10);
		columns.add(ColumnIndexCHICD.CH_15);
		columns.add(ColumnIndexCHICD.CH_20);
		columns.add(ColumnIndexCHICD.CH_25);
		columns.add(ColumnIndexCHICD.CH_30);
		return columns;
	}
	
	public static List<Integer> ch_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_0);
		columns.add(ColumnIndexCHICD.CH_1);
		columns.add(ColumnIndexCHICD.CH_3);
		columns.add(ColumnIndexCHICD.CH_5);
		columns.add(ColumnIndexCHICD.CH_7);
		columns.add(ColumnIndexCHICD.CH_10);
		columns.add(ColumnIndexCHICD.CH_15);
		columns.add(ColumnIndexCHICD.CH_20);
		columns.add(ColumnIndexCHICD.CH_25);
		columns.add(ColumnIndexCHICD.CH_30);
		columns.add(ColumnIndexCHICD.CH_35);
		return columns;
	}
	
	public static List<Integer> ch_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_0);
		columns.add(ColumnIndexCHICD.CH_1);
		columns.add(ColumnIndexCHICD.CH_3);
		columns.add(ColumnIndexCHICD.CH_5);
		columns.add(ColumnIndexCHICD.CH_7);
		columns.add(ColumnIndexCHICD.CH_10);
		columns.add(ColumnIndexCHICD.CH_15);
		columns.add(ColumnIndexCHICD.CH_20);
		columns.add(ColumnIndexCHICD.CH_25);
		columns.add(ColumnIndexCHICD.CH_30);
		columns.add(ColumnIndexCHICD.CH_35);
		columns.add(ColumnIndexCHICD.CH_40);
		return columns;
	}
	
	public static List<Integer> ch_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_0);
		columns.add(ColumnIndexCHICD.CH_1);
		columns.add(ColumnIndexCHICD.CH_3);
		columns.add(ColumnIndexCHICD.CH_5);
		columns.add(ColumnIndexCHICD.CH_7);
		columns.add(ColumnIndexCHICD.CH_10);
		columns.add(ColumnIndexCHICD.CH_15);
		columns.add(ColumnIndexCHICD.CH_20);
		columns.add(ColumnIndexCHICD.CH_25);
		columns.add(ColumnIndexCHICD.CH_30);
		columns.add(ColumnIndexCHICD.CH_35);
		columns.add(ColumnIndexCHICD.CH_40);
		columns.add(ColumnIndexCHICD.CH_45);
		return columns;
	}
	
	public static List<Integer> ch_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_0);
		columns.add(ColumnIndexCHICD.CH_1);
		columns.add(ColumnIndexCHICD.CH_3);
		columns.add(ColumnIndexCHICD.CH_5);
		columns.add(ColumnIndexCHICD.CH_7);
		columns.add(ColumnIndexCHICD.CH_10);
		columns.add(ColumnIndexCHICD.CH_15);
		columns.add(ColumnIndexCHICD.CH_20);
		columns.add(ColumnIndexCHICD.CH_25);
		columns.add(ColumnIndexCHICD.CH_30);
		columns.add(ColumnIndexCHICD.CH_35);
		columns.add(ColumnIndexCHICD.CH_40);
		columns.add(ColumnIndexCHICD.CH_45);
		columns.add(ColumnIndexCHICD.CH_50);
		return columns;
	}
	
	public static List<Integer> ch_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_0);
		columns.add(ColumnIndexCHICD.CH_1);
		columns.add(ColumnIndexCHICD.CH_3);
		columns.add(ColumnIndexCHICD.CH_5);
		columns.add(ColumnIndexCHICD.CH_7);
		columns.add(ColumnIndexCHICD.CH_10);
		columns.add(ColumnIndexCHICD.CH_15);
		columns.add(ColumnIndexCHICD.CH_20);
		columns.add(ColumnIndexCHICD.CH_25);
		columns.add(ColumnIndexCHICD.CH_30);
		columns.add(ColumnIndexCHICD.CH_35);
		columns.add(ColumnIndexCHICD.CH_40);
		columns.add(ColumnIndexCHICD.CH_45);
		columns.add(ColumnIndexCHICD.CH_50);
		columns.add(ColumnIndexCHICD.CH_75);
		return columns;
	}
	
	
	public static List<Integer> icd_bl_ch_0(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_0);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_0);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_1);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_1);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_3);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_3);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_5);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_5);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_7);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_7);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_10);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_10);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_15);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_15);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_20);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_20);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_25);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_25);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_30);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_30);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_35);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_35);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_40);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_40);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_45);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_45);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_50);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_50);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_75);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_75);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_1());
		columns.add(ColumnIndexCHICD.BL);
		columns.addAll(ch_0_1());
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_3());
		columns.add(ColumnIndexCHICD.BL);
		columns.addAll(ch_0_3());
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_5());
		columns.add(ColumnIndexCHICD.BL);
		columns.addAll(ch_0_5());
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_7());
		columns.add(ColumnIndexCHICD.BL);
		columns.addAll(ch_0_7());
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_10());
		columns.add(ColumnIndexCHICD.BL);
		columns.addAll(ch_0_10());
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_15());
		columns.add(ColumnIndexCHICD.BL);
		columns.addAll(ch_0_15());
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_20());
		columns.add(ColumnIndexCHICD.BL);
		columns.addAll(ch_0_20());
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_25());
		columns.add(ColumnIndexCHICD.BL);
		columns.addAll(ch_0_25());
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_30());
		columns.add(ColumnIndexCHICD.BL);
		columns.addAll(ch_0_30());
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_35());
		columns.add(ColumnIndexCHICD.BL);
		columns.addAll(ch_0_35());
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_40());
		columns.add(ColumnIndexCHICD.BL);
		columns.addAll(ch_0_40());
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_45());
		columns.add(ColumnIndexCHICD.BL);
		columns.addAll(ch_0_45());
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_50());
		columns.add(ColumnIndexCHICD.BL);
		columns.addAll(ch_0_50());
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_75());
		columns.add(ColumnIndexCHICD.BL);
		columns.addAll(ch_0_75());
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_20_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_20);
		columns.add(ColumnIndexCHICD.ICD_25);
		columns.add(ColumnIndexCHICD.ICD_30);
		columns.add(ColumnIndexCHICD.ICD_35);
		columns.add(ColumnIndexCHICD.ICD_40);
		columns.add(ColumnIndexCHICD.ICD_45);
		columns.add(ColumnIndexCHICD.ICD_50);
		columns.add(ColumnIndexCHICD.ICD_75);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_20);
		columns.add(ColumnIndexCHICD.CH_25);
		columns.add(ColumnIndexCHICD.CH_30);
		columns.add(ColumnIndexCHICD.CH_35);
		columns.add(ColumnIndexCHICD.CH_40);
		columns.add(ColumnIndexCHICD.CH_45);
		columns.add(ColumnIndexCHICD.CH_50);
		columns.add(ColumnIndexCHICD.CH_75);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_10_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_10);
		columns.add(ColumnIndexCHICD.ICD_15);
		columns.add(ColumnIndexCHICD.ICD_20);
		columns.add(ColumnIndexCHICD.ICD_25);
		columns.add(ColumnIndexCHICD.ICD_30);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_10);
		columns.add(ColumnIndexCHICD.CH_15);
		columns.add(ColumnIndexCHICD.CH_20);
		columns.add(ColumnIndexCHICD.CH_25);
		columns.add(ColumnIndexCHICD.CH_30);
		return columns;
	}
	
	public static List<Integer> icd_bl_ch_35_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_35);
		columns.add(ColumnIndexCHICD.ICD_40);
		columns.add(ColumnIndexCHICD.ICD_45);
		columns.add(ColumnIndexCHICD.ICD_50);
		columns.add(ColumnIndexCHICD.ICD_75);
		columns.add(ColumnIndexCHICD.BL);
		columns.add(ColumnIndexCHICD.CH_35);
		columns.add(ColumnIndexCHICD.CH_40);
		columns.add(ColumnIndexCHICD.CH_45);
		columns.add(ColumnIndexCHICD.CH_50);
		columns.add(ColumnIndexCHICD.CH_75);
		return columns;
	}
	
	
	//METHODS
	public static List<Integer> icd_met_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		return columns;
	}
	
	public static List<Integer> icd_met_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		columns.add(ColumnIndexCHICD.ICD_MET_3);
		return columns;
	}
	
	public static List<Integer> icd_met_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		columns.add(ColumnIndexCHICD.ICD_MET_3);
		columns.add(ColumnIndexCHICD.ICD_MET_5);
		return columns;
	}
	
	public static List<Integer> icd_met_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		columns.add(ColumnIndexCHICD.ICD_MET_3);
		columns.add(ColumnIndexCHICD.ICD_MET_5);
		columns.add(ColumnIndexCHICD.ICD_MET_7);
		return columns;
	}
	
	public static List<Integer> icd_met_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		columns.add(ColumnIndexCHICD.ICD_MET_3);
		columns.add(ColumnIndexCHICD.ICD_MET_5);
		columns.add(ColumnIndexCHICD.ICD_MET_7);
		columns.add(ColumnIndexCHICD.ICD_MET_10);
		return columns;
	}
	
	public static List<Integer> icd_met_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		columns.add(ColumnIndexCHICD.ICD_MET_3);
		columns.add(ColumnIndexCHICD.ICD_MET_5);
		columns.add(ColumnIndexCHICD.ICD_MET_7);
		columns.add(ColumnIndexCHICD.ICD_MET_10);
		columns.add(ColumnIndexCHICD.ICD_MET_15);
		return columns;
	}
	
	public static List<Integer> icd_met_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		columns.add(ColumnIndexCHICD.ICD_MET_3);
		columns.add(ColumnIndexCHICD.ICD_MET_5);
		columns.add(ColumnIndexCHICD.ICD_MET_7);
		columns.add(ColumnIndexCHICD.ICD_MET_10);
		columns.add(ColumnIndexCHICD.ICD_MET_15);
		columns.add(ColumnIndexCHICD.ICD_MET_20);
		return columns;
	}
	
	public static List<Integer> icd_met_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		columns.add(ColumnIndexCHICD.ICD_MET_3);
		columns.add(ColumnIndexCHICD.ICD_MET_5);
		columns.add(ColumnIndexCHICD.ICD_MET_7);
		columns.add(ColumnIndexCHICD.ICD_MET_10);
		columns.add(ColumnIndexCHICD.ICD_MET_15);
		columns.add(ColumnIndexCHICD.ICD_MET_20);
		columns.add(ColumnIndexCHICD.ICD_MET_25);
		return columns;
	}
	
	public static List<Integer> icd_met_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		columns.add(ColumnIndexCHICD.ICD_MET_3);
		columns.add(ColumnIndexCHICD.ICD_MET_5);
		columns.add(ColumnIndexCHICD.ICD_MET_7);
		columns.add(ColumnIndexCHICD.ICD_MET_10);
		columns.add(ColumnIndexCHICD.ICD_MET_15);
		columns.add(ColumnIndexCHICD.ICD_MET_20);
		columns.add(ColumnIndexCHICD.ICD_MET_25);
		columns.add(ColumnIndexCHICD.ICD_MET_30);
		return columns;
	}
	
	public static List<Integer> icd_met_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		columns.add(ColumnIndexCHICD.ICD_MET_3);
		columns.add(ColumnIndexCHICD.ICD_MET_5);
		columns.add(ColumnIndexCHICD.ICD_MET_7);
		columns.add(ColumnIndexCHICD.ICD_MET_10);
		columns.add(ColumnIndexCHICD.ICD_MET_15);
		columns.add(ColumnIndexCHICD.ICD_MET_20);
		columns.add(ColumnIndexCHICD.ICD_MET_25);
		columns.add(ColumnIndexCHICD.ICD_MET_30);
		columns.add(ColumnIndexCHICD.ICD_MET_35);
		return columns;
	}
	
	public static List<Integer> icd_met_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		columns.add(ColumnIndexCHICD.ICD_MET_3);
		columns.add(ColumnIndexCHICD.ICD_MET_5);
		columns.add(ColumnIndexCHICD.ICD_MET_7);
		columns.add(ColumnIndexCHICD.ICD_MET_10);
		columns.add(ColumnIndexCHICD.ICD_MET_15);
		columns.add(ColumnIndexCHICD.ICD_MET_20);
		columns.add(ColumnIndexCHICD.ICD_MET_25);
		columns.add(ColumnIndexCHICD.ICD_MET_30);
		columns.add(ColumnIndexCHICD.ICD_MET_35);
		columns.add(ColumnIndexCHICD.ICD_MET_40);
		return columns;
	}
	
	public static List<Integer> icd_met_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		columns.add(ColumnIndexCHICD.ICD_MET_3);
		columns.add(ColumnIndexCHICD.ICD_MET_5);
		columns.add(ColumnIndexCHICD.ICD_MET_7);
		columns.add(ColumnIndexCHICD.ICD_MET_10);
		columns.add(ColumnIndexCHICD.ICD_MET_15);
		columns.add(ColumnIndexCHICD.ICD_MET_20);
		columns.add(ColumnIndexCHICD.ICD_MET_25);
		columns.add(ColumnIndexCHICD.ICD_MET_30);
		columns.add(ColumnIndexCHICD.ICD_MET_35);
		columns.add(ColumnIndexCHICD.ICD_MET_40);
		columns.add(ColumnIndexCHICD.ICD_MET_45);
		return columns;
	}
	
	public static List<Integer> icd_met_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		columns.add(ColumnIndexCHICD.ICD_MET_3);
		columns.add(ColumnIndexCHICD.ICD_MET_5);
		columns.add(ColumnIndexCHICD.ICD_MET_7);
		columns.add(ColumnIndexCHICD.ICD_MET_10);
		columns.add(ColumnIndexCHICD.ICD_MET_15);
		columns.add(ColumnIndexCHICD.ICD_MET_20);
		columns.add(ColumnIndexCHICD.ICD_MET_25);
		columns.add(ColumnIndexCHICD.ICD_MET_30);
		columns.add(ColumnIndexCHICD.ICD_MET_35);
		columns.add(ColumnIndexCHICD.ICD_MET_40);
		columns.add(ColumnIndexCHICD.ICD_MET_45);
		columns.add(ColumnIndexCHICD.ICD_MET_50);
		return columns;
	}
	
	public static List<Integer> icd_met_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		columns.add(ColumnIndexCHICD.ICD_MET_3);
		columns.add(ColumnIndexCHICD.ICD_MET_5);
		columns.add(ColumnIndexCHICD.ICD_MET_7);
		columns.add(ColumnIndexCHICD.ICD_MET_10);
		columns.add(ColumnIndexCHICD.ICD_MET_15);
		columns.add(ColumnIndexCHICD.ICD_MET_20);
		columns.add(ColumnIndexCHICD.ICD_MET_25);
		columns.add(ColumnIndexCHICD.ICD_MET_30);
		columns.add(ColumnIndexCHICD.ICD_MET_35);
		columns.add(ColumnIndexCHICD.ICD_MET_40);
		columns.add(ColumnIndexCHICD.ICD_MET_45);
		columns.add(ColumnIndexCHICD.ICD_MET_50);
		columns.add(ColumnIndexCHICD.ICD_MET_75);
		return columns;
	}
	
	public static List<Integer> ch_met_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		return columns;
	}
	
	public static List<Integer> ch_met_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		columns.add(ColumnIndexCHICD.CH_MET_3);
		return columns;
	}
	
	public static List<Integer> ch_met_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		columns.add(ColumnIndexCHICD.CH_MET_3);
		columns.add(ColumnIndexCHICD.CH_MET_5);
		return columns;
	}
	
	public static List<Integer> ch_met_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		columns.add(ColumnIndexCHICD.CH_MET_3);
		columns.add(ColumnIndexCHICD.CH_MET_5);
		columns.add(ColumnIndexCHICD.CH_MET_7);
		return columns;
	}
	
	public static List<Integer> ch_met_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		columns.add(ColumnIndexCHICD.CH_MET_3);
		columns.add(ColumnIndexCHICD.CH_MET_5);
		columns.add(ColumnIndexCHICD.CH_MET_7);
		columns.add(ColumnIndexCHICD.CH_MET_10);
		return columns;
	}
	
	public static List<Integer> ch_met_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		columns.add(ColumnIndexCHICD.CH_MET_3);
		columns.add(ColumnIndexCHICD.CH_MET_5);
		columns.add(ColumnIndexCHICD.CH_MET_7);
		columns.add(ColumnIndexCHICD.CH_MET_10);
		columns.add(ColumnIndexCHICD.CH_MET_15);
		return columns;
	}
	
	public static List<Integer> ch_met_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		columns.add(ColumnIndexCHICD.CH_MET_3);
		columns.add(ColumnIndexCHICD.CH_MET_5);
		columns.add(ColumnIndexCHICD.CH_MET_7);
		columns.add(ColumnIndexCHICD.CH_MET_10);
		columns.add(ColumnIndexCHICD.CH_MET_15);
		columns.add(ColumnIndexCHICD.CH_MET_20);
		return columns;
	}
	
	public static List<Integer> ch_met_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		columns.add(ColumnIndexCHICD.CH_MET_3);
		columns.add(ColumnIndexCHICD.CH_MET_5);
		columns.add(ColumnIndexCHICD.CH_MET_7);
		columns.add(ColumnIndexCHICD.CH_MET_10);
		columns.add(ColumnIndexCHICD.CH_MET_15);
		columns.add(ColumnIndexCHICD.CH_MET_20);
		columns.add(ColumnIndexCHICD.CH_MET_25);
		return columns;
	}
	
	public static List<Integer> ch_met_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		columns.add(ColumnIndexCHICD.CH_MET_3);
		columns.add(ColumnIndexCHICD.CH_MET_5);
		columns.add(ColumnIndexCHICD.CH_MET_7);
		columns.add(ColumnIndexCHICD.CH_MET_10);
		columns.add(ColumnIndexCHICD.CH_MET_15);
		columns.add(ColumnIndexCHICD.CH_MET_20);
		columns.add(ColumnIndexCHICD.CH_MET_25);
		columns.add(ColumnIndexCHICD.CH_MET_30);
		return columns;
	}
	
	public static List<Integer> ch_met_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		columns.add(ColumnIndexCHICD.CH_MET_3);
		columns.add(ColumnIndexCHICD.CH_MET_5);
		columns.add(ColumnIndexCHICD.CH_MET_7);
		columns.add(ColumnIndexCHICD.CH_MET_10);
		columns.add(ColumnIndexCHICD.CH_MET_15);
		columns.add(ColumnIndexCHICD.CH_MET_20);
		columns.add(ColumnIndexCHICD.CH_MET_25);
		columns.add(ColumnIndexCHICD.CH_MET_30);
		columns.add(ColumnIndexCHICD.CH_MET_35);
		return columns;
	}
	
	public static List<Integer> ch_met_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		columns.add(ColumnIndexCHICD.CH_MET_3);
		columns.add(ColumnIndexCHICD.CH_MET_5);
		columns.add(ColumnIndexCHICD.CH_MET_7);
		columns.add(ColumnIndexCHICD.CH_MET_10);
		columns.add(ColumnIndexCHICD.CH_MET_15);
		columns.add(ColumnIndexCHICD.CH_MET_20);
		columns.add(ColumnIndexCHICD.CH_MET_25);
		columns.add(ColumnIndexCHICD.CH_MET_30);
		columns.add(ColumnIndexCHICD.CH_MET_35);
		columns.add(ColumnIndexCHICD.CH_MET_40);
		return columns;
	}
	
	public static List<Integer> ch_met_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		columns.add(ColumnIndexCHICD.CH_MET_3);
		columns.add(ColumnIndexCHICD.CH_MET_5);
		columns.add(ColumnIndexCHICD.CH_MET_7);
		columns.add(ColumnIndexCHICD.CH_MET_10);
		columns.add(ColumnIndexCHICD.CH_MET_15);
		columns.add(ColumnIndexCHICD.CH_MET_20);
		columns.add(ColumnIndexCHICD.CH_MET_25);
		columns.add(ColumnIndexCHICD.CH_MET_30);
		columns.add(ColumnIndexCHICD.CH_MET_35);
		columns.add(ColumnIndexCHICD.CH_MET_40);
		columns.add(ColumnIndexCHICD.CH_MET_45);
		return columns;
	}
	
	public static List<Integer> ch_met_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		columns.add(ColumnIndexCHICD.CH_MET_3);
		columns.add(ColumnIndexCHICD.CH_MET_5);
		columns.add(ColumnIndexCHICD.CH_MET_7);
		columns.add(ColumnIndexCHICD.CH_MET_10);
		columns.add(ColumnIndexCHICD.CH_MET_15);
		columns.add(ColumnIndexCHICD.CH_MET_20);
		columns.add(ColumnIndexCHICD.CH_MET_25);
		columns.add(ColumnIndexCHICD.CH_MET_30);
		columns.add(ColumnIndexCHICD.CH_MET_35);
		columns.add(ColumnIndexCHICD.CH_MET_40);
		columns.add(ColumnIndexCHICD.CH_MET_45);
		columns.add(ColumnIndexCHICD.CH_MET_50);
		return columns;
	}
	
	public static List<Integer> ch_met_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.CH_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		columns.add(ColumnIndexCHICD.CH_MET_3);
		columns.add(ColumnIndexCHICD.CH_MET_5);
		columns.add(ColumnIndexCHICD.CH_MET_7);
		columns.add(ColumnIndexCHICD.CH_MET_10);
		columns.add(ColumnIndexCHICD.CH_MET_15);
		columns.add(ColumnIndexCHICD.CH_MET_20);
		columns.add(ColumnIndexCHICD.CH_MET_25);
		columns.add(ColumnIndexCHICD.CH_MET_30);
		columns.add(ColumnIndexCHICD.CH_MET_35);
		columns.add(ColumnIndexCHICD.CH_MET_40);
		columns.add(ColumnIndexCHICD.CH_MET_45);
		columns.add(ColumnIndexCHICD.CH_MET_50);
		columns.add(ColumnIndexCHICD.CH_MET_75);
		return columns;
	}
	
	
	public static List<Integer> icd_ch_met_0(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_0);
		columns.add(ColumnIndexCHICD.CH_MET_0);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_1);
		columns.add(ColumnIndexCHICD.CH_MET_1);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_3);
		columns.add(ColumnIndexCHICD.CH_MET_3);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_5);
		columns.add(ColumnIndexCHICD.CH_MET_5);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_7);
		columns.add(ColumnIndexCHICD.CH_MET_7);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_10);
		columns.add(ColumnIndexCHICD.CH_MET_10);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_15);
		columns.add(ColumnIndexCHICD.CH_MET_15);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_20);
		columns.add(ColumnIndexCHICD.CH_MET_20);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_25);
		columns.add(ColumnIndexCHICD.CH_MET_25);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_30);
		columns.add(ColumnIndexCHICD.CH_MET_30);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_35);
		columns.add(ColumnIndexCHICD.CH_MET_35);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_40);
		columns.add(ColumnIndexCHICD.CH_MET_40);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_45);
		columns.add(ColumnIndexCHICD.CH_MET_45);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_50);
		columns.add(ColumnIndexCHICD.CH_MET_50);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_75);
		columns.add(ColumnIndexCHICD.CH_MET_75);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_1());
		columns.addAll(ch_met_0_1());
		return columns;
	}
	
	public static List<Integer> icd_ch_met_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_3());
		columns.addAll(ch_met_0_3());
		return columns;
	}
	
	public static List<Integer> icd_ch_met_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_5());
		columns.addAll(ch_met_0_5());
		return columns;
	}
	
	public static List<Integer> icd_ch_met_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_7());
		columns.addAll(ch_met_0_7());
		return columns;
	}
	
	public static List<Integer> icd_ch_met_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_10());
		columns.addAll(ch_met_0_10());
		return columns;
	}
	
	public static List<Integer> icd_ch_met_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_15());
		columns.addAll(ch_met_0_15());
		return columns;
	}
	
	public static List<Integer> icd_ch_met_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_20());
		columns.addAll(ch_met_0_20());
		return columns;
	}
	
	public static List<Integer> icd_ch_met_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_25());
		columns.addAll(ch_met_0_25());
		return columns;
	}
	
	public static List<Integer> icd_ch_met_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_30());
		columns.addAll(ch_met_0_30());
		return columns;
	}
	
	public static List<Integer> icd_ch_met_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_35());
		columns.addAll(ch_met_0_35());
		return columns;
	}
	
	public static List<Integer> icd_ch_met_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_40());
		columns.addAll(ch_met_0_40());
		return columns;
	}
	
	public static List<Integer> icd_ch_met_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_45());
		columns.addAll(ch_met_0_45());
		return columns;
	}
	
	public static List<Integer> icd_ch_met_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_50());
		columns.addAll(ch_met_0_50());
		return columns;
	}
	
	public static List<Integer> icd_ch_met_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_75());
		columns.addAll(ch_met_0_75());
		return columns;
	}
	
	public static List<Integer> icd_ch_met_20_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_20);
		columns.add(ColumnIndexCHICD.ICD_MET_25);
		columns.add(ColumnIndexCHICD.ICD_MET_30);
		columns.add(ColumnIndexCHICD.ICD_MET_35);
		columns.add(ColumnIndexCHICD.ICD_MET_40);
		columns.add(ColumnIndexCHICD.ICD_MET_45);
		columns.add(ColumnIndexCHICD.ICD_MET_50);
		columns.add(ColumnIndexCHICD.ICD_MET_75);
		columns.add(ColumnIndexCHICD.CH_MET_20);
		columns.add(ColumnIndexCHICD.CH_MET_25);
		columns.add(ColumnIndexCHICD.CH_MET_30);
		columns.add(ColumnIndexCHICD.CH_MET_35);
		columns.add(ColumnIndexCHICD.CH_MET_40);
		columns.add(ColumnIndexCHICD.CH_MET_45);
		columns.add(ColumnIndexCHICD.CH_MET_50);
		columns.add(ColumnIndexCHICD.CH_MET_75);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_10_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_10);
		columns.add(ColumnIndexCHICD.ICD_MET_15);
		columns.add(ColumnIndexCHICD.ICD_MET_20);
		columns.add(ColumnIndexCHICD.ICD_MET_25);
		columns.add(ColumnIndexCHICD.ICD_MET_30);
		columns.add(ColumnIndexCHICD.CH_MET_10);
		columns.add(ColumnIndexCHICD.CH_MET_15);
		columns.add(ColumnIndexCHICD.CH_MET_20);
		columns.add(ColumnIndexCHICD.CH_MET_25);
		columns.add(ColumnIndexCHICD.CH_MET_30);
		return columns;
	}
	
	public static List<Integer> icd_ch_met_35_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndexCHICD.ICD_MET_35);
		columns.add(ColumnIndexCHICD.ICD_MET_40);
		columns.add(ColumnIndexCHICD.ICD_MET_45);
		columns.add(ColumnIndexCHICD.ICD_MET_50);
		columns.add(ColumnIndexCHICD.ICD_MET_75);
		columns.add(ColumnIndexCHICD.CH_MET_35);
		columns.add(ColumnIndexCHICD.CH_MET_40);
		columns.add(ColumnIndexCHICD.CH_MET_45);
		columns.add(ColumnIndexCHICD.CH_MET_50);
		columns.add(ColumnIndexCHICD.CH_MET_75);
		return columns;
	}
	
	
	
	//delta budget ranges
	public static List<Integer> efficiency_delta_0(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.add(0);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_1(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0());
		rows.add(1);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_3(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_1());
		rows.add(3);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_5(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_3());
		rows.add(5);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_7(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_5());
		rows.add(7);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_10(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_7());
		rows.add(10);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_15(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_10());
		rows.add(15);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_20(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_15());
		rows.add(20);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_25(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_20());
		rows.add(25);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_30(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_25());
		rows.add(30);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_35(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_30());
		rows.add(35);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_40(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_35());
		rows.add(40);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_45(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_40());
		rows.add(45);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_50(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_45());
		rows.add(50);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_60(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_50());
		rows.add(60);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_70(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_60());
		rows.add(70);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_80(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_70());
		rows.add(80);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_90(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_80());
		rows.add(90);
		return rows;
	}
	
	public static List<Integer> efficiency_delta_0_100(){
		List<Integer> rows = new ArrayList<Integer>();
		rows.addAll(efficiency_delta_0_90());
		rows.add(100);
		return rows;
	}
	
	//METHOD ROW HEADER
	public static List<String> method_row_header_1(){
		List<String> rows = new ArrayList<String>();
		rows.add("met-budget 1");
		return rows;
	}
			
	public static List<String> method_row_header_1_2(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(method_row_header_1());
		rows.add("met-budget 2");
		return rows;
	}
	
	public static List<String> method_row_header_1_3(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(method_row_header_1_2());
		rows.add("met-budget 3");
		return rows;
	}
	
	public static List<String> method_row_header_1_4(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(method_row_header_1_3());
		rows.add("met-budget 4");
		return rows;
	}
	
	public static List<String> method_row_header_1_5(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(method_row_header_1_4());
		rows.add("met-budget 5");
		return rows;
	}
	
	public static List<String> method_row_header_1_6(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(method_row_header_1_5());
		rows.add("met-budget 6");
		return rows;
	}
	
	public static List<String> method_row_header_1_7(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(method_row_header_1_6());
		rows.add("met-budget 7");
		return rows;
	}
	
	public static List<String> method_row_header_1_8(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(method_row_header_1_7());
		rows.add("met-budget 8");
		return rows;
	}
	
	public static List<String> method_row_header_1_9(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(method_row_header_1_8());
		rows.add("met-budget 9");
		return rows;
	}
	
	public static List<String> method_row_header_1_10(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(method_row_header_1_9());
		rows.add("met-budget 10");
		return rows;
	}
	
	public static List<String> method_row_header_1_15(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(method_row_header_1_10());
		rows.add("met-budget 15");
		return rows;
	}
	
	public static List<String> method_row_header_1_20(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(method_row_header_1_15());
		rows.add("met-budget 20");
		return rows;
	}
	
	public static List<String> method_row_header_1_25(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(method_row_header_1_20());
		rows.add("met-budget 25");
		return rows;
	}
	
	public static List<String> method_row_header_1_30(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(method_row_header_1_25());
		rows.add("met-budget 30");
		return rows;
	}
	
	public static List<String> method_row_header_1_30_plus(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(method_row_header_1_30());
		rows.add("met-budget 30+");
		return rows;
	}
		
}
