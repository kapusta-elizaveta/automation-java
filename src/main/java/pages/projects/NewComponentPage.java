package pages.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class NewComponentPage extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='New component']")
    public WebElement InputComponentName;

    @FindBy(xpath = "//button[@class='btn']")
    public WebElement CreateButton;

    @FindBy(xpath = "//button[@class='btn']")
    public WebElement ComponentCode ;

    public NewComponentPage(WebDriver driver) {
        super(driver);
    }

    public void CreateComponent(String componentName)
    {
        ProjectPage project = new ProjectPage(driver);
        project.AddComponent();
        InputComponentName.sendKeys(componentName);
        CreateButton.click();
    }

}
