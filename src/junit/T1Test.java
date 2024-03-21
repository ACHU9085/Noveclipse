package junit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.After;

public class T1Test {
  private WebDriver driver;
 
  @Before
  public void setUp() {
    driver = new ChromeDriver();
   
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void t1() {
    driver.get("https://www.google.com/");
    driver.findElement(By.name("q")).click();
    driver.findElement(By.name("q")).sendKeys("books");
    driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]")).click();
    driver.findElement(By.name("btnK")).click();
  }
}
