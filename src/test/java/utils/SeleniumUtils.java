package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SeleniumUtils {

    public static void clickElement(WebElement webElement, WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static void sendText(WebElement webElement,
                                WebDriverWait wait, String text){
        wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
        webElement.sendKeys(text);
    }

    public static void selectByValue(WebElement webElement,
                                     String value, WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
        Select select = new Select(webElement);
        select.selectByValue(value);
    }

    public static void selectByText(WebElement webElement,
                                     String text, WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
        Select select = new Select(webElement);
        select.selectByVisibleText(text);
    }

    public static WebElement findElement(WebDriver driver, final By locator){
        WebElement element = null;
        try{
            element = driver.findElement(locator);
        }
        catch (NoSuchElementException e){
            System.err.print(e.getMessage());
        }
        return element;
    }

    public static List<WebElement> findElements(WebDriver driver, final By locator){
        List<WebElement> elements = null;
        try{
            elements = driver.findElements(locator);
        }
        catch (NoSuchElementException e){
            System.err.print(e.getMessage());
        }
        return elements;
    }

    /***
     * hace scroll del elemento para ponerlo dentro de la vista
     * @param driver
     * @param webElement
     */
    public static void scrollIntoView(WebDriver driver, WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public static String takeScreenShot(WebDriver driver) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "\\reports\\images\\image_" + date + ".png";
        File image = new File(path);
        FileUtils.copyFile(source, image);
        return path;
    }
}
