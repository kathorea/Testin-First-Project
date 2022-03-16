package pomtest;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.HeaderPage;
import pom.LoginPage;
import utils.Utility;

public class TestNgClass extends Browser
{
	private WebDriver driver;
	private HeaderPage headerPage;
	private LoginPage loginPage;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	String testId;
	
	@BeforeTest()
	@Parameters("browser")
	public void launchBrowserName(String browserName)
	{
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
		System.out.println("LaunchBrowser");
    	if(browserName.equals("FireFox"))
    	{
          driver=launchChromeBrowser();
    	}
    
    if(browserName.equals("Edge"))
     {
    	driver=launchEdgeBrowser();
     }
	}
	
	@BeforeClass
	public void launchBrowser()
	{
		LoginPage loginPage=new LoginPage(driver);
		headerPage=new HeaderPage(driver);
	}

	@BeforeMethod
	public void logInToApplication() throws EncryptedDocumentException, IOException
	{
		driver.get("http://localhost/login.do");
		driver.manage().window().maximize();
		
		String user=Utility.getdataFromExcel("Automation Test",1,0);
		String pass=Utility.getdataFromExcel("Automation Test",1,1);
		
		loginPage=new LoginPage(driver);
		loginPage.sendUserName(user);
		loginPage.sendPassword(pass);
		loginPage.clickKeepMeLoggedIn();
		loginPage.clickLogIn();
	}
	
	@Test
	public void verifyUserTab()
	{
		testId="1102";
		headerPage=new HeaderPage(driver);
		headerPage.clickUsers();
	}
	
	@Test
	public void verifyReportButton()
	{
		testId="1103";
	    headerPage=new HeaderPage(driver);
		headerPage.clickReports();		
	}
	
	@AfterMethod
	public void logOut() throws IOException, InterruptedException
	{
		Utility.screenshot(driver, testId);
		headerPage.clickLogOut();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		loginPage=null;
	}
	
	@AfterTest()
	public void closedBrowser()
	{
		System.out.println("close Browser");
		driver.quit();
		driver=null;
		System.gc();
	}
}
