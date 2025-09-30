package testscript;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.GroceryExcelUtility;
import constant.Constants;
import grocerybase.DemoBase;
import grocerypages.HomePage;
import grocerypages.LoginPage;


public class LoginTest extends DemoBase {
	HomePage homepage;
	
	
	@Test(groups= {"smoke"},priority = 1,description="User login using valid username and valid password",retryAnalyzer = retry.Retry.class)
	public void verifyUserWithValidCredenetials() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginPage = new LoginPage (driver);
		loginPage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		//loginPage.rememberMeonRememberMefield();
		homepage = loginPage.clickOnLogin();
		boolean dashboarddisplay = loginPage.isDashboardDisplayed();
		Assert.assertTrue(dashboarddisplay,Constants.VALIDCREDENDIALERROR);
	}
	@Test(priority = 2,description="verify loginWith invalid username and validpassword")
	public void verifyLoginWithInValidUserNameAndValidPassword() throws IOException {
		String username = GroceryExcelUtility.getStringData(1, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage (driver);
		loginPage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnLogin();
		//loginPage.rememberMeonRememberMefield();
	
		String actual = loginPage.getPageTitle();
		String expected ="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constants.INVALIDUSERNAME);
	}
	@Test(priority = 3,description="verify login with valid username invalidpassword")
	public void verifyLoginWithValidUserNameInvalidPassword() throws IOException {
		String username = GroceryExcelUtility.getStringData(2, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginPage = new LoginPage (driver);
		loginPage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnLogin();
		//loginPage.rememberMeonRememberMefield();
		
		String actual = loginPage.getPageTitle();
		String expected ="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constants.INVALIDPASSWORD);
	}
	
	@Test(groups= {"smoke"},priority = 4,description="verify loginwith invalid credentials", dataProvider = "loginProvider")
	public void verifyLoginWithInValidCredentials(String username, String password) throws IOException {
		//String username = GroceryExcelUtility.getStringData(3, 0, "LoginPage");
		//String password =GroceryExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage (driver);
		loginPage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnLogin();
		//loginPage.rememberMeonRememberMefield();
		
		String actual = loginPage.getPageTitle();
		String expected ="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constants.INVALIDCREDENDIALS);
	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}

}
