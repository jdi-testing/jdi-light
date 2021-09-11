package com.jdiai.asserts;

import com.jdiai.interfaces.HasCore;
import com.jdiai.interfaces.HasName;
import com.jdiai.tools.Timer;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.jdiai.JDI.*;
import static com.jdiai.JDIStatistic.shouldValidations;
import static com.jdiai.jsbuilder.JSBuilder.lastScriptExecution;
import static com.jdiai.jsdriver.JDINovaException.throwAssert;
import static com.jdiai.tools.LinqUtils.map;
import static com.jdiai.tools.PrintUtils.print;
import static com.jdiai.tools.StringUtils.format;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

public class ShouldUtils {
    public static <T> T waitForResult(Supplier<T> function) {
        return waitForResult(function, result -> true, timeout);
    }

    public static <T> T waitForResult(Supplier<T> function, int timeout) {
        return waitForResult(function, result -> true, timeout);
    }

    public static <T> T waitForResult(Supplier<T> function, Function<T, Boolean> conditionFunc) {
        return waitForResult(function, conditionFunc, timeout);
    }

    public static <T> T waitForResult(Supplier<T> function, Function<T, Boolean> conditionFunc, int timeout) {
        try {
            return function.get();
        } catch (Throwable ignore){
            loggerOff();
            try {
                Timer timer = new Timer(timeout * 1000L);
                return timer.getResultByCondition(function, conditionFunc);
            } finally {
                loggerOn();
            }
        }
    }

    public static <T extends HasCore> T handleShouldBe(T core, Condition... conditions) {
        if (isEmpty(conditions)) {
            return core;
        }
        shouldValidations ++;
        Timer timer = new Timer(core.core().elementTimeout() * 1000L);
        logger().info(getCombinedAssertionName(core, conditions));
        boolean foundAll;
        try {
             foundAll = checkConditions(core, conditions, timer);
        } finally {
            loggerOn();
        }
        if (!foundAll) {
            checkOutOfTime(core, timer, conditions);
        }
        return core;
    }

    private static String getCombinedAssertionName(HasCore core, Condition... conditions) {
        return "Assert that " + printCondition(core, conditions);
    }

    private static String printCondition(HasName core, Condition... conditions) {
        return conditions.length == 1
            ? conditions[0].getName(core)
            : print(map(conditions, c -> c.getName(core)), "; ");
    }

    private static boolean checkConditions(HasCore core, Condition[] conditions, Timer timer) {
        try {
            boolean foundAll = false;
            while (!foundAll && timer.isRunning()) {
                for (Condition condition : conditions) {
                    checkOutOfTime(core, timer, conditions);
                    foundAll = condition.apply(core);
                    if (!foundAll) {
                        break;
                    }
                }
            }
            return foundAll;
        } catch (Exception ex) {
            loggerOff();
            boolean ignoreFail = IGNORE_FAILURE.apply(core, ex);
            if (timer.isRunning() && ignoreFail) {
                return checkConditions(core, conditions, timer);
            }
            throw throwAssert(ex, ">> Assert failed\nActual result: " + lastScriptExecution.get());
        }
    }

    private static void checkOutOfTime(HasCore core, Timer timer, Condition... conditions) {
        if (timer.isRunning()) {
            return;
        }
        throw throwAssert(format("Failed to execute Assert in time (%s sec);\n'%s'\nAcutal result:%s",
            core.core().elementTimeout(), getCombinedAssertionName(core, conditions), lastScriptExecution.get()));
    }
}
