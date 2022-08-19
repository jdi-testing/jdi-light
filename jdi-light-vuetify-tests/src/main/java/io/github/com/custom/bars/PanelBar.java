package io.github.com.custom.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import io.github.com.custom.asserts.PanelBarAssert;

public class PanelBar extends UIBaseElement<PanelBarAssert> implements IsText {

    @JDIAction("Get '{name}' get avatar")
    public Avatar avatar() {
        return new Avatar().setCore(Avatar.class, core().find(".v-avatar"));
    }

    @JDIAction("Get '{name}' get avatar text")
    public String avatarText() {
        return core().find("//strong").getText();
    }

    @JDIAction("Get '{name}' get gray avatar text")
    public String greyText() {
        return core().find(".grey--text").getText();
    }

    @JDIAction("Get '{name}' notification text")
    public String textNotification() {
        return core().find(".text-no-wrap > strong").getText();
    }

    @JDIAction("Get '{name}' notification count")
    public String cntNotification() {
        return core().find(".v-chip__content").getText();
    }

    @Override
    public PanelBarAssert is() {
        return new PanelBarAssert().set(this);
    }
}
