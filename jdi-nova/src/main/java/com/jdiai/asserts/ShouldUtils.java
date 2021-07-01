package com.jdiai.asserts;

import com.epam.jdi.tools.Timer;
import com.jdiai.interfaces.HasCore;
import com.jdiai.interfaces.HasName;
import com.jdiai.jsdriver.JSException;

import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.jdiai.JDI.IGNORE_FAILURE;
import static com.jdiai.JDI.timeout;
import static com.jdiai.jsbuilder.QueryLogger.logger;
import static com.jdiai.jsdriver.JSException.throwAssert;
import static java.lang.String.format;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

public class ShouldUtils {
    public static <T extends HasCore> T handleShouldBe(T core, Condition... conditions) {
        if (isEmpty(conditions)) {
            throw new JSException("Please specify at least 1 Condition");
        }
        Timer timer = new Timer(timeout * 1000L);
        logger.info(getCombinedAssertionName(core, conditions));
        boolean foundAll = checkConditions(core, conditions, timer);
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
                    String message = "Assert that " + condition.getName(core);
                    logger.debug(message);
                    foundAll = condition.execute(core);
                    if (!foundAll) {
                        break;
                    }
                }
            }
            return foundAll;
        } catch (Exception ex) {
            boolean ignoreFail = IGNORE_FAILURE.execute(core, ex);
            if (timer.isRunning() && ignoreFail) {
                checkConditions(core, conditions, timer);
            }
            throw throwAssert(ex, ">> Assert failed");
        }
    }

    private static void checkOutOfTime(HasCore core, Timer timer, Condition... conditions) {
        if (timer.isRunning()) {
            return;
        }
        throw throwAssert(format("Failed to execute Assert in time (%s sec); '%s'",
            timeout, getCombinedAssertionName(core, conditions)));
    }
}
