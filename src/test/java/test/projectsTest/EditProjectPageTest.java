package test.projectsTest;

import model.User;
import org.junit.Test;
import pages.LoginPage;
import pages.projects.EditProjectPage;
import pages.projects.ProjectPage;
import pages.projects.ProjectsPage;
import service.UserCreator;
import test.BasePage;

import static org.junit.Assert.assertEquals;

public class EditProjectPageTest extends BasePage {

    private final String DESCRIPTION = "Edit description";

    @Test
    public void addDiscriptionTest()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        LoginPage login = new LoginPage(_driver.get_driver());
        login.logIn(testUser);
        EditProjectPage editProjectPage = new EditProjectPage(_driver.get_driver());
        editProjectPage.editDescription(DESCRIPTION);
        ProjectsPage projectsPage = new ProjectsPage(_driver.get_driver());
        ProjectPage project = projectsPage.openProject();
        assertEquals(DESCRIPTION, project.projectDescription.getText());
    }

}
