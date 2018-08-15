package Tests;

import Pages.DraggablePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DraggableTest {

    WebDriver driver = null;
    static ExtentReports reports;
    ExtentTest test;

    @BeforeClass
    static public void setUpReports(){
        reports = new ExtentReports("C:\\Users\\Admin\\Desktop\\Automation\\draggableReport.html",true);
    }
    @AfterClass
    public static void tearDownReports(){
        reports.flush();
    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:/Development/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        reports.endTest(test);
        driver.quit();
    }

    @Test
    public void testDrag(){
        test = reports.startTest("Verify draggable content");
        driver.get("http://demoqa.com/draggable/");
        test.log(LogStatus.INFO,"Browser Started");
        DraggablePage dragPage = PageFactory.initElements(driver,DraggablePage.class);
        Point location = dragPage.draggable.getLocation();
        dragPage.drag(driver);

        if(location.equals(dragPage.draggable.getLocation())){
            test.log(LogStatus.FAIL,"Object not moved");
        }else{
            test.log(LogStatus.PASS,"Object moved successful");
        }

        assertFalse(location.equals(dragPage.draggable.getLocation()));
    }
}
