package org.automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class AtactinPojoClassPage3 extends BaseClass {
	
	public AtactinPojoClassPage3() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="radiobutton_0")
	private WebElement radio;
	@FindBy(id="continue")
	private WebElement continueBtn;
	
	public WebElement getRadio() {
		return radio;
	}
	public WebElement getContinueBtn() {
		return continueBtn;
	}
	
	

}
