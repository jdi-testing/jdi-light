package com.jdiai.jsbuilder;

public class ScriptResult {
    public String jsScript;
    public Object result;
    public ScriptResult(String jsScript, Object result) {
        this.jsScript = jsScript;
        this.result = result;
    }
    @Override
    public String toString() {
        return jsScript + "\n" + result;
    }
}
