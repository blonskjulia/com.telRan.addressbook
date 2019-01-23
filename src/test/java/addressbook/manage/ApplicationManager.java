package addressbook.manage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public static WebDriver driver;
    public GroupHelper groupHelper;
    public SessionHelper sessionHelper;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void start() {

        if (browser.equals(BrowserType.CHROME)) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anblo\\Documents\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\anblo\\Documents\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browser.equals(BrowserType.EDGE)){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\anblo\\Documents\\drivers\\IEDriverServer.exe");
           driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        sessionHelper = new SessionHelper(driver);
        sessionHelper.openSite("http://localhost/addressbook/");
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(driver);
    }
    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public void stop() {
        driver.quit();
    }


}

