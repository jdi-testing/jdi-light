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
import static io.github.com.pages.AppBarsPage.optionsMenu;
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
            collapsibleBar.has().title();
            collapsibleBar.has().textInTitle("Collapsing Bar");
            collapsibleBar.scrollBarToBottom();
            collapsibleBar.has().hiddenTitle();
            collapsibleBar.scrollBarToTop();
            collapsibleBar.has().title();
            collapsibleBar.checkbox().is().displayed();
            collapsibleBar.checkbox().is().checked();
            collapsibleBar.checkbox().uncheck();
            collapsibleBar.checkbox().is().unchecked();
            collapsibleBar.has().hiddenTitle();
            collapsibleBar.checkbox().check();
            collapsibleBar.has().title();
        }

        @Test
        public void denseBarTests() {
            denseBar.is().displayed();
            denseBar.menuButton().is().displayed();
            denseBar.has().title();
            denseBar.has().textInTitle("Page title");
            denseBar.searchButton().is().displayed();
            denseBar.heartButton().is().displayed();
            denseBar.verticalDotsButton().is().displayed();
            denseBar.verticalDotsButton().click();
            optionsMenu.is().displayed();
        }

        @Test
        public void elevateScrollBarTests() {
            elevateScrollBar.is().displayed();
            elevateScrollBar.menuButton().is().displayed();
            elevateScrollBar.has().title();
            elevateScrollBar.has().textInTitle("Title");
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
            imageBar.has().title();
            imageBar.has().textInTitle("Title");
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
            hidingScrollBar.has().title();
            hidingScrollBar.has().textInTitle("Title");
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
            fadeImageBar.has().title();
            fadeImageBar.has().textInTitle("Title");
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
            scrollThresholdBar.has().title();
            scrollThresholdBar.has().textInTitle("Title");
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
            toggleNavigationDrawersBar.has().title();
            toggleNavigationDrawersBar.has().textInTitle("Title");
            toggleNavigationDrawersBar.menuButton().click();
            toggleNavigationDrawersBar.has().navigationMenu();
        }
}
