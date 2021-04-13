package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.inputs.ButtonPage.*;

/**
 * To see an example of Button web element please visit https://material-ui.com/components/buttons/
 */

public class ButtonTests extends TestsInit {

    @BeforeTest
    public void before() {
        openSection("Buttons");
    }

    @Test
    public void defaultButtonTest() {

        containedButtons.get(1).click();
        containedButtons.get(1).is().text("DEFAULT");
        containedButtons.get(6).is().text("Last click: Default");

        containedButtons.get(2).click();
        containedButtons.get(2).is().text("PRIMARY");
        containedButtons.get(6).is().text("Last click: Primary");

        containedButtons.get(3).click();
        containedButtons.get(3).is().text("SECONDARY");
        containedButtons.get(6).is().text("Last click: Secondary");

        containedButtons.get(4).is().text("DISABLED");
        containedButtons.get(4).is().attr("disabled");
        containedButtons.get(4).is().disabled();

        containedButtons.get(5).click();
        containedButtons.get(5).is().text("LINK");
        containedButtons.get(6).is().text("Last click: Link");
        containedButtons.get(5).is().notVisible();
    }

    @Test
    public void textButtonTest() {

        textButtons.get(1).click();
        textButtons.get(1).is().text("DEFAULT");
        textButtons.get(6).is().text("Last click: Default");

        textButtons.get(2).click();
        textButtons.get(2).is().text("PRIMARY");
        textButtons.get(6).is().text("Last click: Primary");

        textButtons.get(3).click();
        textButtons.get(3).is().text("SECONDARY");
        textButtons.get(6).is().text("Last click: Secondary");

        textButtons.get(4).is().text("DISABLED");
        textButtons.get(4).is().attr("disabled");
        textButtons.get(4).is().disabled();

        textButtons.get(5).click();
        textButtons.get(5).is().text("LINK");
        textButtons.get(6).is().text("Last click: Link");
        textButtons.get(5).is().notVisible();
    }

    @Test
    public void iconLabelButtonTest() {

        iconLabelButtons.get(1).click();
        iconLabelButtons.get(1).is().text("DELETE");
        iconLabelButtons.get(7).is().text("Last click: Delete");
        iconLabelIcons.get(1).is().displayed();

        iconLabelButtons.get(2).click();
        iconLabelButtons.get(2).is().text("SEND\nSEND");
        iconLabelButtons.get(7).is().text("Last click: Sendsend");
        iconLabelIcons.get(2).is().displayed();

        iconLabelButtons.get(3).click();
        iconLabelButtons.get(3).is().text("UPLOAD");
        iconLabelButtons.get(7).is().text("Last click: Upload");
        iconLabelIcons.get(3).is().displayed();

        iconLabelButtons.get(4).is().attr("disabled");
        iconLabelButtons.get(4).is().text("TALK");
        iconLabelIcons.get(4).is().displayed();

        iconLabelButtons.get(5).click();
        iconLabelButtons.get(5).is().text("SAVE");
        iconLabelButtons.get(7).is().text("Last click: Save");
        iconLabelIcons.get(5).is().displayed();

        iconLabelButtons.get(6).click();
        iconLabelButtons.get(6).is().text("SAVE ALL");
        iconLabelButtons.get(7).is().text("Last click: Save all");
        iconLabelIcons.get(6).is().displayed();
    }

    @Test
    public void iconButtonTest() {

        iconButtons.get(1).click();
        iconButtons.get(5).is().text("Last click: Delete enabled");
        iconButtonIcons.get(1).is().displayed();

        iconButtons.get(2).is().attr("disabled");
        iconButtons.get(2).is().disabled();
        iconButtonIcons.get(2).is().displayed();

        iconButtons.get(3).click();
        iconButtons.get(5).is().text("Last click: Alarm");
        iconButtonIcons.get(3).is().displayed();

        iconButtons.get(4).click();
        iconButtons.get(5).is().text("Last click: Shopping cart");
        iconButtonIcons.get(4).is().displayed();
    }

    @Test
    public void customizedButtonTest() {

        customizedButtons.get(1).click();
        customizedButtons.get(1).is().text("CUSTOM CSS");
        customizedButtons.get(4).is().text("Last click: Custom CSS");

        customizedButtons.get(2).click();
        customizedButtons.get(2).is().text("THEME PROVIDER");
        customizedButtons.get(4).is().text("Last click: Theme Provider");

        customizedButtons.get(3).click();
        customizedButtons.get(3).is().text("Bootstrap");
        customizedButtons.get(4).is().text("Last click: Bootstrap");
    }

    @Test
    public void complexButtonTest() {

        complexButtons.get(1).click();
        complexButtons.get(1).is().text("Breakfast");
        complexButtons.get(4).is().text("Last click: Breakfast");

        complexButtons.get(2).click();
        complexButtons.get(2).is().text("Burgers");
        complexButtons.get(4).is().text("Last click: Burgers");

        complexButtons.get(3).click();
        complexButtons.get(3).is().text("Camera");
        complexButtons.get(4).is().text("Last click: Camera");
    }
}
