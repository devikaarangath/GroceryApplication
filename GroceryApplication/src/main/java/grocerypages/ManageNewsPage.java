package grocerypages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	//constructor creation is mandatory in 
	public  ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='small-box bg-info']/a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']") private WebElement moreinfo ;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") private WebElement newmanage ;
	@FindBy(xpath="//textarea[@id='news']") private WebElement news ;
	@FindBy(xpath="//button[@type='submit']") private WebElement save ;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") private WebElement searchnews;
	@FindBy(xpath="//input[@class='form-control']") private WebElement searchmanagenews  ;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']") private WebElement searchnewsbutton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") private WebElement resetmanagenews   ;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement alertusercreatedsuccessfully;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr") private List<WebElement> tablerows;
	@FindBy(xpath="//section[@class='content']/form") private List<WebElement> forms;

	
	public void clickOnMoreInfo() {
		moreinfo.click();
	}
	
	
	public void clickOnManageNewsNew() {
		newmanage.click();
		
	}

	public void enterTheNews(String enterthenews) {
		news.sendKeys(enterthenews);

}
	public void saveButtonClick() {
		save.click();
}
	public void enterSearch(String entertitle) {
		searchmanagenews.sendKeys(entertitle);
	}
	public void clickOnSearchNews() {
		searchnews.click();
	}
	public void clickOnSearchNewsButton() {
		searchnewsbutton.click();
	}
	public void resetManageNews() {
		resetmanagenews.click();
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
