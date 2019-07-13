import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import utils.GetProperties;

import java.net.MalformedURLException;

public class BaseTest {

    protected SoftAssert SA;
    protected WebDriver driver;
    protected HomePage homePage;
    protected RegisterPage registerPage;
    protected RegisterOKPage registerOKPage;
    protected SearchPage searchPage;
    protected LogInPage logInPage;
    protected WishListPage wishListPage;
    protected CartListProduct cartListProduct;
    protected CartProduct cartProduct;
    protected GetProperties properties = new GetProperties();
    protected String url = properties.getString("URL");
    protected String hubUrl = properties.getString("HUB_URL");

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setupTest(String browser) throws MalformedURLException {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("disable-infobars");
            // opt.addArguments("--disable-extensions");
            System.setProperty("webdriver.chrome.driver",
                    properties.getString("CHROMEDRIVER_PATH"));
            driver = new ChromeDriver(opt);
//            driver = new RemoteWebDriver(new URL(hubUrl), opt);
        } else if (browser.equalsIgnoreCase(
                "firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    properties.getString("FIREFOX_PATH"));
            driver = new FirefoxDriver();
//            driver = new RemoteWebDriver(new URL(hubUrl), new FirefoxOptions());
        }

        driver.get(url);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        SA = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown()
    {
        SA.assertAll();
        driver.quit();
    }
}
