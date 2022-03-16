package pomtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.HeaderPage;
import pom.LoginPage;

public class TestingClass 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost/login.do");
		driver.manage().window().maximize();
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.sendUserName("admin");
		loginPage.sendPassword("manager");
		loginPage.clickKeepMeLoggedIn();
		loginPage.clickLogIn();
		
		HeaderPage headerPage=new HeaderPage(driver);
		headerPage.clickReports();
		headerPage.clickUsers();
		String url=driver.getCurrentUrl();
		System.out.println(url);
		String title=driver.getTitle();
		System.out.println(title);
		headerPage.clickLogOut();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
