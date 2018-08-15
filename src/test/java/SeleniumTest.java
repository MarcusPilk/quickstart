import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.lang.reflect.Array;

import static org.junit.Assert.assertTrue;

public class SeleniumTest {
    WebDriver driver = null;
    Actions action = null;

@Before
public void setUp(){
    System.setProperty("webdriver.chrome.driver","C:/Development/chromedriver_win32/chromedriver.exe");
    driver = new ChromeDriver();
    action = new Actions(driver);
    driver.manage().window().maximize();
}

@Test
public void seleniumTest(){
    driver.get("http://automationpractice.com/index.php");
    driver.findElement(By.id("search_query_top")).click();
    driver.findElement(By.id("search_query_top")).sendKeys("dress");
    driver.findElement(By.name("submit_search")).click();
    assertTrue(getResults() > 0);



}


@After
public void tearDown(){
    driver.quit();
}

private int getResults(){
    String resultsString = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).getText();
    String[] stringList = resultsString.split(" ");
    int resultNum = Integer.parseInt(stringList[0]);
    return resultNum;
}
private void pause(int length){
    try {
        Thread.sleep(length);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
}
