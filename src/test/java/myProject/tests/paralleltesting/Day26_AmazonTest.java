package myProject.tests.paralleltesting;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import myProject.utilities.Driver;

public class Day26_AmazonTest {

    @Test
    public void lmsPageNavigation(){


       /* WebDriverManager.chromedriver().driverVersion("116.0.5845.96").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        boolean isDisplayed = driver.findElement(By.xpath("//input[@id='continue']")).isDisplayed();
        Assert.assertTrue(isDisplayed);
        driver.quit();

        */

        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().findElement(By.id("nav-link-accountList-nav-line-1")).click();
        boolean isDisplayed = Driver.getDriver().findElement(By.xpath("//input[@id='continue']")).isDisplayed();
        Assert.assertTrue(isDisplayed);
        Driver.getDriver().quit();



        }

    }



