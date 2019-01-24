package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.CommonAssert;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface CheckboxAssert extends CommonAssert<HtmlAssertion> {
    HtmlAssertion selected();
    HtmlAssertion deselected();
}