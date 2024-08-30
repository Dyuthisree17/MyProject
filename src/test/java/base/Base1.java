package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base1 
{
	public WebDriver driver;
	String baseurl = "https://staybloom.com/";

	
	@BeforeTest
	public void setup()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-cookies");
		driver =new ChromeDriver(options);
	}
	@BeforeMethod
	public void set()
	{
		driver.get(baseurl);
		//driver.manage().window().maximize();
	}
	@AfterMethod
	public void aftermethod() throws IOException
	{
			
		System.out.println("Test Done!!!");
		
	}
	@AfterTest
	public void teardown()
	{
		//driver.quit();
	}
}
