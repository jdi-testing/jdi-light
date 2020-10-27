package org.jdiai;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JSProducer {
    private String result;
    public JSProducer(String result) {
        this.result = result;
    }

    public String asString() {
        return result;
    }
    public JsonObject asJson() {
        return new Gson().fromJson(result, JsonObject.class);
    }
    public <T> T asObject(Class<T> cl) {
        return new Gson().fromJson(result, cl);
    }
}
