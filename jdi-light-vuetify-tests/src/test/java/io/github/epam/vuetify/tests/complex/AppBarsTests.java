package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.appBarsPage;
import static io.github.com.pages.AppBarsPage.collapsibleBar;
import static io.github.com.pages.AppBarsPage.denseBar;
import static io.github.com.pages.AppBarsPage.elevateScrollBar;
import static io.github.com.pages.AppBarsPage.fadeImageBar;
import static io.github.com.pages.AppBarsPage.hidingScrollBar;
import static io.github.com.pages.AppBarsPage.imageBar;
import static io.github.com.pages.AppBarsPage.scrollThresholdBar;
import static io.github.com.pages.AppBarsPage.toggleNavigationDrawersBar;


public class AppBarsTests extends TestsInit {

        @BeforeClass
        public void before() {
            appBarsPage.open();
        }

        @Test
        public void collapsibleBarTests() {
            collapsibleBar.is().displayed();
            collapsibleBar.menuButton().is().displayed();
            collapsibleBar.title().is().displayed();
            collapsibleBar.title().has().text("Collapsing Bar");
            collapsibleBar.scrollBarToBottom();
            collapsibleBar.title().is().hidden();
            collapsibleBar.scrollBarToTop();
            collapsibleBar.title().is().displayed();
            collapsibleBar.checkbox().is().displayed();
            collapsibleBar.checkbox().is().checked();
            collapsibleBar.checkbox().uncheck();
            collapsibleBar.checkbox().is().unchecked();
            collapsibleBar.title().is().hidden();
            collapsibleBar.checkbox().check();
            collapsibleBar.title().is().displayed();
        }

        @Test
        public void denseBarTests() {
            denseBar.is().displayed();
            denseBar.menuButton().is().displayed();
            denseBar.title().is().displayed();
            denseBar.title().has().text("Page title");
            denseBar.searchButton().is().displayed();
            denseBar.heartButton().is().displayed();
            denseBar.verticalDotsButton().is().displayed();
            denseBar.verticalDotsButton().click();
            denseBar.menu().is().displayed();
        }

        @Test
        public void elevateScrollBarTests() {
            elevateScrollBar.is().displayed();
            elevateScrollBar.menuButton().is().displayed();
            elevateScrollBar.title().is().displayed();
            elevateScrollBar.title().has().text("Title");
            elevateScrollBar.searchButton().is().displayed();
            elevateScrollBar.heartButton().is().displayed();
            elevateScrollBar.verticalDotsButton().is().displayed();
            elevateScrollBar.scrollBarToBottom();
            elevateScrollBar.has().visibleHeaderShadow();
            elevateScrollBar.scrollBarToTop();
            elevateScrollBar.has().hiddenHeaderShadow();
        }

        @Test
        public void imageBarTests() {
            imageBar.is().displayed();
            imageBar.menuButton().is().displayed();
            imageBar.title().is().displayed();
            imageBar.title().has().text("Title");
            imageBar.searchButton().is().displayed();
            imageBar.heartButton().is().displayed();
            imageBar.verticalDotsButton().is().displayed();
            imageBar.scrollBarToBottom();
            imageBar.has().headerHeight("56px");
            imageBar.scrollBarToTop();
            imageBar.has().headerHeight("128px");
        }

        @Test
        public void hidingScrollBarTests() {
            hidingScrollBar.is().displayed();
            hidingScrollBar.menuButton().is().displayed();
            hidingScrollBar.title().is().displayed();
            hidingScrollBar.title().has().text("Title");
            hidingScrollBar.searchButton().is().displayed();
            hidingScrollBar.heartButton().is().displayed();
            hidingScrollBar.verticalDotsButton().is().displayed();
            hidingScrollBar.has().visibleHeader();
            hidingScrollBar.scrollBarToBottom();
            hidingScrollBar.has().hiddenHeader();
        }

        @Test
        public void fadeImageBarTests() {
            fadeImageBar.is().displayed();
            fadeImageBar.menuButton().is().displayed();
            fadeImageBar.title().is().displayed();
            fadeImageBar.title().has().text("Title");
            fadeImageBar.searchButton().is().displayed();
            fadeImageBar.heartButton().is().displayed();
            fadeImageBar.verticalDotsButton().is().displayed();
            fadeImageBar.has().clickableTabs();
            fadeImageBar.has().headerHeight("224px");
            fadeImageBar.has().headerOpacity(1);
            fadeImageBar.scrollBarToBottom();
            fadeImageBar.has().headerHeight("104px");
            fadeImageBar.has().headerOpacity(0);
        }

        @Test
        public void scrollThresholdBarTests() {
            scrollThresholdBar.is().displayed();
            scrollThresholdBar.menuButton().is().displayed();
            scrollThresholdBar.title().is().displayed();
            scrollThresholdBar.title().has().text("Title");
            scrollThresholdBar.searchButton().is().displayed();
            scrollThresholdBar.heartButton().is().displayed();
            scrollThresholdBar.verticalDotsButton().is().displayed();
            scrollThresholdBar.has().headerHeight("128px");
            scrollThresholdBar.has().headerOpacity(1);
            scrollThresholdBar.scrollBarToBottom();
            scrollThresholdBar.has().headerHeight("56px");
            scrollThresholdBar.has().headerOpacity(0);
        }

        @Test
        public void toggleNavigationDrawersBarTests() {
            toggleNavigationDrawersBar.is().displayed();
            toggleNavigationDrawersBar.menuButton().is().displayed();
            toggleNavigationDrawersBar.title().is().displayed();
            toggleNavigationDrawersBar.title().has().text("Title");
            toggleNavigationDrawersBar.menuButton().click();
            toggleNavigationDrawersBar.has().navigationMenu();
        }
}
