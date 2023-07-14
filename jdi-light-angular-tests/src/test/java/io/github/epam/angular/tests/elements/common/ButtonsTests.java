package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.ButtonsColors.ACCENT;
import static com.epam.jdi.light.angular.elements.enums.ButtonsColors.PRIMARY;
import static com.epam.jdi.light.angular.elements.enums.ButtonsColors.WARN;
import static com.epam.jdi.light.angular.elements.enums.ButtonsTexts.ACCENT_TEXT;
import static com.epam.jdi.light.angular.elements.enums.ButtonsTexts.BASIC_TEXT;
import static com.epam.jdi.light.angular.elements.enums.ButtonsTexts.DISABLED_TEXT;
import static com.epam.jdi.light.angular.elements.enums.ButtonsTexts.LINK_TEXT;
import static com.epam.jdi.light.angular.elements.enums.ButtonsTexts.PRIMARY_TEXT;
import static com.epam.jdi.light.angular.elements.enums.ButtonsTexts.WARN_TEXT;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.buttonsPage;
import static io.github.com.pages.ButtonsPage.*;
import static com.epam.jdi.light.common.ElementArea.TOP_LEFT;

public class ButtonsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        buttonsPage.open();
        waitCondition(() -> buttonsPage.isOpened());
        buttonsPage.checkOpened();
    }

    @Test
    public void getTextTest() {
        basicBasicButton.has().text(BASIC_TEXT.getText());
        basicDisabledButton.has().text(DISABLED_TEXT.getText());
        raisedPrimaryButton.has().text(PRIMARY_TEXT.getText());
        strokedAccentButton.has().text(ACCENT_TEXT.getText());
        flatWarnButton.has().text(WARN_TEXT.getText());
        fabLinkButton.has().text(LINK_TEXT.getText());
    }

    @Test
    public void clickTest() {
        basicBasicButton.click();
        basicBasicButton.is().focused()
                        .has().buttonLabelText(BASIC_TEXT.getText());
    }

    @Test
    public void clickWithMoveTest() {
        flatWarnButton.click(TOP_LEFT);
        flatWarnButton.is().focused()
                      .has().buttonLabelText(WARN_TEXT.getText());
    }

    @Test
    public void disableButtonTest() {
        basicDisabledButton.is().disabled();
    }

    @Test
    public void colorTest() {
        raisedPrimaryButton.has().color(PRIMARY);
        strokedAccentButton.has().color(ACCENT);
        flatWarnButton.has().color(WARN);
    }
    //    @Test
    //    public void isValidationTest() {
    //        basicWarnButton.is().displayed();
    //        basicWarnButton.is().enabled();
    //        basicWarnButton.is().text(is(WARN_TEXT));
    //        basicWarnButton.is().text(containsString(WARN_TEXT));
    //        assertThat(basicWarnButton.core().css("font-size"), is("14px"));
    //        basicWarnButton.assertThat().displayed()
    //                .and().text(is(WARN_TEXT))
    //                .core()
    //                .css("font-size", is("14px"))
    //                .and()
    //                .cssClass("mat-button")
    //                .and()
    //                .attr("type")
    //                .tag(is("button"));
    //        basicDisabledButton.is().text(containsString(DISABLED_TEXT));
    //        basicDisabledButton.is().disabled();
    //    }
}
