package io.github.epam.vuetify.tests.complex.bars;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;
import com.epam.jdi.light.elements.common.UIElement;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.appBarsPage;
import static io.github.com.pages.AppBarsPage.collapsibleBar;
import static io.github.com.pages.AppBarsPage.collapsibleBarOverflow;
import static io.github.com.pages.AppBarsPage.fadeImageOnScrollBar;
import static io.github.com.pages.AppBarsPage.fadeImageOnScrollOverflow;
import static io.github.com.pages.AppBarsPage.hidingScrollBar;
import static io.github.com.pages.AppBarsPage.hidingScrollBarOverflow;
import static io.github.com.pages.AppBarsPage.navigationDrawer;
import static io.github.com.pages.AppBarsPage.toggleNavigationDrawersBar;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppBarsTests extends TestsInit {

    @BeforeClass
    public void before() {
        appBarsPage.open();
        waitCondition(() -> appBarsPage.isOpened());
        appBarsPage.checkOpened();
    }

    @Test(enabled = false)
    public void collapsibleBarTests() {
        collapsibleBar.show();
        collapsibleBar.is().displayed();
        collapsibleBar.has().text("Collapsing Bar");
        scrollToBottom(collapsibleBarOverflow);
        waitCondition(() -> collapsibleBar.isCollapsed());
        scrollBarToTop(collapsibleBarOverflow);
        waitCondition(() -> collapsibleBar.isExpanded());
    }

    @Test
    public void fadeImageOnScrollBarTest() {
        fadeImageOnScrollBar.is().displayed();
        fadeImageOnScrollBar.has().text("Title");
        fadeImageOnScrollBar.menuButton().is().displayed();
        fadeImageOnScrollBar.searchButton().is().displayed();
        fadeImageOnScrollBar.heartButton().is().displayed();
        fadeImageOnScrollBar.verticalDotsButton().is().displayed();
        fadeImageOnScrollBar.image().is().displayed();
        scrollToBottom(fadeImageOnScrollOverflow);
        fadeImageOnScrollBar.image().has().attr("style", "opacity: 0;");
        scrollBarToTop(fadeImageOnScrollOverflow);
        fadeImageOnScrollBar.image().has().attr("style", "opacity: 1;");
        fadeImageOnScrollBar.tabs().select(2);
        fadeImageOnScrollBar.tabs().has().selected(2);
    }

    @Test
    public void hidingScrollBarTests() {
        hidingScrollBar.is().displayed();
        hidingScrollBar.has().text("Title");
        scrollToBottom(hidingScrollBarOverflow);
        waitCondition(() -> hidingScrollBar.isHidden());
    }

    @Test
    public void toggleNavigationDrawersBarTests() {
        toggleNavigationDrawersBar.is().displayed();
        toggleNavigationDrawersBar.menuButton().is().displayed();
        toggleNavigationDrawersBar.menuButton().click();
        navigationDrawer.is().opened();
    }

    private static void scrollToBottom(UIElement overflowWindow) {
        jsExecute("arguments[0].scroll(0, document.body.scrollHeight)", overflowWindow.getFast());
    }

    private static void scrollBarToTop(UIElement overflowWindow) {
        jsExecute("arguments[0].scroll(document.body.scrollHeight, 0)", overflowWindow.getFast());
    }
}
