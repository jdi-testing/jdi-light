package org.jdiai.tools;

import static org.jdiai.tools.JSConditions.*;

public class FilterConditions {
    public static FilterCondition textEquals(String value) {
        FilterCondition condition = new FilterCondition(textEquals);
        condition.value = value;
        return condition;
    }
    public static FilterCondition textContains(String value) {
        FilterCondition condition = new FilterCondition(textContains);
        condition.value = value;
        return condition;
    }
    public static FilterCondition hasAttribute(String attrName) {
        FilterCondition condition = new FilterCondition(hasAttribute);
        condition.attrName = attrName;
        return condition;
    }
    public static FilterCondition hasAttribute(String attrName, String value) {
        FilterCondition condition = new FilterCondition(hasAttributeValue);
        condition.attrName = attrName;
        condition.value = value;
        return condition;
    }
    public static FilterCondition hasTag(String value) {
        FilterCondition condition = new FilterCondition(hasTag);
        condition.value = value;
        return condition;
    }
    public static FilterCondition hasClass(String value) {
        FilterCondition condition = new FilterCondition(hasClass);
        condition.value = value;
        return condition;
    }
}
