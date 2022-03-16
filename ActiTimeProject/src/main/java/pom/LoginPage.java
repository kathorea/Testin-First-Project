package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy (xpath="//input[@id='username']")
	private WebElement userName;
	
	@FindBy (xpath="//input[@name='pwd']")
	private WebElement password;

	@FindBy (xpath="//input[@id='keepLoggedInCheckBox']")
	private WebElement keepMeLoggedIn;
	
	@FindBy (xpath="//div[text()='Login ']")
	private WebElement logIn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendUserName(String user)
	{
		userName.sendKeys("admin");
	}
	
	public void sendPassword(String pass)
	{
		password.sendKeys("manager");
	}
	
	public void clickKeepMeLoggedIn()
	{
		keepMeLoggedIn.click();
	}
	
	public void clickLogIn()
	{
		logIn.click();
	}
}
