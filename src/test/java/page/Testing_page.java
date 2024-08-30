package page;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Testing_page 
{
WebDriver driver;	
//Object Repository
By titlelogo =By.xpath("//img[@alt='bloom']"); 
By homepagelinks = By.tagName("link");

By hamburgermenu = By.xpath("/html/body/app-root/app-home-landing/div/app-home-header/div[1]/div[1]/app-header/nav/div[2]/div[4]/div/div[2]");
By homepagelinks2 =By.tagName("a");
//test 4
By parnerwithus =By.xpath("//a[contains(text(),'Partner with us')]");
By applybutton = By.xpath("//a[contains(text(),'Apply here')]");
By fieldproptype = By.xpath("//input[@type='text']");
By land = By.xpath("//div[contains(text(),'Land')]");
By city = By.xpath("//input[@formcontrolname='city']");
By upload = By.xpath("//label[@class='files']");

public Testing_page(WebDriver driver)  //constructor
{
	this.driver=driver;
}
public void title() throws IOException   //title logo validation and screenshot of element
{
	
	WebElement logo = driver.findElement(titlelogo);
	if(logo.isDisplayed())
	{
		System.out.println("Logo is displayed");
	}
	
	File sslogo = logo.getScreenshotAs(OutputType.FILE);
    FileHandler.copy(sslogo, new File(".//screenshots/ss_logo.png"));
}

public void responsecode() throws Exception     //validating responsecodes of links in links tag and display links not of 200
{
	
	List <WebElement> list = driver.findElements(homepagelinks);
	System.out.println("Number of links : "+list.size());
	System.out.println("Displaying Links not 200");
	for(WebElement l:list)
	{
		String links = l.getAttribute("href");
		URL ur=new URL(links);
	HttpURLConnection con = (HttpURLConnection)ur.openConnection();
	int code = con.getResponseCode();
	con.connect();
	
	if (code !=200)   //System.out.println("Displaying Links not 200");
	{
		
		System.out.println("Response code is :"+ code+"----> Link is===="+links);
	}
	}	
}



public void responsecode2() throws Exception    //validating responsecodes of links in a tag under href attribute
{
	int c=0;
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(hamburgermenu));
	 WebElement menu = driver.findElement(hamburgermenu);
	 
	Actions act = new Actions(driver);
	 act.moveToElement(menu).click().perform();
	
	

try {     
	List<WebElement> lists = driver.findElements(homepagelinks2);
	System.out.println("Displaying links in href \n");
	for(WebElement v:lists)
	{
		String link=v.getAttribute("href");
		
		if(link ==null || link.isEmpty())
		{
		continue;
		}
		else 
		{
		
		URL ob = new URL(link);
		HttpURLConnection ht = (HttpURLConnection)ob.openConnection();
	    ht.connect();
	    int code =	ht.getResponseCode();
		if(code==200)
		{
			System.out.println(" Link is valid==== "+link);
			c++;
		}
		else if(code !=200)
		{
			System.out.println(" Response code is : "+ code+"----> Link is==== "+link);
		}
		
	}
		}
	System.out.println("Number of valid links are : "+c);
}
catch (Exception e)
{
	
	System.out.println(e.getMessage());
	
}

}

public void ddt() throws InterruptedException 
{
	
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.navigate().to("https://staybloom.com/developer-form");
		
	Thread.sleep(2000);
	
	WebElement field = driver.findElement(fieldproptype);
			field.click();
			driver.findElement(land).click();
			WebElement ci = driver.findElement(city);
			ci.click();
			ci.sendKeys("Kochin");
			
	WebElement doc=driver.findElement(upload);
	doc.click();
	
}

}
