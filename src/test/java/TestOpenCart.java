import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestOpenCart extends BaseTest {


    @Test(dataProvider = "CompleteRegister",dataProviderClass = DataProviderClass.class)
    public void testRegistro(String nombre, String apellido, String mail, String tel, String faxx, String compania, String dire1,
                             String dire2, String ciudad, String codigopostal, String pais_nombre, String zona, String passw,
                             String confirmpassw, String suscribe, String agree, Method method) throws InterruptedException {

        extentTest = extentReports.createTest(method.getName());
        registerPage = homePage.clickInRegister();
        eyes.checkWindow("RegisterPage");
        registerOKPage = registerPage.registerNewUser(nombre,apellido,mail,tel,faxx,compania,dire1,dire2,ciudad,codigopostal,pais_nombre,zona,
                passw,confirmpassw,suscribe,agree);
        eyes.checkWindow("RegisterPageOK");
        Assert.assertTrue(registerPage.textDisplayedRegister());

    }

    @Test(dataProvider = "WishListDataProvider", dataProviderClass = DataProviderClass.class )
    public void testLogin(String userName, String password, Method method){
        extentTest = extentReports.createTest(method.getName());
        logInPage = homePage.goLogInPage();
        eyes.checkWindow("LoginPage");
        homePage = logInPage.logInUser(userName, password);
        eyes.checkWindow("LoggedUserPage");
        Assert.assertTrue(homePage.verifyIsLogged());
    }

}
