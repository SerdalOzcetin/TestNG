package myProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import myProject.utilities.Driver;
public class LogInPage {

    public LogInPage() {
        // PageFactory seleniumdan gelen ve bu sayfa elementlerini intantiate etmek icin kullanili

        // Sayfa objeleri cagrildiginda null pointer exception alinmaz
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "exampleInputEmail1")
    public WebElement username;

    @FindBy(id = "exampleInputPassword1")
    public WebElement password;

    @FindBy(xpath = "//*[text()='Submit']")
    public WebElement submitButton;
}
