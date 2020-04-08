package com.epam.jdi.light.settings;

import org.openqa.selenium.Dimension;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.tools.RegExUtils.*;
import static java.lang.Integer.*;

public class ScreenSize {
    public int width, height;
    public boolean maximize;

    public ScreenSize(int height, int width) {
        setHeightWidth(height, width);
    }
    public void setHeightWidth(int height, int width) {
        this.height = height;
        this.width = width;
        maximize = false;

    }
    public ScreenSize() {
        maximize = true;
    }
    public Dimension asDimension() {
        return new Dimension(width, height);
    }
    public void read(String property) {
        List<String> groups = matches(property, "([0-9]+)[^0-9]*([0-9]+)");
        if (groups.size() == 2) {
            try {
                setHeightWidth(parseInt(groups.get(0)), parseInt(groups.get(1)));
            } catch (Exception ex) {
                throw exception("Can't parse property browser.size value (%s). Allowed format: 1024x768 or MAXIMIZED", property);
            }
        } else {
            maximize = true;
        }
    }
}
