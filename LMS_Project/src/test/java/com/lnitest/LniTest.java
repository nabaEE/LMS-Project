package com.lnitest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import lms.genericLibraries.BaseClass;
import lms.genericLibraries.WebDriverUtils;
import lms.objectRepository.MyDashboardPage;

public class LniTest extends BaseClass
{

@Test()
public static void submitLniFormAndVerify()
{
 log.debug("---------submitLniFormAndVerify :Test Started-----------");
 //Call the My Dashboard page
 MyDashboardPage mdp= PageFactory.initElements(driver, MyDashboardPage.class);
 //Click on admin icon
 WebDriverUtils.waitForPageToLoad(driver);
 mdp.getAdminIcon().click();
 //Click on configuration setup
 mdp.getConfigurationSetupButton().click();

}
}
