package org.automation;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;


public class AtactinAutomation extends BaseClass {
	public static int i = 0;
	public static int j = 0;
	
	@BeforeClass
	private void oneTime() {
		chromeDriverMng();
		launchUrl("http://adactinhotelapp.com/");
		maximize();
	}
	@AfterClass
	private void end() {
		System.out.println("Check it");
	}
	
	
	@Test
	private void tc1() {
		AtactinPojoClassPage ata = new AtactinPojoClassPage();
		ata.getUser().sendKeys("Abilajay");
		ata.getPass().sendKeys("abilajay");
		ata.getBtnLogin().click();
	}
	
	@Test
	private void tc2() throws AWTException {
		AtactinPojoClassPage2 ata2 = new AtactinPojoClassPage2();
		selectDropDown(ata2.getLocationDrd(), "London");
		selectDropDown(ata2.getHotelDrd(), "Hotel Sunshine");
		selectDropDown(ata2.getRoomTypeDrd(), "Double");
		selectDropDown(ata2.getRoomNumDrd(), "2 - Two");
		selectDropDown(ata2.getAdultRoomDrd(), "2 - Two");
		selectDropDown(ata2.getChildRoomDrd(), "2 - Two");
		
		jsSendKeys(ata2.getDatePickIn(), "18/04/2021");
		ctrlAllDel(ata2.getDatePickOut());
		ata2.getDatePickOut().sendKeys("21/04/2021");
		ata2.getSearch().click();
	}
	
	@Test
	private void tc3() {
		AtactinPojoClassPage3 ata3 = new AtactinPojoClassPage3();
		ata3.getRadio().click();
		ata3.getContinueBtn().click();
	}
	
	@Test
	private void tc4() throws InterruptedException {
		
		AtactinPojoClassPage4 ata4 = new AtactinPojoClassPage4();
		ata4.getFirstName().sendKeys("abil");
		ata4.getLastName().sendKeys("ajay");
		ata4.getAddress().sendKeys("Chennai-600 100");
		ata4.getCardNumber().sendKeys("1234567890123456");
		ata4.getCcvNumber().sendKeys("466");
		selectDropDown(ata4.getCardTypeDrd(), "VISA");
		selectDropDown(ata4.getCardExpMonthDrd(), "April");
		selectDropDown(ata4.getCardExpYearDrd(), "2022");
		ata4.getBookNowBtn().click();
		Thread.sleep(5000);
	}
	
	@Test
	private void tc5() {
		AtactinPojoClassPage5 ata5 = new AtactinPojoClassPage5();
		String orderNo = ata5.getOrderNumber().getAttribute("value");
		System.out.println(orderNo);
	}

	
	@BeforeMethod
	private void beforeScreenShot() throws IOException {
		takeScreenShot("screenshotb"+i+"");
		i++;
	}
	
	@AfterMethod
	private void AfterScreenShot() throws IOException {
		takeScreenShot("screenshota"+j+"");
		j++;
	}
	

}
