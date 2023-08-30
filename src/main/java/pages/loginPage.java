package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.helper;

import javax.lang.model.util.Elements;
import java.util.List;

public class loginPage {
    WebDriver driver;
    @FindBy(id = "email1")
    private WebElement usernameField;
    @FindBy(name = "password1")
    private WebElement passwordField;
    @FindBy(xpath ="//button[@class='submit-btn']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@class='social-btns']//a")
    private List<WebElement> icons;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        helper.setDriver(driver);
    }

    public int countIcons(){
       return helper.elementCount(icons);
    }

    public void logintoApplication(String username,String password){
        helper.sendText(usernameField,username);
        helper.sendText(passwordField,password);
        helper.elementClick(loginButton);
    }
}
