package com.jdiai.asserts;

import com.epam.jdi.tools.Timer;
import com.jdiai.interfaces.HasCore;
import com.jdiai.interfaces.HasName;
import com.jdiai.jsdriver.JDINovaException;

import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.jdiai.JDI.IGNORE_FAILURE;
import static com.jdiai.JDI.timeout;
import static com.jdiai.jsbuilder.QueryLogger.logger;
import static com.jdiai.jsdriver.JDINovaException.throwAssert;
import static java.lang.String.format;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

public class ShouldUtils {
    public static <T extends HasCore> T handleShouldBe(T core, Condition... conditions) {
        if (isEmpty(conditions)) {
            throw new JDINovaException("Please specify at least 1 Condition");
        }
        Timer timer = new Timer(timeout * 1000L);
        logger.info(getCombinedAssertionName(core, conditions));
        AR actualResult = checkConditions(core, conditions, timer);
        if (!actualResult.result) {
            checkOutOfTime(core, timer, actualResult, conditions);
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

    private static AR checkConditions(HasCore core, Condition[] conditions, Timer timer) {
        AR actualResult = new AR("", false);
        try {
            while (!actualResult.getResult() && timer.isRunning()) {
                for (Condition condition : conditions) {
                    checkOutOfTime(core, timer, actualResult, conditions);
                    String message = "Assert that " + condition.getName(core);
                    logger.debug(message);
                    actualResult = condition.apply(core);
                    if (!actualResult.result) {
                        break;
                    }
                }
            }
            return actualResult;
        } catch (Exception ex) {
            boolean ignoreFail = IGNORE_FAILURE.apply(core, ex);
            if (timer.isRunning() && ignoreFail) {
                return checkConditions(core, conditions, timer);
            }
            throw throwAssert(ex, ">> Assert failed\nActual result: " + actualResult.getActualValue());
        }
    }

    private static void checkOutOfTime(HasCore core, Timer timer, AR actualResult, Condition... conditions) {
        if (timer.isRunning()) {
            return;
        }
        throw throwAssert(format("Failed to execute Assert in time (%s sec);\n'%s'\nAcutal result:%s",
            timeout, getCombinedAssertionName(core, conditions), actualResult.getActualValue()));
    }
}
