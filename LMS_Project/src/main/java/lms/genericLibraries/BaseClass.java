package lms.genericLibraries;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import lms.objectRepository.LoginPage;
import lms.genericLibraries.WebDriverUtils;

public class BaseClass extends FileUtils
{
//Declaration of the driver
 public static WebDriver driver;	
 WebDriverUtils wdu= new WebDriverUtils();
 @BeforeClass()
 @Parameters({"browser"})
public void openBrowser(String browserName)
  {
	 /*Call the chrome driver*/
  if(browserName.equalsIgnoreCase("chrome"))
   {
	 System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Chrome\\14th Sept Chrome\\chromedriver.exe");
	 driver= new ChromeDriver();
    }
  /*call the firefox browser*/
 else if(browserName.equalsIgnoreCase("firefox"))
  {
	 System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\gecko\\geckodriver.exe");
	 driver= new FirefoxDriver();
   }
  /*call the internet explorer browser*/
 else if(browserName.equalsIgnoreCase("ie"))
   {
	 System.setProperty("webdriver.ie.driver", "");
	 driver= new InternetExplorerDriver();
  }
  driver.manage().window().maximize();
}
@BeforeMethod()
public void login() throws IOException
{
	/*Create an object of FileUtils class to get the data from property file*/
 FileUtils fl= new FileUtils();
 Properties pObj=fl.getPropertyData();
 driver.get(pObj.getProperty("URL"));
 /*Call the login page class which is common for all the modules*/
 lms.objectRepository.LoginPage lp= PageFactory.initElements(driver, lms.objectRepository.LoginPage.class);
 //Calling the method declared in login page class
 lp.loginToPage(pObj.getProperty("USERNAME"), pObj.getProperty("PASSWORD"));
 }
@AfterMethod
public void tearDown() throws Exception
{
		  driver.switchTo().frame(0); 
		  lms.objectRepository.LoginPage lp=PageFactory.initElements(driver, lms.objectRepository.LoginPage.class);
		 //call the logout method declared in LoginPage
		 lp.logOut();
}
@AfterClass
public void closeBrowser()
{ 
	driver.switchTo().defaultContent();
	driver.quit();
}
}
