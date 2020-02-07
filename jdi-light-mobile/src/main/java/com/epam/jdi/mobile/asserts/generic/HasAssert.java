package com.epam.jdi.mobile.asserts.generic;

import com.epam.jdi.mobile.elements.interfaces.base.IBaseElement;

import static com.epam.jdi.mobile.asserts.core.SoftAssert.assertSoft;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface HasAssert<T> {
    T is();
    default T assertThat() {
        return is();
    }
    default T has() {
        return is();
    }
    default T waitFor() {
        return is();
    }
    default T waitFor(int sec) {
        ((IBaseElement)this).waitSec(sec);
        return is();
    }
    default T shouldBe() {
        return is();
    }
    default T verify() {
        assertSoft(); return is();
    }
}