package org.automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class AtactinPojoClassPage5 extends BaseClass{
	
	public AtactinPojoClassPage5() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="order_no")
	private WebElement orderNumber;

	public WebElement getOrderNumber() {
		return orderNumber;
	}

}
