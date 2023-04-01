package techproed.tests.smoketests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import techproed.pages.BlueRental_HomaPage;
import techproed.pages.BlueRental_LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day22_PositiveLoginTest {

    /*
    Name: US100201_Admin_Login
    Description:
    Admin bilgileriyle giriş
    Acceptance Criteria:
    Admin olarak, uygulamaya giriş yapabilmeliyim
    https://www.bluerentalcars.com/
    Admin email : jack@gmail.com
    Admin password :12345
     */
    BlueRental_LoginPage blueRental_loginPage;
    BlueRental_HomaPage blueRental_homaPage;

    @Test
    public void US100201_Admin_Login(){

        blueRental_loginPage = new BlueRental_LoginPage();
        blueRental_homaPage = new BlueRental_HomaPage();

        Reporter.log("Sayfaya Git");
        Driver.getDriver().get(ConfigReader.getProperty("BlueRentalCar_Url"));

        Reporter.log("Login butonuna Tıkla");
        blueRental_homaPage.LoginLink.click();

        Reporter.log("Email Adresini Gir");
        blueRental_loginPage.emailBox.sendKeys(ConfigReader.getProperty("Admin_email"));

        Reporter.log("Passwordu Gir");
        blueRental_loginPage.passwordBox.sendKeys(ConfigReader.getProperty("Admin_password"));

        Reporter.log("Login butonuna Tıkla");
        blueRental_loginPage.loginButton.click();

        Assert.assertTrue(blueRental_homaPage.userID.isDisplayed());
    }
}
