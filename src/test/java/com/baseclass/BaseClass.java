package com.baseclass;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.auto.common.Visibility;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	public static WebDriver driver;
	public static Actions action;
	public static Robot robot;
	public static Select select;
	
	public static void launchUrl(String ulr) {
		driver.get(ulr);
		
	}
	public static void printUlr() {
		
		System.out.println(driver.getCurrentUrl());

	}
	public static void printTitle() {
		
		System.out.println(driver.getTitle());

	}
	public static void maximize() {
		driver.manage().window().maximize();

	}
	public static void hold(int sec) throws InterruptedException {
		Thread.sleep(sec);

	}
	public static void pointOnElement(WebElement element) {
		action = new Actions(driver);
        action.moveToElement(element).perform();
        

	}
	public static void robotKey(int key) throws AWTException {
		robot = new Robot();
		robot.keyPress(key);
		robot.keyRelease(key);
		
		

	}
	public static void copy(int key, String text) throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
	}
	
	
	public static void paste() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
	}
	
	
	public static void selectAll() throws AWTException {
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);
	}
	
	
	public static void fill(WebElement element, String text) {
		action = new Actions(driver);
		action.sendKeys(element, text).perform();
	}
	
	
	public static void doubleClick(WebElement element) {
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}
	
	
	public static void fill(String text) {
		action = new Actions(driver);
		action.sendKeys(text).perform();
	}
	
	
	public static void pageRefresh() {
		driver.navigate().refresh();	
	}
	
	
	public static void dragAndDrop(WebElement dragElement, WebElement dropElemnt) {
		action = new Actions(driver);
		action.dragAndDrop(dragElement, dropElemnt).perform();
	}
	
	
	public static void rightClick() {
		action = new Actions(driver);
		action.contextClick().perform();
	}
	
	
	public static void jsSendKeys(WebElement element ,String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String command = String.format("arguments[0].setAttribute('value','%s')", text);
		js.executeScript(command, element);
	}
	
	
	public static void selectDropDown(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}
	
	public static void selectDropDown(String value, WebElement element) {
		select = new Select(element);
		select.selectByValue(value);
	}
	
	public static boolean dopeDownIsMultiple(WebElement element) {
		select = new Select(element);
		return select.isMultiple();
	}
	
	public static void selectDropDown(WebElement element, String visible_text) {
		Select dd = new Select(element);
		dd.selectByVisibleText(visible_text);
	}
	
	
	
	
	
	public static void ctrlAllDel(WebElement mask) throws AWTException {
		mask.sendKeys("");
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyPress(KeyEvent.VK_DELETE);
	}
	public static void chromeDriverMng() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	public static void takeScreenShot(String fileName) throws IOException {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File screenshot = sc.getScreenshotAs(OutputType.FILE);
		File location = new File("C:\\Users\\abila\\eclipse-workspace\\MavenProject\\screenshot\\"+fileName+".png");
		FileUtils.copyFile(screenshot, location);
	}
	
	public static String readFromExcel(String sheetname,int rowNo, int cellNo) throws IOException {
		File location = new File("C:\\Users\\abila\\eclipse-workspace\\MavenProject\\excel\\testdata.xlsx");
		FileInputStream fin = new FileInputStream(location);
		Workbook book = new XSSFWorkbook(fin);
		Sheet sheet = book.getSheet(sheetname);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int cellType = cell.getCellType();
		String name = "";
		if (cellType == 1) {
			name = cell.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			SimpleDateFormat form = new SimpleDateFormat("dd/MM/YYYY");
			name = form.format(date);
			
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l =(long)numericCellValue;
			name = String.valueOf(l);
		}
		return name;
	}
	
	public static void takeFullScreenShot(String fileName) throws AWTException, IOException {
		robot = new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rec = new Rectangle(screenSize);
		BufferedImage screenshot = robot.createScreenCapture(rec);
		File location = new File("C:\\Users\\abila\\eclipse-workspace\\MavenProject\\screenshot\\"+fileName+".png");
		ImageIO.write(screenshot, "png", location);
	}
	
	

}


