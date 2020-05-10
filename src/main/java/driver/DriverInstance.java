package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstance {

    private WebDriver _driver ;

    public DriverInstance(DriverType driverType) {
        switch (driverType){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                _driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                _driver = new FirefoxDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                _driver = new InternetExplorerDriver();
                break;
            default:
                break;
        }
    }

    public WebDriver get_driver() {
        return _driver;
    }
}
