package org.jdiai.tools;

import java.util.function.Function;

public class FilterCondition {
    protected final Function<FilterCondition, String> condition;
    public String value;
    public String attrName;
    public GetTextTypes textType;

    public FilterCondition(Function<FilterCondition, String> condition) {
        this.condition = condition;
    }
    public FilterCondition addTextType(GetTextTypes textType) {
        this.textType = textType;
        return this;
    }
    public String getScript() {
        return condition.apply(this);
    }
}
