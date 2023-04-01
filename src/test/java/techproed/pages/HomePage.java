package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HomePage {

    public HomePage() {
        // PageFactory seleniumdan gelen ve bu sayfa elementlerini intantiate etmek icin kullanili

        // Sayfa objeleri cagrildiginda null pointer exception alinmaz
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[@role='alert']")
    public WebElement homeHeader;

    @FindBy(xpath = "//*[text()=' Logout']")
    public WebElement homeLogOutButton;

}
