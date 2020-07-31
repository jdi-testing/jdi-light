package io.github.com.pages.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.angular.elements.complex.Paginator;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class PaginatorSection {
    @UI("#mat-input-81")
    public TextField listLength;

    @UI("#mat-input-82")
    public TextField pageSize;

    @UI("#mat-input-83")
    public TextField pageSizeOptions;

    @UI("//paginator-configurable-example/mat-paginator")
    public Paginator paginator;
}
