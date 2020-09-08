package TestNGTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity3_TestNG {
	WebDriver driver;
  @Test
  public void testCaseOne() {
	  // find user name and password field
	  WebElement login = driver.findElement(By.id("username"));
	  WebElement password = driver.findElement(By.id("password"));
	  
	  // enter credentials
	  login.sendKeys("admin");
	  password.sendKeys("password");
	  WebElement bt_Login = driver.findElement(By.xpath("//button[@class='ui button']"));
	  // click login
	  bt_Login.click();
	  // read login message
	  String conMsg = driver.findElement(By.id("action-confirmation")).getText();
	  System.out.println("Message: "+conMsg);
	  Assert.assertEquals(conMsg, "Welcome Back, admin");
	  Reporter.log("testing");
  }
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/login-form");
  }

  @AfterClass
  public void afterClass() {
	  // close browser
	  driver.quit();
  }

}
