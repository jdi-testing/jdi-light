package com.epam.jdi.light.common;

public class NullArgumentException extends IllegalArgumentException {
    public NullArgumentException() {
        super("Value should not be null. Only values that can be entered by the user are accepted.");
    }
}
