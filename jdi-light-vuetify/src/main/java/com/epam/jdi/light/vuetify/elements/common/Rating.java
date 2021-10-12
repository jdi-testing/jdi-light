package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JDIRating;
import com.epam.jdi.light.vuetify.elements.complex.Breadcrumbs;
import com.epam.jdi.tools.map.MapArray;
import org.openqa.selenium.Dimension;

import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.ElementArea.TOP_LEFT;
import static com.epam.jdi.light.common.ElementArea.TOP_RIGHT;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * To see an example of Rating web element please visit https://vuetifyjs.com/en/components/ratings
 */
public class Rating extends UIBaseElement<UISelectAssert<?, ?>> implements ISetup  {

//    protected String ROOT_LOCATOR = ".v-rating";
//    protected String EMPTY_ICON_LOCATOR = ".mdi-star-outline";
//    protected String FULL_ICON_LOCATOR = ".mdi-star";
//    protected String HALF_ICON_LOCATOR = ".mdi-star-half-full";
//    protected String BACKGROUND_COLOR_LOCATOR = ".grey--text";
    protected String ROOT_LOCATOR = ".v-rating";
    protected String EMPTY_ICON_LOCATOR = "mdi-star-outline";
    protected String FULL_ICON_LOCATOR = ".mdi-star";
    protected String HALF_ICON_LOCATOR = ".mdi-star-half-full";
    protected String COLOR_LOCATOR = ".grey--text";
    protected String BACKGROUND_COLOR_LOCATOR = ".grey--text";
    protected String BACKGROUND_DARKEN_LOCATOR = ".text--lighten-1";

    @JDIAction("Get {name} rating buttons")
    public WebList getRatingButtons() {
        return core().finds("button");
    }


    public int length() {
        return getRatingButtons().size();
    }

    public int size() {
        return Integer.parseInt(getRatingButtons().get(1).getAttribute("style").replaceFirst("[^0-9]", ""));
    }

    @JDIAction("Set {name} rating to {0}")
    public void setRating(double rating) {
        if (rating % 1 == 0) {
            getRatingButtons().get((int) rating).click(TOP_LEFT);
        } else {
            getRatingButtons().get((int) rating).click(TOP_RIGHT);
        }
    }

    protected double rating(UIElement element){
        String[] res = element.getAttribute("aria-label").replaceAll("\\d+", ";").split(";");
//        double DOB = Double.parseDouble(res);
        return Double.parseDouble(element.getAttribute("aria-label").replaceFirst("[^0-9]", ""));
    }

    protected UIElement distinctiveElement(String locator){
        return getRatingButtons().stream().filter(button -> button.hasClass(locator)).findFirst().orElse(null);
    }

    @JDIAction("Get {name} rating")
    public double getRating() {
        if(!HALF_ICON_LOCATOR.isEmpty()){
            UIElement distinctiveElement = distinctiveElement(HALF_ICON_LOCATOR);
            if(distinctiveElement != null){
                return rating(distinctiveElement) + 0.5;
            }
        }

        if(FULL_ICON_LOCATOR != EMPTY_ICON_LOCATOR){
            UIElement distinctiveElement = distinctiveElement(EMPTY_ICON_LOCATOR);
            if(distinctiveElement == null){
                distinctiveElement = distinctiveElement(FULL_ICON_LOCATOR);
            }
            if(distinctiveElement != null){
                return rating(distinctiveElement);
            }
        }

        if(BACKGROUND_COLOR_LOCATOR != COLOR_LOCATOR){
            UIElement distinctiveElement = distinctiveElement(EMPTY_ICON_LOCATOR);
            if(distinctiveElement != null){
                return rating(distinctiveElement);
            }
        }

        if(!BACKGROUND_DARKEN_LOCATOR.isEmpty()){
            UIElement distinctiveElement = distinctiveElement(BACKGROUND_DARKEN_LOCATOR);
            if(distinctiveElement != null){
                return rating(distinctiveElement);
            }
        }

        return length();
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDIRating.class, Breadcrumbs.class)) {
            JDIRating annotation = field.getAnnotation(JDIRating.class);
            initializeLocators(annotation);
        }
        this.setCore(Breadcrumbs.class, $(ROOT_LOCATOR));
        this.setName(String.format("Rating container %s", field.getName()));
    }

    private void initializeLocators(JDIRating annotation) {
        if (!annotation.root().isEmpty()) {
            ROOT_LOCATOR = annotation.root();
        }
        if (!annotation.emptyIcon().isEmpty()) {
            EMPTY_ICON_LOCATOR = annotation.emptyIcon();
        }
        if (!annotation.fullIcon().isEmpty()) {
            FULL_ICON_LOCATOR = annotation.fullIcon();
        }
        if (!annotation.halfIcon().isEmpty()) {
            HALF_ICON_LOCATOR = annotation.halfIcon();
        }
        if (!annotation.backgroundColor().isEmpty()) {
            BACKGROUND_COLOR_LOCATOR = annotation.backgroundColor();
        }
        if (!annotation.color().isEmpty()) {
            COLOR_LOCATOR = annotation.color();
        }
        if (!annotation.backgroundDarken().isEmpty()) {
            BACKGROUND_DARKEN_LOCATOR = annotation.backgroundDarken();
        }
    }
}
