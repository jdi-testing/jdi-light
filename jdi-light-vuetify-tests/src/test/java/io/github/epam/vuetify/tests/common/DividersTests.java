package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.asserts.DividerAssert;
import com.epam.jdi.light.vuetify.elements.common.Divider;
import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.dividersPage;
import static io.github.com.pages.DividersPage.horizontalDividers;
import static io.github.com.pages.DividersPage.verticalDividers;

public class DividersTests extends TestsInit {

    @BeforeClass
    public void before() {
        dividersPage.open();
        waitCondition(() -> dividersPage.isOpened());
        dividersPage.checkOpened();
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
        verticalDividers.stream().map(Divider::is).forEach(DividerAssert::vertical);
    }
}
