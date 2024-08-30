package test;
import java.io.IOException;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import base.Base1;
import page.Booking_page;

public class Booking_test extends Base1
{

@Test
public void test() throws InterruptedException, IOException 
{
Booking_page lp = new Booking_page(driver);	


lp.setvalues();

lp.selectCity("Pune");


//Landed in the date picker page 

lp.datepikr();

//use assert class to check we have reached the hotel for pune location
lp.asser();

//to scroll into view an element which is only visible when scrolled
lp.scroll();

//Proceed to booking

lp.booking(); //select hotel and room book Standard twin room

lp.radio();  // select radio button to continental

lp.screenshot("./screenshots//ss1.png");
}



}
