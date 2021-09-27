package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Divider;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
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
        boolean result = new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                horizontalDividers.size() != 0);
        if (result) {
            horizontalDividers.stream().map(Divider::is).forEach(e -> {
                e.horizontal();
                e.lightTheme();
            });
        }
    }

    @Test
    public void verticalDividersTest() {
        boolean result = new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                verticalDividers.size() != 0);
        if (result) {
            verticalDividers.stream().map(Divider::is).forEach(e -> {
                e.vertical();
                e.darkTheme();
            });
        }
    }
}
