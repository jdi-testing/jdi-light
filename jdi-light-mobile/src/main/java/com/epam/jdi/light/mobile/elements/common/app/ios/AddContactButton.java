package com.epam.jdi.light.mobile.elements.common.app.ios;

import com.epam.jdi.light.mobile.elements.common.app.Button;

public class AddContactButton extends Button {

    public void openContacts() {
        core().tap();
    }
}
