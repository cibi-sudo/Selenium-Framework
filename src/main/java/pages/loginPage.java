package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.helper;

public class loginPage {
    WebDriver driver;
    public loginPage(WebDriver driver){
        this.driver = driver;
        helper.setDriver(driver);
    }

    By usernameField = By.id("email1");
    By passwordFiled = By.name("password1");
    By loginButton = By.className("submit-btn");
    By icons = By.xpath("//div[@class='social-btns']//a");

    public int countIcons(){
        return helper.elementCount(icons);
    }
    public void logintoApplication(String username,String password){
        helper.sendText(usernameField,username);
        helper.sendText(passwordFiled,password);
        helper.elementClick(loginButton);
    }
}
