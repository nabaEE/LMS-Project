package lms.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import lms.genericLibraries.BaseClass;

@Listeners(lms.genericLibraries.ListenerImplemention.class)
public class LoginTest extends BaseClass
{
 private static Logger log=LogManager.getLogger(LoginTest.class);
	@Test
	public void LoginTest()
	{
    //Declaring the expected page title
    log.debug("*****Login page is displayed*****");
	String expTitle="Employee Service Platform";
	//printing the actual page title
	String actTitle=driver.getTitle();
	Assert.assertEquals(actTitle, expTitle);
	log.info("Title window is displayed :" +actTitle);
	log.fatal("This is fatal");
	
	 }
	
 @Test()
 public static void check()
 {
	 log.debug("Do some operations");
	 log.info("This is just a test");
 }

}
