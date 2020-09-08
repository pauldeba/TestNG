package TestNGTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2_TestNG {
	WebDriver driver;
	
  @Test
  public void testCaseOne() {
	  // this test case will pass
	  String title = driver.getTitle();
	  System.out.println("Title is: "+title);
	  Assert.assertEquals(title, "Target Practice");
  }
  
  @Test
  public void testCaseSecond() {
	  // this test case will fail
	  WebElement buttonElement = driver.findElement(By.linkText("Black"));
	  Assert.assertTrue(buttonElement.isDisplayed());
	  Assert.assertEquals(buttonElement.getText(), "black");
	  
  }
  
  @Test(enabled = false)
  public void testCaseThird() {
	  // this test will skipped
	  System.out.println("Skipped");
	 //WebElement brown = driver.findElement(By.className("ui black button"));
	 //System.out.println("text: "+brown.getText());
	 
	// Assert.assertTrue(subHeading.isDisplayed());
	 String subHeading = driver.findElement(By.className("sub")).getText();
     Assert.assertTrue(subHeading.contains("Practice"));
	  
  }
  
  @Test
  public void testCaseFour() throws SkipException{
	//This test will be skipped and will be be shown as skipped
	  throw new SkipException("This test will be skipped");
	  
  }
  
  @BeforeClass
  public void beforeClass() {
	  // create new instance of Firefox Driver 
	  driver = new FirefoxDriver();
	  // open the browser
	  driver.get("https://www.training-support.net/selenium/target-practice");
	  
  }

  @AfterClass
  public void afterClass() {
	  // close the browser
	  driver.quit();
  }

}
