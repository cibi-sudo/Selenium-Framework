package testcases;


import base.base;
import browserfactory.browser;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage;
import dataproviders.dataProvider;
import utility.configFailedCase;


public class LoginTest extends base {

    @Test(priority = 1,retryAnalyzer = configFailedCase.class)
    public void checkMediaIcons(){
        loginPage login = PageFactory.initElements(browser.getDriver(), loginPage.class);
        Assert.assertEquals(4,login.countIcons());
    }
    @Test(dataProvider = "login-data",dataProviderClass= dataProvider.class,priority = 2,retryAnalyzer = configFailedCase.class)
    public void loginApplication(String username, String password) {
        loginPage login = PageFactory.initElements(browser.getDriver(), loginPage.class);
        login.logintoApplication(username, password);
    }
}

