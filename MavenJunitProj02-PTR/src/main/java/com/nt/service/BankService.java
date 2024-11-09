package com.nt.service;

public class BankService 
{
	public double calculateSimpleIntrest(double amt,double rate,double time)
	{
		System.out.println("BankService.calculateSimpleIntrest()");
		if(amt<=0||rate<=0||time<=0)		
			throw new IllegalArgumentException();
		try {
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return amt*rate*time/100.0;
	}
	public boolean isPallendrome(String str)
	{
		if(str==null||str.length()==0||str.equalsIgnoreCase(""))
			throw new IllegalArgumentException("Invalid Input");
		
		String reverse=new StringBuilder(str).reverse().toString();
		if(str.equalsIgnoreCase(reverse))			
			return true;
		else
			return	false;
	}
}
