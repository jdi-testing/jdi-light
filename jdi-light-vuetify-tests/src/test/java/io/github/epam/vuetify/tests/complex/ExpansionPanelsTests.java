package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanel;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanels;
import io.github.com.custom.panels.LocationExpansionPanel;
import io.github.com.custom.panels.TripExpansionPanel;
import io.github.com.custom.panels.TripTimeExpansionPanel;
import io.github.com.dataproviders.ExpansionPanelsDataProviders;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.expansionPanelsPage;
import static io.github.com.enums.Colors.BLUE;
import static io.github.com.enums.Colors.BLUE_LIGHTEN_2;
import static io.github.com.enums.Colors.WHITE;
//import static io.github.com.enums.MdiIcons.ALERT_CIRCLE;
//import static io.github.com.enums.MdiIcons.CHECK;
//import static io.github.com.enums.MdiIcons.CHEVRON_DOWN;
import static io.github.com.pages.ExpansionPanelsPage.accordionExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.advancedExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.customIconExpansionPanelsDifferentIcons;
import static io.github.com.pages.ExpansionPanelsPage.disableCheckbox;
import static io.github.com.pages.ExpansionPanelsPage.disabledExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.flatExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.focusableExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.insetExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.modelExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.popOutExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.readOnlyCheckbox;
import static io.github.com.pages.ExpansionPanelsPage.readOnlyExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.tileExpansionPanels;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ExpansionPanelsTests extends TestsInit {
    private static final String LOREM_IPSUM_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
            "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";

    @BeforeClass
    public void before() {
        expansionPanelsPage.open();
        waitCondition(() -> expansionPanelsPage.isOpened());
        expansionPanelsPage.checkOpened();
    }

    @Test(description = "Test checks expansion panel texts",
            dataProvider = "simpleExpansionPanelsWithOnlyOneOpenPanelData",
            dataProviderClass = ExpansionPanelsDataProviders.class
    )
    public void textExpansionPanels(ExpansionPanels panels) {
        panels.show();
        for (ExpansionPanel expansionPanel : panels.panels()) {
            expansionPanel.expand();
            expansionPanel.header().has().text(containsString("It"));
            expansionPanel.header().has().text("Item");
            expansionPanel.content().has().text(LOREM_IPSUM_TEXT);
            expansionPanel.is().expanded();
        }
    }

    @Test(description = "Test checks that only one expansion panel can be expanded",
            dataProvider = "simpleExpansionPanelsWithOnlyOneOpenPanelData",
            dataProviderClass = ExpansionPanelsDataProviders.class
    )
    public void oneOpenPanelAtMomentTest(ExpansionPanels panels) {
        panels.show();
        panels.select(1);
        panels.select(2);
        panels.panels().get(0).is().closed();
        panels.panels().get(1).is().expanded();
    }

    @Test(description = "Test checks panel's size",
            dataProvider = "simpleExpansionPanelsWithOnlyOneOpenPanelData",
            dataProviderClass = ExpansionPanelsDataProviders.class
    )
    public void panelsSizeTest(ExpansionPanels panels) {
        panels.show();
        panels.has().size(5);
    }

    @Test(description = "Text checks if expansion panels is disabled or not : disabled (y/n)")
    public void disabledExpansionPanelTest() {
        disabledExpansionPanels.show();
        disableCheckbox.check();
        disabledExpansionPanels.is().disabled();
        disabledExpansionPanels.panels().get(0).is().disabled();
        disableCheckbox.check();
        disabledExpansionPanels.is().enabled();
        disabledExpansionPanels.panels().get(0).is().enabled();
    }

    @Test(description = "Test checks that expansion panel is readonly : readonly (y/n)")
    public void readOnlyExpansionPanelTest() {
        readOnlyExpansionPanels.show();
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

    @Test(description = "Test shows how to work with custom element advanced expansion panels")
    public void advancedExpansionPanelTest() {
        advancedExpansionPanels.has().size(3);

        String tripName = "My trip name";
        TripExpansionPanel tripPanel = advancedExpansionPanels.tripPanel();
        tripPanel.setTripName(tripName);
        waitCondition(() -> !tripPanel.tripNameText().text().equals("Enter a name for the trip"));
        tripPanel.tripNameText().has().text(equalTo(tripName));

        String countryName = "Ecuador";
        LocationExpansionPanel locationPanel = advancedExpansionPanels.locationPanel();
        locationPanel.setLocationName(countryName);
        waitCondition(() -> !locationPanel.tripLocationText().text().equals("Select trip destination"));
        locationPanel.tripLocationText().has().text(equalTo(countryName));

        TripTimeExpansionPanel timePanel = advancedExpansionPanels.tripTimePanel();
        timePanel.startDateText().has().text(equalTo("Start date: Not set"));
        timePanel.endDateText().has().text(equalTo("End date: Not set"));
    }

    @Test(description = "Test checks expansion panel expander class")
    public void differentIconsExpansionPanelTest() {
        customIconExpansionPanelsDifferentIcons.has().size(3);
        List<ExpansionPanel> panels = customIconExpansionPanelsDifferentIcons.panels();
        panels.get(0).expander().has().cssClass("mdi-chevron-down");
        panels.get(1).expander().has().cssClass("mdi-check");
        panels.get(2).expander().has().cssClass("mdi-alert-circle");
    }

    @Test(description = "Test checks expansion panels theme : theme light/dark")
    public void themeExpansionPanels() {
        flatExpansionPanels.show();
        flatExpansionPanels.has().darkTheme();
        tileExpansionPanels.show();
        tileExpansionPanels.has().lightTheme();
    }

    @Test(description = "Test checks if expansion panels are accordion or not : accordion (y/n)")
    public void accordionExpansionPanels() {
        accordionExpansionPanels.show();
        accordionExpansionPanels.is().accordion();
        disabledExpansionPanels.show();
        disabledExpansionPanels.is().notAccordion();
    }

    @Test(description = "Test checks if expansion panels are flat or not : flat (y/n)")
    public void flatExpansionPanels() {
        flatExpansionPanels.show();
        flatExpansionPanels.is().flat();
        tileExpansionPanels.show();
        tileExpansionPanels.is().notFlat();
    }

    @Test(description = "Test checks if expansion panels are focusable or not : focusable (y/n)")
    public void focusableExpansionPanels() {
        insetExpansionPanels.show();
        insetExpansionPanels.is().notFocusable();
        focusableExpansionPanels.show();
        focusableExpansionPanels.is().focusable();
    }

    @Test(description = "Test checks if expansion panels are inset or not : inset (y/n)")
    public void insetExpansionPanels() {
        insetExpansionPanels.show();
        insetExpansionPanels.is().inset();
        modelExpansionPanels.show();
        modelExpansionPanels.is().notInset();
    }

    @Test(description = "Test checks that expansion panels are mandatory : mandatory (y/n)")
    public void mandatoryExpansionPanels() {
        flatExpansionPanels.show();
        flatExpansionPanels.panels().get(0).expand();
        flatExpansionPanels.panels().get(0).is().expanded();
        for(int i = 1; i < flatExpansionPanels.panels().size(); i++) {
            flatExpansionPanels.panels().get(i).close();
            flatExpansionPanels.panels().get(i).is().closed();
        }
        flatExpansionPanels.panels().get(0).close();
        flatExpansionPanels.panels().get(0).is().expanded();
    }

    @Test(description = "Test checks that expansion panels are multiple : multiple (y/n)")
    public void multipleExpansionPanels() {
        flatExpansionPanels.show();
        flatExpansionPanels.panels().get(0).expand();
        flatExpansionPanels.panels().get(0).is().expanded();
        flatExpansionPanels.panels().get(1).expand();
        flatExpansionPanels.panels().get(1).is().expanded();
    }

    @Test(description = "Test checks if expansion panels are popout or not: popout (y/n)")
    public void popoutExpansionPanels() {
        popOutExpansionPanels.show();
        popOutExpansionPanels.is().popout();
        readOnlyExpansionPanels.show();
        readOnlyExpansionPanels.is().notPopout();
    }

    @Test(description = "Test checks is expansion panels are tile or not: tile (y/n)")
    public void tileExpansionPanels() {
        tileExpansionPanels.show();
        tileExpansionPanels.is().tile();
        flatExpansionPanels.show();
        flatExpansionPanels.is().notTile();
    }

    @Test(description = "Test checks that expansion panels are displayed : displayed")
    public void displayedExpansionPanels() {
        tileExpansionPanels.show();
        tileExpansionPanels.is().displayed();
    }

    @Test(description = "Test checks expansion panels color : color")
    public void colorExpansionPanels() {
        flatExpansionPanels.show();
        flatExpansionPanels.panels().get(0).has().backgroundColor(BLUE.value());
        flatExpansionPanels.panels().get(0).has().color(WHITE.value());
        flatExpansionPanels.panels().get(0).has().contentBackgroundColor(BLUE_LIGHTEN_2.value());
        flatExpansionPanels.panels().get(0).has().contentColor(WHITE.value());
    }

    @Test(description = "Test checks if expansion panel's icon rotates or not : disable-icon-rotate (y/n)")
    public void iconRotationExpansionPanels() {
        customIconExpansionPanelsDifferentIcons.show();
        customIconExpansionPanelsDifferentIcons.panels().get(1).has().iconDisableRotate();
        customIconExpansionPanelsDifferentIcons.panels().get(0).has().notIconDisableRotate();
    }
}
