package TestNGTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class Activity10_TestNG {
	WebDriver driver;
	Actions builder;
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  builder = new Actions(driver);
	  driver.get("https://www.training-support.net/selenium/sliders");
  }
  
  @Test(priority=0)
  public void middleValue() {
	  WebElement slider = driver.findElement(By.id("slider"));
	  slider.click();
	  String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
	  Reporter.log("Max Value:"+volumeLevel,true);
	  Assert.assertEquals(volumeLevel, "50");  
  }
  
  @Test(priority=1)
  public void maximumValue() {
	  WebElement slider = driver.findElement(By.id("slider"));
	  builder.clickAndHold(slider).moveByOffset(78, 0).release().build().perform();
	  String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
	  Reporter.log("Max Value:"+volumeLevel,true);
	  Assert.assertEquals(volumeLevel, "100");
  }
  
  @Test(priority=2)
  public void minimumValue() {
	  WebElement slider = driver.findElement(By.id("slider"));
	  builder.clickAndHold(slider).moveByOffset(-78, 0).release().build().perform();
	  String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
	  Reporter.log("Minimum Value:"+volumeLevel,true);
	  Assert.assertEquals(volumeLevel, "0");
  }
  
  @Test(priority=3)
  public void thirtyPercentValue() {
	  WebElement slider = driver.findElement(By.id("slider"));
	  builder.clickAndHold(slider).moveByOffset(-31, 0).release().build().perform();
	  String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
	  Reporter.log("Preset Value:"+volumeLevel,true);
	  Assert.assertEquals(volumeLevel, "30");
  }
  
  @Test(priority=4)
  public void eightyPercentValue() {
	  WebElement slider = driver.findElement(By.id("slider"));
	  builder.clickAndHold(slider).moveByOffset(47, 0).release().build().perform();
	  String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
	  Reporter.log("Perest Value:"+volumeLevel,true);
	  Assert.assertEquals(volumeLevel, "80");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
