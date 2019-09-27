package io.github.epam.bootstrap.tests.composite.section.card;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardExample;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Natalia Amelina on 27.09.2019
 * Email: natalia_amelina@epam.com; Skype: nat_amelina
 */
public class CardImageTest extends TestsInit {

    private static final String SRC_ATTR_EXPECTED = "https://jdi-testing.github.io/jdi-light/images/wolverin.jpg";
    private static final String ALT_ATTR_EXPECTED = "image";
    private static final String IMAGE_TOP_CLASS = "card-img-top";
    private static final String TEXT = "Some quick example text";
    private static final int WIDTH = 86;
    private static final int HEIGHT = 137;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getMainTextText() {
        assertEquals(cardExample.text.getText(), TEXT);
    }

    @Test
    public void getSrcTest() {
        assertEquals(cardExample.image.src(), SRC_ATTR_EXPECTED);
    }

    @Test
    public void getAltTest() {
        assertEquals(cardExample.image.alt(), ALT_ATTR_EXPECTED);
    }

    @Test
    public void isValidationTest() {
        cardExample.text.is().text(is(TEXT));
        cardExample.image.is().src(is(SRC_ATTR_EXPECTED));
        cardExample.image.is().alt(is(ALT_ATTR_EXPECTED));
        cardExample.image.unhighlight();
        cardExample.image.assertThat().width(is(WIDTH));
        cardExample.image.assertThat().height(is(HEIGHT));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(cardExample.image);
        baseValidation(cardExample.text);
    }

    @Test
    public void imageClassTest() {
        cardExample.image.is().core().hasClass(IMAGE_TOP_CLASS);
        cardExample.image.assertThat().core().hasClass(IMAGE_TOP_CLASS);
    }
}