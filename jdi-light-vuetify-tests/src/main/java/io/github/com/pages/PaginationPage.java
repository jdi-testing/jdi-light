package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Pagination;

public class PaginationPage extends VuetifyPage {

    @UI("#CirclePagination .v-pagination")
    public static Pagination circlePagination;

    @UI("#DisabledPagination .v-pagination")
    public static Pagination disabledPagination;

    @UI("#IconsPagination .v-pagination")
    public static Pagination iconsPagination;

    @UI("#LengthPagination .v-pagination")
    public static Pagination lengthPagination;

    @UI("#TotalVisiblePagination .v-pagination")
    public static Pagination totalVisiblePagination;
}
