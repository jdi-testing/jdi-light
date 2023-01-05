package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;
import io.github.com.custom.dialog.NestingDialog;
import io.github.com.custom.dialog.ScrollableDialog;

public class DialogsPage extends VuetifyPage {
    @UI("#fullscreenDialog > button")
    public static VuetifyButton fullscreenDialogButton;

    @UI("#persistentDialog > button")
    public static VuetifyButton persistentDialogButton;

    @UI("#scrollableDialog > button")
    public static VuetifyButton scrollableDialogButton;

    @UI("#nestingDialog button [1]")
    public static VuetifyButton nestingDialogFirstButton;

    @UI("#withoutActivatorDialog > button")
    public static VuetifyButton withoutActivatorDialogButton;

    @UI(".v-dialog__content")
    public static Dialog currentDialog;

    @UI(".v-dialog__content")
    public static ScrollableDialog scrollableDialog;

    @UI(".v-dialog__content[1]")
    public static NestingDialog nestingDialogFirst;

    @UI(".v-dialog__content[2]")
    public static NestingDialog nestingDialogSecond;

    @UI(".v-dialog__content[3]")
    public static Dialog nestingDialogThird;

    @UI("#disabledDialog > button")
    public static VuetifyButton disabledDialogButton;
}
