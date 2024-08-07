package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.breadcrumbsPage;
import static io.github.com.enums.MdiIcons.CHEVRON_RIGHT;
import static io.github.com.enums.MdiIcons.FORWARD;
import static io.github.com.pages.BreadcrumbsPage.darkThemeRippleBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.dashedBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.dottedBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.forwardSlashedBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.greaterSignBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.itemSlotsBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.largeBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.mdiChevronRightBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.mdiForwardBreadcrumbs;
import static io.github.com.pages.BreadcrumbsPage.semicolonBreadcrumbs;

public class BreadcrumbsTests extends TestsInit {
    @BeforeClass
    public void before() {
        breadcrumbsPage.open();
        waitCondition(() -> breadcrumbsPage.isOpened());
        breadcrumbsPage.checkOpened();
    }

    @Test(description = "Test checks that breadcrumbs are displayed")
    public void displayedBreadcrumbsTest() {
        dashedBreadcrumbs.show();
        dashedBreadcrumbs.is().displayed();
    }

    @Test(description = "Test checks breadcrumbs, items and dividers size")
    public void itemsSizeBreadcrumbsTest() {
        dashedBreadcrumbs.show();
        dashedBreadcrumbs.has().size(3);
        dashedBreadcrumbs.list().has().size(3);
        dashedBreadcrumbs.dividers().has().size(2);
    }

    @Test(description = "Test checks dividers types")
    public void dividersTypeTest() {
        dashedBreadcrumbs.show();
        dashedBreadcrumbs.has().dividerType("-");
        forwardSlashedBreadcrumbs.show();
        forwardSlashedBreadcrumbs.has().dividerType("/");
        dottedBreadcrumbs.show();
        dottedBreadcrumbs.has().dividerType(".");
        semicolonBreadcrumbs.show();
        semicolonBreadcrumbs.has().dividerType(";");
        greaterSignBreadcrumbs.show();
        greaterSignBreadcrumbs.has().dividerType(">");
    }

    @Test(description = "Test checks if breadcrumbs are large or not")
    public void largeBreadcrumbsTest() {
        largeBreadcrumbs.show();
        largeBreadcrumbs.is().large();
        mdiForwardBreadcrumbs.show();
        mdiForwardBreadcrumbs.is().notLarge();
    }

    @Test(description = "Test checks breadcrumbs icon dividers")
    public void iconBreadcrumbsTest() {
        mdiForwardBreadcrumbs.show();
        mdiForwardBreadcrumbs.has().iconDivider(FORWARD.mdi());
        mdiChevronRightBreadcrumbs.show();
        mdiChevronRightBreadcrumbs.has().iconDivider(CHEVRON_RIGHT.mdi());
    }

    @Test(description = "Test checks breadcrumbs item text")
    public void itemTextBreadcrumbsTest() {
        itemSlotsBreadcrumbs.show();
        itemSlotsBreadcrumbs.items().get(0).has().text("DASHBOARD");
        itemSlotsBreadcrumbs.items().get(1).has().text("LINK 1");
        itemSlotsBreadcrumbs.items().get(2).has().text("LINK 2");
        itemSlotsBreadcrumbs.list().has().values("DASHBOARD", "LINK 1", "LINK 2");
    }

    @Test(description = "Test checks breadcrumbs theme")
    public void themeBreadcrumbsTest() {
        itemSlotsBreadcrumbs.show();
        itemSlotsBreadcrumbs.has().lightTheme();
        darkThemeRippleBreadcrumbs.show();
        darkThemeRippleBreadcrumbs.has().darkTheme();
    }

    @Test(description = "Test checks if breadcrumbs item is disabled or not")
    public void disabledBreadcrumbsTest() {
        itemSlotsBreadcrumbs.show();
        itemSlotsBreadcrumbs.items().get(2).is().disabled();
        itemSlotsBreadcrumbs.items().get(0).is().enabled();
    }
}
