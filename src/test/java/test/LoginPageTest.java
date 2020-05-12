package test;

import model.User;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import pages.LoginPage;
import service.UserCreator;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LoginPageTest extends BasePage {

    private final String LOG_OUT = "Logout";

    @Test
    public void logInTest()  {
        User testUser = UserCreator.withCredentialsFromProperty();
        LoginPage login = new LoginPage(_driver.get_driver());
        login.logIn(testUser);
        assertEquals(LOG_OUT, login.logOutIcon.getText());
    }

}
