package com.jdiai.jsdriver;

public class JDINovaBuilderException extends JDINovaException {
    public JDINovaBuilderException(String message) {
        super(message);
    }
    public JDINovaBuilderException(String message, Object... args) {
        super(message, args);
    }
    public JDINovaBuilderException(Throwable ex, String msg, Object... args) {
        super(ex, msg, args);
    }

}
