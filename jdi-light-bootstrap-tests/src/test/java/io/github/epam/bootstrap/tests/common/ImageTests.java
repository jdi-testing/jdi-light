package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardImage;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class ImageTests extends TestsInit {
    private static final String SRC_ATTR_EXPECTED = "https://jdi-testing.github.io/jdi-light/images/wolverin.jpg";
    private static final String ALT_ATTR_EXPECTED = "image";
    private static final String IMAGE_TOP_CLASS = "card-img-top";
    private static final String WIDTH = "86";
    private static final String HEIGHT = "138";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void availabilityTest() {
        cardImage.image.is()
                .displayed()
                .enabled();
    }

    @Test
    public void getAltTest() {
        assertEquals(cardImage.image.alt(), ALT_ATTR_EXPECTED);
    }

    @Test
    public void isValidationTest() {
        cardImage.image.is().src(is(SRC_ATTR_EXPECTED));
        cardImage.image.is().alt(is(ALT_ATTR_EXPECTED));
        cardImage.image.unhighlight();
        cardImage.image.assertThat().width(is(WIDTH));
        cardImage.image.assertThat().height(is(HEIGHT));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(cardImage.image);
    }

    @Test
    public void imageClassTest() {
        cardImage.image.is().core().hasClass(IMAGE_TOP_CLASS);
        cardImage.image.assertThat().core().hasClass(IMAGE_TOP_CLASS);
    }
}
