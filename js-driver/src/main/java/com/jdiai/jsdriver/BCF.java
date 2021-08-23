package com.jdiai.jsdriver;

import com.jdiai.jsbuilder.IJSBuilder;

public class BCF {
    public IJSBuilder builder;
    public String context;
    public boolean hasFunction;

    public BCF(String context, IJSBuilder builder, boolean hasFunction) {
        this.context = context;
        this.builder = builder;
        this.hasFunction = hasFunction;
    }
}
