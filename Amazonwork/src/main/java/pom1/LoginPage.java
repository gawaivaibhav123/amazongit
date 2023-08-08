package pom1;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
  @FindBy (xpath="//input[@id='username']")
  private WebElement Username ;
  
  @FindBy (xpath= "//input[@name='pwd']")
  private WebElement Password;
  
  @FindBy (xpath="//input[@id='keepLoggedInCheckBox']")
  private WebElement KeepMeLoggedIn;
  @FindBy (xpath="//a[@id='loginButton']")
  private WebElement Login;
  @FindBy (xpath="common files")
  private List<WebElement> ele;
  
  private WebDriver driver;
  private Actions act;
  private JavascriptExecutor js;
  private WebDriverWait wait;
  
  public LoginPage (WebDriver driver){
	  PageFactory.initElements(driver, this);
	  this.driver=driver;
	  
	  act=new Actions(driver);
	  js=(JavascriptExecutor)driver;
	  wait=new WebDriverWait(driver,20);
  }

   public void SendUserName(String UserName) {
  // act.moveToElement (Username).sendKeys("gawaivaibhav14@gmail.com").build().perform();
	  Username.sendKeys(UserName);
   }
   public void SendPassword(String passWord) {
	   wait.until(ExpectedConditions.visibilityOf(Password));
	  Password.sendKeys(passWord);
   }
  // public void ClickOn() {
	//   KeepMeLoggedIn.click();
  // }
  // public void ClickOnLoginButton() {
	//   Login.click();
  // }
  
  
  
  
  
  
 // Another method also
  public void ClickOnAllObject() {
	  Username.sendKeys("gawaivaibhav14@gmail.com");
	  Password.sendKeys("Vaibhav@143");
	  KeepMeLoggedIn.click();
	  Login.click();
  }
}