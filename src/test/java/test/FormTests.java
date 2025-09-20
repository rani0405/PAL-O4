package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTests {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://demoqa.com/");
	}
	@Test(groups= {"smoke"})
	public void FormSubmission() {
		driver.get("https://demoqa.com/text-box");
		driver.findElement(By.id("firstName")).sendKeys("Rani");
		driver.findElement(By.id("userEmail")).sendKeys("r@gmail.com");
		driver.findElement(By.id("submit"));
		
		WebElement nameout=driver.findElement(By.id("Name"));
		WebElement emailout=driver.findElement(By.id("Email"));
		
		Assert.assertTrue(nameout.getText().contains("Rani"));
		Assert.assertTrue(emailout.getText().contains("r@gmail.com"));
		
		
	}
	@Test(groups= {"regression"})
	public void checkBox() {
		driver.get("https://demoqa.com/checkbox");
		WebElement expandBtn=driver.findElement(By.cssSelector("ol[title='Toggle']"));
		expandBtn.click();
		
		WebElement doccheckBox=driver.findElement(By.cssSelector("label[for='tree-node-deskttop'] span.rct-"));
		doccheckBox.click();
		
		WebElement result=driver.findElement(By.id("result"));
		Assert.assertTrue(result.getText().contains("desktop"));
	}
	//2.handling ui
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
