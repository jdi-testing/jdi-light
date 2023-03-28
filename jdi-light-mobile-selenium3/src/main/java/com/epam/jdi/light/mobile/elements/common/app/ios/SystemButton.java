package com.epam.jdi.light.mobile.elements.common.app.ios;

import com.epam.jdi.light.mobile.elements.common.app.Button;

public class SystemButton extends Button {

    public void done() {
        core().tap();
    }

    public void cancel() {
        core().tap();
    }

    public void send() {
        core().tap();
    }
}
