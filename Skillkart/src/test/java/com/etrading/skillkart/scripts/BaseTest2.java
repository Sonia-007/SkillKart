package com.etrading.skillkart.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.etrading.skillkart.generic.AutoConstants;
import com.etrading.skillkart.generic.PropertyFile;
import com.etrading.skillkart.generic.TakeScreenShotLIb;
import com.etrading.skillkart.generic.WebActionUtil;
import com.etrading.skillkart.pages.HomePage;
import com.etrading.skillkart.pages.LoginPage;


public class BaseTest2 implements AutoConstants
	{
		public WebDriver driver;
		WebActionUtil webActionUtil;
		HomePage hp;
		
		@BeforeClass
		public void openApp(@Optional(DEFAULT_BROWSER)String browser)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				String chrome_key=PropertyFile.getpropertyValue("./resources/config2.properties", "CHROME_KEY");
				String chrome_path=PropertyFile.getpropertyValue("./resources/config2.properties", "CHROME_PATH");
				System.setProperty(chrome_key,chrome_path);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);	
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty(GECKO_KEY, GECKO_PATH);
				FirefoxOptions options = new FirefoxOptions();
				options.addPreference("dom.webnotifications.enabled", false);
				driver = new FirefoxDriver(options);
			}
			else
			{
				throw new IllegalArgumentException("Only Chrome and Firefox is Supported");
			}
			driver.manage().window().maximize();
			String implicit1=PropertyFile.getpropertyValue("./resources/config2.properties", "implicit");
			String explicit1=PropertyFile.getpropertyValue("./resources/config2.properties", "explicit");
			long iTO=Long.parseLong(implicit1);
			long eTO=Long.parseLong(explicit1);
			driver.manage().timeouts().implicitlyWait(iTO,TimeUnit.SECONDS);
			String appUrl=PropertyFile.getpropertyValue("./resources/config.properties", "appUrl");
			driver.get(appUrl);
			webActionUtil = new WebActionUtil(driver, eTO);
		}
		
		@Parameters({"un","pwd"})
		@BeforeMethod
		public void loginToApp() throws Exception
		{
			LoginPage lp = new LoginPage(driver, webActionUtil);
			String un=PropertyFile.getpropertyValue("./resources/config.properties", "username");
			String pwd=PropertyFile.getpropertyValue("./resources/config.properties", "password");
			lp.login(un, pwd);
		}
		
		@AfterMethod
		public void logout(ITestResult result)
		{
			try
			{
				 hp = new HomePage(driver, webActionUtil);
				hp.Logout();
			}
			catch(Exception e)
			{
				
			}
			String testName = result.getName();
			int status=result.getStatus();
			if(status==ITestResult.FAILURE)
			{
				Reporter.log(TakeScreenShotLIb.screenShot(driver, IMAGE_PATH, testName), true);
			}
		}
		
		/*@AfterClass(alwaysRun=true)
		public void closeApp()
		{
			driver.quit();
		}*/
	}

