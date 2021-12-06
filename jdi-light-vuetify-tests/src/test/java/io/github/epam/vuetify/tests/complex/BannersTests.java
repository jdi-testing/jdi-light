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
            singleBanner.textContent().has().text("We can't save your edits while you are in offline mode.");
            singleBanner.button().is().displayed();
            singleBanner.button().has().text("GET ONLINE");
            singleBanner.getSwitch().is().displayed();
            singleBanner.getSwitch().is().unchecked();
            singleBanner.getSwitch().check();
            singleBanner.getSwitch().is().checked();
        }

        @Test
        public void eventsBannerTests() {
            eventsBanner.is().displayed();
            eventsBanner.button().is().displayed();
            eventsBanner.button().has().text("CONNECTION SETTINGS");
            eventsBanner.icon().is().displayed();
            eventsBanner.icon().click();
            eventsBanner.has().alertText("Hello, World!");
            eventsBanner.dismissAlert();
       }

        @Test
        public void actionsBannerTests() {
            actionsBanner.is().displayed();
            actionsBanner.textContent().has().text("No Internet connection");
            actionsBanner.buttons().is().displayed();
            actionsBanner.buttons().has().size(2);
            actionsBanner.buttons().getButtonByIndex(1).has().text("DISMISS");
            actionsBanner.buttons().getButtonByIndex(2).has().text("RETRY");
            actionsBanner.checkbox().is().displayed();
            actionsBanner.checkbox().is().checked();
            actionsBanner.checkbox().uncheck();
            actionsBanner.checkbox().is().unchecked();
            actionsBanner.textContent().is().hidden();
        }

        @Test
        public void iconBannerTests() {
            String bannerText = "Three line text string example with two actions. One to two lines is preferable. " +
                    "Three lines should be considered the maximum string length on desktop " +
                    "in order to keep messages short and actionable.";
            iconBanner.is().displayed();
            iconBanner.buttons().is().displayed();
            iconBanner.buttons().has().size(2);
            iconBanner.buttons().getButtonByIndex(1).has().text("ACTION");
            iconBanner.buttons().getButtonByIndex(2).has().text("ACTION");
            iconBanner.icon().is().displayed();
            iconBanner.textContent().has().text(bannerText);
        }

        @Test
        public void twoLineBannerTests() {
            String bannerText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Praesent cursus nec sem id malesuada. Curabitur lacinia sem et " +
                    "turpis euismod, eget elementum ex pretium.";
            twoLineBanner.is().displayed();
            twoLineBanner.buttons().is().displayed();
            twoLineBanner.buttons().has().size(2);
            twoLineBanner.buttons().get(1).has().text("DISMISS");
            twoLineBanner.buttons().get(2).has().text("RETRY");
            twoLineBanner.textContent().has().text(bannerText);
        }
}
