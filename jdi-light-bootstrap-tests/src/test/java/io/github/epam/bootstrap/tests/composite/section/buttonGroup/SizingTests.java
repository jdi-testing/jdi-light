package io.github.epam.bootstrap.tests.composite.section.buttonGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Zaur Bibilov on 23.09.2019
 * Email: zaur_bibilov@epam.com;
 * Skype: dasilveria
 */

public class SizingTests extends TestsInit {

    // Button texts to check
    String leftBtnText = "Left";
    String midBtnText = "Middle";
    String rightBtnText = "Right";

    // Alert texts to check - single click
    String lgLeftBtnAlertText = "Lg Left Button Clicked!";
    String lgMidBtnAlertText = "Lg Middle Button Clicked!";
    String lgRightBtnAlertText = "Lg Right Button Clicked!";

    String smLeftBtnAlertText = "Sm Left Button Clicked!";
    String smMidBtnAlertText = "Sm Middle Button Clicked!";
    String smRightBtnAlertText = "Sm Right Button Clicked!";

    // Alert texts to check - double click
    String leftBtnDoubleClickText = "Left Button Double Clicked!";
    String midBtnDoubleClickText = "Middle Button Double Clicked!";
    String rightBtnDoubleClickText = "Right Button Double Clicked!";

    // Alert texts to check - right click
    String lgLeftBtnRightClickText = "Lg Left Button Right Clicked!";
    String lgMidBtnRightClickText = "Lg Middle Button Right Clicked!";
    String lgRightBtnRightClickText = "Lg Right Button Right Clicked!";

    String leftBtnRightClickText = "Left Button Right Clicked!";
    String midBtnRightClickText = "Middle Button Right Clicked!";
    String rightBtnRightClickText = "Right Button Right Clicked!";

    String smLeftBtnRightClickText = "Sm Left Button Right Clicked!";
    String smMidBtnRightClickText = "Sm Middle Button Right Clicked!";
    String smRightBtnRightClickText = "Sm Right Button Right Clicked!";



    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void getTextTest() {
        largeBtnGroup.highlight();
        assertEquals(largeBtnGroup.leftBtn.getText(), leftBtnText);
        assertEquals(largeBtnGroup.midBtn.getText(), midBtnText);
        assertEquals(largeBtnGroup.rightBtn.getText(), rightBtnText);

        defaultBtnGroup.highlight();
        assertEquals(defaultBtnGroup.leftBtn.getText(), leftBtnText);
        assertEquals(defaultBtnGroup.midBtn.getText(), midBtnText);
        assertEquals(defaultBtnGroup.rightBtn.getText(), rightBtnText);

        smallBtnGroup.highlight();
        assertEquals(smallBtnGroup.leftBtn.getText(), leftBtnText);
        assertEquals(smallBtnGroup.midBtn.getText(), midBtnText);
        assertEquals(smallBtnGroup.rightBtn.getText(), rightBtnText);
    }

    @Test
    public void getValueTest() {
        largeBtnGroup.highlight();
        assertEquals(largeBtnGroup.leftBtn.getValue(), leftBtnText);
        assertEquals(largeBtnGroup.midBtn.getValue(), midBtnText);
        assertEquals(largeBtnGroup.rightBtn.getValue(), rightBtnText);

        defaultBtnGroup.highlight();
        assertEquals(defaultBtnGroup.leftBtn.getValue(), leftBtnText);
        assertEquals(defaultBtnGroup.midBtn.getValue(), midBtnText);
        assertEquals(defaultBtnGroup.rightBtn.getValue(), rightBtnText);

        smallBtnGroup.highlight();
        assertEquals(smallBtnGroup.leftBtn.getValue(), leftBtnText);
        assertEquals(smallBtnGroup.midBtn.getValue(), midBtnText);
        assertEquals(smallBtnGroup.rightBtn.getValue(), rightBtnText);
    }

    @Test
    public void clickTest() {
        largeBtnGroup.highlight();
        largeBtnGroup.leftBtn.click();
        validateAlert(is(lgLeftBtnAlertText));
        largeBtnGroup.midBtn.click();
        validateAlert(is(lgMidBtnAlertText));
        largeBtnGroup.rightBtn.click();
        validateAlert(is(lgRightBtnAlertText));

        smallBtnGroup.highlight();
        smallBtnGroup.leftBtn.click();
        validateAlert(is(smLeftBtnAlertText));
        smallBtnGroup.midBtn.click();
        validateAlert(is(smMidBtnAlertText));
        smallBtnGroup.rightBtn.click();
        validateAlert(is(smRightBtnAlertText));
    }

    @Test
    public void doubleClickTest() {
        defaultBtnGroup.highlight();
        defaultBtnGroup.leftBtn.doubleClick();
        validateAlert(is(leftBtnDoubleClickText));
        defaultBtnGroup.midBtn.doubleClick();
        validateAlert(is(midBtnDoubleClickText));
        defaultBtnGroup.rightBtn.doubleClick();
        validateAlert(is(rightBtnDoubleClickText));
    }

    @Test
    public void rightClickTest() {
        largeBtnGroup.highlight();
        largeBtnGroup.leftBtn.rightClick();
        validateAlert(is(lgLeftBtnRightClickText));
        largeBtnGroup.midBtn.rightClick();
        validateAlert(is(lgMidBtnRightClickText));
        largeBtnGroup.rightBtn.rightClick();
        validateAlert(is(lgRightBtnRightClickText));

        defaultBtnGroup.highlight();
        defaultBtnGroup.leftBtn.rightClick();
        validateAlert(is(leftBtnRightClickText));
        defaultBtnGroup.midBtn.rightClick();
        validateAlert(is(midBtnRightClickText));
        defaultBtnGroup.rightBtn.rightClick();
        validateAlert(is(rightBtnRightClickText));

        smallBtnGroup.highlight();
        smallBtnGroup.leftBtn.rightClick();
        validateAlert(is(smLeftBtnRightClickText));
        smallBtnGroup.midBtn.rightClick();
        validateAlert(is(smMidBtnRightClickText));
        smallBtnGroup.rightBtn.rightClick();
        validateAlert(is(smRightBtnRightClickText));
    }

    @Test
    public void isValidationTest() {
        largeBtnGroup.highlight();
        largeBtnGroup.is().displayed();
        largeBtnGroup.is().enabled();
        largeBtnGroup.leftBtn.is().text(is(leftBtnText));
        largeBtnGroup.leftBtn.is().text(containsString("Le"));
        assertThat(largeBtnGroup.leftBtn.core().css("font-size"), is("20px"));
        largeBtnGroup.leftBtn.assertThat().displayed()
                .and().text(is(leftBtnText))
                .core()
                .css("font-size", is("20px"))
                .cssClass("btn btn-secondary")
                .attr("type", "button")
                .tag(is("button"));
    }

    @Test
    public void assertValidationTest() {
        defaultBtnGroup.midBtn.assertThat().text(is(midBtnText));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(smallBtnGroup.rightBtn);
    }

}
