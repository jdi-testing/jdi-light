package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardImageOverlays;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Natalia Amelina on 02.10.2019
 * Email: natalia_amelina@epam.com; Skype: nat_amelina
 */
public class CardImageOverlaysTest  extends TestsInit {

    private static final String SRC_ATTR_EXPECTED = "https://jdi-testing.github.io/jdi-light/images/wolverin.jpg";
    private static final String ALT_ATTR_EXPECTED = "image";
    private static final String IMAGE_TOP_CLASS = "card-img";
    private static final String TITLE = "CARD TITLE";
    private static final int WIDTH = 86;
    private static final int HEIGHT = 137;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getTitleTest() {
        assertEquals(cardImageOverlays.title.getText(), TITLE);
    }

    @Test
    public void availabilityTest() {
        cardImageOverlays.title.is()
                .displayed()
                .enabled();
        cardImageOverlays.vectorImage.is()
                .hidden()
                .enabled();
    }

    @Test
    public void isValidationTest() {
        cardImageOverlays.title.is().text(is(TITLE));
        cardImageOverlays.vectorImage.unhighlight();
        cardImageOverlays.vectorImage.assertThat().width(is(WIDTH));
        cardImageOverlays.vectorImage.assertThat().height(is(HEIGHT));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(cardImageOverlays.vectorImage);
        baseValidation(cardImageOverlays.title);
    }

    @Test
    public void imageClassTest() {
        cardImageOverlays.vectorImage.is().core().hasClass(IMAGE_TOP_CLASS);
        cardImageOverlays.vectorImage.assertThat().core().hasClass(IMAGE_TOP_CLASS);
    }
}