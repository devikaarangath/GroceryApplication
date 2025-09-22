package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.GroceryExcelUtility;
import constant.Constants;
import grocerybase.DemoBase;
import grocerypages.HomePage;
import grocerypages.LoginPage;

public class HomeTest extends DemoBase {
	@Test
	public void verifyUserIsAbleToLogOut() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		HomePage homepage = new HomePage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
//		loginPage.rememberMeonRememberMefield();
		loginPage.clickOnLogin();
		
		homepage.clickOnadmin();
		homepage.clickOnLogOut();
		String actual = loginPage.getPageTitle();
		String expected ="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constants.NOTLOGOUT);
	}

}
