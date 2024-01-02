package myProject.utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
public class Driver {
    //    Driver.getDriver(); -> driver
    // private static WebDriver driver;
    //    getDriver() is used to instantiate the driver object

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    public static WebDriver getDriver(){
        if (webDriverThreadLocal.get()==null){
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    // WebDriverManager.chromedriver().driverVersion("116.0.5845.96").setup(); after selenium 4.6.0 no need to use bonigarcia
                    // driver = new ChromeDriver();
                    webDriverThreadLocal.set(new ChromeDriver());
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    // driver=new FirefoxDriver();
                    webDriverThreadLocal.set(new FirefoxDriver());
                    break;
                // case "chrome-headless":
                    //WebDriverManager.chromedriver().driverVersion("116.0.5845.96").setup();
                    // driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    // webDriverThreadLocal.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    // break;
                case "edge":
                    //WebDriverManager.edgedriver().setup();
                    //driver=new EdgeDriver();
                    webDriverThreadLocal.set(new EdgeDriver());
                    break;
            }
//            NOTE: sel 4.5
//            driver = WebDriverManager.chromedriver().create();
        }
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      //  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
      //  driver.manage().window().maximize();
      //  return driver;

          webDriverThreadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
          webDriverThreadLocal.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
          webDriverThreadLocal.get().manage().window().maximize();

          return webDriverThreadLocal.get();
    }
    //    closeDriver() is used to close the driver
    public static void closeDriver(){
//        if driver is already being used(pointing an object)
//        then quit the driver
        if (webDriverThreadLocal!=null){
            webDriverThreadLocal.get().quit();
            webDriverThreadLocal.remove();
        }
    }
}