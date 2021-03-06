package lms.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import lms.genericLibraries.BaseClass;
import lms.genericLibraries.WebDriverUtils;

public class LoginPage 
{
	/******************Initialization*********************/
	@FindBy(id="User_Email")
	private WebElement userNameEdt;
	@FindBy(id="Password")
	private WebElement passWordEdt;
	@FindBy(xpath="//*[@id=\"login_normal\"]")
	private WebElement loginBtn;
	@FindBy(xpath="//i[contains(@class,'material-icons right dropdown-icon')]")
	private WebElement dropDownArrow;
	@FindBy(linkText="Logout")
	private WebElement logoutBtn;
	@FindBy(xpath="//html//frameset//frameset//frame")
	private WebElement accessFrameToLogin;
	@FindBy(xpath="//div[@class='row logout-box']/div[2]/div[3]/label/a")
	private WebElement clickHereToLogin;
	/********************************Getters Usage*****************************************/
	public WebElement getAccessFrameToLogin()
	{
		return accessFrameToLogin;
	}
	public WebElement getClickHereToLogin()
	{
		return clickHereToLogin;
	}
	public WebElement getUserNameEdt()
	{
		return userNameEdt;
	}
	public WebElement getpassWordEdt()
	{
		return passWordEdt;
	}
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	public WebElement getLogoutBtn()
	{
		return logoutBtn;
	}
	public WebElement getDropDownArrow()
	{
		return dropDownArrow;
	}
	/************************************Utilization******************************************/
	public void loginToPage(String username, String password)
	{
		BaseClass.driver.switchTo().frame(BaseClass.driver.findElement(By.xpath("//html//frameset//frameset//frame")));
		userNameEdt.sendKeys(username);
		passWordEdt.sendKeys(password);
		loginBtn.click();
	 }
	  public void logOut()
	  {
	  WebDriverUtils.waitForPageToLoad(BaseClass.driver);
	  WebDriverUtils.waitForElementPresent(BaseClass.driver, dropDownArrow);
	  dropDownArrow.click();
	  logoutBtn.click();
	  }
	
	
}
