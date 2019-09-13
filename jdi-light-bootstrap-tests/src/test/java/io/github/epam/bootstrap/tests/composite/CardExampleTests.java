package io.github.epam.bootstrap.tests.composite;

import com.epam.jdi.light.elements.common.Alerts;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.Assert.assertEquals;


/**
 * Created by Aleksandr Khmelinin on 13.09.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */

public class CardExampleTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }
    private String title = "CARD TITLE";
    private String text = "Some quick example text to build" +
            " on the card title and make up the bulk of the card's content.";
    private String button = "Card Button Clicked!";
    private String imageLink = "https://jdi-testing.github.io/jdi-light/images/wolverin.jpg";

    @Test
    public void getTitleTextTest() {
        assertEquals(cardExampleTitle.getText(), title);
    }

    @Test
    public void getMainTextText() {
        assertEquals(cardExampleMainText.getText(), text);
    }

    @Test
    public void clickTest() {
        cardExampleButton.click();
        Alerts.validateAlert(is(button));
    }

    @Test
    public void imageTest() {
        assertEquals(cardExampleImage.src(), imageLink);
        cardExampleImage.is().src(containsString("wolverin.jpg"));
        cardExampleImage.is().alt(is("image"));
        cardExampleImage.assertThat().height(is(137));
        cardExampleImage.assertThat().width(is(86));
    }

}
