package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Helper;

import java.util.List;

public class LoginPage {
    @FindBy(id = "email1")
    public static WebElement usernameField;
    @FindBy(name = "password1")
    public static WebElement passwordField;
    @FindBy(xpath = "//button[@class='submit-btn']")
    public static WebElement loginButton;
    @FindBy(xpath = "//div[@class='social-btns']//a")
    public static List<WebElement> icons;
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        Helper.setDriver(driver);

    }

    public int countIcons() {
        return Helper.elementCount(icons);
    }

    public void logintoApplication(String username, String password) {
        Helper.sendText(usernameField, username);
        Helper.sendText(passwordField, password);
        Helper.elementClick(loginButton);
    }
}
