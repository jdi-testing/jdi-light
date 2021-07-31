package com.jdiai.jsproducer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.tools.LinqUtils.map;

public class JSListProducer {
    private final List<Object> result;
    public JSListProducer(List<Object> result) {
        this.result = result;
    }

    public List<String> asString() {
        if (result == null) { return new ArrayList<>(); }
        return map(result, Object::toString);
    }
    public List<JsonObject> asJson() {
        if (result == null) { return new ArrayList<>(); }
        return map(result, r -> new Gson().fromJson(r.toString(), JsonObject.class));
    }
    public <T> List<T> asObject(Class<T> cl) {
        if (result == null) { return new ArrayList<>(); }
        return map(result, r -> new Gson().fromJson(r.toString(), cl));
    }
}
