package io.github.com.custom.panels;

import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanel;

public class LocationExpansionPanel extends ExpansionPanel {

    public Text tripLocationText() {
        close();
        return new Text().setCore(Text.class, header().find(".text--secondary span"));
    }

    public void setLocationName(String tripName) {
        wrapper().find("input").sendKeys(tripName);
    }

}
