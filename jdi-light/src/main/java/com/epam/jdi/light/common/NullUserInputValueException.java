package com.epam.jdi.light.common;

public class NullUserInputValueException extends IllegalArgumentException {
    public NullUserInputValueException() {
        super("Value should not be null. Only values that can be entered by the user are accepted.");
    }
}
