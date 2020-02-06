package com.epam.jdi.mobile.elements.init.rules;

import com.epam.jdi.mobile.elements.init.SiteInfo;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc1;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class SetupRule {
    public JFunc1<SiteInfo, Boolean> condition;
    public JAction1<SiteInfo> action;
    public SetupRule(JFunc1<SiteInfo, Boolean> condition, JAction1<SiteInfo> action) {
        this.condition = condition;
        this.action = action;
    }
    public static SetupRule sRule(
            JFunc1<SiteInfo, Boolean> condition, JAction1<SiteInfo> action) {
        return new SetupRule(condition, action);
    }
}
