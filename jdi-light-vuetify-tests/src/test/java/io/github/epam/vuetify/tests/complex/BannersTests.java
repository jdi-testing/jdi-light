package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bannersPage;
import static io.github.com.pages.BannersPage.actionsBanner;
import static io.github.com.pages.BannersPage.eventsBanner;
import static io.github.com.pages.BannersPage.iconBanner;
import static io.github.com.pages.BannersPage.singleBanner;
import static io.github.com.pages.BannersPage.twoLineBanner;

public class BannersTests extends TestsInit {

        @BeforeMethod
        public void beforeTest() {
            bannersPage.open();
        }

        @Test
        public void singleBannerTests() {
            singleBanner.is().displayed();
            singleBanner.has().properTitle("My Document");
            singleBanner.has().properText("We can't save your edits");
            singleBanner.has().button();
            singleBanner.has().checker();
            singleBanner.is().checkerUnchecked();
            singleBanner.getChecker().click();
            singleBanner.is().checkerChecked();
        }

        @Test
        public void eventsBannerTests() {
            eventsBanner.is().displayed();
            eventsBanner.has().button();
            eventsBanner.has().icon();
            eventsBanner.getIcon().click();
            eventsBanner.has().alertOnIconClick("Hello, World!");
            eventsBanner.handleAlert();
       }

        @Test
        public void actionsBannerTests() {
            actionsBanner.is().displayed();
            actionsBanner.has().buttons();
            actionsBanner.has().checker();
            actionsBanner.is().checkerChecked();
            actionsBanner.getChecker().click();
            actionsBanner.is().checkerUnchecked();
            actionsBanner.has().hiddenButtons();
            actionsBanner.has().hiddenTextField();
        }

        @Test
        public void iconBannerTests() {
            iconBanner.is().displayed();
            iconBanner.has().buttons();
            iconBanner.has().icon();
            iconBanner.has().properText("Three line text string example with two actions");
        }

        @Test
        public void twoLineBannerTests() {
            twoLineBanner.is().displayed();
            twoLineBanner.has().buttons();
            twoLineBanner.is().properText("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        }
}
