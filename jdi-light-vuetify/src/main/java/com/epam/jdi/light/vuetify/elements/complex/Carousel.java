package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.asserts.CarouselAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.common.ProgressLinear;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasImage;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsLoading;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Carousel web element please visit https://v2.vuetifyjs.com/en/components/carousels/
 */

public class Carousel extends UIBaseElement<CarouselAssert> implements IsText, HasImage, HasColor, HasTheme, IsLoading,
        HasMeasurement {
    private static final String CONTENT_LOCATOR = ".v-window__container";
    private static final String CONTENT_IMAGES_LOCATOR = ".v-image";
    private static final String CONTENT_TEXT_LOCATOR = ".text-h2";
    private static final String CONTROLS = ".v-carousel__controls";
    private static final String NEXT_BUTTON = ".v-window__next button";
    private static final String PREVIOUS_BUTTON = ".v-window__prev button";
    private static final String WINDOW_ITEM = ".v-window-item";
    private static final String PROGRESS_BAR = "div[role='progressbar']";
    private static final String SHEET = ".v-sheet";
    private static final String COUNTER = "div.justify-space-around";
    @JDIAction("Get '{name}' content")
    public UIElement content() {
        return core().find(CONTENT_LOCATOR);
    }

    public UIElement contentText() {
        return content().find(CONTENT_TEXT_LOCATOR);
    }

    public String getContentText() {
        return contentText().getText();
    }

    public Image contentImage() {
        return new Image().setCore(Image.class, content().find(CONTENT_IMAGES_LOCATOR));
    }

    @JDIAction("Get '{name}' delimiters")
    public ButtonGroup delimiters() {
        return new ButtonGroup(core().find(CONTROLS));
    }

    @JDIAction("Get '{name}' 'next' button")
    public VuetifyButton nextButton() {
        return new VuetifyButton(core().find(NEXT_BUTTON));
    }

    @JDIAction("Get '{name}' 'previous' button")
    public VuetifyButton previousButton() {
        return new VuetifyButton(core().find(PREVIOUS_BUTTON));
    }

    @JDIAction("Get '{name}' progress bar")
    public ProgressLinear progressBar() {
        return new ProgressLinear().setCore(ProgressLinear.class, core().find(PROGRESS_BAR));
    }

    @JDIAction("Get '{name}' delimiters' icons")
    public List<Icon> getDelimitersIcons() {
        return delimiters().getAllButtons().stream()
                .map(e -> new Icon().setCore(Icon.class, e.find("i")))
                .collect(Collectors.toList());
    }

    @Override
    @JDIAction("Get '{name}' content text color")
    public String color() {
        return contentText().css("color");
    }

    @Override
    @JDIAction("Get '{name}' content background color")
    public String backgroundColor() {
        return content().find(SHEET).getCssValue("background-color");
    }

    @Override
    public String getText() {
        return core().find(CONTENT_TEXT_LOCATOR).getText();
    }

    @Override
    @JDIAction("Get '{name}' current slide background image")
    public Image image() {
        return new Image().setCore(Image.class, core().find(CONTENT_IMAGES_LOCATOR));
    }

    @JDIAction("Get '{name}' slide counter")
    public Text slideCounter() {
        return new Text().setCore(Text.class, core().find(COUNTER));
    }

    @JDIAction("Go to slide number {0}")
    public void goToSlide(int slideNumber) {
        if (!delimiters().isHidden()) {
            delimiters().getButtonByIndex(slideNumber).click();
        } else {
            int currentIndex = index();
            while (currentIndex != slideNumber && currentIndex <= getAllSlides().size()) {
                nextButton().click();
                currentIndex++;
            }
        }
    }

    @JDIAction("Get all '{name}' slides")
    public List<WebElement> getAllSlides() {
        return core().findElements(By.cssSelector(WINDOW_ITEM));
    }

    @JDIAction("Get '{name}' index of current slide")
    public int index() {
        int index = 1;
        for (WebElement slide : getAllSlides()) {
            if (!slide.getAttribute("style").contains("display: none")) {
                break;
            }
            index++;
        }
        return index;
    }

    @JDIAction("Get '{name}' 'plus' button")
    public VuetifyButton plusButton() {
        return new VuetifyButton(core().find("div.justify-space-around button.mdi-plus"));
    }

    @JDIAction("Get '{name}' 'minus' button")
    public VuetifyButton minusButton() {
        return new VuetifyButton(core().find("div.justify-space-around button.mdi-minus"));
    }

    @JDIAction("Get if '{name}' shows arrows on hover")
    public boolean showArrowsOnHover() {
        return core().hasClass("v-window--show-arrows-on-hover");
    }

    @JDIAction("Get if '{name}' hides delimiters")
    public boolean hideDelimiters() {
        return core().hasClass("v-carousel--hide-delimiter-background");
    }

    @JDIAction("Get if '{name}' has vertical delimiters")
    public boolean hasVerticalDelimiters() {
        return core().hasClass("v-carousel--vertical-delimiters");
    }

    @Override
    @JDIAction("Get if '{name}' is loading")
    public boolean isLoading() {
        return progressBar().isExist();
    }

    @JDIAction("Get '{name}' loader height")
    public int getLoaderHeight() {
        return Integer.parseInt(progressBar().css("height").replace("px", ""));
    }

    public CarouselAssert is() {
        return new CarouselAssert().set(this);
    }
}
