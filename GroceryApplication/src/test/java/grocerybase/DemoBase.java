package grocerybase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Utilities.ScreenshotUtility;
import constant.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DemoBase {
	Properties prop;
	FileInputStream fs;
	
	public WebDriver driver;
	
	@Parameters("browsers")
	@BeforeMethod(alwaysRun=true)
	public void intialiseBrowser(@Optional("Chrome")String browsers) throws Exception {
	prop = new Properties();
	fs = new FileInputStream(Constants.CONFIGPATH);
	prop.load(fs);
	if(browsers.equalsIgnoreCase("Chrome"))
	{
		driver = new ChromeDriver();
	}
	else if(browsers.equalsIgnoreCase("Firefox")){
		driver = new FirefoxDriver();
		
	}
	else if(browsers.equalsIgnoreCase("Edge")){
		WebDriverManager.edgedriver();
	   
		driver = new EdgeDriver();
	} else {
		throw new Exception("Invalid Browser"); 
	}
	
//		driver = new FirefoxDriver();
		WebDriverManager.chromedriver().setup();
//		WebDriverManager.edgedriver()
//		.clearResolutionCache()
//	    .forceDownload()
//	    .setup();
//		driver = new EdgeDriver();
		
		driver.get(prop.getProperty("url")); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//duration - predefined class
	}
	@AfterMethod(alwaysRun=true)
	public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

		ScreenshotUtility screenShot = new ScreenshotUtility();
		screenShot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();

		}
	

	
}

