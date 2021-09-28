package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.elements.complex.ExpansionPanels;
import io.github.com.StaticSite;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.pages.ExpansionPanelsPage.accordionExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.advancedExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.allButton;
import static io.github.com.pages.ExpansionPanelsPage.customIconExpansionPanelsDifferentIcons;
import static io.github.com.pages.ExpansionPanelsPage.customIconExpansionPanelsSameIcons;
import static io.github.com.pages.ExpansionPanelsPage.disableCheckbox;
import static io.github.com.pages.ExpansionPanelsPage.disabledExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.focusableExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.insetExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.modelExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.noneButton;
import static io.github.com.pages.ExpansionPanelsPage.openPanelText;
import static io.github.com.pages.ExpansionPanelsPage.popOutExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.readOnlyCheckbox;
import static io.github.com.pages.ExpansionPanelsPage.readOnlyExpansionPanels;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ExpansionPanelsTest extends TestsInit {

    private static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
            "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";

    @BeforeSuite
    public void before() {
        StaticSite.expansionPanelsPage.open();
        StaticSite.expansionPanelsPage.checkOpened();
    }

    @DataProvider
    public static Object[][] simpleExpansionPanelsWithOnlyOneOpenPanelData() {
        return new Object[][]{
                {accordionExpansionPanels, 5, "Item", TEXT},
                {insetExpansionPanels, 5, "Item", TEXT},
                {focusableExpansionPanels, 5, "Item", TEXT},
                {popOutExpansionPanels, 5, "Item", TEXT}
        };
    }

    @Test(dataProvider = "simpleExpansionPanelsWithOnlyOneOpenPanelData")
    public void simpleTestWithOnlyOneOpenPanelAtMoment(ExpansionPanels panels, int size, String header, String content) {
        panels.has().size(size);
        panels.panels().forEach(expansionPanel -> {
            expansionPanel.open();
            expansionPanel.getHeader().has().text(header);
            expansionPanel.getWrapper().has().text(content);
            expansionPanel.getIcon()
                    .is().displayed()
                    .has().cssClass("mdi-chevron-down");
            expansionPanel
                    .is().open()
                    .is().displayed();
        });
        panels.select(1);
        panels.select(2);
        panels.panels().get(0).is().closed();
        panels.panels().get(1).is().open();
    }

    @Test
    public void disabledExpansionPanelTest() {
        disabledExpansionPanels.has().size(3);

        disabledExpansionPanels.panels().get(0).is().open();
        disabledExpansionPanels.panels().get(1).is().open();
        disabledExpansionPanels.panels().get(2).is().closed();
        disabledExpansionPanels.select(3);
        disabledExpansionPanels.panels().get(2).is().open();

        disableCheckbox.check();
        disabledExpansionPanels.is().disabled();
        disableCheckbox.check();
        disabledExpansionPanels.is().enabled();
    }

    @Test
    public void modelExpansionPanelTest(){
        modelExpansionPanels.has().size(5);
        modelExpansionPanels.panels().forEach(expansionPanel -> {
            expansionPanel.getHeader().has().text(containsString("Header"));
            expansionPanel.getWrapper().has().text(TEXT);
            expansionPanel.is().open();
        });
        openPanelText.is().text("[ 0, 1, 2, 3, 4 ]");
        modelExpansionPanels.panels().forEach(expansionPanel -> expansionPanel.is().open());
        noneButton.click();
        openPanelText.is().text("[]");
        modelExpansionPanels.panels().forEach(expansionPanel -> expansionPanel.is().closed());
        allButton.click();
        openPanelText.is().text("[ 0, 1, 2, 3, 4 ]");
        modelExpansionPanels.panels().forEach(expansionPanel -> expansionPanel.is().open());
    }

    @Test
    public void readOnlyExpansionPanelTest() {
        readOnlyExpansionPanels.has().size(3);
        List<ExpansionPanels.ExpansionPanel> panels = readOnlyExpansionPanels.panels();
        panels.get(0).is().open();
        panels.get(1).is().open();
        panels.get(2).is().closed();

        readOnlyCheckbox.check();
        panels.forEach(ExpansionPanels.ExpansionPanel::open);
        panels.get(0).is().open();
        panels.get(1).is().open();
        panels.get(2).is().closed();

        readOnlyCheckbox.check();
        panels.forEach(expansionPanel -> {
            expansionPanel.open();
            expansionPanel.is().open();
        });
    }

    @Test
    public void advancedExpansionPanelTest() {
        advancedExpansionPanels.has().size(3);
        List<ExpansionPanels.ExpansionPanel> panels = advancedExpansionPanels.panels();

        String tripName = "My trip name";
        panels.get(0)
                .getWrapper()
                .find("input")
                .sendKeys(tripName);
        panels.get(0).close();
        panels.get(0)
                .getHeader()
                .find(".text--secondary span")
                .has().text(equalTo(tripName));

        String countryName = "Ecuador";
        panels.get(1)
                .getWrapper()
                .find(By.tagName("input"))
                .sendKeys(countryName);
        panels.get(1).close();
        panels.get(1)
                .getHeader()
                .find(".text--secondary span")
                .has().text(equalTo(countryName));

        List<String> listWhenClosedExpected = Arrays.asList("Start date: Not set", "End date: Not set");
        panels.get(2).close();
        WebList listWhenClosedActual = panels.get(2)
                .getHeader()
                .finds(".text--secondary div.col-6");
        listWhenClosedActual.has().size(listWhenClosedExpected.size());
        assertThat(listWhenClosedActual.map(UIElement::getText), equalTo(listWhenClosedExpected));
    }

    @Test
    public void customIconExpansionPanelTest() {
        customIconExpansionPanelsSameIcons.has().size(5);
        customIconExpansionPanelsSameIcons.panels().forEach(expansionPanel -> {
            expansionPanel.getHeader().has().text("Item");
            expansionPanel.getWrapper().has().text(TEXT);
            expansionPanel.is().open();
            expansionPanel.getIcon()
                    .is().displayed()
                    .has().cssClass("mdi-menu-down");
        });
    }

    @Test
    public void differentIconExpansionPanelTest() {
        customIconExpansionPanelsDifferentIcons.has().size(3);
        List<ExpansionPanels.ExpansionPanel> panels = customIconExpansionPanelsDifferentIcons.panels();
        panels.get(0).getIcon().has().cssClass("mdi-chevron-down");
        panels.get(1).getIcon().has().cssClass("mdi-check");
        panels.get(2).getIcon().has().cssClass("mdi-alert-circle");
    }

}
