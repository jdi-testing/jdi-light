package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.boxPage;
import static io.github.com.pages.layout.BoxPage.*;

public class BoxTests extends TestsInit {

    @BeforeMethod
    public void before() {
        boxPage.open();
    }

    @Test
    public void containedBoxTest() {
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
    }
}
