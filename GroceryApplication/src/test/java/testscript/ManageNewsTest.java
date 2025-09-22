package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.GroceryExcelUtility;
import Utilities.RandomDataUtility;
import constant.Constants;
import grocerybase.DemoBase;
import grocerypages.AdminPage;
import grocerypages.LoginPage;
import grocerypages.ManageNewsPage;

public class ManageNewsTest extends DemoBase {
	@Test
	public void verifyUserIsAbleToAddNewUser() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage loginPage = new LoginPage(driver);
		ManageNewsPage newspage = new ManageNewsPage(driver);
		RandomDataUtility randomdata = new RandomDataUtility();
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
//		loginPage.rememberMeonRememberMefield();
		loginPage.clickOnLogin();
		newspage.clickOnMoreInfo();
		newspage.clickOnManageNewsNew();
		String news = GroceryExcelUtility.getStringData(5, 0, "LoginPage");
		newspage.enterTheNews(news);
		newspage.saveButtonClick();
		
		boolean alertdisplayed = newspage.alertMessage();
		Assert.assertTrue(alertdisplayed,Constants.NEWSNOTADDED);
	}
	@Test
	public void verifyUserIsAbleToSearchUser() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(0, 1, "LoginPage");
		AdminPage adminpage = new AdminPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		ManageNewsPage newspage = new ManageNewsPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
//		loginPage.rememberMeonRememberMefield();
		loginPage.clickOnLogin();
		newspage.clickOnMoreInfo();
		newspage.clickOnSearchNews();
		
		String news = GroceryExcelUtility.getStringData(5, 0, "LoginPage");
		newspage.enterSearch(news);
		newspage.clickOnSearchNewsButton();
		int actual = adminpage.tableRowCount();
		int expected = 1;
		Assert.assertEquals(actual, expected,Constants.ERRORINSEARCHINGNEWS);
	}
	@Test
	public void verifyUserIsAbleToReset() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(0, 1, "LoginPage");
		AdminPage adminpage = new AdminPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		ManageNewsPage newspage = new ManageNewsPage(driver);
		loginPage.enterUsernameOnUsernameField(username);
		loginPage.enterPasswordOnPasswordField(password);
//		loginPage.rememberMeonRememberMefield();
		loginPage.clickOnLogin();
		newspage.clickOnMoreInfo();
		newspage.clickOnSearchNews();
		newspage.resetManageNews();
		int actual = adminpage.numberOfForms();
		int expected = 0;
		Assert.assertEquals(actual, expected,Constants.ERRORINRESETINGPAGE);
	}


}
