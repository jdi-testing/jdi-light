package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextArea;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.com.entities.SupportMessage;

public class SupportMessageForm extends Form<SupportMessage> {

    public TextField supportEmail;
    public TextArea supportMessage;

    public void clear(SupportMessage entity) {
        submit(entity, "clear");
    }
}
