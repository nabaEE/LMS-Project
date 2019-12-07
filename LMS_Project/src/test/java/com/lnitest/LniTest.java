package com.lnitest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import lms.genericLibraries.BaseClass;
import lms.genericLibraries.WebDriverUtils;
import lms.objectRepository.ConfigurationSetupPage;
import lms.objectRepository.LNI_ManagementPage;
import lms.objectRepository.MyDashboardPage;

public class LniTest extends BaseClass
{

@Test()
public static void submitLniFormAndVerify() throws InterruptedException
{
 log.debug("---------submitLniFormAndVerify :Test Started-----------");
 String expLniTitle="Linux Training";
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
 WebDriverUtils.waitForElementPresent(driver, lmp.getAddNewButton());
 lmp.getAddNewButton().click();
 //Click on LNI Title and enter values in it.
 WebDriverUtils.waitForElementPresent(driver, lmp.getLniTitleEditbox());
 lmp.getLniTitleEditbox().sendKeys(expLniTitle);
 //Enter project name
 lmp.getProjectNameEditbox().sendKeys("Ubuntu");
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
 lmp.getDurationEditbox().sendKeys("80");
 //Enter number of people.
 lmp.getPeopleEditbox().sendKeys("100");
 //Click current expertise and pick Beginner.
 lmp.getCurrentExpertiseDropdown().click();
 lmp.getSelectBeginner().click();
 //Click external program or certification dropdown.
 lmp.getCertificationSwitchButton().click();
 //Enter external program name
 lmp.getExternalProgramNameEditbox().sendKeys("Hari Sankar");
 //Enter cost 
 lmp.getCostEditbox().sendKeys("1000");
 //Click and Select currency
 lmp.getCurrencyDropdown().click();
 lmp.getPickCurrencyINR().click();
 //Enter Learning Need description
 lmp.getLearningNeedDescription().sendKeys("Nice course");
 //Enter course coverage
 lmp.getCourseCoverageEditbox().sendKeys("NA");
 //Enter Business Benefits
 lmp.getBusinessBenefitsEditbox().sendKeys("Excellent course");
 //Click on save and proceed button
 WebDriverUtils.waitForElementPresent(driver, lmp.getSubmitButton());
 lmp.getSubmitButton().click();
 log.debug("Capture the submitted LNI Title");
 String actTitle=lmp.getsubmittedLniTitle().getText();
 log.debug("-----------Verify the submitted LNI Title-----------");
 Assert.assertTrue(actTitle.contains(expLniTitle));
 log.info("Submitted LNI title is :"+actTitle);
 log.debug("---------submitLniFormAndVerify :Test ended-----------");
 
}
}
