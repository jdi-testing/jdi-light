package com.epam.jdi.mobile.elements.complex.table;

import com.epam.jdi.tools.DataClass;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.firstIndex;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class NameNum extends DataClass<NameNum> {
    public int num = 0;
    public String name;

    public boolean hasName() {
        return isNotBlank(name);
    }
    @Override
    public String toString() {
        return hasName()
            ? num > 0 ? super.toString() : name
            : num+"";
    }
    public int getIndex(List<String> headers) {
        return !hasName() ? num  : firstIndex(headers,
                h -> equalsIgnoreCase(h, name))+1;
    }
}