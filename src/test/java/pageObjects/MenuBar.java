package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumUtils;

public class MenuBar {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(linkText = "Tablets")
    WebElement opcionTablets;

    @FindBy(linkText = "Software")
    WebElement opcionSoftware;

    @FindBy(linkText = "Phones & PDAs")
    WebElement opcionPhonesPDA;

    @FindBy(linkText = "Cameras")
    WebElement opcionCameras;

    public MenuBar(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public SearchPage navegarSimple(String opcion){
        switch (opcion){
            case "Tablets":
                SeleniumUtils.clickElement(opcionTablets, wait);
                break;
            case "Software":
                SeleniumUtils.clickElement(opcionSoftware, wait);
                break;
            case "Phones & PDAs":
                SeleniumUtils.clickElement(opcionPhonesPDA, wait);
                break;
            case "Cameras":
                SeleniumUtils.clickElement(opcionCameras, wait);
                break;

        }
        return new SearchPage(driver);
    }
}
