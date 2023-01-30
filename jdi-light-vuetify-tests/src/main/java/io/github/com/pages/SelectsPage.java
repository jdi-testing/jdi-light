package io.github.com.pages;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.vuetify.elements.complex.Select;
import io.github.com.custom.selects.IconSelect;
import io.github.com.custom.selects.SelectionSelect;

public class SelectsPage extends VuetifyPage {

    @JDropdown(root = "//div[@id = 'CustomTextAndValueSelect']//div[contains(@class, 'col-6')][2]//div[contains(@class, 'v-text-field--is-booted')]",
            value = "//div[contains(@class, 'v-select__selection--comma')]",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = "//i[contains(@class, 'v-icon')]")
    public static Dropdown customSelect;

    @JDropdown(root = "//div[@id = 'DenseSelect']//div[contains(@class, 'col-12')][1]//div[contains(@class, 'v-input--dense')]",
            value = "//input[@type = 'hidden']",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = "//i[contains(@class, 'v-icon')]")
    public static Select standardDenseSelect;

    @JDropdown(root = "//div[@id = 'DisabledSelect']//div[contains(@class, 'v-input--is-disabled')]",
            value = "//input[@type = 'hidden']",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = "//i[contains(@class, 'v-icon')]")
    public static Select disabledSelect;

    @JDropdown(root = "//div[@id = 'IconsSelect']//div[contains(@class, 'col-6')][2]//div[contains(@class, 'v-input--is-label-active')]",
            value = "//input[@type = 'hidden']",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = "//div[@class = 'v-input__slot']//i[contains(@class, 'v-icon')]")
    public static IconSelect prependedIconSelect;

    @JDropdown(root = "//div[@id = 'MenuPropsSelect']//div[contains(@class, 'v-text-field--is-booted')]",
            value = "//input[@type = 'hidden']",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = "//div[@class = 'v-input__slot']//i[contains(@class, 'v-icon')]")
    public static Select menuPropsSelect;

    @JDropdown(root = "//div[@id = 'MultipleSelect']//div[contains(@class, 'col-12')][2]//div[contains(@class, 'v-select--is-multi')]",
            value = "//input[@type = 'hidden']",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = "//div[@class = 'v-input__slot']//i[contains(@class, 'v-icon')]")
    public static Select multipleSelect;

    @JDropdown(root = "//div[@id = 'ReadonlySelect']//div[contains(@class, 'col-12')]//div[contains(@class, 'v-input--is-readonly')]",
            value = "//input[@type = 'hidden']",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = "//i[contains(@class, 'v-icon')]")
    public static Select readonlySelect;

    @JDropdown(root = "//div[@id = 'AppendAndPrependItemSelect']//div[contains(@class, 'v-select--is-multi')]",
            value = "//input[@type = 'hidden']",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = "//i[contains(@class, 'v-icon')]")
    public static Select appendAndPrependItemSelect;

    @JDropdown(root = "#SelectionSelect .v-select--is-multi",
            value = "//input[@type = 'hidden']",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = ".v-input__slot .v-icon")
    public static SelectionSelect selectionSelect;

}
