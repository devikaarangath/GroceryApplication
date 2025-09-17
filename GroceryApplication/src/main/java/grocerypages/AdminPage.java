package grocerypages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void clickOnMoreinfo() {
		moreinfo.click();
		
	}
	
	public void clickOnNewButton() {
		newbutton.click();
		
	}
	public void enterUserNameOnUserNameField(String usernamevalue) {
		username.sendKeys(usernamevalue);
		
	}
	public void enterPasswordOnPasswordField(String passwordvalue ) {
		password.sendKeys(passwordvalue);
		
	}
    public void clickOnUserType() {
    	usertype.click();	
    	
    }
    public void clickOnDropDown() {
    	dropdown.click();	
    	
    }
    public void clickOnSave() {
    	save.click();
    	
    }
    public void clickOnSearch() {
    	search.click();
    }
    public void enterSearchUserOnUsernameField(String searchUserName) {
    	searchuser.sendKeys(searchUserName);
    }
    public void clickOnSearchUserType() {
    	searchusertype.click();
    }
    public void selectSearchUserType() {
    	dropdownusertype.click();
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
    
