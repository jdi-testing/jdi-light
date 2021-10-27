package io.github.com.pages;

import com.epam.jdi.light.vuetify.annotations.JDIPagination;
import com.epam.jdi.light.vuetify.elements.complex.Pagination;

public class PaginationPage extends VuetifyPage {

    @JDIPagination(
            root = "#CirclePagination .v-pagination",
            items = ".v-pagination__item",
            left = ".v-pagination__navigation[1]",
            right = ".v-pagination__navigation[2]",
            more = ".v-pagination__more"
    )
    public static Pagination circlePagination;

    @JDIPagination(root = "#DisabledPagination .v-pagination")
    public static Pagination disabledPagination;

    @JDIPagination(root = "#IconsPagination .v-pagination")
    public static Pagination iconsPagination;

    @JDIPagination(root = "#LengthPagination .v-pagination")
    public static Pagination lengthPagination;

    @JDIPagination(root = "#TotalVisiblePagination .v-pagination")
    public static Pagination totalVisiblePagination;
}
