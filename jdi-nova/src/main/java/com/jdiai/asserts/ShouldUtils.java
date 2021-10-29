package com.jdiai.asserts;

import com.jdiai.JS;
import com.jdiai.interfaces.HasCore;
import com.jdiai.interfaces.HasName;
import com.jdiai.jsbuilder.ScriptResult;
import com.jdiai.tools.Safe;
import com.jdiai.tools.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.jdiai.JDI.*;
import static com.jdiai.JDIStatistic.shouldValidations;
import static com.jdiai.jsbuilder.JSBuilder.lastScriptExecution;
import static com.jdiai.jsdriver.JDINovaException.THROW_ASSERT;
import static com.jdiai.listeners.JDIEvents.*;
import static com.jdiai.tools.LinqUtils.map;
import static com.jdiai.tools.PrintUtils.print;
import static com.jdiai.tools.StringUtils.LINE_BREAK;
import static com.jdiai.tools.StringUtils.format;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

public class ShouldUtils {
    public static boolean SOFT_ASSERTION_MODE = false;
    private static Safe<List<String>> failedAssertions = new Safe<>(ArrayList::new);
    public static List<String> getAssertions() {
        return failedAssertions.get();
    }

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
        String shouldBeAction = "shouldBe()";
        long timeout = core.core().elementTimeout() * 1000L;
        Timer timer = new Timer(timeout);
        boolean foundAll;
        String assertionToLog = getCombinedAssertionName(core, conditions);
        try {
            fireEvent(BEFORE_ACTION_EVENT, shouldBeAction, assertionToLog, core);
            try {
                foundAll = checkConditions(core, conditions, timer);
            } finally {
                loggerOn();
            }
            if (!foundAll) {
                throwOutOfTimeException(core, conditions);
            }
            long timePassed = timer.timePassedInMSec();
            ScriptResult lastResult = lastScriptExecution.get();
            fireEvent(AFTER_SUCCESS_ACTION_EVENT, shouldBeAction, assertionToLog, core, lastResult.result, timeout, timePassed);
        } catch (Throwable ex) {
            long timePassed = timer.timePassedInMSec();
            ScriptResult lastResult = lastScriptExecution.get();
            String failAssertMessage = ">> Assert failed\nJS Script executed:\n" + lastResult.jsScript + "\nActual result: " + lastResult.result;
            fireEvent(AFTER_ACTION_FAIL_EVENT, shouldBeAction, assertionToLog, core, lastResult.result, timeout, timePassed, ex, failAssertMessage);
            if (SOFT_ASSERTION_MODE) {
                failedAssertions.get().add(failAssertMessage);
            } else {
                List<String> softAssertions = getAssertions();
                if (softAssertions.size() > 0) {
                    softAssertions.add(failAssertMessage);
                    THROW_ASSERT.accept(print(softAssertions, LINE_BREAK));
                } else {
                    throw ex;
                }
            }
        } finally {
            long timePassed = timer.timePassedInMSec();
            ScriptResult lastResult = lastScriptExecution.get();
            fireEvent(AFTER_ACTION_EVENT, shouldBeAction, assertionToLog, core, lastResult.result, timeout, timePassed);
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
                        return checkConditions(core, conditions, timer);
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
            throw ex;
        }
    }

    private static void checkOutOfTime(HasCore core, Timer timer, Condition... conditions) {
        if (timer.isRunning()) {
            return;
        }
        throwOutOfTimeException(core, conditions);
    }

    private static void throwOutOfTimeException(HasCore core, Condition... conditions) {
        JS element = core.core();
        int timeout = element.elementTimeout();
        ScriptResult lastResult = lastScriptExecution.get();
        String failAssertName = getCombinedAssertionName(core, conditions);
        THROW_ASSERT.accept(format("Failed to execute Assert in time (%s sec);\n'%s'\nActual result:%s",
            timeout, failAssertName, lastResult));
    }
}
