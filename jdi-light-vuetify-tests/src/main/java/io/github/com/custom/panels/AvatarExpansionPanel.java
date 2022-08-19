package io.github.com.custom.panels;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanel;
import io.github.com.custom.bars.PanelBar;

public class AvatarExpansionPanel extends ExpansionPanel {

    private static final String panelBar = ".row";

    @JDIAction("Get '{name}' panel bar")
    public PanelBar panelBar() {
        return new PanelBar().setCore(PanelBar.class, core().find(panelBar));
    }
}
