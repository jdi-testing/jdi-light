package io.github.epam.bootstrap.tests.composite.section.card;

import com.epam.jdi.light.elements.base.UIBaseElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.cardImageOverlays;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Natalia Amelina on 02.10.2019
 * Email: natalia_amelina@epam.com; Skype: nat_amelina
 */
public class CardImageOverlaysTests extends TestsInit {

    private static final String VECTOR_TEXT_TAG = "text";
    private static final String VECTOR_TEXT = "Card image";
    private static final String VECTOR_TEXT_ATTR = "fill";
    private static final String VECTOR_TEXT_VALUE = "#dee2e6";
    private static final String IMAGE_TOP_CLASS = "card-img";
    private static final String OVERLAY_CLASS = "card-img-overlay";
    private static final String TITLE = "CARD TITLE";
    private static final String WIDTH = "100%";
    private static final int HEIGHT = 270;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getTitleTest() {
        assertEquals(cardImageOverlays.overlaySection.title.getText(), TITLE);
    }

    @DataProvider
    public static Object[][] getElement() {
        return new Object[][] {
            {cardImageOverlays.overlaySection.title},
            {cardImageOverlays.image}
        };
    }

    @Test(dataProvider = "getElement")
    public void availabilityTest(UIBaseElement element) {
        element.is()
                .displayed()
                .enabled();
    }

    @Test
    public void isValidationTest() {
        cardImageOverlays.overlaySection.title.is().text(is(TITLE));
        cardImageOverlays.image.assertThat().height(is(HEIGHT));
        cardImageOverlays.image.assertThat().width(is(WIDTH));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(cardImageOverlays.image);
        baseValidation(cardImageOverlays.overlaySection.title);
    }

    @Test
    public void classTest() {
        cardImageOverlays.overlaySection.is().core().hasClass(OVERLAY_CLASS);
        cardImageOverlays.overlaySection.assertThat().core().hasClass(OVERLAY_CLASS);
        cardImageOverlays.image.is().core().hasClass(IMAGE_TOP_CLASS);
        cardImageOverlays.image.assertThat().core().hasClass(IMAGE_TOP_CLASS);
    }

    @Test
    public void vectorInternalElementsTest() {
        assertEquals(cardImageOverlays.image.getText(VECTOR_TEXT_TAG), VECTOR_TEXT);
        assertEquals(cardImageOverlays.image.getAttribute(VECTOR_TEXT_TAG, VECTOR_TEXT_ATTR), VECTOR_TEXT_VALUE);
    }
}
