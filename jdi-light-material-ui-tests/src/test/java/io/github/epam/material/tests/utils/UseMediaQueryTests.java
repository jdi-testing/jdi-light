package io.github.epam.material.tests.utils;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.useMediaQueryPage;
import static io.github.com.pages.utils.UseMediaQueryPage.useMediaQueryText;
import static org.hamcrest.Matchers.containsString;

public class UseMediaQueryTests extends TestsInit {

    @BeforeMethod
    public void before() {
        useMediaQueryPage.open();
        useMediaQueryPage.shouldBeOpened();
    }

    @Test
    public void useMediaQueryTestWithDifferentScreenWidth() {
        Dimension dimension = useMediaQueryPage.driver().manage().window().getSize();
        jdiAssert(dimension.height, Matchers.equalTo(601));
        new Timer(2000L)
                .wait(() -> useMediaQueryText.has().value(containsString("true")));
        useMediaQueryPage.driver().manage().window().setSize(new Dimension(500, 1000));
        useMediaQueryText.has().value(containsString("false"));
        useMediaQueryPage.driver().manage().window().setSize(new Dimension(700, 1000));
        useMediaQueryText.has().value(containsString("true"));
    }

    @AfterMethod
    public void after() {
        useMediaQueryPage.driver().manage().window().setSize(new Dimension(1024, 762));
    }
}
