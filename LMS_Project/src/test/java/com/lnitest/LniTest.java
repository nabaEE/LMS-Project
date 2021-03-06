package com.lnitest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import lms.genericLibraries.BaseClass;
import lms.genericLibraries.WebDriverUtils;
import lms.objectRepository.ConfigurationSetupPage;
import lms.objectRepository.LNI_ManagementPage;
import lms.objectRepository.LNI_modificationPage;
import lms.objectRepository.LniSummaryPage;
import lms.objectRepository.LoginPage;
import lms.objectRepository.MyDashboardPage;
import lms.objectRepository.PendingApprovalPage;

public class LniTest extends BaseClass
{
//1. Fill in the LNI form then click on submit and verify.
@Test(groups="Smoke", priority=-1)
public static void submitLniFormAndVerify() throws InterruptedException
{
 log.debug("---------submitLniFormAndVerify :Test Started-----------");
 String expLniTitle="Jason Learning";
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
		  try {
			  lns.getClickEligibility().click(); 
			  lns.getSaveAndContinueButton().click();
			  }
		  catch(StaleElementReferenceException e)
		  {
		  lns.getSaveAndContinueButton().click();
		  }
		 
 //Enter remarks in the editbox
 lns.getRemarksEditbox().sendKeys("Submitting the LNI Form");
 //Click on submit
 //lns.getSaveAndContinueButton().click();
 
 log.debug("-----------Verify the submitted LNI Title-------------");
 Assert.assertEquals(actTitle, expLniTitle);
 log.info("Submitted LNI title is :"+actTitle);
 Thread.sleep(2000);
 log.info("---------submitLniFormAndVerify :Test ended-----------");
 }
//2. Click on eye icon to view the LNI summary and verify the title.
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
//3. Modify the LNI Title then click on submit and verify.
@Test()
public static void modifyLniDetailsAndVerify() throws InterruptedException
{
	log.debug("---------view_Lni_Summary :Test started-----------");
	String lniTitle="Rest Api";
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
  //Call the LNI Modification page
	LNI_modificationPage lmp1= PageFactory.initElements(driver, LNI_modificationPage.class);
	//Clear and enter LNI Title
	lmp1.getLniTitle().clear();
	lmp1.getLniTitle().sendKeys(lniTitle);
	//Click on save and proceed
	lmp1.getSaveAndProceedButton().click();
	//Capture the modified Lni title
	 String actTitle= lsp.getLniSummaryTitle().getText();
	log.debug("----------Verify the lni title------------");
	Assert.assertEquals(actTitle, lniTitle);
	log.info("The Lni title is :"+actTitle);
  }
//4. Fill in the LNI form with keeping LNI title blank then submit to verify the error message.
@Test()
public static void verifyLniTitleBlankError() throws InterruptedException
{
	 log.debug("---------verifyLniTitleErrorMessage :Test Started-----------");
	 String expError="LNI Title cannot be empty";
	 log.debug("Expected error message is :"+expError);
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
	 WebDriverUtils.waitForElementPresent(driver, lmp.getProjectNameEditbox());
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
	 //Capture the error message
	 String actError=lmp.getLniTitleBlankError().getText();
	 //Close popup window
	 lmp.getClosePopupWin().click();
	 Assert.assertEquals(actError, expError);
	 log.info("Actual error is :"+actError);
	 log.info("---------verifyLniTitleErrorMessage :Test ended-----------");
  }
//5. Fill in the LNI form with keeping Project Name blank then submit to verify the error message.
@Test()
public static void verifyProjectNameBlankError() throws InterruptedException
{
	 log.debug("---------verifyProjectNameBlankError :Test Started-----------");
	 String expError="Project Name cannot be empty";
	 log.debug("Expected error message is :"+expError);
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
	 lmp.getLniTitleEditbox().sendKeys("s-Learning");
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
	 //Capture the error message
	 String actError=lmp.getProjectNameBlankErr().getText();
	 //Close popup window
	 lmp.getClosePopupWin().click();
	 Assert.assertEquals(actError, expError);
	 log.info("Actual error is :"+actError);
	 log.info("---------verifyProjectNameBlankError :Test ended-----------");
 }
//6. Fill in the LNI form with keeping Project Code blank then submit to verify the error message.
@Test()
public static void verifyProjectCodeBlankError() throws InterruptedException
{
	 log.debug("---------verifyProjectCodeBlankError :Test Started-----------");
	 String expError="Project Code cannot be empty";
	 log.debug("Expected error message is :"+expError);
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
	 lmp.getLniTitleEditbox().sendKeys("dhtml setup");
	 //Enter project name
	 lmp.getProjectNameEditbox().sendKeys("MTNL");
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
	 //Capture the error message
	 String actError=lmp.getProjectCodeBlankErr().getText();
	 //Close popup window
	 lmp.getClosePopupWin().click();
	 Assert.assertEquals(actError, expError);
	 log.info("Actual error is :"+actError);
	 log.info("---------verifyProjectCodeBlankError :Test ended-----------");	
  }
//7. Verify the error message for not picking Sponsorer.
@Test()
public static void verifySponsorerBlankErr() throws InterruptedException
{
	log.debug("---------verifySponsorerBlankErr :Test Started-----------");	
	 String expError="Sponsorer cannot be empty";
	 log.debug("Expected error message is :"+expError);
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
	 lmp.getLniTitleEditbox().sendKeys("M-Learning");
	 //Enter project name
	 lmp.getProjectNameEditbox().sendKeys("dhtml setup");
	 //Enter the project code
	 lmp.getProjectCode().sendKeys("80");
	 //Click on sponsorer dropdown and pick trianz university
	 lmp.getSponsorerDropdown().click();
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
	 //Capture the error message
	 String actError=lmp.getSponsorerBlankErr().getText();
	 //Close popup window
	 lmp.getClosePopupWin().click();
	 Assert.assertEquals(actError, expError);
	 log.info("Actual error is :"+actError);
	 log.info("---------verifySponsorerBlankErr :Test ended-----------");		
}
//8. Verify the error message for not picking Learning type
@Test()
public static void verifyLearningTypeBlankError() throws InterruptedException
{
	log.debug("---------verifySponsorerBlankErr :Test started----------");	
	String expError="Learning Type cannot be empty";
	 log.debug("Expected error message is :"+expError);
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
	 lmp.getLniTitleEditbox().sendKeys("M-Learning");
	 //Enter project name
	 lmp.getProjectNameEditbox().sendKeys("dhtml setup");
	 //Enter the project code
	 lmp.getProjectCode().sendKeys("80");
	 //Click on sponsorer dropdown and pick trianz university
	 lmp.getSponsorerDropdown().click();
	 lmp.getSelectTrianzUniversity().click();
	 //Click learning type dropdown and don't pick Skill Type
	 lmp.getLearningTypeDropdown().click();
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
	 //Capture the error message
	 String actError=lmp.getLearningTypeBlankErr().getText();
	 //Close popup window
	 lmp.getClosePopupWin().click();
	 Assert.assertEquals(actError, expError);
	 log.info("Actual error is :"+actError);	
	 log.info("---------verifyLearningTypeBlankError :Test ended----------");
}
//9. Verify the error message for not picking Learning type
@Test()
public static void validateClassificationBlankError() throws InterruptedException
{
	 log.debug("---------validateClassificationBlankError:Test started----------");
	 String expError="Classification cannot be empty";
	 log.debug("Expected error message is :"+expError);
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
	 lmp.getLniTitleEditbox().sendKeys("M-Learning");
	 //Enter project name
	 lmp.getProjectNameEditbox().sendKeys("dhtml setup");
	 //Enter the project code
	 lmp.getProjectCode().sendKeys("80");
	 //Click on sponsorer dropdown and pick trianz university
	 lmp.getSponsorerDropdown().click();
	 //Select sponsorer
	 lmp.getSelectTrianzUniversity().click();
	 //Click learning type dropdown and don't pick Skill Type
	 lmp.getLearningTypeDropdown().click();
	 lmp.getSelectSkillBased().click();
	 //Click on scope and pick the value
	 lmp.getScopeDropdown().click();
	 lmp.getPickScopeAsTechnical().click();
	 //Click on Classification dropdown and and don't pick Project.
	 lmp.getClassificationDropdown().click();
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
	 //Capture the error message
	 String actError=lmp.getClassificationBlankErr().getText();
	 //Close popup window
	 lmp.getClosePopupWin().click();
	 Assert.assertEquals(actError, expError);
	 log.info("Actual error is :"+actError);	
	 log.info("---------validateClassificationBlankError :Test ended----------");	 
}
//10. Submit LNI Form without picking priority level and verify the error message.
@Test
public static void validatePriorityBlankError() throws InterruptedException
{
	log.debug("---------validatePriorityBlankError: Test started----------");
	 String expError="Priority Level cannot be empty";
	 log.debug("Expected error message is :"+expError);
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
	 lmp.getLniTitleEditbox().sendKeys("S-Learning");
	 //Enter project name
	 lmp.getProjectNameEditbox().sendKeys("dhtml setup");
	 //Enter the project code
	 lmp.getProjectCode().sendKeys("80");
	 //Click on sponsorer dropdown and pick trianz university
	 lmp.getSponsorerDropdown().click();
	 lmp.getSelectTrianzUniversity().click();
	 //Click learning type dropdown and don't pick Skill Type
	 lmp.getLearningTypeDropdown().click();
	 lmp.getSelectSkillBased().click();
	 //Click on scope
	 lmp.getScopeDropdown().click();
     lmp.getPickScopeAsTechnical().click();
	 //Click on Classification dropdown and and don't pick Project.
	 lmp.getClassificationDropdown().click();
	 lmp.getSelectClassificationAsProject().click();
	 //Click on Priority level dropdown and don't select "Within 1Month".
	 lmp.getPriorityLevelDropdown().click();
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
	 //Capture the error message
	 String actError=lmp.getPriorityLevelBlankErr().getText();
	 //Close popup window
	 lmp.getClosePopupWin().click();
	 Assert.assertEquals(actError, expError);
	 log.info("Actual error is :"+actError);	
	 log.info("---------validatePriorityBlankError :Test ended----------");	
}
//11. Fill in the LNI Form with keeping duration edit box blank and verify the error message.
@Test()
public static void verifyDurationEditboxBlankError() throws InterruptedException
{
	log.debug("---------verifyDurationEditboxBlankError :Test Started-----------");
	 String expError="Duration(in days) cannot be empty";
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
	 lmp.getLniTitleEditbox().sendKeys("Oracle");
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
	//Capture the error message
	 String actError=lmp.getDurationBlankErr().getText();
	 //Close popup window
	 lmp.getClosePopupWin().click();
	 Assert.assertEquals(actError, expError);
	 log.info("Actual error is :"+actError);	
	 log.info("---------verifyDurationEditboxBlankError :Test ended----------");	
}
//12. Submit LNI form without making people editbox blank and verify the error message.
@Test()
public static void verifyPeopleEditboxBlankError() throws InterruptedException
{
	log.debug("---------verifyPeopleEditboxBlankError :Test Started-----------");
	 String expError="People cannot be empty";
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
	 lmp.getLniTitleEditbox().sendKeys("Java");
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
	//Capture the error message
	 String actError=lmp.getPeopleBlankErr().getText();
	 //Close popup window
	 lmp.getClosePopupWin().click();
	 Assert.assertEquals(actError, expError);
	 log.info("Actual error is :"+actError);	
	 log.info("---------verifyPeopleEditboxBlankError :Test ended----------");		
}
//13. Verify the error message with keeping the current expertise dropdown blank.
@Test()
public static void checkCurrentExpertiseBlankError() throws InterruptedException
{
	log.debug("---------checkCurrentExpertiseBlankError :Test Started-----------");
	 String expError="Current Expertise cannot be empty";
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
	 lmp.getLniTitleEditbox().sendKeys("C++");
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
	 //Click current expertise and don't pick
	 lmp.getCurrentExpertiseDropdown().click();
	 
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
	//Capture the error message
	 String actError=lmp.getCurrentExpertiseBlankErr().getText();
	 //Close popup window
	 lmp.getClosePopupWin().click();
	 Assert.assertEquals(actError, expError);
	 log.info("Actual error is :"+actError);	
	 log.info("---------validatePriorityBlankError :Test ended----------");		
}
//14. Verify the error message for keeping Learning Need Description editbox blank.
@Test()
public static void verifyLearningNeedDescriptionBlankError() throws InterruptedException
{
	log.debug("---------verifyLearningNeedDescriptionBlankError :Test Started-----------");
	 String expError="Learning Need Description cannot be empty";
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
	 lmp.getLniTitleEditbox().sendKeys("C Language");
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
	 //Enter course coverage
	 lmp.getCourseCoverageEditbox().sendKeys("NA");
	 //Enter Business Benefits
	 lmp.getBusinessBenefitsEditbox().sendKeys("NA");
	 //Click on save and proceed button
	 WebDriverUtils.waitForElementPresent(driver, lmp.getSubmitButton());
	 lmp.getSubmitButton().click();
	//Capture the error message
	 String actError=lmp.getLniDescriptionEditboxBlankErr().getText();
	 //Close popup window
	 lmp.getClosePopupWin().click();
	 Assert.assertEquals(actError, expError);
	 log.info("Actual error is :"+actError);	
	 log.info("---------verifyLearningNeedDescriptionBlankError :Test ended----------");	
  }
//15. Submit the Eligibility section with picking location then verify it.
@Test()
public static void AddAndVerifyEligibility() throws InterruptedException
{
	 log.debug("---------AddAndVerifyEligibility :Test Started-----------");
	 //Call the My Dashboard page
	 MyDashboardPage mdp= PageFactory.initElements(driver, MyDashboardPage.class);
  //Click on Learning Request on landing page
	 WebDriverUtils.waitForElementPresent(driver, mdp.getLearningRequestButton());
	 Thread.sleep(2000);
	 //Click on Learning Request
	 mdp.getLearningRequestButton().click();
	 //Call the LNI manangement page
	 LNI_ManagementPage lmp= PageFactory.initElements(driver, LNI_ManagementPage.class);
	 //Click on LNI edit icon
	 lmp.getEditLniButton().click();
	 //Call LNI Summary page
	 LniSummaryPage lsp= PageFactory.initElements(driver, LniSummaryPage.class);
	 //Click on eligibility modify Icon
	 lsp.getClickEligibility().click();
	 //Click on eligibility checkbox
	 lsp.getClickEligibilityCheckbox().click();
	 //Click on select all location checkbox
	 lsp.getClickSelectAllLocationCheckbox().click();
	 //Click on chennai location
	 lsp.getClickChennaiLocation().click();
	 //Click on save and continue button
	 lsp.getSaveAndContinueButton().click();
	 //Declare the selected location
	 String expLocation="Chennai";
	 log.debug("Expected location is :"+expLocation);
	 //Capture the selected location
	 String actLocation=lsp.getCheckEnteredLocation().getText();
	 log.debug("---------Verify the entered location----------");
	 Assert.assertEquals(actLocation, expLocation);
	 log.info("Selected location is :"+actLocation);
	 log.info("---------AddAndVerifyEligibility :Test ended-----------");
}
//16. Login as employee then submit the LNI request and verify the approval section. 
@Test()
public static void submitLNIAndpproveRequest() throws Exception
{
	log.debug("-----------submitLNIAndpproveRequest : Test Started-------------");
	 String expLniTitle="Data Science2 Learning";
	 //Call the My Dashboard page
	 MyDashboardPage mdp= PageFactory.initElements(driver, MyDashboardPage.class);
	 Thread.sleep(3000);
	 //Click on admin icon
	 WebDriverUtils.waitForElementPresent(driver, mdp.getAdminIcon());
	//Click on Learning Request
	 Thread.sleep(2000);
	 mdp.getLearningRequestButton().click();
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
	 try {
		  lns.getClickEligibility().click(); 
		  lns.getSaveAndContinueButton().click();
		  }
	  catch(StaleElementReferenceException e)
	  {
	  lns.getSaveAndContinueButton().click();
	  }
			 
	 //Enter remarks in the editbox
	 lns.getRemarksEditbox().sendKeys("Submitting the LNI Form");
	 //Click on submit
	 lns.getSaveAndContinueButton().click();
    //Call login page
	LoginPage lp= PageFactory.initElements(driver, LoginPage.class);
	WebDriverUtils.waitForPageToLoad(driver);
	Thread.sleep(2000);
	WebDriverUtils.waitForElementPresent(driver, lp.getDropDownArrow());
	//Click on logout
	lp.logOut();
	//Click on click here to login
	lp.getClickHereToLogin().click();
	//Enter approval username and password
	lp.getUserNameEdt().sendKeys("Ganeshan.Venkat@trianz.com");
	lp.getpassWordEdt().sendKeys("NeWTesT@19");
	//Click on login
	lp.getLoginBtn().click();
	//Call the my dashboard page
   MyDashboardPage md= PageFactory.initElements(driver, MyDashboardPage.class);
   driver.switchTo().frame(driver.findElement(By.xpath("//html//frameset//frame")));
  //Click on approval button
   md.getEmployeeApprovalButton().click();
   //Call the approval page
   PendingApprovalPage pap= PageFactory.initElements(driver, PendingApprovalPage.class);
   //Click on pencil icon
   WebDriverUtils.waitForElementPresent(driver, pap.getClickPencilIcon());
   pap.getClickPencilIcon().click();
   //enter remarks and click on approve
   pap.getRemarksEditbox().sendKeys("Submit");
   pap.getApproveButton().click();
   WebDriverUtils.waitForElementPresent(driver, lp.getDropDownArrow());
   Thread.sleep(2000);
   lp.logOut();
 //Click on click here to login
 	lp.getClickHereToLogin().click();
 	//Enter approval username and password
 	lp.getUserNameEdt().sendKeys("anita.pinto@trianz.com");
 	lp.getpassWordEdt().sendKeys("NeWTesT@19");
 	//Click on login
 	lp.getLoginBtn().click();
 	//Call the my dashboard page
    driver.switchTo().frame(driver.findElement(By.xpath("//html//frameset//frame")));
    WebDriverUtils.waitForElementPresent(driver, md.getEmployeeApprovalButton());
    Thread.sleep(2000);
   //Click on approval button
    md.getAdminApprovalButton().click();
    //Click on pencil icon
    WebDriverUtils.waitForElementPresent(driver, pap.getClickPencilIcon());
    pap.getClickPencilIcon().click();
    //enter remarks and click on approve
    pap.getRemarksEditbox().sendKeys("Submit");
    pap.getApproveButton().click();
    String expMessage="Transaction is Approved.";
    log.debug("Expected toast message is :"+expMessage);
    //Capture the actual message
    String actMessage=pap.getApprovalMessage().getText();
    log.debug("-----Verify the approval message-------");
    Assert.assertEquals(actMessage, expMessage);
    log.info("Actual message is :"+actMessage);
    WebDriverUtils.waitForElementPresent(driver, lp.getDropDownArrow());
    Thread.sleep(2000);
    lp.logOut();
   log.info("-----------submitLNIAndpproveRequest : Test Ended-------------");
   driver.close();
    }

}









