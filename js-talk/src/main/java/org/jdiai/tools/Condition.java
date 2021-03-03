package org.jdiai.tools;

import java.util.function.Function;

public class Condition {
    protected final Function<Condition, String> condition;
    public String value;
    public String attrName;
    public GetTextTypes textType;

    public Condition(Function<Condition, String> condition) {
        this.condition = condition;
    }
    public Condition addTextType(GetTextTypes textType) {
        this.textType = textType;
        return this;
    }
    public String getScript() {
        return condition.apply(this);
    }
}
