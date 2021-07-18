package com.jdiai;

import com.epam.jdi.tools.map.MapArray;
import com.google.gson.JsonObject;
import com.jdiai.interfaces.HasCore;
import com.jdiai.interfaces.HasLocators;
import com.jdiai.interfaces.HasName;
import com.jdiai.interfaces.HasParent;
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
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

public interface JS extends WebElement, HasLocators, HasParent, HasCore {
    String getElement(String valueFunc);
    List<String> getList(String valueFunc);
    String filterElements(String valueFunc);
    String getJSResult(String action);
    void set(String action);
    void setOption(String option);
    void selectByName(String name);
    String selectedValueOption();
    String selectedOption();
    String getText();
    boolean isDisplayed();
    boolean isEnabled();
    void doAction(String action);
    void actionsWithElement(BiFunction<Actions, WebElement, Actions> action);
    void actions(BiFunction<Actions, WebElement, Actions> action);
    void clickCenter();
    void click(int x, int y);
    void select();
    void select(String value);
    void selectSubList(String value);
    JS setFindTextLocator(String locator);
    void select(String... values);
    <TEnum extends Enum<?>> void select(TEnum name);
    void check(boolean condition);
    void check();
    void uncheck();
    void rightClick();
    void doubleClick();
    void hover();
    void dragAndDropTo(WebElement to);
    void dragAndDropTo(int x, int y);
    void input(CharSequence... value);
    void slide(String value);
    String tag();
    String getProperty(String property);
    Json getJson(String valueFunc);
    List<String> getAttributesAsList(String attr);
    Json allAttributes();
    void highlight(String color);
    String cssStyle(String style);
    Json cssStyles(String... style);
    Json allCssStyles();
    boolean isDeselected();
    JS setTextType(GetTextTypes textType);
    String getText(GetTextTypes textType);
    ClientRect getClientRect();
    File makeScreenshot(String tag);
    void startRecording();
    void startRecording(ImageTypes imageType);
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
    void setEntityList();
    <T> List<T> getEntityList(Class<T> cl);
    void fill(Object obj);
    void submit(Object obj, String locator);
    void submit(Object obj);
    void loginAs(Object obj, String locator);
    void loginAs(Object obj);
    JS setEntity(Object obj);
    <T> List<T> getEntityList(String objectMap, Class<?> cl);
    void setEntityList(String objectMap);
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
    void uploadFile(String filePath);
    void press(Keys key);
    void keyboardCommands(String... commands);
    boolean isClickable(int xOffset, int yOffset);
    String fontColor();
    String bgColor();
    String pseudo(String name, String value);
    boolean focused();
    JSImages imagesData();
    File getImageFile();
    File getImageFile(String tag);
    void visualValidation();
    void visualValidation(String tag);
    void visualCompareWith(JS element);
    boolean relativePosition(JS element, Direction expected);
    OfElement isOn(Function<Direction, Boolean> expected);
    boolean relativePosition(JS element, Function<Direction, Boolean> expected);
    void clearRelations();
    MapArray<String, Direction> getRelativePositions(JS... elements);
    List<String> validateRelations();
    Point getCenter();
    String textType();

    default String getFullName() {
        if (parent() == null) {
            return getName();
        }
        String parentName = isInterface(parent().getClass(), HasName.class)
            ? ((HasName)parent()).getName()
            : parent().getClass().getSimpleName();
        return parentName + "." + getName();
    }

    default JS setLocators(List<By> locators) {
        if (isNotEmpty(locators)) {
            engine().jsDriver().locators = locators;
        }
        return this;
    }
}
