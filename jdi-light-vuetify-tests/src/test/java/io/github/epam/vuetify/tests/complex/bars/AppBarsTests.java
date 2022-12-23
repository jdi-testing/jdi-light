package io.github.epam.vuetify.tests.complex.bars;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.appBarsPage;
import static io.github.com.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.enums.Colors.WHITE;
import static io.github.com.pages.AppBarsPage.collapsibleBar;
import static io.github.com.pages.AppBarsPage.denseBar;
import static io.github.com.pages.AppBarsPage.elevateOnScrollBar;
import static io.github.com.pages.AppBarsPage.elevatedBar;
import static io.github.com.pages.AppBarsPage.fadeImageOnScrollBar;
import static io.github.com.pages.AppBarsPage.flatBar;
import static io.github.com.pages.AppBarsPage.hidingScrollBar;
import static io.github.com.pages.AppBarsPage.imageBar;
import static io.github.com.pages.AppBarsPage.outlinedBar;
import static io.github.com.pages.AppBarsPage.roundedBar;
import static io.github.com.pages.AppBarsPage.scrollThresholdBar;
import static io.github.com.pages.AppBarsPage.shapedBar;
import static io.github.com.pages.AppBarsPage.toggleNavigationDrawersBar;


public class AppBarsTests extends TestsInit {

    @BeforeClass
    public void before() {
        appBarsPage.open();
        waitCondition(() -> appBarsPage.isOpened());
        appBarsPage.checkOpened();
    }

    @Test(description = "Test checks bar's text")
    public void textBarTests() {
        collapsibleBar.show();
        collapsibleBar.is().displayed();
        collapsibleBar.has().text("Collapsing Bar");
    }

    @Test(description = "Test checks if bar is collapsible : collapse (y/n), collapse-on-scroll (y/n)")
    public void collapsibleBarTests() {
        collapsibleBar.show();
        collapsibleBar.is().collapsible();
        collapsibleBar.scrollBarToBottom();
        waitCondition(() -> collapsibleBar.isCollapsed());
        collapsibleBar.is().collapsed();
        collapsibleBar.scrollBarToTop();
        waitCondition(() -> collapsibleBar.isExpanded());
        collapsibleBar.is().expanded();
        fadeImageOnScrollBar.show();
        fadeImageOnScrollBar.is().notCollapsible();
    }

    @Test(description = "Test checks if app bar has image fading on scroll or not")
    public void fadeImageOnScrollBarTest() {
        fadeImageOnScrollBar.show();
        fadeImageOnScrollBar.is().displayed();
        fadeImageOnScrollBar.has().imageFadingOnScroll();
        fadeImageOnScrollBar.scrollBarToBottom();
        fadeImageOnScrollBar.image().has().attr("style", "opacity: 0;");
        fadeImageOnScrollBar.scrollBarToTop();
        fadeImageOnScrollBar.image().has().attr("style", "opacity: 1;");
        fadeImageOnScrollBar.tabs().select(2);
        fadeImageOnScrollBar.tabs().has().selected(2);
        imageBar.show();
        imageBar.isDisplayed();
        imageBar.has().noImageFadingOnScroll();
    }

    @Test(description = "Test checks that app bar is hiding on scroll : hide-on-scroll (y/n)")
    public void hidingScrollBarTests() {
        hidingScrollBar.show();
        hidingScrollBar.is().displayed();
        hidingScrollBar.scrollBarToBottom();
        waitCondition(() -> hidingScrollBar.isHidden());
    }

    @Test(description = "Test checks if app bar is prominent or not : prominent (y/n)")
    public void prominentScrollBarTests() {
        hidingScrollBar.show();
        hidingScrollBar.is().displayed();
        hidingScrollBar.is().prominent();
        toggleNavigationDrawersBar.show();
        toggleNavigationDrawersBar.isDisplayed();
        toggleNavigationDrawersBar.is().notProminent();
    }

    @Test(description = "Test checks if app bar is elevate on scroll or not : elevate-on-scroll (y/n)")
    public void elevateOnScrollAppBarTests() {
        elevateOnScrollBar.show();
        elevateOnScrollBar.is().displayed();
        elevateOnScrollBar.is().elevateOnScroll();
        imageBar.show();
        imageBar.isDisplayed();
        imageBar.is().notElevateOnScroll();
    }

    @Test(description = "Test checks if element is scrolled or not")
    public void scrolledAppBarTests() {
        toggleNavigationDrawersBar.show();
        toggleNavigationDrawersBar.is().scrolled();
        imageBar.show();
        imageBar.is().notScrolled();
    }

    @Test(description = "Test checks element's color : color")
    public void colorAppBarTests() {
        denseBar.show();
        denseBar.has().backgroundColor(DEEP_PURPLE_ACCENT_4.value());
        denseBar.has().color(WHITE.value());
    }

    @Test(description = "Test checks if element is dense or not : dense(y/n)")
    public void denseAppBarTests() {
        denseBar.show();
        denseBar.is().dense();
        outlinedBar.show();
        outlinedBar.is().notDense();
    }

    @Test(description = "Test checks if element is outlined or not : outlined (y/n)")
    public void outlinedAppBarTests() {
        outlinedBar.show();
        outlinedBar.is().outlined();
        denseBar.show();
        denseBar.is().notOutlined();
    }

    @Test(description = "Test checks if element is flat or not : flat (y/n)")
    public void flatAppBarTests() {
        flatBar.show();
        flatBar.is().flat();
        denseBar.show();
        denseBar.is().notFlat();
    }

    @Test(description = "Test checks if element is rounded or not : rounded (y/n)")
    public void roundedAppBarTests() {
        roundedBar.show();
        roundedBar.is().rounded();
        denseBar.show();
        denseBar.is().notRounded();
    }

    @Test(description = "Test checks if element is shaped or not : shaped (y/n)")
    public void shapedAppBarTests() {
        shapedBar.show();
        shapedBar.is().shaped();
        denseBar.show();
        denseBar.is().notShaped();
    }

    @Test(description = "Test checks if element has background image or not :  src (link)")
    public void backgroundImageAppBarTests() {
        imageBar.show();
        imageBar.has().backgroundImage();
        imageBar.backgroundImage().has().sourcePath(
                "https://jdi-testing.github.io/jdi-light/vuetify/pictures/car_in_forest_1080.jpeg");
        denseBar.show();
        denseBar.is().noBackgroundImage();
    }

    @Test(description = "Test checks if element shrinks on scroll or not")
    public void shrinkOnScrollAppBarTests() {
        scrollThresholdBar.show();
        scrollThresholdBar.is().shrinkOnScroll();
        denseBar.show();
        denseBar.is().notShrinkOnScroll();
    }

    @Test(description = "Test checks if element is elevated or not : elevated (y/n)")
    public void elevatedAppBarTests() {
        elevatedBar.show();
        elevatedBar.is().elevated();
        elevatedBar.has().elevation(10);
        denseBar.show();
        denseBar.is().notShrinkOnScroll();
    }
}
