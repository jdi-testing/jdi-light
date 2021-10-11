package com.jdiai.asserts;

import com.jdiai.JS;
import com.jdiai.interfaces.HasCore;
import com.jdiai.interfaces.HasName;
import com.jdiai.tools.Safe;
import com.jdiai.tools.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.jdiai.JDI.*;
import static com.jdiai.JDIEvents.*;
import static com.jdiai.JDIStatistic.shouldValidations;
import static com.jdiai.jsbuilder.JSBuilder.lastScriptExecution;
import static com.jdiai.jsdriver.JDINovaException.throwAssert;
import static com.jdiai.tools.LinqUtils.map;
import static com.jdiai.tools.PrintUtils.print;
import static com.jdiai.tools.StringUtils.format;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

public class ShouldUtils {
    public static boolean SOFT_ASSERTION_MODE = false;
    private static Safe<List<String>> failedAssertions = new Safe<>(ArrayList::new);

    public static <T> T waitForResult(Supplier<T> function) {
        return waitForResult(function, result -> true, timeout);
    }

    public static <T> T waitForResult(Supplier<T> function, int timeoutInSec) {
        return waitForResult(function, result -> true, timeoutInSec);
    }

    public static <T> T waitForResult(Supplier<T> function, Function<T, Boolean> conditionFunc) {
        return waitForResult(function, conditionFunc, timeout);
    }

    public static <T> T waitForResult(Supplier<T> function, Function<T, Boolean> conditionFunc, int timeoutInSec) {
        try {
            T result = function.get();
            if (result != null && conditionFunc.apply(result)) {
                return result;
            }
        } catch (Throwable ignore) { }
        loggerOff();
        try {
            Timer timer = new Timer(timeoutInSec * 1000L);
            return timer.getResultByCondition(function, conditionFunc);
        } finally {
            loggerOn();
        }
    }

    public static <T extends HasCore> T handleShouldBe(T core, Condition... conditions) {
        if (isEmpty(conditions)) {
            return core;
        }
        shouldValidations ++;
        try {
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
        } catch (Throwable ex) {
            JS element = core.core();
            String errorMsg = ex.getMessage();
            fireEvent(SHOULD_ASSERT_FAILED_EVENT, element, element.elementTimeout(), errorMsg);
            if (SOFT_ASSERTION_MODE) {
                failedAssertions.get().add(errorMsg);
            } else {
                throw ex;
            }
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
            JS element = core.core();
            int timeout = element.elementTimeout();
            String lastResult = lastScriptExecution.get();
            String failAssertMessage = ">> Assert failed\nActual result: " + lastResult;
            fireEvent(SHOULD_ASSERT_FAILED_EVENT, element, timeout, failAssertMessage, lastResult, ex.getMessage());
            if (SOFT_ASSERTION_MODE) {
                failedAssertions.get().add(failAssertMessage);
                return false;
            } else {
                throw throwAssert(ex, failAssertMessage);
            }
        }
    }

    private static void checkOutOfTime(HasCore core, Timer timer, Condition... conditions) {
        if (timer.isRunning()) {
            return;
        }
        JS element = core.core();
        int timeout = element.elementTimeout();
        String failAssertName = getCombinedAssertionName(core, conditions);
        String lastResult = lastScriptExecution.get();
        fireEvent(SHOULD_OUT_OF_TIME_EVENT, element, timeout, failAssertName, lastResult);
        throw throwAssert(format("Failed to execute Assert in time (%s sec);\n'%s'\nActual result:%s",
            timeout, failAssertName, lastResult));
    }
}
