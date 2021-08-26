package com.jdiai.entities;

import com.jdiai.jswraper.interfaces.GetValue;
import com.jdiai.tools.DataClass;

public class ElementInfo extends DataClass<ElementInfo> {
    @GetValue("tagName")
    public String tag;
    @GetValue("id")
    public String id;
    @GetValue("textContent")
    public String text;
    @GetValue("innerHTML")
    public String html;
    @GetValue("styles.visibility")
    public String visibility;
    @GetValue("styles.fontSize")
    public String fontSize;
    @GetValue("!!{element}.selected")
    public String selected;
}
