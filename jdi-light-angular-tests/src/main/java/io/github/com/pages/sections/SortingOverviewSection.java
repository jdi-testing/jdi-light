package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.SortingOverview;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class SortingOverviewSection extends Section {
    @UI("#sort-headers tr:nth-child(1)")
    public static SortingOverview sortingOverview;
}