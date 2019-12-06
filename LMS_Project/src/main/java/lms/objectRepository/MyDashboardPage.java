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


/****************Getters Usage********************/
public WebElement getAdminIcon() {
	return adminIcon;
}
public WebElement getConfigurationSetupButton() 
{
	return configurationSetupButton;
}


}
