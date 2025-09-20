package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InteractionTests {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://demoqa.com/");

	}
	@Test
	public void handlingAlert() {
		driver.get("https://demoqa.com/alerts");
		WebElement confirmBtn=driver.findElement(By.id("confirmButton"));
		confirmBtn.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		WebElement confirmMsg=driver.findElement(By.id("confirmResult"));
		Assert.assertTrue(confirmMsg.getText().contains("You selected Ok"));
		
		
	}
	@Test
	public void handlingIfranes() {
		driver.get("https://demoqa.com/frames");
		driver.switchTo().frame("frame1");
		
		WebElement heading=driver.findElement(By.id("frame1Wrapper"));
		String headlingText=heading.getText();
		
		Assert.assertEquals(heading,"This is a sample page");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
