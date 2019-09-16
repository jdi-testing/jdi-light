package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import io.github.com.sections.InputGroupInputWithText;
import io.github.com.sections.MediaObject;


public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton;
    @Css("#input-group-username") public static InputGroupInputWithText inputGroupUsername;

    @Css("#media-object-sample") public static MediaObject mediaObjectSample;
    @Css("#media-object-nesting") public static MediaObject mediaObjectNesting;
    @Css("#media-object-list") public static MediaObject mediaObjectList;
    //endregion

    //region Complex Elements

    //endregion

}