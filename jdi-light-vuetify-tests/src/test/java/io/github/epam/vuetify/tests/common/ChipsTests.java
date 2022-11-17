package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Chip;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.chipsPage;
import static io.github.com.enums.Colors.GREEN;
import static io.github.com.enums.Colors.GREEN_ACCENT_5;
import static io.github.com.enums.Colors.TRANSPARENT;
import static io.github.com.pages.ChipsPage.actionChips;
import static io.github.com.pages.ChipsPage.closableChips;
import static io.github.com.pages.ChipsPage.coloredChips;
import static io.github.com.pages.ChipsPage.customListChipsList;
import static io.github.com.pages.ChipsPage.customListItems;
import static io.github.com.pages.ChipsPage.darkChip;
import static io.github.com.pages.ChipsPage.darkSwitch;
import static io.github.com.pages.ChipsPage.disableSwitch;
import static io.github.com.pages.ChipsPage.disabledChip;
import static io.github.com.pages.ChipsPage.draggableChip;
import static io.github.com.pages.ChipsPage.expandableChip;
import static io.github.com.pages.ChipsPage.expandableMenu;
import static io.github.com.pages.ChipsPage.expandableMenuItems;
import static io.github.com.pages.ChipsPage.filterChips;
import static io.github.com.pages.ChipsPage.filterSwitchLabel;
import static io.github.com.pages.ChipsPage.iconChips;
import static io.github.com.pages.ChipsPage.inSelectsChips;
import static io.github.com.pages.ChipsPage.labelChips;
import static io.github.com.pages.ChipsPage.outlinedChips;
import static io.github.com.pages.ChipsPage.sizesChips;
import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChipsTests extends TestsInit {

    @BeforeClass
    public void before() {
        chipsPage.open();
        waitCondition(() -> chipsPage.isOpened());
        chipsPage.checkOpened();
    }

    @Test
    public void closableChipTests() {
        Chip closableChip = closableChips.get(1);
        Chip greyChip = coloredChips.get(1);
        closableChip.show();
        closableChip.is().displayed().and().removable();
        closableChip.close();
        closableChip.is().hidden();
        greyChip.show();
        greyChip.is().notRemovable();
    }

    @Test
    public void coloredChipTests() {
        Chip outlinedChip = outlinedChips.get(1);
        outlinedChip.show();
        outlinedChip.has().borderColor(GREEN_ACCENT_5.value());
        outlinedChip.has().backgroundColor(TRANSPARENT.value());
        outlinedChip.has().color(GREEN.value());
    }

    @Test
    public void draggableChipTests() {
        Chip filterChip = filterChips.get(1);
        draggableChip.show();
        draggableChip.is().draggable();
        filterChip.show();
        filterChip.is().notDraggable();
    }

    @Test
    public void filterChipTests() {
        Chip filterChip = filterChips.get(1);
        filterChip.show();
        filterChip.is().deselected();
        filterSwitchLabel.click();
        filterChip.is().selected();
        filterChip.has().filterIconDisplayed();
    }

    @Test
    public void labelChipTests() {
        Chip labelChip = labelChips.get(1);
        Chip outlinedChip = outlinedChips.get(1);
        labelChip.show();
        labelChip.is().label();
        outlinedChip.show();
        outlinedChip.is().notLabel();
    }

    @Test
    public void outlinedChipTests() {
        Chip outlinedChip = outlinedChips.get(1);
        Chip sizeChip = sizesChips.get(1);
        outlinedChip.show();
        outlinedChip.is().outlined();
        sizeChip.is().notOutlined();
    }

    @Test
    public void sizesChipTests() {
        int expectedFontSize = 10;
        int expectedHeight = 16;
        sizesChips.get(1).show();
        sizesChips.get(1).has().fontSize(expectedFontSize);
        sizesChips.get(1).has().height(expectedHeight);
        sizesChips.get(1).has().xSmallSize();
        sizesChips.get(2).has().smallSize();
        sizesChips.get(3).has().defaultSize();
        sizesChips.get(4).has().largeSize();
        sizesChips.get(5).has().xLargeSize();
    }

    @Test
    public void actionChipTests() {
        String expectedAlertMessage = "Toggling lights...";
        actionChips.get(1).click();
        assertThat(getDriver().switchTo().alert().getText(), Matchers.containsString(expectedAlertMessage));
        getDriver().switchTo().alert().accept();
    }

    @Test
    public void iconChipTests() {
        Chip iconChip = iconChips.get(1);
        iconChip.show();
        iconChip.has().icon();
    }

    @Test
    public void customListChipTests() {
        assertThat(customListChipsList.isEmpty(), Matchers.is(true));
        customListItems.get(1).click();
        customListChipsList.get(1).is().containsText("Nature");
    }

    @Test
    public void expandableChipTests() {
        assertThat(expandableMenu.isNotDisplayed(), Matchers.is(true));
        expandableChip.has().image();
        expandableChip.click();
        waitCondition(() -> expandableMenu.isDisplayed());
        assertThat(expandableMenu.isDisplayed(), Matchers.is(true));
        expandableMenuItems.get(1).click(); // collapse menu just to be safe
    }

    @Test
    public void labelTextChipTests() {
        String expectedBoldText = "Programming";
        String expectedRegularText = "(interest)";
        String expectedFullChipText = format("%s %s", expectedBoldText, expectedRegularText);
        Chip compositeLabelChip = inSelectsChips.get(1);
        compositeLabelChip.show();
        compositeLabelChip.is().compositeLabelContainsText(expectedFullChipText);
        compositeLabelChip.is().compositeLabelBoldTextContains(expectedBoldText);
        compositeLabelChip.is().compositeLabelRegularTextContains(expectedRegularText);
        disabledChip.show();
        disabledChip.is().containsText("Disabled");
    }

    @Test
    public void disabledChipTests() {
        disabledChip.show();
        disabledChip.is().enabled();
        disableSwitch.check();
        disabledChip.is().disabled();
    }

    @Test
    public void themeChipTests() {
        darkChip.show();
        darkChip.has().lightTheme();
        darkSwitch.check();
        darkChip.has().darkTheme();
        darkSwitch.uncheck();
    }

    @Test
    public void pillChipTests() {
        Chip pillChip = outlinedChips.get(2);
        Chip notPillChip = outlinedChips.get(3);
        pillChip.show();
        pillChip.is().pill();
        notPillChip.is().notPill();
    }
}
