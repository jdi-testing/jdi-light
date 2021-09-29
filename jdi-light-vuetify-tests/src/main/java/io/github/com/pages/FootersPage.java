package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.composite.Footer;
import io.github.com.custom.footers.CompanyFooter;
import io.github.com.custom.footers.IndigoFooter;
import io.github.com.custom.footers.TealFooter;

public class FootersPage extends VuetifyPage {

    @UI("#PadlessFooter")
    public static Footer padlessFooter;

    @UI("#CompanyFooter")
    public static CompanyFooter companyFooter;

    @UI("#IndigoFooter")
    public static IndigoFooter indigoFooter;

    @UI("#TealFooter")
    public static TealFooter tealFooter;

}
