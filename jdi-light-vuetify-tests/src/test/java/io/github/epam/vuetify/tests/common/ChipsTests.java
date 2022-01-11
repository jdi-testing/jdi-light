package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Chip;
import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.StaticSite.chipsPage;
import static io.github.com.pages.ChipsPage.actionChips;
import static io.github.com.pages.ChipsPage.closableChips;
import static io.github.com.pages.ChipsPage.coloredChips;
import static io.github.com.pages.ChipsPage.customListChipsList;
import static io.github.com.pages.ChipsPage.customListItems;
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
        chipsPage.checkOpened();
    }

    @Test
    public void closableChipTests() {
        Chip closableChip = closableChips.get(1);
        closableChip.is().displayed();
        closableChip.close();
        closableChip.is().hidden();
    }

    @Test
    public void coloredChipTests() {
        coloredChips.get(1).has().backgroundColor(Colors.GREY_LIGHTEN_2.value());
    }

    @Test
    public void draggableChipTests() {
        draggableChip.is().draggable();
    }

    @Test
    public void filterChipTests() {
        Chip filterChip = filterChips.get(1);
        filterChip.is().notActive();

        filterSwitchLabel.click();
        filterChip.is().active();
        filterChip.has().filterIconDisplayed();
    }

    @Test
    public void labelChipTests() {
        labelChips.get(1).is().label();
    }

    @Test
    public void outlinedChipTests() {
        String expectedRgbColorCode = "76, 175, 80";
        Chip outlinedChip = outlinedChips.get(1);

        outlinedChip.has().visibleBorder();
        outlinedChip.has().borderColor(expectedRgbColorCode);
        outlinedChip.has().fontColor(expectedRgbColorCode);
    }

    @Test
    public void sizesChipTests() {
        int expectedFontSize = 10;
        int expectedHeight = 16;
        sizesChips.get(1).has().fontSize(expectedFontSize);
        sizesChips.get(1).has().height(expectedHeight);
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
        iconChips.get(1).has().icon();
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
    public void inSelectChipTests() {
        String expectedBoldText = "Programming";
        String expectedRegularText = "(interest)";
        String expectedFullChipText = format("%s %s", expectedBoldText, expectedRegularText);
        Chip testedChip = inSelectsChips.get(1);

        testedChip.is().compositeLabelContainsText(expectedFullChipText);
        testedChip.is().compositeLabelBoldTextContains(expectedBoldText);
        testedChip.is().compositeLabelRegularTextContains(expectedRegularText);
    }
}
