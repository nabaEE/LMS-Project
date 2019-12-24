package lms.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LNI_ManagementPage 
{
	/*****************Initialization***********************/
	
	@FindBy(xpath="//div[@id='AppsMenuRow']/div/div/a[4]/i")
	private WebElement addNewButton;
	@FindBy(xpath="//tbody[@id='TBody']/tr[1]/td[1]/span")
	private WebElement editLniButton;
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
	@FindBy(id="Error_LNI_Description")
	private WebElement learningNeedDescription;
	@FindBy(id="Course_Coverage")
	private WebElement courseCoverageEditbox;
	@FindBy(id="Business_Benifits")
	private WebElement businessBenefitsEditbox;
	@FindBy(xpath="//tbody[@id='TBody']/tr[1]/td[1]/a/i")
	private WebElement viewButton;
	@FindBy(id="Submit")
	private WebElement submitButton;
	@FindBy(xpath="//tbody[@id='TBody']/tr[1]/td[2]/text()")
	private WebElement submittedLniTitle;
	@FindBy(id="Error_LNI_Title")
	private WebElement lniTitleBlankError;
	@FindBy(id="Error_Project_Name")
	private WebElement projectNameBlankErr;
	@FindBy(id="Error_Project_Code")
	private WebElement projectCodeBlankErr;
	@FindBy(id="Error_SponsoredBy")
	private WebElement sponsorerBlankErr;
	@FindBy(id="Error_LearningCourse_Type")
	private WebElement learningTypeBlankErr;
	@FindBy(id="Error_LearningCourse_Category")
	private WebElement scopeBlankErr;
	@FindBy(id="Error_LNI_Classification")
	private WebElement classificationBlankErr;
	@FindBy(id="Error_Priority_Level")
	private WebElement priorityLevelBlankErr;
	@FindBy(id="Error_Duration")
	private WebElement durationBlankErr;
	@FindBy(id="Error_NoOf_Partcipants")
	private WebElement peopleBlankErr;
	@FindBy(id="Error_Current_Expertise")
	private WebElement currentExpertiseBlankErr;
	@FindBy(id="Error_LNI_Description")
	private WebElement lniDescriptionEditboxBlankErr;
	@FindBy(xpath="//i[text()='close']")
	private WebElement closePopupWin;
	
	
   
/*************Getters Usage****************************/	
	public WebElement getClosePopupWin()
	{
		return closePopupWin;
	}
	public WebElement getSubmittedLniTitle() {
		return submittedLniTitle;
	}
	public WebElement getLniTitleBlankError() {
		return lniTitleBlankError;
	}
	public WebElement getProjectNameBlankErr() {
		return projectNameBlankErr;
	}
	public WebElement getProjectCodeBlankErr() {
		return projectCodeBlankErr;
	}
	public WebElement getSponsorerBlankErr() {
		return sponsorerBlankErr;
	}
	public WebElement getLearningTypeBlankErr() {
		return learningTypeBlankErr;
	}
	public WebElement getScopeBlankErr() {
		return scopeBlankErr;
	}
	public WebElement getClassificationBlankErr() {
		return classificationBlankErr;
	}
	public WebElement getPriorityLevelBlankErr() {
		return priorityLevelBlankErr;
	}
	public WebElement getDurationBlankErr() {
		return durationBlankErr;
	}
	public WebElement getPeopleBlankErr() {
		return peopleBlankErr;
	}
	public WebElement getCurrentExpertiseBlankErr() {
		return currentExpertiseBlankErr;
	}
	public WebElement getLniDescriptionEditboxBlankErr() {
		return lniDescriptionEditboxBlankErr;
	}
	public WebElement getEditLniButton()
	{
		return editLniButton;
	}
	public WebElement getViewButton()
	{
		return viewButton;
	}
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
