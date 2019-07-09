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
import utils.GetProperties;

public class HomePageTest extends BaseTest{

    @Parameters("currency")
    @Test
    public void cambioMonedaParameters(String moneda){
        homePage.seleccionarMoneda(moneda);
        Assert.assertTrue(homePage.verificarCambioMoneda(moneda));

    }
}
