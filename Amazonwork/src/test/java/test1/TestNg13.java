package test1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg13 {

	@BeforeClass
	public void beforeclass() {
	System.out.println("Before class");
	
	}
	@BeforeMethod
	public void beforemethod() {
	System.out.println("Before Method");
	
	}
	@Test (dependsOnMethods= {"testC","testD"})
	public void testA() {
	System.out.println("Test A");
	}
	
	@Test(priority=1,invocationCount=3)
	public void testB() {
	System.out.println("Test B");
	
	}
	
	@Test
	public void testC() {
	System.out.println("Test C");
	
	}
	
	@Test (timeOut=3000)
	public void testD () throws InterruptedException {
	System.out.println("Test D");	
	Thread.sleep(2000);
	System.out.println("hii");
	}
	
	@Test (enabled=false)
	public void testE() {
	System.out.println("Test E");
	}
	
	@AfterMethod
	public void aftermethod() {
	System.out.println(" After Method");
	
	}
	
	@AfterClass
	public void afterclass() {
	System.out.println(" After class");
	
	}
}
