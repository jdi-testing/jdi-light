package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.surfaces.PaperAssert;
import org.apache.commons.lang3.StringUtils;

import static java.lang.Integer.parseInt;

/**
 * Represents paper MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/paper/">Paper MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Paper extends UIBaseElement<PaperAssert> {

    public boolean isRounded() {
        return !core().classLike("MuiPaper-rounded", StringUtils::equals).isEmpty();
    }

    public boolean isOutlined() {
        return !core().classLike("MuiPaper-outlined", StringUtils::equals).isEmpty();
    }

    public int elevation() {
        String elevClassName = "MuiPaper-elevation";
        String elevationClass = core().classLike(elevClassName, StringUtils::startsWith);
        if (elevationClass.isEmpty()) {
            return 0;
        }

        elevationClass = elevationClass.replace(elevClassName, "");
        return parseInt(elevationClass);
    }



    @Override
    public PaperAssert is() {
        return new PaperAssert().set(this);
    }
}
