package org.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DataDrivenExample1 extends LibClass {

	public static void main(String[] args) throws IOException, InterruptedException {
		// WebDriverManager.chromedriver().setup();
		// WebDriver driver = new ChromeDriver();
		LibClass lib = new LibClass();
		lib.getOneDriver("chrome");
		String userName = lib.getDataFromExcel(1, 0);
		String password = lib.getDataFromExcel(1, 1);
		String location = lib.getDataFromExcel(1, 2);
		String hotelName = lib.getDataFromExcel(1, 3);
		String roomType = lib.getDataFromExcel(1, 4);
		String roomNo = lib.getDataFromExcel(1, 5);
		String inDate = lib.getDataFromExcel(1, 6);
		String outDate = lib.getDataFromExcel(1, 7);
		String adultNo = lib.getDataFromExcel(1, 8);
		String childrenNo = lib.getDataFromExcel(1, 9);
		String firstName = lib.getDataFromExcel(1, 10);
		String lastName = lib.getDataFromExcel(1, 11);
		String address = lib.getDataFromExcel(1, 12);
		String cardNo = lib.getDataFromExcel(1, 13);
		String cardType = lib.getDataFromExcel(1, 14);
		String cardMonth = lib.getDataFromExcel(1, 15);
		String cardYear = lib.getDataFromExcel(1, 16);
		String cvv = lib.getDataFromExcel(1, 17);
		lib.getUrl("http://adactinhotelapp.com/");
		WebElement txtUsername = driver.findElement(By.id("username"));
		txtUsername.sendKeys(userName);
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys(password);
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		WebElement element = driver.findElement(By.xpath("//select[@id='location']"));
		Select s = new Select(element);
		s.selectByValue(location);
		WebElement hotel = driver.findElement(By.id("hotels"));
		Select s1 = new Select(hotel);
		s1.selectByVisibleText(hotelName);
		WebElement room = driver.findElement(By.id("room_type"));
		Select s2 = new Select(room);
		s2.selectByVisibleText(roomType);
		WebElement noroom = driver.findElement(By.id("room_nos"));
		Select s3 = new Select(noroom);
		s3.selectByValue(roomNo);
		driver.findElement(By.id("datepick_in")).sendKeys(inDate);
		driver.findElement(By.id("datepick_out")).sendKeys(outDate);
		WebElement adult = driver.findElement(By.id("adult_room"));
		Select s4 = new Select(adult);
		s4.selectByVisibleText(adultNo);
		WebElement child = driver.findElement(By.id("child_room"));
		Select s5 = new Select(child);
		s5.selectByVisibleText(childrenNo);
		driver.findElement(By.id("Submit")).click();
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.name("first_name")).sendKeys(firstName);
		driver.findElement(By.name("last_name")).sendKeys(lastName);
		driver.findElement(By.id("address")).sendKeys(address);
		driver.findElement(By.id("cc_num")).sendKeys(cardNo);
		WebElement credit = driver.findElement(By.id("cc_type"));
		Select s6 = new Select(credit);
		s6.selectByVisibleText(cardType);
		WebElement month = driver.findElement(By.id("cc_exp_month"));
		Select s7 = new Select(month);
		s7.selectByVisibleText(cardMonth);
		WebElement year = driver.findElement(By.id("cc_exp_year"));
		Select s8 = new Select(year);
		s8.selectByVisibleText(cardYear);
		driver.findElement(By.id("cc_cvv")).sendKeys(cvv);
		driver.findElement(By.id("book_now")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("my_itinerary")).click();
		Thread.sleep(5000);

		List<WebElement> findElements = driver.findElements(By.xpath("//*[contains(@id,'order_id_')]"));
		String OrderId = "";
		for (int i = findElements.size() - 1; i > 0; i--) {
			String oId = findElements.get(i).getAttribute("value");
			OrderId = oId;
			break;
		}
		System.out.println(OrderId);
		lib.writeDataToExcel(0, 0, OrderId);

	}

}
