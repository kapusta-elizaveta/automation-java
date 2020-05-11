package pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import java.util.Set;

public class CreateProjectPage extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='New project']")
    public WebElement InputProjectName;

    @FindBy(xpath = "//textarea[@placeholder='Type here...']")
    public WebElement InputProjectDiscription;

    @FindBy(xpath = "//input[@placeholder='example.com']")
    public WebElement InputDomain;

    @FindBy(xpath = "//button[@class='btn']")
    public WebElement CreateButton;

    @FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Projects')]")
    public WebElement ProjectsLink;

    @FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Projects')]")
    public WebElement LibraryLink;


    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    public void AddProject(String projectName, String projectDiscription, String domain)
    {
        ProjectsPage projects = new ProjectsPage(driver);
        projects.OpenAddProject();
        InputProjectName.sendKeys(projectName);
        InputProjectDiscription.sendKeys(projectDiscription);
        InputDomain.sendKeys(domain);
        CreateButton.click();
    }

    public int OpenProjectsPage(String xpathCountProject, String pageTitle)
    {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        switchWindows(pageTitle);
        driver.get("https://www.integrivideo.com/app/projects");;
        return driver.findElements(By.xpath(xpathCountProject)).size();
    }

    private void switchWindows(String title)
    {
        Set<String> allWindowsHandles = driver.getWindowHandles();
        for (String handle : allWindowsHandles)
        {
            String switchedWindowTitle = driver.switchTo().window(handle).getTitle();
            if (title.equals(switchedWindowTitle))
            {
                break;
            }
        }
    }


}
