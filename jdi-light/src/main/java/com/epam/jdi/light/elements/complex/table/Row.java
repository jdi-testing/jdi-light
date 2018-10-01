package com.epam.jdi.light.elements.complex.table;

import static com.epam.jdi.tools.EnumUtils.getEnumValue;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class Row extends NameNum {
    public static Row row(int num) {
        return (Row)new Row().set(row -> row.num = num);
    }
    public static Row row(String name) {
        return (Row)new Row().set(row -> row.name = name);
    }
    public static Row row(Enum name) { return row(getEnumValue(name)); }
    public static Row inRow(int num) {
        return row(num);
    }
    public static Row inRow(String name) {
        return row(name);
    }
    public static Row inRow(Enum name) { return row(getEnumValue(name)); }
}