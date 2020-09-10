package TestNGTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Activity9_TestNG {
	WebDriver driver;
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  Reporter.log("Testing Start |",true);
	  driver.get("https://www.training-support.net/selenium/javascript-alerts");
	  Reporter.log("Open Browser |");
	  //print title of the page
	  Reporter.log("Title of the page: "+driver.getTitle()+" |",true);
  }
 
  @BeforeMethod
  public void beforeMethod() {
	  Reporter.log("Test Case Setup Started |",true);
	  driver.switchTo().defaultContent();
  }

    
  @Test(priority=0)
  public void simpleAlertTestCase() {
	  Reporter.log("simpleAlertTestCase() started |",true);
	  //Click the button to open a simple alert
      driver.findElement(By.id("simple")).click();
      Reporter.log("Simple Alert opened |",true);

      //Switch to alert window
      Alert simpleAlert = driver.switchTo().alert();
      Reporter.log("Switched foucs to alert |",true);
      
      String alertText = simpleAlert.getText();
      Reporter.log("Alert text is: " + alertText + " |",true);
      // Assert
      Assert.assertEquals("This is a JavaScript Alert!", alertText);
      simpleAlert.accept();
      
      Reporter.log("Alert closed");
      
      Reporter.log("Test case ended |");
      
  }
  @Test(priority=1)
  public void confirmAlertTestCase() throws InterruptedException {
	  Reporter.log("confirmAlertTestCase() started |",true);
      //Click the button to open a simple alert
      driver.findElement(By.id("confirm")).click();
      Reporter.log("Confirm Alert opened |",true);

      //Switch to alert window
      Alert confirmAlert = driver.switchTo().alert();
      Reporter.log("Switched focus to alert |", true);
      
      String alertText = confirmAlert.getText();
      Reporter.log("Alert text is: "+alertText+" |",true);
      //Assert
      Thread.sleep(5000);
      Assert.assertEquals(alertText, "This is a JavaScript Confirmation!");
     confirmAlert.accept();
     
     Reporter.log("Alert closed |",true);
     
     Reporter.log("Test case ended |",true);
  }
  
  @Test(priority=2,enabled = true)
  public void promtAlertTestCase() {
	  Reporter.log("promtAlertTestCase() started |",true);
      //Click the button to open a simple alert
      driver.findElement(By.id("prompt")).click();
      Reporter.log("Prompt Alert opened |",true);

      //Switch to alert window
	  Alert prompt = driver.switchTo().alert();
	  String promptText = prompt.getText();
	  Reporter.log("Tile Text is :" +promptText+" |", true);
	  //Assert
	  Assert.assertEquals("This is a JavaScript Prompt!", promptText);
	  //accept the alert
	  prompt.accept();
	  
	  Reporter.log("Alert closed |",true);
	  
      Reporter.log("Test case ended |",true);
	  
  }

  @AfterClass
  public void afterMethod() {
	  Reporter.log("Ending Test |");
	  driver.close();
  }

}
