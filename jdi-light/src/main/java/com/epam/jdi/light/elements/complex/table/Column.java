package com.epam.jdi.light.elements.complex.table;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import static com.epam.jdi.tools.EnumUtils.getEnumValue;

public class Column extends NameNum {
    public static Column column(int num) { return (Column)new Column().set(row -> row.num = num); }
    public static Column column(String value) {
        return (Column)new Column().set(row -> row.name = value);
    }
    public static Column column(Enum name) { return column(getEnumValue(name)); }
    public static Column inColumn(int num) { return column(num); }
    public static Column inColumn(String value) { return column(value); }
    public static Column inColumn(Enum name) { return column(getEnumValue(name)); }

}