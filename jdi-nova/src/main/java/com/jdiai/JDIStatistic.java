package com.jdiai;

import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.map.MapArray;

public class JDIStatistic {
    public static int shouldValidations = 0;
    public static Safe<MapArray<String, Long>> actionsTime = new Safe<>(new MapArray<>());

}
