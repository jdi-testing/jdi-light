package io.github.epam.material.tests.surfaces;

import static io.github.com.StaticSite.cardPage;
import static io.github.com.pages.surfaces.CardPage.*;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * To see an example of Card web element please visit https://material-ui.com/ru/components/cards/
 */
public class CardTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        cardPage.open();
        cardPage.isOpened();
    }

    private void textCheck(int index) {
        pTagTexts.get(index).has().text(Matchers.is("Word of the Day"));
        h2TagTexts.get(index).has().text(Matchers.is("be•nev•o•lent"));
    }

    @Test
    public void simpleCardTest() {
        textCheck(1);
    }

    @Test
    public void outlinedCardTest() {
        textCheck(2);
        outlinedCard.has().classValue(Matchers.containsString("MuiPaper-outlined"));
    }

    @Test
    public void complexCardTest() {
        String expectedText = "This impressive paella is a perfect party dish and a fun meal to cook together with your guests. Add 1 cup of frozen peas along with the mussels, if you like.";
        pTagTexts.get(3).has().text(Matchers.is(expectedText));
        complexCardImage.is().displayed();

        complexCardHeartIconButton.click();
        new Timer(1000L)
                .wait(() -> complexCardHeartIcon.has().classValue(Matchers.containsString("jss")));

        complexCardHeartIconButton.click();
        new Timer(1000L)
                .wait(() -> complexCardHeartIcon.has().classValue(Matchers.not("jss")));

        complexCardSliderDownButton.click();
        complexCardHiddenTextArea.is().displayed();
        complexCardHiddenText.get(1).has().text(Matchers.containsString("Method:"));
    }
}
