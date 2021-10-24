package com.impetus.pages;

import org.openqa.selenium.support.PageFactory;

import com.impetus.base.BasePage;
import com.impetus.utils.ElementUtil;

public class LoginPage extends BasePage {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AdminPage Login() throws Exception
	{
		try {
			ElementUtil elementUtil=new ElementUtil(driver);
			return new AdminPage();
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
