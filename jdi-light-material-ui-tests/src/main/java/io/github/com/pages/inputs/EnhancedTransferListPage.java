package io.github.com.pages.inputs;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDITransferList;
import com.epam.jdi.light.material.elements.inputs.EnhancedTransferListNew;
import com.epam.jdi.light.material.elements.inputs.transferlist.EnhancedTransferList;

public class EnhancedTransferListPage extends WebPage {

    @UI(".MuiGrid-justify-xs-center")
    public static EnhancedTransferListNew enhancedTransferListNew;
}
