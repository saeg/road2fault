package br.usp.each.saeg.road2fault.extractor;

public class ColumnIndexCHICD {
	
	public static final int PROGRAM = 0;
	public static final int FAULT = 2;
	public static final int HEURISTIC = 3;
	public static final int HEADER_ICD = 6;
	public static final int ICD_0 = 7;
	public static final int ICD_1 = 8;
	public static final int ICD_3 = 9;
	public static final int ICD_5 = 10;
	public static final int ICD_7 = 11;
	public static final int ICD_10 = 12;
	public static final int ICD_15 = 13;
	public static final int ICD_20 = 14;
	public static final int ICD_25 = 15;
	public static final int ICD_30 = 16;
	public static final int ICD_35 = 17;
	public static final int ICD_40 = 18;
	public static final int ICD_45 = 19;
	public static final int ICD_50 = 20;
	public static final int ICD_75 = 21;
	public static final int BL = 22;
	public static final int CH_0 = 23;
	public static final int CH_1 = 24;
	public static final int CH_3 = 25;
	public static final int CH_5 = 26;
	public static final int CH_7 = 27;
	public static final int CH_10 = 28;
	public static final int CH_15 = 29;
	public static final int CH_20 = 30;
	public static final int CH_25 = 31;
	public static final int CH_30 = 32;
	public static final int CH_35 = 33;
	public static final int CH_40 = 34;
	public static final int CH_45 = 35;
	public static final int CH_50 = 36;
	public static final int CH_75 = 37;
	private static final int DIST_MET_BEFORE_BL = 32;
	private static final int DIST_MET_AFTER_BL = 31;
	public static final int HEADER_MET = 6+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_0 = 7+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_1 = 8+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_3 = 9+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_5 = 10+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_7 = 11+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_10 = 12+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_15 = 13+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_20 = 14+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_25 = 15+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_30 = 16+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_35 = 17+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_40 = 18+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_45 = 19+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_50 = 20+DIST_MET_BEFORE_BL;
	public static final int ICD_MET_75 = 21+DIST_MET_BEFORE_BL;
	public static final int CH_MET_0 = 23+DIST_MET_AFTER_BL;
	public static final int CH_MET_1 = 24+DIST_MET_AFTER_BL;
	public static final int CH_MET_3 = 25+DIST_MET_AFTER_BL;
	public static final int CH_MET_5 = 26+DIST_MET_AFTER_BL;
	public static final int CH_MET_7 = 27+DIST_MET_AFTER_BL;
	public static final int CH_MET_10 = 28+DIST_MET_AFTER_BL;
	public static final int CH_MET_15 = 29+DIST_MET_AFTER_BL;
	public static final int CH_MET_20 = 30+DIST_MET_AFTER_BL;
	public static final int CH_MET_25 = 31+DIST_MET_AFTER_BL;
	public static final int CH_MET_30 = 32+DIST_MET_AFTER_BL;
	public static final int CH_MET_35 = 33+DIST_MET_AFTER_BL;
	public static final int CH_MET_40 = 34+DIST_MET_AFTER_BL;
	public static final int CH_MET_45 = 35+DIST_MET_AFTER_BL;
	public static final int CH_MET_50 = 36+DIST_MET_AFTER_BL;
	public static final int CH_MET_75 = 37+DIST_MET_AFTER_BL;
	public static final int EXEC_BLOCKS = 38+DIST_MET_AFTER_BL;
	public static final int EXEC_METHODS = 39+DIST_MET_AFTER_BL;
	
	
	public static final int ABS_BLOCKS_IDX_BEGIN = ICD_0;
	public static final int ABS_BLOCKS_IDX_END = CH_75;
	public static final int ABS_METHODS_IDX_BEGIN = ICD_MET_0;
	public static final int ABS_METHODS_IDX_END = CH_MET_75;
	public static final int TOTAL_COLUMNS = EXEC_METHODS+1;
	
	
	//DELTA
	public static final int DB_EXTRA_COLUMNS = 3;
	public static final int DB_SUM_ICD = 7;
	public static final int DB_SUM_BL = 1+DB_SUM_ICD;
	public static final int DB_SUM_CH = 1+DB_SUM_BL;
	
