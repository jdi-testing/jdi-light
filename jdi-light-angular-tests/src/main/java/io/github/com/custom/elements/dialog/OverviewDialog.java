package io.github.com.custom.elements.dialog;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.angular.elements.common.Input;
import com.epam.jdi.light.angular.elements.complex.Dialog;

public class OverviewDialog extends Dialog {

    public String title() {
        return core().find("mat-dialog-title").getText();
    }

    public Input inputField() {
        return new Input().setCore(Input.class, core().find("input"));
    }

    public Button okButton() {
        return new Button().setCore(Button.class, core().find(".mat-mdc-dialog-actions button:last-child"));
    }

    public Button noThanksButton() {
        return new Button().setCore(Button.class, core().find(".mat-mdc-dialog-actions button:first-child"));
    }
}
