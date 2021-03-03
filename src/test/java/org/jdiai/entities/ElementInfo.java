package org.jdiai.entities;

import com.epam.jdi.tools.DataClass;
import org.jdiai.tools.GetValue;

public class ElementInfo extends DataClass<ElementInfo> {
    @GetValue("tagName")
    public String tag;
    @GetValue("id")
    public String id;
    @GetValue("textContent")
    public String text;
    @GetValue("innerHTML")
    public String html;
    @GetValue("style.visibility")
    public String visibility;
    @GetValue("style.fontSize")
    public String fontSize;
    @GetValue("!!{element}.selected")
    public String selected;
}
