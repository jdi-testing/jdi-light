package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.BasicButtonsSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static com.epam.jdi.light.common.ElementArea.TOP_LEFT;

// TODO Move to the new page
@Ignore
public class BasicButtonTests extends TestsInit {

    private static final String BASIC_TEXT = "Basic";
    private static final String PRIMARY_TEXT = "Primary";
    private static final String ACCENT_TEXT = "Accent";
    private static final String WARN_TEXT = "Warn";
    private static final String DISABLED_TEXT = "Disabled";
    private static final String LINK_TEXT = "Link";
    private static final String FOCUSED_CLASS = "cdk-focused";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        basicBasicButton.show();
    }

    @Test
    public void basicTest() {
        basicBasicButton.is().displayed();
        basicPrimaryButton.is().displayed();
        basicAccentButton.is().displayed();
        basicWarnButton.is().displayed();
        basicDisabledButton.is().displayed();
        basicLinkButton.is().displayed();
    }

    @Test
    public void getTextTest() {
        basicBasicButton.is().text(BASIC_TEXT);
        basicPrimaryButton.is().text(PRIMARY_TEXT);
        basicAccentButton.is().text(ACCENT_TEXT);
        basicWarnButton.is().text(WARN_TEXT);
        basicDisabledButton.is().text(DISABLED_TEXT);
        basicLinkButton.is().text(LINK_TEXT);
    }

    @Test
    public void clickTest() {
        basicBasicButton.click();
        basicBasicButton.is().focused()
                        .has().buttonsLabelText(BASIC_TEXT);
    }

    @Test
    public void clickWithMoveTest() {
        basicWarnButton.click(TOP_LEFT);
        basicWarnButton.is().focused()
                       .has().buttonsLabelText(WARN_TEXT);
    }

    @Test
    public void disableButtonTest() {
        basicDisabledButton.is().disabled();
    }

    @Test
    public void colorTest() {
        basicAccentButton.is().color("rgba(255, 215, 64, 1)");
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
