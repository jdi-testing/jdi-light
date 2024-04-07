package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Chip;
import io.github.com.custom.chips.CompositeLabelChip;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.chipsPage;
import static io.github.com.enums.Colors.BLUE_ACCENT_6;
import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.WHITE;
import static io.github.com.pages.ChipsPage.actionChips;
import static io.github.com.pages.ChipsPage.avatarChip;
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

    @Test (description = "Test checks removable feature")
    public void closableChipTests() {
        Chip closableChip = closableChips.get(1);
        Chip greyChip = coloredChips.get(1);
        closableChip.show();
        closableChip.is().displayed()
                .and().removable();
        closableChip.close();
        closableChip.is().hidden();
        greyChip.show();
        greyChip.is().notRemovable();
    }

    @Test (description = "Test checks colors")
    public void coloredChipTests() {
        Chip coloredChip = coloredChips.get(2);
        coloredChip.show();
        coloredChip.has().borderColor(BLUE_ACCENT_6.value())
                .and().backgroundColor(BLUE_DARKEN_2.value())
                .and().color(WHITE.value());
    }

    @Test (description = "Test checks draggable feature")
    public void draggableChipTests() {
        Chip filterChip = filterChips.get(1);
        draggableChip.show();
        draggableChip.is().draggable();
        filterChip.show();
        filterChip.is().notDraggable();
    }

    @Test (description = "Test checks filtering feature")
    public void filterChipTests() {
        Chip filterChip = filterChips.get(1);
        filterChip.show();
        filterChip.is().deselected();
        filterSwitchLabel.click();
        filterChip.is().selected();
        filterChip.has().filterIconDisplayed();
    }

    @Test (description = "Test checks that chip is label or not")
    public void labelChipTests() {
        Chip labelChip = labelChips.get(1);
        Chip outlinedChip = outlinedChips.get(1);
        labelChip.show();
        labelChip.is().label();
        outlinedChip.show();
        outlinedChip.is().notLabel();
    }

    @Test (description = "Test checks outlined feature")
    public void outlinedChipTests() {
        Chip outlinedChip = outlinedChips.get(1);
        Chip sizeChip = sizesChips.get(1);
        outlinedChip.show();
        outlinedChip.is().outlined();
        sizeChip.is().notOutlined();
    }

    @Test (description = "Text checks chip sizes")
    public void sizesChipTests() {
        int expectedFontSize = 10;
        int expectedHeight = 16;
        Chip sizeChip = sizesChips.get(1);
        sizeChip.show();
        sizeChip.has().height(expectedHeight)
                .and().xSmallSize();
        sizesChips.get(2).has().smallSize();
        sizesChips.get(3).has().defaultSize();
        sizesChips.get(4).has().largeSize();
        sizesChips.get(5).has().xLargeSize();
    }

    @Test (description = "Test checks chip actions")
    public void actionChipTests() {
        String expectedAlertMessage = "Toggling lights...";
        actionChips.get(1).click();
        assertThat(getDriver().switchTo().alert().getText(), Matchers.containsString(expectedAlertMessage));
        getDriver().switchTo().alert().accept();
    }

    @Test(description = "Test checks that chip has icon")
    public void iconChipTests() {
        Chip iconChip = iconChips.get(1);
        iconChip.show();
        iconChip.has().icon();
    }

    @Test(description = "Test checks that chip has avatar with size and text")
    public void avatarChipTests() {
        avatarChip.show();
        avatarChip.getAvatar().has().size(24)
                .and().text("1");
        avatarChip.has().text("Years");
    }

    @Test(description = "Test checks that when we click on the list-item chip with proper text appears")
    public void customListChipTests() {
        assertThat(customListChipsList.isEmpty(), Matchers.is(true));
        customListItems.get(1).click();
        customListChipsList.get(1).has().text("Nature");
    }

    @Test(description = "Test checks that, when we click on expandable chip, menu options are appearing")
    public void expandableChipTests() {
        expandableChip.show();
        expandableMenu.is().notVisible();
        expandableChip.has().image();
        expandableChip.getAvatar().has().height(32);
        expandableChip.click();
        waitCondition(() -> expandableMenu.isDisplayed());
        expandableMenu.is().displayed();
        expandableMenu.select(1);
    }

    @Test (description = "Test checks custom labels")
    public void customLabelTextChipTests() {
        String expectedBoldText = "Programming";
        String expectedRegularText = "(interest)";
        String expectedFullChipText = format("%s %s", expectedBoldText, expectedRegularText);
        CompositeLabelChip compositeLabelChip = inSelectsChips.get(1);
        compositeLabelChip.show();
        compositeLabelChip.has().text(expectedFullChipText);
        compositeLabelChip.is().containsBoldText(expectedBoldText);
        compositeLabelChip.is().containsRegularText(expectedRegularText);
        disabledChip.show();
        disabledChip.has().text("Disabled");
    }

    @Test (description = "Test checks disabled feature")
    public void disabledChipTests() {
        disabledChip.show();
        disabledChip.is().enabled();
        disableSwitch.check();
        disabledChip.is().disabled();
    }

    @Test (description = "Test checks theme")
    public void themeChipTests() {
        darkChip.show();
        darkChip.has().lightTheme();
        darkSwitch.check();
        darkChip.has().darkTheme();
        darkSwitch.uncheck();
    }

    @Test (description = "Test checks pill feature")
    public void pillChipTests() {
        Chip pillChip = outlinedChips.get(2);
        Chip notPillChip = outlinedChips.get(3);
        pillChip.show();
        pillChip.is().pill();
        notPillChip.is().notPill();
    }
}
