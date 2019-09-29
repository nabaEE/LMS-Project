package lms.test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import lms.genericLibraries.BaseClass;

@Listeners(lms.genericLibraries.ListenerImplemention.class)
public class LoginTest extends BaseClass
{

	@Test
	public void LoginTest()
	{
    //Declaring the expected page title
	Reporter.log("Login to NewTest is successful with admin account", true);
	String expTitle="Employee Service Platform";
	//printing the actual page title
	String actTitle=driver.getTitle();
	Assert.assertEquals(actTitle, expTitle);
	Reporter.log(actTitle, true);
	 }

}
