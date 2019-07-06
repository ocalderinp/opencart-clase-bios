import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import pageObjects.RegisterOKPage;
import pageObjects.RegisterPage;

public class TestOpenCart {

    SoftAssert SA;
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private RegisterOKPage registerOKPage;


    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setupTest(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("disable-infobars");
            // opt.addArguments("--disable-extensions");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver(opt);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.get("https://opencart.abstracta.us/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        SA = new SoftAssert();
    }

    @Test(dataProvider = "CompleteRegister",dataProviderClass = DataProviderClass.class)
    public void testRegistro(String nombre,String apellido,String mail,String tel,String faxx,String compania,String dire1,
                             String dire2,String ciudad,String codigopostal,String pais_nombre,String zona,String passw,
                             String confirmpassw,String suscribe,String agree) throws InterruptedException {


        registerPage = homePage.clickInRegister();
        registerOKPage = registerPage.registerNewUser(nombre,apellido,mail,tel,faxx,compania,dire1,dire2,ciudad,codigopostal,pais_nombre,zona,
                passw,confirmpassw,suscribe,agree);

        Assert.assertTrue(registerPage.textDisplayedRegister());



    }


    @AfterMethod(alwaysRun = true)
    public void teardown()
    {
        SA.assertAll();
        driver.quit();
    }

}
