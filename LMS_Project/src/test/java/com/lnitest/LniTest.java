package com.lnitest;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import lms.genericLibraries.BaseClass;
import lms.genericLibraries.WebDriverUtils;
import lms.objectRepository.ConfigurationSetupPage;
import lms.objectRepository.LNI_ManagementPage;
import lms.objectRepository.LniSummaryPage;
import lms.objectRepository.MyDashboardPage;

public class LniTest extends BaseClass
{

@Test()
public static void submitLniFormAndVerify() throws InterruptedException
{
 log.debug("---------submitLniFormAndVerify :Test Started-----------");
 String expLniTitle="SQL advance";
 //Call the My Dashboard page
 MyDashboardPage mdp= PageFactory.initElements(driver, MyDashboardPage.class);
 Thread.sleep(3000);
 //Click on admin icon
 WebDriverUtils.waitForElementPresent(driver, mdp.getAdminIcon());
 mdp.getAdminIcon().click();
 //Click on configuration setup
 mdp.getConfigurationSetupButton().click();
 //Call Confirguration setup page
 ConfigurationSetupPage csp= PageFactory.initElements(driver, ConfigurationSetupPage.class);
 //Click on LMS Data setup
 csp.getLmsDataSetup().click();
 //Click on lnis Management
 Thread.sleep(3000);
 WebDriverUtils.waitForElementPresent(driver, csp.getLni_ManagementButton());
 csp.getLni_ManagementButton().click();
 //Call the LNI management page
 LNI_ManagementPage lmp= PageFactory.initElements(driver, LNI_ManagementPage.class);
 //Click on add new button
 Thread.sleep(2000);
 WebDriverUtils.waitForElementPresent(driver, lmp.getAddNewButton());
 lmp.getAddNewButton().click();
 //Click on LNI Title and enter values in it.
 WebDriverUtils.waitForElementPresent(driver, lmp.getLniTitleEditbox());
 Thread.sleep(2000);
 lmp.getLniTitleEditbox().sendKeys(expLniTitle);
 //Enter project name
 lmp.getProjectNameEditbox().sendKeys("dhtml setup");
 //Enter the project code
 lmp.getProjectCode().sendKeys("80");
 //Click on sponsorer dropdown and pick trianz university
 lmp.getSponsorerDropdown().click();
 lmp.getSelectTrianzUniversity().click();
 //Click learning type dropdown and pick Skill Type
 lmp.getLearningTypeDropdown().click();
 lmp.getSelectSkillBased().click();
 //Click on scope dropdown and pick Technical.
 lmp.getScopeDropdown().click();
 lmp.getPickScopeAsTechnical().click();
 //Click on Classification dropdown and pick Project.
 lmp.getClassificationDropdown().click();
 lmp.getSelectClassificationAsProject().click();
 //Click on Priority level dropdown and select "Within 1Month".
 lmp.getPriorityLevelDropdown().click();
 lmp.getSelectPriorityAs_1Month().click();
 //Click on duration editbox.
 lmp.getDurationEditbox().sendKeys("90");
 //Enter number of people.
 lmp.getPeopleEditbox().sendKeys("60");
 //Click current expertise and pick Beginner.
 lmp.getCurrentExpertiseDropdown().click();
 lmp.getSelectBeginner().click();
 //Click external program or certification dropdown.
 lmp.getCertificationSwitchButton().click();
 //Enter external program name
 lmp.getExternalProgramNameEditbox().sendKeys("Yash rao");
 //Enter cost 
 lmp.getCostEditbox().sendKeys("1000");
 //Click and Select currency
 lmp.getCurrencyDropdown().click();
 lmp.getPickCurrencyINR().click();
 //Enter Learning Need description
 lmp.getLearningNeedDescription().sendKeys("NA");
 //Enter course coverage
 lmp.getCourseCoverageEditbox().sendKeys("NA");
 //Enter Business Benefits
 lmp.getBusinessBenefitsEditbox().sendKeys("NA");
 //Click on save and proceed button
 WebDriverUtils.waitForElementPresent(driver, lmp.getSubmitButton());
 lmp.getSubmitButton().click();
 //Call the LNI Summary page
 LniSummaryPage lns= PageFactory.initElements(driver, LniSummaryPage.class);
 log.debug("Capture the submitted LNI Title");
 String actTitle=lns.getLniTitle().getText();
 //Click on eligibility 
		
		  lns.getClickEligibility().click(); 
		  //Click on save and continue button
		  try {
		  lns.getSaveAndContinueButton().click(); }
		  catch(StaleElementReferenceException e) 
		  {
		  lns.getSaveAndContinueButton().click();
		  }
 //Enter remarks in the editbox
 lns.getRemarksEditbox().sendKeys("Submitting the LNI Form");
 //Click on submit
 lns.getSaveAndContinueButton().click();
 
 log.debug("-----------Verify the submitted LNI Title-------------");
 Assert.assertEquals(actTitle, expLniTitle);
 log.info("Submitted LNI title is :"+actTitle);
 Thread.sleep(2000);
 log.info("---------submitLniFormAndVerify :Test ended-----------");
 }

@Test()
public static void view_Lni_SummaryAndVerify() throws InterruptedException
{
log.debug("---------view_Lni_Summary :Test started-----------");
MyDashboardPage mdp= PageFactory.initElements(driver, MyDashboardPage.class);
Thread.sleep(3000);
//Click on admin icon
WebDriverUtils.waitForElementPresent(driver, mdp.getAdminIcon());
mdp.getAdminIcon().click();
//Click on configuration setup
mdp.getConfigurationSetupButton().click();
//Call Confirguration setup page
ConfigurationSetupPage csp= PageFactory.initElements(driver, ConfigurationSetupPage.class);
//Click on LMS Data setup
csp.getLmsDataSetup().click();
//Click on lnis Management
Thread.sleep(3000);
WebDriverUtils.waitForElementPresent(driver, csp.getLni_ManagementButton());
csp.getLni_ManagementButton().click();
//Call LNI Management page
LNI_ManagementPage lmp= PageFactory.initElements(driver, LNI_ManagementPage.class);
//Click on view icon
lmp.getViewButton().click();
//Call the LNI Summary page
LniSummaryPage lsp= PageFactory.initElements(driver, LniSummaryPage.class);
log.debug("--------Verify the LNI Summary page--------");
Assert.assertTrue(lsp.getLniSummaryTitle().isDisplayed());
log.info("The title is :"+lsp.getLniSummaryTitle().getText());
//Close the Summay page
lsp.getCloseLniSummaryPage().click();
log.info("---------view_Lni_Summary :Test ended-----------");
  }
@Test()
public static void modifyLniDetailsAndVerify() throws InterruptedException
{
	log.debug("---------view_Lni_Summary :Test started-----------");
	MyDashboardPage mdp= PageFactory.initElements(driver, MyDashboardPage.class);
	Thread.sleep(3000);
	//Click on admin icon
	WebDriverUtils.waitForElementPresent(driver, mdp.getAdminIcon());
	mdp.getAdminIcon().click();
	//Click on configuration setup
	mdp.getConfigurationSetupButton().click();
	//Call Confirguration setup page
	ConfigurationSetupPage csp= PageFactory.initElements(driver, ConfigurationSetupPage.class);
	//Click on LMS Data setup
	csp.getLmsDataSetup().click();
	//Click on lnis Management
	Thread.sleep(3000);
	WebDriverUtils.waitForElementPresent(driver, csp.getLni_ManagementButton());
	csp.getLni_ManagementButton().click();
	//Call LNI Management page
	LNI_ManagementPage lmp= PageFactory.initElements(driver, LNI_ManagementPage.class);
	//Click edit button
	Thread.sleep(2000);
	lmp.getEditLniButton().click();
	//Call LNI summary page
	LniSummaryPage lsp= PageFactory.initElements(driver, LniSummaryPage.class);
	//Click on Lni Summary Edit icon
	lsp.getLniSummaryEditButton().click();
	
	
	
	
	
	
}

}
