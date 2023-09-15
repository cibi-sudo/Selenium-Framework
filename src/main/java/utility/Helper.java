package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Helper {
    static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        Helper.driver = driver;
    }

    public static int pageloadouttime = 20;
    public static int implicittime = 10;
    public static int explicittime = 5;

    public static byte[] captureScreenshotinByte(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] screenshot;
        screenshot = ts.getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

    public static String captureScreenshotinbase64(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String base64;
        base64 = ts.getScreenshotAs(OutputType.BASE64);
        return base64;
    }
    public static void captureScreenshot(WebDriver driver) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File trg = new File("/home/cibi/IdeaProjects/Selenium_Hybrid_Framework/src/main/resources/screenshots" + getcurrenttime() + ".png");
            FileUtils.copyFile(src, trg);
        } catch (IOException exception) {
            System.out.println("Something went wrong" + exception.getMessage());
        }
    }

    public static void captureElement(WebDriver driver, WebElement element) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = element.getScreenshotAs(OutputType.FILE);
            File trg = new File("/home/cibi/IdeaProjects/Selenium_Hybrid_Framework/src/main/resources/screenshots" + getcurrenttime() + ".png");
            FileUtils.copyFile(src, trg);
        } catch (IOException exception) {
            System.out.println("Something went wrong" + exception.getMessage());
        }
    }

    public static String getcurrenttime() {
        return new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
    }

    public static boolean elementToBeDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public static void elementClick(WebElement element) {
        element.click();
    }

    public static void sendText(WebElement element, String string) {
        element.click();
        element.clear();
        element.sendKeys(string);
    }

    public static void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(explicittime));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void acceptAlert() {
        Alert alt = driver.switchTo().alert();
        alt.accept();
    }

    public static void dismissAlert() {
        Alert alt = driver.switchTo().alert();
        alt.dismiss();
    }

    public static String getTextAlert() {
        Alert alt = driver.switchTo().alert();
        return alt.getText();
    }

    public static void clickAction(){
        Actions act = new Actions(driver);
        act.click().build().perform();
    }

    public static void doubleClickAction(){
        Actions act = new Actions(driver);
        act.doubleClick().build().perform();
    }

    public static int elementCount(List<WebElement> element){
            return element.size();
    }

}
