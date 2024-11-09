package com.nt.testPTR;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.nt.service.BankService;

public class AppTest 
{
	private static BankService bs;
	@BeforeAll
	public static void setupOnce()
	{
		bs=new BankService();
	}
	@Test
    public void shouldAnswerWithTrue() 
    {
        assertTrue(true);
    }
	@Test
	public void testcalPTRWithSmallValues()
	{
		double expected=(24000.0);
		double actual=bs.calculateSimpleIntrest(100000.0, 2.0, 12.0);
		assertEquals(expected, actual,0.5);
	}
	@Test
	public void testcalPTRWithBigValues()
	{
		double expected=(2400000.0);
		double actual=bs.calculateSimpleIntrest(10000000.0, 2.0, 12.0);
		assertEquals(expected, actual,1.0);
	}
	@Test
	public void testcalPTRWithInvalidValues()
	{
		assertThrows(IllegalArgumentException.class, ()->{bs.calculateSimpleIntrest(0, 2.0, 12.0);});
	}	
	@Test
	public void testcalPTRWithTimer()
	{
		assertTimeout(Duration.ofMillis(6000), ()->{bs.calculateSimpleIntrest(10000000.0, 2.0, 12.0);});
	}
	
	@Test
	public void testIsPallendromWithValid()
	{
		assertTrue(bs.isPallendrome("madam"));
	}
	@Test
	public void testIsPallendromWithInvalid()
	{
		assertFalse(bs.isPallendrome("madam1"));
	}
	@Test
	public void testIsPallendromWithNoInputs()
	{
		assertThrows(IllegalArgumentException.class,()->{bs.isPallendrome("");});
	}
	@AfterAll
	public static void teardownAll()
	{
		bs=null;
	}
    
}
