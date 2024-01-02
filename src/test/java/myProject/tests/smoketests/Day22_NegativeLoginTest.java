package myProject.tests.smoketests;

import org.testng.Assert;
import org.testng.annotations.Test;
import myProject.pages.BlueRental_HomaPage;
import myProject.pages.BlueRental_LoginPage;
import myProject.utilities.ConfigReader;
import myProject.utilities.Driver;

public class Day22_NegativeLoginTest {

    BlueRental_HomaPage blueRental_homaPage;
    BlueRental_LoginPage blueRental_LoginPage;

    @Test
    public void US100208_Negative_Login () throws InterruptedException {
        blueRental_homaPage = new BlueRental_HomaPage();
        blueRental_LoginPage = new BlueRental_LoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("BlueRentalCar_Url"));

        blueRental_homaPage.LoginLink.click();
        blueRental_LoginPage.emailBox.sendKeys(ConfigReader.getProperty("fake_email"));
        blueRental_LoginPage.passwordBox.sendKeys(ConfigReader.getProperty("fake_password"));
        blueRental_LoginPage.loginButton.click();

        Thread.sleep(2000);

        Assert.assertEquals(blueRental_LoginPage.error_message.getText(),"User with email fake@bluerentalcars.com not found");

        Driver.closeDriver();
    }
}
