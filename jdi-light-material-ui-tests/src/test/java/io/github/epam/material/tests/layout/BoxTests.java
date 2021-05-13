package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.boxPage;
import static io.github.com.pages.layout.BoxPage.containedBox;
import static io.github.com.pages.layout.BoxPage.disabledBox;
import static io.github.com.pages.layout.BoxPage.lastClickContent;
import static io.github.com.pages.layout.BoxPage.outlinedBox;

public class BoxTests extends TestsInit {

    @BeforeTest
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
