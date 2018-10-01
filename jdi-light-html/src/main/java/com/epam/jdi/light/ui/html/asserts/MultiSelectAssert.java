package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.ui.html.base.HtmMultiSelector;
import org.hamcrest.Matcher;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MultiSelectAssert extends BaseSelectAssert {

    HtmMultiSelector mSelect;
    public MultiSelectAssert(HtmMultiSelector mSelect) {
        super(mSelect);
        this.mSelect = mSelect;
    }

    public void selected(Matcher<Iterable<String>> condition) {
        assertThat(mSelect.selected(), condition);
    }


}
