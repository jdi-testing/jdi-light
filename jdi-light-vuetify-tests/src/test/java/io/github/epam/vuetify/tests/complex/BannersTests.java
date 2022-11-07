package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.bannersPage;
import static io.github.com.enums.ButtonNames.ACTION;
import static io.github.com.enums.ButtonNames.CONNECTION_SETTINGS;
import static io.github.com.enums.ButtonNames.DISMISS;
import static io.github.com.enums.ButtonNames.RETRY;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.GREEN;
import static io.github.com.enums.Colors.PURPLE;
import static io.github.com.enums.Colors.RED;
import static io.github.com.enums.Colors.WHITE;
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
		eventsBanner.buttons().getButtonWithText(CONNECTION_SETTINGS.toString()).has().text(CONNECTION_SETTINGS.toString());
		eventsBanner.buttons().getButtonWithText(CONNECTION_SETTINGS.toString()).is().clickable();
	}

	@Test
	public void actionsBannerTests() {
		actionsBanner.show();
		actionsBanner.is().displayed().and().has().text("No Internet connection");
		actionsBanner.buttons().is().displayed().and().has().size(2);
		actionsBanner.buttons().getButtonWithText(DISMISS.toString()).has().text(DISMISS.toString());
		actionsBanner.buttons().getButtonWithText(DISMISS.toString()).is().clickable();
		actionsBanner.buttons().getButtonWithText(RETRY.toString()).has().text(RETRY.toString());
		actionsBanner.buttons().getButtonWithText(RETRY.toString()).is().clickable();
		actionsBanner.buttons().getButtonWithText(DISMISS.toString()).click();
		waitCondition(() -> actionsBanner.bannerContent().isNotVisible());
		actionsBanner.bannerContent().is().notVisible();
		actionsBanner.bannerActions().is().notVisible();
	}

	@Test
	public void iconBannerTests() {
		iconBanner.show();
		iconBanner.is().displayed();
		iconBanner.getIconFromContent().is().displayed();
		iconBanner.buttons().getButtonByIndex(1).has().text(ACTION.toString());
		iconBanner.buttons().getButtonByIndex(1).is().clickable();
		iconBanner.buttons().getButtonByIndex(2).has().text(ACTION.toString());
		iconBanner.buttons().getButtonByIndex(2).is().clickable();
		jdiAssert(iconBanner.attrs().has("two-line"), Matchers.is(true));
	}

	@Test
	public void twoLineBannerTests() {
		twoLineBanner.show();
		twoLineBanner.is().displayed();
		twoLineBanner.buttons().getButtonWithText(DISMISS.toString()).has().text(DISMISS.toString());
		twoLineBanner.buttons().getButtonWithText(DISMISS.toString()).is().clickable();
		twoLineBanner.buttons().getButtonWithText(RETRY.toString()).has().text(RETRY.toString());
		twoLineBanner.buttons().getButtonWithText(RETRY.toString()).is().clickable();
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
        tileBanner.show();
        tileBanner.has().backgroundColor(GREEN.value());
        tileBanner.has().color(BLACK_TRANSPARENT_087.value());
        shapedBanner.show();
        shapedBanner.has().backgroundColor(RED.value());
        shapedBanner.has().color(BLACK_TRANSPARENT_087.value());
        darkBanner.show();
        darkBanner.has().backgroundColor(PURPLE.value());
        darkBanner.has().color(WHITE.value());
    }
}
