package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.buttonPage;
import static io.github.com.pages.inputs.ButtonPage.breakfastComplexButton;
import static io.github.com.pages.inputs.ButtonPage.complexButtonLastClick;
import static io.github.com.pages.inputs.ButtonPage.customCssCustomizedButton;
import static io.github.com.pages.inputs.ButtonPage.customizedButtonLastClick;
import static io.github.com.pages.inputs.ButtonPage.defaultContainedButton;
import static io.github.com.pages.inputs.ButtonPage.defaultTextButton;
import static io.github.com.pages.inputs.ButtonPage.deleteIconButton;
import static io.github.com.pages.inputs.ButtonPage.deleteIconLabelButton;
import static io.github.com.pages.inputs.ButtonPage.disabledContainedButton;
import static io.github.com.pages.inputs.ButtonPage.disabledIconButton;
import static io.github.com.pages.inputs.ButtonPage.disabledTextButton;
import static io.github.com.pages.inputs.ButtonPage.iconButtonLastClick;
import static io.github.com.pages.inputs.ButtonPage.iconLabelButtonLastClick;
import static io.github.com.pages.inputs.ButtonPage.containedButtonLastClick;
import static io.github.com.pages.inputs.ButtonPage.talkIconLabelButton;
import static io.github.com.pages.inputs.ButtonPage.textButtonLastClick;

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
    public void enableContainedButtonTest() {
        defaultContainedButton.label().is().text("DEFAULT");
        defaultContainedButton.click();
        containedButtonLastClick.is().text("Last click: Default");
    }

    @Test
    public void disableContainedButtonTest() {
        disabledContainedButton.label().is().text("DISABLED");
        disabledContainedButton.is().disabled();
        containedButtonLastClick.is().text("Last click:");
    }

    @Test
    public void enableTextButtonTest() {
        defaultTextButton.label().is().text("DEFAULT");
        defaultTextButton.click();
        textButtonLastClick.is().text("Last click: Default");
    }

    @Test
    public void disableTextButtonTest() {
        disabledTextButton.label().is().text("DISABLED");
        disabledTextButton.is().disabled();
        textButtonLastClick.is().text("Last click:");
    }

    @Test
    public void enableIconLabelButtonTest() {
        deleteIconLabelButton.icon().is().displayed();
        deleteIconLabelButton.label().is().text("DELETE");
        deleteIconLabelButton.click();
        iconLabelButtonLastClick.is().text("Last click: Delete");
    }

    @Test
    public void disableIconLabelButtonTest() {
        talkIconLabelButton.icon().is().displayed();
        talkIconLabelButton.label().is().text("TALK");
        talkIconLabelButton.is().disabled();
        iconLabelButtonLastClick.is().text("Last click:");
    }

    @Test
    public void enableIconButtonTest() {
        deleteIconButton.icon().is().displayed();
        deleteIconButton.click();
        iconButtonLastClick.is().text("Last click: Delete enabled");
    }

    @Test
    public void disableIconButtonTest() {
        disabledIconButton.icon().is().displayed();
        disabledIconButton.is().disabled();
        iconButtonLastClick.is().text("Last click:");
    }

    @Test
    public void customizeButtonTest() {
        customCssCustomizedButton.label().is().text("CUSTOM CSS");
        customCssCustomizedButton.click();
        customizedButtonLastClick.is().text("Last click: Custom CSS");
    }

    @Test
    public void complexButtonTest() {
        breakfastComplexButton.typography().is().text("Breakfast");
        breakfastComplexButton.image().is().displayed();
        breakfastComplexButton.click();
        complexButtonLastClick.is().text("Last click:Breakfast");
    }
}
