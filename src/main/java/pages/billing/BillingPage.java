package pages.billing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import pages.projects.ProjectsPage;

public class BillingPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(),'Add new')]")
    public WebElement AddNewCardButton;

    public BillingPage(WebDriver driver) {
        super(driver);
    }

    public NewCardPage OpenCardPage()
    {
        ProjectsPage projects = new ProjectsPage(driver);
        projects.OpenBilling();
        AddNewCardButton.click();
        return new NewCardPage(driver);
    }

}
