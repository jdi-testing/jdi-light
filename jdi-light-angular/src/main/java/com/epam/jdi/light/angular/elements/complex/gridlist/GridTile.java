package com.epam.jdi.light.angular.elements.complex.gridlist;

import com.epam.jdi.light.angular.asserts.gridlist.GridTileAssert;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasColor;

public class GridTile extends UIBaseElement<GridTileAssert> implements HasColor {

    private static final String HEADER_LOCATOR = ".mat-grid-tile-header";
    private static final String FOOTER_LOCATOR = ".mat-grid-tile-footer";

    @Override
    public GridTileAssert is() {
        return new GridTileAssert().set(this);
    }

    @Override
    public GridTileAssert has() {
        return is();
    }

    @JDIAction(value = "Get '{name}' tile's number of columns")
    public int colspan() {
        return Integer.parseInt(core().getAttribute("colspan"));
    }

    @JDIAction(value = "Get '{name}' tile's number of rows")
    public int rowspan() {
        return Integer.parseInt(core().getAttribute("rowspan"));
    }

    @JDIAction(value = "Get '{name}' tile text")
    public String text() {
        return core().text();
    }

    @JDIAction("Get '{name}' header color")
    public String headerColor() {
        return core().find(HEADER_LOCATOR).getCssValue("color");
    }

    @JDIAction("Get '{name}' footer color")
    public String footerColor() {
        return core().find(FOOTER_LOCATOR).getCssValue("color");
    }

    @JDIAction("Get '{name}' header color")
    public String headerBackgroundColor() {
        return core().find(HEADER_LOCATOR).getCssValue("background-color");
    }

    @JDIAction("Get '{name}' footer color")
    public String footerBackgroundColor() {
        return core().find(FOOTER_LOCATOR).getCssValue("background-color");
    }

    @JDIAction("Get '{name}' angular color")
    public AngularColors angularColor() {
        return AngularColors.fromColor(color());
    }

    @JDIAction("Get '{name}' angular background color")
    public AngularColors angularBackgroundColor() {
        return AngularColors.fromColor(backgroundColor());
    }

    @JDIAction("Get '{name}' header angular color")
    public AngularColors headerAngularColor() {
        return AngularColors.fromColor(headerColor());
    }

    @JDIAction("Get '{name}' footer angular color")
    public AngularColors footerAngularColor() {
        return AngularColors.fromColor(footerColor());
    }

    @JDIAction("Get '{name}' header angular background color")
    public AngularColors headerAngularBackgroundColor() {
        return AngularColors.fromColor(headerBackgroundColor());
    }

    @JDIAction("Get '{name}' footer angular background color")
    public AngularColors footerAngularBackgroundColor() {
        return AngularColors.fromColor(footerBackgroundColor());
    }

    @JDIAction("Get '{name}' header text")
    public String headerText() {
        return core().find(HEADER_LOCATOR).text();
    }

    @JDIAction("Get '{name}' footer text")
    public String footerText() {
        return core().find(FOOTER_LOCATOR).text();
    }

    @JDIAction("Get '{name}' header")
    public UIElement header() {
        return core().find(HEADER_LOCATOR);
    }

    @JDIAction("Get '{name}' footer")
    public UIElement footer() {
        return core().find(FOOTER_LOCATOR);
    }
}
