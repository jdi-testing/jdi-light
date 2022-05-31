package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import io.github.epam.test.data.HiddenDataProvider;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.hiddenPage;
import static io.github.com.pages.layout.HiddenPage.currentWidth;
import static io.github.com.pages.layout.HiddenPage.papers;

/**
 * @see <a href="https://v4.mui.com/components/hidden/">Hidden MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class HiddenTests extends TestsInit {

    @BeforeMethod
    public void before() {
        hiddenPage.open();
        hiddenPage.checkOpened();
    }

    @Test(dataProviderClass = HiddenDataProvider.class, dataProvider = "Screen Width")
    public void hiddenTestWithScreenWidthDifferentScreenWidth(int width, int size, String expectedWidth) {
        setWidth(width);
        papers.has().size(size);
        if (size > 0) {
            papers.is().displayed();
        } else {
            papers.is().hidden();
        }
        currentWidth.has().text("Current width: " + expectedWidth);
    }

    private void setWidth(int width) {
        Dimension currentScreenSize = hiddenPage.driver().manage().window().getSize();
        Dimension newScreenSize = new Dimension(width, currentScreenSize.getHeight());
        hiddenPage.driver().manage().window().setSize(newScreenSize);
    }

    @AfterMethod
    public void after() {
        hiddenPage.driver().manage().window().setSize(new Dimension(1920, 1080));
    }
}
