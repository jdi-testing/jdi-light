package io.github.com.custom.textfields;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

public class ProgressTextField extends TextField {

    @UI("#ProgressTextField .v-text-field .v-progress-linear")
    public static UIElement progressTextFieldProgressbar;

    /** Get the value max of the progressTextField.
     *
     * @return icon as {@code int}
     */
    @JDIAction("Get value max of '{name}'")
    public int valueMax() {
        return Integer.parseInt(progressTextFieldProgressbar.attr("aria-valuemax"));
    }

    /**
     * Checks if this progressTextField have correct current progress or not.
     *
     * @param currentProgress expected current progress
     * @return {@code true} if this current progress is same, otherwise {@code false}
     */
    @JDIAction("Has correct current progress of '{name}'")
    public boolean hasCurrentProgress(int currentProgress) {
        String actualCurrentProgress = progressTextFieldProgressbar.attr("aria-valuenow");
        return actualCurrentProgress.equals(Integer.toString(currentProgress));
    }
}
