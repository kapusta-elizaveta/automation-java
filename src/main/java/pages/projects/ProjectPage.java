package pages.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class ProjectPage extends AbstractPage {

    @FindBy(xpath = "//span[@class='iv-icon iv-icon-file-add']")
    public WebElement IconComponentAdd;

    @FindBy(xpath = "//a[contains(text(),'Edit')]")
    public WebElement EditComponentLink;

    @FindBy(xpath = "//div[@class='col-12 description']")
    public WebElement ProjectDescription;

    protected ProjectPage(WebDriver driver) {
        super(driver);
    }

    public void AddComponent()
    {
        ProjectsPage projects = new ProjectsPage(driver);
        projects.OpenProject();
        IconComponentAdd.click();
    }

    public EditProjectPage OpenEditProject()
    {
        ProjectsPage projects = new ProjectsPage(driver);
        projects.OpenProject();
        EditComponentLink.click();
        return new EditProjectPage(driver);
    }

}
