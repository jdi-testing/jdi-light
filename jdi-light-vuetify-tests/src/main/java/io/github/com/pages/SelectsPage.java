package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.vuetify.elements.complex.Select;

public class SelectsPage extends VuetifyPage {

    @JDropdown(root = "//div[@id = 'DenseSelect']//div[contains(@class, 'col-12')][1]//div[contains(@class, 'v-input--dense')]",
            value = "//input[@type = 'hidden']",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = "//i[contains(@class, 'v-icon')]",
            autoClose = true)
    public static Select standardDenseSelect;

    @JDropdown(root = "//div[@id = 'DenseSelect']//div[contains(@class, 'col-12')][3]//div[contains(@class, 'v-input--dense')]",
            value = "//input[@type = 'hidden']",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = "//i[contains(@class, 'v-icon')]",
            autoClose = true)
    public static Select outlinedStyleSelect;




    @JDropdown(root = "//div[@id = 'IconsSelect']//div[contains(@class, 'col-6')][2]//div[contains(@class, 'v-input--is-label-active')]",
            value = "//input[@type = 'hidden']",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = "//div[@class = 'v-input__slot']//i[contains(@class, 'v-icon')]",
            autoClose = false)
    public static Select leftIconSelect;

    @JDropdown(root = "//div[@id = 'MenuPropsSelect']//div[contains(@class, 'v-text-field--is-booted')]",
            value = "//input[@type = 'hidden']",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = "//div[@class = 'v-input__slot']//i[contains(@class, 'v-icon')]",
            autoClose = false)
    public static Select menuPropsSelect;

    @JDropdown(root = "//div[@id = 'MultipleSelect']//div[contains(@class, 'col-12')][2]//div[contains(@class, 'v-select--is-multi')]",
            value = "//input[@type = 'hidden']",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = "//div[@class = 'v-input__slot']//i[contains(@class, 'v-icon')]",
            autoClose = false)
    public static Select multipleSelect;

}
