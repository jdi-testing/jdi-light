package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.inputs.ButtonPage.*;

public class ButtonTests extends TestsInit {

    @Test
    public void defaultButtonTest() {
        openSection("Buttons");

        button.getContainedButtonByIndex(1).click();
        button.getContainedButtonByIndex(1).is().text("DEFAULT");
        button.getContainedButtonByIndex(1).is().hasClass("MuiButton-contained");
        checkContainedField.is().text("Last click: Default");

        button.getContainedButtonByIndex(2).click();
        button.getContainedButtonByIndex(2).is().hasClass("MuiButton-contained");
        button.getContainedButtonByIndex(2).is().text("PRIMARY");
        button.getContainedButtonByIndex(2).is().hasClass("MuiButton-containedPrimary");
        checkContainedField.is().text("Last click: Primary");

        button.getContainedButtonByIndex(3).click();
        button.getContainedButtonByIndex(3).is().hasClass("MuiButton-contained");
        button.getContainedButtonByIndex(3).is().text("SECONDARY");
        button.getContainedButtonByIndex(3).is().hasClass("MuiButton-containedSecondary");
        checkContainedField.is().text("Last click: Secondary");

        button.getContainedButtonByIndex(4).is().text("DISABLED");
        button.getContainedButtonByIndex(4).is().hasClass("MuiButton-contained");
        button.getContainedButtonByIndex(4).is().hasClass("Mui-disabled");
        button.getContainedButtonByIndex(4).is().attr("disabled");
        button.getContainedButtonByIndex(4).is().disabled();

        button.getContainedButtonByIndex(5).click();
        button.getContainedButtonByIndex(5).is().hasClass("MuiButton-contained");
        button.getContainedButtonByIndex(5).is().text("LINK");
        button.getContainedButtonByIndex(5).is().hasClass("MuiButton-containedPrimary");
        checkContainedField.is().text("Last click: Link");
        button.getContainedButtonByIndex(5).is().notVisible();
    }

    @Test
    public void textButtonTest() {
        openSection("Buttons");

        button.getTextButtonByIndex(1).click();
        button.getTextButtonByIndex(1).is().hasClass("MuiButton-text");
        button.getTextButtonByIndex(1).is().text("DEFAULT");
        checkTextField.is().text("Last click: Default");

        button.getTextButtonByIndex(2).click();
        button.getTextButtonByIndex(2).is().hasClass("MuiButton-text");
        button.getTextButtonByIndex(2).is().text("PRIMARY");
        button.getTextButtonByIndex(2).is().hasClass("MuiButton-textPrimary");
        checkTextField.is().text("Last click: Primary");

        button.getTextButtonByIndex(3).click();
        button.getTextButtonByIndex(3).is().hasClass("MuiButton-text");
        button.getTextButtonByIndex(3).is().text("SECONDARY");
        button.getTextButtonByIndex(3).is().hasClass("MuiButton-textSecondary");
        checkTextField.is().text("Last click: Secondary");

        button.getTextButtonByIndex(4).is().text("DISABLED");
        button.getTextButtonByIndex(4).is().hasClass("MuiButton-text");
        button.getTextButtonByIndex(4).is().attr("disabled");
        button.getTextButtonByIndex(4).is().hasClass("Mui-disabled");
        button.getTextButtonByIndex(4).hasClass("Mui-disabled");

        button.getTextButtonByIndex(5).click();
        button.getTextButtonByIndex(5).is().hasClass("MuiButton-text");
        button.getTextButtonByIndex(5).is().text("LINK");
        button.getTextButtonByIndex(5).is().hasClass("MuiButton-textPrimary");
        checkTextField.is().text("Last click: Link");
        button.getTextButtonByIndex(5).is().notVisible();
    }

