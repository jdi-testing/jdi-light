package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLink;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.asserts.LinkAssert;

import java.net.MalformedURLException;
import java.net.URL;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.jdiai.tools.LinqUtils.safeException;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Link extends UIBaseElement<LinkAssert>
        implements HasValue, HasClick, IsText, HasLink {
    // region Actions
    @JDIAction(value = "Get '{name}' image alt", level = DEBUG)
    public String alt() { return core().attr("alt"); }
    // endregion

    // region Set and get value for Forms
    public String getValue() {
        return getText();
    }
    // endregion

    // region Extend assertions
    @Override
    public LinkAssert is() {
        return new LinkAssert().set(this);
    }
    // endregion
}
