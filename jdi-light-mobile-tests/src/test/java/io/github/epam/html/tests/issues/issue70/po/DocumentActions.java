package io.github.epam.html.tests.issues.issue70.po;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

import static com.epam.jdi.light.elements.init.UIFactory.*;

public class DocumentActions extends UIElement {
    private UIElement documentActionsBtn = $(".document-actions-btn");
    private WebList actions = $$(".%s-btn");

    @Override
    public void select(String name) {
        documentActionsBtn.click();
        actions.select(name);
    }
}