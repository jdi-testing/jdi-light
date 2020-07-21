package com.epam.jdi.light.mobile;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.elements.interfaces.base.INamed;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.common.ios.app.MenuItem;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import com.epam.jdi.tools.func.JFunc2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.mobile.elements.init.MobileAppFactory.$;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.namesEqual;

/**
 * This class introduces the wrappers around the driver methods.
 * Since each mobile driver has its own set of features, every time some
 * driver method is called, we need to perform a check if the current driver is able to perform
 * the desired action. These methods perform such check and fire an exception if the method
 * cannot be called with the current driver
 */
public class MobileUtils {
    public static <I> void executeDriverMethod(Class<I> clazz, Consumer<I> consumer) {
        WebDriver driver = getDriver();
        if (clazz.isInstance(driver)) {
            consumer.accept(clazz.cast(driver));
        } else {
            throw exception("Cannot use this method. The driver needs to extend/implement the " + clazz.getName());
        }
    }
    public static <I, R> R executeDriverMethod(Class<I> clazz, Function<I, R> function) {
        WebDriver driver = getDriver();
        if (clazz.isInstance(driver)) {
            return function.apply(clazz.cast(driver));
        } else {
            throw exception("Cannot use this method. The driver needs to extend/implement the " + clazz.getName());
        }
    }


    public static JFunc2<Object, String, IClickable> GET_DEFAULT_BUTTON =
            (obj, buttonName) -> $(By.name(buttonName), obj).setName(buttonName);

    public static JFunc2<Object, String, IClickable> GET_BUTTON = (obj, buttonName) -> {
        List<Field> fields = getFields(obj, IsButton.class);
        if (fields.size() == 0)
            fields = getFieldsExact(obj, WebElement.class, UIElement.class);
        if (fields.size() > 1) {
            fields = filter(fields, f ->
                    isInterfaceAnd(getValueField(f, obj).getClass(), IClickable.class, INamed.class));
            if (fields.size() >= 1) {
                Collection<IClickable> buttons = select(fields,
                        f -> (IClickable) getValueField(f, obj));
                IClickable button = first(buttons, b -> namesEqual(toButton(((INamed) b).getName()), toButton(buttonName)));
                if (button != null)
                    return button;
            }
        }
        if (fields.size() == 1) {
            Field field = fields.get(0);
            Object btnObj = getValueField(field, obj);
            if (isInterface(btnObj.getClass(), IClickable.class))
                return (IClickable) btnObj;
        }
        return GET_DEFAULT_BUTTON.execute(obj, buttonName);
    };

    private static String toButton(String buttonName) {
        return buttonName.toLowerCase().contains("button") ? buttonName : buttonName + "button";
    }

    public static JFunc2<Object, String, HasTouchActions> GET_DEFAULT_APP_MENU_ITEM =
            (obj, menuItemName) -> $(By.xpath(String.format("//XCUIElementTypeMenuItem[@name='%s']", menuItemName)),
                    obj).setName(menuItemName);

    public static JFunc2<Object, String, HasTouchActions> GET_APP_MENU_ITEM = (obj, buttonName) -> {
        List<Field> fields = getFields(obj, MenuItem.class);
        if (fields.size() == 0)
            fields = getFieldsExact(obj, MobileAppUIElement.class, UIElement.class);
        if (fields.size() > 1) {
            fields = filter(fields, f ->
                    isInterfaceAnd(getValueField(f, obj).getClass(), HasTouchActions.class, INamed.class));
            if (fields.size() >= 1) {
                Collection<HasTouchActions> buttons = select(fields,
                        f -> (HasTouchActions) getValueField(f, obj));
                HasTouchActions button = first(buttons, b -> namesEqual(toButton(((INamed) b).getName()), toButton(buttonName)));
                if (button != null)
                    return button;
            }
        }
        if (fields.size() == 1) {
            Field field = fields.get(0);
            Object btnObj = getValueField(field, obj);
            if (isInterface(btnObj.getClass(), IClickable.class))
                return (HasTouchActions) btnObj;
        }
        return GET_DEFAULT_APP_MENU_ITEM.execute(obj, buttonName);
    };
}
