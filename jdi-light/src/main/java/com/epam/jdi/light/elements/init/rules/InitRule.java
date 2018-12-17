package com.epam.jdi.light.elements.init.rules;

import com.epam.jdi.light.elements.init.SiteInfo;
import com.epam.jdi.tools.func.JFunc1;

import java.lang.reflect.Field;

public class InitRule {
    public JFunc1<Field, Boolean> condition;
    public JFunc1<SiteInfo, Object> func;
    public InitRule(JFunc1<Field, Boolean> condition, JFunc1<SiteInfo, Object> func) {
        this.condition = condition;
        this.func = func;
    }
    public static InitRule iRule(
            JFunc1<Field, Boolean> condition, JFunc1<SiteInfo, Object> func) {
        return new InitRule(condition, func);
    }
}
