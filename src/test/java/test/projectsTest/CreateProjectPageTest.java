package test.projectsTest;

import model.User;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import pages.projects.CreateProjectPage;
import service.UserCreator;
import test.BasePage;

import static org.junit.Assert.assertEquals;

public class CreateProjectPageTest extends BasePage {

    private final String PROJECT_NAME = "Project name";
    private final String PROJECT_DISCRIPTION = "Project discription";
    private final String DOMAIN = "test.com";
    private final String PAGE_TITLE = "IntegriVideo - Video components for your website";
    private final String XPATH_COUNT_PROJECTS = "//div[@class='col-xl-4 col-sm-6']";

    @Test
    public void createProjectTest()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        LoginPage login = new LoginPage(_driver.get_driver());
        login.logIn(testUser);
        int oldCountProject = _driver.get_driver().findElements(By.xpath(XPATH_COUNT_PROJECTS)).size();
        CreateProjectPage createProject = new CreateProjectPage(_driver.get_driver());
        createProject.addProject(PROJECT_NAME, PROJECT_DISCRIPTION, DOMAIN);
        String parentWindowHandle = _driver.get_driver().getWindowHandle();
        int newCountProjects = createProject.openProjectsPage(XPATH_COUNT_PROJECTS, PAGE_TITLE);
        _driver.get_driver().close();
        _driver.get_driver().switchTo().window(parentWindowHandle);
        assertEquals(newCountProjects, ++oldCountProject);
    }
}
