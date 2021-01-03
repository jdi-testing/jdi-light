package org.jdiai.jsproducer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.map;

public class JSListProducer {
    private final List<String> result;
    public JSListProducer(List<String> result) {
        this.result = result;
    }

    public List<String> asString() {
        return result;
    }
    public List<JsonObject> asJson() {
        return map(result, r -> new Gson().fromJson(r, JsonObject.class));
    }
    public <T> List<T> asObject(Class<T> cl) {
        return map(result, r -> new Gson().fromJson(r, cl));
    }
}
