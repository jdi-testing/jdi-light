package com.jdiai;

import com.epam.jdi.tools.map.MapArray;
import com.google.gson.JsonObject;
import com.jdiai.interfaces.HasCore;
import com.jdiai.interfaces.HasLocators;
import com.jdiai.interfaces.HasParent;
import com.jdiai.jsbuilder.IJSBuilder;
import com.jdiai.jsproducer.Json;
import com.jdiai.tools.ClientRect;
import com.jdiai.tools.GetTextTypes;
import com.jdiai.tools.JSImages;
import com.jdiai.visual.Direction;
import com.jdiai.visual.ImageTypes;
import com.jdiai.visual.OfElement;
import com.jdiai.visual.StreamToImageVideo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

public interface JS extends WebElement, HasLocators, HasParent, HasCore {
    String getElement(String valueFunc);
    List<String> getList(String valueFunc);
    String filterElements(String valueFunc);
    String getJSResult(String action);
    JS set(String action);
    JS setOption(String option);
    JS selectByName(String name);
    String selectedValueOption();
    String selectedOption();
    String getText();
    boolean isDisplayed();
    default boolean isHidden() {
        return !isDisplayed();
    }
    default boolean isEnabled() {
        return !isDisabled();
    }
    boolean isDisabled();
    boolean isVisible();
    boolean isInView();
    default boolean isNotVisible() {
        return !isVisible();
    }
    default boolean isOutOfView() {
        return !isInView();
    }
    boolean isExist();
    boolean isNotCovered();
    default boolean isNotExist() {
        return !isExist();
    }
    JS doAction(String action);
    JS weElementActions(BiFunction<Actions, WebElement, Actions> action);
    JS weActions(BiFunction<Actions, WebElement, Actions> action);
    JS clickCenter();
    JS click(int x, int y);
    JS select();
    JS select(String value);
    JS selectSubList(String value);
    JS setFindTextLocator(String locator);
    JS select(String... values);
    <TEnum extends Enum<?>> void select(TEnum name);
    JS check(boolean condition);
    JS check();
    JS uncheck();
    JS rightClick();
    JS doubleClick();
    JS hover();
    JS dragAndDropTo(WebElement to);
    JS dragAndDropTo(int x, int y);
    JS input(CharSequence... value);
    JS slide(String value);
    String tag();
    String getProperty(String property);
    Json getJson(String valueFunc);
    List<String> getAttributesAsList(String attr);
    Json allAttributes();
    JS highlight(String color);
    String cssStyle(String style);
    Json cssStyles(String... style);
    Json allCssStyles();
    boolean isDeselected();
    JS setTextType(GetTextTypes textType);
    String getText(GetTextTypes textType);
    ClientRect getClientRect();
    File makeScreenshot(String tag);
    JS startRecording();
    JS startRecording(ImageTypes imageType);
    StreamToImageVideo stopRecordingAndSave(ImageTypes imageType);
    StreamToImageVideo stopRecordingAndSave();
    StreamToImageVideo recordCanvasVideo(int sec);
    StreamToImageVideo recordCanvasVideo(ImageTypes imageType, int sec);
    // Experimental record video for any element
    StreamToImageVideo recordVideo(int sec);
    JS setObjectMapping(String objectMap, Class<?> cl);
    JsonObject getJSObject(String json);
    <T> T getEntity(Class<T> cl);
    <T> T getEntity();
    <T> T getEntity(String objectMap, Class<?> cl);
    void setEntity(String objectMap);
    JS find(String by);
    JS find(By by);
    JS children();
    JS ancestor();
    List<String> values(GetTextTypes getTextType);
    List<String> values();
    int size();
    List<JsonObject> getObjectList(String json);
    <T> List<T> getEntityList();
    void setEntity();
    <T> List<T> getEntityList(Class<T> cl);
    JS fill(Object obj);
    JS submit(Object obj, String locator);
    JS submit(Object obj);
    JS loginAs(Object obj, String locator);
    JS loginAs(Object obj);
    JS setEntity(Object obj);
    <T> List<T> getEntityList(String objectMap, Class<?> cl);
    JS setEntityList(String objectMap);
    JS findFirst(String by, Function<JS, String> condition);
    JS findFirst(By by, Function<JS, String> condition);
    JS findFirst(String by, String condition);
    JS get(int index);
    JS get(String by, int index);
    JS get(By by, int index);
    JS get(Function<JS, String> filter);
    JS get(String value);
    JS findFirst(Function<JS, String> condition);
    JS findFirst(String condition);
    JS findFirst(By by, String condition);
    long indexOf(Function<JS, String> condition);
    JS uploadFile(String filePath);
    JS press(Keys key);
    JS keyboardCommands(String... commands);
    boolean isNotCovered(int xOffset, int yOffset);
    String fontColor();
    String bgColor();
    String pseudo(String name, String value);
    boolean focused();
    JS focus();
    JS blur();
    JSImages imagesData();
    File getImageFile();
    File getImageFile(String tag);
    JS visualValidation();
    JS visualValidation(String tag);
    JS visualCompareWith(JS element);
    boolean relativePosition(JS element, Direction expected);
    OfElement isOn(Function<Direction, Boolean> expected);
    boolean relativePosition(JS element, Function<Direction, Boolean> expected);
    JS clearRelations();
    MapArray<String, Direction> getRelativePositions(JS... elements);
    List<String> validateRelations();
    Point getCenter();
    String textType();
    JS setParent(Object parent);

    default JS setFilter(String filter) {
        engine().jsDriver().setFilter(filter);
        return this;
    }

    String getFullName();

    default JS setLocators(List<By> locators) {
        if (isNotEmpty(locators)) {
            engine().jsDriver().setLocators(locators);
        }
        return this;
    }
    void setVarName(Field field);
    JS setBuilder(IJSBuilder builder);
    JS copy();
}
