package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsColors.*;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTexts.*;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.*;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.buttonsPage;
import static io.github.com.pages.ButtonsPage.*;

public class ButtonsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        buttonsPage.open();
        waitCondition(() -> buttonsPage.isOpened());
        buttonsPage.checkOpened();
    }

    @Test(description = "Test checks buttons color")
    public void buttonsColorTest() {
        raisedPrimaryButton.has().color(PRIMARY);
        strokedAccentButton.has().color(ACCENT);
        flatWarnButton.has().color(WARN);
    }

    @Test(description = "Test checks buttons text")
    public void buttonsTextTest() {
        basicBasicButton.has().text(BASIC_TEXT.getText());
        basicDisabledButton.has().text(DISABLED_TEXT.getText());
        raisedPrimaryButton.has().text(PRIMARY_TEXT.getText());
        strokedAccentButton.has().text(ACCENT_TEXT.getText());
        flatWarnButton.has().text(WARN_TEXT.getText());
        fabLinkButton.has().text(LINK_TEXT.getText());
    }

    @Test(description = "Test checks clicks on buttons")
    public void clickOnButtonsTest() {
        basicBasicButton.click();
        basicBasicButton.is().focused()
                        .has().buttonLabelText(BASIC, BASIC_TEXT.getText());

        raisedPrimaryButton.click();
        raisedPrimaryButton.is().focused()
                           .has().buttonLabelText(RAISED, PRIMARY_TEXT.getText());

        strokedAccentButton.click();
        strokedAccentButton.is().focused()
                           .has().buttonLabelText(STROKED, ACCENT_TEXT.getText());

        flatWarnButton.click();
        flatWarnButton.is().focused()
                      .has().buttonLabelText(FLAT, WARN_TEXT.getText());

        fabLinkButton.click();
        fabLinkButton.is().focused()
                     .has().buttonLabelText(FAB, LINK_TEXT.getText());

        miniFabHeartButton.click();
        miniFabHeartButton.is().focused()
                          .has().buttonLabelText(MINI_FAB, HEART_LABEL_TEXT.getText());
    }
}
