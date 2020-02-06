package com.epam.jdi.mobile.elements.init.rules;

import com.epam.jdi.mobile.elements.init.SiteInfo;
import com.epam.jdi.tools.func.JFunc1;

import java.lang.reflect.Field;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.any;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class InitRule {
    public JFunc1<Field, Boolean> condition;
    public JFunc1<SiteInfo, Object> func;
    public InitRule(JFunc1<Field, Boolean> condition, JFunc1<SiteInfo, Object> func) {
        this.condition = condition;
        this.func = func;
    }
    public static InitRule iRule(JFunc1<Field, Boolean> condition, JFunc1<SiteInfo, Object> func) {
        return new InitRule(condition, func);
    }
    public static InitRule iRule(Class interfaceClass, JFunc1<SiteInfo, Object> func) {
        return new InitRule(f -> f.getType() == interfaceClass, func);
    }
    public static InitRule iRule(List<Class> interfaces, JFunc1<SiteInfo, Object> func) {
        return new InitRule(f -> any(interfaces, i -> f.getType() == i), func);
    }
}
