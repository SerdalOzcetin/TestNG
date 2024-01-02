package myProject.tests.excelautomation;

import org.testng.annotations.Test;
import myProject.pages.BlueRental_HomaPage;
import myProject.pages.BlueRental_LoginPage;
import myProject.utilities.ConfigReader;
import myProject.utilities.Driver;
import myProject.utilities.ExcelUtils;
import myProject.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day24_ExcelLogin2 {
    BlueRental_HomaPage blueRentalHomePage;
    BlueRental_LoginPage blueRentalLoginPage;
    // Bu metot login sayfasina gitmek icin kullanililacak
    ExcelUtils excelUtils;
    List<Map<String, String>> excelDatalari;

    @Test
    public void customerLogin() throws IOException {
        String path ="C:\\Users\\asus\\IdeaProjects\\testNGProject\\src\\test\\java\\resources\\mysmoketestdata.xlsx";
        String sayfa = "customer_info";
        excelUtils = new ExcelUtils(path, sayfa);
        excelDatalari = excelUtils.getDataList();
        Driver.getDriver().get(ConfigReader.getProperty("BlueRentalCar_Url"));
        // home page Logine tikla
        for (Map<String, String> data : excelDatalari) {
            // Sayfaya git
            Driver.getDriver().get(ConfigReader.getProperty("BlueRentalCar_Url"));
            blueRentalHomePage = new BlueRental_HomaPage();
            blueRentalLoginPage = new BlueRental_LoginPage();
            blueRentalHomePage.LoginLink.click();
            ReusableMethods.waitFor(1);// 1 saniye bekle
            blueRentalLoginPage.emailBox.sendKeys(data.get("username"));
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));
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
        }
        Driver.closeDriver();
    }
}
