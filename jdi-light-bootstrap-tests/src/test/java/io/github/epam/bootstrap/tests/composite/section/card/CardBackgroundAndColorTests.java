package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardBody;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.core.Is.is;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Aleksandr Khmelinin on 23.09.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */

public class CardBackgroundAndColorTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    private String text = "This is some text within a card body.";


    cardBackground.
    @Test
    public void getBodyTextTest() {
        assertEquals(cardBody.text.getText(), text);
    }

    @Test
    public void isValidationTest() {
        cardBody.text.is().text(is(text));
    }

    @Test
    public void baseValidatonTest() {
        baseValidation(cardBody.text);
    }
}
