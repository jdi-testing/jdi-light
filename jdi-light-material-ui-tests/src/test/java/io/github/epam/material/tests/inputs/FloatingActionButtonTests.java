package io.github.epam.material.tests.inputs;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.floatingActionButtonPage;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonAdd;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonAnimatedAdd;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonAnimatedEdit;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonEdit;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonExpand;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonLike;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonNavigate;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonsBasic;
import static io.github.com.pages.inputs.FloatingActionButtonPage.labelAnimatedLastClick;
import static io.github.com.pages.inputs.FloatingActionButtonPage.labelLastClick;
import static io.github.com.pages.inputs.FloatingActionButtonPage.tabItemOne;
import static io.github.com.pages.inputs.FloatingActionButtonPage.tabItemThree;
import static io.github.com.pages.inputs.FloatingActionButtonPage.tabItemTwo;
import static io.github.com.pages.inputs.FloatingActionButtonPage.tabSections;

/**
 * To see an example of Floating Action Buttons web element please visit
 * https://material-ui.com/components/floating-action-button/
 * Floating Action Button
 */

public class FloatingActionButtonTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        floatingActionButtonPage.open();
    }

    @Test
    public void basicButtonsTest() {
        buttonsBasic.forEach(el -> el.is().displayed());
        labelLastClick.is().text("Last click:");

        buttonAdd.is().enabled();
        buttonAdd.click();
        labelLastClick.is().text("Last click: Add");

        buttonEdit.is().enabled();
        buttonEdit.click();
        labelLastClick.is().text("Last click: Edit");

        buttonNavigate.is().enabled();
        buttonNavigate.click();
        labelLastClick.is().text("Last click: Navigate");

        buttonLike.is().disabled();
    }

    @Test
    public void animatedButtonsTest() {
        Timer timer = new Timer(2000L);

        tabSections.forEach(el -> el.is().displayed());
        labelAnimatedLastClick.is().text("Last click:");

        tabSections.get(1).click();
        tabPanelContent.get(1).is().text("Item One");
        buttonAnimatedAdd.click();
        labelAnimatedLastClick.is().text("Last click: Add");

        tabSections.get(2).click();
        tabPanelContent.get(2).is().text("Item Two");
        timer.wait(() -> buttonAnimatedEdit.isDisplayed());
        buttonAnimatedEdit.click();
        labelAnimatedLastClick.is().text("Last click: Edit");

        tabSections.get(3).click();
        tabPanelContent.get(3).is().text("Item Three");
        timer.wait(() -> buttonExpand.isDisplayed());
        buttonExpand.click();
        labelAnimatedLastClick.is().text("Last click: Expand");
    }
}
