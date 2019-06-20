package com.epam.jdi.light.elements.init.rules;

import com.epam.jdi.light.elements.init.SiteInfo;
import com.epam.jdi.tools.func.JFunc1;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.any;

public class InitRule {
    public JFunc1<Class<?>, Boolean> condition;
    public JFunc1<SiteInfo, Object> func;
    public InitRule(JFunc1<Class<?>, Boolean> condition, JFunc1<SiteInfo, Object> func) {
        this.condition = condition;
        this.func = func;
    }
    public static InitRule iRule(JFunc1<Class<?>, Boolean> condition, JFunc1<SiteInfo, Object> func) {
        return new InitRule(condition, func);
    }
    public static InitRule iRule(Class interfaceClass, JFunc1<SiteInfo, Object> func) {
        return new InitRule(cl -> cl == interfaceClass, func);
    }
    public static InitRule iRule(List<Class> interfaces, JFunc1<SiteInfo, Object> func) {
        return new InitRule(cl -> any(interfaces, i -> cl == i), func);
    }
}
