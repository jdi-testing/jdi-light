package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Jumbotron;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton;

    @Css("[class=\"jumbotron\"]") public static Jumbotron jumbotron;
    @Css(".jumbotron.jumbotron-fluid") public static Jumbotron jumbotronFluid;
    @Css("a[class=\"btn btn-primary btn-lg\"]") public static Button learnMoreBtn;
    //endregion

    //region Complex Elements

    //endregion

}