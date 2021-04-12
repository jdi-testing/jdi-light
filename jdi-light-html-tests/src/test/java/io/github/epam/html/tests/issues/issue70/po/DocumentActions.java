package io.github.epam.html.tests.issues.issue70.po;

import com.epam.jdi.light.elements.common.uiElement;
import com.epam.jdi.light.elements.complex.webList;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

public class DocumentActions extends uiElement {
    private uiElement documentActionsBtn = $(".document-actions-btn");
    private webList actions = $$(".%s-btn").setName("Document actions");

    @Override
    public void select(String name) {
        documentActionsBtn.click();
        actions.select(name);
    }
}