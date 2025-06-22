package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.TabsTestsDataProvider;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.resizeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.fullscreen;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.tabsPage;
import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.RED_LIGHTEN_2;
import static io.github.com.enums.Colors.WHITE;
import static io.github.com.enums.MdiIcons.ARROW_LEFT_BOLD_BOX_OUTLINE;
import static io.github.com.enums.MdiIcons.ARROW_RIGHT_BOLD_BOX_OUTLINE;
import static io.github.com.pages.TabsPage.addButton;
import static io.github.com.pages.TabsPage.alignWithTitleTabs;
import static io.github.com.pages.TabsPage.centerActiveTabs;
import static io.github.com.pages.TabsPage.contentTabs;
import static io.github.com.pages.TabsPage.customIconsTabs;
import static io.github.com.pages.TabsPage.disabledTabs;
import static io.github.com.pages.TabsPage.dynamicTabs;
import static io.github.com.pages.TabsPage.fixedTabs;
import static io.github.com.pages.TabsPage.growTabs;
import static io.github.com.pages.TabsPage.hrefTabs;
import static io.github.com.pages.TabsPage.iconAndTextTabs;
import static io.github.com.pages.TabsPage.overflowToMenuTabs;
import static io.github.com.pages.TabsPage.paginationTabs;
import static io.github.com.pages.TabsPage.removeButton;
import static io.github.com.pages.TabsPage.rightTabs;
import static io.github.com.pages.TabsPage.verticalTabs;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;

public class TabsTests extends TestsInit {

	private static final String[] OVERFLOW_TAB_DATA = {"WEB", "SHOPPING", "VIDEOS", "IMAGES"};
	private static final String[] OPTIONS = {"OPTION 1", "OPTION 2", "OPTION 3"};
	private static final String[] USER_PROFILE_TEXT = {"Sed aliquam ultrices mauris", "Morbi nec metus", "Fusce a quam"};

	@BeforeClass
	public static void before() {
		tabsPage.open();
		waitCondition(() -> tabsPage.isOpened());
		tabsPage.checkOpened();
		resizeWindow(1920, 1080);
	}

	// @todo #5298 Delete window resize and restore window, check the tests
	@AfterClass
	public static void after() {
		fullscreen();
	}

	@Test(description = "Test checks that tab is selected", dataProviderClass = TabsTestsDataProvider.class,
			dataProvider = "alignWithTitleTabsTestsData")
	public static void selectTabsTest(int index, String text) {
		alignWithTitleTabs.show();
		alignWithTitleTabs.select(index);
		alignWithTitleTabs.is().selected(index);
		alignWithTitleTabs.get(index).has().text(text);
	}

	@Test(description = "Test checks if tabs are align with title or not")
	public static void alignWithTitleTabsTest() {
		alignWithTitleTabs.show();
		alignWithTitleTabs.is().alignWithTitle();
		centerActiveTabs.show();
		centerActiveTabs.is().notAlignWithTitle();
	}

	@Test(description = "Test checks that tabs are center active")
	public static void centerActiveTabsTest() {
		centerActiveTabs.show();
		centerActiveTabs.select(1);
		waitCondition(() -> centerActiveTabs.navigation().isPreviousButtonDisabled());
		centerActiveTabs.navigation().has().previousButtonDisabled().and().nextButtonActive();
		centerActiveTabs.get(1).is().visible();
		centerActiveTabs.get(17).is().notVisible();
		centerActiveTabs.select(10);
		waitCondition(() -> centerActiveTabs.get(1).isNotVisible() &&
				centerActiveTabs.get(17).isVisible());
		centerActiveTabs.get(1).is().notVisible();
		centerActiveTabs.get(17).is().visible();
	}

	@Test(description = "Test checks tabs custom icons")
	public static void customIconsTabsTest() {
		customIconsTabs.show();
		clickWhileClickable(customIconsTabs.navigation().nextButton());
		clickWhileClickable(customIconsTabs.navigation().previousButton());
		customIconsTabs.icons().get(0).is().visible();
		customIconsTabs.icons().get(0).has().type(ARROW_LEFT_BOLD_BOX_OUTLINE.mdi());
		customIconsTabs.icons().get(1).is().visible();
		customIconsTabs.icons().get(1).has().type(ARROW_RIGHT_BOLD_BOX_OUTLINE.mdi());
	}

	@Test(description = "Test checks if tabs are fixed or not")
	public static void fixedTabsTest() {
		fixedTabs.show();
		fixedTabs.is().fixed();
		growTabs.show();
		growTabs.is().grow();
	}

	@Test(description = "Test checks if tabs are grow or not")
	public static void growTabsTest() {
		growTabs.show();
		growTabs.is().grow();
		iconAndTextTabs.show();
		iconAndTextTabs.is().notGrow();
	}

