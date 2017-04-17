package br.usp.each.road2fault;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.usp.each.inss.RequirementWrapper;
import br.usp.each.inss.cache.Requirements;
import br.usp.each.opal.requirement.RequirementType;
import br.usp.each.road2fault.RequirementCoverage;
import br.usp.each.road2fault.RequirementCoverageReader;

public class TestRequirementCoverageReader extends TestCase {

	RequirementCoverageReader reqTest = new RequirementCoverageReader(); 
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testMain() {
		
	}

	@Test
	public void testExportListRequirements() {
		fail("Not yet implemented");
	}
	@Test
	public void testCreateCoverageMatrix1() {
		RequirementWrapper wrapper = new RequirementWrapper();
		File file = new File("/home/higor/dpbci/jtopas/scripts/outputNode1");
		Assert.assertEquals(true, file.isFile());
		try{
			FileInputStream fileIn = new FileInputStream(file);
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        Requirements requirements = (Requirements) in.readObject();
	        RequirementWrapper.load(requirements, wrapper);
	        
	        Assert.assertEquals(8,wrapper.getClasses().size());
	        
	        reqTest.actualTestCase = 0;
			reqTest.totalTestCases = 1;
			reqTest.requirementType = RequirementType.NODE;
			
			reqTest.failedTestCases = new boolean[1];
			reqTest.failedTestCases[0] = false; 
			
	        
	        //insert in matrix
	        reqTest.createCoverageMatrix(wrapper);
	        
	        Assert.assertEquals(8,reqTest.hashClasses.size());
	        
	        Hashtable<Integer,List<RequirementCoverage>> hshMethod = new Hashtable<Integer,List<RequirementCoverage>>();
	        
	        hshMethod = reqTest.hashClasses.get("de.susebox.java.util.SpecialSequencesIterator");
	        Assert.assertEquals(4, hshMethod.size());
	        List<RequirementCoverage> lstCov = hshMethod.get(1);
	        RequirementCoverage cv = lstCov.get(4);
	        Assert.assertEquals("40", cv.getRequirement());
	        Assert.assertEquals(5, lstCov.size());
	        
	        hshMethod = reqTest.hashClasses.get("de.susebox.java.util.SortedArray");
	        Assert.assertEquals(6, hshMethod.size());
	        List<RequirementCoverage> lstCov2 = hshMethod.get(4);
	        RequirementCoverage cv2 = lstCov2.get(9);
	        Assert.assertEquals("95", cv2.getRequirement());
	        Assert.assertEquals(42, lstCov2.size());
	        
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		
		
	}

	@Test
	public void testUpdateRemainingClasses() {
		
		reqTest.actualTestCase = 4;
		reqTest.totalTestCases = 5;
		
		reqTest.failedTestCases = new boolean[5];
		reqTest.failedTestCases[0] = false; 
		reqTest.failedTestCases[1] = true; 
		reqTest.failedTestCases[2] = false; 
		reqTest.failedTestCases[3] = false; 
		reqTest.failedTestCases[4] = true; 
		
		//method1
		RequirementCoverage cov1 = new RequirementCoverage(5);
		RequirementCoverage cov2 = new RequirementCoverage(5);
		
		//method2
		RequirementCoverage cov3 = new RequirementCoverage(5);
		RequirementCoverage cov4 = new RequirementCoverage(5);
		RequirementCoverage cov5 = new RequirementCoverage(5);
				
		cov1.setC_e_f(1);
		cov1.setCoverage(0, true);
		cov1.setRequirement("1,12");
		
		cov2.setC_e_f(1);
		cov2.setCoverage(0, true);
		cov2.setRequirement("1,15");
		
		cov3.setC_e_f(1);
		cov3.setCoverage(0, true);
		cov3.setRequirement("0,1");
		
		cov4.setC_e_f(1);
		cov4.setCoverage(0, true);
		cov4.setRequirement("0,2");
		
		cov5.setC_e_f(1);
		cov5.setCoverage(0, true);
		cov5.setRequirement("10,15");
		
		//method1
		List<RequirementCoverage> lstCov1 = new ArrayList<RequirementCoverage>();
		lstCov1.add(cov1);
		lstCov1.add(cov2);
		
		//method2
		List<RequirementCoverage> lstCov2 = new ArrayList<RequirementCoverage>();
		lstCov2.add(cov3);
		lstCov2.add(cov4);
		lstCov2.add(cov5);
		
		Hashtable<Integer,List<RequirementCoverage>> hsMethod = new Hashtable<Integer,List<RequirementCoverage>>();
		
		hsMethod.put(0, lstCov1);
		hsMethod.put(1, lstCov2);
		
		Hashtable<String,Hashtable<Integer,List<RequirementCoverage>>> hsClass = new Hashtable<String,Hashtable<Integer,List<RequirementCoverage>>>();
		
		hsClass.put("de.susebox.java.util.SpecialSequencesIterator", hsMethod);
		
		reqTest.hashClasses = hsClass;
		
		reqTest.updateRemainingClasses();
		
		Hashtable<Integer,List<RequirementCoverage>> hsMethodUpdated = new Hashtable<Integer,List<RequirementCoverage>>();
		
		hsMethodUpdated = reqTest.hashClasses.get("de.susebox.java.util.SpecialSequencesIterator");
		
		List<RequirementCoverage> lstCov1Updated = new ArrayList<RequirementCoverage>();
		
		List<RequirementCoverage> lstCov2Updated = new ArrayList<RequirementCoverage>();
		
		lstCov1Updated = hsMethodUpdated.get(0);
		
		lstCov2Updated = hsMethodUpdated.get(1);
		
		//method1
		RequirementCoverage cov1Updated = lstCov1Updated.get(0);
		RequirementCoverage cov2Updated = lstCov1Updated.get(1);
		
		//method2
		RequirementCoverage cov3Updated = lstCov2Updated.get(0);
		RequirementCoverage cov4Updated = lstCov2Updated.get(1);
		RequirementCoverage cov5Updated = lstCov2Updated.get(2);
				
		Assert.assertEquals(3,cov1Updated.getC_n_p());
		Assert.assertEquals(1,cov1Updated.getC_n_f());
		Assert.assertEquals(0,cov1Updated.getC_e_p());
		Assert.assertEquals(1,cov1Updated.getC_e_f());
		Assert.assertEquals(3,cov2Updated.getC_n_p());
		Assert.assertEquals(1,cov3Updated.getC_n_f());
		Assert.assertEquals(0,cov3Updated.getC_e_p());
		Assert.assertEquals(3,cov3Updated.getC_n_p());
		Assert.assertEquals(1,cov5Updated.getC_e_f());
		Assert.assertEquals(0,cov5Updated.getC_e_p());
		Assert.assertEquals(1,cov5Updated.getC_n_f());
	}

	@Test
	public void testUpdatePreviousTestCases() {
		RequirementCoverage cov = new RequirementCoverage(5);
		reqTest.actualTestCase = 4;
		reqTest.failedTestCases = new boolean[5];
		reqTest.failedTestCases[0] = false; 
		reqTest.failedTestCases[1] = true; 
		reqTest.failedTestCases[2] = false; 
		reqTest.failedTestCases[3] = false; 
		reqTest.failedTestCases[4] = true; 
		
		cov.setC_e_f(1);
		cov.setCoverage(4, true);
		cov.setRequirement("1,12");
		
		reqTest.updatePreviousTestCases(cov);
		
		Assert.assertEquals(1,cov.getC_e_f());
		Assert.assertEquals(0,cov.getC_e_p());
		Assert.assertEquals(1,cov.getC_n_f());
		Assert.assertEquals(3,cov.getC_n_p());
		
		Assert.assertEquals(false,cov.getCoverage(1));
		Assert.assertEquals(true,cov.getCoverage(4));
		
	}

	@Test
	public void testSelectRequirementType() {
		//RequirementType type = RequirementType.NODE;
		
		reqTest.requirementType = reqTest.selectRequirementType("node");
		Assert.assertEquals(RequirementType.NODE, reqTest.requirementType);
		
		reqTest.requirementType = reqTest.selectRequirementType("edge");
		Assert.assertEquals(RequirementType.EDGE, reqTest.requirementType);
		
		reqTest.requirementType = reqTest.selectRequirementType("dua");
		Assert.assertEquals(RequirementType.DUA, reqTest.requirementType);
		
		reqTest.requirementType = reqTest.selectRequirementType("c");
		Assert.assertEquals(RequirementType.NODE, reqTest.requirementType);
		
	}

	@Test
	public void testGetStringRequirement() {
		String str = "(0,12,true)";
		Assert.assertEquals("0,12",reqTest.getStringRequirement(str));
		
		str = "(100,true)";
		Assert.assertEquals("100",reqTest.getStringRequirement(str));
		
		str = "[48,51,9,false]";
		Assert.assertEquals("48,51,9",reqTest.getStringRequirement(str));
		
		str = "[0,(4,128),19,false]";
		Assert.assertEquals("0,(4,128),19",reqTest.getStringRequirement(str));
		
		str = "";
		Assert.assertEquals("",reqTest.getStringRequirement(str));
		
		str = "aa";
		Assert.assertEquals("",reqTest.getStringRequirement(str));
		 
	}

	@Test
	public void testGetPackageName() {
		String str = reqTest.getPackageName("de.susebox.java.lang.ExtRuntimeException");
		assertEquals("de.susebox.java.lang", str);
	}
	
	@Test
	public void testFillPackages() {
		reqTest.fillPackages();
	}
	

}
