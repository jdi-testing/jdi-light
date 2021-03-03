package org.jdiai.tools;

import static org.jdiai.tools.SearchConditions.*;

public class Conditions {
    public static Condition textEquals(String value) {
        Condition condition = new Condition(textEquals);
        condition.value = value;
        return condition;
    }
    public static Condition textContains(String value) {
        Condition condition = new Condition(textContains);
        condition.value = value;
        return condition;
    }
    public static Condition hasAttribute(String attrName) {
        Condition condition = new Condition(hasAttribute);
        condition.attrName = attrName;
        return condition;
    }
    public static Condition hasAttribute(String attrName, String value) {
        Condition condition = new Condition(hasAttributeValue);
        condition.attrName = attrName;
        condition.value = value;
        return condition;
    }
    public static Condition hasTag(String value) {
        Condition condition = new Condition(hasTag);
        condition.value = value;
        return condition;
    }
    public static Condition hasClass(String value) {
        Condition condition = new Condition(hasClass);
        condition.value = value;
        return condition;
    }
}
