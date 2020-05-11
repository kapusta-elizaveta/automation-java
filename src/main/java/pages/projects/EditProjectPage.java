package pages.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class EditProjectPage extends AbstractPage {

    @FindBy(xpath= "//textarea[@placeholder='Type here...']")
    public WebElement description;

    @FindBy(xpath = "//button[@class='btn']")
    public WebElement updateButton;

    public EditProjectPage(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage editDescription(String description)
    {
        ProjectPage project = new ProjectPage(driver);
        project.openEditProject();
        this.description.sendKeys(description);
        updateButton.click();
        return new ProjectsPage(driver);
    }

}
