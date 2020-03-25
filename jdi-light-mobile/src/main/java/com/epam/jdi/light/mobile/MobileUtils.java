package com.epam.jdi.light.mobile;

import org.openqa.selenium.WebDriver;

import java.util.function.Consumer;
import java.util.function.Function;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

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
}
