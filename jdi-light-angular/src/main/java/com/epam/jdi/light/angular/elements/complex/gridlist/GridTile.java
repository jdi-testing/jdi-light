package com.epam.jdi.light.angular.elements.complex.gridlist;

import com.epam.jdi.light.angular.asserts.gridlist.GridTileAssert;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasColor;

public class GridTile extends UIBaseElement<GridTileAssert> implements HasColor {

    private static final String HEADER_LOCATOR = ".mat-grid-tile-header";
    private static final String FOOTER_LOCATOR = ".mat-grid-tile-footer";
    private static final String TEXT_LOCATOR = ".mat-grid-tile-text";

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
        return core().find(TEXT_LOCATOR).text();
    }

    @JDIAction("Get '{name}' color")
    public String color() {
        return core().getCssValue("background-color");
    }

    @JDIAction("Get '{name}' header color")
    public String headerColor() {
        return core().find(HEADER_LOCATOR).getCssValue("border-bottom-color");
    }

    @JDIAction("Get '{name}' footer color")
    public String footerColor() {
        return core().find(FOOTER_LOCATOR).getCssValue("border-bottom-color");
    }

    @JDIAction("Get '{name}' angular color")
    public AngularColors angularColor() {
        return AngularColors.fromColor(core().getCssValue("background-color"));
    }

    @JDIAction("Get '{name}' angular header color")
    public AngularColors headerAngularColor() {
        return AngularColors.fromColor(core().find(HEADER_LOCATOR).getCssValue("border-bottom-color"));
    }

    @JDIAction("Get '{name}' angular footer color")
    public AngularColors footerAngularColor() {
        return AngularColors.fromColor(core().find(FOOTER_LOCATOR).getCssValue("border-bottom-color"));
    }

    @JDIAction("Get '{name}' header text")
    public String headerText() {
        return core().find(HEADER_LOCATOR).text();
    }

    @JDIAction("Get '{name}' footer text")
    public String footerText() {
        return core().find(FOOTER_LOCATOR).text();
    }
}
