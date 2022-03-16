package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser 
{
	public static WebDriver launchChromeBrowser()
	{
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Downloads\\geckodriver.exe");
		 WebDriver  driver=new FirefoxDriver();
		 return driver;
	}
	
	public static WebDriver launchEdgeBrowser()
	{
		System.setProperty("webdriver.edge.driver","C:\\Users\\DELL\\Downloads\\msedgedriver.exe");
	    WebDriver driver=new EdgeDriver();
	    return driver;
	}

}
