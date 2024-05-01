package io.github.com.custom.elements.dialog;

import com.epam.jdi.light.material.elements.feedback.Dialog;
import com.epam.jdi.light.material.elements.inputs.TextField;

public class DialogWithEmail extends Dialog {

    public TextField email() {
        return new TextField().setCore(TextField.class, core().find(".MuiTextField-root"));
    }


}
