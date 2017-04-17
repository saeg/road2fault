package br.usp.each.road2fault;

public class MethodCallPairRequirementCoverage implements Comparable<MethodCallPairRequirementCoverage>{

	private int methodIdCaller = 0;
	private String methodNameCaller = "";
	private String classNameCaller = "";

	private int methodIdCalled = 0;
	private String methodNameCalled = "";
	private String classNameCalled = "";

	private boolean[] coverage;
	private int c_e_f = 0;
	private int c_n_f= 0;
	private int c_e_p= 0;
	private int c_n_p = 0;
	private double suspicious= 0;
	private int absolutePosition = 0;


	public MethodCallPairRequirementCoverage(int num_testcase)
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

	public int getMethodIdCalled() {
		return methodIdCalled;
	}

	public String getMethodNameCalled() {
		return methodNameCalled;
	}

	public String getClassNameCalled() {
		return classNameCalled;
	}

	public int getAbsolutePosition() {
		return absolutePosition;
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

	public void setMethodIdCalled(int methodIdCalled) {
		this.methodIdCalled = methodIdCalled;
	}

	public void setMethodNameCalled(String methodNameCalled) {
		this.methodNameCalled = methodNameCalled;
	}

	public void setClassNameCalled(String classNameCalled) {
		this.classNameCalled = classNameCalled;
	}

	public void setAbsolutePosition(int absolutePosition) {
		this.absolutePosition = absolutePosition;
	}

	//compare and put in descending order
	public int compareTo(MethodCallPairRequirementCoverage reqCoverage)
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
					compare = this.classNameCalled.compareTo(reqCoverage.getClassNameCalled());
					if(compare == 0)
					{
						compare = this.methodIdCalled - reqCoverage.getMethodIdCalled();
					}
				}
			}
		}
		return compare;
	}

}