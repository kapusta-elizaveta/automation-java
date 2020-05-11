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
    public void AddDiscriptionTest()
    {
        LoginPage loginPage = new LoginPage(_driver.get_driver());
        loginPage.logIn();
        EditProjectPage editProjectPage = new EditProjectPage(_driver.get_driver());
        editProjectPage.EditDescription(DESCRIPTION);
        ProjectsPage projectsPage = new ProjectsPage(_driver.get_driver());
        ProjectPage project = projectsPage.OpenProject();
        assertEquals(DESCRIPTION, project.ProjectDescription.getText());
    }

}
