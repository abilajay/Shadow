package org.automation;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.baseclass.BaseClass;

public class Automation extends BaseClass {
	public static void main(String[] args) throws IOException, AWTException, InterruptedException{
		chromeDriverMng();
		launchUrl("http://adactinhotelapp.com/");
		maximize();
		String username = readFromExcel("Sheet1", 1, 0);
		String password = readFromExcel("Sheet1", 1, 1);
		String cindate = readFromExcel("Sheet1", 1, 2);
		String coutdate = readFromExcel("Sheet1", 1, 3);
		String firstname = readFromExcel("Sheet1", 1, 4);
		String lastname = readFromExcel("Sheet1", 1, 5);
		String billingadd = readFromExcel("Sheet1", 1, 6);
		String cardno = readFromExcel("Sheet1", 1, 7);
		String ccv = readFromExcel("Sheet1", 1, 8);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		WebElement locationdd = driver.findElement(By.id("location"));
		selectDropDown(locationdd, "London");
		WebElement hoteldd = driver.findElement(By.id("hotels"));
		selectDropDown(hoteldd, "Hotel Sunshine");
		WebElement roomdd = driver.findElement(By.id("room_type"));
		selectDropDown(roomdd, "Double");
		WebElement roomnodd = driver.findElement(By.id("room_nos"));
		selectDropDown(roomnodd, "5 - Five");
		WebElement adult_room = driver.findElement(By.id("adult_room"));
		selectDropDown(adult_room, "2 - Two");
		WebElement child_room = driver.findElement(By.id("child_room"));
		selectDropDown(child_room, "2 - Two");
		WebElement element = driver.findElement(By.id("datepick_in"));
		ctrlAllDel(element);
		element.sendKeys(cindate);
		WebElement element2 = driver.findElement(By.id("datepick_out"));
		ctrlAllDel(element2);
		element2.sendKeys(coutdate);
		driver.findElement(By.id("Submit")).click();
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("first_name")).sendKeys(firstname);
		driver.findElement(By.id("last_name")).sendKeys(lastname);
		driver.findElement(By.id("address")).sendKeys(billingadd);
		driver.findElement(By.id("cc_num")).sendKeys(cardno);
		driver.findElement(By.id("cc_cvv")).sendKeys(ccv);
		WebElement element3 = driver.findElement(By.id("cc_type"));
		selectDropDown(element3, "VISA");
		WebElement element4 = driver.findElement(By.id("cc_exp_month"));
		selectDropDown(element4, "April");
		WebElement element5 = driver.findElement(By.id("cc_exp_year"));
		selectDropDown(element5, "2022");
		driver.findElement(By.id("book_now")).click();
	}
}
