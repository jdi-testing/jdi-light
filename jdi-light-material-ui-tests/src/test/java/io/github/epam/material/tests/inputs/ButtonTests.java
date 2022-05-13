package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.ComplexMUIButton;
import com.epam.jdi.light.material.elements.inputs.MUIButton;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.buttonPage;
import static io.github.com.pages.inputs.ButtonPage.complexButtonLastClick;
import static io.github.com.pages.inputs.ButtonPage.containedButtons;
import static io.github.com.pages.inputs.ButtonPage.customizedButtonLastClick;
import static io.github.com.pages.inputs.ButtonPage.iconButtonLastClick;
import static io.github.com.pages.inputs.ButtonPage.iconLabelButtonLastClick;
import static io.github.com.pages.inputs.ButtonPage.containedButtonLastClick;
import static io.github.com.pages.inputs.ButtonPage.textButtons;
import static io.github.com.pages.inputs.ButtonPage.iconLabelButtons;
import static io.github.com.pages.inputs.ButtonPage.iconButtons;
import static io.github.com.pages.inputs.ButtonPage.customizedButtons;
import static io.github.com.pages.inputs.ButtonPage.complexButtons;
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
        MUIButton enableContainedButton = containedButtons.get(1);
        enableContainedButton.label().is().text("DEFAULT");
        enableContainedButton.click();
        containedButtonLastClick.is().text("Last click: Default");
    }

    @Test
    public void disableContainedButtonTest() {
        MUIButton disableContainedButton = containedButtons.get(4);
        disableContainedButton.label().is().text("DISABLED");
        disableContainedButton.is().disabled();
        containedButtonLastClick.is().text("Last click:");
    }

    @Test
    public void enableTextButtonTest() {
        MUIButton enableTextButton = textButtons.get(1);
        enableTextButton.label().is().text("DEFAULT");
        enableTextButton.click();
        textButtonLastClick.is().text("Last click: Default");
    }

    @Test
    public void disableTextButtonTest() {
        MUIButton disableTextButton = textButtons.get(4);
        disableTextButton.label().is().text("DISABLED");
        disableTextButton.is().disabled();
        textButtonLastClick.is().text("Last click:");
    }

    @Test
    public void enableIconLabelButtonTest() {
        MUIButton enableIconLabelButton = iconLabelButtons.get(1);
        enableIconLabelButton.icon().is().displayed();
        enableIconLabelButton.label().is().text("DELETE");
        enableIconLabelButton.click();
        iconLabelButtonLastClick.is().text("Last click: Delete");
    }

    @Test
    public void disableIconLabelButtonTest() {
        MUIButton disableIconLabelButton = iconLabelButtons.get(4);
        disableIconLabelButton.icon().is().displayed();
        disableIconLabelButton.label().is().text("TALK");
        disableIconLabelButton.is().disabled();
        iconLabelButtonLastClick.is().text("Last click:");
    }

    @Test
    public void enableIconButtonTest() {
        MUIButton enableIconButton = iconButtons.get(1);
        enableIconButton.icon().is().displayed();
        enableIconButton.click();
        iconButtonLastClick.is().text("Last click: Delete enabled");
    }

    @Test
    public void disableIconButtonTest() {
        MUIButton disableIconButton = iconButtons.get(2);
        disableIconButton.icon().is().displayed();
        disableIconButton.is().disabled();
        iconButtonLastClick.is().text("Last click:");
    }

    @Test
    public void customizeButtonTest() {
        MUIButton customizedButton = customizedButtons.get(1);
        customizedButton.label().is().text("CUSTOM CSS");
        customizedButton.click();
        customizedButtonLastClick.is().text("Last click: Custom CSS");
    }

    @Test
    public void complexButtonTest() {
        ComplexMUIButton complexButton = complexButtons.get(1);
        complexButton.typography().is().text("Breakfast");
        complexButton.image().is().displayed();
        complexButton.click();
        complexButtonLastClick.is().text("Last click:Breakfast");
    }
}
