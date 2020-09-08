/*
 * Checking the page title
Header Tests:
Find the third header and assert the text in the h3 tag.
Find and assert the colour of the fifth header tag element.
Button Tests:
Find the button with the class olive and assert it text.
Find and assert the colour of the first button in the third row.
Group the Header tests under a group, HeaderTests.
Group the Button tests under a group, ButtonTests.
 */
package TestNGTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Activity5_TestNG {
	WebDriver driver;
	
  
  @BeforeClass(alwaysRun=true)
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("https://www.training-support.net/selenium/target-practice"); 
  }
  
  @Test(groups = {"Header Test","Button Test"})
  public void pageTitleTest() {
	  String title = driver.getTitle();
	  System.out.println("Title of the page: "+title);
	  Assert.assertEquals(title, "Target Practice"); 
  }
  
  @Test(groups={"Header Test"}, dependsOnMethods= {"pageTitleTest"})
  public void headerTest1() {
	  String header3=driver.findElement(By.cssSelector("h3#third-header")).getText();
	  Assert.assertEquals(header3, "Third header"); 
	  System.out.println("Header Test 1");
  }
  
  @Test(groups = {"Header Test"}, dependsOnMethods= {"pageTitleTest"})
  public void headerTest2() {
	  WebElement fifthHeader = driver.findElement(By.cssSelector("h5.ui"));
	  Assert.assertEquals(fifthHeader.getCssValue("Color"), "rgb(33, 186, 69)");
	  System.out.println("Header Test 2");
  }
  
  @Test(groups = {"Button Test"}, dependsOnMethods= {"pageTitleTest"})
  public void buttonTest1() {
	  WebElement button1 = driver.findElement(By.xpath("//div/button[@class='ui olive button']"));
	  Assert.assertEquals(button1.getText(), "Olive");
	  System.out.println("Button Test 1");
  }
  
  @Test(groups = {"Button Test"},dependsOnMethods= {"pageTitleTest"})
  public void buttonTest2() {
	  WebElement button2 = driver.findElement(By.xpath("//button[@class='ui brown button']"));
	  Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");
	  System.out.println("Button Test 1");
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  driver.quit();
  }

}
