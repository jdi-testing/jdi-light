package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import org.hamcrest.Matchers;
import java.util.List;
import java.util.Map;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.equalTo;

public class TreeViewAssert extends UISelectAssert<TreeViewAssert, TreeView> implements
        LoadingAssert<TreeViewAssert, TreeView>,
        DenseAssert<TreeViewNodeAssert, TreeView> {


    @JDIAction("Assert that '{name}' is hoverable")
    public TreeViewAssert hoverable() {
        jdiAssert(element().isHoverable(), Matchers.is(true), "Element is not hoverable");
        return this;
    }

    @JDIAction("Assert that '{name}' is not hoverable")
    public TreeViewAssert notHoverable() {
        jdiAssert(element().isHoverable(), Matchers.is(false), "Element is hoverable");
        return this;
    }

    @JDIAction("Assert that structure of '{name}' is equal to '{0}'")
    public TreeViewAssert structure(Map<String, List<String>> structure) {
        Map<String, List<String>> actualStructure = element().structure();
        jdiAssert(actualStructure, equalTo(structure), String.format("Actual element's structure '%s' is not equal " +
                "to expected '%s'", actualStructure, structure));
        return this;
    }

    public TreeViewAssert and() {
        return this;
    }
}
