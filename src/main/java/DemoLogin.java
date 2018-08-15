import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DemoLogin {

    @FindBy (xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
    WebElement loginText;

    @FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
    WebElement loginUsername;

    @FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
    WebElement loginPassword;

    @FindBy (xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
    WebElement loginButton;

    public void loginProcess(String text){
        loginUsername.sendKeys(text);
        loginPassword.sendKeys(text);
    }

    public void clickLogin(){
        loginButton.click();
    }

    public Boolean checkLoginText(){
        if(loginText.getText().equals("**Successful Login**")){
            return true;
        }else{
            return false;
        }
    }

}
