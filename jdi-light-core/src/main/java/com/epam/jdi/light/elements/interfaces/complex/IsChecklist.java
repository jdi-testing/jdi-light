package com.epam.jdi.light.elements.interfaces.complex;

import com.epam.jdi.light.asserts.complex.ChecklistAssert;
import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.elements.complex.ISelector;
import com.jdiai.tools.HasStartIndex;

import java.util.List;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IsChecklist extends ISelector, HasAssert<ChecklistAssert>, HasStartIndex {
    void select(String name);
    void select(String... names);
    <EnumType extends Enum<?>> void select(EnumType value);
    <EnumType extends Enum<?>> void select(EnumType... values);
    void select(int index);
    void select(int... indexes);

    void check(String... names);
    <EnumType extends Enum<?>> void check(EnumType value);
    <EnumType extends Enum<?>> void check(EnumType... values);
    void check(int index);
    void check(int... indexes);

    void checkAll();

    void uncheck(String... names);
    <EnumType extends Enum<?>> void uncheck(EnumType value);
    <EnumType extends Enum<?>> void uncheck(EnumType... values);
    void uncheck(int index);
    void uncheck(int... indexes);
    void uncheckAll();

    List<String> checked();
}
