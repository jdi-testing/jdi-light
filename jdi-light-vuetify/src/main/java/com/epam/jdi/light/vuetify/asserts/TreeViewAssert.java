package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import org.hamcrest.Matchers;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TreeViewAssert extends UISelectAssert<TreeViewAssert, TreeView> implements
        LoadingAssert<TreeViewAssert, TreeView>,
        DenseAssert<TreeViewNodeAssert, TreeView> {


    @JDIAction(value = "Assert that '{name}' is hoverable", isAssert = true)
    public TreeViewAssert hoverable() {
        jdiAssert(element().isHoverable(), Matchers.is(true), "TreeView is not hoverable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not hoverable", isAssert = true)
    public TreeViewAssert notHoverable() {
        jdiAssert(element().isHoverable(), Matchers.is(false), "TreeView is hoverable");
        return this;
    }

    public TreeViewAssert and() {
        return this;
    }
}
