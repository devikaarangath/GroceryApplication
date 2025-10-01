package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}
	
	public void selectDropdownWithIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);

	}
	//method to perform click action
	
	public void sendDataToElement(WebElement element  ) {
		element.click();
	}
	//method to perform sendKeys action
	public void clickElement(WebElement element, String text) {
		element.sendKeys(text);
	}
	//method to perform selectbyVisibleText action
	public void selectDatawithVisibleText(WebElement element, String userType) {
		Select select = new Select(element);
		select.selectByVisibleText(userType);
	}
	//Below 2 methods are not used in this project
	public void scrollToElement(WebDriver driver, WebElement  element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void clearElementData(WebElement element  ) {
		element.clear();
	}
	
	}
