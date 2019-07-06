package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage{


    @FindBy(how = How.ID, using = "input-firstname")
    WebElement firstName;
    @FindBy(how = How.ID, using = "input-lastname")
    WebElement lastName;
    @FindBy(how = How.ID, using = "input-email")
    WebElement email;
    @FindBy(how = How.ID, using = "input-telephone")
    WebElement telephone;
    @FindBy(how = How.ID, using = "input-fax")
    WebElement fax;
    @FindBy(how = How.ID, using = "input-company")
    WebElement companyName;
    @FindBy(how = How.ID, using = "input-address-1")
    WebElement address1;
    @FindBy(how = How.ID, using = "input-address-2")
    WebElement address2;
    @FindBy(how = How.ID, using = "input-city")
    WebElement city;
    @FindBy(how = How.ID, using = "input-postcode")
    WebElement postalCode;
    @FindBy(how = How.ID, using ="input-country")
    WebElement country;
    @FindBy(how = How.ID, using ="input-zone")
    WebElement zone;
    @FindBy(how = How.ID, using = "input-password")
    WebElement password;
    @FindBy(how = How.ID, using = "input-confirm")
    WebElement confirmPassword;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    WebElement checkBoxAgree;

    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    WebElement btnContinue;

    @FindBy(how = How.CSS, using = "input[name='newsletter'][value='1']")
    WebElement radioNewsYes;

    @FindBy(how = How.CSS, using = "input[name='newsletter'][value='0']")
    WebElement radioNewsNo;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterOKPage registerNewUser (String nombre,
                                           String apellido,
                                           String mail,
                                           String tel,
                                           String faxx,
                                           String compania,
                                           String dire1,
                                           String dire2,
                                           String ciudad,
                                           String codigopostal,
                                           String pais_nombre,
                                           String zona,
                                           String passw,
                                           String confirmpassw,
                                           String suscribe,
                                           String agree
    ) {


        firstName.sendKeys(nombre);
        lastName.sendKeys(apellido);
        email.sendKeys(mail);
        telephone.sendKeys(tel);
        fax.sendKeys(faxx);
        companyName.sendKeys(compania);
        address1.sendKeys(dire1);
        address2.sendKeys(dire2);
        city.sendKeys(ciudad);
        postalCode.sendKeys(codigopostal);

        Select seleccionarPais = new Select(country);
        seleccionarPais.selectByVisibleText(pais_nombre);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Montevideo')]")));
        Select seleccionarZona = new Select(zone);
        seleccionarZona.selectByVisibleText(zona);

        password.sendKeys(passw);
        confirmPassword.sendKeys(confirmpassw);



        if(suscribe.equalsIgnoreCase("YES"))
        {
            radioNewsYes.click();
        }
        else if (suscribe.equalsIgnoreCase("NO"))
        {
            radioNewsNo.click();
        }

        if(agree.equalsIgnoreCase("YES"))
        {
            checkBoxAgree.click();
        }

        btnContinue.click();
        return new RegisterOKPage(driver);
    }



    public boolean textDisplayedRegister() {
        return driver.findElement(By.id("content")).getText().contains("Your Account Has Been Created!");

    }

}
