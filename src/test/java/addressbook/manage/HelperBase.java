package addressbook.manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.NoSuchElementException;

public class HelperBase {

    public WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        ApplicationManager.driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        ApplicationManager.driver.findElement(locator).clear();
        ApplicationManager.driver.findElement(locator).sendKeys(text);
    }

    public boolean isElementPresent(By locator) {
        try {
            ApplicationManager.driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
