package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.OtpInput;

public class OtpInputPage extends VuetifyPage{

    @UI("#HiddenOtpInput .v-otp-input")
    public static OtpInput hiddenOtpInput;

    @UI("#DisabledOtpInput .v-otp-input")
    public static OtpInput disabledOtpInput;

    @UI("#PlainOtpInput .v-otp-input")
    public static OtpInput plainOtpInput;

    @UI("#ReadOnlyOtpInput .v-otp-input")
    public static OtpInput readOnlyOtpInput;
}
