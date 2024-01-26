package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.SideNav;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;
import org.openqa.selenium.Point;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SideNaveAssert extends UIAssert<SideNaveAssert, SideNav> {

    private static final String LOCATION_ERROR_MESSAGE = "SideNavSection with location %s isn't on the right side";

    @JDIAction(value = "Assert that '{name}' has section with location '{0}' on the right side", isAssert = true)
    public SideNaveAssert sideNavSectionOnTheRight(Point locationOfSection) {
        jdiAssert(element().isSectionInRightPart(locationOfSection), Matchers.is(true),
            String.format(LOCATION_ERROR_MESSAGE, locationOfSection));
        return this;
    }
}
