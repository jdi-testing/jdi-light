package io.github.epam.vuetify.tests.common;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static io.github.com.StaticSite.chipsPage;
import static io.github.com.pages.ChipsPage.actionChips;
import static io.github.com.pages.ChipsPage.closableChips;
import static io.github.com.pages.ChipsPage.closableChipsResetButton;
import static io.github.com.pages.ChipsPage.coloredChips;
import static io.github.com.pages.ChipsPage.customListChip;
import static io.github.com.pages.ChipsPage.customListItems;
import static io.github.com.pages.ChipsPage.customListNextButton;
import static io.github.com.pages.ChipsPage.customListSearchField;
import static io.github.com.pages.ChipsPage.expandableChip;
import static io.github.com.pages.ChipsPage.expandableChipEmails;
import static io.github.com.pages.ChipsPage.filterChips;
import static io.github.com.pages.ChipsPage.filterSwitchLabel;
import static io.github.com.pages.ChipsPage.iconChips;
import static io.github.com.pages.ChipsPage.inSelectsChips;
import static io.github.com.pages.ChipsPage.outlinedChips;
import static io.github.com.pages.ChipsPage.sizesChips;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChipsTests extends TestsInit {

    @BeforeSuite
    public void before() {
        chipsPage.open();
    }

    @Test
    public void closableChipsTest() {
        List<String> chipsLabels = Arrays.asList("Closable", "Remove", "Success", "Complete");
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                closableChips.size() != 0);
        for (int i = 1; i <= chipsLabels.size(); i++) {
            closableChips.get(i).is().containsText(chipsLabels.get(i - 1));
        }
        closableChips.forEach(e -> {
            e.close();
            e.is().notDisplayed();
        });
        closableChipsResetButton.click();
    }

    @Test
    public void coloredChipsTest() {
        List<String> chipsLabels = Arrays.asList("Default", "Primary", "Secondary", "Red Chip", "Green Chip");
        List<String> chipsBackgroundColors = Arrays.asList("rgba(224, 224, 224, 1)", "rgba(25, 118, 210, 1)",
                "rgba(66, 66, 66, 1)", "rgba(244, 67, 54, 1)", "rgba(76, 175, 80, 1)");
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                coloredChips.size() != 0);
        for (int i = 1; i <= chipsLabels.size(); i++) {
            coloredChips.get(i).is().containsText(chipsLabels.get(i - 1));
            coloredChips.get(i).has().backgroundColor(chipsBackgroundColors.get(i - 1));
        }

        for (int i = 2; i <= chipsLabels.size(); i++) {
            coloredChips.get(i).has().notIcon();
            coloredChips.get(i).has().notImage();
        }
    }

    @Test
    public void filterChipsTest() {
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                filterSwitchLabel.isDisplayed());
        filterSwitchLabel.click();
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                filterChips.get(1).hasFilter());
        filterChips.forEach(e -> e.has().filter());
        filterSwitchLabel.click();
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                !filterChips.get(1).hasFilter());
        filterChips.forEach(e -> e.has().notFilter());
    }

    @Test
    public void outlinedChipsTest() {
        List<String> borderColors = Arrays.asList("rgb(76, 175, 80)", "rgb(25, 118, 210)",
                "rgb(98, 0, 234)", "rgb(40, 53, 147)");
        List<String> fontColors = Arrays.asList("rgba(76, 175, 80, 1)", "rgba(25, 118, 210, 1)",
                "rgba(98, 0, 234, 1)", "rgba(40, 53, 147, 1)");
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                outlinedChips.get(1).isDisplayed());
        outlinedChips.forEach(e -> e.has().visibleBorder());
        for (int i = 1; i <= borderColors.size(); i++) {
            outlinedChips.get(i).has().borderColor(borderColors.get(i - 1));
            outlinedChips.get(i).has().fontColor(fontColors.get(i - 1));
        }
    }

    @Test
    public void sizesChipsTest() {
        List<Integer> fontSizes = Arrays.asList(10, 12, 14, 16, 18);
        List<Integer> heights = Arrays.asList(16, 24, 32, 54, 66);
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                sizesChips.size() != 0);
        for (int i = 1; i <= fontSizes.size(); i++) {
            sizesChips.get(i).has().fontSize(fontSizes.get(i - 1));
            sizesChips.get(i).has().height(heights.get(i - 1));
        }
    }

    @Test
    public void actionChipsTest() {
        List<String> alertMessages = Arrays.asList("Toggling lights...", "Turning on alarm...", "Toggling Blinds...");
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                actionChips.size() != 0);
        for (int i = 1; i <= alertMessages.size(); i++) {
            actionChips.get(i).click();
            assertThat(getDriver().switchTo().alert().getText(), Matchers.containsString(alertMessages.get(i - 1)));
            getDriver().switchTo().alert().accept();
        }
    }

    @Test
    public void iconChipsTest() {
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                iconChips.size() != 0);
        iconChips.get(1).show();
        for (int i = 1; i <= iconChips.size() && i != 4; i++) {
            iconChips.get(i).has().icon();
        }
    }

    @Test
    public void customListChipTest() {
        String text = "Nature";
        customListSearchField.sendKeys(text);
        customListItems.get(1).click();
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                customListChip.isDisplayed());
        customListChip.is().containsText(text);
        customListNextButton.click();
    }

    @Test
    public void expandableChipTest() {
        List<String> emails = Arrays.asList("john@vuetifyjs.com", "john@gmail.com");
        expandableChip.has().image();
        expandableChip.click();
        for (int i = 1; i <= emails.size(); i++) {
            expandableChipEmails.get(i).has().text(emails.get(i - 1));
        }
    }

    @Test
    public void inSelectChipsTest() {
        List<String> fullLabel = Arrays.asList("Programming (interest)", "Playing video games (interest)",
                "Watching movies (interest)", "Sleeping (interest)");
        List<String> boldText = Arrays.asList("Programming", "Playing video games",
                "Watching movies", "Sleeping");
        String regularText = "(interest)";
        for (int i = 1; i <= fullLabel.size(); i++) {
            inSelectsChips.get(i).assertThat().compositeLabelContainsText(fullLabel.get(i - 1));
            inSelectsChips.get(i).assertThat().compositeLabelBoldTextContains(boldText.get(i - 1));
            inSelectsChips.get(i).assertThat().compositeLabelRegularTextContains(regularText);
        }
    }
}