	@Test(description = "Test checks texts and icons on tabs", dataProviderClass = TabsTestsDataProvider.class,
			dataProvider = "iconsTextTabsTestsData")
	public static void iconsTextTabsTest(int index, String text, String iconType) {
		iconAndTextTabs.show();
		iconAndTextTabs.select(index);
		iconAndTextTabs.get(index).has().text(text);
		iconAndTextTabs.icons().get(index - 1).has().type(iconType);
	}

	@Test(description = "Test checks if tabs are right or not")
	public static void rightTabsTest() {
		rightTabs.show();
		rightTabs.show();
		rightTabs.is().right();
		verticalTabs.show();
		verticalTabs.show();
		verticalTabs.is().notRight();
	}

	@Test(description = "Test checks if tabs are vertical or not")
	public static void verticalTabsTest() {
		verticalTabs.show();
		verticalTabs.is().vertical();
		for (int opt = 0; opt <= OPTIONS.length - 1; opt++) {
			int finalOpt = opt;
			verticalTabs.select(finalOpt + 1);
			waitCondition(() -> verticalTabs.icons().get(finalOpt).isVisible());
			verticalTabs.icons().get(finalOpt).is().visible();
			waitCondition(() -> verticalTabs.getTabTextContent().contains(USER_PROFILE_TEXT[finalOpt]));
			verticalTabs.has().tabTextContentContains(USER_PROFILE_TEXT[finalOpt]);
			verticalTabs.get(opt + 1).has().text(OPTIONS[finalOpt]);
		}
		contentTabs.is().notVertical();
	}

	@Test(description = "Test checks tabs content")
	public static void contentTabsTest() {
		contentTabs.show();
		contentTabs.has().values(equalTo(asList("ITEM 1", "ITEM 2", "ITEM 3")));
		contentTabs.has().tabTextContentContains("Lorem ipsum dolor sit amet");
	}

	@Test(description = "Test checks tab addition and removal for dynamic tabs")
	public static void dynamicTabsTest() {
		dynamicTabs.show();
		dynamicTabs.is().tabExist(15);
		dynamicTabs.is().tabNotExist(16);
		addButton.is().enabled().and().has().text("ADD TAB");
		addButton.click();
		dynamicTabs.is().tabExist(16);
		removeButton.is().enabled().and().has().text("REMOVE TAB");
		removeButton.click();
		dynamicTabs.is().tabNotExist(16);
	}

	@Test(description = "Test checks tabs with menu")
	public static void overflowToMenuTabsTest() {
		overflowToMenuTabs.show();
		for (int i = 1; i <= OVERFLOW_TAB_DATA.length; i++) {
			overflowToMenuTabs.select(i);
			overflowToMenuTabs.get(i).has().text(OVERFLOW_TAB_DATA[i - 1]);
		}
		for (int i = 1; i <= 5; i++) {
			overflowToMenuTabs.menuButton().get(0).click();
			overflowToMenuTabs.menu().is().visible();
			overflowToMenuTabs.menu().select(i);
		}
	}

	@Test(description = "Test checks tabs color : Color, Background color")
	public static void colorTabsTest() {
		dynamicTabs.show();
		dynamicTabs.has().color(WHITE.value());
		dynamicTabs.has().backgroundColor(RED_LIGHTEN_2.value());
	}

	@Test(description = "Test checks tabs theme : Theme (dark/light)")
	public static void themeTabsTest() {
		dynamicTabs.show();
		dynamicTabs.has().darkTheme();
		growTabs.show();
		growTabs.has().lightTheme();
	}

	@Test(description = "Test checks tab slider's size and color : Slider size, Slider color")
	public static void tabSliderTabsTest() {
		verticalTabs.show();
		verticalTabs.has().tabSliderSizePx(4);
		verticalTabs.has().tabSliderColor(BLUE_DARKEN_2.value());
	}

	@Test(description = "Test checks tab slider's size and color : Slider size, Slider color")
	public static void disabledTabsTest() {
		disabledTabs.show();
		disabledTabs.is().tabDisabled(2);
		disabledTabs.is().tabEnabled(3);
	}

	@Test(description = "Test checks tab's href : href")
	public static void withHrefTabsTest() {
		hrefTabs.show();
		hrefTabs.has().tabHref(2);
		hrefTabs.has().tabHref(2, "https://jdi-testing.github.io/jdi-light/vuetify/#/tabs?tab=two");
		disabledTabs.has().noTabHref(1);
	}

	@Test(description = "Test checks if tabs show arrows or not")
	public static void showArrowsTabsTest() {
		paginationTabs.show();
		paginationTabs.is().showArrows();
		rightTabs.show();
		rightTabs.is().notShowArrows();
	}

	private static void clickWhileClickable(VuetifyButton element) {
		if (element.isExist()) {
			while (!element.attr("class").contains("disabled")) {
				element.click();
			}
		}
	}
}
