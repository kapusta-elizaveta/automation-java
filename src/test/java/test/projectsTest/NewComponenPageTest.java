package test.projectsTest;

import org.junit.Test;
import pages.LoginPage;
import pages.projects.NewComponentPage;
import test.BasePage;

import static org.junit.Assert.assertEquals;

public class NewComponenPageTest extends BasePage {

    private final String COMPONENT_NAME = "Component name";
    private final String BUTTON_UPDATE = "Update";

    @Test
    public void CreateComponentTest()
    {
        LoginPage loginPage = new LoginPage(_driver.get_driver());
        loginPage.logIn();
        NewComponentPage newComponentPage = new NewComponentPage(_driver.get_driver());
        newComponentPage.CreateComponent(COMPONENT_NAME);
        _driver.get_driver().navigate().refresh();
        assertEquals(BUTTON_UPDATE, newComponentPage.ComponentCode.getText());
    }

}
