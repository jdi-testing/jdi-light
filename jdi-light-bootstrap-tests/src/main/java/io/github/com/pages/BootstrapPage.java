package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import io.github.com.sections.CardExample;
import io.github.com.sections.CardWithSubtitlesAndLinks;
import io.github.com.sections.InputGroupInputWithText;
import io.github.com.sections.Jumbotron;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton, disabledButton;

    @Css("#jumbotron-fluid") public static Jumbotron jumbotronFluid;
    @Css("#jumbotron") public static Jumbotron jumbotron;

    @Css("#input-group-username") public static InputGroupInputWithText inputGroupUsername;

    @Css("#card-example") public static CardExample cardExample;
    @Css("#card-subtitle-link") public static CardWithSubtitlesAndLinks cardWithSubtitlesAndLinks;
    //endregion

    //region Complex Elements


    //endregion
}