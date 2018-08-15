package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

public class HelperMethods {

        public static void screenshot(WebDriver driver) {

            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            String destination = "C:\\Users\\Admin\\Desktop\\Automation\\"
                    + "Pass" + dateName + ".png";

            File finalDestination = new File(destination);

            try {
                FileHandler.copy(source, finalDestination);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        public static void waitUntilHidden(WebDriver driver, WebElement element, int waitTime){
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until((Function<WebDriver, Object>) driver1 -> !(driver1.findElement(By.id(element.getAttribute("id"))).isDisplayed()));
        }


}
