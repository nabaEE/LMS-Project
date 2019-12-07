package lms.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LNI_ManagementPage 
{
	/*****************Initialization***********************/
	
	@FindBy(xpath="//div[@id='AppsMenuRow']/div/div/a[4]/i")
	private WebElement addNewButton;
	@FindBy(id="LNI_Title")
	private WebElement lniTitleEditbox;
	@FindBy(id="Project_Name")
	private WebElement projectNameEditbox;
	@FindBy(id="Project_Code")
	private WebElement projectCode;
	@FindBy(xpath="//div[@id='div_SponsoredBy']/div/input")
	private WebElement sponsorerDropdown;
	@FindBy(xpath="//span[contains(text(),'Trianz University')]")
	private WebElement selectTrianzUniversity;
	@FindBy(xpath="//div[@id='div_LearningCourse_Type']/div/input")
	private WebElement learningTypeDropdown;
	@FindBy(xpath="//div[@id='div_LearningCourse_Type']/div/ul/li[2]/span")
	private WebElement selectSkillBased;
	@FindBy(xpath="//div[@id='div_LearningCourse_Category']/div/input")
	private WebElement scopeDropdown;
	@FindBy(xpath="//div[@id='div_LearningCourse_Category']/div/ul/li[2]/span")
	private WebElement pickScopeAsTechnical;
	@FindBy(xpath="//div[@id='div_LNI_Classification']/div/input")
	private WebElement classificationDropdown;
	@FindBy(xpath="//div[@id='div_LNI_Classification']/div/ul/li[3]/span")
	private WebElement selectClassificationAsProject;
	@FindBy(xpath="//div[@id='div_Priority_Level']/div/input")
	private WebElement priorityLevelDropdown;
	@FindBy(xpath="//div[@id='div_Priority_Level']/div/ul/li[2]/span")
	private WebElement selectPriorityAs_1Month;
	@FindBy(id="Duration")
	private WebElement durationEditbox;
	@FindBy(id="NoOf_Partcipants")
	private WebElement peopleEditbox;
	@FindBy(xpath="//div[@id='div_Current_Expertise']/div/input")
	private WebElement currentExpertiseDropdown;
	@FindBy(xpath="//div[@id='div_Current_Expertise']/div/ul/li[2]/span")
	private WebElement selectBeginner;
	@FindBy(xpath="//div[@id='div_External_Program']/div/p/label/span")
	private WebElement certificationSwitchButton;
	@FindBy(id="External_ProgramName")
	private WebElement externalProgramNameEditbox;
	@FindBy(id="LNI_Cost")
	private WebElement costEditbox;
	@FindBy(id="div_Org_Currencies")
	private WebElement currencyDropdown;
	@FindBy(xpath="//div[@id='div_Org_Currencies']/div/ul/li[3]/span")
	private WebElement pickCurrencyINR;
	@FindBy(id="LNI_Description")
	private WebElement learningNeedDescription;
	@FindBy(id="Course_Coverage")
	private WebElement courseCoverageEditbox;
	@FindBy(id="Business_Benifits")
	private WebElement businessBenefitsEditbox;
	@FindBy(id="Submit")
	private WebElement submitButton;
	@FindBy(xpath="//tbody[@id='TBody']/tr[1]/td[2]/text()")
	private WebElement submittedLniTitle;
	
	
   /*************Getters Usage****************************/	
	public WebElement getsubmittedLniTitle()
	{
		return submittedLniTitle;
	}
	public WebElement getLearningNeedDescription()
	{
		return learningNeedDescription;
	}
	public WebElement getExternalProgramNameEditbox() {
		return externalProgramNameEditbox;
	}
	public WebElement getCostEditbox() {
		return costEditbox;
	}
	public WebElement getCurrencyDropdown() {
		return currencyDropdown;
	}
	public WebElement getPickCurrencyINR() {
		return pickCurrencyINR;
	}
	public WebElement getSelectBeginner()
	{
		return selectBeginner;
	}
	public WebElement getSelectPriorityAs_1Month()
	{
		return selectPriorityAs_1Month;
	}
	public WebElement getSelectClassificationAsProject()
	{
		return selectClassificationAsProject;
	}
	public WebElement getPickScopeAsTechnical()
	{
		return pickScopeAsTechnical;
	}
	public WebElement getSelectSkillBased()
	{
		return selectSkillBased;
	}
	
	public WebElement getAddNewButton() {
		return addNewButton;
	}
	public WebElement getLniTitleEditbox() {
		return lniTitleEditbox;
	}
	public WebElement getProjectNameEditbox() {
		return projectNameEditbox;
	}
	public WebElement getProjectCode() {
		return projectCode;
	}
	public WebElement getSponsorerDropdown() {
		return sponsorerDropdown;
	}
	public WebElement getSelectTrianzUniversity()
	{
		return selectTrianzUniversity;
	}
	public WebElement getLearningTypeDropdown() {
		return learningTypeDropdown;
	}
	public WebElement getScopeDropdown() {
		return scopeDropdown;
	}
	public WebElement getClassificationDropdown() {
		return classificationDropdown;
	}
	public WebElement getPriorityLevelDropdown() {
		return priorityLevelDropdown;
	}
	public WebElement getDurationEditbox() {
		return durationEditbox;
	}
	public WebElement getPeopleEditbox() {
		return peopleEditbox;
	}
	public WebElement getCurrentExpertiseDropdown() {
		return currentExpertiseDropdown;
	}
	public WebElement getCertificationSwitchButton() {
		return certificationSwitchButton;
	}
	public WebElement getCourseCoverageEditbox() {
		return courseCoverageEditbox;
	}
	public WebElement getBusinessBenefitsEditbox() {
		return businessBenefitsEditbox;
	}
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	/*****************Utilization**************************/
}
