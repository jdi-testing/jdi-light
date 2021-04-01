package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.inputs.ButtonFrame.*;

public class ButtonTests extends TestsInit {

    @Test
    public void defaultButtonTest() {
        openSection("Buttons");

        containedButton.getDefaultContainedButton().click();
        containedButton.getDefaultContainedButton().is().text("DEFAULT");
        checkContainedField.is().text("Last click: Default");

        containedButton.getPrimaryContainedButton().click();
        containedButton.getPrimaryContainedButton().is().text("PRIMARY");
        checkContainedField.is().text("Last click: Primary");

        containedButton.getSecondaryContainedButton().click();
        containedButton.getSecondaryContainedButton().is().text("SECONDARY");
        checkContainedField.is().text("Last click: Secondary");

        containedButton.getDisabledContainedButton().is().text("DISABLED");
        containedButton.getDisabledContainedButton().is().attr("disabled");
        containedButton.getDisabledContainedButton().is().disabled();

        containedButton.getLinkContainedButton().click();
        containedButton.getLinkContainedButton().is().text("LINK");
        checkContainedField.is().text("Last click: Link");
        containedButton.getLinkContainedButton().is().notVisible();
    }

    @Test
    public void textButtonTest() {
        openSection("Buttons");

        textButton.getDefaultTextButton().click();
        textButton.getDefaultTextButton().is().text("DEFAULT");
        checkTextField.is().text("Last click: Default");

        textButton.getPrimaryTextButton().click();
        textButton.getPrimaryTextButton().is().text("PRIMARY");
        checkTextField.is().text("Last click: Primary");

        textButton.getSecondaryTextButton().click();
        textButton.getSecondaryTextButton().is().text("SECONDARY");
        checkTextField.is().text("Last click: Secondary");

        textButton.getDisabledTextButton().is().text("DISABLED");
        textButton.getDisabledTextButton().is().attr("disabled");
        textButton.getDisabledTextButton().hasClass("Mui-disabled");

        textButton.getLinkTextButton().click();
        textButton.getLinkTextButton().is().text("LINK");
        checkTextField.is().text("Last click: Link");
        textButton.getLinkTextButton().is().notVisible();
    }

    @Test
    public void iconLabelButtonTest() {
        openSection("Buttons");

        iconLabelButton.getDeleteIconLabelButton().click();
        iconLabelButton.getDeleteIconLabelButton().is().text("DELETE");
        checkIconLabelField.is().text("Last click: Delete");
        iconLabelButton.getDeleteIconLabelIcon().is().hasSvg("MuiSvgIcon-root");

        iconLabelButton.getSendIconLabelButton().click();
        iconLabelButton.getSendIconLabelButton().is().text("SEND\nSEND");
        checkIconLabelField.is().text("Last click: Sendsend");
        iconLabelButton.getSendIconLabelIcon().is().displayedSpanIcon();

        iconLabelButton.getUploadIconLabelButton().click();
        iconLabelButton.getUploadIconLabelButton().is().text("UPLOAD");
        checkIconLabelField.is().text("Last click: Upload");
        iconLabelButton.getUploadIconLabelIcon().is().hasSvg("MuiSvgIcon-root");

        iconLabelButton.getTalkIconLabelButton().is().attr("disabled");
        iconLabelButton.getTalkIconLabelButton().is().text("TALK");
        iconLabelButton.getTalkIconLabelButton().hasClass("Mui-disabled");
        iconLabelButton.getTalkIconLabelIcon().is().hasSvg("MuiSvgIcon-root");

        iconLabelButton.getSaveIconLabelButton().click();
        iconLabelButton.getSaveIconLabelButton().is().text("SAVE");
        checkIconLabelField.is().text("Last click: Save");
        iconLabelButton.getSaveIconLabelIcon().is().hasSvg("MuiSvgIcon-root");

        iconLabelButton.getSaveAllIconLabelButton().click();
        iconLabelButton.getSaveAllIconLabelButton().is().text("SAVE ALL");
        checkIconLabelField.is().text("Last click: Save all");
        iconLabelButton.getSaveAllIconLabelIcon().is().hasSvg("MuiSvgIcon-root");
    }

    @Test
    public void iconButtonTest() {
        openSection("Buttons");

        iconButton.getDeleteEnabledButton().click();
        checkIconField.is().text("Last click: Delete enabled");
        iconButton.getDeleteEnabledIcon().is().hasSvg("MuiSvgIcon-root");

        iconButton.getDeleteDisabledButton().is().attr("disabled");
        iconButton.getDeleteEnabledButton().hasClass("Mui-disabled");
        iconButton.getDeleteDisabledIcon().is().hasSvg("MuiSvgIcon-root");

        iconButton.getAlarmButton().click();
        checkIconField.is().text("Last click: Alarm");
        iconButton.getAlarmIcon().is().hasSvg("MuiSvgIcon-root");

        iconButton.getShoppingCardButton().click();
        checkIconField.is().text("Last click: Shopping cart");
        iconButton.getShoppingCardIcon().is().hasSvg("MuiSvgIcon-root");
    }

    @Test
    public void customizedButtonTest() {
        openSection("Buttons");

        customizedButton.getCustomCSSButton().click();
        customizedButton.getCustomCSSButton().is().text("CUSTOM CSS");
        checkCustomizedField.is().text("Last click: Custom CSS");

        customizedButton.getThemeProviderButton().click();
        customizedButton.getThemeProviderButton().is().text("THEME PROVIDER");
        checkCustomizedField.is().text("Last click: Theme Provider");

        customizedButton.getBootstrapButton().click();
        customizedButton.getBootstrapButton().is().text("Bootstrap");
        checkCustomizedField.is().text("Last click: Bootstrap");

    }

    @Test
    public void complexButtonTest() {
        openSection("Buttons");

        complexButton.getBreakfastButton().click();
        complexButton.getBreakfastButton().is().text("Breakfast");
        checkComplexField.is().text("Last click: Breakfast");

        complexButton.getBurgersButton().click();
        complexButton.getBurgersButton().is().text("Burgers");
        checkComplexField.is().text("Last click: Burgers");

        complexButton.getCameraButton().click();
        complexButton.getCameraButton().is().text("Camera");
        checkComplexField.is().text("Last click: Camera");
    }
}
