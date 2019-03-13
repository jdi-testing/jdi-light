package com.epam.jdi.light.asserts;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface IHasSelectAssert {

    SelectAssert is();
    default SelectAssert assertThat() {
        return is();
    }
    default SelectAssert has() {
        return is();
    }
}