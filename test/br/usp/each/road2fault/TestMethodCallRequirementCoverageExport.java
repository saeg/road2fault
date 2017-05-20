package br.usp.each.road2fault;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.usp.each.opal.requirement.RequirementType;
import br.usp.each.saeg.road2fault.HeuristicType;
import br.usp.each.saeg.road2fault.MethodCallTripleRequirementCoverage;
import br.usp.each.saeg.road2fault.MethodCallTripleRequirementCoverageExport;

public class TestMethodCallRequirementCoverageExport {

	RequirementType rType;
	HeuristicType hType;
	File f;
	MethodCallTripleRequirementCoverageExport export = new MethodCallTripleRequirementCoverageExport(new ArrayList<MethodCallTripleRequirementCoverage>(),rType,hType,f); 
	
	@Test
	public void testFormatSignatureInt() {
		assertEquals("(String,int)",export.formatSignature("(Ljava/lang/String;I)"));
	}
	
	@Test
	public void testFormatSignatureDouble() {
		assertEquals("(String,double)",export.formatSignature("(Ljava/lang/String;D)"));
	}

	@Test
	public void testFormatSignatureFloat() {
		assertEquals("(String,float)",export.formatSignature("(Ljava/lang/String;F)"));
	}

	@Test
	public void testFormatSignatureBoolean() {
		assertEquals("(String,boolean)",export.formatSignature("(Ljava/lang/String;Z)"));
	}

	@Test
	public void testFormatSignatureByte() {
		assertEquals("(String,byte)",export.formatSignature("(Ljava/lang/String;B)"));
	}

	@Test
	public void testFormatSignatureChar() {
		assertEquals("(String,char)",export.formatSignature("(Ljava/lang/String;C)"));
	}

	@Test
	public void testFormatSignatureShort() {
		assertEquals("(String,short)",export.formatSignature("(Ljava/lang/String;S)"));
	}

	@Test
	public void testFormatSignatureLong() {
		assertEquals("(String,long)",export.formatSignature("(Ljava/lang/String;J)"));
	}

	@Test
	public void testFormatSignatureString() {
		assertEquals("(int,String,char,String)",export.formatSignature("(ILjava/lang/String;CLjava/lang/String;)"));
	}

	@Test
	public void testFormatSignatureJustInt() {
		assertEquals("(int)",export.formatSignature("(I)"));
	}
	
	@Test
	public void testFormatSignatureSeveralPrimitives() {
		assertEquals("(int,char,boolean)",export.formatSignature("(ICZ)"));
	}

	@Test
	public void testFormatSignatureSeveralParameters() {
		assertEquals("(int,String,char,boolean,String,int,char,boolean)",export.formatSignature("(ILjava/lang/String;CZLjava/lang/String;ICZ)"));
	}
	
	@Test
	public void testFormatSignatureEmpty() {
		assertEquals("()",export.formatSignature("()"));
	}
	
	@Test
	public void testFormatSignatureArray() {
		assertEquals("(int,String[],String,int[])",export.formatSignature("(I[Ljava/lang/String;Ljava/lang/String;[I)"));
	}
	

}
