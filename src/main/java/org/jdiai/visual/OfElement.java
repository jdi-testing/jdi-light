package org.jdiai.visual;

import com.epam.jdi.tools.func.JFunc1;
import org.jdiai.tools.JS;

public class OfElement {
    private JS base;
    private JFunc1<Direction, Boolean> directionFunc;
    public OfElement(JFunc1<Direction, Boolean> directionFunc, JS base) {
        this.directionFunc = directionFunc;
        this.base = base;
    }

    public boolean from(JS target) {
        return directionFunc.execute(target.getDirectionTo(base));
    }
}
