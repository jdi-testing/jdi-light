package io.github.com.custom.cards;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import io.github.com.custom.asserts.MenuCardAssert;

public class AvatarMenuCard extends UIBaseElement<MenuCardAssert> implements IsText {

    private static final String editAccountButton = "//button/span[contains(text(), 'Edit Account')]";
    private static final String disconnectedButton = "//button/span[contains(text(), 'Disconnect')]";
    private static final String emailText = ".text-caption";
    private static final String avatar = ".v-avatar";

    @JDIAction("Get '{name}' edit account button")
    public Button getEditAccountButton() {
        return new Button().setCore(Button.class, core().find(editAccountButton));
    }

    @JDIAction("Get '{name}' disconnected button")
    public Button getDisconnectedButton() {
        return new Button().setCore(Button.class, core().find(disconnectedButton));
    }

    @JDIAction("Get '{name}' get email")
    public String email() {
        return core().find(emailText).getText();
    }

    @JDIAction("Get '{name}' get avatar")
    public Avatar avatar() {
        return new Avatar().setCore(Avatar.class, core().find(avatar));
    }

    @Override
    public MenuCardAssert is() {
        return new MenuCardAssert().set(this);
    }
}
