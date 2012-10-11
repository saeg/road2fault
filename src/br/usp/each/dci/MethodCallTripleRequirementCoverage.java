package br.usp.each.dci;

public class MethodCallTripleRequirementCoverage implements Comparable<MethodCallTripleRequirementCoverage>{
	
	private int methodIdCaller = 0;
	private String methodNameCaller = "";
	private String classNameCaller = "";

	private int methodIdCalledN1 = 0;
	private String methodNameCalledN1 = "";
	private String classNameCalledN1 = "";

	private int methodIdCalledN2 = 0;
	private String methodNameCalledN2 = "";
	private String classNameCalledN2 = "";

	private boolean[] coverage;
	private int c_e_f = 0;
	private int c_n_f= 0;
	private int c_e_p= 0;
	private int c_n_p = 0;
	private double suspicious= 0;

	public MethodCallTripleRequirementCoverage(int num_testcase)
	{
		coverage = new boolean[num_testcase];
	}
	
	public boolean getCoverage(int pos) {
		return this.coverage[pos];
	}

	public void setCoverage(int pos, boolean cover) {
		this.coverage[pos] = cover;
	}

	public boolean[] getAllCoverage() {
		return coverage;
	}

	public void setAllCoverage(boolean[] coverage) {
		this.coverage = coverage;
	}

	public int getC_e_f() {
		return c_e_f;
	}

	public void setC_e_f(int cEF) {
		c_e_f = cEF;
	}

	public int getC_n_f() {
		return c_n_f;
	}

	public void setC_n_f(int cNF) {
		c_n_f = cNF;
	}

	public int getC_e_p() {
		return c_e_p;
	}

	public void setC_e_p(int cEP) {
		c_e_p = cEP;
	}

	public int getC_n_p() {
		return c_n_p;
	}

	public void setC_n_p(int cNP) {
		c_n_p = cNP;
	}

	public double getSuspicious() {
		return suspicious;
	}

	public void setSuspicious(double suspicious) {
		this.suspicious = (double)suspicious;
	}

	public int getMethodIdCaller() {
		return methodIdCaller;
	}

	public String getMethodNameCaller() {
		return methodNameCaller;
	}

	public String getClassNameCaller() {
		return classNameCaller;
	}

	public int getMethodIdCalledN1() {
		return methodIdCalledN1;
	}

	public String getMethodNameCalledN1() {
		return methodNameCalledN1;
	}

	public String getClassNameCalledN1() {
		return classNameCalledN1;
	}

	public int getMethodIdCalledN2() {
		return methodIdCalledN2;
	}

	public String getMethodNameCalledN2() {
		return methodNameCalledN2;
	}

	public String getClassNameCalledN2() {
		return classNameCalledN2;
	}

	public void setMethodIdCaller(int methodIdCaller) {
		this.methodIdCaller = methodIdCaller;
	}

	public void setMethodNameCaller(String methodNameCaller) {
		this.methodNameCaller = methodNameCaller;
	}

	public void setClassNameCaller(String classNameCaller) {
		this.classNameCaller = classNameCaller;
	}

	public void setMethodIdCalledN1(int methodIdCalledN1) {
		this.methodIdCalledN1 = methodIdCalledN1;
	}

	public void setMethodNameCalledN1(String methodNameCalledN1) {
		this.methodNameCalledN1 = methodNameCalledN1;
	}

	public void setClassNameCalledN1(String classNameCalledN1) {
		this.classNameCalledN1 = classNameCalledN1;
	}

	public void setMethodIdCalledN2(int methodIdCalledN2) {
		this.methodIdCalledN2 = methodIdCalledN2;
	}

	public void setMethodNameCalledN2(String methodNameCalledN2) {
		this.methodNameCalledN2 = methodNameCalledN2;
	}

	public void setClassNameCalledN2(String classNameCalledN2) {
		this.classNameCalledN2 = classNameCalledN2;
	}

	
	//compare and put in descending order
	public int compareTo(MethodCallTripleRequirementCoverage reqCoverage)
	{
		int compare = 0;
		if(reqCoverage.getSuspicious() < this.suspicious)
		{
			compare = -1;
		}
		else if(reqCoverage.getSuspicious() > this.suspicious)
		{
			compare = 1;
		}
		if(reqCoverage.getSuspicious() == this.suspicious)
		{
			compare = this.classNameCaller.compareTo(reqCoverage.getClassNameCaller());
			if(compare == 0)
			{
				compare = this.methodIdCaller - reqCoverage.getMethodIdCaller();
				if(compare == 0)
				{
					compare = this.classNameCalledN1.compareTo(reqCoverage.getClassNameCalledN1());
					if(compare == 0)
					{
						compare = this.methodIdCalledN1 - reqCoverage.getMethodIdCalledN1();
						if(compare == 0)
						{
							compare = this.classNameCalledN2.compareTo(reqCoverage.getClassNameCalledN2());
							if(compare == 0)
							{
								compare = this.methodIdCalledN2 - reqCoverage.getMethodIdCalledN2();
							}
						}
					}
				}
			}
		}
		return compare;
	}
}
