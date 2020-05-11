package pages.billing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;

public class NewCardPage extends AbstractPage {

    private final String XPATH_WRONG_MESSAGE = "//div[@class='col-xs-11 col-sm-4 alert alert-danger animated fadeInDown']";

    @FindBy(xpath = "//input[@placeholder='0000 0000 0000 0000']")
    public WebElement InputNumberCard;

    @FindBy(xpath = "//input[@placeholder='MM']")
    public WebElement InputMonth;

    @FindBy(xpath = "//input[@placeholder='YYYY']")
    public WebElement InputYear;

    @FindBy(xpath = "//input[@placeholder='Cardholder name']")
    public WebElement InputCardholderName;

     @FindBy(xpath = "//button[@class='btn']")
    public WebElement AddButton;

    public NewCardPage(WebDriver driver) {
        super(driver);
    }

    public void AddWrongCard(String numberCard, String month, String year , String cardholderName)
    {
        BillingPage billingPage = new BillingPage(driver);
        billingPage.openCardPage();
        InputNumberCard.sendKeys(numberCard);
        InputMonth.sendKeys(month);
        InputYear.sendKeys(year);
        InputCardholderName.sendKeys(cardholderName);
        new WebDriverWait(driver, 30).until(ExpectedConditions
                .elementToBeClickable(AddButton));
        AddButton.click();
    }

    public boolean IsWrongCard()
    {
        new WebDriverWait(driver, 5).until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.xpath(XPATH_WRONG_MESSAGE)));
        return true;
    }
}
