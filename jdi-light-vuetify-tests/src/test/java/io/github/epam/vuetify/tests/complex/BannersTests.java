package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.bannersPage;
import static io.github.com.enums.ButtonNames.CONNECTION_SETTINGS;
import static io.github.com.enums.ButtonNames.DISMISS;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.YELLOW;
import static io.github.com.pages.BannersPage.actionsBanner;
import static io.github.com.pages.BannersPage.darkBanner;
import static io.github.com.pages.BannersPage.elevatedBanner;
import static io.github.com.pages.BannersPage.enableTileCheckbox;
import static io.github.com.pages.BannersPage.eventsBanner;
import static io.github.com.pages.BannersPage.iconBanner;
import static io.github.com.pages.BannersPage.outlinedBanner;
import static io.github.com.pages.BannersPage.roundedBanner;
import static io.github.com.pages.BannersPage.shapedBanner;
import static io.github.com.pages.BannersPage.singleBanner;
import static io.github.com.pages.BannersPage.singleBannerSwitch;
import static io.github.com.pages.BannersPage.tileBanner;
import static io.github.com.pages.BannersPage.twoLineBanner;

public class BannersTests extends TestsInit {

	@BeforeClass
	public void before() {
		bannersPage.open();
		waitCondition(() -> bannersPage.isOpened());
		bannersPage.checkOpened();
	}

	@Test
	public void textBannerTests() {
		singleBanner.show();
		singleBanner.is().displayed();
		singleBanner.has().text("We can't save your edits while you are in offline mode.");
	}

	@Test
	public void singleBannerTests() {
		singleBanner.show();
		singleBanner.is().singleLine();
		twoLineBanner.show();
		twoLineBanner.is().notSingleLine();
	}

	@Test
	public void stickyBannerTests() {
		singleBanner.show();
		singleBanner.is().notSticky();
		singleBannerSwitch.check();
		singleBanner.is().sticky();
	}

	@Test
	public void eventsBannerTests() {
		eventsBanner.show();
		eventsBanner.is().displayed();
		eventsBanner.icon().is().displayed();
		eventsBanner.icon().click();
		eventsBanner.core().driver().switchTo().alert().dismiss();
		eventsBanner.getButtonWithText(CONNECTION_SETTINGS.toString()).has().text(CONNECTION_SETTINGS.toString());
		eventsBanner.getButtonByText(CONNECTION_SETTINGS.toString()).is().clickable();
	}

	@Test
	public void actionsBannerTests() {
		actionsBanner.show();
		actionsBanner.has().text("No Internet connection");
		actionsBanner.buttons().has().size(2);
		actionsBanner.getButtonWithText(DISMISS.toString()).click();
		waitCondition(() -> actionsBanner.isNotVisible());
		actionsBanner.is().notVisible();
	}

	@Test
	public void iconBannerTests() {
		iconBanner.show();
		iconBanner.has().icon();
		actionsBanner.show();
		actionsBanner.has().notIcon();
	}

	@Test
	public void roundedBannerTest() {
		roundedBanner.show();
		roundedBanner.is().rounded();
	}

	@Test
	public void tileBannerTest() {
		enableTileCheckbox.show();
        enableTileCheckbox.check();
		tileBanner.is().tile();
        shapedBanner.is().notTile();
	}

    @Test
    public void shapedBannerTest() {
        shapedBanner.show();
        shapedBanner.is().shaped();
        outlinedBanner.is().notShaped();
    }

    @Test
    public void outlinedBannerTest() {
        outlinedBanner.show();
        outlinedBanner.is().outlined();
        darkBanner.is().notOutlined();
    }

    @Test
    public void themeBannerTest() {
        outlinedBanner.show();
        outlinedBanner.has().lightTheme();
        darkBanner.has().darkTheme();
    }

    @Test
    public void elevationBannerTest() {
        elevatedBanner.show();
        elevatedBanner.is().elevated();
        elevatedBanner.has().elevation(12);
        darkBanner.is().notElevated();
    }

    @Test
    public void colorBannerTest() {
        roundedBanner.show();
        roundedBanner.has().backgroundColor(YELLOW.value());
        roundedBanner.has().color(BLACK_TRANSPARENT_087.value());
    }
}
