package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.utils.ModalAssert;
import com.epam.jdi.light.ui.html.elements.common.Text;
import org.openqa.selenium.Keys;

/**
 * Represent modal MUI component on GUI. The modal component provides a solid foundation for creating dialogs, popovers, lightboxes, or whatever else.
 *
 * @see <a href="https://mui.com/components/modal/">Modal MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Modal extends UIBaseElement<ModalAssert> implements IsText {

    /**
     * Gets the title of this modal.
     *
     * @return title of this modal as {@link Text}
     */
    @JDIAction("Get '{name}' title")
    public Text title() {
        return new Text().setCore(Text.class, core().find("h2"));
    }

    /**
     * Gets the description of this modal.
     *
     * @return description of this modal as {@link Text}
     */
    @JDIAction("Get '{name}' description")
    public Text description() {
        return new Text().setCore(Text.class, core().find("p"));
    }

    /**
     * Closes this modal.
     */
    @JDIAction("Close {name}")
    public void close() {
        core().actions((a) -> a.sendKeys(Keys.ESCAPE));
    }

    @Override
    public ModalAssert is() {
        return new ModalAssert().set(this);
    }
}
