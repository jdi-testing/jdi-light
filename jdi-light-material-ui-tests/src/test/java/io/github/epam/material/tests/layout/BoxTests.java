package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.boxPage;
import static io.github.com.pages.layout.BoxPage.containedBox;
import static io.github.com.pages.layout.BoxPage.disabledBox;
import static io.github.com.pages.layout.BoxPage.lastClickContent;
import static io.github.com.pages.layout.BoxPage.outlinedBox;

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
        containedBox.is().displayed();
        containedBox.click();
        containedBox.is().text("FIRST BUTTON");
        lastClickContent.is().text("You clicked First button");
    }

    @Test
    public void outlinedBoxTest() {
        outlinedBox.is().displayed();
        outlinedBox.click();
        outlinedBox.is().text("SECOND BUTTON");
        lastClickContent.is().text("You clicked Second button");
    }

    @Test
    public void disabledBoxTest() {
        disabledBox.is().displayed();
        disabledBox.is().text("THIRD BUTTON");
        disabledBox.is().disabled();
        disabledBox.core().click(0, 0);
        lastClickContent.is().text("You clicked Third button");

    }
}
