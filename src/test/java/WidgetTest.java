import Widgets.AccordionPage;
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

public class WidgetTest {

    WebDriver driver = null;
    static ExtentReports reports;
    ExtentTest test;

    @BeforeClass
    static public void setUpReports(){
        reports = new ExtentReports("C:\\Users\\Admin\\Desktop\\Automation\\WidgetReport.html",true);
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
    public void testAccordion(){
        test = reports.startTest("Verify accordion content");
        driver.get("http://demoqa.com/accordion/");
        test.log(LogStatus.INFO,"Browser Started");
        AccordionPage accordionPage = PageFactory.initElements(driver,AccordionPage.class);

        accordionPage.clickSection3();
        test.log(LogStatus.INFO,"Section 3 clicked");

        if(accordionPage.checkText()){
            test.log(LogStatus.INFO,"Section 3 text displayed");
        }else{
            test.log(LogStatus.INFO,"Section 3 text not displayed");
        }

        if(accordionPage.checkHidden()){
            test.log(LogStatus.INFO,"Section 1 hidden");
        }else{
            test.log(LogStatus.INFO, "Section 1 not hidden");
        }

        if(accordionPage.checkText() && accordionPage.checkHidden()){
            test.log(LogStatus.PASS,"Test Passed");
        }else{
            test.log(LogStatus.FAIL,"Test Failed");
        }


        assertTrue(accordionPage.checkHidden() && accordionPage.checkText());



    }
}
