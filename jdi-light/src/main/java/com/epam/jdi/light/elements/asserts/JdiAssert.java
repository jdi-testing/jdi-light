package com.epam.jdi.light.elements.asserts;

public class JdiAssert<A> {
    A asserter;
    public JdiAssert(A asserter) {
        this.asserter = asserter;
    }

    public A get() { return asserter; }
}
