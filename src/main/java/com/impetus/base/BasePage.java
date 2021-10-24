package com.impetus.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.impetus.utils.Timeout;

public class BasePage {

	public enum Browser
	{
		Edge
	}
	public static WebDriver driver;
	public static Properties prop;
	
	public BasePage()
	{
		try 
		{
			prop=new Properties();
			FileInputStream fs=new FileInputStream("./src/main/java/com/impetus/config/config.properties");
			prop.load(fs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
	public static void initialization()
	{
		System.setProperty("webdriver.edge.driver",prop.getProperty("edgeDriverPath"));
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Timeout.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Timeout.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
}
