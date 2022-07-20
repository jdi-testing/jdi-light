package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.bannersPage;
import static io.github.com.pages.BannersPage.actionsBanner;
import static io.github.com.pages.BannersPage.eventsBanner;
import static io.github.com.pages.BannersPage.singleBanner;
import static io.github.com.pages.BannersPage.iconBanner;
import static io.github.com.pages.BannersPage.twoLineBanner;

public class BannersTests extends TestsInit {

        @BeforeClass
        public void before() {
            bannersPage.open();
            waitCondition(() -> bannersPage.isOpened());
            bannersPage.checkOpened();
        }

        @Test
        public void singleBannerTests() {
            singleBanner.show();
            singleBanner.is().displayed();
            singleBanner.toolbarTitle().has().text("My Document");
            singleBanner.checkbox().isClickable();
            singleBanner.has().text("We can't save your edits while you are in offline mode.");
            singleBanner.checkbox().click();
            singleBanner.has().css("position", "relative");
        }

        @Test
        public void eventsBannerTests() {
            eventsBanner.show();
            eventsBanner.is().displayed();
            eventsBanner.getIconFromContent().is().displayed();
            eventsBanner.getIconFromContent().click();
            String alertText = eventsBanner.core().driver().switchTo().alert().getText();
            jdiAssert(alertText, Matchers.is("Hello, World!"));
            eventsBanner.core().driver().switchTo().alert().dismiss();
            eventsBanner.buttons().getButtonByText("\n" + "      Connection Settings\n" + "    ").has().text("CONNECTION SETTINGS");
            eventsBanner.buttons().getButtonByText("\n" + "      Connection Settings\n" + "    ").is().clickable();
        }

        @Test
        public void actionsBannerTests() {
            actionsBanner.show();
            actionsBanner.is().displayed().and().has().text("No Internet connection");
            actionsBanner.buttons().is().displayed().and().has().size(2);
            actionsBanner.buttons().getButtonByIndex(1).has().text("DISMISS");
            actionsBanner.buttons().getButtonByIndex(1).is().clickable();
            actionsBanner.buttons().getButtonByIndex(2).has().text("RETRY");
            actionsBanner.buttons().getButtonByIndex(2).is().clickable();
            actionsBanner.buttons().getButtonByIndex(1).click();
            waitCondition(() -> actionsBanner.bannerContent().isNotVisible());
            actionsBanner.bannerContent().is().notVisible();
            actionsBanner.bannerActions().is().notVisible();
        }

        @Test
        public void iconBannerTests() {
            iconBanner.show();
            iconBanner.is().displayed();
            iconBanner.getIconFromContent().is().displayed();
            iconBanner.buttons().getButtonByIndex(1).has().text("ACTION");
            iconBanner.buttons().getButtonByIndex(1).is().clickable();
            iconBanner.buttons().getButtonByIndex(2).has().text("ACTION");
            iconBanner.buttons().getButtonByIndex(2).is().clickable();
            jdiAssert(iconBanner.attrs().has("two-line"), Matchers.is(true));
        }

        @Test
        public void twoLineBannerTests() {
            twoLineBanner.show();
            twoLineBanner.is().displayed();
            twoLineBanner.buttons().getButtonByIndex(1).has().text("DISMISS");
            twoLineBanner.buttons().getButtonByIndex(1).is().clickable();
            twoLineBanner.buttons().getButtonByIndex(2).has().text("RETRY");
            twoLineBanner.buttons().getButtonByIndex(2).is().clickable();
        }
}
