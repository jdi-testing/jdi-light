package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Dialog;

public class DialogsPage extends VuetifyPage {

    //fullscreen dialog
    @UI("#fullscreenDialog")
    public static Dialog fullscreenDialog;

    //transitions dialog
    @UI("//div[@id='transitionsDialog']/div[1]")
    public static Dialog fromTheBottom;

    @UI("//div[@id='transitionsDialog']/div[2]")
    public static Dialog fromTheTop;

    //persistent dialog
    @UI("#persistentDialog")
    public static Dialog persistentDialog;

    //scrollable dialog
    @UI("#scrollableDialog")
    public static Dialog scrollableDialog;

    //form dialog
    @UI("#formDialog")
    public static Dialog formDialog;

    //loader dialog
    @UI("#loaderDialog")
    public static Dialog loaderDialog;

    //nesting dialog
    @UI("#nestingDialog")
    public static Dialog nestingDialog;

    //overflowed dialog
    @UI("#overflowedDialog")
    public static Dialog overflowedDialog;

    //withoutActivator dialog
    @UI("#withoutActivatorDialog")
    public static Dialog withoutActivatorDialog;
}
