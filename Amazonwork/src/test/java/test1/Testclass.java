package test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom1.HomePage;
import pom1.LoginPage;
import util.Utilityclass;

public class Testclass {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe" );
	WebDriver driver=new ChromeDriver();
	driver.get("https://online.actitime.com/moralix/login.do");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	LoginPage lg=new LoginPage(driver);
	String UserName=Utilityclass.FetchData("Sheet1", 1, 0);
	lg.SendUserName(UserName);
	String passWord=Utilityclass.FetchData("Sheet1", 1, 1);
	lg.SendPassword(passWord);
	//lg.ClickOn();
	//lg.ClickOnLoginButton();
	lg.ClickOnAllObject();
	
	
	HomePage hp=new HomePage(driver);
	hp.OpenTimetrack();
	hp.OPenTask();
	hp.reports();
	hp.OpenUser();
	hp.ClickOnLogout();
}
}
