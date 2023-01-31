package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.asserts.DividerAssert;
import com.epam.jdi.light.vuetify.elements.common.Divider;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        horizontalDividers.stream()
                .map(Divider::is)
                .forEach(DividerAssert::horizontal);
    }

    @Test
    public void verticalDividersTest() {
        verticalDividers.stream()
                .map(Divider::is)
                .forEach(DividerAssert::vertical);
    }

    @Test
    public void themeDividersTest() {
        horizontalDividers.stream()
                .map(Divider::is)
                .forEach(divider -> divider.is().lightTheme());
    }

    @Test
    public void insetDividersTest() {
        horizontalDividers.stream()
                .map(Divider::is)
                .forEach(DividerAssert::inset);
        verticalDividers.stream()
                .map(Divider::is)
                .forEach(DividerAssert::notInset);
    }
}
