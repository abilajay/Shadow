package org.automation;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class AtactinPojoClassPage2 extends BaseClass {
	
	public AtactinPojoClassPage2() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="location")
	private WebElement locationDrd;
	@FindBy(id="hotels")
	private WebElement hotelDrd;
	@FindBy(id="room_type")
	private WebElement roomTypeDrd;
	@FindBy(id="room_nos")
	private WebElement roomNumDrd;
	@FindBy(id="adult_room")
	private WebElement adultRoomDrd;
	@FindBy(id="child_room")
	private WebElement childRoomDrd;
	@FindBy(id="datepick_in")
	private WebElement datePickIn;
	@FindBy(id="datepick_out")
	private WebElement datePickOut;
	@FindBy(id="Submit")
	private WebElement search;
	
	public WebElement getLocationDrd() {
		return locationDrd;
	}
	public WebElement getHotelDrd() {
		return hotelDrd;
	}
	public WebElement getRoomTypeDrd() {
		return roomTypeDrd;
	}
	public WebElement getRoomNumDrd() {
		return roomNumDrd;
	}
	public WebElement getAdultRoomDrd() {
		return adultRoomDrd;
	}
	public WebElement getChildRoomDrd() {
		return childRoomDrd;
	}
	public WebElement getDatePickIn() {
		return datePickIn;
	}
	public WebElement getDatePickOut() {
		return datePickOut;
	}
	public WebElement getSearch() {
		return search;
	}
	
	

}
