package lms.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LNI_modificationPage
{
/*************Initialization****************/
@FindBy(id="LNI_Title")
private WebElement lniTitle;
@FindBy(id="Submit")
private WebElement saveAndProceedButton;



/*************Getters Usage****************/
public WebElement getLniTitle() 
{
	return lniTitle;
}
public WebElement getSaveAndProceedButton()
{
		return saveAndProceedButton;
}

/*************Utilization****************/






}
