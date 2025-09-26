package grocerypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	//constructor creation is mandatory in 
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@data-toggle='dropdown']") private WebElement admin;
	@FindBy(xpath="//div[@class='dropdown-menu dropdown-menu-lg dropdown-menu-right text_black show']/a[@href='https://groceryapp.uniqassosiates.com/admin/logout']") private WebElement logout;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']/i[@class='fas fa-arrow-circle-right']") private WebElement adminuser;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") private WebElement managenews;
	
	public HomePage clickOnadmin() {
		admin.click();
		return this;
	}
	public LoginPage clickOnLogOut() {
		logout.click();
		return new LoginPage(driver);
		
		
	}
	public AdminPage clickOnAdminUsers() {
		adminuser.click();
		return new AdminPage(driver);
		
		
	}
	public ManageNewsPage clickOnManageNews() {
		managenews.click();
		return new ManageNewsPage(driver);
		
		
	}
	
	
		
	}