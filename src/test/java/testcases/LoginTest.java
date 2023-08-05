package testcases;


import base.base;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage;
import dataprovider.dataProvider;


public class LoginTest extends base {
    @Test(priority = 1)
    public void checkMediaIcons(){
        loginPage login = PageFactory.initElements(driver, loginPage.class);
        Assert.assertEquals(4,login.countIcons());
    }
    @Test(dataProvider = "login-data",dataProviderClass= dataProvider.class,priority = 2)
    public void loginApplication(String username, String password) {
        loginPage login = PageFactory.initElements(driver, loginPage.class);
        login.logintoApplication(username, password);
    }
}

