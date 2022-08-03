package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.SlideGroupAssert;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.jdiai.tools.Timer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * To see an example of SlideGroup web element please visit https://vuetifyjs.com/en/components/slide-groups/
 */

public class SlideGroup extends ItemGroup {

    @JDIAction("Get '{name}'s 'next slides' button")
    private VuetifyButton getNextButton() {
        return new VuetifyButton(find(".v-slide-group__next"));
    }

    @JDIAction("Get '{name}'s 'previous slides' button")
    private VuetifyButton getPreviousButton() {
        return new VuetifyButton(find(".v-slide-group__prev"));
    }

    @JDIAction("Get '{name}' position of visible slides")
    public String slidesPosition() {
        return this.find(".v-slide-group__content").getAttribute("style");
    }

    @JDIAction("Get '{name}' slide by index")
    public UIElement slideByIndex(int index) {
        return this.finds(".v-card").get(index);
    }

    @JDIAction("Slide is selected")
    public boolean slideIsSelected(int index) {
        return slideByIndex(index).getAttribute("class").contains("success")
                || slideByIndex(index).getAttribute("class").contains("active");
    }

    @JDIAction("Click on 'slide' {0}")
    public void clickOnSlideByIndex(int index) {
        slideByIndex(index).click();
    }

    @JDIAction("Click on 'next slides' button")
    public void clickOnNextButton() {
        getNextButton().click();
    }

    @JDIAction("Click on 'next slides' button")
    public boolean nextButtonIsDisabled() {
        return getNextButton().hasClass("v-slide-group__next--disabled");
    }

    @JDIAction("Click on 'next slides' button")
    public boolean nextButtonIsActive() {
        return !nextButtonIsDisabled();
    }

    @JDIAction("Click on 'previous slides' button")
    public void clickOnPreviousButton() {
        getPreviousButton().click();
    }

    @JDIAction("Click on 'previous slides' button")
    public boolean previousButtonIsDisabled() {
        return getPreviousButton().hasClass("v-slide-group__prev--disabled");
    }

    @JDIAction("Click on 'previous slides' button")
    public boolean previousButtonIsActive() {
        return !previousButtonIsDisabled();
    }

    public WebList getSlidesCount() {
        return this.finds(".v-card");
    }

    @JDIAction("Get position of the '{name}'")
    public int position() {
        int index = 0;
        int position = -1;
        for (WebElement slideCard : getSlidesCount()) {
            index++;
            if (slideCard.getAttribute("class").contains("active")) {
                position = index;
                break;
            }
        }
        return position;
    }

    private List<WebElement> getAllSlides(By by) {
        return WebDriverFactory.getDriver().findElements(by);
    }

    /**
     * Check other slide not selected except
     *
     * @param slideId: id of slide from list {#ActiveClassSlideGroup, #CenterActiveSlideGroup,
     *                 #CustomIconsSlideGroup, #MultipleSlideGroup, #PseudoCarouselSlideGroup}
     * @param indexes: indexes of slide that test select
     * @return comparison between expected indexes and actual selected index of slides
     */
    public boolean notSelectedExcept(String slideId, int... indexes) {
        int[] example1 = allSelectedIndexes(slideId).stream().mapToInt(i -> i).toArray();
        return Arrays.equals(indexes, example1);
    }

    /**
     * Get selected index of slide group
     *
     * @param slideId: id of slide from list {#ActiveClassSlideGroup, #CenterActiveSlideGroup,
     *                 #CustomIconsSlideGroup, #MultipleSlideGroup, #PseudoCarouselSlideGroup}
     * @return index of selected Slide
     */
    public int selectedIndex(String slideId) {
        List<WebElement> lstSlider = getAllSlides(By.cssSelector(slideId + " .v-card"));
        int index = 0;
        int selectedIndex = -1;
        for (WebElement slider : lstSlider) {
            if (slider.getAttribute("class").contains("v-slide-item--active")) {
                selectedIndex = index;
                break;
            }
            index++;
        }
        return selectedIndex;
    }

    public List<Integer> allSelectedIndexes(String slideId) {
        List<Integer> listSelectedIndex = new ArrayList<>();
        List<WebElement> lstSlider = getAllSlides(By.cssSelector(slideId + " .v-card"));
        int index = 1;
        for (WebElement slider : lstSlider) {
            if (slider.getAttribute("class").contains("active") ||
                    slider.getAttribute("class").contains("success")) {
                listSelectedIndex.add(index);
            }
            index++;
        }
        return listSelectedIndex;
    }

    public void startTest() {
        clickOnNextButton();
        clickOnPreviousButton();
        Timer.waitCondition(() -> slidesPosition().equals("transform: translateX(0px);"));
    }

    public SlideGroupAssert is() {
        SlideGroupAssert slideGroupAssert = new SlideGroupAssert();
        slideGroupAssert.set(this);
        return slideGroupAssert;
    }

    public SlideGroupAssert has() {
        return this.is();
    }
}
