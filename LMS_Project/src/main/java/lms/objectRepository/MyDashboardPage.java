package lms.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyDashboardPage
{

	/******************Initialization*********************/
@FindBy(xpath="//html//body//header//div[2]//nav//div//ul//li[1]//a//img")
private WebElement adminIcon;
@FindBy(xpath="//ul[@id='AdminDropDowns']//a[text()='Configuration Setup']")
private WebElement configurationSetupButton;
@FindBy(xpath="//ul[@class='right hide-on-med-and-down']/li[4]/a")
private WebElement employeeApprovalButton;
@FindBy(xpath="//ul[@class='right hide-on-med-and-down']/li[5]/a")
private WebElement adminApprovalButton;
@FindBy(xpath="//div[@id='firstPanel']/div/div[2]/ul/div[5]/li/p")
private WebElement learningRequestButton;

/****************Getters Usage********************/
public WebElement getLearningRequestButton()
{
	return learningRequestButton;
}
public WebElement getAdminIcon() {
	return adminIcon;
}
public WebElement getConfigurationSetupButton() 
{
	return configurationSetupButton;
}
public WebElement getEmployeeApprovalButton()
{
	return employeeApprovalButton;
}
public WebElement getAdminApprovalButton()
{
	return adminApprovalButton;
}

}
