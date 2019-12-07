package lms.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigurationSetupPage
{
/*****************Initialization***********************/
@FindBy(xpath="//div[@id='showGroups']/div[2]/div[2]/div/div/p")
private WebElement lmsDataSetup;

@FindBy(xpath="//div[@id='Display_ul']/div[5]/li/p")
private WebElement lni_ManagementButton;


/*************Getters Usage****************************/	
public WebElement getLmsDataSetup() {
	return lmsDataSetup;
}

public WebElement getLni_ManagementButton() {
	return lni_ManagementButton;
}
	

/*****************Utilization**************************/

}
