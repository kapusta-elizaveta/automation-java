package test;

import model.User;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.projects.ProjectsPage;
import service.UserCreator;

import static org.junit.Assert.assertEquals;

public class MainPageTest extends BasePage {

    private final String TEXT_LOG_IN_BUTTON = "Log in";

     @Test
    public void logOutTest()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        LoginPage login = new LoginPage(_driver.get_driver());
        ProjectsPage projects = login.logIn(testUser);
        MainPage mainPage = projects.logOut();
        assertEquals(TEXT_LOG_IN_BUTTON, mainPage.logInButton.getText());
    }
}
