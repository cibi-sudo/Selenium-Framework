package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.helper;

import java.util.List;

public class loginPage {
    @FindBy(id = "email1")
    public static WebElement usernameField;
    @FindBy(name = "password1")
    public static WebElement passwordField;
    @FindBy(xpath = "//button[@class='submit-btn']")
    public static WebElement loginButton;
    @FindBy(xpath = "//div[@class='social-btns']//a")
    public static List<WebElement> icons;
    WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        helper.setDriver(driver);

    }

    public int countIcons() {
        return helper.elementCount(icons);
    }

    public void logintoApplication(String username, String password) {
        helper.sendText(usernameField, username);
        helper.sendText(passwordField, password);
        helper.elementClick(loginButton);
    }
}
