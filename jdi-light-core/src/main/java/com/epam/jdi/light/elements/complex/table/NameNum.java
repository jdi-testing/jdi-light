package com.epam.jdi.light.elements.complex.table;

import com.jdiai.tools.DataClass;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.jdiai.tools.LinqUtils.firstIndex;
import static com.jdiai.tools.StringUtils.format;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class NameNum extends DataClass<NameNum> {
    public int num = -1;
    public String name;

    public boolean hasName() {
        return isNotBlank(name);
    }

    @Override
    public String toString() {
        if (!hasName() && num > -1) {
            return num + "";
        }
        if (hasName() && num == -1) {
            return name;
        }
        if (hasName() && num > -1) {
            return format("%s(%s)", name, num);
        }
        return "";
    }

    public int getIndex(List<String> headers, int startIndex) {
        logger.debug("Find header with ");
        if (!hasName()) {
            return num;
        }
        int index = firstIndex(headers, h -> equalsIgnoreCase(h, name));
        if (index < 0) {
            throw runtimeException("Failed to getIndex. Index should be >= 0");
        }
        return index + startIndex;
    }
}
