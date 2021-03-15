package com.epam.jdi.light.settings;

import org.openqa.selenium.Dimension;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.RegExUtils.matches;
import static java.lang.Integer.parseInt;

public class ScreenSize {
    public int width, height;
    public boolean maximize;

    public ScreenSize(int width, int height) {
        setWidthHeight(width, height);
    }
    public void setWidthHeight(int width, int height) {
        this.width = width;
        this.height = height;
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
                setWidthHeight(parseInt(groups.get(0)), parseInt(groups.get(1)));
            } catch (Exception ex) {
                throw exception("Can't parse property browser.size value (%s). Allowed format: 1024x768 or MAXIMIZE", property);
            }
        } else {
            maximize = true;
        }
    }
}
