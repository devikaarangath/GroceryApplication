package grocerypages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	public WebDriver driver;
	//constructor creation is mandatory in 
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']") private WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']") private WebElement password;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']") private WebElement signin;
	@FindBy(xpath="//label[@for='remember']") private WebElement rememberme;
	@FindBy(xpath="//p[text()='Dashboard']") private WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") private WebElement loginpagetitle;
	
	public void enterUsernameOnUsernameField(String usernameValue) {
		username.sendKeys(usernameValue);
	}
	public void enterPasswordOnPasswordField(String passwordValue) {
		password.sendKeys(passwordValue);
		
	}
	public void  clickOnLogin() {
		signin.click();
	}
	public void rememberMeonRememberMefield() {
		rememberme.click();
		
	}
	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}
	public String getPageTitle() {
		return loginpagetitle.getText();
	}
}
	