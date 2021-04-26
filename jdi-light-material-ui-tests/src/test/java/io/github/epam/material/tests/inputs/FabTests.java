package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.inputs.FabPage.*;

/**
 * To see an example of Floating Action Buttons web element please visit https://material-ui.com/components/floating-action-button/
 */

public class FabTests extends TestsInit {

    @BeforeTest
    public void beforeTest() {
        openSection("Floating Action Button");
    }

    private void lastClickTextsIs(Text lastClick, String txt) {
        lastClick.is().text(String.format("Last click:%s", txt));
    }

    @Test
    public void basicButtonsTest() {
        basicBtns.forEach(el -> el.is().displayed());
        lastClickTextsIs(basicBtnsLastClick, "");

        addBtn.is().enabled();
        addBtn.click();
        lastClickTextsIs(basicBtnsLastClick, " Add");

        editBtn.is().enabled();
        editBtn.click();
        lastClickTextsIs(basicBtnsLastClick, " Edit");

        extendedBtn.is().enabled();
        extendedBtn.click();
        lastClickTextsIs(basicBtnsLastClick, " Navigate");

        disabledBtn.is().disabled();
    }

    @Test
    public void animatedButtonsTest() {
        scrollBtns.forEach(el -> el.is().displayed());
        lastClickTextsIs(animatedBtnsLastClick, "");

        scrollBtns.get(1).click();
        itemNameOne.is().text("Item One");
        animatedBtn.waitFor().displayed();
        animatedBtn.click();
        lastClickTextsIs(animatedBtnsLastClick, " Add");

        scrollBtns.get(2).click();
        itemNameTwo.is().text("Item Two");
        animatedBtn.waitFor().displayed();
        animatedBtn.click();
        lastClickTextsIs(animatedBtnsLastClick, " Edit");

        scrollBtns.get(3).click();
        itemNameThree.is().text("Item Three");
        animatedBtn.waitFor().displayed();
        animatedBtn.click();
        lastClickTextsIs(animatedBtnsLastClick, " Expand");
    }
}
