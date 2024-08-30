package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Util 
{

		public static void fileUpload(String p) throws AWTException, InterruptedException
		{

			StringSelection str = new StringSelection(p);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			
			//To paste to s/m windows
			
			Robot robo=new Robot();
			robo.delay(3000);
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
		}
		
		public static void getlastrownum() 
		{
			
			
		}
}


