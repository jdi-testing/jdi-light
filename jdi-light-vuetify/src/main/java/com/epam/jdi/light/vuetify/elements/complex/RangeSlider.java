package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.RangeSliderAssert;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Range Slider web element please visit https://vuetifyjs.com/en/components/range-sliders
 */
public class RangeSlider extends UIBaseElement<RangeSliderAssert> {

    private static final String DISABLED = "v-slider--disabled";
    private static final String VERTICAL = "v-slider--vertical";

    private String thumbContainerLocator = ".v-slider__thumb-container";
    private String thumbLocator = ".v-slider__thumb";
    private String thumbLabelContainerLocator = ".v-slider__thumb-label-container";
    private String thumbLabelLocator = ".v-slider__thumb-label";

    private String trackContainerLocator = ".v-slider__track-container";
    private String trackBackgroundLocator = ".v-slider__track-background";
    private String trackFillLocator = ".v-slider__track-fill";

    private String ticksContainerLocator = ".v-slider__ticks-container";
    private String alwaysShow = "v-slider__ticks-container--always-show";
    private String tickLabelLocator = ".v-slider__tick-label";
    private String colorPickerLocator = ".v-color-picker__input input";

    @JDIAction("Get track container from '{name}'")
    protected UIElement getTrackContainer() {
        return $(trackContainerLocator, this);
    }

    @JDIAction("Get track background from '{name}'")
    public WebList getBackground() {
        return $$(trackBackgroundLocator, getTrackContainer());
    }

    @JDIAction("Get thumb container from '{name}'")
    protected WebList getThumbContainer() {
        return $$(thumbContainerLocator, this);
    }

    @JDIAction("Get left thumb from '{name}'")
    public UIElement getLeftThumb() {
        return $(thumbLocator, getThumbContainer().get(1));
    }

    @JDIAction("Get right thumb from '{name}'")
    public UIElement getRightThumb() {
        return $(thumbLocator, getThumbContainer().get(2));
    }

    @JDIAction("Get thumb label from '{name}'")
    public WebList getThumbLabel() {
        return $$(thumbLabelLocator, this);
    }

    @JDIAction("Get tick label value from '{name}'")
    public String getTickLabel(int index) {
        return $$(tickLabelLocator, this).get(index).getValue();
    }

    @JDIAction("Get track fill container from '{name}'")
    protected UIElement getTrackFillContainer() {return $(trackFillLocator, getTrackContainer());}

    @JDIAction("Get value from '{name}'")
    public List<Integer> getValue() {
        return new WebList(core().findElements(By.cssSelector("input")))
                .stream()
                .map(input -> Integer.parseInt(input.getAttribute("value")))
                .collect(Collectors.toList());
    }

    @JDIAction("Get value from '{name}'")
    public Integer getLeftValue() {
        return Integer.parseInt(core().findElement(By.cssSelector("[id*='input-min']"))
                .getAttribute("value"));
    }

    @JDIAction("Get value from '{name}'")
    public Integer getRightValue() {
        return Integer.parseInt(core().findElement(By.cssSelector("[id*='input-max']")).getAttribute("value"));
    }

    @JDIAction("Get thumb label value from '{name}'")
    public List<String> getThumbLabelValue() {
        return getThumbLabel()
                .stream()
                .map(thumbLabel -> thumbLabel.find("i").getAttribute("class"))
                .collect(Collectors.toList());
    }

    @JDIAction("Set slider from '{name}' to {0}")
    public void setLeftValue(int valueLeft, boolean isVertical){
        List<Double> nowValue = getCurrentLocationValue();
        if (isVertical){
            double trackHeight = getTrackContainer().getSize().height;
            double minValue = Double.parseDouble(getThumbContainer().get(1).getAttribute("aria-valuemin"));
            double pixelsInUnit = getPixelsInUnit(trackHeight);
            dragAndDropToYOffsetLeft(valueLeft, minValue, pixelsInUnit, nowValue);
        } else {
            double trackWidth = getTrackContainer().getSize().width;
            double pixelsInUnit = getPixelsInUnit(trackWidth);
            dragAndDropToXOffsetLeft(valueLeft, pixelsInUnit, nowValue);
        }
    }

    @JDIAction("Set slider from '{name}' to {0}")
    public void setRightValue(int valueRight, boolean isVertical){
        List<Double> nowValue = getCurrentLocationValue();
        if (isVertical){
            double trackHeight = getTrackContainer().getSize().height;
            double minValue = Double.parseDouble(getThumbContainer().get(1).getAttribute("aria-valuemin"));
            double pixelsInUnit = getPixelsInUnit(trackHeight);
            dragAndDropToYOffsetRight(valueRight, minValue, pixelsInUnit, nowValue);
        }
        else {
            double trackWidth = getTrackContainer().getSize().width;
            double pixelsInUnit = getPixelsInUnit(trackWidth);
            dragAndDropToXOffsetRight(valueRight, pixelsInUnit,nowValue);
        }
    }

