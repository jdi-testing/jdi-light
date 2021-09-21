package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.Conditions.displayed;
import static io.github.com.StaticSite.appBarsPage;
import static io.github.com.pages.AppBarsPage.*;

public class AppBarsTests extends TestsInit {

        @BeforeMethod
        public void beforeTest() {
            appBarsPage.open();
        }

        @Test
        public void collapsibleBarTests() {
            collapsibleBar.waitFor(displayed);
            collapsibleBar.is().displayed();
            collapsibleBar.has().menuButton();
            collapsibleBar.has().properTitleText("Collapsing Bar");
            collapsibleBar.has().title();
            collapsibleBar.scrollToBottom();
            collapsibleBar.has().hiddenTitle();
            collapsibleBar.scrollToTop();
            collapsibleBar.has().title();
            collapsibleBar.has().checker();
            collapsibleBar.is().checkerChecked();
            collapsibleBar.getChecker().click();
            collapsibleBar.is().checkerUnchecked();
            collapsibleBar.has().hiddenTitle();
            collapsibleBar.getChecker().click();
            collapsibleBar.has().title();
        }

        @Test
        public void denseBarTests() {
            denseBar.waitFor(displayed);
            denseBar.is().displayed();
            denseBar.has().menuButton();
            denseBar.has().properTitleText("Page title");
            denseBar.has().title();
            denseBar.has().searchButton();
            denseBar.has().heartButton();
            denseBar.has().verticalDotsButton();
            denseBar.getVerticalDotsButton().click();
            optionsMenu.is().displayed();
        }

        @Test
        public void elevateScrollBarTests() {
            elevateScrollBar.waitFor(displayed);
            elevateScrollBar.is().displayed();
            elevateScrollBar.has().menuButton();
            elevateScrollBar.has().properTitleText("Title");
            elevateScrollBar.has().title();
            elevateScrollBar.has().searchButton();
            elevateScrollBar.has().heartButton();
            elevateScrollBar.has().verticalDotsButton();
            elevateScrollBar.scrollToBottom();
            elevateScrollBar.is().headerShadowVisible("v-app-bar--is-scrolled");
            elevateScrollBar.scrollToTop();
            elevateScrollBar.is().headerShadowHidden("hide-shadow");
        }

        @Test
        public void imageBarTests() {
            imageBar.waitFor(displayed);
            imageBar.is().displayed();
            imageBar.has().menuButton();
            imageBar.has().properTitleText("Title");
            imageBar.has().title();
            imageBar.has().searchButton();
            imageBar.has().heartButton();
            imageBar.has().verticalDotsButton();
            imageBar.scrollToBottom();
            imageBar.has().headerHeight("56px");
            imageBar.scrollToTop();
            imageBar.is().headerHeight("128px");
        }

        @Test
        public void hidingScrollBarTests() {
            hidingScrollBar.waitFor(displayed);
            hidingScrollBar.is().displayed();
            hidingScrollBar.has().menuButton();
            hidingScrollBar.has().properTitleText("Title");
            hidingScrollBar.has().title();
            hidingScrollBar.has().searchButton();
            hidingScrollBar.has().heartButton();
            hidingScrollBar.has().verticalDotsButton();
            hidingScrollBar.is().headerVisible();
            hidingScrollBar.scrollToBottom();
            hidingScrollBar.is().headerHidden();
        }

        @Test
        public void fadeImageBarTests() {
            fadeImageBar.waitFor(displayed);
            fadeImageBar.is().displayed();
            fadeImageBar.has().menuButton();
            fadeImageBar.has().properTitleText("Title");
            fadeImageBar.has().title();
            fadeImageBar.has().searchButton();
            fadeImageBar.has().heartButton();
            fadeImageBar.has().verticalDotsButton();
            fadeImageBar.has().tabs();
            fadeImageBar.has().headerHeight("224px");
            fadeImageBar.has().headerOpacity(1);
            fadeImageBar.scrollToBottom();
            fadeImageBar.has().headerHeight("104px");
            fadeImageBar.has().headerOpacity(0);
        }

        @Test
        public void scrollThresholdBarTests() {
            scrollThresholdBar.waitFor(displayed);
            scrollThresholdBar.scrollPageToBottom();
            scrollThresholdBar.is().displayed();
            scrollThresholdBar.has().menuButton();
            scrollThresholdBar.has().properTitleText("Title");
            scrollThresholdBar.has().title();
            scrollThresholdBar.has().searchButton();
            scrollThresholdBar.has().heartButton();
            scrollThresholdBar.has().verticalDotsButton();
            scrollThresholdBar.has().headerHeight("128px");

//            scrollThresholdBar.has().headerOpacity(1);
            scrollThresholdBar.scrollToBottom();
            scrollThresholdBar.has().headerHeight("56px");
//            scrollThresholdBar.has().headerOpacity(0);
        }
}
