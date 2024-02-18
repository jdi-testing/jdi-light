package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.feedback.AlertAssert;
import com.epam.jdi.light.material.elements.inputs.MUIButton;
import com.epam.jdi.light.material.elements.utils.enums.Severity;
import com.epam.jdi.light.material.interfaces.displaydata.HasIcon;
import com.epam.jdi.light.ui.html.elements.common.Text;
import org.apache.commons.lang3.StringUtils;

/**
 * Represents alert MUI component on GUI.
 *
 * @see <a href="https://v4.mui.com/components/alert/">Alert MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Alert extends UIBaseElement<AlertAssert> implements HasIcon {

    private String titleLocator = ".MuiAlertTitle-root";
    /**
     * Gets the title of this alert.
     *
     * @return title of this alert as {@link Text}
     */
    @JDIAction("Get '{name}' title")
    public String title() {
        return core().find(titleLocator).getText();
    }

    @JDIAction("Get if '{name}' has title")
    public boolean hasTitle() {
        return core().finds(titleLocator).size() > 0;
    }

    public String text() {
        return core().find(".MuiAlert-message").getText();
    }

    public UIElement action() {
        return core().find(".MuiAlert-action");
    }

    public MUIButton buttonAction() {
        return new MUIButton().setCore(MUIButton.class, core().find(".MuiAlertAction, button"));
    }

    public Severity severity() {
        String[] prefixes = {"MuiAlert-standard", "MuiAlert-filled", "MuiAlert-outlined"};
        for (String prefix: prefixes) {
            String severityClass = core().classLike(prefix, StringUtils::startsWith);
            if (!severityClass.isEmpty()) {
                return Severity.fromStyle(severityClass, prefix);
            }
        }
        return Severity.SUCCESS;
    }

    @Override
    public AlertAssert is() {
        return new AlertAssert().set(this);
    }
}
