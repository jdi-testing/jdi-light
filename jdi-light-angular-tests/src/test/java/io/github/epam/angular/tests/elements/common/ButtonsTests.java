package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsColors.ACCENT;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsColors.PRIMARY;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsColors.WARN;

import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTexts.ACCENT_TEXT;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTexts.BASIC_TEXT;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTexts.DISABLED_TEXT;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTexts.HEART_LABEL_TEXT;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTexts.LINK_TEXT;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTexts.PRIMARY_TEXT;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTexts.WARN_TEXT;

import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.BASIC;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.EXTENDED_FAB;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.FAB;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.FLAT;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.ICON;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.MINI_FAB;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.RAISED;
import static com.epam.jdi.light.angular.elements.enums.buttons.ButtonsTypes.STROKED;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.buttonsPage;

import static io.github.com.pages.ButtonsPage.basicBasicButton;
import static io.github.com.pages.ButtonsPage.defaultColorButton;
import static io.github.com.pages.ButtonsPage.extendedFabAccentButton;
import static io.github.com.pages.ButtonsPage.raisedPrimaryButton;
import static io.github.com.pages.ButtonsPage.flatWarnButton;
import static io.github.com.pages.ButtonsPage.fabLinkButton;
import static io.github.com.pages.ButtonsPage.basicDisabledButton;
import static io.github.com.pages.ButtonsPage.iconPrimaryButton;
import static io.github.com.pages.ButtonsPage.miniFabHeartButton;
import static io.github.com.pages.ButtonsPage.strokedAccentButton;

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

        basicBasicButton.has().text(BASIC_TEXT.getText())
                        .and().visualTypeOfButton(BASIC);
        basicBasicButton.click();
        basicBasicButton.is().focused()
                        .and().has().buttonLabelText(BASIC, BASIC_TEXT.getText());

        basicDisabledButton.has().text(DISABLED_TEXT.getText())
                           .and().is().disabled();
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

        extendedFabAccentButton.has().color(ACCENT)
                               .and().text(ACCENT_TEXT.getText())
                               .and().visualTypeOfButton(EXTENDED_FAB);
        extendedFabAccentButton.click();
        extendedFabAccentButton.is().focused()
                               .and().has().buttonLabelText(EXTENDED_FAB, ACCENT_TEXT.getText());
    }

    @Test(description = "Test checks fab buttons attributes")
    public void fabButtonsTest() {
        fabLinkButton.shouldBe().displayed();
        fabLinkButton.show();
        fabLinkButton.shouldBe().visible();

        fabLinkButton.has().text(LINK_TEXT.getText())
                     .and().visualTypeOfButton(FAB);
        fabLinkButton.click();
        fabLinkButton.is().focused()
                     .and().has().buttonLabelText(FAB, LINK_TEXT.getText());
    }

    @Test(description = "Test checks flat buttons attributes")
    public void flatButtonsTest() {
        flatWarnButton.shouldBe().displayed();
        flatWarnButton.show();
        flatWarnButton.shouldBe().visible();

        flatWarnButton.has().color(WARN)
                      .and().text(WARN_TEXT.getText())
                      .and().visualTypeOfButton(FLAT);
        flatWarnButton.click();
        flatWarnButton.is().focused()
                      .and().has().buttonLabelText(FLAT, WARN_TEXT.getText());
    }

    @Test(description = "Test checks icon buttons attributes")
    public void iconButtonsTest() {
        iconPrimaryButton.shouldBe().displayed();
        iconPrimaryButton.show();
        iconPrimaryButton.shouldBe().visible();

        iconPrimaryButton.has().color(PRIMARY)
                         .and().visualTypeOfButton(ICON);
        iconPrimaryButton.click();
        iconPrimaryButton.is().focused()
                         .and().has().buttonLabelText(ICON, PRIMARY_TEXT.getText());
    }

    @Test(description = "Test checks mini fab buttons attributes")
    public void miniFabButtonsTest() {
        miniFabHeartButton.shouldBe().displayed();
        miniFabHeartButton.show();
        miniFabHeartButton.shouldBe().visible();

        miniFabHeartButton.has().visualTypeOfButton(MINI_FAB);
        miniFabHeartButton.click();
        miniFabHeartButton.is().focused()
                          .and().has().buttonLabelText(MINI_FAB, HEART_LABEL_TEXT.getText());
    }

    @Test(description = "Test checks raised buttons attributes")
    public void raisedButtonsTest() {
        raisedPrimaryButton.shouldBe().displayed();
        raisedPrimaryButton.show();
        raisedPrimaryButton.shouldBe().visible();

        raisedPrimaryButton.has().color(PRIMARY)
                           .and().text(PRIMARY_TEXT.getText())
                           .and().visualTypeOfButton(RAISED);
        raisedPrimaryButton.click();
        raisedPrimaryButton.is().focused()
                           .and().has().buttonLabelText(RAISED, PRIMARY_TEXT.getText());
    }

    @Test(description = "Test checks stroked buttons attributes")
    public void strokedButtonsTest() {
        strokedAccentButton.shouldBe().displayed();
        strokedAccentButton.show();
        strokedAccentButton.shouldBe().visible();

        strokedAccentButton.has().color(ACCENT)
                           .and().text(ACCENT_TEXT.getText())
                           .and().visualTypeOfButton(STROKED);
        strokedAccentButton.click();
        strokedAccentButton.is().focused()
                           .and().has().buttonLabelText(STROKED, ACCENT_TEXT.getText());
    }
}
