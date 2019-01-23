package addressbook.manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    GroupHelper groupHelper;

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void openSite(String url) {
        ApplicationManager.driver.get(url);
    }

    protected void login(String userName, String password) {
        type(By.name("user"),userName);
        type(By.name("pass"), password);
        ApplicationManager.driver.findElement(By.cssSelector("[type=submit]")).click();
    }
}

