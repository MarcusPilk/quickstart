package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class DraggablePage {

    @FindBy (id = "draggable")
    public WebElement draggable;

    Actions action = null;

    public void drag(WebDriver driver){
        action = new Actions(driver);
        action.moveToElement(draggable).clickAndHold().moveByOffset(300,300).perform();
    }


}
