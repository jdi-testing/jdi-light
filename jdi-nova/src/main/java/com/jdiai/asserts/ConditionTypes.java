package com.jdiai.asserts;

import com.jdiai.tools.DataClass;

public class ConditionTypes extends DataClass<ConditionTypes> {
    public String isExist = ElementFilters.isExist;
    public String isEnabled = ElementFilters.isEnabled;
    public String isDisplayed = ElementFilters.isDisplayed;
    public String isVisible = ElementFilters.isVisible;
}
