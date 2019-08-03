import com.applitools.eyes.selenium.Eyes;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageobjects.*;
import sun.awt.OSInfo;
import utils.GetProperties;
import utils.SeleniumUtils;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {

    protected static SoftAssert softAssert;
    protected static WebDriver driver;
    protected HomePage homePage;
    protected Eyes eyes;
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
    protected String api_key = properties.getString("API_KEY_APPLITOOLS");

    //reportes
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;

    @BeforeSuite(alwaysRun = true)
    @Parameters("browser")
    public void setupSuite(final String browser) throws MalformedURLException {
        boolean ci = Boolean.parseBoolean(System.getProperty("ci"));
        System.out.println("Ejecucion en ci: " + String.valueOf(ci));
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                properties.getString("CHROMEDRIVER_PATH"));
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("disable-infobars");
            if (ci) {
                opt.addArguments("--headless");
                opt.addArguments("--window-size=1980,1080");
            }

            driver = new ChromeDriver(opt);
//            driver = new RemoteWebDriver(new URL(hubUrl), opt);
        } else if (browser.equalsIgnoreCase(
                "firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    properties.getString("FIREFOX_PATH"));
            driver = new FirefoxDriver();
//            FirefoxOptions fopts = new FirefoxOptions();
//            driver = new RemoteWebDriver(new URL(hubUrl), fopts);
        }
//        eyes = new Eyes();
//        eyes.setApiKey(api_key);
//        eyes.open(driver, "OpenCart", "TestVisuales",
//                new RectangleSize(600,800));
        softAssert = new SoftAssert();
        setupReports();
        if (!ci) {
            driver.manage().window().maximize();
        }
    }

    public void setupReports() {
        extentHtmlReporter = new ExtentHtmlReporter("reports/reporte.html");
        extentHtmlReporter.config().setDocumentTitle("Automation Reports");
        extentHtmlReporter.config().setReportName("Opencart - Reporte de Pruebas Automatizadas");
        extentHtmlReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);

        extentReports.setSystemInfo("Ambiente", "Testing");
        extentReports.setSystemInfo("Hostname", "opencart.testing.us");
        extentReports.setSystemInfo("Sistema Operativo", OSInfo.getOSType().name());

    }

    @BeforeMethod(alwaysRun = true)
    public void navegarInicio() {
        driver.get(url);
        //driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void teardownTest(final ITestResult result) throws IOException {
        softAssert.assertAll();
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL,
                    "Test Case " + result.getName() + " failed");
            extentTest.log(Status.FAIL,
                    "Caused: " + result.getThrowable());
            String screenShoot = SeleniumUtils.takeScreenShot(driver);
            extentTest.log(Status.FAIL, "Image: ");
            extentTest.addScreenCaptureFromPath(screenShoot);
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP,
                    "Test Case " + result.getName() + " skipped");
            extentTest.log(Status.SKIP,
                    "Caused: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS,
                    "Test Case " + result.getName() + " passed");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void flush() {
        extentReports.flush();
        driver.quit();
//        eyes.close();
    }

}
