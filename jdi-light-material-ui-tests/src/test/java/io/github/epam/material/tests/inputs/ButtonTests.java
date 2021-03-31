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
}
