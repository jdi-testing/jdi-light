package io.github.com.custom.panels;

import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanel;

public class TripExpansionPanel extends ExpansionPanel {

    public Text tripNameText() {
        close();
        return new Text().setCore(Text.class, header().find(".text--secondary span"));
    }

    public void setTripName(String tripName) {
        wrapper().find("input").sendKeys(tripName);
    }

}
