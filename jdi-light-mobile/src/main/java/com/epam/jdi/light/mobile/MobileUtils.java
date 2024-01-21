package com.epam.jdi.light.mobile;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.elements.interfaces.base.INamed;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.common.app.ios.MenuItem;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import com.jdiai.tools.func.JFunc2;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.elements.init.MobileAppFactory.$;
import static com.jdiai.tools.LinqUtils.*;
import static com.jdiai.tools.ReflectionUtils.*;
import static com.jdiai.tools.StringUtils.format;
import static com.jdiai.tools.StringUtils.namesEqual;

/**
 * This class introduces the wrappers around the driver methods.
 * Since each mobile driver has its own set of features, every time some
 * driver method is called, we need to perform a check if the current driver is able to perform
 * the desired action. These methods perform such check and fire an exception if the method
 * cannot be called with the current driver
 */
public final class MobileUtils {
    private MobileUtils() {
    }

    public static <I> void executeDriverMethod(Class<I> clazz, Consumer<I> consumer) {
        WebDriver driver = getDriver();
        if (clazz.isInstance(driver)) {
            consumer.accept(clazz.cast(driver));
        } else {
            throw runtimeException("Cannot use this method. The driver needs to extend/implement the " + clazz.getName());
        }
    }
    public static <I, R> R executeDriverMethod(Class<I> clazz, Function<I, R> function) {
        WebDriver driver = getDriver();
        if (clazz.isInstance(driver)) {
            return function.apply(clazz.cast(driver));
        } else {
            throw runtimeException("Cannot use this method. The driver needs to extend/implement the " + clazz.getName());
        }
    }

    //CHECKSTYLE:OFF
    public static JFunc2<Object, String, HasTouchActions> GET_DEFAULT_BUTTON =
            (obj, buttonName) -> $(AppiumBy.xpath(format("//XCUIElementTypeButton[@name='%s']", buttonName)),
                    obj).setName(buttonName);
    //CHECKSTYLE:ON

    //CHECKSTYLE:OFF
    public static final JFunc2<Object, String, HasTouchActions> GET_BUTTON = (obj, buttonName) -> {
        //CHECKSTYLE:ON
        List<Field> fields = getFields(obj, IsButton.class);
        if (fields.isEmpty()) {
            fields = getFieldsExact(obj, MobileAppUIElement.class, UIElement.class);
        }
        if (!fields.isEmpty()) {
            fields = filter(fields, f ->
                    isInterfaceAnd(getValueField(f, obj).getClass(), HasTouchActions.class, INamed.class));
            if (!fields.isEmpty()) {
                Collection<HasTouchActions> buttons = select(fields,
                        f -> (HasTouchActions) getValueField(f, obj));
                HasTouchActions button = first(buttons,
                        b -> namesEqual(toButton(b.getName()), toButton(buttonName)));
                if (button != null) {
                    return button;
                }
            }
        }
        if (fields.size() == 1) {
            Field field = fields.get(0);
            Object btnObj = getValueField(field, obj);
            if (isInterface(btnObj.getClass(), HasTouchActions.class)) {
                return (HasTouchActions) btnObj;
            }
        }
        return GET_DEFAULT_BUTTON.execute(obj, buttonName);
    };

    private static String toButton(String buttonName) {
        return buttonName.toLowerCase().contains("button") ? buttonName : buttonName + "button";
    }

    //CHECKSTYLE:OFF
    public static JFunc2<Object, String, HasTouchActions> GET_DEFAULT_APP_MENU_ITEM =
            (obj, menuItemName) -> $(AppiumBy.xpath(format("//XCUIElementTypeMenuItem[@name='%s']", menuItemName)),
                    obj).setName(menuItemName);
    //CHECKSTYLE:ON

    //CHECKSTYLE:OFF
    public static JFunc2<Object, String, HasTouchActions> GET_APP_MENU_ITEM = (obj, buttonName) -> {
        //CHECKSTYLE:ON
        List<Field> fields = getFields(obj, MenuItem.class);
        if (fields.isEmpty()) {
            fields = getFieldsExact(obj, MobileAppUIElement.class, UIElement.class);
        }
        if (!fields.isEmpty()) {
            fields = filter(fields, f ->
                    isInterfaceAnd(getValueField(f, obj).getClass(), HasTouchActions.class, INamed.class));
            if (!fields.isEmpty()) {
                Collection<HasTouchActions> buttons = select(fields,
                        f -> (HasTouchActions) getValueField(f, obj));
                HasTouchActions button = first(buttons, b -> namesEqual(toButton(b.getName()), toButton(buttonName)));
                if (button != null) {
                    return button;
                }
            }
        }
        if (fields.size() == 1) {
            Field field = fields.get(0);
            Object btnObj = getValueField(field, obj);
            if (isInterface(btnObj.getClass(), IClickable.class)) {
                return (HasTouchActions) btnObj;
            }
        }
        return GET_DEFAULT_APP_MENU_ITEM.execute(obj, buttonName);
    };
}
