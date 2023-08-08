package test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom1.HomePage;
import pom1.LoginPage;
import util.Utilityclass;



public class Verification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub'
		LoginPage  lg;
		HomePage   hp;
		
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver_win32\\chromedriver.exe");
  WebDriver driver= new ChromeDriver();
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  
  // testcase 1= task page
  driver.get("https://online.actitime.com/moralix/login.do");
    lg=new LoginPage(driver);
   lg.ClickOnAllObject();
   
    hp=new HomePage(driver);
   hp.OPenTask();
   
   String url=driver.getCurrentUrl();
   String Title=driver.getTitle();
   System.out.println(url);
   System.out.println(Title);
   
   if(url.equals("https://online.actitime.com/moralix/tasks/tasklist.do")&& Title.equals("actiTIME - Task List")) {
	   System.out.println("pass");
   }
	else {
		System.out.println("fail");
		   
}
   
   hp.ClickOnLogout();
   
   //test case 2= Reports page
   
   driver.get("https://online.actitime.com/moralix/login.do");
   lg=new LoginPage(driver);
   String UserName1=Utilityclass.FetchData("Sheet1", 1, 0);
   String passWord1=Utilityclass.FetchData("Sheet1", 1, 1);
   lg.ClickOnAllObject();
   hp=new HomePage(driver);
   hp.reports();
   
   String url1=driver.getCurrentUrl();
   String Title1=driver.getTitle();
   System.out.println("url1");
   System.out.println("Title1");
   
   if(url.equals("https://online.actitime.com/moralix/reports/dashboard.do")&& Title.equals("actiTIME - Reports Dashboard")) {
	   System.out.println("pass");
   }
   else {
	   System.out.println("Failed");
   }
   hp.ClickOnLogout();
   }
	}