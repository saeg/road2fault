package br.usp.each.road2fault;

public class RequirementCoverage implements Comparable<RequirementCoverage> {
	
	
	private String requirement= "";
	//consider include the requirement type here
	private boolean[] coverage;
	
	private int c_e_f = 0;
	private int c_n_f= 0;
	private int c_e_p= 0;
	private int c_n_p = 0;
	
	private double suspicious= 0; 
	private int methodId = 0;
	private String className = "";
	private int absolutePosition = 0;
	
	public RequirementCoverage(int num_testcase)
	{
		coverage = new boolean[num_testcase];
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
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

	public int getMethodId() {
		return methodId;
	}

	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public void setAbsolutePosition(int absolutePosition) {
		this.absolutePosition = absolutePosition;
	}

	public int getAbsolutePosition() {
		return absolutePosition;
	}

	//compare and put in descending order
	public int compareTo(RequirementCoverage reqCoverage)
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
			compare = this.className.compareTo(reqCoverage.getClassName());
			if(compare == 0)
			{
				compare = this.methodId - reqCoverage.getMethodId();
				if(compare == 0)
				{
					compare = this.requirement.compareTo(reqCoverage.getRequirement());
				}
			}
		}
		return compare;
	}

}

