package pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;
import pages.LoginPage;
import pages.MainPage;
import pages.billing.BillingPage;

public class ProjectsPage extends AbstractPage {

    private final String XPATH_PROJECT_LINK = "//div[@id='project-list']/div[@class='row']/div[4]";

    @FindBy(xpath = "//div[@class='project new']//a")
    public WebElement addProjectButton;

    @FindBy(xpath = XPATH_PROJECT_LINK)
    public WebElement projectLink;

    @FindBy(xpath = "//input[@placeholder='New component']")
    public WebElement inputComponentName;

    @FindBy(xpath = "//button[@class='btn']")
    public WebElement createButton;

    @FindBy(xpath = "//span[@class='iv-icon iv-icon-credit-card']")
    public WebElement linkBilling;

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public MainPage logOut()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logOutIcon.click();
        return new MainPage(driver);
    }

    public CreateProjectPage openAddProject()
    {
        addProjectButton.click();
        return new CreateProjectPage(driver);
    }

    public ProjectPage openProject()
    {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_PROJECT_LINK)));
        projectLink.click();
        return new ProjectPage(driver);
    }

    public BillingPage openBilling()
    {
        linkBilling.click();
        return new BillingPage(driver);
    }


}
