package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.dividerPage;
import static io.github.com.pages.DividerPage.defaultDividersSeparators;
import static io.github.com.pages.DividerPage.insetDividerSeparators;
import static io.github.com.pages.DividerPage.textWithDefaultDividers;
import static io.github.com.pages.DividerPage.verticalDividerSeparators;
import static org.hamcrest.Matchers.equalTo;

public class DividerTests extends TestsInit {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        dividerPage.open();
        waitCondition(() -> dividerPage.isOpened());
        dividerPage.checkOpened();
        textWithDefaultDividers.show();
    }

    @Test(description = "Test checks that default divider separators have horizontal property")
    public void defaultDividersSeparatorsTest() {
        defaultDividersSeparators.has().size(equalTo(2));
        defaultDividersSeparators.get(1).is().horizontal();
        defaultDividersSeparators.get(2).is().horizontal();
    }

    @Test(description = "Test checks that inset divider separators have inset property")
    public void insetDividersSeparatorsTest() {
        insetDividerSeparators.has().size(equalTo(2));
        insetDividerSeparators.get(1).has().inset();
        insetDividerSeparators.get(2).has().inset();
    }

    @Test(description = "Test checks that vertical divider separators have vertical property")
    public void verticalDividerSeparatorsTest() {
        verticalDividerSeparators.has().size(equalTo(2));
        verticalDividerSeparators.get(1).is().vertical();
        verticalDividerSeparators.get(2).is().vertical();
    }
}