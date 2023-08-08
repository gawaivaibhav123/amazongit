package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {
public static WebDriver openChromeBrowser() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	return driver;
}
public static WebDriver openFirefoxBrowser() {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\Downloads\\geckodriver-v0.33.0-win32\\geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	return driver;
}
public static WebDriver openOperaMiniBrowser() {
	System.setProperty("webdriver.opera.driver", "C:\\Users\\Dell\\Downloads\\operadriver_win64\\operadriver_win64\\operadriver.exe");
	WebDriver driver=new OperaDriver();
return driver;
}
}
