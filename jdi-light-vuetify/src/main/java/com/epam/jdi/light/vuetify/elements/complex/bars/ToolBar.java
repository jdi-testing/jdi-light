package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.bars.ToolBarAssert;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.common.Input;

/**
 * To see examples of Tool Bar web elements please visit https://vuetifyjs.com/en/components/toolbars
 */

public class ToolBar extends BasicBar<ToolBar, ToolBarAssert> {

    @JDIAction("Get '{name}'s 'close' button")
    public Button closeButton() {
        return findIconButton("mdi-close");
    }

    @JDIAction("Get '{name}'s 'delete' button")
    public Button deleteButton() {
        return findIconButton("mdi-delete");
    }
    @JDIAction("'{name}' has 'export' button")
    public Button exportButton() {
        return findIconButton("mdi-export");
    }

    @JDIAction("'{name}' has 'GPS' button")
    public Button gpsButton() {
        return findIconButton("mdi-crosshairs-gps");
    }

    @JDIAction("'{name}' has 'apps' button")
    public Button appsButton() {
        return findIconButton("mdi-apps");
    }

    @JDIAction("'{name}' has 'search' icon")
    public Icon searchIcon() {
        return castToIcon(find(".mdi-magnify"));
    }

    public Input input() {
        return new Input().setCore(Input.class, find(".v-input"));
    }

    @JDIAction("Get '{name}'s 'select options' field")
    public UIElement getSelectOptionsField() {
        return find(".v-select__selections");
    }

    @JDIAction("'{name}' has header height")
    public String getHeaderHeight() {
        return getHeader().getAttribute("style");
    }

    @JDIAction("'{name}'s header has color")
    public String getHeaderColor() {
        return getHeader().getCssValue("background-color");
    }

    @JDIAction("'{name}' has selected options")
    public String hasSelectedOptions() {
        return find("input[type=hidden]").getAttribute("value");
    }

    @JDIAction("'{name}' has background image")
    public Image backgroundImage() {
        if(find(".v-image__image").isExist()) {
            return new Image().setCore(Image.class, find(".v-image__image"));
        } else return new Image().setCore(Image.class, find(".v-card--flat"));
    }

    @JDIAction("'{name}' has 'select options' field")
    public boolean hasSelectOptionsField() {
        return getSelectOptionsField().isDisplayed();
    }

    @JDIAction("'{name}'s 'delete' and 'close' buttons are hidden")
    public boolean hasHiddenButtons() {
        return closeButton().isNotExist() && deleteButton().isNotExist();
    }

    @JDIAction("'{name}'s header is collapsed")
    public boolean hasCollapsedHeader() {
        return getHeader().getAttribute("class").contains("collapsed");
    }

    @JDIAction("'{name}'s header is dense")
    public boolean hasDenseHeader() {
        return getHeader().getAttribute("class").contains("dense");
    }

    @JDIAction("'{name}'s header is extended")
    public boolean hasExtendedHeader() {
        return getHeader().getAttribute("class").contains("extended");
    }

    public void collapse() {
        getSelectOptionsField().click(-1, -1);
    }

    public ToolBarAssert is() {
        return new ToolBarAssert().set(this);
    }

    public ToolBarAssert has() {
        return is();
    }
}
