package com.impetus.pages;

import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Min;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.inject.Key;
import com.impetus.base.BasePage;
import com.impetus.utils.ElementUtil;
import com.impetus.utils.Timeout;

public class AdminPage extends BasePage{

	@FindBy(xpath="//a[text()='Careers']")
	WebElement btnCareers;
	
	@FindBy(xpath="//div[text()='Browse all jobs']")
	WebElement btnBrowseAllJobs;
	
	@FindBy(xpath="//p[contains(text(),'Current Openings found')]")
	WebElement lblCurrentOpenings;
	
	@FindBy(xpath="//input[@name='expFrom']")
	WebElement inputMinExp;
	
	@FindBy(xpath="//input[@name='expTo']")
	WebElement inputMaxExp;
	
	@FindBy(xpath="//input[@name='keyword']")
	WebElement inputKeyword;
	
	@FindBy(xpath="//img[@class='search-svg']")
	WebElement btnSearch;
	
	@FindBy(xpath="//input[@name='fileUpload']")
	WebElement btnUploadResume;
	
	@FindBy(xpath="//label[contains(text(),'Qualification')]")
	WebElement lblQualification;
	
	ElementUtil elementUtil;
	public String text;
	
	public AdminPage()
	{
		PageFactory.initElements(driver, this);
		elementUtil=new ElementUtil(driver);
	}
	public String test01(String Min_Exp, String Max_Exp, String Country,String Keyword, String JobTitle) throws InterruptedException 
	{
		//elementUtil.waitForElementToBeVisible(btnCareers);
		driver.manage().timeouts().implicitlyWait(Timeout.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnCareers);
		driver.manage().timeouts().implicitlyWait(Timeout.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("arguments[0].click();", btnCareers);
		driver.manage().timeouts().implicitlyWait(Timeout.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		elementUtil.waitForElementToBeVisible(btnBrowseAllJobs);
		btnBrowseAllJobs.click();
		Thread.sleep(5000);
		js.executeScript("arguments[0].scrollIntoView();", lblCurrentOpenings);
		elementUtil.waitForElementToBeVisible(lblCurrentOpenings);
		inputMinExp.sendKeys(Min_Exp.subSequence(0, Min_Exp.indexOf(".")));
		inputMaxExp.sendKeys(Max_Exp.subSequence(0, Max_Exp.indexOf(".")));
		driver.findElement(By.xpath("//input[@id='Country_"+Country+"']")).click();
		js.executeScript("arguments[0].scrollIntoView();", inputKeyword);
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Timeout.IMPLICIT_WAIT, TimeUnit.SECONDS);
		js.executeScript("arguments[0].click();", inputKeyword);
		inputKeyword.sendKeys(Keyword);
		driver.manage().timeouts().implicitlyWait(Timeout.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		js.executeScript("arguments[0].click();", btnSearch);
		Thread.sleep(3000);
		WebElement lblJobTitle= driver.findElement(By.xpath("//h3[contains(text(),'"+JobTitle+"')]"));
		elementUtil.waitForElementToBeVisible(lblJobTitle);
		driver.findElement(By.xpath("//h3[contains(text(),'Automation Test Engineer')]//parent::div//parent::div/div[4]/div[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(Timeout.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Thread.sleep(3000);
		elementUtil.waitForElementToBeVisible(lblQualification);
		driver.findElement(By.linkText("Apply")).click();
		Thread.sleep(3000);
		System.out.println("HEY1");
		elementUtil.waitForElementToBeVisible(btnUploadResume);
		System.out.println("HEY2");
		btnUploadResume.click();
		System.out.println("HEY3");
		Thread.sleep(3000);
		btnUploadResume.sendKeys("C:\\Users\\user\\Desktop\\Andalib Sheikh_Resume_October2021.pdf");
		Thread.sleep(5000);
		text="Success";
		return text;
	}
}
