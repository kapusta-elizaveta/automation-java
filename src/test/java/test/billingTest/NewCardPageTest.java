package test.billingTest;

import org.junit.Test;
import pages.LoginPage;
import pages.billing.NewCardPage;
import test.BasePage;

import static org.junit.Assert.assertTrue;

public class NewCardPageTest extends BasePage {

    private final String NUMBER_CARD = "2343566545342222";
    private final String MONTH = "12";
    private final String YEAR = "2021";
    private final String NAME = "integri";

    @Test
    public void addWrongCardTest()
    {
        LoginPage loginPage = new LoginPage(_driver.get_driver());
        loginPage.logIn();
        NewCardPage newCard = new NewCardPage(_driver.get_driver());
        newCard.AddWrongCard(NUMBER_CARD, MONTH, YEAR, NAME);
        assertTrue(newCard.IsWrongCard());
    }

}
