package Com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Com.Actitime.pom.Homepage;
import Com.Actitime.pom.Loginpage;

public class Baseclass {
	public  static WebDriver driver;
	FileLibrary f = new FileLibrary();
	
	@BeforeSuite
	public void dataBaseConnection() {
		Reporter.log("database connected", true);
	}
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String URL = f.readDataFromPropertyFile("url");
		driver.get(URL);
		Reporter.log("Browser Launched Successfully", true);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		String un = f.readDataFromPropertyFile("username");
		Loginpage lp = new Loginpage(driver);
		lp.getUntbx().sendKeys(un);
		String pw = f.readDataFromPropertyFile("password");
		lp.getPwtbx().sendKeys(pw);
		lp.getLgbtn().click();
		Reporter.log("Logged in Successfully", true);
	}
	
	@AfterMethod
	public void logout() {
		Homepage hp = new Homepage(driver);
		hp.getLogoutlnk().click();
		Reporter.log("Logged out Successfully", true);
	}
	
	@AfterTest
	public void closeBrowser() {
		Reporter.log("Browser Closed Successfully", true);
	}
	
	@AfterSuite
	public void dataBaseDisconnection() {
		Reporter.log("database disconnected Successfully", true);
	}
	
}
