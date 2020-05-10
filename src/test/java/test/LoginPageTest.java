package test;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import pages.LoginPage;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LoginPageTest extends BasePage {

    private final String LOG_OUT = "Logout";
    private final String LOGIN = "integriuser2@mailinator.com";
    private final String PASSWORD = "integripassword";

    @Test
    public void logInTest() throws IOException, ParseException {
        LoginPage login = new LoginPage(_driver.get_driver());
        login.logIn();
        assertEquals(LOG_OUT, login.logOutIcon.getText());
    }

}
