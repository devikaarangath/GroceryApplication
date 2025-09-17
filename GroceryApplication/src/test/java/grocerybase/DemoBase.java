package grocerybase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utilities.ScreenshotUtility;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DemoBase {
	public WebDriver driver;

@BeforeMethod

	public void intialiseBrowser() {
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		WebDriverManager.chromedriver().setup();
//		WebDriverManager.edgedriver()
//		.clearResolutionCache()
//	    .forceDownload()
//	    .setup();
//		driver = new EdgeDriver();
		
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//duration - predefined class
	}
	@AfterMethod
	public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {

		ScreenshotUtility screenShot = new ScreenshotUtility();
		screenShot.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();

		}
	

	
}

