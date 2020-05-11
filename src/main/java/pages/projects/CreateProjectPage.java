package pages.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

import java.util.ArrayList;
import java.util.Set;

public class CreateProjectPage extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='New project']")
    public WebElement inputProjectName;

    @FindBy(xpath = "//textarea[@placeholder='Type here...']")
    public WebElement inputProjectDiscription;

    @FindBy(xpath = "//input[@placeholder='example.com']")
    public WebElement inputDomain;

    @FindBy(xpath = "//button[@class='btn']")
    public WebElement createButton;

    @FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Projects')]")
    public WebElement projectsLink;

    @FindBy(xpath = "//a[@class='nav-link'][contains(text(),'Projects')]")
    public WebElement libraryLink;


    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    public void addProject(String projectName, String projectDiscription, String domain)
    {
        ProjectsPage projects = new ProjectsPage(driver);
        projects.openAddProject();
        inputProjectName.sendKeys(projectName);
        inputProjectDiscription.sendKeys(projectDiscription);
        inputDomain.sendKeys(domain);
        createButton.click();
    }

    public int openProjectsPage(String xpathCountProject, String pageTitle)
    {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
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
