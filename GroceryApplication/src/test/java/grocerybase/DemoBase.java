package grocerybase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

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
		
	}
	public void browserclose() {
		//driver.close();
		//driver.quit();
	}

	
}

