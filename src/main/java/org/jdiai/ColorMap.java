package org.jdiai;

import com.epam.jdi.tools.map.MapArray;

import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;

public class ColorMap {
    public static MapArray<String, String> COLORS_MAP = map(
        $("#000000", "Black"),
        $("#FF0000", "Red"),
        $("#00FF00", "Green"),
        $("#0000FF", "Blue"),
        $("#00FFFF", "Cyan"),
        $("#FF00FF", "Magenta"),
        $("#FFFF00", "Yellow"),
        $("#FFFFFF", "White"));
    public static String asColor(String color) {
        return COLORS_MAP.has(color) ? COLORS_MAP.get(color) : color;
    }
}
