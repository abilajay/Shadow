package org.automation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class AtactinPojoClassPage4 extends BaseClass {
	
	public AtactinPojoClassPage4() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	private WebElement firstName;
	@FindBy(id="last_name")
	private WebElement lastName;
	@FindBy(id="address")
	private WebElement address;
	@FindBy(id="cc_num")
	private WebElement cardNumber;
	@FindBy(id="cc_cvv")
	private WebElement ccvNumber;
	@FindBy(id="cc_type")
	private WebElement cardTypeDrd;
	@FindBy(id= "cc_exp_month")
	private WebElement cardExpMonthDrd;
	@FindBy(id="cc_exp_year")
	private WebElement cardExpYearDrd;
	@FindBy(id="book_now")
	private WebElement bookNowBtn;
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getCardNumber() {
		return cardNumber;
	}
	public WebElement getCcvNumber() {
		return ccvNumber;
	}
	public WebElement getCardTypeDrd() {
		return cardTypeDrd;
	}
	public WebElement getCardExpMonthDrd() {
		return cardExpMonthDrd;
	}
	public WebElement getCardExpYearDrd() {
		return cardExpYearDrd;
	}
	public WebElement getBookNowBtn() {
		return bookNowBtn;
	}
	
	
	
	

}
