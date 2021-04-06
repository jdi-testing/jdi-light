package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.inputs.ButtonPage.*;

public class ButtonTests extends TestsInit {

    @Test
    public void defaultButtonTest() {
        openSection("Buttons");

        button.getButtonByGroupIndex("contained",1).click();
        button.getButtonByGroupIndex("contained",1).is().text("DEFAULT");
        button.getButtonByGroupIndex("contained",1).is().hasClass("MuiButton-contained");
        checkContainedField.is().text("Last click: Default");

        button.getButtonByGroupIndex("contained",2).click();
        button.getButtonByGroupIndex("contained",2).is().hasClass("MuiButton-contained");
        button.getButtonByGroupIndex("contained",2).is().text("PRIMARY");
        button.getButtonByGroupIndex("contained",2).is().hasClass("MuiButton-containedPrimary");
        checkContainedField.is().text("Last click: Primary");

        button.getButtonByGroupIndex("contained",3).click();
        button.getButtonByGroupIndex("contained",3).is().hasClass("MuiButton-contained");
        button.getButtonByGroupIndex("contained",3).is().text("SECONDARY");
        button.getButtonByGroupIndex("contained",3).is().hasClass("MuiButton-containedSecondary");
        checkContainedField.is().text("Last click: Secondary");

        button.getButtonByGroupIndex("contained",4).is().text("DISABLED");
        button.getButtonByGroupIndex("contained",4).is().hasClass("MuiButton-contained");
        button.getButtonByGroupIndex("contained",4).is().hasClass("Mui-disabled");
        button.getButtonByGroupIndex("contained",4).is().attr("disabled");
        button.getButtonByGroupIndex("contained",4).is().disabled();

        button.getButtonByGroupIndex("contained",5).click();
        button.getButtonByGroupIndex("contained",5).is().hasClass("MuiButton-contained");
        button.getButtonByGroupIndex("contained",5).is().text("LINK");
        button.getButtonByGroupIndex("contained",5).is().hasClass("MuiButton-containedPrimary");
        checkContainedField.is().text("Last click: Link");
        button.getButtonByGroupIndex("contained",5).is().notVisible();
    }

    @Test
    public void textButtonTest() {
        openSection("Buttons");

        button.getButtonByGroupIndex("text",1).click();
        button.getButtonByGroupIndex("text",1).is().hasClass("MuiButton-text");
        button.getButtonByGroupIndex("text",1).is().text("DEFAULT");
        checkTextField.is().text("Last click: Default");

        button.getButtonByGroupIndex("text",2).click();
        button.getButtonByGroupIndex("text",2).is().hasClass("MuiButton-text");
        button.getButtonByGroupIndex("text",2).is().text("PRIMARY");
        button.getButtonByGroupIndex("text",2).is().hasClass("MuiButton-textPrimary");
        checkTextField.is().text("Last click: Primary");

        button.getButtonByGroupIndex("text",3).click();
        button.getButtonByGroupIndex("text",3).is().hasClass("MuiButton-text");
        button.getButtonByGroupIndex("text",3).is().text("SECONDARY");
        button.getButtonByGroupIndex("text",3).is().hasClass("MuiButton-textSecondary");
        checkTextField.is().text("Last click: Secondary");

        button.getButtonByGroupIndex("text",4).is().text("DISABLED");
        button.getButtonByGroupIndex("text",4).is().hasClass("MuiButton-text");
        button.getButtonByGroupIndex("text",4).is().attr("disabled");
        button.getButtonByGroupIndex("text",4).is().hasClass("Mui-disabled");

        button.getButtonByGroupIndex("text",5).click();
        button.getButtonByGroupIndex("text",5).is().hasClass("MuiButton-text");
        button.getButtonByGroupIndex("text",5).is().text("LINK");
        button.getButtonByGroupIndex("text",5).is().hasClass("MuiButton-textPrimary");
        checkTextField.is().text("Last click: Link");
        button.getButtonByGroupIndex("text",5).is().notVisible();
    }

