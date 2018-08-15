package Tests;

import Pages.Constantss;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class DDTTesting {
    WebDriver driver = null;
    static ExtentReports reports;
    ExtentTest test;
    String loginData = "";

    @BeforeClass
    static public void setUpReports(){
        reports = new ExtentReports("C:\\Users\\Admin\\Desktop\\Automation\\DDTTesting.html",true);
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

        driver.quit();
    }

    @Test
    public void testExcel() throws IOException {
        FileInputStream file = new FileInputStream(Constantss.pathTestData+ "\\" + Constantss.fileTestData);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        Pages.ExcelUtils.setExcelFile(Constantss.pathTestData+ "\\" + Constantss.fileTestData,0);


        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
            test = reports.startTest("Starting Test: " + i);

            driver.get(Constantss.registerURL);
            test.log(LogStatus.INFO,"Open Register User WebPage");
            Pages.DemoAddUser addUsr = PageFactory.initElements(driver,Pages.DemoAddUser.class);
            Cell username = worksheet.getRow(i).getCell(0);
            Cell password = worksheet.getRow(i).getCell(1);

            addUsr.enterText(username.getStringCellValue(),password.getStringCellValue());
            addUsr.clickSave();
            test.log(LogStatus.INFO,"Details entered and saved");
            addUsr.changePageLogin();
            test.log(LogStatus.INFO,"Navigate to Log In WebPage");

            Pages.DemoLogin login = PageFactory.initElements(driver,Pages.DemoLogin.class);
            login.loginProcess(username.getStringCellValue(),password.getStringCellValue());
            login.clickLogin();
            test.log(LogStatus.INFO,"Details entered and login process started");

            if(login.checkLoginText()){
                test.log(LogStatus.PASS, "Logged In Successfully");
                Pages.ExcelUtils.setCellData("Success",i,2);
            }else{
                test.log(LogStatus.FAIL, "Log In Failed");
                Pages.ExcelUtils.setCellData("Fail",i,2);
            }


            assertTrue(login.checkLoginText());

            reports.endTest(test);

        }
    }

}