	public static final int DB_PROGRAM = 0;
	public static final int DB_FAULT = 2;
	public static final int DB_HEURISTIC = 3;
	public static final int DB_HEADER_ICD = 6;
	public static final int DB_ICD_0 = 7+DB_EXTRA_COLUMNS;
	public static final int DB_ICD_1 = 8+DB_EXTRA_COLUMNS;
	public static final int DB_ICD_3 = 9+DB_EXTRA_COLUMNS;
	public static final int DB_ICD_5 = 10+DB_EXTRA_COLUMNS;
	public static final int DB_ICD_7 = 11+DB_EXTRA_COLUMNS;
	public static final int DB_ICD_10 = 12+DB_EXTRA_COLUMNS;
	public static final int DB_ICD_15 = 13+DB_EXTRA_COLUMNS;
	public static final int DB_ICD_20 = 14+DB_EXTRA_COLUMNS;
	public static final int DB_ICD_25 = 15+DB_EXTRA_COLUMNS;
	public static final int DB_ICD_30 = 16+DB_EXTRA_COLUMNS;
	public static final int DB_ICD_35 = 17+DB_EXTRA_COLUMNS;
	public static final int DB_ICD_40 = 18+DB_EXTRA_COLUMNS;
	public static final int DB_ICD_45 = 19+DB_EXTRA_COLUMNS;
	public static final int DB_ICD_50 = 20+DB_EXTRA_COLUMNS;
	public static final int DB_ICD_75 = 21+DB_EXTRA_COLUMNS;
	public static final int DB_BL = 22+DB_EXTRA_COLUMNS;
	public static final int DB_CH_0 = 23+DB_EXTRA_COLUMNS;
	public static final int DB_CH_1 = 24+DB_EXTRA_COLUMNS;
	public static final int DB_CH_3 = 25+DB_EXTRA_COLUMNS;
	public static final int DB_CH_5 = 26+DB_EXTRA_COLUMNS;
	public static final int DB_CH_7 = 27+DB_EXTRA_COLUMNS;
	public static final int DB_CH_10 = 28+DB_EXTRA_COLUMNS;
	public static final int DB_CH_15 = 29+DB_EXTRA_COLUMNS;
	public static final int DB_CH_20 = 30+DB_EXTRA_COLUMNS;
	public static final int DB_CH_25 = 31+DB_EXTRA_COLUMNS;
	public static final int DB_CH_30 = 32+DB_EXTRA_COLUMNS;
	public static final int DB_CH_35 = 33+DB_EXTRA_COLUMNS;
	public static final int DB_CH_40 = 34+DB_EXTRA_COLUMNS;
	public static final int DB_CH_45 = 35+DB_EXTRA_COLUMNS;
	public static final int DB_CH_50 = 36+DB_EXTRA_COLUMNS;
	public static final int DB_CH_75 = 37+DB_EXTRA_COLUMNS;
	private static final int DB_DIST_MET_BEFORE_BL = 32+DB_EXTRA_COLUMNS;
	private static final int DB_DIST_MET_AFTER_BL = 31+DB_EXTRA_COLUMNS;
	public static final int DB_HEADER_MET = 6+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_0 = 7+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_1 = 8+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_3 = 9+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_5 = 10+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_7 = 11+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_10 = 12+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_15 = 13+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_20 = 14+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_25 = 15+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_30 = 16+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_35 = 17+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_40 = 18+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_45 = 19+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_50 = 20+DB_DIST_MET_BEFORE_BL;
	public static final int DB_ICD_MET_75 = 21+DB_DIST_MET_BEFORE_BL;
	public static final int DB_CH_MET_0 = 23+DB_DIST_MET_AFTER_BL;
	public static final int DB_CH_MET_1 = 24+DB_DIST_MET_AFTER_BL;
	public static final int DB_CH_MET_3 = 25+DB_DIST_MET_AFTER_BL;
	public static final int DB_CH_MET_5 = 26+DB_DIST_MET_AFTER_BL;
	public static final int DB_CH_MET_7 = 27+DB_DIST_MET_AFTER_BL;
	public static final int DB_CH_MET_10 = 28+DB_DIST_MET_AFTER_BL;
	public static final int DB_CH_MET_15 = 29+DB_DIST_MET_AFTER_BL;
	public static final int DB_CH_MET_20 = 30+DB_DIST_MET_AFTER_BL;
	public static final int DB_CH_MET_25 = 31+DB_DIST_MET_AFTER_BL;
	public static final int DB_CH_MET_30 = 32+DB_DIST_MET_AFTER_BL;
	public static final int DB_CH_MET_35 = 33+DB_DIST_MET_AFTER_BL;
	public static final int DB_CH_MET_40 = 34+DB_DIST_MET_AFTER_BL;
	public static final int DB_CH_MET_45 = 35+DB_DIST_MET_AFTER_BL;
	public static final int DB_CH_MET_50 = 36+DB_DIST_MET_AFTER_BL;
	public static final int DB_CH_MET_75 = 37+DB_DIST_MET_AFTER_BL;
	public static final int DB_EXEC_BLOCKS = 38+DB_DIST_MET_AFTER_BL;
	public static final int DB_EXEC_METHODS = 39+DB_DIST_MET_AFTER_BL;
	
	public static final int DB_ABS_BLOCKS_IDX_BEGIN = DB_ICD_0;
	public static final int DB_ABS_BLOCKS_IDX_END = DB_CH_75;
	public static final int DB_ABS_METHODS_IDX_BEGIN = DB_ICD_MET_0;
	public static final int DB_ABS_METHODS_IDX_END = DB_CH_MET_75;
	public static final int DB_TOTAL_COLUMNS = DB_EXEC_METHODS+1;
	public static final int DB_ABS_BLOCKS_EFFORT_IDX_BEGIN = DB_SUM_ICD;
	public static final int DB_ABS_BLOCKS_EFFORT_IDX_END = DB_SUM_CH;
	
	
}