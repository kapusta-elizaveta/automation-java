package test;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;

public class LoginPageTest extends BasePage {

    private final String LOG_OUT = "Logout";
    private final String LOGIN = "DDD";
    private final String PASSWORD = "VVVV";

    @Test
    public void LogInTest()
    {
        LoginPage login = new LoginPage(_driver.get_driver());
        login.LogIn(LOGIN, PASSWORD);
        Assert.assertEquals(LOG_OUT, login.logOutIcon.getText(), "User didn't log in");
    }

}
