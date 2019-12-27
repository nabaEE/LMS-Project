package lms.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PendingApprovalPage 
{
/*********************Initialization************************/
@FindBy(xpath="//tbody[@id='TBody']/tr[1]/td[1]/a[2]/i")
private WebElement clickPencilIcon;
@FindBy(id="Remarks")
private WebElement remarksEditbox;
@FindBy(id="Approve")
private WebElement approveButton;
@FindBy(id="Reject")
private WebElement rejectButton;
@FindBy(xpath="//div[@id='snackbar']")
private WebElement approvalMessage;
/**********************Getters Usage************************/
public WebElement getClickPencilIcon()
{
	return clickPencilIcon;
}
public WebElement getRemarksEditbox()
{
	return remarksEditbox;
}
public WebElement getApprovalMessage()
{
	return approvalMessage;
}
public WebElement getApproveButton() {
	return approveButton;
}
public WebElement getRejectButton() {
	return rejectButton;
}
/*********************Utilization***************************/

}
