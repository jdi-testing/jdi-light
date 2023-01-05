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
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsFlat;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BasicBar<T extends BasicBar<?, ?>, A extends BasicBarAssert<?, ?>> extends UIBaseElement<A>
        implements IsText, HasColor, IsFlat, IsDense, IsShaped, IsOutlined, HasElevation, HasTheme, HasRounded {

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
        return new Text().setCore(Text.class, find(".v-toolbar__title, .v-app-bar-title__content"));
    }

    @JDIAction("Get '{name}' header")
    public UIElement getHeader() {
        return find("header");
    }

    public List<VuetifyButton> buttons() {
        return finds("div button").stream().map(VuetifyButton::new).collect(Collectors.toList());
    }

    public List<UIElement> fields() {
        return finds("div div");
    }

    public VuetifyButton findIconButton(String buttonLocator) {
        return new VuetifyButton(find(String.format("//i[contains(@class, '%s')]/ancestor::button", buttonLocator)));
    }

    public Icon castToIcon(UIElement element) {
        return new Icon().setCore(Icon.class, element);
    }

    @JDIAction("Check that '{name}' is extended")
    public boolean isExtended() {
        return core().attr("class").contains("-extended");
    }

    @JDIAction("Check that '{name}' is floating")
    public boolean isFloating() {
        return core().attr("class").contains("-floating");
    }

    @JDIAction("Check that '{name}' is prominent")
    public boolean isProminent() {
        return core().attr("class").contains("-prominent");
    }
}
