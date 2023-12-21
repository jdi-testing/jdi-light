package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.dividerPage;
import static io.github.com.pages.DividerPage.defaultDividers;
import static io.github.com.pages.DividerPage.insetDivider;
import static io.github.com.pages.DividerPage.textWithBasicDivider;
import static io.github.com.pages.DividerPage.verticalDivider;
import static org.hamcrest.Matchers.equalTo;

public class DividerTests extends TestsInit {

    @BeforeClass(alwaysRun = true)
    public void before() {
        dividerPage.open();
        waitCondition(() -> dividerPage.isOpened());
        dividerPage.checkOpened();
        textWithBasicDivider.show();
    }

    @Test(description = "Test checks that default divider has horizontal property")
    public void defaultDividersTest() {
        defaultDividers.waitFor().displayed();
        defaultDividers.has().size(equalTo(2));
        defaultDividers.get(1).is().horizontal();
        defaultDividers.get(2).is().horizontal();
    }

    @Test(description = "Test checks that inset divider has inset property")
    public void insetDividersTest() {
        insetDivider.has().size(equalTo(2));
        insetDivider.get(1).has().inset();
        insetDivider.get(2).has().inset();
    }

    @Test(description = "Test checks that vertical divider has vertical property")
    public void verticalDividerTest() {
        verticalDivider.has().size(equalTo(2));
        verticalDivider.get(1).is().vertical();
        verticalDivider.get(2).is().vertical();
    }
}
