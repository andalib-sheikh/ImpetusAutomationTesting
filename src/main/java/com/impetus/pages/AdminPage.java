package com.impetus.pages;

import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Min;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(xpath="//label[@for='fileUpload']")
	WebElement lblUploadResume;
	
	@FindBy(xpath="//input[@name='fileUpload']")
	WebElement btnUploadResume;
	
	@FindBy(xpath="//label[contains(text(),'Qualification')]")
	WebElement lblQualification;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement inputFirstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement inputLastName;
	
	@FindBy(xpath="//input[@name='emailId']")
	WebElement inputEmailAddress;
	
	@FindBy(xpath="//input[@name='phoneNo']")
	WebElement inputPhoneNo;
	
	@FindBy(xpath="//input[@name='location']")
	WebElement inputLocation;
	
	@FindBy(xpath="//input[@name='currentCtc']")
	WebElement inputCurrentCTC;
	
	@FindBy(xpath="//input[@name='expectedCtc']")
	WebElement inputExpectedCTC;

	@FindBy(xpath="//input[@name='primaryskills']")
	WebElement inputPrimarySkills;
	
	@FindBy(xpath="//input[@name='secondaryskills']")
	WebElement inputSecondarySkills;	
	
	@FindBy(xpath="//input[@name='noticedPeriod']")
	WebElement inputNoticePeriod;	
	
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	WebElement divCaptcha;
	
	
	ElementUtil elementUtil;
	public String text;
	
	public AdminPage()
	{
		PageFactory.initElements(driver, this);
		elementUtil=new ElementUtil(driver);
	}
	public String test01(String Min_Exp, String Max_Exp, String Country, String Keyword, String JobTitle,
			String FirstName, String LastName, String EmailAddress, String PhoneNo, String CurrentLocation, String PreferredLocation,
			String CurrentCTC, String ExpectedCTC, String PrimarySkills, String SecondarySkills, String NoticePeriod) throws InterruptedException 
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
		//elementUtil.waitForElementToBeVisible(lblCurrentOpenings);
		//js.executeScript("arguments[0].scrollIntoView();", lblCurrentOpenings);
		//elementUtil.waitForElementToBeVisible(lblCurrentOpenings);
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
		elementUtil.waitForElementToBeVisible(lblUploadResume);
		Thread.sleep(2000);
		((RemoteWebElement)btnUploadResume).setFileDetector(new LocalFileDetector());
		String filePath = "C:\Users\user\Desktop\Andalib Sheikh_Resume_October2021.pdf"; 
		btnUploadResume.sendKeys(filePath);
		Thread.sleep(3000);
		inputFirstName.clear();
		inputFirstName.sendKeys(FirstName);
		inputLastName.clear();
		inputLastName.sendKeys(LastName);
		inputEmailAddress.clear();
		inputEmailAddress.sendKeys(EmailAddress);
		inputPhoneNo.clear();
		PhoneNo=PhoneNo.substring(0,PhoneNo.indexOf("."))+PhoneNo.substring(PhoneNo.indexOf(".")+1,PhoneNo.indexOf("E"));
		System.out.print(PhoneNo);
		inputPhoneNo.sendKeys(PhoneNo);
		inputLocation.sendKeys(CurrentLocation);
		
		inputCurrentCTC.sendKeys(CurrentCTC.subSequence(0, CurrentCTC.indexOf(".")));
		inputExpectedCTC.sendKeys(ExpectedCTC.subSequence(0, ExpectedCTC.indexOf(".")));
		Select selectJoiningLocation = new Select(driver.findElement(By.id("joininglocation")));
		selectJoiningLocation.selectByValue(PreferredLocation);
		
		inputPrimarySkills.sendKeys(PrimarySkills);
		inputSecondarySkills.sendKeys(SecondarySkills);
		inputNoticePeriod.sendKeys(NoticePeriod.subSequence(0, NoticePeriod.indexOf(".")));
		
		Thread.sleep(4000);
		text="Success";
		return text;
	}
}
