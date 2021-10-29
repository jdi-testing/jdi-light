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
            collapsibleBar.has().menuButton();
            collapsibleBar.has().title();
            collapsibleBar.has().textInTitle("Collapsing Bar");
            collapsibleBar.scrollBarToBottom();
            collapsibleBar.has().hiddenTitle();
            collapsibleBar.scrollBarToTop();
            collapsibleBar.has().title();
            collapsibleBar.has().checkbox();
            collapsibleBar.has().checkboxChecked();
            collapsibleBar.checkboxUncheck();
            collapsibleBar.has().checkboxUnchecked();
            collapsibleBar.has().hiddenTitle();
            collapsibleBar.checkboxCheck();
            collapsibleBar.has().title();
        }

        @Test
        public void denseBarTests() {
            denseBar.is().displayed();
            denseBar.has().menuButton();
            denseBar.has().title();
            denseBar.has().textInTitle("Page title");
            denseBar.has().searchButton();
            denseBar.has().heartButton();
            denseBar.has().verticalDotsButton();
            denseBar.clickOnVerticalDotsButton();
            optionsMenu.is().displayed();
        }

        @Test
        public void elevateScrollBarTests() {
            elevateScrollBar.is().displayed();
            elevateScrollBar.has().menuButton();
            elevateScrollBar.has().title();
            elevateScrollBar.has().textInTitle("Title");
            elevateScrollBar.has().searchButton();
            elevateScrollBar.has().heartButton();
            elevateScrollBar.has().verticalDotsButton();
            elevateScrollBar.scrollBarToBottom();
            elevateScrollBar.has().visibleHeaderShadow();
            elevateScrollBar.scrollBarToTop();
            elevateScrollBar.has().hiddenHeaderShadow();
        }

        @Test
        public void imageBarTests() {
            imageBar.is().displayed();
            imageBar.has().menuButton();
            imageBar.has().title();
            imageBar.has().textInTitle("Title");
            imageBar.has().searchButton();
            imageBar.has().heartButton();
            imageBar.has().verticalDotsButton();
            imageBar.scrollBarToBottom();
            imageBar.has().headerHeight("56px");
            imageBar.scrollBarToTop();
            imageBar.has().headerHeight("128px");
        }

        @Test
        public void hidingScrollBarTests() {
            hidingScrollBar.is().displayed();
            hidingScrollBar.has().menuButton();
            hidingScrollBar.has().title();
            hidingScrollBar.has().textInTitle("Title");
            hidingScrollBar.has().searchButton();
            hidingScrollBar.has().heartButton();
            hidingScrollBar.has().verticalDotsButton();
            hidingScrollBar.has().visibleHeader();
            hidingScrollBar.scrollBarToBottom();
            hidingScrollBar.has().hiddenHeader();
        }

        @Test
        public void fadeImageBarTests() throws Exception {
            fadeImageBar.is().displayed();
            fadeImageBar.has().menuButton();
            fadeImageBar.has().title();
            fadeImageBar.has().textInTitle("Title");
            fadeImageBar.has().searchButton();
            fadeImageBar.has().heartButton();
            fadeImageBar.has().verticalDotsButton();
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
            scrollThresholdBar.has().menuButton();
            scrollThresholdBar.has().title();
            scrollThresholdBar.has().textInTitle("Title");
            scrollThresholdBar.has().searchButton();
            scrollThresholdBar.has().heartButton();
            scrollThresholdBar.has().verticalDotsButton();
            scrollThresholdBar.has().headerHeight("128px");
            scrollThresholdBar.has().headerOpacity(1);
            scrollThresholdBar.scrollBarToBottom();
            scrollThresholdBar.has().headerHeight("56px");
            scrollThresholdBar.has().headerOpacity(0);
        }

        @Test
        public void toggleNavigationDrawersBarTests() {
            toggleNavigationDrawersBar.is().displayed();
            toggleNavigationDrawersBar.has().menuButton();
            toggleNavigationDrawersBar.has().title();
            toggleNavigationDrawersBar.has().textInTitle("Title");
            toggleNavigationDrawersBar.clickOnMenuButton();
            toggleNavigationDrawersBar.has().navigationMenu();
        }
}
