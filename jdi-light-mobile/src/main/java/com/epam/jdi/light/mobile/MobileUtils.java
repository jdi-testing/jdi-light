package com.epam.jdi.light.mobile;

import org.openqa.selenium.WebDriver;

import java.util.function.Consumer;
import java.util.function.Function;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

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
}
