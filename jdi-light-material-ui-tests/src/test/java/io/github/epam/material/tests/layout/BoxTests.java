package io.github.epam.material.tests.layout;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.layout.BoxPage.containedBox;
import static io.github.com.pages.layout.BoxPage.disabledBox;
import static io.github.com.pages.layout.BoxPage.lastClickContent;
import static io.github.com.pages.layout.BoxPage.outlinedBox;
import static org.hamcrest.Matchers.hasToString;

public class BoxTests extends TestsInit {

    @BeforeTest
    public void before() {
        openSection("Box");
    }

    @Test
    public void containedBoxTest() {
        Timer timer = new Timer(1000L);
        timer.wait(() -> containedBox.isDisplayed());
        containedBox.click();
        containedBox.is().text("FIRST BUTTON");
        lastClickContent.is().text(hasToString("You clicked First button"));
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
