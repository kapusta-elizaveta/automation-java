package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='btn']")
    public WebElement logInButton;


    public MainPage(WebDriver driver) {
        super(driver);
    }
}
