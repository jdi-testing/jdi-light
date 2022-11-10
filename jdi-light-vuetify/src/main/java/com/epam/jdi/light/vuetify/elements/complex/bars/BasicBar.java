package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.asserts.bars.BasicBarAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.interfaces.HasColor;

public abstract class BasicBar<T extends BasicBar<?, ?>, A extends BasicBarAssert<?, ?>> extends UIBaseElement<A>
        implements IsText, HasColor {

    @JDIAction("Check that '{name}' is collapsed")
    public boolean isCollapsed() {
        return attr("class").contains("collapsed");
    }

    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded() {
        return !isCollapsed();
    }

    @JDIAction("Get '{name}' title")
    public Text title() {
        return new Text().setCore(Text.class, find(".v-toolbar__title"));
    }

    @JDIAction("Get '{name}' header")
    public UIElement getHeader() {
        return find("header");
    }

    public VuetifyButton findIconButton(String buttonLocator) {
        return new VuetifyButton(find(String.format("//i[contains(@class, '%s')]/ancestor::button", buttonLocator)));
    }

    public Icon castToIcon(UIElement element) {
        return new Icon().setCore(Icon.class, element);
    }
}
