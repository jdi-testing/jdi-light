package io.github.epam.material.tests.inputs;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.floatingActionButtonPage;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonsBasic;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonAdd;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonEdit;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonNavigate;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonLike;
import static io.github.com.pages.inputs.FloatingActionButtonPage.labelLastClick;
import static io.github.com.pages.inputs.FloatingActionButtonPage.tabSections;
import static io.github.com.pages.inputs.FloatingActionButtonPage.labelAnimatedLastClick;
import static io.github.com.pages.inputs.FloatingActionButtonPage.tabPanelContent;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonAnimatedAdd;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonAnimatedEdit;
import static io.github.com.pages.inputs.FloatingActionButtonPage.buttonExpand;

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
        labelLastClick.has().text("Last click:");

        buttonAdd.is().enabled();
        buttonAdd.click();
        labelLastClick.has().text("Last click: Add");

        buttonEdit.is().enabled();
        buttonEdit.click();
        labelLastClick.has().text("Last click: Edit");

        buttonNavigate.is().enabled();
        buttonNavigate.click();
        labelLastClick.is().text("Last click: Navigate");

        buttonLike.is().disabled();
    }

    @Test
    public void animatedButtonsTest() {
        tabSections.is().displayed();
        labelAnimatedLastClick.has().text("Last click:");

        tabSections.select(1);
        tabPanelContent.get(1).has().text("Item One");
        buttonAnimatedAdd.click();
        labelAnimatedLastClick.has().text("Last click: Add");

        tabSections.select(2);
        tabPanelContent.get(2).has().text("Item Two");
        buttonAnimatedEdit.is().displayed();
        buttonAnimatedEdit.click();
        labelAnimatedLastClick.has().text("Last click: Edit");

        tabSections.select(3);
        tabPanelContent.get(3).has().text("Item Three");
        buttonExpand.is().displayed();
        buttonExpand.click();
        labelAnimatedLastClick.has().text("Last click: Expand");
    }
}
