package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static executionEngine.DriverScript.OR;

import java.util.concurrent.TimeUnit;

public class ActionKeywords {

    public static WebDriver driver;

    public void openBrowser(){
        driver=new ChromeDriver();
    }

    public static void navigate(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Constant Variable is used in place of URL
        //As it was declared as 'static', it can be used by referring the class name
        //Type the class name 'config.Constants' and press '.' dot, it will display all the memebers of the class config.Constants
        driver.get(Constants.URL);
    }


    public static void click(String object){
        //This is fetching the xpath of the element from the Object Repository property file
        driver.findElement(By.xpath(OR.getProperty(object))).click();
    }

    public static void input_UserName(String object){
        driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.UserName);
    }

    public static void input_Password(String object){
        driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.Password);
    }

    public static void waitFor(String object) throws Exception{
        Thread.sleep(5000);
    }

    public static void closeBrowser(String object){
        driver.quit();
    }

}
