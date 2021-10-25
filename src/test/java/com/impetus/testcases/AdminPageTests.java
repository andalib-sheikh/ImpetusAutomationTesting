package com.impetus.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.impetus.base.BasePage;
import com.impetus.pages.AdminPage;
import com.impetus.utils.ReadExcel;

public class AdminPageTests extends BasePage{
	
	AdminPage adminPage;

	public AdminPageTests() {
		super();
	}
	
	@BeforeClass
	public void setup() throws Exception{
		try {
			initialization();
			adminPage=new AdminPage();
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	@AfterClass
	public void tearDown() {
		try {
			Thread.sleep(3000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		driver.quit();
	}
	
	@Test(priority=1, dataProvider="getTest01Data", enabled=true)
	public void test01(String Min_Exp, String Max_Exp, String Country, String Keyword, String JobTitle,
			String FirstName, String LastName, String EmailAddress, String PhoneNo, String CurrentLocation, String PreferredLocation,
			String CurrentCTC, String ExpectedCTC, String PrimarySkills, String SecondarySkills, String NoticePeriod) throws Exception
	{
		try {
		adminPage.test01(Min_Exp, Max_Exp, Country, Keyword, JobTitle, FirstName, LastName, EmailAddress, PhoneNo, CurrentLocation, PreferredLocation,
			 CurrentCTC, ExpectedCTC, PrimarySkills, SecondarySkills, NoticePeriod);
		Assert.assertEquals(adminPage.text, "Success");
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	@DataProvider
	 public static Object[][] getTest01Data()
	 {
	 	Object data[][] =  ReadExcel.getTestData("test01");
	 	return data;
	 }
}