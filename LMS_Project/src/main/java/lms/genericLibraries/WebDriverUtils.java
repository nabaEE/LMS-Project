package lms.genericLibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils
{

   /**
   * 
   * wait for page to load
   * 
   */
	public static void waitForPageToLoad(WebDriver driver)
	{
	
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
	/**
	 * 
	 * Wait for any element available in GUI
	 * 
	 */
  public static void waitForElementPresent(WebDriver driver, WebElement wb)
  {
	  WebDriverWait wait= new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.elementToBeClickable(wb));
   }
 
 /**
  * Customer Wait
  * @throws InterruptedException
  * 
  */
public void waitForCompleteElementToLoad(WebElement wb) throws InterruptedException
{
 int count=0;
  while(count<10)
  {
	  try
	  {
		  wb.isDisplayed();
		  System.out.println("\nElement is displayed\n");
		  break;
	  }
	  catch(Throwable t)
	  {
		 System.out.println("Handle the exception and continue");
		 Thread.sleep(1000);
		 count++;
	  }
  }
}
}








