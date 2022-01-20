package com.epam.jdi.light.vuetify.elements.complex.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.asserts.bars.ToolBarAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.Select;

/**
 * To see examples of Tool Bar web elements please visit https://vuetifyjs.com/en/components/toolbars
 */

public class ToolBar extends BasicBar<ToolBar, ToolBarAssert> {

    @JDIAction("Get '{name}'s 'close' button")
    public VuetifyButton closeButton() {
        return findIconButton("mdi-close");
    }

    @JDIAction("Get '{name}'s 'delete' button")
    public VuetifyButton deleteButton() {
        return findIconButton("mdi-delete");
    }
    @JDIAction("Get '{name}'s 'export' button")
    public VuetifyButton exportButton() {
        return findIconButton("mdi-export");
    }

    @JDIAction("Get '{name}'s 'GPS' button")
    public VuetifyButton gpsButton() {
        return findIconButton("mdi-crosshairs-gps");
    }

    @JDIAction("Get '{name}'s 'apps' button")
    public VuetifyButton appsButton() {
        return findIconButton("mdi-apps");
    }

    @JDIAction("Get '{name}'s 'search' icon")
    public Icon searchIcon() {
        return castToIcon(find(".mdi-magnify"));
    }

    @JDIAction("Get '{name}'s input field")
    public Input input() {
        return new Input().setCore(Input.class, find(".v-input"));
    }

    @JDIAction("Get '{name}'s 'select options' field")
    public Select select() {
        String rootLocator = core().printFullLocator()
                .replaceAll("'", "")
                .replace("css=", "")
                + " .v-select";
        String valueLocator = "//input[@type = 'hidden']";
        String listLocator =
                "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]" +
                        "//div[contains(@class, 'v-list-item--link')]";
        String expandLocator = "//div[@class = 'v-input__slot']//i[contains(@class, 'v-icon')]";
        return (Select) new Select().setup(rootLocator, valueLocator, listLocator, expandLocator);
    }

    @JDIAction("Get '{name}'s header's height")
    public String getHeaderHeight() {
        return getHeader().getAttribute("style");
    }

    @JDIAction("Get '{name}'s header's color")
    public String getHeaderColor() {
        return getHeader().getCssValue("background-color");
    }

    @JDIAction("Get '{name}'s background image")
    public Image backgroundImage() {
        if(find(".v-image__image").isExist()) {
            return new Image().setCore(Image.class, find(".v-image__image"));
        } else {
            return new Image().setCore(Image.class, find(".v-card--flat"));
        }
    }

    @JDIAction("Does '{name}' have hidden 'delete' and 'close' buttons")
    public boolean hasHiddenButtons() {
        return closeButton().isNotExist() && deleteButton().isNotExist();
    }

    @JDIAction("Does '{name}' have collapsed header")
    public boolean hasCollapsedHeader() {
        return getHeader().getAttribute("class").contains("collapsed");
    }

    @JDIAction("Does '{name}' have dense header")
    public boolean hasDenseHeader() {
        return getHeader().getAttribute("class").contains("dense");
    }

    @JDIAction("Does '{name}' have extended header")
    public boolean hasExtendedHeader() {
        return getHeader().getAttribute("class").contains("extended");
    }

    public ToolBarAssert is() {
        return new ToolBarAssert().set(this);
    }
}
