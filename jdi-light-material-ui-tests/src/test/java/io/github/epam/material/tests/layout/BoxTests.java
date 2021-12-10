package io.github.epam.material.tests.layout;

import static io.github.com.StaticSite.boxPage;
import static io.github.com.pages.layout.BoxPage.buttonContainedBox;
import static io.github.com.pages.layout.BoxPage.buttonDisabledBox;
import static io.github.com.pages.layout.BoxPage.buttonOutlinedBox;
import static io.github.com.pages.layout.BoxPage.lastClickContent;

import io.github.epam.TestsInit;
import io.github.epam.enums.Colors;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * To see an example of Box web element please visit
 * https://material-ui.com/components/box/
 */

public class BoxTests extends TestsInit {

    @BeforeMethod
    public void before() {
        boxPage.open();
        boxPage.isOpened();
    }

    @Test
    public void containedBoxTest() {
        buttonContainedBox.is().displayed()
                .and().has().text("FIRST BUTTON")
                .and().cssClass("MuiButton-containedPrimary")
                .and().has().css("background-color", Colors.PRIMARY.rgba());

        buttonContainedBox.click();
        lastClickContent.has().text("You clicked First button");
    }

    @Test
    public void outlinedBoxTest() {
        String[] exp = Colors.SECONDARY.rgba().split(",");
        exp[3] = " 0.5)";
        String expectedBorderColor = String.join(",", exp);

        buttonOutlinedBox.is().displayed()
                .and().has().text("SECOND BUTTON")
                .and().cssClass("MuiButton-outlinedSecondary")
                .and().css("color", Colors.SECONDARY.rgba())
                .and().css("border-style", "solid")
                .and().css("border-color", expectedBorderColor);

        buttonOutlinedBox.click();
        lastClickContent.has().text("You clicked Second button");
    }

    @Test
    public void disabledBoxTest() {
        buttonDisabledBox.is().displayed()
                .and().has().text("THIRD BUTTON")
                .and().cssClass("Mui-disabled")
                .and().is().disabled();

        buttonDisabledBox.core().click(0, 0);
        lastClickContent.is().text("You clicked Third button");
    }
}
