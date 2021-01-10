package org.jdiai;

import com.google.gson.JsonObject;

public class ClientRect {
    public int x, y, top, bottom, right, left, windowWidth, windowHeight;
    public ClientRect(JsonObject json) {
        x = roundUp(json, "x");
        y = roundUp(json, "y");
        top = roundUp(json, "top");
        bottom = roundDown(json, "bottom");
        right = roundDown(json, "right");
        left = roundUp(json, "left");
        windowWidth = roundDown(json, "wWidth");;
        windowHeight = roundDown(json, "wHeight");;
    }
    private int roundUp(JsonObject json, String variable) {
        return (int) Math.round(json.get(variable).getAsDouble());
    }
    private int roundDown(JsonObject json, String variable) {
        return (int) json.get(variable).getAsDouble();
    }
}
