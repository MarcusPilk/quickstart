package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class Constantss {
    public static final String websiteURL = "http://thedemosite.co.uk";

    public static final String registerURL = "http://thedemosite.co.uk/addauser.php";

    public static final String loginURL = "http://thedemosite.co.uk/login.php";

    public static final String pathTestData = "C:\\Users\\Admin\\Downloads\\Automated Testing Materials";

    public static final String fileTestData = "DemoSiteDDT.xlsx";

    public static void waitUntilHidden(WebDriver driver, WebElement element, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until((Function<WebDriver, Object>) driver1 -> !(driver1.findElement(By.id(element.getAttribute("id"))).isDisplayed()));
    }
}
