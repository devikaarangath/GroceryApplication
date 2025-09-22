package testscript;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.GroceryExcelUtility;
import constant.Constants;
import grocerybase.DemoBase;
import grocerypages.LoginPage;


public class LoginTest extends DemoBase {
	
	@Test
	public void verifyUserWithValidCredenetials() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage (driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.rememberMeonRememberMefield();
		loginPage.clickOnLogin();
		boolean dashboarddisplay = loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashboarddisplay,Constants.VALIDCREDENDIALERROR);
	}
	@Test
	public void verifyLoginWithInValidUserNameAndValidPassword() throws IOException {
		String username = GroceryExcelUtility.getStringData(1, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage (driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.rememberMeonRememberMefield();
		loginPage.clickOnLogin();
		String actual = loginPage.getPageTitle();
		String expected ="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constants.INVALIDUSERNAME);
	}
	@Test
	public void verifyLoginWithValidUserNameInvalidPassword() throws IOException {
		String username = GroceryExcelUtility.getStringData(2, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginPage = new LoginPage (driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.rememberMeonRememberMefield();
		loginPage.clickOnLogin();
		String actual = loginPage.getPageTitle();
		String expected ="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constants.INVALIDPASSWORD);
	}
	
	@Test
	public void verifyLoginWithInValidCredentials() throws IOException {
		String username = GroceryExcelUtility.getStringData(3, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage (driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
		loginPage.rememberMeonRememberMefield();
		loginPage.clickOnLogin();
		String actual = loginPage.getPageTitle();
		String expected ="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constants.INVALIDCREDENDIALS);
	}
	

}
