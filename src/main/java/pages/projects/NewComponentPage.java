package pages.projects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;

public class NewComponentPage extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='New component']")
    public WebElement inputComponentName;

    @FindBy(xpath = "//button[@class='btn']")
    public WebElement createButton;

    @FindBy(xpath = "//button[@class='btn']")
    public WebElement componentCode;

    public NewComponentPage(WebDriver driver) {
        super(driver);
    }

    public void createComponent(String componentName)
    {
        ProjectPage project = new ProjectPage(driver);
        project.addComponent();
        inputComponentName.sendKeys(componentName);
        createButton.click();
    }

}
