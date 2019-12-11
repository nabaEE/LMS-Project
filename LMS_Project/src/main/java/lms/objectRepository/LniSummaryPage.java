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
@FindBy(xpath="//div[@id='PopUpCont']/div[1]/span")
private WebElement lniSummaryTitle;
@FindBy(xpath="//div[@id='PopUpCont']/div[1]/button/i")
private WebElement closeLniSummaryPage;
	
	
	
	
/***************Getters Usage*************/
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
