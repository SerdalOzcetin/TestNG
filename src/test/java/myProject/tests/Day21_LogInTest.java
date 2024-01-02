package myProject.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import myProject.pages.HomePage;
import myProject.pages.LogInPage;
import myProject.utilities.ConfigReader;
import myProject.utilities.Driver;

public class Day21_LogInTest {

@Test
    public void logInTest(){

    LogInPage logInPage = new LogInPage();
    HomePage homePage = new HomePage();


    Driver.getDriver().get(ConfigReader.getProperty("Login_Page_Url"));

    logInPage.username.sendKeys(ConfigReader.getProperty("Login_Page_Username"));
    logInPage.password.sendKeys(ConfigReader.getProperty("Login_Page_Password"));
    logInPage.submitButton.click();

//LogIn yap ve bunu test et.
    Assert.assertTrue(homePage.homeHeader.isDisplayed());

//Çıkış yap ve bunu test et
    homePage.homeLogOutButton.click();
    Assert.assertTrue(logInPage.submitButton.isDisplayed());

    Driver.closeDriver();

    }
}
