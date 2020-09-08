package TestNGTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Activity4_TestNG_DemoOne {
  @Test
  public void firstTestCase() {
	  System.out.println("I'm in first test case from demoOne Class");
  }
  
  @Test
  public void secondTestCase() {
	  System.out.println("I'm in second test case from demoOne Class");
  }
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
