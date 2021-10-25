package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bannersPage;
import static io.github.com.pages.BannersPage.actionsBanner;
import static io.github.com.pages.BannersPage.eventsBanner;
import static io.github.com.pages.BannersPage.iconBanner;
import static io.github.com.pages.BannersPage.singleBanner;
import static io.github.com.pages.BannersPage.twoLineBanner;

public class BannersTests extends TestsInit {

        @BeforeClass
        public void before() {
            bannersPage.open();
        }

        @Test
        public void singleBannerTests() {
            singleBanner.is().displayed();
            singleBanner.has().title("My Document");
            singleBanner.has().text("We can't save your edits");
            singleBanner.has().buttons(1);
            singleBanner.has().checker();
            singleBanner.has().checkerUnchecked();
            singleBanner.checkerCheck();
            singleBanner.has().checkerChecked();
        }

        @Test
        public void eventsBannerTests() {
            eventsBanner.is().displayed();
            eventsBanner.has().buttons(1);
            eventsBanner.has().icon();
            eventsBanner.clickOnIcon();
            eventsBanner.has().alertOnIconClick("Hello, World!");
            eventsBanner.handleAlert();
       }

        @Test
        public void actionsBannerTests() {
            actionsBanner.is().displayed();
            actionsBanner.has().buttons(2);
            actionsBanner.has().visibleButtons();
            actionsBanner.has().checker();
            actionsBanner.has().checkerChecked();
            actionsBanner.checkerUnCheck();
            actionsBanner.has().checkerUnchecked();
            actionsBanner.has().hiddenButtons();
            actionsBanner.has().hiddenTextField();
        }

        @Test
        public void iconBannerTests() {
            iconBanner.is().displayed();
            iconBanner.has().buttons(2);
            iconBanner.has().icon();
            iconBanner.has().text("Three line text string example with two actions");
        }

        @Test
        public void twoLineBannerTests() {
            twoLineBanner.is().displayed();
            twoLineBanner.has().buttons(2);
            twoLineBanner.has().text("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
        }
}
