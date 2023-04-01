package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourceDashboardPage;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_openSourceLogin {


    @Test(groups = "regression-tests")
    public void openSourceLogin() throws InterruptedException {

        //Sayfaya git
        //Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Driver.getDriver().get(ConfigReader.getProperty("open_source_url"));

        //Page Objesi oluştur.
        OpenSourcePage openSourcePage = new OpenSourcePage();

        // Bu objeyi kullanarak objelere ulaş.
        openSourcePage.username.sendKeys(ConfigReader.getProperty("open_source_username"));
        openSourcePage.password.sendKeys("open_source_password");
        openSourcePage.submitButton.click();

        //Assertion
        OpenSourceDashboardPage openSourceDashboardPage = new OpenSourceDashboardPage();
        Assert.assertTrue(openSourceDashboardPage.dashboardHeader.isDisplayed());

        //Close Driver
        Driver.closeDriver();




    }
}
