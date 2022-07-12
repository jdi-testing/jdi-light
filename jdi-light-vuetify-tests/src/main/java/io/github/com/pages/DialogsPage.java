package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;

public class DialogsPage extends VuetifyPage {

    //fullscreen dialog button
    @UI("#fullscreenDialog > button")
    public static VuetifyButton fullscreenDialogButton;

    //transitions dialog buttons
    @UI("#transitions > button [1]")
    public static VuetifyButton fromTheBottomButton;

    @UI("#transitions > button [2]")
    public static VuetifyButton fromTheTopButton;

    //persistent dialog button
    @UI("#persistentDialog > button")
    public static VuetifyButton persistentDialogButton;

    //scrollable dialog button
    @UI("#scrollableDialog > button")
    public static VuetifyButton scrollableDialogButton;

    //form dialog button
    @UI("#formDialog > button")
    public static VuetifyButton formDialogButton;

    //loader dialog button
    @UI("#loaderDialog > button")
    public static VuetifyButton loaderDialogButton;

    //nesting dialog buttons
    @UI("#nestingDialog button [1]")
    public static VuetifyButton nestingDialogFirstButton;

    @UI("#nestingDialog button [2]")
    public static VuetifyButton nestingDialogSecondButton;

    @UI("#nestingDialog button [3]")
    public static VuetifyButton nestingDialogThirdButton;

    //overflowed dialog button
    @UI("#overflowedDialog > button")
    public static VuetifyButton overflowedDialogButton;

    //without Activator dialog button
    @UI("#withoutActivatorDialog > button")
    public static VuetifyButton withoutActivatorDialogButton;

    //nesting dialogs
    @UI(".v-dialog__content[1]")
    public static Dialog nestingDialogFirst;

    @UI(".v-dialog__content[2]")
    public static Dialog nestingDialogSecond;

    @UI(".v-dialog__content[3]")
    public static Dialog nestingDialogThird;

    //current dialog
    @UI(".v-dialog__content")
    public static Dialog currentDialog;
}
