package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.StaticSite.buttonFrame;
import static io.github.com.StaticSite.inputButtonDefaultPage;
import static io.github.com.StaticSite.inputButtonDisabledPage;
import static io.github.com.pages.inputs.ButtonFrame.checkField;
import static io.github.com.pages.inputs.ButtonFrame.containedButton;

public class ButtonTests extends TestsInit {

    @Test
    public void defaultButtonTest() {
        openSection("Buttons");

        containedButton.getDefaultContainedButton().click();
        containedButton.getDefaultContainedButton().is().text("DEFAULT");
        checkField.is().text("Last click: Default");

        containedButton.getPrimaryContainedButton().click();
        containedButton.getPrimaryContainedButton().is().text("PRIMARY");
        checkField.is().text("Last click: Primary");

        containedButton.getSecondaryContainedButton().click();
        containedButton.getSecondaryContainedButton().is().text("SECONDARY");
        checkField.is().text("Last click: Secondary");

        containedButton.getDisabledContainedButton().is().text("DISABLED");
        containedButton.getDisabledContainedButton().is().attr("disabled");
        containedButton.getDisabledContainedButton().hasClass("Mui-disabled");

        containedButton.getLinkContainedButton().click();
        containedButton.getLinkContainedButton().is().text("LINK");
        checkField.is().text("Last click: Link");
        containedButton.getLinkContainedButton().is().notVisible();
    }

}
