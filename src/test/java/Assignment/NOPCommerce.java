package Assignment;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom_Package.Dashboard_POM;
import pom_Package.Login_POM;

public class NOPCommerce {

	public static WebDriver driver;
	public static Login_POM lp = new Login_POM();
	public static WebDriverWait wait;
	public static ExtentReports reports;
	public static ExtentTest test;

	@BeforeSuite
	public static void ExtentR() throws Exception {
		reports = new ExtentReports(ReusableMethods.Dataprop("Path"));
		test = reports.startTest(ReusableMethods.Dataprop("TestName"));
	}
	
	
	@Test(priority = 0, groups = {"Login"})
	public static void NavigatetoPage() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(ReusableMethods.Dataprop("URL"));
		driver.manage().window().maximize();
		if (driver.getTitle().equals(ReusableMethods.Dataprop("Title1"))) {
			test.log(LogStatus.PASS, "Successfully navigated to website.");

		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(ReusableMethods.ScreenCapture(driver))+"Navigation to website unsuccessful.");
		}
	}

	
	@Test(priority = 1, groups = {"Login"})
	public static void LogIn() throws Exception {
		wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(Login_POM.Email()));
		Login_POM.Email().clear();
		Login_POM.Email().sendKeys(ReusableMethods.Dataprop("Email"));
		Login_POM.Password().clear();
		Login_POM.Password().sendKeys(ReusableMethods.Dataprop("Password"));
		Login_POM.Submit().click();
		if (driver.getTitle().contentEquals(ReusableMethods.Dataprop("Title2"))) {
			test.log(LogStatus.PASS, "Successfully logged in."); 
		} else {
			test.log(LogStatus.FAIL, test.addScreenCapture(ReusableMethods.ScreenCapture(driver))+ "Login unsuccessful.");
		}
	}
	
	@Test(priority =2, dependsOnGroups = {"Login"})
	public static void DashboardOrders() {
		wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(Dashboard_POM.Catalog()));
		Dashboard_POM.Catalog().click();
		wait.until(ExpectedConditions.elementToBeClickable(Dashboard_POM.pdts()));
		Dashboard_POM.pdts().click();
	}
	
	@AfterSuite 
	public static void teardown() {
		ReusableMethods.reports.endTest(ReusableMethods.test);
		ReusableMethods.reports.flush();
		
	}
}
