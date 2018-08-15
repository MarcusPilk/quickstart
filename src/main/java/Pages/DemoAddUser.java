package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoAddUser {

    @FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
    WebElement usernameText;

    @FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
    WebElement passwordText;

    @FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
    WebElement saveButton;

    @FindBy (xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
    WebElement loginLink;

    public void enterText(String user,String pass){
        usernameText.click();
        usernameText.sendKeys(user);
        passwordText.click();
        passwordText.sendKeys(pass);
    }


    public void clickSave(){
        saveButton.click();
    }

    public void changePageLogin(){
        loginLink.click();
    }
}
