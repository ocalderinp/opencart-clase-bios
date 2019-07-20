import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class HomePageTest extends BaseTest{

    @Parameters("currency")
    @Test
    public void cambioMonedaParameters(String moneda, Method method){
        extentTest = extentReports.createTest(method.getName());
        homePage.seleccionarMoneda(moneda);
        Assert.assertTrue(homePage.verificarCambioMoneda(moneda));

    }
}
