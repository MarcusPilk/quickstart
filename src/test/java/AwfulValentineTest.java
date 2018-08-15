import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AwfulValentineTest {
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
    public void testWait(){
        driver.get("http://awful-valentine.com/purchase-forms/slow-ajax/");
        driver.findElement(By.id("go")).click();
        WebElement dynamicElement = (new WebDriverWait(driver,10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("success")));

        assertTrue(dynamicElement.isDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
