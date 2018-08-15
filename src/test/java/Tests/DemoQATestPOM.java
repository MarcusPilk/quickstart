package Tests;

import Pages.DemoAddUser;
import Pages.DemoLogin;
import Pages.DemoSiteHome;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class DemoQATestPOM {
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
        //Home
        driver.get("http://thedemosite.co.uk/index.php");
        DemoSiteHome homePage = PageFactory.initElements(driver, DemoSiteHome.class);
        homePage.changePage();

        //Add User
        DemoAddUser addUserPage = PageFactory.initElements(driver,DemoAddUser.class);
        addUserPage.enterText("test","test");
        addUserPage.clickSave();
        addUserPage.changePageLogin();

        //Log in
        DemoLogin loginPage = PageFactory.initElements(driver, DemoLogin.class);
        loginPage.loginProcess("test","test");
        loginPage.clickLogin();
        assertTrue(loginPage.checkLoginText());

    }




    @After
    public void tearDown(){
        driver.quit();
    }
}
