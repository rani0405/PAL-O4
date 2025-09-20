package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenStudentFormTests {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:automation-practice-form");

	}
	@DataProvider(name="Studentdata")
	public Object[][]getStudentData(){
		return new Object[][] {
			{"John","Doe","jonh@gmail.com","Male","938541000"},
			{"Alice","kaush","a@gmail.com","Female","98541000"}
		};
	}
	@Test(dataProvider="Studentdata")
	public void testStudent(String FirstName,String lastName,String email,String gender,String mobile) {
		driver.findElement(By.id("FirstName")).clear();
		driver.findElement(By.id("FirstName")).sendKeys(FirstName);
		
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		
		driver.findElement(By.id("gender")).clear();
		driver.findElement(By.id("gender")).sendKeys(gender);
		
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys(mobile);
		
		driver.findElement(By.id("Submit")).click();
		String studentName=driver.findElement(By.xpath("studentName")).getText();
		String StudentEmail=driver.findElement(By.xpath("studentEmail")).getText();
		
		Assert.assertEquals(studentName, FirstName+" "+lastName);
		Assert.assertEquals(StudentEmail,email);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
