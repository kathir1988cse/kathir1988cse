package org.excel;

import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JunitExample extends LibClass {
	static LibClass lib;

	@BeforeClass
	public static void browserLaunch() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://adactinhotelapp.com/");

		System.out.println("Before Lanuch");
	}

	@AfterClass
	public static void closeBrowser() {
		driver.close();
		System.out.println("Close Browser");

	}

	@Rule
	public TestName test = new TestName();

	@Test
	public void tc_Adactin_001() throws InterruptedException, IOException {
		Thread.sleep(3000);
		String userName = getDataFromExcel(1, 0);
		String password = getDataFromExcel(1, 1);

		WebElement txtUsername = driver.findElement(By.id("username"));
		txtUsername.sendKeys(userName);
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys(password);
		String methodName = test.getMethodName();
		getScreenshot(methodName);
	}

	@Test
	public void tc_Adactin_002() throws IOException, InterruptedException {
		
		String location = getDataFromExcel(1, 2);
		String hotelName = getDataFromExcel(1, 3);
		String roomType = getDataFromExcel(1, 4);
		String roomNo = getDataFromExcel(1, 5);
		String inDate = getDataFromExcel(1, 6);
		String outDate = getDataFromExcel(1, 7);
		String adultNo = getDataFromExcel(1, 8);
		String childrenNo = getDataFromExcel(1, 9);

		WebElement login = driver.findElement(By.id("login"));
		login.click();
		System.out.println("Entering Hotel Page");
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
		String methodName = test.getMethodName();
		getScreenshot(methodName);
	}

	@Test
	public void tc_Adactin_003() throws IOException {

		driver.findElement(By.id("Submit")).click();
		System.out.println("Entering confirm hotel stage");
		driver.findElement(By.id("radiobutton_0")).click();
		String methodName = test.getMethodName();
		getScreenshot(methodName);

	}

	@Test
	public void tc_Adactin_004() throws IOException {

		String firstName = getDataFromExcel(1, 10);
		String lastName = getDataFromExcel(1, 11);
		String address = getDataFromExcel(1, 12);
		String cardNo = getDataFromExcel(1, 13);
		String cardType = getDataFromExcel(1, 14);
		String cardMonth = getDataFromExcel(1, 15);
		String cardYear = getDataFromExcel(1, 16);
		String cvv = getDataFromExcel(1, 17);
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
		String methodName = test.getMethodName();
		getScreenshot(methodName);
		driver.findElement(By.id("book_now")).click();
	}
	
	
	@Test
	public void tc_Adactin_005() throws InterruptedException, IOException {
		System.out.println("Final Stage111");	
		System.out.println("Final Stage");
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
		String methodName = test.getMethodName();
		getScreenshot(methodName);

		System.out.println(OrderId);

	}

	

}
