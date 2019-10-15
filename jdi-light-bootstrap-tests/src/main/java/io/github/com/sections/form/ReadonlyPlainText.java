package io.github.com.sections.form;

import com.epam.jdi.light.asserts.core.IsAssert;
import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class ReadonlyPlainText extends Text implements HasLabel {

    public String getText() {
        return core().getText();
    }


}
