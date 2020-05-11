package test;

import org.junit.Test;
import pages.MainPage;
import pages.projects.ProjectsPage;

import static org.junit.Assert.assertEquals;

public class MainPageTest extends BasePage {

    private final String TEXT_LOG_IN_BUTTON = "Log in";

     @Test
    public void LogOutTest()
    {
        ProjectsPage projects = new ProjectsPage(_driver.get_driver());
        MainPage mainPage = projects.LogOut();
        assertEquals(TEXT_LOG_IN_BUTTON, mainPage.LogInButton.getText());
    }
}
