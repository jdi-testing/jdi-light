package io.github.com.sections.form;

import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class ReadonlyPlainText extends Text implements HasLabel {

    public String getText() {
        return core().getText();
    }
}
