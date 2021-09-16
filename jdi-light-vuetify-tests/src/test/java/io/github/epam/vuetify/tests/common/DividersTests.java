package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Divider;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.dividersPage;
import static io.github.com.pages.DividersPage.horizontalDividers;
import static io.github.com.pages.DividersPage.verticalDividers;

public class DividersTests extends TestsInit {

    @BeforeSuite
    public void before() {
        dividersPage.open();
    }

    @Test
    public void horizontalDividersTest() {
        horizontalDividers.stream().map(Divider::is).forEach(e -> {
            e.horizontal();
            e.lightTheme();
                });
    }

    @Test
    public void verticalDividersTest() {
        verticalDividers.stream().map(Divider::is).forEach(e -> {
                    e.vertical();
                    e.darkTheme();
                });
    }
}
