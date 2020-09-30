package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.elements.interfaces.base.IBaseElement;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface HasAssert<A> {
    A is();
    default A assertThat() {
        return is();
    }
    default A has() {
        return is();
    }
    default A waitFor() {
        return is();
    }
    default A waitFor(int sec) {
        ((IBaseElement)this).waitSec(sec);
        return is();
    }
    default A shouldBe() {
        return is();
    }
    default A verify() {
        assertSoft(); return is();
    }
}