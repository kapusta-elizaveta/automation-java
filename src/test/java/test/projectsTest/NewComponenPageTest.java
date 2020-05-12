package test.projectsTest;

import model.User;
import org.junit.Test;
import pages.LoginPage;
import pages.projects.NewComponentPage;
import service.UserCreator;
import test.BasePage;

import static org.junit.Assert.assertEquals;

public class NewComponenPageTest extends BasePage {

    private final String COMPONENT_NAME = "Component name";
    private final String BUTTON_UPDATE = "Update";

    @Test
    public void createComponentTest()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        LoginPage login = new LoginPage(_driver.get_driver());
        login.logIn(testUser);
        NewComponentPage newComponentPage = new NewComponentPage(_driver.get_driver());
        newComponentPage.createComponent(COMPONENT_NAME);
        _driver.get_driver().navigate().refresh();
        assertEquals(BUTTON_UPDATE, newComponentPage.componentCode.getText());
    }

}
