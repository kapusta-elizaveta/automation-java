package test;

import driver.DriverInstance;
import driver.DriverType;
import org.junit.After;
import org.junit.Before;

public class BasePage {

    protected DriverInstance _driver;

    @Before()
    public void SetUp() {
        _driver = new DriverInstance(DriverType.CHROME);
        _driver.get_driver().manage().window().maximize();
    }

    @After
    public void TearDown() {
        _driver.get_driver().quit();
    }

}
