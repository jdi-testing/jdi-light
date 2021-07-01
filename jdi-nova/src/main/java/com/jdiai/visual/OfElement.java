package com.jdiai.visual;

import com.jdiai.JS;

import java.util.function.Function;

public class OfElement {
    private JS base;
    private Function<Direction, Boolean> directionFunc;
    public OfElement(Function<Direction, Boolean> directionFunc, JS base) {
        this.directionFunc = directionFunc;
        this.base = base;
    }

    public boolean from(JS target) {
        return directionFunc.apply(target.getDirectionTo(base));
    }
}
