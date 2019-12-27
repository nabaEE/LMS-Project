package lms.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LniSummaryPage 
{
/**********Initialization***************/
@FindBy(xpath="//form[@id='E2ProForm_1994']/div/div/div/fieldset/div[2]/div[1]/p/span")
private WebElement lniTitle;
@FindBy(xpath="//form[@id='E2ProForm_1994']/div/div[5]/div/fieldset/legend/span/i")
private WebElement clickEligibility;
@FindBy(id="Submit")
private WebElement saveAndContinueButton;
@FindBy(id="Remarks")
private WebElement remarksEditbox;
@FindBy(xpath="//form[@id='E2ProForm_1994']/div[1]/div[1]/div/fieldset/div[2]/div[1]/p/span")
private WebElement lniSummaryTitle;
@FindBy(xpath="//div[@id='PopUpCont']/div[1]/button/i")
private WebElement closeLniSummaryPage;
@FindBy(xpath="//form[@id='E2ProForm_1994']/div/div[1]/div/fieldset/legend/span/i")
private WebElement lniSummaryEditButton;
@FindBy(xpath="//div[@id='EligibilityDiv']/p[2]/label/span")
private WebElement clickEligibilityCheckbox;
@FindBy(xpath="//fieldset[@id='Field_Location']/p/label/span")
private WebElement clickSelectAllLocationCheckbox;
@FindBy(xpath="//span[@id='LocationsCheckBoxes']/div/div/p/label/span[text()='Chennai']")
private WebElement clickChennaiLocation;
@FindBy(xpath="//tbody/tr/td[1]")
private WebElement checkEnteredLocation;
	
	
	
	
/***************Getters Usage*************/
public WebElement getCheckEnteredLocation()
{
	return checkEnteredLocation;
}
public WebElement getClickChennaiLocation()
{
	return clickChennaiLocation;
}
public WebElement getClickSelectAllLocationCheckbox()
{
	return clickSelectAllLocationCheckbox;
}
public WebElement getClickEligibilityCheckbox()
{
	return clickEligibilityCheckbox;
}
public WebElement getLniSummaryEditButton()
{
	return lniSummaryEditButton;
}
public WebElement getCloseLniSummaryPage()
{
	return closeLniSummaryPage;
}
public WebElement getLniSummaryTitle()
{
	return lniSummaryTitle;
}
public WebElement getRemarksEditbox()
{
	return remarksEditbox;
}
public WebElement getLniTitle()
{
	return lniTitle;
}
public  WebElement getClickEligibility()
{
	return clickEligibility;
}
public WebElement getSaveAndContinueButton()
{
	return saveAndContinueButton;
}
	
	
	
/***************Utilization*************/

}
