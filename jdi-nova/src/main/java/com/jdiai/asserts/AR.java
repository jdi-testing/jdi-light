package com.jdiai.asserts;

public class AR {
    public String actualValue;
    public boolean result;
    public AR(boolean result) {
        this(result+"", result);
    }
    public AR(String actualValue, boolean result) {
        this.actualValue = actualValue;
        this.result = result;
    }

    public String getActualValue() {
        return actualValue;
    }
    public boolean getResult() {
        return result;
    }
}
