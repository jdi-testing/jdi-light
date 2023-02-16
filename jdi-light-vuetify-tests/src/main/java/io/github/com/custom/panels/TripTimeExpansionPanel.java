package io.github.com.custom.panels;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanel;

public class TripTimeExpansionPanel extends ExpansionPanel {

    public UIElement startDateText() {
        close();
        return header().find("div.col-6[1]");
    }

    public UIElement endDateText() {
        close();
        return header().find("div.col-6[2]");
    }


}
