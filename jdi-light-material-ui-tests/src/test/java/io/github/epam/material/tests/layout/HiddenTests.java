package io.github.epam.material.tests.layout;

import com.epam.jdi.light.settings.Timeouts;
import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.hiddenPage;
import static io.github.com.pages.layout.HiddenPage.currentWidth;
import static io.github.com.pages.layout.HiddenPage.papers;

/**
 * To see an example of Hidden web element please visit
 * https://material-ui.com/components/hidden/
 */
public class HiddenTests extends TestsInit {

    @BeforeMethod
    public void before() {
        hiddenPage.open();
        hiddenPage.checkOpened();
    }

    @DataProvider(name = "Screen Width")
    public Object[][] screenWidthDividers() {
        return new Object[][]{
                {599, 0, "xs"},
                {600, 1, "sm"},
                {959, 1, "sm"},
                {960, 2, "md"},
                {1279, 2, "md"},
                {1280, 3, "lg"},
                {1919, 3, "lg"},
                {1920, 4, "xl"}};
    }

    @Test(dataProvider = "Screen Width")
    public void hiddenTestWithScreenWidthDifferentScreenWidth(int width, int size, String expectedWidth) {
        setWidth(width);
        new Timer(currentWidth.core().getTimeout()).wait(() -> papers.size() == size);
        jdiAssert(papers.size(), Matchers.equalTo(size));
        papers.forEach(element -> element.is().displayed());
        currentWidth.has().text("Current width: " + expectedWidth);
    }

    private void setWidth(int width) {
        Dimension currentScreenSize = hiddenPage.driver().manage().window().getSize();
        Dimension newScreenSize = new Dimension(width, currentScreenSize.getHeight());
        hiddenPage.driver().manage().window().setSize(newScreenSize);
    }

    @AfterMethod
    public void after() {
        hiddenPage.driver().manage().window().setSize(new Dimension(1024, 762));
    }
}