    @JDIAction("Set slider from '{name}' to {0}, {1}")
    public void setValue(int valueLeft, int valueRight, boolean isVertical){
        List<Double> nowValue = getCurrentLocationValue();
        if (isVertical){
            double trackHeight = getTrackContainer().getSize().height;
            double minValue = Double.parseDouble(getThumbContainer().get(1).getAttribute("aria-valuemin"));
            double pixelsInUnit = getPixelsInUnit(trackHeight);
            dragAndDropToYOffsetLeft(valueLeft, minValue, pixelsInUnit, nowValue);
            dragAndDropToYOffsetRight(valueRight, minValue, pixelsInUnit, nowValue);
        }
        else {
            double trackWidth = getTrackContainer().getSize().width;
            double pixelsInUnit = getPixelsInUnit(trackWidth);
            dragAndDropToXOffsetLeft(valueLeft, pixelsInUnit, nowValue);
            dragAndDropToXOffsetRight(valueRight, pixelsInUnit,nowValue);
        }
    }

    @Override
    @JDIAction("Check if '{name}' disabled")
    public boolean isDisabled() {
        return core().hasClass(DISABLED);
    }

    @JDIAction("Check if '{name}' vertical")
    public boolean isVertical() {
        return core().hasClass(VERTICAL);
    }

    @JDIAction("Check if ticks of '{name}' always show")
    public boolean isAlwaysShow() {
        return $(ticksContainerLocator, this).hasClass(alwaysShow);
    }

    @JDIAction("Check if thumb label of '{name}' displayed")
    public boolean isThumbLabelDisplayed() {
        return new WebList(core().findElements(By.cssSelector(thumbLabelContainerLocator)))
                .stream()
                .noneMatch(label -> label.getAttribute("style").contains("display: none"));
    }

    @JDIAction("Set '{color}' to ranger slider")
    public void setRangerSliderColor(String red, String green, String blue) {
        List<UIElement> colorInputs = getRangerSliderColorPicker();
        colorInputs.get(1).clear();
        colorInputs.get(1).sendKeys(red);
        colorInputs.get(2).clear();
        colorInputs.get(2).sendKeys(green);
        colorInputs.get(3).clear();
        colorInputs.get(3).sendKeys(blue);
    }

    @JDIAction("Get '{name}' track color")
    public String trackColor() {
        return getTrackFillContainer().css("background-color");
    }

    @JDIAction("Get '{name}' leftThumb size")
    public int getLeftThumbSize() {
        return Integer.parseInt(getLeftThumb().css("font-size").replace("px", ""));
    }

    @JDIAction("Get '{name}' rightThumb size")
    public int getRightThumbSize() {
        return Integer.parseInt(getRightThumb().css("font-size").replace("px", ""));
    }

    @Override
    public RangeSliderAssert is() {
        return new RangeSliderAssert().set(this);
    }

    @JDIAction("Get '{name}' color picker")
    private List<UIElement> getRangerSliderColorPicker() {
        return $$(colorPickerLocator, this);
    }

    @JDIAction("Get '{name}' pixels in unit")
    private double getPixelsInUnit(double trackWidthOrHeight){
        double minValue = Double.parseDouble(getThumbContainer().get(1).getAttribute("aria-valuemin"));
        double maxValue = Double.parseDouble(getThumbContainer().get(1).getAttribute("aria-valuemax"));
        return trackWidthOrHeight / (maxValue - minValue);
    }

    @JDIAction("Get '{name}' current location value")
    private List<Double> getCurrentLocationValue(){
        return Arrays.stream(getThumbContainer().get(1).getAttribute("aria-valuenow").split(","))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    @JDIAction("Drag and drop'{name}' to the X offset left")
    private void dragAndDropToXOffsetLeft(int valueLeft, double pixelsInUnit, List<Double> nowValue){
        double xOffsetLeft = (valueLeft - nowValue.get(0)) * pixelsInUnit;
        getLeftThumb().dragAndDropTo((int) Math.round(xOffsetLeft), 0);
    }

    @JDIAction("Drag and drop'{name}' to the X offset right")
    private void dragAndDropToXOffsetRight(int valueRight, double pixelsInUnit, List<Double> nowValue){
        double xOffsetRight = (valueRight - nowValue.get(1)) * pixelsInUnit;
        getRightThumb().dragAndDropTo((int) Math.round(xOffsetRight), 0);
    }

    @JDIAction("Drag and drop'{name}' to the Y offset left")
    private void dragAndDropToYOffsetLeft(int valueLeft, double minValue, double pixelsInUnit, List<Double> nowValue){
        double yOffsetLeft = (valueLeft - minValue) * pixelsInUnit - (nowValue.get(0) - minValue) * pixelsInUnit;
        getLeftThumb().dragAndDropTo(0, -(int) Math.round(yOffsetLeft));
    }

    @JDIAction("Drag and drop'{name}' to the Y offset right")
    private void dragAndDropToYOffsetRight(int valueRight, double minValue, double pixelsInUnit, List<Double> nowValue){
        double yOffsetRight = (valueRight - minValue) * pixelsInUnit - (nowValue.get(1) - minValue) * pixelsInUnit;
        getRightThumb().dragAndDropTo(0, -(int) Math.round(yOffsetRight));
    }
}
