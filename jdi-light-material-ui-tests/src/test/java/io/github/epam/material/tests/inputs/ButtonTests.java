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

public class ButtonTests extends TestsInit {

    @BeforeMethod
    public void before() {
        buttonPage.open();
        buttonPage.isOpened();
    }

    @Test
    public void enableContainedButtonTest() {
        defaultContainedButton.label().has().text("DEFAULT");
        defaultContainedButton.click();
        containedButtonLastClick.has().text("Last click: Default");
    }

    @Test
    public void disableContainedButtonTest() {
        disabledContainedButton.label().has().text("DISABLED");
        disabledContainedButton.is().disabled();
        containedButtonLastClick.has().text("Last click:");
    }

    @Test
    public void enableTextButtonTest() {
        defaultTextButton.label().has().text("DEFAULT");
        defaultTextButton.click();
        textButtonLastClick.has().text("Last click: Default");
    }

    @Test
    public void disableTextButtonTest() {
        disabledTextButton.label().has().text("DISABLED");
        disabledTextButton.is().disabled();
        textButtonLastClick.has().text("Last click:");
    }

    @Test
    public void enableIconLabelButtonTest() {
        deleteIconLabelButton.icon().is().displayed();
        deleteIconLabelButton.label().has().text("DELETE");
        deleteIconLabelButton.click();
        iconLabelButtonLastClick.has().text("Last click: Delete");
    }

    @Test
    public void disableIconLabelButtonTest() {
        talkIconLabelButton.icon().is().displayed();
        talkIconLabelButton.label().has().text("TALK");
        talkIconLabelButton.is().disabled();
        iconLabelButtonLastClick.has().text("Last click:");
    }

    @Test
    public void enableIconButtonTest() {
        deleteIconButton.icon().is().displayed();
        deleteIconButton.click();
        iconButtonLastClick.has().text("Last click: Delete enabled");
    }

    @Test
    public void disableIconButtonTest() {
        disabledIconButton.icon().is().displayed();
        disabledIconButton.is().disabled();
        iconButtonLastClick.has().text("Last click:");
    }

    @Test
    public void customizeButtonTest() {
        customCssCustomizedButton.label().has().text("CUSTOM CSS");
        customCssCustomizedButton.click();
        customizedButtonLastClick.has().text("Last click: Custom CSS");
    }

    @Test
    public void complexButtonTest() {
        breakfastComplexButton.typography().has().text("Breakfast");
        breakfastComplexButton.image().is().displayed();
        breakfastComplexButton.click();
        complexButtonLastClick.has().text("Last click:Breakfast");
    }
}
