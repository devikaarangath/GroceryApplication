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
	
	public void clickOnadmin() {
		admin.click();
	}
	public void clickOnLogOut() {
		logout.click();
		
		
	}
		
	}