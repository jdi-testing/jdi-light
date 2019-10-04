package io.github.epam.bootstrap.tests.composite.section.card;

import com.epam.jdi.light.elements.base.UIBaseElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
    private static Object[][] getElement() {
        return new Object[][] {
            {cardImageOverlays.overlaySection.title},
            {cardImageOverlays.vectorImage}
        };
    }

    @Test(dataProvider = "getElement")
    public void availabilityTest(UIBaseElement element) {
        element.is()
                .displayed()
                .notAppear()
                .enabled();
    }

    @Test
    public void isValidationTest() {
        cardImageOverlays.overlaySection.title.is().text(is(TITLE));
        cardImageOverlays.vectorImage.assertThat().height(is(HEIGHT));
        cardImageOverlays.vectorImage.assertThat().width(is(WIDTH));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(cardImageOverlays.vectorImage);
        baseValidation(cardImageOverlays.overlaySection.title);
    }

    @Test
    public void classTest() {
        cardImageOverlays.overlaySection.is().core().hasClass(IMAGE_TOP_CLASS);
        cardImageOverlays.overlaySection.assertThat().core().hasClass(OVERLAY_CLASS);
        cardImageOverlays.vectorImage.is().core().hasClass(IMAGE_TOP_CLASS);
        //cardImageOverlays.vectorImage.assertThat().core().hasClass(IMAGE_TOP_CLASS);
    }
}