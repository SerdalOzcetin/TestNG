package myProject.tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import myProject.utilities.ConfigReader;
import myProject.utilities.Driver;


@Feature("Feature01")
@Epic("Epic01")
@Listeners({myProject.utilities.Listeners.class})
public class DAy_20_Driver_Config_Test {

    @Severity(SeverityLevel.NORMAL)
    @Description("Something for description...")
    @Step("Step01 for allure")
    @Test
    public void firstTest(){


        // amazon a git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Title ın "amazon" içerdiğini test et.
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));

        Driver.closeDriver();

    }
}
