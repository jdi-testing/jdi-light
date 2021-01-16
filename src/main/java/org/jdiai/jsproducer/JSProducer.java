package org.jdiai.jsproducer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jdiai.Json;

import java.util.Map;

public class JSProducer {
    private Object result;
    public JSProducer(Object result) {
        this.result = result;
    }

    public String asString() {
        return result == null ? "NULL" : result.toString();
    }
    public JsonObject asJson() {
        if (result == null) { return null; }
        return new Gson().fromJson(result.toString(), JsonObject.class);
    }
    public Json asMap() {
        if (result == null) { return null; }
        return new Json(new Gson().fromJson(result.toString(), Map.class));
    }
    public <T> T asObject(Class<T> cl) {
        if (result == null) { return null; }
        return new Gson().fromJson(result.toString(), cl);
    }
}
