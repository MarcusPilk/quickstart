import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoSiteHome {

    @FindBy (xpath ="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]" )
    WebElement addUserPage;

    public void changePage(){
        addUserPage.click();
    }
}
