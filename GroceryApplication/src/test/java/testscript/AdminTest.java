package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.GroceryExcelUtility;
import Utilities.RandomDataUtility;
import grocerybase.DemoBase;
import grocerypages.AdminPage;
import grocerypages.LoginPage;

public class AdminTest extends DemoBase {
	@Test
	public void verifyUserIsAbleToAddNewUser() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(0, 1, "LoginPage");
		AdminPage adminpage = new AdminPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		RandomDataUtility randomdata = new RandomDataUtility();
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
//		loginPage.rememberMeonRememberMefield();
		loginPage.clickOnLogin();
		adminpage.clickOnMoreinfo();
		adminpage.clickOnNewButton();
		String newusername = randomdata.createRandomUserName();
		String newpassword =randomdata.createRandomPassword();
		adminpage.enterUserNameOnUserNameField(newusername);
		adminpage.enterPasswordOnPasswordField(newpassword);
		adminpage.clickOnUserType();
		adminpage.clickOnDropDown();
		adminpage.clickOnSave();
		boolean alertdisplayed = adminpage. alertMessage();
		Assert.assertTrue(alertdisplayed,"User not added");
	}
	@Test
	public void verifyUserIsAbleToSearchUser() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(0, 1, "LoginPage");
		String newusername = GroceryExcelUtility.getStringData(4, 0, "LoginPage");
		AdminPage adminpage = new AdminPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
//		loginPage.rememberMeonRememberMefield();
		loginPage.clickOnLogin();
		adminpage.clickOnMoreinfo();
		adminpage.clickOnSearch();
		adminpage.enterSearchUserOnUsernameField(newusername);
		adminpage.clickOnSearchUserType();
		adminpage.selectSearchUserType();
		adminpage.clickOnSearchUser();
		int actual = adminpage.tableRowCount();
		int expected = 1;
		Assert.assertEquals(actual, expected,"Error in searching user");
	}
	@Test
	public void verifyUserIsAbleToReset() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(0, 1, "LoginPage");
		AdminPage adminpage = new AdminPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
//		loginPage.rememberMeonRememberMefield();
		loginPage.clickOnLogin();
		adminpage.clickOnMoreinfo();
		adminpage.clickOnNewButton();
		adminpage.clickOnReset();
		int actual = adminpage.numberOfForms();
		int expected = 0;
		Assert.assertEquals(actual, expected,"Error in searching user");
	}

}
