package com.jdiai;

import com.jdiai.tools.Safe;
import com.jdiai.tools.map.MapArray;

public class JDIStatistic {
    public static int shouldValidations = 0;
    public static Safe<MapArray<String, Long>> actionsTime = new Safe<>(new MapArray<>());

}
