package addressbook.tests;

import addressbook.manage.ApplicationManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.EDGE));

   //@BeforeSuite
   @Before
    public void setUp() {
        app.start();
    }

   //@AfterSuite(alwaysRun = true)
    @After
    public void tearDown() {
        app.stop();
    }
}

