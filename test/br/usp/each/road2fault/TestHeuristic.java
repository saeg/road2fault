package br.usp.each.road2fault;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.usp.each.road2fault.Heuristic;
import br.usp.each.road2fault.RequirementCoverage;

public class TestHeuristic {

	Heuristic heur = new Heuristic();
	RequirementCoverage req = new RequirementCoverage(27); 
	@Before
	public void setUp() throws Exception {
		
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	//Tarantula
	
	@Test
	public void testCalculateTarantulaAllCoeficientsZeroMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaANegativeValueInCefMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaAllCoeficientsNegativeMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(-1);
		req.setC_e_p(-1);
		req.setC_n_p(-1);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCefHaveValueMustBeMaxSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCnfHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCepHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCnpHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCefCnfHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCefNotHaveValueMustBeLowSuspicious() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCefCnpHaveValuesMustBeHighSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCepNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCefCepHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCnfNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.666, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaAllCoeficientsHaveValueOne() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCnpNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.333, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCefHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(5);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCepHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(5);
		req.setC_n_p(1);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.231, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaAllCoeficientsHaveEqualValues() {
		double susp = 0;
		req.setC_e_f(2);
		req.setC_n_f(1);
		req.setC_e_p(3);
		req.setC_n_p(2);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.526, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCefCnfMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1);
		req.setC_n_p(2);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.666, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCepCnpMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(10);
		req.setC_n_p(4);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.259, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCefMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCefMoreExecutedThanCnfCepCnp() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(2);
		req.setC_n_p(1);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.576, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCefMoreExecutedThanCep() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(2);
		req.setC_n_p(0);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCefMoreExecutedThanCep2() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(3);
		req.setC_n_p(0);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCefCepEqualExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(10);
		req.setC_n_p(0);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCepMoreExecutedThanCef() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(11);
		req.setC_n_p(0);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCefNotExecuted() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(10);
		req.setC_e_p(10);
		req.setC_n_p(5);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCepWithHighValueMustBeLowSuspiciousness() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1000);
		req.setC_n_p(15);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.403, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCefWithHighVaValueMustBeHighSuspiciousness() {
		double susp = 0;
		req.setC_e_f(100);
		req.setC_n_f(15);
		req.setC_e_p(10);
		req.setC_n_p(500);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.977, susp, 0.001);
	}
	
	@Test
	public void testCalculateTarantulaCnfCnpWithHighValuesMustBeMediumSuspiciousness() {
		double susp = 0;
		req.setC_e_f(12);
		req.setC_n_f(30);
		req.setC_e_p(20);
		req.setC_n_p(100);
		susp = heur.calculateTarantula(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.631, susp, 0.001);
	}
	
	
	//DRT
	
	@Test
	public void testCalculateDRTAllCoeficientsZeroMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTANegativeValueInCefMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTAllCoeficientsNegativeMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(-1);
		req.setC_e_p(-1);
		req.setC_n_p(-1);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCefHaveValueMustBeMaxSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCnfHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCepHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCnpHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCefCnfHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCefNotHaveValueMustBeLowSuspicious() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCefCnpHaveValuesMustBeHighSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCepNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCefCepHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.666, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCnfNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.75, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTAllCoeficientsHaveValueOne() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.8, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCnpNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.75, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCefHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(5);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(5, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCepHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(5);
		req.setC_n_p(1);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.666, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTAllCoeficientsHaveEqualValues() {
		double susp = 0;
		req.setC_e_f(2);
		req.setC_n_f(1);
		req.setC_e_p(3);
		req.setC_n_p(2);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1.454, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCefCnfMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1);
		req.setC_n_p(2);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(9.473, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCepCnpMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(10);
		req.setC_n_p(4);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.642, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCefMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(10, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCefMoreExecutedThanCnfCepCnp() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(2);
		req.setC_n_p(1);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(8.75, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCefMoreExecutedThanCep() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(2);
		req.setC_n_p(0);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(8.571, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCefMoreExecutedThanCep2() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(3);
		req.setC_n_p(0);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(8.125, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCefCepEqualExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(10);
		req.setC_n_p(0);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(6.666, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCepMoreExecutedThanCef() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(11);
		req.setC_n_p(0);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(6.562, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCefNotExecuted() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(10);
		req.setC_e_p(10);
		req.setC_n_p(5);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCepWithHighValueMustBeLowSuspiciousness() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1000);
		req.setC_n_p(15);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(5.073, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCefWithHighVaValueMustBeHighSuspiciousness() {
		double susp = 0;
		req.setC_e_f(100);
		req.setC_n_f(15);
		req.setC_e_p(10);
		req.setC_n_p(500);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(98.425, susp, 0.001);
	}
	
	@Test
	public void testCalculateDRTCnfCnpWithHighValuesMustBeMediumSuspiciousness() {
		double susp = 0;
		req.setC_e_f(12);
		req.setC_n_f(30);
		req.setC_e_p(20);
		req.setC_n_p(100);
		susp = heur.calculateDRT(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(10.681, susp, 0.001);
	}
	
	
	//Ochiai
	
	@Test
	public void testCalculateOchiaiAllCoeficientsZeroMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiANegativeValueInCefMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiAllCoeficientsNegativeMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(-1);
		req.setC_e_p(-1);
		req.setC_n_p(-1);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCefHaveValueMustBeMaxSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCnfHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCepHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCnpHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCefCnfHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.707, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCefNotHaveValueMustBeLowSuspicious() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCefCnpHaveValuesMustBeHighSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.707, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCepNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCefCepHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCnfNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.707, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiAllCoeficientsHaveValueOne() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCnpNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.707, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCefHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(5);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.833, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCepHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(5);
		req.setC_n_p(1);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.353, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiAllCoeficientsHaveEqualValues() {
		double susp = 0;
		req.setC_e_f(2);
		req.setC_n_f(1);
		req.setC_e_p(3);
		req.setC_n_p(2);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.577, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCefCnfMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1);
		req.setC_n_p(2);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.745, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCepCnpMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(10);
		req.setC_n_p(4);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.223, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCefMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.909, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCefMoreExecutedThanCnfCepCnp() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(2);
		req.setC_n_p(1);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.909, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCefMoreExecutedThanCep() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(2);
		req.setC_n_p(0);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCefMoreExecutedThanCep2() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(3);
		req.setC_n_p(0);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCefCepEqualExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(10);
		req.setC_n_p(0);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCepMoreExecutedThanCef() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(11);
		req.setC_n_p(0);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCefNotExecuted() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(10);
		req.setC_e_p(10);
		req.setC_n_p(5);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCepWithHighValueMustBeLowSuspiciousness() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1000);
		req.setC_n_p(15);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.516, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCefWithHighVaValueMustBeHighSuspiciousness() {
		double susp = 0;
		req.setC_e_f(100);
		req.setC_n_f(15);
		req.setC_e_p(10);
		req.setC_n_p(500);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.380, susp, 0.001);
	}
	
	@Test
	public void testCalculateOchiaiCnfCnpWithHighValuesMustBeMediumSuspiciousness() {
		double susp = 0;
		req.setC_e_f(12);
		req.setC_n_f(30);
		req.setC_e_p(20);
		req.setC_n_p(100);
		susp = heur.calculateOchiai(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.174, susp, 0.001);
	}
	
	
	//Jaccard
	
	@Test
	public void testCalculateJaccardAllCoeficientsZeroMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardANegativeValueInCefMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardAllCoeficientsNegativeMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(-1);
		req.setC_e_p(-1);
		req.setC_n_p(-1);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCefHaveValueMustBeMaxSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCnfHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCepHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCnpHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCefCnfHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCefNotHaveValueMustBeLowSuspicious() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCefCnpHaveValuesMustBeHighSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCepNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCefCepHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCnfNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardAllCoeficientsHaveValueOne() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.333, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCnpNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.333, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCefHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(5);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.833, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCepHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(5);
		req.setC_n_p(1);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.111, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardAllCoeficientsHaveEqualValues() {
		double susp = 0;
		req.setC_e_f(2);
		req.setC_n_f(1);
		req.setC_e_p(3);
		req.setC_n_p(2);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.333, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCefCnfMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1);
		req.setC_n_p(2);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.625, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCepCnpMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(10);
		req.setC_n_p(4);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.071, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCefMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.909, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCefMoreExecutedThanCnfCepCnp() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(2);
		req.setC_n_p(1);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.769, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCefMoreExecutedThanCep() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(2);
		req.setC_n_p(0);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.833, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCefMoreExecutedThanCep2() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(3);
		req.setC_n_p(0);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.769, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCefCepEqualExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(10);
		req.setC_n_p(0);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCepMoreExecutedThanCef() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(11);
		req.setC_n_p(0);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.476, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCefNotExecuted() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(10);
		req.setC_e_p(10);
		req.setC_n_p(5);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCepWithHighValueMustBeLowSuspiciousness() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1000);
		req.setC_n_p(15);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.00985, susp, 0.00001);
	}
	
	@Test
	public void testCalculateJaccardCefWithHighVaValueMustBeHighSuspiciousness() {
		double susp = 0;
		req.setC_e_f(100);
		req.setC_n_f(15);
		req.setC_e_p(10);
		req.setC_n_p(500);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.8, susp, 0.001);
	}
	
	@Test
	public void testCalculateJaccardCnfCnpWithHighValuesMustBeMediumSuspiciousness() {
		double susp = 0;
		req.setC_e_f(12);
		req.setC_n_f(30);
		req.setC_e_p(20);
		req.setC_n_p(100);
		susp = heur.calculateJaccard(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.193, susp, 0.001);
	}
	
	
	//Zoltar

	@Test
	public void testCalculateZoltarAllCoeficientsZeroMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarANegativeValueInCefMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarAllCoeficientsNegativeMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(-1);
		req.setC_e_p(-1);
		req.setC_n_p(-1);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCefHaveValueMustBeMaxSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCnfHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCepHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCnpHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCefCnfHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCefNotHaveValueMustBeLowSuspicious() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCefCnpHaveValuesMustBeHighSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCepNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCefCepHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCnfNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarAllCoeficientsHaveValueOne() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.00009997, susp, 0.0000001);
	}
	
	@Test
	public void testCalculateZoltarCnpNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.00009997, susp, 0.0000001);
	}
	
	@Test
	public void testCalculateZoltarCefHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(5);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.833, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCepHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(5);
		req.setC_n_p(1);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.0000066663, susp, 0.00000001);
	}
	
	@Test
	public void testCalculateZoltarAllCoeficientsHaveEqualValues() {
		double susp = 0;
		req.setC_e_f(2);
		req.setC_n_f(1);
		req.setC_e_p(3);
		req.setC_n_p(2);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.000133, susp, 0.000001);
	}
	
	@Test
	public void testCalculateZoltarCefCnfMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1);
		req.setC_n_p(2);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.00199, susp, 0.00001);
	}
	
	@Test
	public void testCalculateZoltarCepCnpMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(10);
		req.setC_n_p(4);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.0000033332, susp, 0.00000001);
	}
	
	@Test
	public void testCalculateZoltarCefMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.909, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCefMoreExecutedThanCnfCepCnp() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(2);
		req.setC_n_p(1);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.00496, susp, 0.00001);
	}
	
	@Test
	public void testCalculateZoltarCefMoreExecutedThanCep() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(2);
		req.setC_n_p(0);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.833, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCefMoreExecutedThanCep2() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(3);
		req.setC_n_p(0);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.769, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCefCepEqualExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(10);
		req.setC_n_p(0);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCepMoreExecutedThanCef() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(11);
		req.setC_n_p(0);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.476, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCefNotExecuted() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(10);
		req.setC_e_p(10);
		req.setC_n_p(5);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateZoltarCepWithHighValueMustBeLowSuspiciousness() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1000);
		req.setC_n_p(15);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.00000199, susp, 0.00000001);
	}
	
	@Test
	public void testCalculateZoltarCefWithHighVaValueMustBeHighSuspiciousness() {
		double susp = 0;
		req.setC_e_f(100);
		req.setC_n_f(15);
		req.setC_e_p(10);
		req.setC_n_p(500);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.00661, susp, 0.00001);
	}
	
	@Test
	public void testCalculateZoltarCnfCnpWithHighValuesMustBeMediumSuspiciousness() {
		double susp = 0;
		req.setC_e_f(12);
		req.setC_n_f(30);
		req.setC_e_p(20);
		req.setC_n_p(100);
		susp = heur.calculateZoltar(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.00002399, susp, 0.0000001);
	}
	
		
	//Op

	@Test
	public void testCalculateOpAllCoeficientsZeroMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpANegativeValueInCefMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpAllCoeficientsNegativeMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(-1);
		req.setC_e_p(-1);
		req.setC_n_p(-1);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCefHaveValueMustBeMaxSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCnfHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCepHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCnpHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCefCnfHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCefNotHaveValueMustBeLowSuspicious() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.333, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCefCnpHaveValuesMustBeHighSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCepNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCefCepHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCnfNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.666, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpAllCoeficientsHaveValueOne() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.666, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCnpNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCefHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(5);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(5, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCepHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(5);
		req.setC_n_p(1);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.285, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpAllCoeficientsHaveEqualValues() {
		double susp = 0;
		req.setC_e_f(2);
		req.setC_n_f(1);
		req.setC_e_p(3);
		req.setC_n_p(2);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCefCnfMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1);
		req.setC_n_p(2);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(9.75, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCepCnpMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(10);
		req.setC_n_p(4);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.333, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCefMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(10, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCefMoreExecutedThanCnfCepCnp() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(2);
		req.setC_n_p(1);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(9.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCefMoreExecutedThanCep() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(2);
		req.setC_n_p(0);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(9.333, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCefMoreExecutedThanCep2() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(3);
		req.setC_n_p(0);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(9.25, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCefCepEqualExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(10);
		req.setC_n_p(0);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(9.090, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCepMoreExecutedThanCef() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(11);
		req.setC_n_p(0);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(9.083, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCefNotExecuted() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(10);
		req.setC_e_p(10);
		req.setC_n_p(5);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.625, susp, 0.001);
	}

	@Test
	public void testCalculateOpCepWithHighValueMustBeLowSuspiciousness() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1000);
		req.setC_n_p(15);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(9.015, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCefWithHighVaValueMustBeHighSuspiciousness() {
		double susp = 0;
		req.setC_e_f(100);
		req.setC_n_f(15);
		req.setC_e_p(10);
		req.setC_n_p(500);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(99.980, susp, 0.001);
	}
	
	@Test
	public void testCalculateOpCnfCnpWithHighValuesMustBeMediumSuspiciousness() {
		double susp = 0;
		req.setC_e_f(12);
		req.setC_n_f(30);
		req.setC_e_p(20);
		req.setC_n_p(100);
		susp = heur.calculateOp(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(11.834, susp, 0.001);
	}
	
		
	//Minus
	
	@Test
	public void testCalculateMinusAllCoeficientsZeroMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusANegativeValueInCefMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusAllCoeficientsNegativeMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(-1);
		req.setC_e_p(-1);
		req.setC_n_p(-1);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCefHaveValueMustBeMaxSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCnfHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCepHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-1.0, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCnpHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCefCnfHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.666, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCefNotHaveValueMustBeLowSuspicious() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.666, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCefCnpHaveValuesMustBeHighSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCepNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.666, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCefCepHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCnfNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.666, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusAllCoeficientsHaveValueOne() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCnpNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.666, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCefHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(5);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.857, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCepHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(5);
		req.setC_n_p(1);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.587, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusAllCoeficientsHaveEqualValues() {
		double susp = 0;
		req.setC_e_f(2);
		req.setC_n_f(1);
		req.setC_e_p(3);
		req.setC_n_p(2);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.071, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCefCnfMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1);
		req.setC_n_p(2);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.333, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCepCnpMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(10);
		req.setC_n_p(4);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.464, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCefMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.916, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCefMoreExecutedThanCnfCepCnp() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(2);
		req.setC_n_p(1);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.362, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCefMoreExecutedThanCep() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(2);
		req.setC_n_p(0);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCefMoreExecutedThanCep2() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(3);
		req.setC_n_p(0);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCefCepEqualExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(10);
		req.setC_n_p(0);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCepMoreExecutedThanCef() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(11);
		req.setC_n_p(0);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCefNotExecuted() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(10);
		req.setC_e_p(10);
		req.setC_n_p(5);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.75, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCepWithHighValueMustBeLowSuspiciousness() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1000);
		req.setC_n_p(15);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.553, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCefWithHighVaValueMustBeHighSuspiciousness() {
		double susp = 0;
		req.setC_e_f(100);
		req.setC_n_f(15);
		req.setC_e_p(10);
		req.setC_n_p(500);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.860, susp, 0.001);
	}
	
	@Test
	public void testCalculateMinusCnfCnpWithHighValuesMustBeMediumSuspiciousness() {
		double susp = 0;
		req.setC_e_f(12);
		req.setC_n_f(30);
		req.setC_e_p(20);
		req.setC_n_p(100);
		susp = heur.calculateMinus(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.170, susp, 0.001);
	}
	
	
	//Kulczynski2

	@Test
	public void testCalculateKulczynski2AllCoeficientsZeroMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2ANegativeValueInCefMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2AllCoeficientsNegativeMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(-1);
		req.setC_e_p(-1);
		req.setC_n_p(-1);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CefHaveValueMustBeMaxSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CnfHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CepHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CnpHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CefCnfHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.75, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CefNotHaveValueMustBeLowSuspicious() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CefCnpHaveValuesMustBeHighSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CepNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.75, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CefCepHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.75, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CnfNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.75, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2AllCoeficientsHaveValueOne() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CnpNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CefHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(5);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.916, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CepHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(5);
		req.setC_n_p(1);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.208, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2AllCoeficientsHaveEqualValues() {
		double susp = 0;
		req.setC_e_f(2);
		req.setC_n_f(1);
		req.setC_e_p(3);
		req.setC_n_p(2);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.533, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CefCnfMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1);
		req.setC_n_p(2);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.787, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CepCnpMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(10);
		req.setC_n_p(4);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.17, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CefMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.954, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CefMoreExecutedThanCnfCepCnp() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(2);
		req.setC_n_p(1);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.871, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CefMoreExecutedThanCep() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(2);
		req.setC_n_p(0);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.916, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CefMoreExecutedThanCep2() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(3);
		req.setC_n_p(0);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.884, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CefCepEqualExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(10);
		req.setC_n_p(0);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.75, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CepMoreExecutedThanCef() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(11);
		req.setC_n_p(0);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.738, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CefNotExecuted() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(10);
		req.setC_e_p(10);
		req.setC_n_p(5);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CepWithHighValueMustBeLowSuspiciousness() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1000);
		req.setC_n_p(15);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.338, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CefWithHighVaValueMustBeHighSuspiciousness() {
		double susp = 0;
		req.setC_e_f(100);
		req.setC_n_f(15);
		req.setC_e_p(10);
		req.setC_n_p(500);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.889, susp, 0.001);
	}
	
	@Test
	public void testCalculateKulczynski2CnfCnpWithHighValuesMustBeMediumSuspiciousness() {
		double susp = 0;
		req.setC_e_f(12);
		req.setC_n_f(30);
		req.setC_e_p(20);
		req.setC_n_p(100);
		susp = heur.calculateKulczynski2(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.330, susp, 0.001);
	}
	
		
	//McCon

	@Test
	public void testCalculateMcConAllCoeficientsZeroMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConANegativeValueInCefMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConAllCoeficientsNegativeMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(-1);
		req.setC_e_p(-1);
		req.setC_n_p(-1);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCefHaveValueMustBeMaxSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCnfHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCepHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCnpHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCefCnfHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCefNotHaveValueMustBeLowSuspicious() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-1, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCefCnpHaveValuesMustBeHighSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCepNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCefCepHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCnfNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConAllCoeficientsHaveValueOne() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCnpNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCefHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(5);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.833, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCepHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(5);
		req.setC_n_p(1);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.583, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConAllCoeficientsHaveEqualValues() {
		double susp = 0;
		req.setC_e_f(2);
		req.setC_n_f(1);
		req.setC_e_p(3);
		req.setC_n_p(2);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.066, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCefCnfMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1);
		req.setC_n_p(2);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.575, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCepCnpMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(10);
		req.setC_n_p(4);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.659, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCefMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.909, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCefMoreExecutedThanCnfCepCnp() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(2);
		req.setC_n_p(1);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.742, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCefMoreExecutedThanCep() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(2);
		req.setC_n_p(0);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.833, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCefMoreExecutedThanCep2() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(3);
		req.setC_n_p(0);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.769, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCefCepEqualExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(10);
		req.setC_n_p(0);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.5, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCepMoreExecutedThanCef() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(11);
		req.setC_n_p(0);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.476, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCefNotExecuted() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(10);
		req.setC_e_p(10);
		req.setC_n_p(5);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-1, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCepWithHighValueMustBeLowSuspiciousness() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1000);
		req.setC_n_p(15);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.323, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCefWithHighVaValueMustBeHighSuspiciousness() {
		double susp = 0;
		req.setC_e_f(100);
		req.setC_n_f(15);
		req.setC_e_p(10);
		req.setC_n_p(500);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0.778, susp, 0.001);
	}
	
	@Test
	public void testCalculateMcConCnfCnpWithHighValuesMustBeMediumSuspiciousness() {
		double susp = 0;
		req.setC_e_f(12);
		req.setC_n_f(30);
		req.setC_e_p(20);
		req.setC_n_p(100);
		susp = heur.calculateMcCon(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.339, susp, 0.001);
	}
	
	
	//Wong3

	@Test
	public void testCalculateWong3AllCoeficientsZeroMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3ANegativeValueInCefMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-1, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3AllCoeficientsNegativeMustBeZero() {
		double susp = 0;
		req.setC_e_f(-1);
		req.setC_n_f(-1);
		req.setC_e_p(-1);
		req.setC_n_p(-1);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CefHaveValueMustBeMaxSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CnfHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CepHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-1, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CnpHaveValueMustBeZero() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CefCnfHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(0);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CefNotHaveValueMustBeLowSuspicious() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-1, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CefCnpHaveValuesMustBeHighSuspicious() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CepNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(1, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CefCepHaveValues() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CnfNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(0);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3AllCoeficientsHaveValueOne() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(1);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CnpNotHaveValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(1);
		req.setC_e_p(1);
		req.setC_n_p(0);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(0, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CefHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(5);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(5, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CepHaveBiggestValue() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(5);
		req.setC_n_p(1);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-1.3, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3AllCoeficientsHaveEqualValues() {
		double susp = 0;
		req.setC_e_f(2);
		req.setC_n_f(1);
		req.setC_e_p(3);
		req.setC_n_p(2);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-0.1, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CefCnfMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1);
		req.setC_n_p(2);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(9, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CepCnpMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(1);
		req.setC_n_f(3);
		req.setC_e_p(10);
		req.setC_n_p(4);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-1.8, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CefMoreFrequentlyExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(0);
		req.setC_n_p(1);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(10, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CefMoreExecutedThanCnfCepCnp() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(1);
		req.setC_e_p(2);
		req.setC_n_p(1);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(8, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CefMoreExecutedThanCep() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(2);
		req.setC_n_p(0);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(8, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CefMoreExecutedThanCep2() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(3);
		req.setC_n_p(0);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(7.9, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CefCepEqualExecuted() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(10);
		req.setC_n_p(0);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(7.2, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CepMoreExecutedThanCef() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(0);
		req.setC_e_p(11);
		req.setC_n_p(0);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(7.199, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CefNotExecuted() {
		double susp = 0;
		req.setC_e_f(0);
		req.setC_n_f(10);
		req.setC_e_p(10);
		req.setC_n_p(5);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(-2.8, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CepWithHighValueMustBeLowSuspiciousness() {
		double susp = 0;
		req.setC_e_f(10);
		req.setC_n_f(5);
		req.setC_e_p(1000);
		req.setC_n_p(15);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(6.210, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CefWithHighVaValueMustBeHighSuspiciousness() {
		double susp = 0;
		req.setC_e_f(100);
		req.setC_n_f(15);
		req.setC_e_p(10);
		req.setC_n_p(500);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(97.200, susp, 0.001);
	}
	
	@Test
	public void testCalculateWong3CnfCnpWithHighValuesMustBeMediumSuspiciousness() {
		double susp = 0;
		req.setC_e_f(12);
		req.setC_n_f(30);
		req.setC_e_p(20);
		req.setC_n_p(100);
		susp = heur.calculateWong3(req.getC_e_f(),req.getC_n_f(),req.getC_e_p(),req.getC_n_p());
		Assert.assertEquals(9.190, susp, 0.001);
	}

}
