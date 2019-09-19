package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Alert;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Carousel;

import io.github.com.sections.ButtonWithDropdown;
import io.github.com.sections.CardExample;
import io.github.com.sections.InputGroupInputWithCheckBox;
import io.github.com.sections.InputGroupInputWithRadio;
import io.github.com.sections.InputGroupInputWithText;
import io.github.com.sections.Jumbotron;
import io.github.com.sections.SegmentedButton;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton, disabledButton;
    @UI("#simple-alert") public static Alert simpleAlert;
    @UI("#dismissible-alert") public static Alert dismissibleAlert;
    @UI("#jumbotron-fluid") public static Jumbotron jumbotronFluid;
    @UI("#jumbotron") public static Jumbotron jumbotron;
    //endregion
  
    //region Complex Elements
    @UI("#carousel-example-slides-only") public static Carousel carouselWithSlidesOnly;
    @UI("#carousel-example-controls") public static Carousel carouselWithControls;
    @UI("#carousel-example-indicators") public static Carousel carouselWithIndicators;
    @UI("#carousel-example-captions") public static Carousel carouselWithCaptions;
    @UI("#carousel-example-fade") public static Carousel carouselWithFadeTransition;
    @UI("#carousel-example-interval") public static Carousel carouselWithCustomInterval;
    //endregion
    
    //region Composite Elements
    @UI("#input-group-username") public static InputGroupInputWithText inputGroupUsername;
    @UI("#input-group-checkbox") public static InputGroupInputWithCheckBox inputGroupCheckBox;
    @UI("#input-group-radio") public static InputGroupInputWithRadio inputGroupRadio;
    @UI("#card-example") public static CardExample cardExample;
    @UI("#button-with-dropdown") public static ButtonWithDropdown buttonWithDropdown;
    @UI("#segmented-button") public static SegmentedButton segmentedButton;
    //endregion
}