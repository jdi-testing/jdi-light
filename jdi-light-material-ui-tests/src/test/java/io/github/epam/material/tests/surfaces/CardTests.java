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
        jdiAssert(pTagTexts.get(index).text(), Matchers.is("Word of the Day"));
        jdiAssert(h2TagTexts.get(index).text(), Matchers.is("be•nev•o•lent"));
    }

    @Test
    public void simpleCardTest() {
        textCheck(1);
    }

    @Test
    public void outlinedCardTest() {
        textCheck(2);
        jdiAssert(outlinedCard.hasClass("MuiPaper-outlined"), Matchers.is(true));
    }

    @Test
    public void complexCardTest() {
        String expectedText = "This impressive paella is a perfect party dish and a fun meal to cook together with your guests. Add 1 cup of frozen peas along with the mussels, if you like.";
        jdiAssert(pTagTexts.get(3).text(), Matchers.is(expectedText));
        complexCardImage.is().displayed();

        complexCardHeartIconButton.click();
        boolean hasClass = new Timer(1000L)
                .wait(() -> complexCardHeartIcon.has().classValue(Matchers.containsString("jss")));
        jdiAssert(hasClass, Matchers.is(true));

        complexCardHeartIconButton.click();
        hasClass = new Timer(1000L)
                .wait(() -> complexCardHeartIcon.has().classValue(Matchers.not(expectedRedHeartClass)));
        jdiAssert(hasClass, Matchers.is(true));

        complexCardSliderDownButton.click();
        complexCardHiddenTextArea.is().displayed();
        jdiAssert(complexCardHiddenText.text(), Matchers.is("Method:"));
    }
}
