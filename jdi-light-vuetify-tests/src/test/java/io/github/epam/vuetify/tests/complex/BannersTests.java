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

	@Test(description = "Test checks that single banner has expected text")
	public void textBannerTests() {
		singleBanner.show();
		singleBanner.is().displayed();
		singleBanner.has().text("We can't save your edits while you are in offline mode.");
	}

	@Test(description = "Test checks that banner has single line text")
	public void singleBannerTests() {
		singleBanner.show();
		singleBanner.is().singleLine();
		twoLineBanner.show();
		twoLineBanner.is().notSingleLine();
	}

	@Test(description = "Test checks that banner is 'sticky' or not")
	public void stickyBannerTests() {
		singleBanner.show();
		singleBanner.is().notSticky();
		singleBannerSwitch.check();
		singleBanner.is().sticky();
	}

	@Test(description = "Test checks event banner")
	public void eventsBannerTests() {
		eventsBanner.show();
		eventsBanner.is().displayed();
		eventsBanner.icon().is().displayed();
		eventsBanner.icon().click();
		eventsBanner.core().driver().switchTo().alert().dismiss();
		eventsBanner.getButtonWithText(CONNECTION_SETTINGS.toString()).has().text(CONNECTION_SETTINGS.toString());
		eventsBanner.getButtonByText(CONNECTION_SETTINGS.toString()).is().clickable();
	}

	@Test(description = "Test checks text of action banner and functionality")
	public void actionsBannerTests() {
		actionsBanner.show();
		actionsBanner.has().text("No Internet connection")
				.and().numberOfButtons(2);
		actionsBanner.getButtonWithText(DISMISS.toString()).click();
		waitCondition(() -> actionsBanner.isNotVisible());
		actionsBanner.is().notVisible();
	}

	@Test(description = "Test checks that icon banner has icon")
	public void iconBannerTests() {
		iconBanner.show();
		iconBanner.has().icon();
		actionsBanner.show();
		actionsBanner.has().notIcon();
	}

	@Test(description = "Test checks that banner is rounded")
	public void roundedBannerTest() {
		roundedBanner.show();
		roundedBanner.is().rounded();
	}

	@Test(description = "Test checks that banner is a tile or not")
	public void tileBannerTest() {
		enableTileCheckbox.show();
        enableTileCheckbox.check();
		tileBanner.is().tile();
        shapedBanner.is().notTile();
	}

	@Test(description = "Test checks that banner is shaped or not")
    public void shapedBannerTest() {
        shapedBanner.show();
        shapedBanner.is().shaped();
        outlinedBanner.is().notShaped();
    }

	@Test(description = "Test checks that banner is outlined or not")
    public void outlinedBannerTest() {
        outlinedBanner.show();
        outlinedBanner.is().outlined();
        darkBanner.is().notOutlined();
    }

	@Test(description = "Test checks that banner has light or dark theme")
    public void themeBannerTest() {
        outlinedBanner.show();
        outlinedBanner.has().lightTheme();
        darkBanner.has().darkTheme();
    }

	@Test(description = "Test checks that banner is elevated and has expected elevation value")
    public void elevationBannerTest() {
        elevatedBanner.show();
        elevatedBanner.is().elevated().and().has().elevation(12);
        darkBanner.is().notElevated();
    }

	@Test(description = "Test checks background color of banner and ti's main color")
    public void colorBannerTest() {
        roundedBanner.show();
        roundedBanner.has().backgroundColor(YELLOW.value())
				.and().color(BLACK_TRANSPARENT_087.value());
    }
}
