package io.github.epam.material.tests.inputs;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.fabPage;
import static io.github.com.pages.inputs.FabPage.*;

/**
 * To see an example of Floating Action Buttons web element please visit
 * https://material-ui.com/components/floating-action-button/
 * Floating Action Button
 */

public class FabTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        fabPage.open();
    }

    @Test
    public void basicButtonsTest() {
        basicBtns.forEach(el -> el.is().displayed());
        basicBtnsLastClick.is().text("Last click:");

        addBtn.is().enabled();
        addBtn.click();
        basicBtnsLastClick.is().text("Last click: Add");

        editBtn.is().enabled();
        editBtn.click();
        basicBtnsLastClick.is().text("Last click: Edit");

        extendedBtn.is().enabled();
        extendedBtn.click();
        basicBtnsLastClick.is().text("Last click: Navigate");

        disabledBtn.is().disabled();
    }

    @Test
    public void animatedButtonsTest() {
        Timer timer = new Timer(2000L);

        scrollBtns.forEach(el -> el.is().displayed());
        animatedBtnsLastClick.is().text("Last click:");

        scrollBtns.get(1).click();
        itemNameOne.is().text("Item One");
        addButton.click();
        animatedBtnsLastClick.is().text("Last click: Add");

        scrollBtns.get(2).click();
        itemNameTwo.is().text("Item Two");
        timer.wait(() -> editButton.isDisplayed());
        editButton.click();
        animatedBtnsLastClick.is().text("Last click: Edit");

        scrollBtns.get(3).click();
        itemNameThree.is().text("Item Three");
        timer.wait(() -> expandButton.isDisplayed());
        expandButton.click();
        animatedBtnsLastClick.is().text("Last click: Expand");
    }
}
