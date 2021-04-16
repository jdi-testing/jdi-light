package io.github.epam.material.tests.surfaces;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.StaticSite.surfaceCardPage;
import static io.github.com.pages.surfaces.CardPage.*;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CardTests extends TestsInit {

    @BeforeTest
    public void beforeTest() {
        openSection("Card");
        surfaceCardPage.isOpened();
    }

    private void textCheck(int index) {
        String expectedPTagText = "Word of the Day";
        String expectedH2TagText = "be•nev•o•lent";
        jdiAssert(pTagTexts.get(index).text(), Matchers.is(expectedPTagText));
        jdiAssert(h2TagTexts.get(index).text(), Matchers.is(expectedH2TagText));
    }

    @Test
    public void simpleCardTest() {
        textCheck(1);
    }

    @Test
    public void outlinedCardTest() {
        textCheck(2);
        String expectedClassName = "MuiPaper-outlined";
        jdiAssert(outlinedCard.hasClass(expectedClassName), Matchers.is(true));
    }

    @Test
    public void complexCardTest() {
        String expectedText = "This impressive paella is a perfect party dish and a fun meal to cook together with your guests. Add 1 cup of frozen peas along with the mussels, if you like.";
        String expectedRedHearthClass = "jss";
        jdiAssert(pTagTexts.get(3).text(), Matchers.is(expectedText));
        complexCardImage.is().displayed();

        complexCardHearthIconButton.click();
        boolean hasClass = new Timer(1000L)
                .wait(() -> complexCardHearthIcon.has().classValue(Matchers.containsString(expectedRedHearthClass)));
        jdiAssert(hasClass, Matchers.is(true));

        complexCardHearthIconButton.click();
        hasClass = new Timer(1000L)
                .wait(() -> complexCardHearthIcon.has().classValue(Matchers.not(expectedRedHearthClass)));
        jdiAssert(hasClass, Matchers.is(true));

        expectedText = "Method:";
        complexCardSliderDownButton.click();
        complexCardHiddenTextArea.is().displayed();
        jdiAssert(complexCardHiddenText.text(), Matchers.is(expectedText));
    }
}
