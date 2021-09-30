package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanel;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanels;
import io.github.com.custom.panels.LocationExpansionPanel;
import io.github.com.custom.panels.TripExpansionPanel;
import io.github.com.custom.panels.TripTimeExpansionPanel;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.expansionPanelsPage;
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
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ExpansionPanelsTest extends TestsInit {

    private static final String LOREM_IPSUM_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
            "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";

    @BeforeSuite
    public void before() {
        expansionPanelsPage.open();
        expansionPanelsPage.checkOpened();
    }

    @DataProvider
    public static Object[][] simpleExpansionPanelsWithOnlyOneOpenPanelData() {
        return new Object[][]{
                {accordionExpansionPanels, 5, "Item", LOREM_IPSUM_TEXT},
                {insetExpansionPanels, 5, "Item", LOREM_IPSUM_TEXT},
                {focusableExpansionPanels, 5, "Item", LOREM_IPSUM_TEXT},
                {popOutExpansionPanels, 5, "Item", LOREM_IPSUM_TEXT}
        };
    }

    @Test(dataProvider = "simpleExpansionPanelsWithOnlyOneOpenPanelData")
    public void simpleTestWithOnlyOneOpenPanelAtMoment(ExpansionPanels panels, int size, String header, String content) {
        panels.has().size(size);
        for (ExpansionPanel expansionPanel : panels.panels()) {
            expansionPanel.expand();
            expansionPanel.header().has().text(header);
            expansionPanel.wrapper().has().text(content);
            expansionPanel.expander().has().cssClass("mdi-chevron-down");
            expansionPanel.is().expanded();
        }
        panels.select(1);
        panels.select(2);
        panels.panels().get(0).is().closed();
        panels.panels().get(1).is().expanded();
    }

    @Test
    public void disabledExpansionPanelTest() {
        disabledExpansionPanels.has().size(3);

        disabledExpansionPanels.panels().get(0).is().expanded();
        disabledExpansionPanels.panels().get(1).is().expanded();
        disabledExpansionPanels.panels().get(2).is().closed();
        disabledExpansionPanels.select(3);
        disabledExpansionPanels.panels().get(2).is().expanded();

        disableCheckbox.check();
        disabledExpansionPanels.is().disabled();
        disableCheckbox.check();
        disabledExpansionPanels.is().enabled();
    }

    @Test
    public void modelExpansionPanelTest(){
        modelExpansionPanels.has().size(5);
        for (ExpansionPanel expansionPanel : modelExpansionPanels.panels()) {
            expansionPanel.header().has().text(containsString("Header"));
            expansionPanel.wrapper().has().text(LOREM_IPSUM_TEXT);
            expansionPanel.is().expanded();
        }
        openPanelText.is().text("[ 0, 1, 2, 3, 4 ]");
        modelExpansionPanels.panels().forEach(expansionPanel -> expansionPanel.is().expanded());
        noneButton.click();
        openPanelText.is().text("[]");
        modelExpansionPanels.panels().forEach(expansionPanel -> expansionPanel.is().closed());
        allButton.click();
        openPanelText.is().text("[ 0, 1, 2, 3, 4 ]");
        modelExpansionPanels.panels().forEach(expansionPanel -> expansionPanel.is().expanded());
    }

    @Test
    public void readOnlyExpansionPanelTest() {
        readOnlyExpansionPanels.has().size(3);
        List<ExpansionPanel> panels = readOnlyExpansionPanels.panels();
        panels.get(0).is().expanded();
        panels.get(1).is().expanded();
        panels.get(2).is().closed();

        readOnlyCheckbox.check();
        panels.forEach(ExpansionPanel::expand);
        panels.get(0).is().expanded();
        panels.get(1).is().expanded();
        panels.get(2).is().closed();

        readOnlyCheckbox.check();
        for (ExpansionPanel expansionPanel : panels) {
            expansionPanel.expand();
            expansionPanel.is().expanded();
        }
    }

    @Test
    public void advancedExpansionPanelTest() {
        advancedExpansionPanels.has().size(3);

        String tripName = "My trip name";
        TripExpansionPanel tripPanel = advancedExpansionPanels.tripPanel();
        tripPanel.setTripName(tripName);
        tripPanel.tripNameText().has().text(equalTo(tripName));

        String countryName = "Ecuador";
        LocationExpansionPanel locationPanel = advancedExpansionPanels.locationPanel();
        locationPanel.setLocationName(countryName);
        locationPanel.tripLocationText().has().text(equalTo(countryName));

        TripTimeExpansionPanel timePanel = advancedExpansionPanels.tripTimePanel();
        timePanel.startDateText().has().text(equalTo("Start date: Not set"));
        timePanel.endDateText().has().text(equalTo("End date: Not set"));
    }

    @Test
    public void customIconExpansionPanelTest() {
        customIconExpansionPanelsSameIcons.has().size(5);
        for (ExpansionPanel expansionPanel : customIconExpansionPanelsSameIcons.panels()) {
            expansionPanel.header().has().text("Item");
            expansionPanel.wrapper().has().text(LOREM_IPSUM_TEXT);
            expansionPanel.is().expanded();
            expansionPanel.expander().is().displayed();
            expansionPanel.expander().has().cssClass("mdi-menu-down");
        }
    }

    @Test
    public void differentIconExpansionPanelTest() {
        customIconExpansionPanelsDifferentIcons.has().size(3);
        List<ExpansionPanel> panels = customIconExpansionPanelsDifferentIcons.panels();
        panels.get(0).expander().has().cssClass("mdi-chevron-down");
        panels.get(1).expander().has().cssClass("mdi-check");
        panels.get(2).expander().has().cssClass("mdi-alert-circle");
    }

}
