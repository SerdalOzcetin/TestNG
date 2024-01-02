package myProject.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import myProject.pages.BlueRental_HomaPage;
import myProject.pages.BlueRental_LoginPage;
import myProject.utilities.ConfigReader;
import myProject.utilities.Driver;
import myProject.utilities.ReusableMethods;

import java.io.IOException;

public class Day_24DataProviderTest02 {

    @DataProvider
    public Object[][] customerData(){
        Object[][] customerCredentials = {
                {"sam.walker@bluerentalcars.com",	 "c!fas_art"},
                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}
        };
        return customerCredentials;
    }

    @Test(dataProvider = "customerData")
    public void dataProviderTest01(String email, String password){
        System.out.println("EMAİL :"+email+"  "+"ŞİFRE :"+password);
    }

    BlueRental_HomaPage blueRentalHomePage;
    BlueRental_LoginPage blueRentalLoginPage;

    @Test(dataProvider = "customerData")
    public void dataProviderTest02(String email,String password) throws IOException {
        // Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("BlueRentalCar_Url"));
        blueRentalHomePage = new BlueRental_HomaPage();
        blueRentalLoginPage = new BlueRental_LoginPage();
        blueRentalHomePage.LoginLink.click();
        ReusableMethods.waitFor(1);// 1 saniye bekle
        blueRentalLoginPage.emailBox.sendKeys(email);
        ReusableMethods.waitFor(1);
        blueRentalLoginPage.passwordBox.sendKeys(password);
        ReusableMethods.waitFor(1);
        blueRentalLoginPage.loginButton.click();

        ReusableMethods.verifyElementDisplayed(blueRentalLoginPage.loginButton);
        //Giris yapıldı
        ReusableMethods.getScreenshot("Ekran Görüntüsü");

        ReusableMethods.waitFor(1);
        blueRentalHomePage.userID.click();
        ReusableMethods.waitFor(1);
        blueRentalHomePage.LogOut.click();
        ReusableMethods.waitFor(1);
        blueRentalHomePage.OK.click();

        Driver.closeDriver();

    }

}

