package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.GroceryExcelUtility;
import Utilities.RandomDataUtility;
import constant.Constants;
import grocerybase.DemoBase;
import grocerypages.AdminPage;
import grocerypages.HomePage;
import grocerypages.LoginPage;

public class AdminTest extends DemoBase {
	HomePage homepage;
	AdminPage adminpage;

	@Test(priority = 1, description = "verify user is able to addnewuser")
	public void verifyUserIsAbleToAddNewUser() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password = GroceryExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);

		RandomDataUtility randomdata = new RandomDataUtility();
		loginPage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
//		loginPage.rememberMeonRememberMefield();
		homepage = loginPage.clickOnLogin();
		adminpage = homepage.clickOnAdminUsers();
//		adminpage.clickOnMoreinfo();
		adminpage.clickOnNewButton();
		String newusername = randomdata.createRandomUserName();
		String newpassword = randomdata.createRandomPassword();
		adminpage.enterUserNameOnUserNameField(newusername).enterPasswordOnPasswordField(newpassword).clickOnUserType()
				.clickOnDropDown().clickOnSave();
		boolean alertdisplayed = adminpage.alertMessage();
		Assert.assertTrue(alertdisplayed, Constants.USERNOTADDED);
	}

	@Test(priority = 2, description = "verify user isable to searchuser")
	public void verifyUserIsAbleToSearchUser() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password = GroceryExcelUtility.getStringData(0, 1, "LoginPage");
		String existingUser = GroceryExcelUtility.getStringData(0, 0, "AdminPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
//		loginPage.rememberMeonRememberMefield();
		homepage = loginPage.clickOnLogin();
		adminpage = homepage.clickOnAdminUsers();
//		adminpage.clickOnMoreinfo();
		adminpage.clickOnSearch().enterSearchUserOnUsernameField(existingUser).clickOnSearchUserType()
				.selectSearchUserType().clickOnSearchUser();

		int actual = adminpage.tableRowCount();
		int expected = 1;
		Assert.assertEquals(actual, expected, Constants.ERRORINSEARCHINGUSER);
	}

	@Test(priority = 3, description = "verify user is able to reset")
	public void verifyUserIsAbleToReset() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password = GroceryExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
//		loginPage.rememberMeonRememberMefield();
		homepage = loginPage.clickOnLogin();
		adminpage = homepage.clickOnAdminUsers();
//		adminpage.clickOnMoreinfo();
		adminpage.clickOnNewButton().clickOnReset();
		int actual = adminpage.numberOfForms();
		int expected = 0;
		Assert.assertEquals(actual, expected, Constants.SEARCHINGUSERERROR);
	}

}
