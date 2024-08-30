package page;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Booking_page 
{
WebDriver driver;	
String mon = "";
//Object Repository


By log = By.xpath ("/html/body/app-root/app-home-landing/div/app-home-header/div[1]/div[2]/div/div/div[1]/div[2]/app-search-box");
By ahmedabad = By.xpath("/html/body/app-root/app-home-landing/div/app-home-header/div[2]/app-city-modal/p-sidebar/div/div/div[2]/div[1]/app-city-popup-holder/div/div[1]/app-city-popup-card/div/div");
By cardElemtrial = By.xpath("//div[@class ='city-card']");
By month =By.xpath("/html/body/app-root/app-home-landing/div/app-home-header/app-calender/p-sidebar/div/div/div[2]/p-calendar/span/div/div[1]/div[1]/div");
By arrow =By.xpath("/html/body/app-root/app-home-landing/div/app-home-header/app-calender/p-sidebar/div/div/div[2]/p-calendar/span/div/div[2]/div[1]/a[1]");
By Sdate =By.xpath("/html/body/app-root/app-home-landing/div/app-home-header/app-calender/p-sidebar/div/div/div[2]/p-calendar/span/div/div[1]/div[2]/table/tbody/tr/td/a");
By Edate = By.xpath("/html/body/app-root/app-home-landing/div/app-home-header/app-calender/p-sidebar/div/div/div[2]/p-calendar/span/div/div[2]/div[2]/table/tbody/tr	/td/a");
By dateconfButton = By.xpath("/html/body/app-root/app-home-landing/div/app-home-header/app-calender/p-sidebar/div/div/div[3]/div/app-calender-date-view-footer/div/div[2]/div[2]/app-button");
By assertwait = By.xpath("/html/body/app-root/app-city-landing/div[2]/app-city-header/div/div[2]/h1");
By numberOfHotel = By.xpath("//div[@class='box__text']");
By punehotelList = By.xpath("//h3[contains(@title,'Bloom')]");
By selectbutton = By.xpath("/html/body/app-root/app-city-landing/div[3]/div/app-city-detail-card-holder/div/div[1]/div[1]/app-hotel-card/div/div[2]/div[4]");
By stdKing = By.xpath("/html/body/app-root/app-property-landing/div[3]/div[3]/app-property-card-holder/div/div[1]/div[1]/app-property-card/div/div[2]/h3");
By stdQuees = By.xpath("/html/body/app-root/app-property-landing/div[3]/div[3]/app-property-card-holder/div/div[1]/div[2]/app-property-card/div/div[2]");
By stdTwin = By.xpath("/html/body/app-root/app-property-landing/div[3]/div[3]/app-property-card-holder/div/div[1]/div[3]/app-property-card/div/div[2]");
By roomdetails =By.xpath("/html/body/app-root/app-property-landing/div[3]/div[3]/app-property-card-holder/div/div[1]/div/app-property-card/div/div[2]/h3");
By roomclose =By.xpath("/html/body/app-root/app-room-landing/div[1]/div/app-close-button");
By bookbutton =By.xpath("/html/body/app-root/app-room-landing/div[2]/div[1]/app-room-header/div/div[2]/div[2]");  //book twinroom
By conRadiobtn = By.xpath("//label[@for='CPStandard Twin0']/div");
By roomRadiobtn = By.xpath("//div[@class='radio__group']/label/div");
//constructor

public Booking_page (WebDriver driver)
{
	this.driver = driver;
}

public void setvalues() 
{

waitblock(log);
driver.findElement(log).click();  //click on search
waitblock(ahmedabad);			
System.out.println(driver.getCurrentUrl());

//Display the number of cities selection and the name of cities
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
List<WebElement> cardElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cardElemtrial));
		//driver.findElements(cardElemtrial);  //stores a list of card elements in the container

// Iterate over each card element and print the city name

System.out.println("The number of cities for selection : "+cardElements.size());
for (WebElement cE : cardElements) 
{
//Print the city name 
	
String cityname = cE.getText();
System.out.println("City Name: " +cityname);
}
}


public void selectCity(String city) 
{
	List<WebElement> cardElements= driver.findElements(cardElemtrial);
	for(WebElement v:cardElements)
	{
		
		if(city.equalsIgnoreCase(v.getText()))
		{
			System.out.println("got element");
			v.click();
			break;
		}
	}
}

//Method to pick a date start and end date

public void datepikr()
{
	waitblock(arrow);
	while(true)
	{
	
	WebElement month1=driver.findElement(month);  //get a month
	String mo1=month1.getText();
	//System.out.println(mo1);
	if(mo1.equalsIgnoreCase("October2024"))
	{
		System.out.println("Selected month : " +mo1);
		mon=mo1;
		break;
		
	}
	else
	{
		driver.findElement(arrow).click();	
		//System.out.println("not here checking again...");
	}
	}
	List<WebElement> date = driver.findElements(Sdate);
	for(WebElement v:date)
	{
		String dat= v.getText();
		if(dat.equalsIgnoreCase("3"))
		{
			v.click();
			System.out.println("Selected start date : "+ dat+" of "+mon);
		}
		else if (dat.equalsIgnoreCase("10"))
		{
			v.click();
			System.out.println("Selected end date : "+ dat+" of "+mon);
		}
	
	}
	driver.findElement(dateconfButton).click();
	
	
}
	
public void waitblock(By elem)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(elem));
	
}
public void asser() {
	waitblock(assertwait);
	String expectedUrl ="https://staybloom.com/hotels/pune";
	String actualUrl = driver.getCurrentUrl();
	Assert.assertEquals(actualUrl, expectedUrl);
	System.out.println("Confirmed the url is correct - Using Assert Class");
	
	}

public void scroll()
{
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
JavascriptExecutor js =((JavascriptExecutor)driver);
js.executeScript("window.scrollBy(0,800)","");

System.out.println("Hotels are : ");
List <WebElement> list = driver.findElements(punehotelList);
for(WebElement v:list)
{
	System.out.println(v.getText());
}

}
public void booking() throws InterruptedException
{
	driver.navigate().refresh();
	waitblock(selectbutton);
	WebElement select = driver.findElement(selectbutton); //select first hotel
	select.click(); //click first Hotel
	
	// click on the different room options there 
	driver.findElement(stdKing).click();
	System.out.println("Inspected Standard King room");
	Thread.sleep(3000);
	driver.navigate().back();
	
	waitblock(stdQuees);
	driver.findElement(stdQuees).click();
	System.out.println("Inspected Standard Queen Room");
	Thread.sleep(3000);
	driver.navigate().back();
	Thread.sleep(3000);
	driver.findElement(stdTwin).click();
	System.out.println("Inspected Standard Twin Room");
	waitblock(bookbutton);
	driver.findElement(bookbutton).click();  //book a twin room
	System.out.println("A Standard Twin Room is Booked ");
	mon = driver.getCurrentUrl();
	System.out.println(driver.getCurrentUrl());
}
public void radio()
{
// Select a continental Plan use is selected
	System.out.println("check radio method");
	waitblock(roomRadiobtn);
	WebElement r1 = driver.findElement(roomRadiobtn);
	
	if(r1.isEnabled()==true)
		{ 
		System.out.println("Room radio button was enabled : continental with breakfast option is selected");
		driver.findElement(conRadiobtn).click();
		}
}


public void screenshot(String sspath) throws IOException {
	File scr1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(scr1, new File(sspath));
	
}
}	


