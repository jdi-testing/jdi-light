package io.github.com.custom.panels;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanel;

public class AvatarExpansionPanel extends ExpansionPanel {

    private static final String avatar = ".v-avatar";
    private static final String avatarText = "//strong";
    private static final String greyText = ".grey--text";
    private static final String textNotification = ".text-no-wrap > strong";
    private static final String cntNotification = ".text-no-wrap > .v-chip__content";

    @JDIAction("Get '{name}' get avatar")
    public Avatar avatar() {
        return new Avatar().setCore(Avatar.class, core().find(avatar));
    }

    @JDIAction("Get '{name}' get avatar text")
    public String avatarText() {
        return core().find(avatarText).getText();
    }

    @JDIAction("Get '{name}' get gray avatar text")
    public String greyText() {
        return core().find(greyText).getText();
    }

    @JDIAction("Get '{name}' notification text")
    public String textNotification() {
        return core().find(textNotification).getText();
    }

    @JDIAction("Get '{name}' notification count")
    public String cntNotification() {
        return core().find(cntNotification).getText();
    }
}
