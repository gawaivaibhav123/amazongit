package test1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import browsers.Base;
import pom1.HomePage;
import pom1.LoginPage;
import util.Utilityclass;

public class Testng12 extends Base{
	
	WebDriver driver;
    LoginPage lg;
    HomePage hp;
   SoftAssert soft; 
   int testid;
   
   @Parameters("browserName")
   @BeforeTest
   public void LaunchBrowser(String browser) {
	   System.out.println("before test");
	   if (browser.equals("Chrome")) {
		   driver=openChromeBrowser();
	   }
	   if(browser.equals("Firefox")) {
		  driver=openFirefoxBrowser() ;
	   }
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
   }
   
   
   
   
   
   
   
 
	
  @BeforeClass
  
  public void createPOMobjects() {
	  System.out.println("before class");
	  lg=new LoginPage(driver);
	  hp=new HomePage(driver);
	//  driver=Base.openChromeBrowser();
	 // driver=Base.openFirefoxBrowser();
	  
  }
  @BeforeMethod
  public void LoginTOaApplication() {
	  System.out.println("before method");
	  driver.get("https://online.actitime.com/moralix/login.do");
	 
	  String UserName=Utilityclass.FetchData("Sheet1",1,0);
	  lg.SendUserName(UserName);
	  
	  String PassWord=Utilityclass.FetchData("Sheet1",1,1);
	  lg.SendPassword(PassWord);
	  
	  lg=new LoginPage(driver);
	  lg.ClickOnAllObject();
	  
	  hp=new HomePage(driver);
	  soft = new SoftAssert();
	  
  }
  @Test
  public void ToVerifyTheTaskButton() {
	  System.out.println("Test A");
	  testid=001;
	  hp.OPenTask();
	  
	  String url=driver.getCurrentUrl();
	  String Title=driver.getTitle();
	  System.out.println(url);
	  System.out.println(Title);
	  
	 // Boolean result=true;
	  
	//  Assert.assertTrue(result);
	soft.assertEquals("https://online.actitime.com/moralix/tasks/tasklist.do", "https://online.actitime.com/moralix/tasks/tasklist.d");
	//  if(url.equals("https://online.actitime.com/moralix/tasks/tasklist.do")&& Title.equals("actiTIME - Task List")) {
	//	 System.out.println("Passed")
	//  }
	//  else {
	//	  System.out.println("failed");
	soft.assertAll();
	  }  
  

	  @Test
	  public void ToVerifyTheReportButton() {
		  testid=002;
		System.out.println("Test B"); 
		hp.reports();
		String url1=driver.getCurrentUrl();
		String Title1=driver.getTitle();
		System.out.println("url1");
		System.out.println("Title1");
		
		Assert.assertEquals("https://online.actitime.com/moralix/reports/dashboard.do", "https://online.actitime.com/moralix/reports/dashboard.do");
		
	//	if(url1.equals("https://online.actitime.com/moralix/reports/dashboard.do")&& Title1.equals("actiTIME - Reports Dashboard")) {
	//		System.out.println("passed");
	//	}
	//	else {
	//		System.out.println("failed");
		}
		
		@Test
		public void TestC() {
			System.out.println("Testc");
			testid=003;
			
		}
	  
  
	  
	  
  @AfterMethod
  public void LogoutFromApplication(ITestResult result) throws IOException {
	  if(ITestResult.FAILURE==result.getStatus()) {
		  Utilityclass.capture(driver, testid);
	  }
	  hp.ClickOnLogout();
	  
	  
  }
  @AfterClass
  public void ClearObject() {
	 lg=null;
	 hp=null;
	  
	  
   //driver.close();
  }
  @AfterTest
  public void ClosedBrowser() {
	  System.out.println("after test");
	  driver.quit();
	  driver=null;
	  System.gc();
  }

  
  
  }
