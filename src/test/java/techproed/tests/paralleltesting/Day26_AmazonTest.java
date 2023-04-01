package techproed.tests.paralleltesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Day26_AmazonTest {

    @Test
    public void lmsPageNavigation(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        boolean isDisplayed = driver.findElement(By.xpath("//input[@id='continue']")).isDisplayed();
        Assert.assertTrue(isDisplayed);
        driver.quit();
        }
    }

