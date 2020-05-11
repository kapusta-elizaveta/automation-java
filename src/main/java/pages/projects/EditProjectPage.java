package pages.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class EditProjectPage extends AbstractPage {

    @FindBy(xpath= "//textarea[@placeholder='Type here...']")
    public WebElement Description;

    @FindBy(xpath = "//button[@class='btn']")
    public WebElement UpdateButton;

    public EditProjectPage(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage EditDescription(String description)
    {
        ProjectPage project = new ProjectPage(driver);
        project.OpenEditProject();
        Description.sendKeys(description);
        UpdateButton.click();
        return new ProjectsPage(driver);
    }

}
