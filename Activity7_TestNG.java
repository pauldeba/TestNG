package TestNGTest;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity7_TestNG {
	WebDriver driver;
	
  @DataProvider(name="Authentication")
  public Object[][] credentials() {
    return new Object[][] {{"admin","password"}};
  }
  
  @Test(dataProvider = "Authentication")
  public void credentials(String username, String password) {
	  driver.findElement(By.id("username")).sendKeys(username);
	  driver.findElement(By.id(password)).sendKeys(password);
	  driver.findElement(By.xpath("//button[text()='Log in']")).click();
	  String msg = driver.findElement(By.id("action-confirmation")).getText();
	  Reporter.log("Login Sucessful with Message: "+msg,true);
	  Assert.assertEquals(msg, "Welcome Back, admin");
  }

  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/login-form");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
