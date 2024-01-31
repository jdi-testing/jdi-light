package io.github.com.custom.elements.dialog;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.complex.Dialog;

public class ActionDialog extends Dialog {

    public String title() {
        return core().find("mat-dialog-title").getText();
    }


    public Button installButton() {
        return new Button().setCore(Button.class, core().find(".mat-mdc-dialog-actions button:last-child"));
    }

    public Button cancelButton() {
        return new Button().setCore(Button.class, core().find(".mat-mdc-dialog-actions button:first-child"));
    }

}
