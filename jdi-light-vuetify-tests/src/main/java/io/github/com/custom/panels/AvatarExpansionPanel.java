package io.github.com.custom.panels;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanel;
import io.github.com.custom.bars.PanelBar;

public class AvatarExpansionPanel extends ExpansionPanel {
    @UI(".row")
    private PanelBar panelBar;

    public PanelBar panelBar() {
        return panelBar;
    }
}
