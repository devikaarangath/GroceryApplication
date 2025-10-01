package grocerypages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class AdminPage {
	public WebDriver driver;
	//constructor creation is mandatory in 
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='small-box bg-info']/a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") private WebElement moreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']") private WebElement newbutton; 
	@FindBy(xpath="//input[@id='username']") private WebElement username;
	@FindBy(xpath="//input[@id='password']") private WebElement password;
	@FindBy(xpath="//select[@id='user_type']") private WebElement usertype;
	@FindBy(xpath="//select[@id='user_type']/option[@value='staff']") private WebElement dropdown;
	@FindBy(xpath="//button[@name='Create']") private WebElement save;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") private WebElement search;
	@FindBy(xpath="//input[@id='un']") private WebElement searchuser;
	@FindBy(xpath="//select[@id='ut']") private WebElement searchusertype;
	@FindBy(xpath="//select[@id='ut']/option[@value='staff']") private WebElement dropdownusertype;
	
	@FindBy(xpath="//button[@name='Search']") private WebElement newusersearch;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") private WebElement reset;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement alertusercreatedsuccessfully;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr") private List<WebElement> tablerows;
	@FindBy(xpath="//section[@class='content']/form") private List<WebElement> forms;
	
	public AdminPage clickOnMoreinfo() {
		moreinfo.click();
		return this;
	}
	
	public AdminPage clickOnNewButton() {
		newbutton.click();
		return this;
	}
	public AdminPage enterUserNameOnUserNameField(String usernamevalue) {
		username.sendKeys(usernamevalue);
		return this;
		
	}
	public AdminPage enterPasswordOnPasswordField(String passwordvalue ) {
		password.sendKeys(passwordvalue);
		return this;
		
	}
    public AdminPage clickOnUserType() {
    	usertype.click();	
    	return this;
    	
    }
    public AdminPage clickOnDropDown() {
    	dropdown.click();	
    	return this;
    	
    }
    public AdminPage clickOnSave() {
    	save.click();
    	return this;
    	
    }
    public AdminPage clickOnSearch() {
    	search.click();
    	return this;
    }
    public AdminPage enterSearchUserOnUsernameField(String searchUserName) {
    	searchuser.sendKeys(searchUserName);
    	return this;
    }
    public AdminPage clickOnSearchUserType() {
    	searchusertype.click();
    	return this;
    }
    public AdminPage selectSearchUserType() {
    	dropdownusertype.click();
    	PageUtility page = new PageUtility();
    	page.selectDropdownWithIndex(usertype,2);
    	return this;
    }
    public void clickOnSearchUser() {
    	newusersearch.click();
    }
    public void clickOnReset() {
    	reset.click();
    }
    public boolean alertMessage() {
    	return alertusercreatedsuccessfully.isDisplayed();
    	
    }
    public int tableRowCount() {
    	return tablerows.size();
    }
    public int numberOfForms() {
    	return forms.size();
    	
    }
}
    
