package test;

import java.awt.AWTException;

import org.testng.annotations.Test;

import base.Base1;
import page.Testing_page;
import utilities.Util;

public class Testing2 extends Base1 {
	
	String baseurl = "https://staybloom.com/";	
	String path ="C:\\DYUTHISREE\\LUMINAR\\4. Selenium\\DDT\\data.png";
	
@Test
public void test2() throws Exception
	{
		Testing_page lp1=new Testing_page(driver);		
		lp1.title(); //verify title logo is displayed
		lp1.responsecode();
		
	}
@Test
public void test3() throws Exception
{
	//Check whether the response code of links in pages are valid
	
	Testing_page lp1=new Testing_page(driver);
	
	lp1.responsecode2();
	
}
@Test
public void test4() throws InterruptedException, AWTException
{
	Testing_page lp1=new Testing_page(driver);
	lp1.ddt();
	
	//Image upload
	Util.fileUpload(path);
	
	//data driven testing
	
	

}
}
