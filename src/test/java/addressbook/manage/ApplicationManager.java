package addressbook.manage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private  WebDriver wd;
    SessionHelper sessionHelper;
    GroupHelper groupHelper;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void start() {

        if (browser.equals(BrowserType.CHROME)) {
       // System.setProperty("webdriver.chrome.driver", "C:\\Users\\anblo\\Documents\\drivers\\chromedriver.exe");
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\anblo\\Documents\\drivers\\geckodriver.exe");
            wd = new FirefoxDriver();
        }/*else if(browser.equals(BrowserType.EDGE)){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\anblo\\Documents\\drivers\\IEDriverServer.exe");
           driver = new EdgeDriver();
        }*/

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite("http://localhost/addressbook/");
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
    }
    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public void stop() {
        wd.quit();
    }


}

