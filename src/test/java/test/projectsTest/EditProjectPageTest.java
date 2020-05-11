package test.projectsTest;

import org.junit.Test;
import pages.LoginPage;
import pages.projects.EditProjectPage;
import pages.projects.ProjectPage;
import pages.projects.ProjectsPage;
import test.BasePage;

import static org.junit.Assert.assertEquals;

public class EditProjectPageTest extends BasePage {

    private final String DESCRIPTION = "Edit description";

    @Test
    public void addDiscriptionTest()
    {
        LoginPage loginPage = new LoginPage(_driver.get_driver());
        loginPage.logIn();
        EditProjectPage editProjectPage = new EditProjectPage(_driver.get_driver());
        editProjectPage.editDescription(DESCRIPTION);
        ProjectsPage projectsPage = new ProjectsPage(_driver.get_driver());
        ProjectPage project = projectsPage.openProject();
        assertEquals(DESCRIPTION, project.projectDescription.getText());
    }

}
