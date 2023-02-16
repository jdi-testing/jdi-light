package io.github.com.custom.panels;

import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanels;

public class AdvancedExpansionPanels extends ExpansionPanels {

    public TripExpansionPanel tripPanel() {
        return new TripExpansionPanel().setCore(TripExpansionPanel.class, get(1));
    }

    public LocationExpansionPanel locationPanel() {
        return new LocationExpansionPanel().setCore(LocationExpansionPanel.class, get(2));
    }

    public TripTimeExpansionPanel tripTimePanel() {
        return new TripTimeExpansionPanel().setCore(TripTimeExpansionPanel.class, get(3));
    }

}
