package pages.billing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import pages.projects.ProjectsPage;

public class BillingPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(),'Add new')]")
    public WebElement addNewCardButton;

    public BillingPage(WebDriver driver) {
        super(driver);
    }

    public NewCardPage openCardPage()
    {
        ProjectsPage projects = new ProjectsPage(driver);
        projects.openBilling();
        addNewCardButton.click();
        return new NewCardPage(driver);
    }

}
