package pages.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class ProjectPage extends AbstractPage {

    @FindBy(xpath = "//span[@class='iv-icon iv-icon-file-add']")
    public WebElement iconComponentAdd;

    @FindBy(xpath = "//a[contains(text(),'Edit')]")
    public WebElement editComponentLink;

    @FindBy(xpath = "//div[@class='col-12 description']")
    public WebElement projectDescription;

    protected ProjectPage(WebDriver driver) {
        super(driver);
    }

    public void addComponent()
    {
        ProjectsPage projects = new ProjectsPage(driver);
        projects.openProject();
        iconComponentAdd.click();
    }

    public EditProjectPage openEditProject()
    {
        ProjectsPage projects = new ProjectsPage(driver);
        projects.openProject();
        editComponentLink.click();
        return new EditProjectPage(driver);
    }

}
