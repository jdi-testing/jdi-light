package io.github.epam.html.tests.issues.issue70.po;

import com.epam.jdi.light.ui.html.base.HtmlElement;
import com.epam.jdi.light.ui.html.base.HtmlList;
import com.epam.jdi.light.ui.html.common.Button;

import static com.epam.jdi.light.ui.html.HtmlFactory.$;
import static com.epam.jdi.light.ui.html.HtmlFactory.$$;

public class DocumentActions extends HtmlElement {
    private Button documentActionsBtn = $(".document-actions-btn");
    private HtmlList actions = $$(".%s-btn");

    @Override
    public void select(String name) {
        documentActionsBtn.click();
        actions.select(name);
    }
}