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
    private UIElement getSlideByIndex(int index) {
        return this.finds(".v-card").get(index);
    }

    @JDIAction("Slide is selected")
    public boolean slideIsSelected(int index) {
        return getSlideByIndex(index).getAttribute("class").contains("success")
                || getSlideByIndex(index).getAttribute("class").contains("active");
    }

    @JDIAction("Click on 'slide' {0}")
    public void clickOnSlideByIndex(int index) {
        getSlideByIndex(index).click();
    }

    @JDIAction("Click on 'next slides' button")
    public void clickOnNextButton() {
        getNextButton().click();
    }

    @JDIAction("Click on 'next slides' button")
    public boolean nextButtonIsDisabled() {
        return getNextButton().core().getAttribute("class").contains("disabled");
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
        return getPreviousButton().core().getAttribute("class").contains("disabled");
    }

    @JDIAction("Click on 'previous slides' button")
    public boolean previousButtonIsActive() {
        return !previousButtonIsDisabled();
    }
    public WebList getAllSlide(){
        return this.finds(".v-card");
    }
    @JDIAction("Get position of the '{name}'")
    public int position() {
        int index = -1;
        for (int i = 1; i <=getAllSlide().size(); i++){
            if (getSlideByIndex(i).getAttribute("class").contains("success")
                    || getSlideByIndex(i).getAttribute("class").contains("active")){
                index = i;
            }
        }
        return index;
    }

    public int selectedIndex(By by){
        List<WebElement> lstSlider = WebDriverFactory.getDriver().findElements(by);
        int index = 0;
        for(WebElement slider : lstSlider){
            if (slider.getAttribute("class").contains("v-slide-item--active")) {
                break;
            }
            index++;
        }
        return index;
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
