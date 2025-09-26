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
import grocerypages.HomePage;
import grocerypages.LoginPage;
import grocerypages.ManageNewsPage;

public class ManageNewsTest extends DemoBase {
	HomePage homepage;
	ManageNewsPage managenewspage;
	@Test(priority= -1,description="verify user is able to addnew news")
	public void verifyUserIsAbleToAddNewNews() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnLogin();
		
		ManageNewsPage newspage = new ManageNewsPage(driver);
		String news = GroceryExcelUtility.getStringData(0, 0, "NewsPage");
		newspage.clickOnMoreInfo().clickOnManageNewsNew().enterTheNews(news).saveButtonClick();
		
		boolean alertdisplayed = newspage.alertMessage();
		Assert.assertTrue(alertdisplayed,Constants.NEWSNOTADDED);
	}
	
	@Test(priority = 1,description="verify user is able to search news")
	public void verifyUserIsAbleToSearchNews() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(0, 1, "LoginPage");
		
		AdminPage adminpage = new AdminPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		ManageNewsPage newspage = new ManageNewsPage(driver);

		loginPage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnLogin();
		String news = GroceryExcelUtility.getStringData(0, 0, "NewsPage");
		newspage.clickOnMoreInfo().clickOnSearchNews().enterSearch(news).clickOnSearchNewsButton();
		int actual = adminpage.tableRowCount();
		int expected = 1;
		Assert.assertTrue(actual > expected, Constants.ERRORINSEARCHINGNEWS);
	}
	
	@Test(priority = 2,description="verify user is able to reset")
	public void verifyUserIsAbleToReset() throws IOException {
		String username = GroceryExcelUtility.getStringData(0, 0, "LoginPage");
		String password =GroceryExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage loginPage = new LoginPage(driver);
		ManageNewsPage newspage = new ManageNewsPage(driver);
		loginPage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnLogin();
		newspage.clickOnMoreInfo().clickOnSearchNews().resetManageNews();
		int actual = newspage.numberOfForms();
		int expected = 0;
		Assert.assertEquals(actual, expected,Constants.ERRORINRESETINGPAGE);
	}


}
