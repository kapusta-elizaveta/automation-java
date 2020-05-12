package test.billingTest;

import model.Card;
import model.User;
import org.junit.Test;
import pages.LoginPage;
import pages.billing.NewCardPage;
import service.CardCreator;
import service.UserCreator;
import test.BasePage;

import static org.junit.Assert.assertTrue;

public class NewCardPageTest extends BasePage {

    @Test
    public void addWrongCardTest()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        LoginPage login = new LoginPage(_driver.get_driver());
        login.logIn(testUser);
        Card testCard = CardCreator.withCredentialsFromProperty();
        NewCardPage newCard = new NewCardPage(_driver.get_driver());
        newCard.AddWrongCard(testCard);
        assertTrue(newCard.IsWrongCard());
    }

}
