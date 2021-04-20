package org.automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class AtactinPojoClassPage extends BaseClass {
	
	public AtactinPojoClassPage() {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	private WebElement user;
	@FindBy(id="password")
	private WebElement pass;
	@FindBy(id="login")
	private WebElement btnLogin;
	
	
	public WebElement getUser() {
		return user;
	}
	public WebElement getPass() {
		return pass;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}

}

