package io.github.epam.bootstrap.tests.composite.section.card;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardHorizontal;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Aleksandr Khmelinin on 25.09.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */

public class CardHorizontalTests extends TestsInit {

    private String titleText = "WOLVERINE";
    private String mainText = "Wolverine is a fictional character appearing in American comic books published by Marvel" +
            " Comics, mostly in association with the X-Men. He is a mutant who possesses animal-keen senses, enhanced" +
            " physical capabilities, powerful regenerative ability known as a healing factor, and three retractable" +
            " claws in each hand. Wolverine has been depicted variously as a member of the X-Men, Alpha Flight," +
            " and the Avengers.";
    private String smallText = "The character appeared in #180 (1974)";
    private String imageSrc = "https://jdi-testing.github.io/jdi-light/images/wolverin.jpg";
    private String imageTitle = "Wolverine icon";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getTitleTextTest() {
        assertEquals(cardHorizontal.title.getText(), titleText);
    }

    @Test
    public void getMainTextText() {
        assertEquals(cardHorizontal.mainText.getText(), mainText);
    }

    @Test
    public void getSmallTextTest() {
        assertEquals(cardHorizontal.smallText.getText(), smallText);
    }

    @Test
    public void getSrcTest() {
        assertEquals(cardHorizontal.image.src(), imageSrc);
    }

    @Test
    public void checkElementsPositionTest() {
        boolean execResult = WebDriverFactory.jsExecute("var img = document.getElementById('card-horizontal-img');" +
                "var imgOffset = img.getBoundingClientRect().left;" +
                "var title = document.getElementById('card-horizontal-title');" +
                "var titleOffset = title.getBoundingClientRect().left;" +
                "return imgOffset < titleOffset;");
        assertTrue(execResult);
    }

    @Test
    public void isValidationTest() {
        cardHorizontal.title.is().text(is(titleText));
        cardHorizontal.mainText.is().text(is(mainText));
        cardHorizontal.smallText.is().displayed()
                .and().text(is(smallText))
                .core()
                .css("font-size", is("11.2px"))
                .tag(is("small"));
        cardHorizontal.image.is().displayed()
                .and().src(is(imageSrc))
                .core()
                .attr("title", imageTitle);
        cardHorizontal.image.unhighlight();
        cardHorizontal.image.assertThat().width(anyOf(is(91), is(94)));
        cardHorizontal.image.assertThat().height(anyOf(is(146), is(150)));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(cardHorizontal.title);
        baseValidation(cardHorizontal.mainText);
        baseValidation(cardHorizontal.smallText);
        baseValidation(cardHorizontal.image);
    }
}