    @Test
    public void iconLabelButtonTest() {
        openSection("Buttons");

        button.getIconLabelButtonByIndex(1).click();
        button.getIconLabelButtonByIndex(1).is().text("DELETE");
        button.getIconLabelButtonByIndex(1).is().hasClass("MuiButton-containedSecondary");
        checkIconLabelField.is().text("Last click: Delete");
        button.getIconLabelIconByIndex(1).is().hasSvg("MuiSvgIcon-root");

        button.getIconLabelButtonByIndex(2).click();
        button.getIconLabelButtonByIndex(2).is().text("SEND\nSEND");
        button.getIconLabelButtonByIndex(2).is().hasClass("MuiButton-containedPrimary");
        checkIconLabelField.is().text("Last click: Sendsend");
        button.getIconLabelSpanIcon().is().displayedSpanIcon();

        button.getIconLabelButtonByIndex(3).click();
        button.getIconLabelButtonByIndex(3).is().text("UPLOAD");
        checkIconLabelField.is().text("Last click: Upload");
        button.getIconLabelIconByIndex(2).is().hasSvg("MuiSvgIcon-root");

        button.getIconLabelButtonByIndex(4).is().attr("disabled");
        button.getIconLabelButtonByIndex(4).is().text("TALK");
        button.getIconLabelButtonByIndex(4).is().hasClass("Mui-disabled");
        button.getIconLabelButtonByIndex(4).hasClass("Mui-disabled");
        button.getIconLabelIconByIndex(3).is().hasSvg("MuiSvgIcon-root");

        button.getIconLabelButtonByIndex(5).click();
        button.getIconLabelButtonByIndex(5).is().text("SAVE");
        button.getIconLabelButtonByIndex(5).is().hasClass("MuiButton-sizeSmall");
        checkIconLabelField.is().text("Last click: Save");
        button.getIconLabelIconByIndex(4).is().hasSvg("MuiSvgIcon-root");

        button.getIconLabelButtonByIndex(6).click();
        button.getIconLabelButtonByIndex(6).is().text("SAVE ALL");
        button.getIconLabelButtonByIndex(6).is().hasClass("MuiButton-sizeLarge");
        checkIconLabelField.is().text("Last click: Save all");
        button.getIconLabelIconByIndex(5).is().hasSvg("MuiSvgIcon-root");
    }

    @Test
    public void iconButtonTest() {
        openSection("Buttons");

        button.getIconButtonByIndex(1).click();
        checkIconField.is().text("Last click: Delete enabled");
        button.getIconButtonByIndex(1).is().hasSvg("MuiSvgIcon-root");

        button.getIconButtonByIndex(2).is().attr("disabled");
        button.getIconButtonByIndex(2).is().hasClass("Mui-disabled");
        button.getIconButtonByIndex(2).is().hasSvg("MuiSvgIcon-root");

        button.getIconButtonByIndex(3).click();
        button.getIconButtonByIndex(3).is().hasClass("MuiIconButton-colorSecondary");
        checkIconField.is().text("Last click: Alarm");
        button.getIconButtonByIndex(3).is().hasSvg("MuiSvgIcon-root");

        button.getIconButtonByIndex(4).click();
        button.getIconButtonByIndex(4).is().hasClass("MuiIconButton-colorPrimary");
        checkIconField.is().text("Last click: Shopping cart");
        button.getIconButtonByIndex(4).is().hasSvg("MuiSvgIcon-root");
    }

    @Test
    public void customizedButtonTest() {
        openSection("Buttons");

        button.getCustomizedButtonByIndex(1).click();
        button.getCustomizedButtonByIndex(1).is().hasClass("MuiButton-containedPrimary");
        button.getCustomizedButtonByIndex(1).is().text("CUSTOM CSS");
        checkCustomizedField.is().text("Last click: Custom CSS");

        button.getCustomizedButtonByIndex(2).click();
        button.getCustomizedButtonByIndex(2).is().hasClass("MuiButton-containedPrimary");
        button.getCustomizedButtonByIndex(2).is().text("THEME PROVIDER");
        checkCustomizedField.is().text("Last click: Theme Provider");

        button.getCustomizedButtonByIndex(3).click();
        button.getCustomizedButtonByIndex(3).is().hasClass("MuiButton-containedPrimary");
        button.getCustomizedButtonByIndex(3).is().text("Bootstrap");
        checkCustomizedField.is().text("Last click: Bootstrap");

    }

    @Test
    public void complexButtonTest() {
        openSection("Buttons");

        button.getComplexButtonByIndex(1).click();
        button.getComplexButtonByIndex(1).is().text("Breakfast");
        checkComplexField.is().text("Last click: Breakfast");

        button.getComplexButtonByIndex(2).click();
        button.getComplexButtonByIndex(2).is().text("Burgers");
        checkComplexField.is().text("Last click: Burgers");

        button.getComplexButtonByIndex(3).click();
        button.getComplexButtonByIndex(3).is().text("Camera");
        checkComplexField.is().text("Last click: Camera");
    }
}
