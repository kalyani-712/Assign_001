package assignment.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {   
        
	protected static WebDriver driver;
	String URL = "https://sakshingp.github.io/assignment/login.html";
		
	@BeforeSuite
	public void suitrun() {
		System.out.println("============= Suite Execution Start =============");
		Reporter.log("============== Suite Session Started ============", true);
	}
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setupApplication() throws Exception{
		Reporter.log("============= Browser Session Started =============", true);
		System.out.println("============= class execution start =============");
	    //used WebDriver Manager
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
  		driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		System.out.println("============= URL Provided ==============");
	    
		Reporter.log("========== Application Started ==========", true);
      }
	@AfterMethod
	public void closeApplication()
	{
			//	driver.quit();
		Reporter.log("============= Browser Session End =============", true);
		
	}
	
	@AfterSuite
	public void suitend() {
		driver.quit();
		System.out.println("============= Suite Execution END =============");
	}
}
