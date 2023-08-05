package base;

import browserfactory.browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utility.configReader;

import java.util.Properties;

public class base {
    public WebDriver driver;

    @BeforeMethod
    public void browserSetup(){
        Properties prop = new configReader().intializeProperties();
        driver = browser.initializeBrowser(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
    }
    @AfterMethod
    public void browserclose(){
        driver.quit();
    }
}
