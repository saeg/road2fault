package br.usp.each.saeg.road2fault.extractor;

import java.util.ArrayList;
import java.util.List;

public class RangeIndex {
	
	//EFFECTIVENESS - DELTA BUDGET
	public static List<Integer> delta_budget_icd_bl_mhs(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.DB_SUM_ICD);
		columns.add(ColumnIndex.DB_SUM_BL);
		columns.add(ColumnIndex.DB_SUM_MHS);
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
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.ICD_1);
		return columns;
	}
	
	public static List<Integer> icd_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.ICD_1);
		columns.add(ColumnIndex.ICD_3);
		return columns;
	}
	
	public static List<Integer> icd_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.ICD_1);
		columns.add(ColumnIndex.ICD_3);
		columns.add(ColumnIndex.ICD_5);
		return columns;
	}
	
	public static List<Integer> icd_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.ICD_1);
		columns.add(ColumnIndex.ICD_3);
		columns.add(ColumnIndex.ICD_5);
		columns.add(ColumnIndex.ICD_7);
		return columns;
	}
	
	public static List<Integer> icd_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.ICD_1);
		columns.add(ColumnIndex.ICD_3);
		columns.add(ColumnIndex.ICD_5);
		columns.add(ColumnIndex.ICD_7);
		columns.add(ColumnIndex.ICD_10);
		return columns;
	}
	
	public static List<Integer> icd_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.ICD_1);
		columns.add(ColumnIndex.ICD_3);
		columns.add(ColumnIndex.ICD_5);
		columns.add(ColumnIndex.ICD_7);
		columns.add(ColumnIndex.ICD_10);
		columns.add(ColumnIndex.ICD_15);
		return columns;
	}
	
	public static List<Integer> icd_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.ICD_1);
		columns.add(ColumnIndex.ICD_3);
		columns.add(ColumnIndex.ICD_5);
		columns.add(ColumnIndex.ICD_7);
		columns.add(ColumnIndex.ICD_10);
		columns.add(ColumnIndex.ICD_15);
		columns.add(ColumnIndex.ICD_20);
		return columns;
	}
	
	public static List<Integer> icd_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.ICD_1);
		columns.add(ColumnIndex.ICD_3);
		columns.add(ColumnIndex.ICD_5);
		columns.add(ColumnIndex.ICD_7);
		columns.add(ColumnIndex.ICD_10);
		columns.add(ColumnIndex.ICD_15);
		columns.add(ColumnIndex.ICD_20);
		columns.add(ColumnIndex.ICD_25);
		return columns;
	}
	
	public static List<Integer> icd_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.ICD_1);
		columns.add(ColumnIndex.ICD_3);
		columns.add(ColumnIndex.ICD_5);
		columns.add(ColumnIndex.ICD_7);
		columns.add(ColumnIndex.ICD_10);
		columns.add(ColumnIndex.ICD_15);
		columns.add(ColumnIndex.ICD_20);
		columns.add(ColumnIndex.ICD_25);
		columns.add(ColumnIndex.ICD_30);
		return columns;
	}
	
	public static List<Integer> icd_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.ICD_1);
		columns.add(ColumnIndex.ICD_3);
		columns.add(ColumnIndex.ICD_5);
		columns.add(ColumnIndex.ICD_7);
		columns.add(ColumnIndex.ICD_10);
		columns.add(ColumnIndex.ICD_15);
		columns.add(ColumnIndex.ICD_20);
		columns.add(ColumnIndex.ICD_25);
		columns.add(ColumnIndex.ICD_30);
		columns.add(ColumnIndex.ICD_35);
		return columns;
	}
	
	public static List<Integer> icd_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.ICD_1);
		columns.add(ColumnIndex.ICD_3);
		columns.add(ColumnIndex.ICD_5);
		columns.add(ColumnIndex.ICD_7);
		columns.add(ColumnIndex.ICD_10);
		columns.add(ColumnIndex.ICD_15);
		columns.add(ColumnIndex.ICD_20);
		columns.add(ColumnIndex.ICD_25);
		columns.add(ColumnIndex.ICD_30);
		columns.add(ColumnIndex.ICD_35);
		columns.add(ColumnIndex.ICD_40);
		return columns;
	}
	
	public static List<Integer> icd_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.ICD_1);
		columns.add(ColumnIndex.ICD_3);
		columns.add(ColumnIndex.ICD_5);
		columns.add(ColumnIndex.ICD_7);
		columns.add(ColumnIndex.ICD_10);
		columns.add(ColumnIndex.ICD_15);
		columns.add(ColumnIndex.ICD_20);
		columns.add(ColumnIndex.ICD_25);
		columns.add(ColumnIndex.ICD_30);
		columns.add(ColumnIndex.ICD_35);
		columns.add(ColumnIndex.ICD_40);
		columns.add(ColumnIndex.ICD_45);
		return columns;
	}
	
	public static List<Integer> icd_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.ICD_1);
		columns.add(ColumnIndex.ICD_3);
		columns.add(ColumnIndex.ICD_5);
		columns.add(ColumnIndex.ICD_7);
		columns.add(ColumnIndex.ICD_10);
		columns.add(ColumnIndex.ICD_15);
		columns.add(ColumnIndex.ICD_20);
		columns.add(ColumnIndex.ICD_25);
		columns.add(ColumnIndex.ICD_30);
		columns.add(ColumnIndex.ICD_35);
		columns.add(ColumnIndex.ICD_40);
		columns.add(ColumnIndex.ICD_45);
		columns.add(ColumnIndex.ICD_50);
		return columns;
	}
	
	public static List<Integer> icd_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.ICD_1);
		columns.add(ColumnIndex.ICD_3);
		columns.add(ColumnIndex.ICD_5);
		columns.add(ColumnIndex.ICD_7);
		columns.add(ColumnIndex.ICD_10);
		columns.add(ColumnIndex.ICD_15);
		columns.add(ColumnIndex.ICD_20);
		columns.add(ColumnIndex.ICD_25);
		columns.add(ColumnIndex.ICD_30);
		columns.add(ColumnIndex.ICD_35);
		columns.add(ColumnIndex.ICD_40);
		columns.add(ColumnIndex.ICD_45);
		columns.add(ColumnIndex.ICD_50);
		columns.add(ColumnIndex.ICD_75);
		return columns;
	}
	
	public static List<Integer> mhs_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_0);
		columns.add(ColumnIndex.MHS_1);
		return columns;
	}
	
	public static List<Integer> mhs_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_0);
		columns.add(ColumnIndex.MHS_1);
		columns.add(ColumnIndex.MHS_3);
		return columns;
	}
	
	public static List<Integer> mhs_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_0);
		columns.add(ColumnIndex.MHS_1);
		columns.add(ColumnIndex.MHS_3);
		columns.add(ColumnIndex.MHS_5);
		return columns;
	}
	
	public static List<Integer> mhs_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_0);
		columns.add(ColumnIndex.MHS_1);
		columns.add(ColumnIndex.MHS_3);
		columns.add(ColumnIndex.MHS_5);
		columns.add(ColumnIndex.MHS_7);
		return columns;
	}
	
	public static List<Integer> mhs_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_0);
		columns.add(ColumnIndex.MHS_1);
		columns.add(ColumnIndex.MHS_3);
		columns.add(ColumnIndex.MHS_5);
		columns.add(ColumnIndex.MHS_7);
		columns.add(ColumnIndex.MHS_10);
		return columns;
	}
	
	public static List<Integer> mhs_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_0);
		columns.add(ColumnIndex.MHS_1);
		columns.add(ColumnIndex.MHS_3);
		columns.add(ColumnIndex.MHS_5);
		columns.add(ColumnIndex.MHS_7);
		columns.add(ColumnIndex.MHS_10);
		columns.add(ColumnIndex.MHS_15);
		return columns;
	}
	
	public static List<Integer> mhs_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_0);
		columns.add(ColumnIndex.MHS_1);
		columns.add(ColumnIndex.MHS_3);
		columns.add(ColumnIndex.MHS_5);
		columns.add(ColumnIndex.MHS_7);
		columns.add(ColumnIndex.MHS_10);
		columns.add(ColumnIndex.MHS_15);
		columns.add(ColumnIndex.MHS_20);
		return columns;
	}
	
	public static List<Integer> mhs_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_0);
		columns.add(ColumnIndex.MHS_1);
		columns.add(ColumnIndex.MHS_3);
		columns.add(ColumnIndex.MHS_5);
		columns.add(ColumnIndex.MHS_7);
		columns.add(ColumnIndex.MHS_10);
		columns.add(ColumnIndex.MHS_15);
		columns.add(ColumnIndex.MHS_20);
		columns.add(ColumnIndex.MHS_25);
		return columns;
	}
	
	public static List<Integer> mhs_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_0);
		columns.add(ColumnIndex.MHS_1);
		columns.add(ColumnIndex.MHS_3);
		columns.add(ColumnIndex.MHS_5);
		columns.add(ColumnIndex.MHS_7);
		columns.add(ColumnIndex.MHS_10);
		columns.add(ColumnIndex.MHS_15);
		columns.add(ColumnIndex.MHS_20);
		columns.add(ColumnIndex.MHS_25);
		columns.add(ColumnIndex.MHS_30);
		return columns;
	}
	
	public static List<Integer> mhs_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_0);
		columns.add(ColumnIndex.MHS_1);
		columns.add(ColumnIndex.MHS_3);
		columns.add(ColumnIndex.MHS_5);
		columns.add(ColumnIndex.MHS_7);
		columns.add(ColumnIndex.MHS_10);
		columns.add(ColumnIndex.MHS_15);
		columns.add(ColumnIndex.MHS_20);
		columns.add(ColumnIndex.MHS_25);
		columns.add(ColumnIndex.MHS_30);
		columns.add(ColumnIndex.MHS_35);
		return columns;
	}
	
	public static List<Integer> mhs_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_0);
		columns.add(ColumnIndex.MHS_1);
		columns.add(ColumnIndex.MHS_3);
		columns.add(ColumnIndex.MHS_5);
		columns.add(ColumnIndex.MHS_7);
		columns.add(ColumnIndex.MHS_10);
		columns.add(ColumnIndex.MHS_15);
		columns.add(ColumnIndex.MHS_20);
		columns.add(ColumnIndex.MHS_25);
		columns.add(ColumnIndex.MHS_30);
		columns.add(ColumnIndex.MHS_35);
		columns.add(ColumnIndex.MHS_40);
		return columns;
	}
	
	public static List<Integer> mhs_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_0);
		columns.add(ColumnIndex.MHS_1);
		columns.add(ColumnIndex.MHS_3);
		columns.add(ColumnIndex.MHS_5);
		columns.add(ColumnIndex.MHS_7);
		columns.add(ColumnIndex.MHS_10);
		columns.add(ColumnIndex.MHS_15);
		columns.add(ColumnIndex.MHS_20);
		columns.add(ColumnIndex.MHS_25);
		columns.add(ColumnIndex.MHS_30);
		columns.add(ColumnIndex.MHS_35);
		columns.add(ColumnIndex.MHS_40);
		columns.add(ColumnIndex.MHS_45);
		return columns;
	}
	
	public static List<Integer> mhs_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_0);
		columns.add(ColumnIndex.MHS_1);
		columns.add(ColumnIndex.MHS_3);
		columns.add(ColumnIndex.MHS_5);
		columns.add(ColumnIndex.MHS_7);
		columns.add(ColumnIndex.MHS_10);
		columns.add(ColumnIndex.MHS_15);
		columns.add(ColumnIndex.MHS_20);
		columns.add(ColumnIndex.MHS_25);
		columns.add(ColumnIndex.MHS_30);
		columns.add(ColumnIndex.MHS_35);
		columns.add(ColumnIndex.MHS_40);
		columns.add(ColumnIndex.MHS_45);
		columns.add(ColumnIndex.MHS_50);
		return columns;
	}
	
	public static List<Integer> mhs_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_0);
		columns.add(ColumnIndex.MHS_1);
		columns.add(ColumnIndex.MHS_3);
		columns.add(ColumnIndex.MHS_5);
		columns.add(ColumnIndex.MHS_7);
		columns.add(ColumnIndex.MHS_10);
		columns.add(ColumnIndex.MHS_15);
		columns.add(ColumnIndex.MHS_20);
		columns.add(ColumnIndex.MHS_25);
		columns.add(ColumnIndex.MHS_30);
		columns.add(ColumnIndex.MHS_35);
		columns.add(ColumnIndex.MHS_40);
		columns.add(ColumnIndex.MHS_45);
		columns.add(ColumnIndex.MHS_50);
		columns.add(ColumnIndex.MHS_75);
		return columns;
	}
	
	
	public static List<Integer> icd_bl_mhs_0(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_0);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_0);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_1);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_1);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_3);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_3);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_5);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_5);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_7);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_7);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_10);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_10);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_15);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_15);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_20);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_20);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_25);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_25);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_30);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_30);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_35);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_35);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_40);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_40);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_45);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_45);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_50);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_50);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_75);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_75);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_1());
		columns.add(ColumnIndex.BL);
		columns.addAll(mhs_0_1());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_3());
		columns.add(ColumnIndex.BL);
		columns.addAll(mhs_0_3());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_5());
		columns.add(ColumnIndex.BL);
		columns.addAll(mhs_0_5());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_7());
		columns.add(ColumnIndex.BL);
		columns.addAll(mhs_0_7());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_10());
		columns.add(ColumnIndex.BL);
		columns.addAll(mhs_0_10());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_15());
		columns.add(ColumnIndex.BL);
		columns.addAll(mhs_0_15());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_20());
		columns.add(ColumnIndex.BL);
		columns.addAll(mhs_0_20());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_25());
		columns.add(ColumnIndex.BL);
		columns.addAll(mhs_0_25());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_30());
		columns.add(ColumnIndex.BL);
		columns.addAll(mhs_0_30());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_35());
		columns.add(ColumnIndex.BL);
		columns.addAll(mhs_0_35());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_40());
		columns.add(ColumnIndex.BL);
		columns.addAll(mhs_0_40());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_45());
		columns.add(ColumnIndex.BL);
		columns.addAll(mhs_0_45());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_50());
		columns.add(ColumnIndex.BL);
		columns.addAll(mhs_0_50());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_0_75());
		columns.add(ColumnIndex.BL);
		columns.addAll(mhs_0_75());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_20_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_20);
		columns.add(ColumnIndex.ICD_25);
		columns.add(ColumnIndex.ICD_30);
		columns.add(ColumnIndex.ICD_35);
		columns.add(ColumnIndex.ICD_40);
		columns.add(ColumnIndex.ICD_45);
		columns.add(ColumnIndex.ICD_50);
		columns.add(ColumnIndex.ICD_75);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_20);
		columns.add(ColumnIndex.MHS_25);
		columns.add(ColumnIndex.MHS_30);
		columns.add(ColumnIndex.MHS_35);
		columns.add(ColumnIndex.MHS_40);
		columns.add(ColumnIndex.MHS_45);
		columns.add(ColumnIndex.MHS_50);
		columns.add(ColumnIndex.MHS_75);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_10_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_10);
		columns.add(ColumnIndex.ICD_15);
		columns.add(ColumnIndex.ICD_20);
		columns.add(ColumnIndex.ICD_25);
		columns.add(ColumnIndex.ICD_30);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_10);
		columns.add(ColumnIndex.MHS_15);
		columns.add(ColumnIndex.MHS_20);
		columns.add(ColumnIndex.MHS_25);
		columns.add(ColumnIndex.MHS_30);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_35_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_35);
		columns.add(ColumnIndex.ICD_40);
		columns.add(ColumnIndex.ICD_45);
		columns.add(ColumnIndex.ICD_50);
		columns.add(ColumnIndex.ICD_75);
		columns.add(ColumnIndex.BL);
		columns.add(ColumnIndex.MHS_35);
		columns.add(ColumnIndex.MHS_40);
		columns.add(ColumnIndex.MHS_45);
		columns.add(ColumnIndex.MHS_50);
		columns.add(ColumnIndex.MHS_75);
		return columns;
	}
	
	
	//METHODS
	public static List<Integer> icd_met_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.ICD_MET_1);
		return columns;
	}
	
	public static List<Integer> icd_met_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.ICD_MET_1);
		columns.add(ColumnIndex.ICD_MET_3);
		return columns;
	}
	
	public static List<Integer> icd_met_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.ICD_MET_1);
		columns.add(ColumnIndex.ICD_MET_3);
		columns.add(ColumnIndex.ICD_MET_5);
		return columns;
	}
	
	public static List<Integer> icd_met_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.ICD_MET_1);
		columns.add(ColumnIndex.ICD_MET_3);
		columns.add(ColumnIndex.ICD_MET_5);
		columns.add(ColumnIndex.ICD_MET_7);
		return columns;
	}
	
	public static List<Integer> icd_met_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.ICD_MET_1);
		columns.add(ColumnIndex.ICD_MET_3);
		columns.add(ColumnIndex.ICD_MET_5);
		columns.add(ColumnIndex.ICD_MET_7);
		columns.add(ColumnIndex.ICD_MET_10);
		return columns;
	}
	
	public static List<Integer> icd_met_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.ICD_MET_1);
		columns.add(ColumnIndex.ICD_MET_3);
		columns.add(ColumnIndex.ICD_MET_5);
		columns.add(ColumnIndex.ICD_MET_7);
		columns.add(ColumnIndex.ICD_MET_10);
		columns.add(ColumnIndex.ICD_MET_15);
		return columns;
	}
	
	public static List<Integer> icd_met_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.ICD_MET_1);
		columns.add(ColumnIndex.ICD_MET_3);
		columns.add(ColumnIndex.ICD_MET_5);
		columns.add(ColumnIndex.ICD_MET_7);
		columns.add(ColumnIndex.ICD_MET_10);
		columns.add(ColumnIndex.ICD_MET_15);
		columns.add(ColumnIndex.ICD_MET_20);
		return columns;
	}
	
	public static List<Integer> icd_met_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.ICD_MET_1);
		columns.add(ColumnIndex.ICD_MET_3);
		columns.add(ColumnIndex.ICD_MET_5);
		columns.add(ColumnIndex.ICD_MET_7);
		columns.add(ColumnIndex.ICD_MET_10);
		columns.add(ColumnIndex.ICD_MET_15);
		columns.add(ColumnIndex.ICD_MET_20);
		columns.add(ColumnIndex.ICD_MET_25);
		return columns;
	}
	
	public static List<Integer> icd_met_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.ICD_MET_1);
		columns.add(ColumnIndex.ICD_MET_3);
		columns.add(ColumnIndex.ICD_MET_5);
		columns.add(ColumnIndex.ICD_MET_7);
		columns.add(ColumnIndex.ICD_MET_10);
		columns.add(ColumnIndex.ICD_MET_15);
		columns.add(ColumnIndex.ICD_MET_20);
		columns.add(ColumnIndex.ICD_MET_25);
		columns.add(ColumnIndex.ICD_MET_30);
		return columns;
	}
	
	public static List<Integer> icd_met_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.ICD_MET_1);
		columns.add(ColumnIndex.ICD_MET_3);
		columns.add(ColumnIndex.ICD_MET_5);
		columns.add(ColumnIndex.ICD_MET_7);
		columns.add(ColumnIndex.ICD_MET_10);
		columns.add(ColumnIndex.ICD_MET_15);
		columns.add(ColumnIndex.ICD_MET_20);
		columns.add(ColumnIndex.ICD_MET_25);
		columns.add(ColumnIndex.ICD_MET_30);
		columns.add(ColumnIndex.ICD_MET_35);
		return columns;
	}
	
	public static List<Integer> icd_met_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.ICD_MET_1);
		columns.add(ColumnIndex.ICD_MET_3);
		columns.add(ColumnIndex.ICD_MET_5);
		columns.add(ColumnIndex.ICD_MET_7);
		columns.add(ColumnIndex.ICD_MET_10);
		columns.add(ColumnIndex.ICD_MET_15);
		columns.add(ColumnIndex.ICD_MET_20);
		columns.add(ColumnIndex.ICD_MET_25);
		columns.add(ColumnIndex.ICD_MET_30);
		columns.add(ColumnIndex.ICD_MET_35);
		columns.add(ColumnIndex.ICD_MET_40);
		return columns;
	}
	
	public static List<Integer> icd_met_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.ICD_MET_1);
		columns.add(ColumnIndex.ICD_MET_3);
		columns.add(ColumnIndex.ICD_MET_5);
		columns.add(ColumnIndex.ICD_MET_7);
		columns.add(ColumnIndex.ICD_MET_10);
		columns.add(ColumnIndex.ICD_MET_15);
		columns.add(ColumnIndex.ICD_MET_20);
		columns.add(ColumnIndex.ICD_MET_25);
		columns.add(ColumnIndex.ICD_MET_30);
		columns.add(ColumnIndex.ICD_MET_35);
		columns.add(ColumnIndex.ICD_MET_40);
		columns.add(ColumnIndex.ICD_MET_45);
		return columns;
	}
	
	public static List<Integer> icd_met_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.ICD_MET_1);
		columns.add(ColumnIndex.ICD_MET_3);
		columns.add(ColumnIndex.ICD_MET_5);
		columns.add(ColumnIndex.ICD_MET_7);
		columns.add(ColumnIndex.ICD_MET_10);
		columns.add(ColumnIndex.ICD_MET_15);
		columns.add(ColumnIndex.ICD_MET_20);
		columns.add(ColumnIndex.ICD_MET_25);
		columns.add(ColumnIndex.ICD_MET_30);
		columns.add(ColumnIndex.ICD_MET_35);
		columns.add(ColumnIndex.ICD_MET_40);
		columns.add(ColumnIndex.ICD_MET_45);
		columns.add(ColumnIndex.ICD_MET_50);
		return columns;
	}
	
	public static List<Integer> icd_met_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.ICD_MET_1);
		columns.add(ColumnIndex.ICD_MET_3);
		columns.add(ColumnIndex.ICD_MET_5);
		columns.add(ColumnIndex.ICD_MET_7);
		columns.add(ColumnIndex.ICD_MET_10);
		columns.add(ColumnIndex.ICD_MET_15);
		columns.add(ColumnIndex.ICD_MET_20);
		columns.add(ColumnIndex.ICD_MET_25);
		columns.add(ColumnIndex.ICD_MET_30);
		columns.add(ColumnIndex.ICD_MET_35);
		columns.add(ColumnIndex.ICD_MET_40);
		columns.add(ColumnIndex.ICD_MET_45);
		columns.add(ColumnIndex.ICD_MET_50);
		columns.add(ColumnIndex.ICD_MET_75);
		return columns;
	}
	
	public static List<Integer> mhs_met_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_0);
		columns.add(ColumnIndex.MHS_MET_1);
		return columns;
	}
	
	public static List<Integer> mhs_met_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_0);
		columns.add(ColumnIndex.MHS_MET_1);
		columns.add(ColumnIndex.MHS_MET_3);
		return columns;
	}
	
	public static List<Integer> mhs_met_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_0);
		columns.add(ColumnIndex.MHS_MET_1);
		columns.add(ColumnIndex.MHS_MET_3);
		columns.add(ColumnIndex.MHS_MET_5);
		return columns;
	}
	
	public static List<Integer> mhs_met_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_0);
		columns.add(ColumnIndex.MHS_MET_1);
		columns.add(ColumnIndex.MHS_MET_3);
		columns.add(ColumnIndex.MHS_MET_5);
		columns.add(ColumnIndex.MHS_MET_7);
		return columns;
	}
	
	public static List<Integer> mhs_met_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_0);
		columns.add(ColumnIndex.MHS_MET_1);
		columns.add(ColumnIndex.MHS_MET_3);
		columns.add(ColumnIndex.MHS_MET_5);
		columns.add(ColumnIndex.MHS_MET_7);
		columns.add(ColumnIndex.MHS_MET_10);
		return columns;
	}
	
	public static List<Integer> mhs_met_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_0);
		columns.add(ColumnIndex.MHS_MET_1);
		columns.add(ColumnIndex.MHS_MET_3);
		columns.add(ColumnIndex.MHS_MET_5);
		columns.add(ColumnIndex.MHS_MET_7);
		columns.add(ColumnIndex.MHS_MET_10);
		columns.add(ColumnIndex.MHS_MET_15);
		return columns;
	}
	
	public static List<Integer> mhs_met_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_0);
		columns.add(ColumnIndex.MHS_MET_1);
		columns.add(ColumnIndex.MHS_MET_3);
		columns.add(ColumnIndex.MHS_MET_5);
		columns.add(ColumnIndex.MHS_MET_7);
		columns.add(ColumnIndex.MHS_MET_10);
		columns.add(ColumnIndex.MHS_MET_15);
		columns.add(ColumnIndex.MHS_MET_20);
		return columns;
	}
	
	public static List<Integer> mhs_met_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_0);
		columns.add(ColumnIndex.MHS_MET_1);
		columns.add(ColumnIndex.MHS_MET_3);
		columns.add(ColumnIndex.MHS_MET_5);
		columns.add(ColumnIndex.MHS_MET_7);
		columns.add(ColumnIndex.MHS_MET_10);
		columns.add(ColumnIndex.MHS_MET_15);
		columns.add(ColumnIndex.MHS_MET_20);
		columns.add(ColumnIndex.MHS_MET_25);
		return columns;
	}
	
	public static List<Integer> mhs_met_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_0);
		columns.add(ColumnIndex.MHS_MET_1);
		columns.add(ColumnIndex.MHS_MET_3);
		columns.add(ColumnIndex.MHS_MET_5);
		columns.add(ColumnIndex.MHS_MET_7);
		columns.add(ColumnIndex.MHS_MET_10);
		columns.add(ColumnIndex.MHS_MET_15);
		columns.add(ColumnIndex.MHS_MET_20);
		columns.add(ColumnIndex.MHS_MET_25);
		columns.add(ColumnIndex.MHS_MET_30);
		return columns;
	}
	
	public static List<Integer> mhs_met_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_0);
		columns.add(ColumnIndex.MHS_MET_1);
		columns.add(ColumnIndex.MHS_MET_3);
		columns.add(ColumnIndex.MHS_MET_5);
		columns.add(ColumnIndex.MHS_MET_7);
		columns.add(ColumnIndex.MHS_MET_10);
		columns.add(ColumnIndex.MHS_MET_15);
		columns.add(ColumnIndex.MHS_MET_20);
		columns.add(ColumnIndex.MHS_MET_25);
		columns.add(ColumnIndex.MHS_MET_30);
		columns.add(ColumnIndex.MHS_MET_35);
		return columns;
	}
	
	public static List<Integer> mhs_met_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_0);
		columns.add(ColumnIndex.MHS_MET_1);
		columns.add(ColumnIndex.MHS_MET_3);
		columns.add(ColumnIndex.MHS_MET_5);
		columns.add(ColumnIndex.MHS_MET_7);
		columns.add(ColumnIndex.MHS_MET_10);
		columns.add(ColumnIndex.MHS_MET_15);
		columns.add(ColumnIndex.MHS_MET_20);
		columns.add(ColumnIndex.MHS_MET_25);
		columns.add(ColumnIndex.MHS_MET_30);
		columns.add(ColumnIndex.MHS_MET_35);
		columns.add(ColumnIndex.MHS_MET_40);
		return columns;
	}
	
	public static List<Integer> mhs_met_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_0);
		columns.add(ColumnIndex.MHS_MET_1);
		columns.add(ColumnIndex.MHS_MET_3);
		columns.add(ColumnIndex.MHS_MET_5);
		columns.add(ColumnIndex.MHS_MET_7);
		columns.add(ColumnIndex.MHS_MET_10);
		columns.add(ColumnIndex.MHS_MET_15);
		columns.add(ColumnIndex.MHS_MET_20);
		columns.add(ColumnIndex.MHS_MET_25);
		columns.add(ColumnIndex.MHS_MET_30);
		columns.add(ColumnIndex.MHS_MET_35);
		columns.add(ColumnIndex.MHS_MET_40);
		columns.add(ColumnIndex.MHS_MET_45);
		return columns;
	}
	
	public static List<Integer> mhs_met_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_0);
		columns.add(ColumnIndex.MHS_MET_1);
		columns.add(ColumnIndex.MHS_MET_3);
		columns.add(ColumnIndex.MHS_MET_5);
		columns.add(ColumnIndex.MHS_MET_7);
		columns.add(ColumnIndex.MHS_MET_10);
		columns.add(ColumnIndex.MHS_MET_15);
		columns.add(ColumnIndex.MHS_MET_20);
		columns.add(ColumnIndex.MHS_MET_25);
		columns.add(ColumnIndex.MHS_MET_30);
		columns.add(ColumnIndex.MHS_MET_35);
		columns.add(ColumnIndex.MHS_MET_40);
		columns.add(ColumnIndex.MHS_MET_45);
		columns.add(ColumnIndex.MHS_MET_50);
		return columns;
	}
	
	public static List<Integer> mhs_met_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_0);
		columns.add(ColumnIndex.MHS_MET_1);
		columns.add(ColumnIndex.MHS_MET_3);
		columns.add(ColumnIndex.MHS_MET_5);
		columns.add(ColumnIndex.MHS_MET_7);
		columns.add(ColumnIndex.MHS_MET_10);
		columns.add(ColumnIndex.MHS_MET_15);
		columns.add(ColumnIndex.MHS_MET_20);
		columns.add(ColumnIndex.MHS_MET_25);
		columns.add(ColumnIndex.MHS_MET_30);
		columns.add(ColumnIndex.MHS_MET_35);
		columns.add(ColumnIndex.MHS_MET_40);
		columns.add(ColumnIndex.MHS_MET_45);
		columns.add(ColumnIndex.MHS_MET_50);
		columns.add(ColumnIndex.MHS_MET_75);
		return columns;
	}
	
	
	public static List<Integer> icd_mhs_met_0(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_0);
		columns.add(ColumnIndex.MHS_MET_0);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_1);
		columns.add(ColumnIndex.MHS_MET_1);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_3);
		columns.add(ColumnIndex.MHS_MET_3);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_5);
		columns.add(ColumnIndex.MHS_MET_5);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_7);
		columns.add(ColumnIndex.MHS_MET_7);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_10);
		columns.add(ColumnIndex.MHS_MET_10);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_15);
		columns.add(ColumnIndex.MHS_MET_15);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_20);
		columns.add(ColumnIndex.MHS_MET_20);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_25);
		columns.add(ColumnIndex.MHS_MET_25);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_30);
		columns.add(ColumnIndex.MHS_MET_30);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_35);
		columns.add(ColumnIndex.MHS_MET_35);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_40);
		columns.add(ColumnIndex.MHS_MET_40);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_45);
		columns.add(ColumnIndex.MHS_MET_45);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_50);
		columns.add(ColumnIndex.MHS_MET_50);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_75);
		columns.add(ColumnIndex.MHS_MET_75);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_1());
		columns.addAll(mhs_met_0_1());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_3());
		columns.addAll(mhs_met_0_3());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_5());
		columns.addAll(mhs_met_0_5());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_7());
		columns.addAll(mhs_met_0_7());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_10());
		columns.addAll(mhs_met_0_10());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_15());
		columns.addAll(mhs_met_0_15());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_20());
		columns.addAll(mhs_met_0_20());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_25());
		columns.addAll(mhs_met_0_25());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_30());
		columns.addAll(mhs_met_0_30());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_35());
		columns.addAll(mhs_met_0_35());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_40());
		columns.addAll(mhs_met_0_40());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_45());
		columns.addAll(mhs_met_0_45());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_50());
		columns.addAll(mhs_met_0_50());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_0_75());
		columns.addAll(mhs_met_0_75());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_20_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_20);
		columns.add(ColumnIndex.ICD_MET_25);
		columns.add(ColumnIndex.ICD_MET_30);
		columns.add(ColumnIndex.ICD_MET_35);
		columns.add(ColumnIndex.ICD_MET_40);
		columns.add(ColumnIndex.ICD_MET_45);
		columns.add(ColumnIndex.ICD_MET_50);
		columns.add(ColumnIndex.ICD_MET_75);
		columns.add(ColumnIndex.MHS_MET_20);
		columns.add(ColumnIndex.MHS_MET_25);
		columns.add(ColumnIndex.MHS_MET_30);
		columns.add(ColumnIndex.MHS_MET_35);
		columns.add(ColumnIndex.MHS_MET_40);
		columns.add(ColumnIndex.MHS_MET_45);
		columns.add(ColumnIndex.MHS_MET_50);
		columns.add(ColumnIndex.MHS_MET_75);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_10_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_10);
		columns.add(ColumnIndex.ICD_MET_15);
		columns.add(ColumnIndex.ICD_MET_20);
		columns.add(ColumnIndex.ICD_MET_25);
		columns.add(ColumnIndex.ICD_MET_30);
		columns.add(ColumnIndex.MHS_MET_10);
		columns.add(ColumnIndex.MHS_MET_15);
		columns.add(ColumnIndex.MHS_MET_20);
		columns.add(ColumnIndex.MHS_MET_25);
		columns.add(ColumnIndex.MHS_MET_30);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_35_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_35);
		columns.add(ColumnIndex.ICD_MET_40);
		columns.add(ColumnIndex.ICD_MET_45);
		columns.add(ColumnIndex.ICD_MET_50);
		columns.add(ColumnIndex.ICD_MET_75);
		columns.add(ColumnIndex.MHS_MET_35);
		columns.add(ColumnIndex.MHS_MET_40);
		columns.add(ColumnIndex.MHS_MET_45);
		columns.add(ColumnIndex.MHS_MET_50);
		columns.add(ColumnIndex.MHS_MET_75);
		return columns;
	}
	
	
	//PERCENTUAL
	public static List<Integer> icd_perc_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.ICD_PERC_1);
		return columns;
	}
	
	public static List<Integer> icd_perc_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.ICD_PERC_1);
		columns.add(ColumnIndex.ICD_PERC_3);
		return columns;
	}
	
	public static List<Integer> icd_perc_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.ICD_PERC_1);
		columns.add(ColumnIndex.ICD_PERC_3);
		columns.add(ColumnIndex.ICD_PERC_5);
		return columns;
	}
	
	public static List<Integer> icd_perc_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.ICD_PERC_1);
		columns.add(ColumnIndex.ICD_PERC_3);
		columns.add(ColumnIndex.ICD_PERC_5);
		columns.add(ColumnIndex.ICD_PERC_7);
		return columns;
	}
	
	public static List<Integer> icd_perc_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.ICD_PERC_1);
		columns.add(ColumnIndex.ICD_PERC_3);
		columns.add(ColumnIndex.ICD_PERC_5);
		columns.add(ColumnIndex.ICD_PERC_7);
		columns.add(ColumnIndex.ICD_PERC_10);
		return columns;
	}
	
	public static List<Integer> icd_perc_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.ICD_PERC_1);
		columns.add(ColumnIndex.ICD_PERC_3);
		columns.add(ColumnIndex.ICD_PERC_5);
		columns.add(ColumnIndex.ICD_PERC_7);
		columns.add(ColumnIndex.ICD_PERC_10);
		columns.add(ColumnIndex.ICD_PERC_15);
		return columns;
	}
	
	public static List<Integer> icd_perc_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.ICD_PERC_1);
		columns.add(ColumnIndex.ICD_PERC_3);
		columns.add(ColumnIndex.ICD_PERC_5);
		columns.add(ColumnIndex.ICD_PERC_7);
		columns.add(ColumnIndex.ICD_PERC_10);
		columns.add(ColumnIndex.ICD_PERC_15);
		columns.add(ColumnIndex.ICD_PERC_20);
		return columns;
	}
	
	public static List<Integer> icd_perc_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.ICD_PERC_1);
		columns.add(ColumnIndex.ICD_PERC_3);
		columns.add(ColumnIndex.ICD_PERC_5);
		columns.add(ColumnIndex.ICD_PERC_7);
		columns.add(ColumnIndex.ICD_PERC_10);
		columns.add(ColumnIndex.ICD_PERC_15);
		columns.add(ColumnIndex.ICD_PERC_20);
		columns.add(ColumnIndex.ICD_PERC_25);
		return columns;
	}
	
	public static List<Integer> icd_perc_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.ICD_PERC_1);
		columns.add(ColumnIndex.ICD_PERC_3);
		columns.add(ColumnIndex.ICD_PERC_5);
		columns.add(ColumnIndex.ICD_PERC_7);
		columns.add(ColumnIndex.ICD_PERC_10);
		columns.add(ColumnIndex.ICD_PERC_15);
		columns.add(ColumnIndex.ICD_PERC_20);
		columns.add(ColumnIndex.ICD_PERC_25);
		columns.add(ColumnIndex.ICD_PERC_30);
		return columns;
	}
	
	public static List<Integer> icd_perc_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.ICD_PERC_1);
		columns.add(ColumnIndex.ICD_PERC_3);
		columns.add(ColumnIndex.ICD_PERC_5);
		columns.add(ColumnIndex.ICD_PERC_7);
		columns.add(ColumnIndex.ICD_PERC_10);
		columns.add(ColumnIndex.ICD_PERC_15);
		columns.add(ColumnIndex.ICD_PERC_20);
		columns.add(ColumnIndex.ICD_PERC_25);
		columns.add(ColumnIndex.ICD_PERC_30);
		columns.add(ColumnIndex.ICD_PERC_35);
		return columns;
	}
	
	public static List<Integer> icd_perc_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.ICD_PERC_1);
		columns.add(ColumnIndex.ICD_PERC_3);
		columns.add(ColumnIndex.ICD_PERC_5);
		columns.add(ColumnIndex.ICD_PERC_7);
		columns.add(ColumnIndex.ICD_PERC_10);
		columns.add(ColumnIndex.ICD_PERC_15);
		columns.add(ColumnIndex.ICD_PERC_20);
		columns.add(ColumnIndex.ICD_PERC_25);
		columns.add(ColumnIndex.ICD_PERC_30);
		columns.add(ColumnIndex.ICD_PERC_35);
		columns.add(ColumnIndex.ICD_PERC_40);
		return columns;
	}
	
	public static List<Integer> icd_perc_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.ICD_PERC_1);
		columns.add(ColumnIndex.ICD_PERC_3);
		columns.add(ColumnIndex.ICD_PERC_5);
		columns.add(ColumnIndex.ICD_PERC_7);
		columns.add(ColumnIndex.ICD_PERC_10);
		columns.add(ColumnIndex.ICD_PERC_15);
		columns.add(ColumnIndex.ICD_PERC_20);
		columns.add(ColumnIndex.ICD_PERC_25);
		columns.add(ColumnIndex.ICD_PERC_30);
		columns.add(ColumnIndex.ICD_PERC_35);
		columns.add(ColumnIndex.ICD_PERC_40);
		columns.add(ColumnIndex.ICD_PERC_45);
		return columns;
	}
	
	public static List<Integer> icd_perc_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.ICD_PERC_1);
		columns.add(ColumnIndex.ICD_PERC_3);
		columns.add(ColumnIndex.ICD_PERC_5);
		columns.add(ColumnIndex.ICD_PERC_7);
		columns.add(ColumnIndex.ICD_PERC_10);
		columns.add(ColumnIndex.ICD_PERC_15);
		columns.add(ColumnIndex.ICD_PERC_20);
		columns.add(ColumnIndex.ICD_PERC_25);
		columns.add(ColumnIndex.ICD_PERC_30);
		columns.add(ColumnIndex.ICD_PERC_35);
		columns.add(ColumnIndex.ICD_PERC_40);
		columns.add(ColumnIndex.ICD_PERC_45);
		columns.add(ColumnIndex.ICD_PERC_50);
		return columns;
	}
	
	public static List<Integer> icd_perc_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.ICD_PERC_1);
		columns.add(ColumnIndex.ICD_PERC_3);
		columns.add(ColumnIndex.ICD_PERC_5);
		columns.add(ColumnIndex.ICD_PERC_7);
		columns.add(ColumnIndex.ICD_PERC_10);
		columns.add(ColumnIndex.ICD_PERC_15);
		columns.add(ColumnIndex.ICD_PERC_20);
		columns.add(ColumnIndex.ICD_PERC_25);
		columns.add(ColumnIndex.ICD_PERC_30);
		columns.add(ColumnIndex.ICD_PERC_35);
		columns.add(ColumnIndex.ICD_PERC_40);
		columns.add(ColumnIndex.ICD_PERC_45);
		columns.add(ColumnIndex.ICD_PERC_50);
		columns.add(ColumnIndex.ICD_PERC_75);
		return columns;
	}
	
	public static List<Integer> mhs_perc_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_PERC_0);
		columns.add(ColumnIndex.MHS_PERC_1);
		return columns;
	}
	
	public static List<Integer> mhs_perc_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_PERC_0);
		columns.add(ColumnIndex.MHS_PERC_1);
		columns.add(ColumnIndex.MHS_PERC_3);
		return columns;
	}
	
	public static List<Integer> mhs_perc_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_PERC_0);
		columns.add(ColumnIndex.MHS_PERC_1);
		columns.add(ColumnIndex.MHS_PERC_3);
		columns.add(ColumnIndex.MHS_PERC_5);
		return columns;
	}
	
	public static List<Integer> mhs_perc_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_PERC_0);
		columns.add(ColumnIndex.MHS_PERC_1);
		columns.add(ColumnIndex.MHS_PERC_3);
		columns.add(ColumnIndex.MHS_PERC_5);
		columns.add(ColumnIndex.MHS_PERC_7);
		return columns;
	}
	
	public static List<Integer> mhs_perc_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_PERC_0);
		columns.add(ColumnIndex.MHS_PERC_1);
		columns.add(ColumnIndex.MHS_PERC_3);
		columns.add(ColumnIndex.MHS_PERC_5);
		columns.add(ColumnIndex.MHS_PERC_7);
		columns.add(ColumnIndex.MHS_PERC_10);
		return columns;
	}
	
	public static List<Integer> mhs_perc_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_PERC_0);
		columns.add(ColumnIndex.MHS_PERC_1);
		columns.add(ColumnIndex.MHS_PERC_3);
		columns.add(ColumnIndex.MHS_PERC_5);
		columns.add(ColumnIndex.MHS_PERC_7);
		columns.add(ColumnIndex.MHS_PERC_10);
		columns.add(ColumnIndex.MHS_PERC_15);
		return columns;
	}
	
	public static List<Integer> mhs_perc_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_PERC_0);
		columns.add(ColumnIndex.MHS_PERC_1);
		columns.add(ColumnIndex.MHS_PERC_3);
		columns.add(ColumnIndex.MHS_PERC_5);
		columns.add(ColumnIndex.MHS_PERC_7);
		columns.add(ColumnIndex.MHS_PERC_10);
		columns.add(ColumnIndex.MHS_PERC_15);
		columns.add(ColumnIndex.MHS_PERC_20);
		return columns;
	}
	
	public static List<Integer> mhs_perc_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_PERC_0);
		columns.add(ColumnIndex.MHS_PERC_1);
		columns.add(ColumnIndex.MHS_PERC_3);
		columns.add(ColumnIndex.MHS_PERC_5);
		columns.add(ColumnIndex.MHS_PERC_7);
		columns.add(ColumnIndex.MHS_PERC_10);
		columns.add(ColumnIndex.MHS_PERC_15);
		columns.add(ColumnIndex.MHS_PERC_20);
		columns.add(ColumnIndex.MHS_PERC_25);
		return columns;
	}
	
	public static List<Integer> mhs_perc_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_PERC_0);
		columns.add(ColumnIndex.MHS_PERC_1);
		columns.add(ColumnIndex.MHS_PERC_3);
		columns.add(ColumnIndex.MHS_PERC_5);
		columns.add(ColumnIndex.MHS_PERC_7);
		columns.add(ColumnIndex.MHS_PERC_10);
		columns.add(ColumnIndex.MHS_PERC_15);
		columns.add(ColumnIndex.MHS_PERC_20);
		columns.add(ColumnIndex.MHS_PERC_25);
		columns.add(ColumnIndex.MHS_PERC_30);
		return columns;
	}
	
	public static List<Integer> mhs_perc_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_PERC_0);
		columns.add(ColumnIndex.MHS_PERC_1);
		columns.add(ColumnIndex.MHS_PERC_3);
		columns.add(ColumnIndex.MHS_PERC_5);
		columns.add(ColumnIndex.MHS_PERC_7);
		columns.add(ColumnIndex.MHS_PERC_10);
		columns.add(ColumnIndex.MHS_PERC_15);
		columns.add(ColumnIndex.MHS_PERC_20);
		columns.add(ColumnIndex.MHS_PERC_25);
		columns.add(ColumnIndex.MHS_PERC_30);
		columns.add(ColumnIndex.MHS_PERC_35);
		return columns;
	}
	
	public static List<Integer> mhs_perc_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_PERC_0);
		columns.add(ColumnIndex.MHS_PERC_1);
		columns.add(ColumnIndex.MHS_PERC_3);
		columns.add(ColumnIndex.MHS_PERC_5);
		columns.add(ColumnIndex.MHS_PERC_7);
		columns.add(ColumnIndex.MHS_PERC_10);
		columns.add(ColumnIndex.MHS_PERC_15);
		columns.add(ColumnIndex.MHS_PERC_20);
		columns.add(ColumnIndex.MHS_PERC_25);
		columns.add(ColumnIndex.MHS_PERC_30);
		columns.add(ColumnIndex.MHS_PERC_35);
		columns.add(ColumnIndex.MHS_PERC_40);
		return columns;
	}
	
	public static List<Integer> mhs_perc_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_PERC_0);
		columns.add(ColumnIndex.MHS_PERC_1);
		columns.add(ColumnIndex.MHS_PERC_3);
		columns.add(ColumnIndex.MHS_PERC_5);
		columns.add(ColumnIndex.MHS_PERC_7);
		columns.add(ColumnIndex.MHS_PERC_10);
		columns.add(ColumnIndex.MHS_PERC_15);
		columns.add(ColumnIndex.MHS_PERC_20);
		columns.add(ColumnIndex.MHS_PERC_25);
		columns.add(ColumnIndex.MHS_PERC_30);
		columns.add(ColumnIndex.MHS_PERC_35);
		columns.add(ColumnIndex.MHS_PERC_40);
		columns.add(ColumnIndex.MHS_PERC_45);
		return columns;
	}
	
	public static List<Integer> mhs_perc_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_PERC_0);
		columns.add(ColumnIndex.MHS_PERC_1);
		columns.add(ColumnIndex.MHS_PERC_3);
		columns.add(ColumnIndex.MHS_PERC_5);
		columns.add(ColumnIndex.MHS_PERC_7);
		columns.add(ColumnIndex.MHS_PERC_10);
		columns.add(ColumnIndex.MHS_PERC_15);
		columns.add(ColumnIndex.MHS_PERC_20);
		columns.add(ColumnIndex.MHS_PERC_25);
		columns.add(ColumnIndex.MHS_PERC_30);
		columns.add(ColumnIndex.MHS_PERC_35);
		columns.add(ColumnIndex.MHS_PERC_40);
		columns.add(ColumnIndex.MHS_PERC_45);
		columns.add(ColumnIndex.MHS_PERC_50);
		return columns;
	}
	
	public static List<Integer> mhs_perc_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_PERC_0);
		columns.add(ColumnIndex.MHS_PERC_1);
		columns.add(ColumnIndex.MHS_PERC_3);
		columns.add(ColumnIndex.MHS_PERC_5);
		columns.add(ColumnIndex.MHS_PERC_7);
		columns.add(ColumnIndex.MHS_PERC_10);
		columns.add(ColumnIndex.MHS_PERC_15);
		columns.add(ColumnIndex.MHS_PERC_20);
		columns.add(ColumnIndex.MHS_PERC_25);
		columns.add(ColumnIndex.MHS_PERC_30);
		columns.add(ColumnIndex.MHS_PERC_35);
		columns.add(ColumnIndex.MHS_PERC_40);
		columns.add(ColumnIndex.MHS_PERC_45);
		columns.add(ColumnIndex.MHS_PERC_50);
		columns.add(ColumnIndex.MHS_PERC_75);
		return columns;
	}
	
	
	public static List<Integer> icd_bl_mhs_perc_0(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_0);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_0);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_1);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_1);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_3);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_3);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_5);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_5);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_7);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_7);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_10);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_10);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_15);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_15);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_20);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_20);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_25);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_25);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_30);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_30);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_35);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_35);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_40);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_40);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_45);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_45);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_50);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_50);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_75);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_75);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_perc_0_1());
		columns.add(ColumnIndex.BL_PERC);
		columns.addAll(mhs_perc_0_1());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_perc_0_3());
		columns.add(ColumnIndex.BL_PERC);
		columns.addAll(mhs_perc_0_3());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_perc_0_5());
		columns.add(ColumnIndex.BL_PERC);
		columns.addAll(mhs_perc_0_5());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_perc_0_7());
		columns.add(ColumnIndex.BL_PERC);
		columns.addAll(mhs_perc_0_7());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_perc_0_10());
		columns.add(ColumnIndex.BL_PERC);
		columns.addAll(mhs_perc_0_10());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_perc_0_15());
		columns.add(ColumnIndex.BL_PERC);
		columns.addAll(mhs_perc_0_15());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_perc_0_20());
		columns.add(ColumnIndex.BL_PERC);
		columns.addAll(mhs_perc_0_20());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_perc_0_25());
		columns.add(ColumnIndex.BL_PERC);
		columns.addAll(mhs_perc_0_25());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_perc_0_30());
		columns.add(ColumnIndex.BL_PERC);
		columns.addAll(mhs_perc_0_30());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_perc_0_35());
		columns.add(ColumnIndex.BL_PERC);
		columns.addAll(mhs_perc_0_35());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_perc_0_40());
		columns.add(ColumnIndex.BL_PERC);
		columns.addAll(mhs_perc_0_40());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_perc_0_45());
		columns.add(ColumnIndex.BL_PERC);
		columns.addAll(mhs_perc_0_45());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_perc_0_50());
		columns.add(ColumnIndex.BL_PERC);
		columns.addAll(mhs_perc_0_50());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_perc_0_75());
		columns.add(ColumnIndex.BL_PERC);
		columns.addAll(mhs_perc_0_75());
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_20_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_20);
		columns.add(ColumnIndex.ICD_PERC_25);
		columns.add(ColumnIndex.ICD_PERC_30);
		columns.add(ColumnIndex.ICD_PERC_35);
		columns.add(ColumnIndex.ICD_PERC_40);
		columns.add(ColumnIndex.ICD_PERC_45);
		columns.add(ColumnIndex.ICD_PERC_50);
		columns.add(ColumnIndex.ICD_PERC_75);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_20);
		columns.add(ColumnIndex.MHS_PERC_25);
		columns.add(ColumnIndex.MHS_PERC_30);
		columns.add(ColumnIndex.MHS_PERC_35);
		columns.add(ColumnIndex.MHS_PERC_40);
		columns.add(ColumnIndex.MHS_PERC_45);
		columns.add(ColumnIndex.MHS_PERC_50);
		columns.add(ColumnIndex.MHS_PERC_75);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_10_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_10);
		columns.add(ColumnIndex.ICD_PERC_15);
		columns.add(ColumnIndex.ICD_PERC_20);
		columns.add(ColumnIndex.ICD_PERC_25);
		columns.add(ColumnIndex.ICD_PERC_30);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_10);
		columns.add(ColumnIndex.MHS_PERC_15);
		columns.add(ColumnIndex.MHS_PERC_20);
		columns.add(ColumnIndex.MHS_PERC_25);
		columns.add(ColumnIndex.MHS_PERC_30);
		return columns;
	}
	
	public static List<Integer> icd_bl_mhs_perc_35_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_PERC_35);
		columns.add(ColumnIndex.ICD_PERC_40);
		columns.add(ColumnIndex.ICD_PERC_45);
		columns.add(ColumnIndex.ICD_PERC_50);
		columns.add(ColumnIndex.ICD_PERC_75);
		columns.add(ColumnIndex.BL_PERC);
		columns.add(ColumnIndex.MHS_PERC_35);
		columns.add(ColumnIndex.MHS_PERC_40);
		columns.add(ColumnIndex.MHS_PERC_45);
		columns.add(ColumnIndex.MHS_PERC_50);
		columns.add(ColumnIndex.MHS_PERC_75);
		return columns;
	}
	
	//METHOD PERCENTUAL
	public static List<Integer> icd_met_perc_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		return columns;
	}
	
	public static List<Integer> icd_met_perc_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		columns.add(ColumnIndex.ICD_MET_PERC_3);
		return columns;
	}
	
	public static List<Integer> icd_met_perc_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		columns.add(ColumnIndex.ICD_MET_PERC_3);
		columns.add(ColumnIndex.ICD_MET_PERC_5);
		return columns;
	}
	
	public static List<Integer> icd_met_perc_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		columns.add(ColumnIndex.ICD_MET_PERC_3);
		columns.add(ColumnIndex.ICD_MET_PERC_5);
		columns.add(ColumnIndex.ICD_MET_PERC_7);
		return columns;
	}
	
	public static List<Integer> icd_met_perc_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		columns.add(ColumnIndex.ICD_MET_PERC_3);
		columns.add(ColumnIndex.ICD_MET_PERC_5);
		columns.add(ColumnIndex.ICD_MET_PERC_7);
		columns.add(ColumnIndex.ICD_MET_PERC_10);
		return columns;
	}
	
	public static List<Integer> icd_met_perc_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		columns.add(ColumnIndex.ICD_MET_PERC_3);
		columns.add(ColumnIndex.ICD_MET_PERC_5);
		columns.add(ColumnIndex.ICD_MET_PERC_7);
		columns.add(ColumnIndex.ICD_MET_PERC_10);
		columns.add(ColumnIndex.ICD_MET_PERC_15);
		return columns;
	}
	
	public static List<Integer> icd_met_perc_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		columns.add(ColumnIndex.ICD_MET_PERC_3);
		columns.add(ColumnIndex.ICD_MET_PERC_5);
		columns.add(ColumnIndex.ICD_MET_PERC_7);
		columns.add(ColumnIndex.ICD_MET_PERC_10);
		columns.add(ColumnIndex.ICD_MET_PERC_15);
		columns.add(ColumnIndex.ICD_MET_PERC_20);
		return columns;
	}
	
	public static List<Integer> icd_met_perc_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		columns.add(ColumnIndex.ICD_MET_PERC_3);
		columns.add(ColumnIndex.ICD_MET_PERC_5);
		columns.add(ColumnIndex.ICD_MET_PERC_7);
		columns.add(ColumnIndex.ICD_MET_PERC_10);
		columns.add(ColumnIndex.ICD_MET_PERC_15);
		columns.add(ColumnIndex.ICD_MET_PERC_20);
		columns.add(ColumnIndex.ICD_MET_PERC_25);
		return columns;
	}
	
	public static List<Integer> icd_met_perc_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		columns.add(ColumnIndex.ICD_MET_PERC_3);
		columns.add(ColumnIndex.ICD_MET_PERC_5);
		columns.add(ColumnIndex.ICD_MET_PERC_7);
		columns.add(ColumnIndex.ICD_MET_PERC_10);
		columns.add(ColumnIndex.ICD_MET_PERC_15);
		columns.add(ColumnIndex.ICD_MET_PERC_20);
		columns.add(ColumnIndex.ICD_MET_PERC_25);
		columns.add(ColumnIndex.ICD_MET_PERC_30);
		return columns;
	}
	
	public static List<Integer> icd_met_perc_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		columns.add(ColumnIndex.ICD_MET_PERC_3);
		columns.add(ColumnIndex.ICD_MET_PERC_5);
		columns.add(ColumnIndex.ICD_MET_PERC_7);
		columns.add(ColumnIndex.ICD_MET_PERC_10);
		columns.add(ColumnIndex.ICD_MET_PERC_15);
		columns.add(ColumnIndex.ICD_MET_PERC_20);
		columns.add(ColumnIndex.ICD_MET_PERC_25);
		columns.add(ColumnIndex.ICD_MET_PERC_30);
		columns.add(ColumnIndex.ICD_MET_PERC_35);
		return columns;
	}
	
	public static List<Integer> icd_met_perc_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		columns.add(ColumnIndex.ICD_MET_PERC_3);
		columns.add(ColumnIndex.ICD_MET_PERC_5);
		columns.add(ColumnIndex.ICD_MET_PERC_7);
		columns.add(ColumnIndex.ICD_MET_PERC_10);
		columns.add(ColumnIndex.ICD_MET_PERC_15);
		columns.add(ColumnIndex.ICD_MET_PERC_20);
		columns.add(ColumnIndex.ICD_MET_PERC_25);
		columns.add(ColumnIndex.ICD_MET_PERC_30);
		columns.add(ColumnIndex.ICD_MET_PERC_35);
		columns.add(ColumnIndex.ICD_MET_PERC_40);
		return columns;
	}
	
	public static List<Integer> icd_met_perc_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		columns.add(ColumnIndex.ICD_MET_PERC_3);
		columns.add(ColumnIndex.ICD_MET_PERC_5);
		columns.add(ColumnIndex.ICD_MET_PERC_7);
		columns.add(ColumnIndex.ICD_MET_PERC_10);
		columns.add(ColumnIndex.ICD_MET_PERC_15);
		columns.add(ColumnIndex.ICD_MET_PERC_20);
		columns.add(ColumnIndex.ICD_MET_PERC_25);
		columns.add(ColumnIndex.ICD_MET_PERC_30);
		columns.add(ColumnIndex.ICD_MET_PERC_35);
		columns.add(ColumnIndex.ICD_MET_PERC_40);
		columns.add(ColumnIndex.ICD_MET_PERC_45);
		return columns;
	}
	
	public static List<Integer> icd_met_perc_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		columns.add(ColumnIndex.ICD_MET_PERC_3);
		columns.add(ColumnIndex.ICD_MET_PERC_5);
		columns.add(ColumnIndex.ICD_MET_PERC_7);
		columns.add(ColumnIndex.ICD_MET_PERC_10);
		columns.add(ColumnIndex.ICD_MET_PERC_15);
		columns.add(ColumnIndex.ICD_MET_PERC_20);
		columns.add(ColumnIndex.ICD_MET_PERC_25);
		columns.add(ColumnIndex.ICD_MET_PERC_30);
		columns.add(ColumnIndex.ICD_MET_PERC_35);
		columns.add(ColumnIndex.ICD_MET_PERC_40);
		columns.add(ColumnIndex.ICD_MET_PERC_45);
		columns.add(ColumnIndex.ICD_MET_PERC_50);
		return columns;
	}
	
	public static List<Integer> icd_met_perc_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		columns.add(ColumnIndex.ICD_MET_PERC_3);
		columns.add(ColumnIndex.ICD_MET_PERC_5);
		columns.add(ColumnIndex.ICD_MET_PERC_7);
		columns.add(ColumnIndex.ICD_MET_PERC_10);
		columns.add(ColumnIndex.ICD_MET_PERC_15);
		columns.add(ColumnIndex.ICD_MET_PERC_20);
		columns.add(ColumnIndex.ICD_MET_PERC_25);
		columns.add(ColumnIndex.ICD_MET_PERC_30);
		columns.add(ColumnIndex.ICD_MET_PERC_35);
		columns.add(ColumnIndex.ICD_MET_PERC_40);
		columns.add(ColumnIndex.ICD_MET_PERC_45);
		columns.add(ColumnIndex.ICD_MET_PERC_50);
		columns.add(ColumnIndex.ICD_MET_PERC_75);
		return columns;
	}
	
	public static List<Integer> mhs_met_perc_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		return columns;
	}
	
	public static List<Integer> mhs_met_perc_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		columns.add(ColumnIndex.MHS_MET_PERC_3);
		return columns;
	}
	
	public static List<Integer> mhs_met_perc_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		columns.add(ColumnIndex.MHS_MET_PERC_3);
		columns.add(ColumnIndex.MHS_MET_PERC_5);
		return columns;
	}
	
	public static List<Integer> mhs_met_perc_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		columns.add(ColumnIndex.MHS_MET_PERC_3);
		columns.add(ColumnIndex.MHS_MET_PERC_5);
		columns.add(ColumnIndex.MHS_MET_PERC_7);
		return columns;
	}
	
	public static List<Integer> mhs_met_perc_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		columns.add(ColumnIndex.MHS_MET_PERC_3);
		columns.add(ColumnIndex.MHS_MET_PERC_5);
		columns.add(ColumnIndex.MHS_MET_PERC_7);
		columns.add(ColumnIndex.MHS_MET_PERC_10);
		return columns;
	}
	
	public static List<Integer> mhs_met_perc_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		columns.add(ColumnIndex.MHS_MET_PERC_3);
		columns.add(ColumnIndex.MHS_MET_PERC_5);
		columns.add(ColumnIndex.MHS_MET_PERC_7);
		columns.add(ColumnIndex.MHS_MET_PERC_10);
		columns.add(ColumnIndex.MHS_MET_PERC_15);
		return columns;
	}
	
	public static List<Integer> mhs_met_perc_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		columns.add(ColumnIndex.MHS_MET_PERC_3);
		columns.add(ColumnIndex.MHS_MET_PERC_5);
		columns.add(ColumnIndex.MHS_MET_PERC_7);
		columns.add(ColumnIndex.MHS_MET_PERC_10);
		columns.add(ColumnIndex.MHS_MET_PERC_15);
		columns.add(ColumnIndex.MHS_MET_PERC_20);
		return columns;
	}
	
	public static List<Integer> mhs_met_perc_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		columns.add(ColumnIndex.MHS_MET_PERC_3);
		columns.add(ColumnIndex.MHS_MET_PERC_5);
		columns.add(ColumnIndex.MHS_MET_PERC_7);
		columns.add(ColumnIndex.MHS_MET_PERC_10);
		columns.add(ColumnIndex.MHS_MET_PERC_15);
		columns.add(ColumnIndex.MHS_MET_PERC_20);
		columns.add(ColumnIndex.MHS_MET_PERC_25);
		return columns;
	}
	
	public static List<Integer> mhs_met_perc_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		columns.add(ColumnIndex.MHS_MET_PERC_3);
		columns.add(ColumnIndex.MHS_MET_PERC_5);
		columns.add(ColumnIndex.MHS_MET_PERC_7);
		columns.add(ColumnIndex.MHS_MET_PERC_10);
		columns.add(ColumnIndex.MHS_MET_PERC_15);
		columns.add(ColumnIndex.MHS_MET_PERC_20);
		columns.add(ColumnIndex.MHS_MET_PERC_25);
		columns.add(ColumnIndex.MHS_MET_PERC_30);
		return columns;
	}
	
	public static List<Integer> mhs_met_perc_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		columns.add(ColumnIndex.MHS_MET_PERC_3);
		columns.add(ColumnIndex.MHS_MET_PERC_5);
		columns.add(ColumnIndex.MHS_MET_PERC_7);
		columns.add(ColumnIndex.MHS_MET_PERC_10);
		columns.add(ColumnIndex.MHS_MET_PERC_15);
		columns.add(ColumnIndex.MHS_MET_PERC_20);
		columns.add(ColumnIndex.MHS_MET_PERC_25);
		columns.add(ColumnIndex.MHS_MET_PERC_30);
		columns.add(ColumnIndex.MHS_MET_PERC_35);
		return columns;
	}
	
	public static List<Integer> mhs_met_perc_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		columns.add(ColumnIndex.MHS_MET_PERC_3);
		columns.add(ColumnIndex.MHS_MET_PERC_5);
		columns.add(ColumnIndex.MHS_MET_PERC_7);
		columns.add(ColumnIndex.MHS_MET_PERC_10);
		columns.add(ColumnIndex.MHS_MET_PERC_15);
		columns.add(ColumnIndex.MHS_MET_PERC_20);
		columns.add(ColumnIndex.MHS_MET_PERC_25);
		columns.add(ColumnIndex.MHS_MET_PERC_30);
		columns.add(ColumnIndex.MHS_MET_PERC_35);
		columns.add(ColumnIndex.MHS_MET_PERC_40);
		return columns;
	}
	
	public static List<Integer> mhs_met_perc_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		columns.add(ColumnIndex.MHS_MET_PERC_3);
		columns.add(ColumnIndex.MHS_MET_PERC_5);
		columns.add(ColumnIndex.MHS_MET_PERC_7);
		columns.add(ColumnIndex.MHS_MET_PERC_10);
		columns.add(ColumnIndex.MHS_MET_PERC_15);
		columns.add(ColumnIndex.MHS_MET_PERC_20);
		columns.add(ColumnIndex.MHS_MET_PERC_25);
		columns.add(ColumnIndex.MHS_MET_PERC_30);
		columns.add(ColumnIndex.MHS_MET_PERC_35);
		columns.add(ColumnIndex.MHS_MET_PERC_40);
		columns.add(ColumnIndex.MHS_MET_PERC_45);
		return columns;
	}
	
	public static List<Integer> mhs_met_perc_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		columns.add(ColumnIndex.MHS_MET_PERC_3);
		columns.add(ColumnIndex.MHS_MET_PERC_5);
		columns.add(ColumnIndex.MHS_MET_PERC_7);
		columns.add(ColumnIndex.MHS_MET_PERC_10);
		columns.add(ColumnIndex.MHS_MET_PERC_15);
		columns.add(ColumnIndex.MHS_MET_PERC_20);
		columns.add(ColumnIndex.MHS_MET_PERC_25);
		columns.add(ColumnIndex.MHS_MET_PERC_30);
		columns.add(ColumnIndex.MHS_MET_PERC_35);
		columns.add(ColumnIndex.MHS_MET_PERC_40);
		columns.add(ColumnIndex.MHS_MET_PERC_45);
		columns.add(ColumnIndex.MHS_MET_PERC_50);
		return columns;
	}
	
	public static List<Integer> mhs_met_perc_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		columns.add(ColumnIndex.MHS_MET_PERC_3);
		columns.add(ColumnIndex.MHS_MET_PERC_5);
		columns.add(ColumnIndex.MHS_MET_PERC_7);
		columns.add(ColumnIndex.MHS_MET_PERC_10);
		columns.add(ColumnIndex.MHS_MET_PERC_15);
		columns.add(ColumnIndex.MHS_MET_PERC_20);
		columns.add(ColumnIndex.MHS_MET_PERC_25);
		columns.add(ColumnIndex.MHS_MET_PERC_30);
		columns.add(ColumnIndex.MHS_MET_PERC_35);
		columns.add(ColumnIndex.MHS_MET_PERC_40);
		columns.add(ColumnIndex.MHS_MET_PERC_45);
		columns.add(ColumnIndex.MHS_MET_PERC_50);
		columns.add(ColumnIndex.MHS_MET_PERC_75);
		return columns;
	}
	
	
	public static List<Integer> icd_mhs_met_perc_0(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_0);
		columns.add(ColumnIndex.MHS_MET_PERC_0);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_1);
		columns.add(ColumnIndex.MHS_MET_PERC_1);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_3);
		columns.add(ColumnIndex.MHS_MET_PERC_3);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_5);
		columns.add(ColumnIndex.MHS_MET_PERC_5);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_7);
		columns.add(ColumnIndex.MHS_MET_PERC_7);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_10);
		columns.add(ColumnIndex.MHS_MET_PERC_10);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_15);
		columns.add(ColumnIndex.MHS_MET_PERC_15);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_20);
		columns.add(ColumnIndex.MHS_MET_PERC_20);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_25);
		columns.add(ColumnIndex.MHS_MET_PERC_25);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_30);
		columns.add(ColumnIndex.MHS_MET_PERC_30);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_35);
		columns.add(ColumnIndex.MHS_MET_PERC_35);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_40);
		columns.add(ColumnIndex.MHS_MET_PERC_40);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_45);
		columns.add(ColumnIndex.MHS_MET_PERC_45);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_50);
		columns.add(ColumnIndex.MHS_MET_PERC_50);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_75);
		columns.add(ColumnIndex.MHS_MET_PERC_75);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_perc_0_1());
		columns.addAll(mhs_met_perc_0_1());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_perc_0_3());
		columns.addAll(mhs_met_perc_0_3());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_perc_0_5());
		columns.addAll(mhs_met_perc_0_5());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_perc_0_7());
		columns.addAll(mhs_met_perc_0_7());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_perc_0_10());
		columns.addAll(mhs_met_perc_0_10());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_perc_0_15());
		columns.addAll(mhs_met_perc_0_15());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_perc_0_20());
		columns.addAll(mhs_met_perc_0_20());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_perc_0_25());
		columns.addAll(mhs_met_perc_0_25());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_perc_0_30());
		columns.addAll(mhs_met_perc_0_30());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_perc_0_35());
		columns.addAll(mhs_met_perc_0_35());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_perc_0_40());
		columns.addAll(mhs_met_perc_0_40());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_perc_0_45());
		columns.addAll(mhs_met_perc_0_45());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_perc_0_50());
		columns.addAll(mhs_met_perc_0_50());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(icd_met_perc_0_75());
		columns.addAll(mhs_met_perc_0_75());
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_20_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_20);
		columns.add(ColumnIndex.ICD_MET_PERC_25);
		columns.add(ColumnIndex.ICD_MET_PERC_30);
		columns.add(ColumnIndex.ICD_MET_PERC_35);
		columns.add(ColumnIndex.ICD_MET_PERC_40);
		columns.add(ColumnIndex.ICD_MET_PERC_45);
		columns.add(ColumnIndex.ICD_MET_PERC_50);
		columns.add(ColumnIndex.ICD_MET_PERC_75);
		columns.add(ColumnIndex.MHS_MET_PERC_20);
		columns.add(ColumnIndex.MHS_MET_PERC_25);
		columns.add(ColumnIndex.MHS_MET_PERC_30);
		columns.add(ColumnIndex.MHS_MET_PERC_35);
		columns.add(ColumnIndex.MHS_MET_PERC_40);
		columns.add(ColumnIndex.MHS_MET_PERC_45);
		columns.add(ColumnIndex.MHS_MET_PERC_50);
		columns.add(ColumnIndex.MHS_MET_PERC_75);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_10_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_10);
		columns.add(ColumnIndex.ICD_MET_PERC_15);
		columns.add(ColumnIndex.ICD_MET_PERC_20);
		columns.add(ColumnIndex.ICD_MET_PERC_25);
		columns.add(ColumnIndex.ICD_MET_PERC_30);
		columns.add(ColumnIndex.MHS_MET_PERC_10);
		columns.add(ColumnIndex.MHS_MET_PERC_15);
		columns.add(ColumnIndex.MHS_MET_PERC_20);
		columns.add(ColumnIndex.MHS_MET_PERC_25);
		columns.add(ColumnIndex.MHS_MET_PERC_30);
		return columns;
	}
	
	public static List<Integer> icd_mhs_met_perc_35_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.ICD_MET_PERC_35);
		columns.add(ColumnIndex.ICD_MET_PERC_40);
		columns.add(ColumnIndex.ICD_MET_PERC_45);
		columns.add(ColumnIndex.ICD_MET_PERC_50);
		columns.add(ColumnIndex.ICD_MET_PERC_75);
		columns.add(ColumnIndex.MHS_MET_PERC_35);
		columns.add(ColumnIndex.MHS_MET_PERC_40);
		columns.add(ColumnIndex.MHS_MET_PERC_45);
		columns.add(ColumnIndex.MHS_MET_PERC_50);
		columns.add(ColumnIndex.MHS_MET_PERC_75);
		return columns;
	}
	
	
	//EFFICIENCY
	//ICD X BL
	public static List<Integer> ef_icd_bl_0(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EF_ICD_BL_0);
		columns.add(ColumnIndex.EF_BL_ICD_0);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_0());
		columns.add(ColumnIndex.EF_ICD_BL_1);
		columns.add(ColumnIndex.EF_BL_ICD_1);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_0_1());
		columns.add(ColumnIndex.EF_ICD_BL_3);
		columns.add(ColumnIndex.EF_BL_ICD_3);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_0_3());
		columns.add(ColumnIndex.EF_ICD_BL_5);
		columns.add(ColumnIndex.EF_BL_ICD_5);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_0_5());
		columns.add(ColumnIndex.EF_ICD_BL_7);
		columns.add(ColumnIndex.EF_BL_ICD_7);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_0_7());
		columns.add(ColumnIndex.EF_ICD_BL_10);
		columns.add(ColumnIndex.EF_BL_ICD_10);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_0_10());
		columns.add(ColumnIndex.EF_ICD_BL_15);
		columns.add(ColumnIndex.EF_BL_ICD_15);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_0_15());
		columns.add(ColumnIndex.EF_ICD_BL_20);
		columns.add(ColumnIndex.EF_BL_ICD_20);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_0_20());
		columns.add(ColumnIndex.EF_ICD_BL_25);
		columns.add(ColumnIndex.EF_BL_ICD_25);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_0_25());
		columns.add(ColumnIndex.EF_ICD_BL_30);
		columns.add(ColumnIndex.EF_BL_ICD_30);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_0_30());
		columns.add(ColumnIndex.EF_ICD_BL_35);
		columns.add(ColumnIndex.EF_BL_ICD_35);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_0_35());
		columns.add(ColumnIndex.EF_ICD_BL_40);
		columns.add(ColumnIndex.EF_BL_ICD_40);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_0_40());
		columns.add(ColumnIndex.EF_ICD_BL_45);
		columns.add(ColumnIndex.EF_BL_ICD_45);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_0_45());
		columns.add(ColumnIndex.EF_ICD_BL_50);
		columns.add(ColumnIndex.EF_BL_ICD_50);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_0_50());
		columns.add(ColumnIndex.EF_ICD_BL_75);
		columns.add(ColumnIndex.EF_BL_ICD_75);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_15_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EF_ICD_BL_15);
		columns.add(ColumnIndex.EF_BL_ICD_15);
		columns.add(ColumnIndex.EF_ICD_BL_20);
		columns.add(ColumnIndex.EF_BL_ICD_20);
		columns.add(ColumnIndex.EF_ICD_BL_25);
		columns.add(ColumnIndex.EF_BL_ICD_25);
		columns.add(ColumnIndex.EF_ICD_BL_30);
		columns.add(ColumnIndex.EF_BL_ICD_30);
		columns.add(ColumnIndex.EF_ICD_BL_35);
		columns.add(ColumnIndex.EF_BL_ICD_35);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_40_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EF_ICD_BL_40);
		columns.add(ColumnIndex.EF_BL_ICD_40);
		columns.add(ColumnIndex.EF_ICD_BL_45);
		columns.add(ColumnIndex.EF_BL_ICD_45);
		columns.add(ColumnIndex.EF_ICD_BL_50);
		columns.add(ColumnIndex.EF_BL_ICD_50);
		columns.add(ColumnIndex.EF_ICD_BL_75);
		columns.add(ColumnIndex.EF_BL_ICD_75);
		return columns;
	}
	
	//ICD x MHS
	public static List<Integer> ef_icd_mhs_0(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EF_ICD_MHS_0);
		columns.add(ColumnIndex.EF_MHS_ICD_0);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_mhs_0());
		columns.add(ColumnIndex.EF_ICD_MHS_1);
		columns.add(ColumnIndex.EF_MHS_ICD_1);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_mhs_0_1());
		columns.add(ColumnIndex.EF_ICD_MHS_3);
		columns.add(ColumnIndex.EF_MHS_ICD_3);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_mhs_0_3());
		columns.add(ColumnIndex.EF_ICD_MHS_5);
		columns.add(ColumnIndex.EF_MHS_ICD_5);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_mhs_0_5());
		columns.add(ColumnIndex.EF_ICD_MHS_7);
		columns.add(ColumnIndex.EF_MHS_ICD_7);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_mhs_0_7());
		columns.add(ColumnIndex.EF_ICD_MHS_10);
		columns.add(ColumnIndex.EF_MHS_ICD_10);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_mhs_0_10());
		columns.add(ColumnIndex.EF_ICD_MHS_15);
		columns.add(ColumnIndex.EF_MHS_ICD_15);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_mhs_0_15());
		columns.add(ColumnIndex.EF_ICD_MHS_20);
		columns.add(ColumnIndex.EF_MHS_ICD_20);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_mhs_0_20());
		columns.add(ColumnIndex.EF_ICD_MHS_25);
		columns.add(ColumnIndex.EF_MHS_ICD_25);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_mhs_0_25());
		columns.add(ColumnIndex.EF_ICD_MHS_30);
		columns.add(ColumnIndex.EF_MHS_ICD_30);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_mhs_0_30());
		columns.add(ColumnIndex.EF_ICD_MHS_35);
		columns.add(ColumnIndex.EF_MHS_ICD_35);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_mhs_0_35());
		columns.add(ColumnIndex.EF_ICD_MHS_40);
		columns.add(ColumnIndex.EF_MHS_ICD_40);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_mhs_0_40());
		columns.add(ColumnIndex.EF_ICD_MHS_45);
		columns.add(ColumnIndex.EF_MHS_ICD_45);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_mhs_0_45());
		columns.add(ColumnIndex.EF_ICD_MHS_50);
		columns.add(ColumnIndex.EF_MHS_ICD_50);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_mhs_0_50());
		columns.add(ColumnIndex.EF_ICD_MHS_75);
		columns.add(ColumnIndex.EF_MHS_ICD_75);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_15_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EF_ICD_MHS_15);
		columns.add(ColumnIndex.EF_MHS_ICD_15);
		columns.add(ColumnIndex.EF_ICD_MHS_20);
		columns.add(ColumnIndex.EF_MHS_ICD_20);
		columns.add(ColumnIndex.EF_ICD_MHS_25);
		columns.add(ColumnIndex.EF_MHS_ICD_25);
		columns.add(ColumnIndex.EF_ICD_MHS_30);
		columns.add(ColumnIndex.EF_MHS_ICD_30);
		columns.add(ColumnIndex.EF_ICD_MHS_35);
		columns.add(ColumnIndex.EF_MHS_ICD_35);
		return columns;
	}
	
	public static List<Integer> ef_icd_mhs_40_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EF_ICD_MHS_40);
		columns.add(ColumnIndex.EF_MHS_ICD_40);
		columns.add(ColumnIndex.EF_ICD_MHS_45);
		columns.add(ColumnIndex.EF_MHS_ICD_45);
		columns.add(ColumnIndex.EF_ICD_MHS_50);
		columns.add(ColumnIndex.EF_MHS_ICD_50);
		columns.add(ColumnIndex.EF_ICD_MHS_75);
		columns.add(ColumnIndex.EF_MHS_ICD_75);
		return columns;
	}
	
	//MHS X BL
	public static List<Integer> ef_mhs_bl_0(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EF_MHS_BL_0);
		columns.add(ColumnIndex.EF_BL_MHS_0);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_mhs_bl_0());
		columns.add(ColumnIndex.EF_MHS_BL_1);
		columns.add(ColumnIndex.EF_BL_MHS_1);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_mhs_bl_0_1());
		columns.add(ColumnIndex.EF_MHS_BL_3);
		columns.add(ColumnIndex.EF_BL_MHS_3);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_mhs_bl_0_3());
		columns.add(ColumnIndex.EF_MHS_BL_5);
		columns.add(ColumnIndex.EF_BL_MHS_5);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_mhs_bl_0_5());
		columns.add(ColumnIndex.EF_MHS_BL_7);
		columns.add(ColumnIndex.EF_BL_MHS_7);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_mhs_bl_0_7());
		columns.add(ColumnIndex.EF_MHS_BL_10);
		columns.add(ColumnIndex.EF_BL_MHS_10);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_mhs_bl_0_10());
		columns.add(ColumnIndex.EF_MHS_BL_15);
		columns.add(ColumnIndex.EF_BL_MHS_15);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_mhs_bl_0_15());
		columns.add(ColumnIndex.EF_MHS_BL_20);
		columns.add(ColumnIndex.EF_BL_MHS_20);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_mhs_bl_0_20());
		columns.add(ColumnIndex.EF_MHS_BL_25);
		columns.add(ColumnIndex.EF_BL_MHS_25);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_mhs_bl_0_25());
		columns.add(ColumnIndex.EF_MHS_BL_30);
		columns.add(ColumnIndex.EF_BL_MHS_30);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_mhs_bl_0_30());
		columns.add(ColumnIndex.EF_MHS_BL_35);
		columns.add(ColumnIndex.EF_BL_MHS_35);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_mhs_bl_0_35());
		columns.add(ColumnIndex.EF_MHS_BL_40);
		columns.add(ColumnIndex.EF_BL_MHS_40);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_mhs_bl_0_40());
		columns.add(ColumnIndex.EF_MHS_BL_45);
		columns.add(ColumnIndex.EF_BL_MHS_45);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_mhs_bl_0_45());
		columns.add(ColumnIndex.EF_MHS_BL_50);
		columns.add(ColumnIndex.EF_BL_MHS_50);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_mhs_bl_0_50());
		columns.add(ColumnIndex.EF_MHS_BL_75);
		columns.add(ColumnIndex.EF_BL_MHS_75);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_15_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EF_MHS_BL_15);
		columns.add(ColumnIndex.EF_BL_MHS_15);
		columns.add(ColumnIndex.EF_MHS_BL_20);
		columns.add(ColumnIndex.EF_BL_MHS_20);
		columns.add(ColumnIndex.EF_MHS_BL_25);
		columns.add(ColumnIndex.EF_BL_MHS_25);
		columns.add(ColumnIndex.EF_MHS_BL_30);
		columns.add(ColumnIndex.EF_BL_MHS_30);
		columns.add(ColumnIndex.EF_MHS_BL_35);
		columns.add(ColumnIndex.EF_BL_MHS_35);
		return columns;
	}
	
	public static List<Integer> ef_mhs_bl_40_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EF_MHS_BL_40);
		columns.add(ColumnIndex.EF_BL_MHS_40);
		columns.add(ColumnIndex.EF_MHS_BL_45);
		columns.add(ColumnIndex.EF_BL_MHS_45);
		columns.add(ColumnIndex.EF_MHS_BL_50);
		columns.add(ColumnIndex.EF_BL_MHS_50);
		columns.add(ColumnIndex.EF_MHS_BL_75);
		columns.add(ColumnIndex.EF_BL_MHS_75);
		return columns;
	}
	
	//ICD X BL X MHS
	public static List<Integer> ef_icd_bl_mhs_0(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EF_ICD_BL_MHS_0);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_0);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_0);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_0_1(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_mhs_0());
		columns.add(ColumnIndex.EF_ICD_BL_MHS_1);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_1);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_1);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_0_3(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_mhs_0_1());
		columns.add(ColumnIndex.EF_ICD_BL_MHS_3);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_3);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_3);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_0_5(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_mhs_0_3());
		columns.add(ColumnIndex.EF_ICD_BL_MHS_5);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_5);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_5);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_0_7(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_mhs_0_5());
		columns.add(ColumnIndex.EF_ICD_BL_MHS_7);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_7);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_7);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_0_10(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_mhs_0_7());
		columns.add(ColumnIndex.EF_ICD_BL_MHS_10);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_10);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_10);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_0_15(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_mhs_0_10());
		columns.add(ColumnIndex.EF_ICD_BL_MHS_15);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_15);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_15);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_0_20(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_mhs_0_15());
		columns.add(ColumnIndex.EF_ICD_BL_MHS_20);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_20);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_20);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_0_25(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_mhs_0_20());
		columns.add(ColumnIndex.EF_ICD_BL_MHS_25);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_25);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_25);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_0_30(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_mhs_0_25());
		columns.add(ColumnIndex.EF_ICD_BL_MHS_30);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_30);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_30);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_0_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_mhs_0_30());
		columns.add(ColumnIndex.EF_ICD_BL_MHS_35);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_35);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_35);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_0_40(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_mhs_0_35());
		columns.add(ColumnIndex.EF_ICD_BL_MHS_40);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_40);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_40);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_0_45(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_mhs_0_40());
		columns.add(ColumnIndex.EF_ICD_BL_MHS_45);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_45);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_45);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_0_50(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_mhs_0_45());
		columns.add(ColumnIndex.EF_ICD_BL_MHS_50);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_50);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_50);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_0_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.addAll(ef_icd_bl_mhs_0_50());
		columns.add(ColumnIndex.EF_ICD_BL_MHS_75);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_75);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_75);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_15_35(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EF_ICD_BL_MHS_15);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_15);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_15);
		columns.add(ColumnIndex.EF_ICD_BL_MHS_20);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_20);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_20);
		columns.add(ColumnIndex.EF_ICD_BL_MHS_25);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_25);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_25);
		columns.add(ColumnIndex.EF_ICD_BL_MHS_30);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_30);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_30);
		columns.add(ColumnIndex.EF_ICD_BL_MHS_35);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_35);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_35);
		return columns;
	}
	
	public static List<Integer> ef_icd_bl_mhs_40_75(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EF_ICD_BL_MHS_40);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_40);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_40);
		columns.add(ColumnIndex.EF_ICD_BL_MHS_45);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_45);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_45);
		columns.add(ColumnIndex.EF_ICD_BL_MHS_50);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_50);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_50);
		columns.add(ColumnIndex.EF_ICD_BL_MHS_75);
		columns.add(ColumnIndex.EF_BL_ICD_MHS_75);
		columns.add(ColumnIndex.EF_MHS_ICD_BL_75);
		return columns;
	}
	
	
	//Efficiency charts
	public static List<Integer> efficiency_icd_bl(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EFFICIENCY_ICD_BL);
		columns.add(ColumnIndex.EFFICIENCY_BL_ICD);
		return columns;
	}
	
	public static List<Integer> efficiency_icd_mhs(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EFFICIENCY_ICD_MHS);
		columns.add(ColumnIndex.EFFICIENCY_MHS_ICD);
		return columns;
	}
	
	public static List<Integer> efficiency_mhs_bl(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EFFICIENCY_MHS_BL);
		columns.add(ColumnIndex.EFFICIENCY_BL_MHS);
		return columns;
	}
	
	public static List<Integer> efficiency_icd_bl_mhs(){
		List<Integer> columns = new ArrayList<Integer>();
		columns.add(ColumnIndex.EFFICIENCY_ICD_BL_MHS);
		columns.add(ColumnIndex.EFFICIENCY_BL_ICD_MHS);
		columns.add(ColumnIndex.EFFICIENCY_MHS_ICD_BL);
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
	
		
	//PERC BLOCK ROW HEADER
	public static List<String> perc_block_row_header_1(){
		List<String> rows = new ArrayList<String>();
		rows.add("block-1%");
		return rows;
	}
		
	public static List<String> perc_block_row_header_1_5(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1());
		rows.add("block-5%");
		return rows;
	}
	
	public static List<String> perc_block_row_header_1_10(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1_5());
		rows.add("block-10%");
		return rows;
	}
	
	public static List<String> perc_block_row_header_1_15(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1_10());
		rows.add("block-15%");
		return rows;
	}
	
	public static List<String> perc_block_row_header_1_20(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1_15());
		rows.add("block-20%");
		return rows;
	}
	
	public static List<String> perc_block_row_header_1_25(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1_20());
		rows.add("block-25%");
		return rows;
	}
	
	public static List<String> perc_block_row_header_1_30(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1_25());
		rows.add("block-30%");
		return rows;
	}
	
	public static List<String> perc_block_row_header_1_35(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1_30());
		rows.add("block-35%");
		return rows;
	}
	
	public static List<String> perc_block_row_header_1_40(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1_35());
		rows.add("block-40%");
		return rows;
	}
	
	public static List<String> perc_block_row_header_1_45(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1_40());
		rows.add("block-45%");
		return rows;
	}
	
	public static List<String> perc_block_row_header_1_50(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1_45());
		rows.add("block-50%");
		return rows;
	}
	
	public static List<String> perc_block_row_header_1_60(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1_50());
		rows.add("block-60%");
		return rows;
	}
	
	public static List<String> perc_block_row_header_1_70(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1_60());
		rows.add("block-70%");
		return rows;
	}
	
	public static List<String> perc_block_row_header_1_80(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1_70());
		rows.add("block-80%");
		return rows;
	}
	
	public static List<String> perc_block_row_header_1_90(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1_80());
		rows.add("block-90%");
		return rows;
	}
	
	public static List<String> perc_block_row_header_1_100(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_block_row_header_1_90());
		rows.add("block-100%");
		return rows;
	}
	
	
	//PERC METHOD ROW HEADER
	public static List<String> perc_method_row_header_1(){
		List<String> rows = new ArrayList<String>();
		rows.add("met-1%");
		return rows;
	}
		
	public static List<String> perc_method_row_header_1_5(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1());
		rows.add("met-5%");
		return rows;
	}
	
	public static List<String> perc_method_row_header_1_10(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1_5());
		rows.add("met-10%");
		return rows;
	}
	
	public static List<String> perc_method_row_header_1_15(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1_10());
		rows.add("met-15%");
		return rows;
	}
		
	public static List<String> perc_method_row_header_1_20(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1_15());
		rows.add("met-20%");
		return rows;
	}
		
	public static List<String> perc_method_row_header_1_25(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1_20());
		rows.add("met-25%");
		return rows;
	}
		
	public static List<String> perc_method_row_header_1_30(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1_25());
		rows.add("met-30%");
		return rows;
	}
		
	public static List<String> perc_method_row_header_1_35(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1_30());
		rows.add("met-35%");
		return rows;
	}
		
	public static List<String> perc_method_row_header_1_40(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1_35());
		rows.add("met-40%");
		return rows;
	}
		
	public static List<String> perc_method_row_header_1_45(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1_40());
		rows.add("met-45%");
		return rows;
	}
		
	public static List<String> perc_method_row_header_1_50(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1_45());
		rows.add("met-50%");
		return rows;
	}
		
	public static List<String> perc_method_row_header_1_60(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1_50());
		rows.add("met-60%");
		return rows;
	}
		
	public static List<String> perc_method_row_header_1_70(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1_60());
		rows.add("met-70%");
		return rows;
	}
		
	public static List<String> perc_method_row_header_1_80(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1_70());
		rows.add("met-80%");
		return rows;
	}
		
	public static List<String> perc_method_row_header_1_90(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1_80());
		rows.add("met-90%");
		return rows;
	}
		
	public static List<String> perc_method_row_header_1_100(){
		List<String> rows = new ArrayList<String>();
		rows.addAll(perc_method_row_header_1_90());
		rows.add("met-100%");
		return rows;
	}
	
}
