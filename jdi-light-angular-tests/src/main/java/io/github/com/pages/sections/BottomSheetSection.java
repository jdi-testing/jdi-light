package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.BottomSheet;
import com.epam.jdi.light.angular.elements.complex.Paginator;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class BottomSheetSection {
    @UI("#open-bottom-sheet-button")
    public static Button openBottomSheetButton;

    @UI("#bottom-sheet")
    public static BottomSheet bottomSheet;
}
