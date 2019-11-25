package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardMixinsUtilities;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.AssertJUnit.assertEquals;
import static org.hamcrest.Matchers.is;

/**
 * Created by Aleksandr Khmelinin on 26.09.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */

public class CardMixinsUtilitiesTests extends TestsInit {

    private String title = "THE SECRET TO MARVEL STUDIOS’ SUCCESS";
    private String text = "Because while the Marvel Cinematic Universe always includes plenty of spectacle and pulse pounding action, each blockbuster tells a very human story. The heroes of the world are flawed and funny, allowing audiences to connect with characters who are super powered and dealing with situations we truly can't comprehend.";
    private String header = "According To Samuel L. Jackson";
    private String footer = "For Cinema Blend";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getTitleTextTest() {
        assertEquals(cardMixinsUtilities.title.getText(), title);
    }

    @Test
    public void getTextTest() {
        assertEquals(cardMixinsUtilities.text.getText(), text);
    }

    @Test
    public void getHeaderTextTest() {
        assertEquals(cardMixinsUtilities.header.getText(), header);
    }

    @Test
    public void getFooterTextTest() {
        assertEquals(cardMixinsUtilities.footer.getText(), footer);
    }

    @Test
    public void isValidationTest() {
        cardMixinsUtilities.title.is()
                .text(is(title))
                .and().core()
                .css("color", "rgba(40, 167, 69, 1)");
        cardMixinsUtilities.text.is()
                .text(is(text))
                .and().core()
                .css("color", "rgba(40, 167, 69, 1)");
        cardMixinsUtilities.header.is()
                .text(is(header))
                .and().core()
                .css("color", "rgba(102, 102, 102, 1)");
        cardMixinsUtilities.footer.is()
                .text(is(footer))
                .and().core()
                .css("color", "rgba(102, 102, 102, 1)");
        cardMixinsUtilities.is()
                .displayed()
                .and().core()
                .css("border-color", "rgb(40, 167, 69)");
    }

    @Test
    public void baseValidationTest() {
        baseValidation(cardMixinsUtilities.title);
        baseValidation(cardMixinsUtilities.text);
        baseValidation(cardMixinsUtilities.header);
        baseValidation(cardMixinsUtilities.footer);
    }
}
