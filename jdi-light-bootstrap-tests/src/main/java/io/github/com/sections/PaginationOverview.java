package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Pagination;

public class PaginationOverview extends Section {

    @UI("li")
    public Pagination paginationItems;

}
