package techproed.tests.paralleltesting;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.time.Duration;

public class Day26_ManagerLoginTest {

    @Test
    public void customerLogin(){
        /*
        WebDriverManager.chromedriver().driverVersion("116.0.5845.96").setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bluerentalcars.com/login");
        driver.findElement(By.id("formBasicEmail")).sendKeys("customer@bluerentalcars.com");
        ReusableMethods.waitFor(3);
        driver.findElement(By.id("formBasicPassword")).sendKeys("12345");
        ReusableMethods.waitFor(3);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.close();

         */

        Driver.getDriver().get("https://www.bluerentalcars.com/login");
        Driver.getDriver().findElement(By.id("formBasicEmail")).sendKeys("customer@bluerentalcars.com");
        ReusableMethods.waitFor(3);
        Driver.getDriver().findElement(By.id("formBasicPassword")).sendKeys("12345");
        ReusableMethods.waitFor(3);
        Driver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        Driver.getDriver().close();

    }

}
