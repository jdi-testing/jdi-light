package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Snackbar;
import com.epam.jdi.light.common.JDIAction;
import com.jdiai.tools.Timer;
import com.jdiai.tools.func.JAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SnackbarAssert extends PositionAssert<SnackbarAssert, Snackbar> {

    @JDIAction(value = "Assert that '{name}' has message '{0}'", isAssert = true)
    public SnackbarAssert message(String expected) {
        jdiAssert(element().message()
                          .getText(), Matchers.containsString(expected));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has action '{0}'", isAssert = true)
    public SnackbarAssert action(String expected) {
        jdiAssert(element().action()
                          .getText(), Matchers.containsString(expected));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has action button", isAssert = true)
    public SnackbarAssert hasAction() {
        jdiAssert(element().action()
                          .isExist(), Matchers.is(true), "Action doesn't exist in snackbar");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no action button", isAssert = true)
    public SnackbarAssert hasNoAction() {
        jdiAssert(element().action()
                          .isNotExist(), Matchers.is(true), "Action exists in snackbar");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is visible during '{0}' seconds", isAssert = true)
    public SnackbarAssert notHidden(int timeoutSec) {
        JAction action = () -> {
            element().base()
                    .timer()
                    .wait(() -> element().isDisplayed());
        };
        boolean result = new Timer(timeoutSec * 1000L).wait(action);
        jdiAssert(result ? "displayed" : "hidden", Matchers.is("displayed"));
        return this;
    }
}
