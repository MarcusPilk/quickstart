import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class KatalonTest {

     private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {

            System.setProperty("webdriver.chrome.driver","C:/Development/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testLoginTestCase() throws Exception {
            driver.get("http://thedemosite.co.uk/index.php");
            driver.findElement(By.linkText("2. The Database")).click();
            driver.findElement(By.linkText("3. Add a User")).click();
            driver.findElement(By.name("username")).click();
            driver.findElement(By.name("username")).click();
            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys("testName");
            driver.findElement(By.name("password")).click();
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("password");
            driver.findElement(By.name("FormsButton2")).click();
            driver.findElement(By.linkText("4. Login")).click();
            driver.findElement(By.name("username")).click();
            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys("testName");
            driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Help'])[3]/following::p[1]")).click();
            driver.findElement(By.name("password")).click();
            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys("password");
            driver.findElement(By.name("FormsButton2")).click();

            assertTrue(getLoginText().equals("**Successful Login**"));

        }

        @After
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

        private String getLoginText(){
            return driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText();
        }
}
