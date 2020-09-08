package TestNGTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity1_TestNG {
	WebDriver driver;
  @Test
  public void exampleTestCase() throws InterruptedException {
	  //Thread.sleep(5000);
	  String title = driver.getTitle();
	//Print the title of the page
      System.out.println("Page title is: " + title);
    // assertion
      Assert.assertEquals("Training Support", title);
      Thread.sleep(2000);
      driver.findElement(By.id("about-link")).click();
      
      //Print title of new page
      System.out.println("New page title is: " + driver.getTitle());
      
      Assert.assertEquals(driver.getTitle(), "About Training Support");
      
  }
  
    
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net");
  }

  @AfterMethod
  public void afterMethod() {
	  //close
	  driver.quit();
  }

}
