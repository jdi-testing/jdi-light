package com.epam.jdi.light.elements.interfaces.complex;

import com.epam.jdi.light.asserts.complex.ChecklistAssert;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.elements.complex.ISelector;

import java.util.List;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IsChecklist extends ISelector, HasAssert<ChecklistAssert> {
    void select(String name);
    void select(String... names);
    <TEnum extends Enum<?>> void select(TEnum value);
    <TEnum extends Enum<?>> void select(TEnum... values);
    void select(int index);
    void select(int... indexes);

    void check(String... names);
    <TEnum extends Enum<?>> void check(TEnum value);
    <TEnum extends Enum<?>> void check(TEnum... values);
    void check(int index);
    void check(int... indexes);

    void checkAll();

    void uncheck(String... names);
    <TEnum extends Enum<?>> void uncheck(TEnum value);
    <TEnum extends Enum<?>> void uncheck(TEnum... values);
    void uncheck(int index);
    void uncheck(int... indexes);
    void uncheckAll();

    List<String> checked();
}
