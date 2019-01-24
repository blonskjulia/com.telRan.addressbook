package addressbook.manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);

    }


//    public SessionHelper(WebDriver driver) {
//        super(driver);
//    }

    public void openSite(String url) {
        wd.get(url);
    }

    protected void login(String userName, String password) {
        type(By.name("user"),userName);
        type(By.name("pass"), password);
        wd.findElement(By.cssSelector("[type=submit]")).click();
    }
}

