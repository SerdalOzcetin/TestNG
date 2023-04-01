package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class DAy_20_Driver_Config_Test {

    @Test

    public void firstTest(){


        // amazon a git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Title ın "amazon" içerdiğini test et.
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));

        Driver.closeDriver();

    }
}
