package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsColors.ACCENT;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsColors.PRIMARY;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsColors.WARN;
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

    @Test(description = "Test checks basic buttons attributes")
    public void basicButtonsTest() {
        basicBasicButton.shouldBe().displayed();
        basicBasicButton.show();
        basicBasicButton.shouldBe().visible();
        basicBasicButton.has().text(BASIC_TEXT.getText());
        basicBasicButton.click();
        basicBasicButton.is().focused()
                        .has().buttonLabelText(BASIC, BASIC_TEXT.getText());

        basicDisabledButton.has().text(DISABLED_TEXT.getText());
    }

    @Test(description = "Test checks default color of button")
    public void defaultColorButtonTest() {
        defaultColorButton.shouldBe().displayed();
        defaultColorButton.show();
        defaultColorButton.shouldBe().visible();
        defaultColorButton.has().defaultColor();
    }

    @Test(description = "Test checks extended fab buttons attributes")
    public void extendedFabButtonsTest() {
        extendedFabAccentButton.shouldBe().displayed();
        extendedFabAccentButton.show();
        extendedFabAccentButton.shouldBe().visible();
        extendedFabAccentButton.has().color(ACCENT.getColor())
                               .and().text(ACCENT_TEXT.getText());
        extendedFabAccentButton.click();
        extendedFabAccentButton.is().focused()
                               .has().buttonLabelText(EXTENDED_FAB, ACCENT_TEXT.getText());
    }

    @Test(description = "Test checks fab buttons attributes")
    public void fabButtonsTest() {
        fabLinkButton.shouldBe().displayed();
        fabLinkButton.show();
        fabLinkButton.shouldBe().visible();
        fabLinkButton.has().text(LINK_TEXT.getText());
        fabLinkButton.click();
        fabLinkButton.is().focused()
                     .has().buttonLabelText(FAB, LINK_TEXT.getText());
    }

    @Test(description = "Test checks flat buttons attributes")
    public void flatButtonsTest() {
        flatWarnButton.shouldBe().displayed();
        flatWarnButton.show();
        flatWarnButton.shouldBe().visible();
        flatWarnButton.has().color(WARN.getColor())
                      .and().text(WARN_TEXT.getText());
        flatWarnButton.click();
        flatWarnButton.is().focused()
                      .has().buttonLabelText(FLAT, WARN_TEXT.getText());
    }

    @Test(description = "Test checks icon buttons attributes")
    public void iconButtonsTest() {
        iconPrimaryButton.shouldBe().displayed();
        iconPrimaryButton.show();
        iconPrimaryButton.shouldBe().visible();
        iconPrimaryButton.has().color(PRIMARY.getColor());
        iconPrimaryButton.click();
        iconPrimaryButton.is().focused()
                         .has().buttonLabelText(ICON, PRIMARY_TEXT.getText());
    }

    @Test(description = "Test checks mini fab buttons attributes")
    public void miniFabButtonsTest() {
        miniFabHeartButton.shouldBe().displayed();
        miniFabHeartButton.show();
        miniFabHeartButton.shouldBe().visible();
        miniFabHeartButton.click();
        miniFabHeartButton.is().focused()
                          .has().buttonLabelText(MINI_FAB, HEART_LABEL_TEXT.getText());
    }

    @Test(description = "Test checks raised buttons attributes")
    public void raisedButtonsTest() {
        raisedPrimaryButton.shouldBe().displayed();
        raisedPrimaryButton.show();
        raisedPrimaryButton.shouldBe().visible();
        raisedPrimaryButton.has().color(PRIMARY.getColor())
                           .and().text(PRIMARY_TEXT.getText());
        raisedPrimaryButton.click();
        raisedPrimaryButton.is().focused()
                           .has().buttonLabelText(RAISED, PRIMARY_TEXT.getText());
    }

    @Test(description = "Test checks stroked buttons attributes")
    public void strokedButtonsTest() {
        strokedAccentButton.shouldBe().displayed();
        strokedAccentButton.show();
        strokedAccentButton.shouldBe().visible();
        strokedAccentButton.has().color(ACCENT.getColor())
                           .and().text(ACCENT_TEXT.getText());
        strokedAccentButton.click();
        strokedAccentButton.is().focused()
                           .has().buttonLabelText(STROKED, ACCENT_TEXT.getText());
    }
}
