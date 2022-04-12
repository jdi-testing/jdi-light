package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.buttonPage;
import static io.github.com.pages.inputs.ButtonPage.containedButtons;
import static io.github.com.pages.inputs.ButtonPage.simpleLastClick;
import static io.github.com.pages.inputs.ButtonPage.textButtons;
import static io.github.com.pages.inputs.ButtonPage.textLastClick;
import static io.github.com.pages.inputs.ButtonPage.iconLabelButtons;
import static io.github.com.pages.inputs.ButtonPage.iconLabelIcons;
import static io.github.com.pages.inputs.ButtonPage.labeledLastClick;
import static io.github.com.pages.inputs.ButtonPage.iconButtons;
import static io.github.com.pages.inputs.ButtonPage.iconButtonIcons;
import static io.github.com.pages.inputs.ButtonPage.iconLastClick;
import static io.github.com.pages.inputs.ButtonPage.customizedButtons;
import static io.github.com.pages.inputs.ButtonPage.customizedLastClick;
import static io.github.com.pages.inputs.ButtonPage.complexButtons;
import static io.github.com.pages.inputs.ButtonPage.complexLastClick;
/**
 * To see an example of Button web element please visit
 * https://material-ui.com/components/buttons/
 */

public class ButtonTests extends TestsInit {

    @BeforeMethod
    public void before() {
        buttonPage.open();
        buttonPage.isOpened();
    }

    @Test
    public void defaultButtonTest() {

        containedButtons.get(1).click();
        containedButtons.get(1).has().text("DEFAULT");
        simpleLastClick.is().text("Last click: Default");

        containedButtons.get(2).click();
        containedButtons.get(2).has().text("PRIMARY");
        simpleLastClick.is().text("Last click: Primary");

        containedButtons.get(3).click();
        containedButtons.get(3).has().text("SECONDARY");
        simpleLastClick.is().text("Last click: Secondary");

        containedButtons.get(4).has().text("DISABLED");
        containedButtons.get(4).has().attr("disabled");
        containedButtons.get(4).is().disabled();

        containedButtons.get(5).click();
        containedButtons.get(5).has().text("LINK");
        simpleLastClick.is().text("Last click: Link");
        containedButtons.get(5).is().notVisible();
    }

    @Test
    public void textButtonTest() {

        textButtons.get(1).click();
        textButtons.get(1).has().text("DEFAULT");
        textLastClick.is().text("Last click: Default");

        textButtons.get(2).click();
        textButtons.get(2).has().text("PRIMARY");
        textLastClick.is().text("Last click: Primary");

        textButtons.get(3).click();
        textButtons.get(3).has().text("SECONDARY");
        textLastClick.is().text("Last click: Secondary");

        textButtons.get(4).has().text("DISABLED");
        textButtons.get(4).has().attr("disabled");
        textButtons.get(4).is().disabled();

        textButtons.get(5).click();
        textButtons.get(5).has().text("LINK");
        textLastClick.is().text("Last click: Link");
        textButtons.get(5).is().notVisible();
    }

    @Test
    public void iconLabelButtonTest() {

        iconLabelButtons.get(1).click();
        iconLabelButtons.get(1).has().text("DELETE");
        labeledLastClick.is().text("Last click: Delete");
        iconLabelIcons.get(1).is().displayed();

        iconLabelButtons.get(2).click();
        iconLabelButtons.get(2).has().text("SEND\nSEND");
        labeledLastClick.is().text("Last click: Sendsend");
        iconLabelIcons.get(2).is().displayed();

        iconLabelButtons.get(3).click();
        iconLabelButtons.get(3).has().text("UPLOAD");
        labeledLastClick.is().text("Last click: Upload");
        iconLabelIcons.get(3).is().displayed();

        iconLabelButtons.get(4).has().attr("disabled");
        iconLabelButtons.get(4).has().text("TALK");
        iconLabelIcons.get(4).is().displayed();

        iconLabelButtons.get(5).click();
        iconLabelButtons.get(5).has().text("SAVE");
        labeledLastClick.is().text("Last click: Save");
        iconLabelIcons.get(5).is().displayed();

        iconLabelButtons.get(6).click();
        iconLabelButtons.get(6).has().text("SAVE ALL");
        labeledLastClick.is().text("Last click: Save all");
        iconLabelIcons.get(6).is().displayed();
    }

    @Test
    public void iconButtonTest() {

        iconButtons.get(1).click();
        iconLastClick.is().text("Last click: Delete enabled");
        iconButtonIcons.get(1).is().displayed();

        iconButtons.get(2).has().attr("disabled");
        iconButtons.get(2).is().disabled();
        iconButtonIcons.get(2).is().displayed();

        iconButtons.get(3).click();
        iconLastClick.is().text("Last click: Alarm");
        iconButtonIcons.get(3).is().displayed();

        iconButtons.get(4).click();
        iconLastClick.is().text("Last click: Shopping cart");
        iconButtonIcons.get(4).is().displayed();
    }

    @Test
    public void customizedButtonTest() {

        customizedButtons.get(1).click();
        customizedButtons.get(1).has().text("CUSTOM CSS");
        customizedLastClick.is().text("Last click: Custom CSS");

        customizedButtons.get(2).click();
        customizedButtons.get(2).has().text("THEME PROVIDER");
        customizedLastClick.is().text("Last click: Theme Provider");

        customizedButtons.get(3).click();
        customizedButtons.get(3).has().text("Bootstrap");
        customizedLastClick.is().text("Last click: Bootstrap");
    }

    @Test
    public void complexButtonTest() {

        complexButtons.get(1).click();
        complexButtons.get(1).has().text("Breakfast");
        complexLastClick.is().text("Last click:Breakfast");

        complexButtons.get(2).click();
        complexButtons.get(2).has().text("Burgers");
        complexLastClick.is().text("Last click:Burgers");

        complexButtons.get(3).click();
        complexButtons.get(3).has().text("Camera");
        complexLastClick.is().text("Last click:Camera");
    }
}
