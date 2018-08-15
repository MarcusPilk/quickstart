package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class AccordionPage {

    @FindBy(id = "ui-id-4")
    WebElement section1Tab;
    @FindBy (id = "ui-id-5")
    WebElement section1Div;

    @FindBy(id = "ui-id-6")
    WebElement section2Tab;
    @FindBy (id = "ui-id-7")
    WebElement section2Div;

    @FindBy(id = "ui-id-8")
    WebElement section3Tab;
    @FindBy (id = "ui-id-9")
    WebElement section3Div;

    @FindBy(id = "ui-id-10")
    WebElement section4Tab;
    @FindBy (id = "ui-id-11")
    WebElement section4Div;

    public void clickSection3(){
        section3Tab.click();
    }

    public Boolean checkText(){
        if(section3Div.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkHidden(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until((Function<WebDriver, Object>) driver1 -> !(driver1.findElement(By.id("ui-id-5")).isDisplayed()));
        if(section1Div.getAttribute("aria-hidden").equals("true")){
            return true;
        }else{
            return false;
        }
    }


}
