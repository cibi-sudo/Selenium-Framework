package testcases;


import base.Base;
import browserfactory.Browser;
import dataproviders.DataProviders;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utility.ConfigFailedCase;


public class LoginTest extends Base {

    @Test(priority = 1, retryAnalyzer = ConfigFailedCase.class)
    public void checkMediaIcons() {
        LoginPage login = PageFactory.initElements(Browser.getDriver(), LoginPage.class);
        Assert.assertEquals(4, login.countIcons());
    }

    @Test(dataProvider = "login-data", dataProviderClass = DataProviders.class, priority = 2, retryAnalyzer = ConfigFailedCase.class)
    public void loginApplication(String username, String password) {
        LoginPage login = PageFactory.initElements(Browser.getDriver(), LoginPage.class);
        login.logintoApplication(username, password);
    }
}

