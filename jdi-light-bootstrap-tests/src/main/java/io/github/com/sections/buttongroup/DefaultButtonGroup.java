package io.github.com.sections.buttongroup;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultButtonGroup extends Section {

    @Css(".btn-group .btn-danger")
    public static Button redButton;

    @Css(".btn-group .btn-success:not(.dropdown-toggle)")
    public static Button greenButton;

    @JDropdown(expand = "#btnGroupDrop1",
                value = ".dropdown-menu",
                list = ".dropdown-item")
    public static Dropdown dropdownButton;

    public enum Option {
        JDI("JDI"), JDI_DOCUMENTATION("JDI documentation");

        String title;

        Option(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public static List<String> getValues() {
            return Stream.of(Option.values()).map(option -> option.getTitle()).collect(Collectors.toList());
        }
    }
}