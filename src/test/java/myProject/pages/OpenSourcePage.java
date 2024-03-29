package myProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import myProject.utilities.Driver;

public class OpenSourcePage {

    // Page abjelerini bu sayfada buluruz

    // 1. constructor
    public OpenSourcePage() {
    // PageFactory seleniumdan gelen ve bu sayfa elementlerini intantiate etmek icin kullanili

    // Sayfa objeleri cagrildiginda null pointer exception alinmaz
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // PAGE OBJELERINI OLUSTUR
    // GELENEKSEL : public WebElement username = Driver.getDriver ().findElement(By.name ("username"));
    @FindBy(name = "username")
    public WebElement username;


    @FindBy (xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement submitButton;

}
