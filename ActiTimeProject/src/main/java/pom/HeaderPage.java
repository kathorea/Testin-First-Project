package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage
{
	@FindBy (xpath="//div[text()='Time-Track']")
	private WebElement timeTrack;
	
	@FindBy (xpath="//a[@class='content tasks']")
	private WebElement tasks;

	@FindBy (xpath="//a[@class='content reports']")
	private WebElement reports;
	
	@FindBy (xpath="//a[@class='content users']")
	private WebElement users;
	
	@FindBy (xpath="//a[@class='content calendar']")
	private WebElement workSchedule;
	
	@FindBy (xpath="//a[@id='logoutLink']")
	private WebElement logOut;
	
	public HeaderPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickReports()
	{
		reports.click();
	}
	
	public void clickUsers()
	{
		users.click();
	}
	
	public void clickLogOut()
	{
		logOut.click();
	}

}
