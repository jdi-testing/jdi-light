package io.github.epam.vuetify.tests.common;

import com.epam.jdi.tools.Timer;
import io.github.com.dataproviders.ChipsDataProviders;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

    @BeforeClass
    public void before() {
        chipsPage.open();
    }

    @Test(dataProvider = "closableChipsDataProvider", dataProviderClass = ChipsDataProviders.class)
    public void closableChipsTest(List<String> chipsLabels) {
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

    @Test(dataProvider = "coloredChipsDataProvider", dataProviderClass = ChipsDataProviders.class)
    public void coloredChipsTest(List<String> chipsLabels, List<String> chipsBackgroundColors) {
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

    @Test(dataProvider = "outlinedChipsDataProvider", dataProviderClass = ChipsDataProviders.class)
    public void outlinedChipsTest(List<String> borderColors, List<String> fontColors) {
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                outlinedChips.get(1).isDisplayed());
        outlinedChips.forEach(e -> e.has().visibleBorder());
        for (int i = 1; i <= borderColors.size(); i++) {
            outlinedChips.get(i).has().borderColor(borderColors.get(i - 1));
            outlinedChips.get(i).has().fontColor(fontColors.get(i - 1));
        }
    }

    @Test(dataProvider = "sizesChipsDataProvider", dataProviderClass = ChipsDataProviders.class)
    public void sizesChipsTest(List<Integer> fontSizes, List<Integer> heights) {
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                sizesChips.size() != 0);
        for (int i = 1; i <= fontSizes.size(); i++) {
            sizesChips.get(i).has().fontSize(fontSizes.get(i - 1));
            sizesChips.get(i).has().height(heights.get(i - 1));
        }
    }

    @Test(dataProvider = "actionChipsDataProvider", dataProviderClass = ChipsDataProviders.class)
    public void actionChipsTest(List<String> alertMessages) {
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

    @Test(dataProvider = "customListChipsDataProvider", dataProviderClass = ChipsDataProviders.class)
    public void customListChipTest(String text) {
        customListSearchField.sendKeys(text);
        customListItems.get(1).click();
        new Timer(TIMEOUTS.page.get() * 1000L).getResult(() ->
                customListChip.isDisplayed());
        customListChip.is().containsText(text);
        customListNextButton.click();
    }

    @Test(dataProvider = "expandableChipDataProvider", dataProviderClass = ChipsDataProviders.class)
    public void expandableChipTest(List<String> emails) {
        expandableChip.has().image();
        expandableChip.click();
        for (int i = 1; i <= emails.size(); i++) {
            expandableChipEmails.get(i).has().text(emails.get(i - 1));
        }
    }

    @Test(dataProvider = "inSelectChipsDataProvider", dataProviderClass = ChipsDataProviders.class)
    public void inSelectChipsTest(List<String> fullLabel, List<String> boldText, String regularText) {
        for (int i = 1; i <= fullLabel.size(); i++) {
            inSelectsChips.get(i).assertThat().compositeLabelContainsText(fullLabel.get(i - 1));
            inSelectsChips.get(i).assertThat().compositeLabelBoldTextContains(boldText.get(i - 1));
            inSelectsChips.get(i).assertThat().compositeLabelRegularTextContains(regularText);
        }
    }
}
