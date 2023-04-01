package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRental_HomaPage;
import techproed.pages.BlueRental_LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day_24DataProviderTest03 {


    @DataProvider
    public Object[][] customerData(){

        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
        String sheetName = "customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);

        Object[][] customerCredentials = excelUtils.getDataArrayWithoutFirstRow();
        return customerCredentials;
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
