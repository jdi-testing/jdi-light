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
import static io.github.com.pages.BannersPage.stickSwitch;

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
            singleBanner.has().text("We can't save your edits while you are in offline mode.");
            stickSwitch.check();
            singleBanner.has().css("position", "sticky");
        }

        @Test
        public void eventsBannerTests() {
            eventsBanner.show();
            eventsBanner.is().displayed();
            eventsBanner.icon().is().displayed();
            eventsBanner.icon().click();
            String alertText = eventsBanner.core().driver().switchTo().alert().getText();
            jdiAssert(alertText, Matchers.is("Hello, World!"));
            eventsBanner.core().driver().switchTo().alert().dismiss();
        }

        @Test
        public void actionsBannerTests() {
            actionsBanner.show();
            actionsBanner.is().displayed().and().has().text("No Internet connection");
            actionsBanner.buttons().is().displayed().and().has().size(2);
            actionsBanner.buttons().getButtonByIndex(1).has().text("DISMISS");
            actionsBanner.buttons().getButtonByIndex(2).has().text("RETRY");
            actionsBanner.buttons().getButtonByIndex(1).click();
            actionsBanner.is().notVisible();
        }
}