    @Test
    public void iconLabelButtonTest() {
        openSection("Buttons");

        button.getButtonByGroupIndex("iconLabelButton",1).click();
        button.getButtonByGroupIndex("iconLabelButton",1).is().text("DELETE");
        button.getButtonByGroupIndex("iconLabelButton",1).is().hasClass("MuiButton-containedSecondary");
        checkIconLabelField.is().text("Last click: Delete");
        button.getButtonByGroupIndex("iconLabelIcon",1).is().hasSvg("MuiSvgIcon-root");

        button.getButtonByGroupIndex("iconLabelButton",2).click();
        button.getButtonByGroupIndex("iconLabelButton",2).is().text("SEND\nSEND");
        button.getButtonByGroupIndex("iconLabelButton",2).is().hasClass("MuiButton-containedPrimary");
        checkIconLabelField.is().text("Last click: Sendsend");
        button.getButtonByGroupIndex("iconLabelSpanIcon",2).is().displayedSpanIcon();

        button.getButtonByGroupIndex("iconLabelButton",3).click();
        button.getButtonByGroupIndex("iconLabelButton",3).is().text("UPLOAD");
        checkIconLabelField.is().text("Last click: Upload");
        button.getButtonByGroupIndex("iconLabelIcon",2).is().hasSvg("MuiSvgIcon-root");

        button.getButtonByGroupIndex("iconLabelButton",4).is().attr("disabled");
        button.getButtonByGroupIndex("iconLabelButton",4).is().text("TALK");
        button.getButtonByGroupIndex("iconLabelButton",4).is().hasClass("Mui-disabled");
        button.getButtonByGroupIndex("iconLabelIcon",3).is().hasSvg("MuiSvgIcon-root");

        button.getButtonByGroupIndex("iconLabelButton",5).click();
        button.getButtonByGroupIndex("iconLabelButton",5).is().text("SAVE");
        button.getButtonByGroupIndex("iconLabelButton",5).is().hasClass("MuiButton-sizeSmall");
        checkIconLabelField.is().text("Last click: Save");
        button.getButtonByGroupIndex("iconLabelIcon",4).is().hasSvg("MuiSvgIcon-root");

        button.getButtonByGroupIndex("iconLabelButton",6).click();
        button.getButtonByGroupIndex("iconLabelButton",6).is().text("SAVE ALL");
        button.getButtonByGroupIndex("iconLabelButton",6).is().hasClass("MuiButton-sizeLarge");
        checkIconLabelField.is().text("Last click: Save all");
        button.getButtonByGroupIndex("iconLabelIcon",5).is().hasSvg("MuiSvgIcon-root");
    }

    @Test
    public void iconButtonTest() {
        openSection("Buttons");

        button.getButtonByGroupIndex("iconButton",1).click();
        checkIconField.is().text("Last click: Delete enabled");
        button.getButtonByGroupIndex("iconButton",1).is().hasSvg("MuiSvgIcon-root");

        button.getButtonByGroupIndex("iconButton",2).is().attr("disabled");
        button.getButtonByGroupIndex("iconButton",2).is().hasClass("Mui-disabled");
        button.getButtonByGroupIndex("iconButton",2).is().hasSvg("MuiSvgIcon-root");

        button.getButtonByGroupIndex("iconButton",3).click();
        button.getButtonByGroupIndex("iconButton",3).is().hasClass("MuiIconButton-colorSecondary");
        checkIconField.is().text("Last click: Alarm");
        button.getButtonByGroupIndex("iconButton",3).is().hasSvg("MuiSvgIcon-root");

        button.getButtonByGroupIndex("iconButton",4).click();
        button.getButtonByGroupIndex("iconButton",4).is().hasClass("MuiIconButton-colorPrimary");
        checkIconField.is().text("Last click: Shopping cart");
        button.getButtonByGroupIndex("iconButton",4).is().hasSvg("MuiSvgIcon-root");
    }

    @Test
    public void customizedButtonTest() {
        openSection("Buttons");

        button.getButtonByGroupIndex("customizedButton",1).click();
        button.getButtonByGroupIndex("customizedButton",1).is().hasClass("MuiButton-containedPrimary");
        button.getButtonByGroupIndex("customizedButton",1).is().text("CUSTOM CSS");
        checkCustomizedField.is().text("Last click: Custom CSS");

        button.getButtonByGroupIndex("customizedButton",2).click();
        button.getButtonByGroupIndex("customizedButton",2).is().hasClass("MuiButton-containedPrimary");
        button.getButtonByGroupIndex("customizedButton",2).is().text("THEME PROVIDER");
        checkCustomizedField.is().text("Last click: Theme Provider");

        button.getButtonByGroupIndex("customizedButton",3).click();
        button.getButtonByGroupIndex("customizedButton",3).is().hasClass("MuiButton-containedPrimary");
        button.getButtonByGroupIndex("customizedButton",3).is().text("Bootstrap");
        checkCustomizedField.is().text("Last click: Bootstrap");

    }

    @Test
    public void complexButtonTest() {
        openSection("Buttons");

        button.getButtonByGroupIndex("complexButton",1).click();
        button.getButtonByGroupIndex("complexButton",1).is().text("Breakfast");
        checkComplexField.is().text("Last click: Breakfast");

        button.getButtonByGroupIndex("complexButton",2).click();
        button.getButtonByGroupIndex("complexButton",2).is().text("Burgers");
        checkComplexField.is().text("Last click: Burgers");

        button.getButtonByGroupIndex("complexButton",3).click();
        button.getButtonByGroupIndex("complexButton",3).is().text("Camera");
        checkComplexField.is().text("Last click: Camera");
    }
}
