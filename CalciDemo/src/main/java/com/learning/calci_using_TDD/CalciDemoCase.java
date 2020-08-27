package com.learning.calci_using_TDD;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalciDemoCase {

	ICalci iCalci = new CalciImp();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {	
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("TearDown Class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("SetUp Method");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("TearDown Method");
	}

	@Test
	public void test() {
		assertEquals(34,iCalci.add(17, 17));
		assertEquals(3,iCalci.divide(9,3));
		assertEquals(12, iCalci.multipy(3,4));
		assertEquals(3,iCalci.sub(5,2));
		
	}
	
	

}
