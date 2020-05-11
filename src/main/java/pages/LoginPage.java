package pages;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.projects.ProjectsPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginPage extends AbstractPage{

    private final String XPATH_EMAIL = "//input[@placeholder='Email']";

    @FindBy(xpath = XPATH_EMAIL)
    @CacheLookup
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@placeholder='Password']")
    @CacheLookup
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    @CacheLookup
    public WebElement logInButton;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    @CacheLookup
    public WebElement logOutIcon;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage logIn()  {
        Gson gson = new Gson();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader("testdata/user.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
        String login = jsonObject.get("email").getAsString();
        String password = jsonObject.get("password").getAsString();
        driver.get("https://www.integrivideo.com/app/projects");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.sendKeys(login);
        inputPassword.sendKeys(password);
        logInButton.click();
        return new ProjectsPage(driver);
    }
}
