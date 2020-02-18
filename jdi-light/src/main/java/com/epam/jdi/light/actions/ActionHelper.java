package com.epam.jdi.light.actions;

import com.epam.jdi.light.asserts.generic.JAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.PageChecks;
import com.epam.jdi.light.common.VisualCheckPage;
import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.base.INamed;
import com.epam.jdi.light.elements.interfaces.base.JDIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.VisualCheck;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.PrintUtils;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.map.MapArray;
import io.qameta.allure.Step;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.common.VisualCheckAction.ON_VISUAL_ACTION;
import static com.epam.jdi.light.driver.ScreenshotMaker.takeScreen;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.base.OutputTemplates.*;
import static com.epam.jdi.light.elements.common.WindowsManager.getWindows;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.logger.AllureLogger.*;
import static com.epam.jdi.light.logger.LogLevels.ERROR;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.logger.LogStrategy.*;
import static com.epam.jdi.light.logger.Strategy.FAIL;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.JsonUtils.beautifyJson;
import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.LinqUtils.where;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.*;
import static com.epam.jdi.tools.Timer.nowTime;
import static com.epam.jdi.tools.map.MapArray.IGNORE_NOT_UNIQUE;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static java.lang.Character.toUpperCase;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;
import static java.util.Collections.reverse;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ActionHelper {
    static String getTemplate(LogLevels level) {
        return level.equalOrMoreThan(STEP) ? STEP_TEMPLATE : DEFAULT_TEMPLATE;
    }
    public static int CUT_STEP_TEXT = 70;
    public static String getActionName(ProceedingJoinPoint jp) {
        try {
            MethodSignature method = getJpMethod(jp);
            String template = methodNameTemplate(method);
            return isBlank(template)
                    ? getDefaultName(method.getName(), methodArgs(jp, method))
                    : fillTemplate(template, jp, method);
        } catch (Throwable ex) {
            throw exception(ex, "Surround method issue: Can't get action name: ");
        }
    }
    public static JFunc1<ProceedingJoinPoint, String> GET_ACTION_NAME = ActionHelper::getActionName;
    public static String fillTemplate(String template, ProceedingJoinPoint jp, MethodSignature method) {
        String filledTemplate = template;
        try {
            if (filledTemplate.contains("{0")) {
                Object[] args = getArgs(jp);
                filledTemplate = msgFormat(filledTemplate, args);
            } else if (filledTemplate.contains("%s")) {
                filledTemplate = format(filledTemplate, getArgs(jp));
            }
            if (filledTemplate.contains("{")) {
                MapArray<String, Object> obj = toMap(() -> new MapArray<>("this", getElementName(jp)));
                MapArray<String, Object> args = methodArgs(jp, method);
                MapArray<String, Object> core = core(jp);
                MapArray<String, Object> fields = classFields(jp.getThis());
                filledTemplate = getActionNameFromTemplate(method, filledTemplate, obj, args, core, fields);
                if (filledTemplate.contains("{{VALUE}}") && args.size() > 0) {
                    filledTemplate = filledTemplate.replaceAll("\\{\\{VALUE}}", args.get(0).toString());
                }
                if (filledTemplate.contains("{failElement}")) {
                    filledTemplate = filledTemplate.replaceAll("\\{failElement}", obj.get(0).value.toString());
                }
            }
            return filledTemplate;
        } catch (Exception ex) {
            throw exception(ex, "Surround method issue: Can't fill JDIAction template: " + template + " for method: " + method.getName());
        }
    }
    public static void beforeStepAction(ActionObject jInfo) {
        ProceedingJoinPoint jp = jInfo.jp();
        String message = getBeforeLogString(jp);
        logger.toLog(message, logLevel(jp));
        jInfo.stepUId = startStep(message);
        if (VISUAL_ACTION_STRATEGY == ON_VISUAL_ACTION) {
            Object obj = jp.getThis();
            if (obj == null) {
                if (getJpMethod(jp).getMethod().getAnnotation(VisualCheck.class) != null)
                    try {
                        visualWindowCheck();
                    } catch (Exception ex) {
                        logger.debug("BEFORE: Can't do visualWindowCheck");
                    }
            }
            else {
                if (isInterface(obj.getClass(), JAssert.class)) {
                    JDIBase element = ((IBaseElement) obj).base();
                    try {
                        element.visualCheck(message);
                    } catch (Exception ex) {
                        logger.debug("BEFORE: Can't do visualCheck for element");
                    }
                }
            }
        }
    }
    public static JAction1<ActionObject> BEFORE_STEP_ACTION = ActionHelper::beforeStepAction;
    public static void beforeJdiAction(ActionObject jp) {
        BEFORE_STEP_ACTION.execute(jp);
        processNewPage(jp);
    }
    public static JAction1<ActionObject> BEFORE_JDI_ACTION = ActionHelper::beforeJdiAction;
    public static Object afterStepAction(ActionObject jInfo, Object result) {
        ProceedingJoinPoint jp = jInfo.jp();
        if (!logResult(jp)) return result;
        LogLevels logLevel = logLevel(jp);
        if (result == null || isInterface(getJpClass(jp), JAssert.class))
            logger.debug("Done");
        else {
            String text = result.toString();
            if (logLevel == STEP && text.length() > CUT_STEP_TEXT + 5)
                text = text.substring(0, CUT_STEP_TEXT) + "...";
            logger.toLog(">>> " + text, logLevel);
        }
        passStep(jInfo.stepUId);
        if (getJpMethod(jp).getName().equals("open"))
            BEFORE_NEW_PAGE.execute(getPage(jp.getThis()));
        TIMEOUT.reset();
        return result;
    }
    public static JFunc2<ActionObject, Object, Object> AFTER_STEP_ACTION = ActionHelper::afterStepAction;
    static boolean logResult(ProceedingJoinPoint jp) {
        Class<?> cl = getJpClass(jp);
        if (!isInterface(cl, JDIElement.class)) return false;
        JDIAction ja = getJdiAction(jp);
        return ja != null && ja.logResult();
    }
    static JDIAction getJdiAction(ProceedingJoinPoint jp) {
        return ((MethodSignature)jp.getSignature()).getMethod().getAnnotation(JDIAction.class);
    }
    protected static Class<?> getJpClass(JoinPoint jp) {
        return jp.getThis() != null
                ? jp.getThis().getClass()
                : jp.getSignature().getDeclaringType();
    }
    public static Object afterJdiAction(ActionObject jInfo, Object result) {
        return AFTER_STEP_ACTION.execute(jInfo, result);
    }
    public static JFunc2<ActionObject, Object, Object> AFTER_JDI_ACTION = ActionHelper::afterJdiAction;
    //region Private
    public static String getBeforeLogString(ProceedingJoinPoint jp) {
        String actionName = GET_ACTION_NAME.execute(jp);
        String logString = jp.getThis() == null
            ? actionName
            : msgFormat(getTemplate(logger.getLogLevel()), map(
                $("action", actionName),
                $("element", getElementName(jp))));
        return toUpperCase(logString.charAt(0)) + logString.substring(1);
    }
    public static void processNewPage(ActionObject jInfo) {
        if (CHECK_AFTER_OPEN == PageChecks.NONE && VISUAL_PAGE_STRATEGY == VisualCheckPage.NONE)
            return;
        getWindows();
        Object element = jInfo.jp().getThis();
        if (element != null && !isClass(element.getClass(), WebPage.class)) {
            WebPage page = getPage(element);
            String currentPage = getCurrentPage();
            if (currentPage != null && page != null) {
                if (!currentPage.equals(page.getName())) {
                    setCurrentPage(page);
                    BEFORE_NEW_PAGE.execute(page);
                }
                else BEFORE_EACH_STEP.execute(page);
            }
        }
    }
    public static JFunc2<Object, String, String> ACTION_FAILED = (el, ex) -> ex;
    public static void logFailure(ActionObject jInfo) {
        logger.toLog(">>> " + jInfo.object().toString(), ERROR);
        String screenName = "";
        String htmlSnapshot = "";
        String errors = "";
        if (SCREEN_STRATEGY.contains(FAIL))
            screenName = takeScreen();
        if (HTML_CODE_STRATEGY.contains(FAIL))
            htmlSnapshot = takeHtmlCodeOnFailure();
        if (REQUESTS_STRATEGY.contains(FAIL)) {
            WebDriver driver = jInfo.element() != null
                ? jInfo.element().base().driver()
                : getDriver();
            List<LogEntry> requests = driver.manage().logs().get("performance").getAll();
            List<String> errorEntries = LinqUtils.map(filter(requests, FILTER_REQUESTS),
                logEntry -> beautifyJson(logEntry.getMessage()));
            errors = print(errorEntries);
        }
        failStep(jInfo.stepUId, screenName, htmlSnapshot, errors);
    }
    static WebPage getPage(Object element) {
        if (!isClass(element.getClass(), DriverBase.class))
            return null;
        return isClass(element.getClass(), WebPage.class)
            ? (WebPage) element
            : ((DriverBase) element).getPage();
    }
    public static MethodSignature getJpMethod(JoinPoint joinPoint) {
        return (MethodSignature) joinPoint.getSignature();
    }
    static String methodNameTemplate(MethodSignature method) {
        try {
            Method m = method.getMethod();
            if (m.isAnnotationPresent(JDIAction.class)) {
                return m.getAnnotation(JDIAction.class).value();
            }
            if (m.isAnnotationPresent(Step.class)) {
                return m.getAnnotation(Step.class).value();
            }
            return null;
        } catch (Exception ex) {
            throw exception(ex, "Surround method issue: Can't get method name template");
        }
    }
    static LogLevels logLevel(JoinPoint joinPoint) {
        Method m = getJpMethod(joinPoint).getMethod();
        return m.isAnnotationPresent(JDIAction.class)
            ? m.getAnnotation(JDIAction.class).level()
            : STEP;
    }
    static String getDefaultName(String method, MapArray<String, Object> args) {
        if (args.size() == 1 && args.get(0).value.getClass().isArray())
            return format("%s(%s)", method, arrayToString(args.get(0).value));
        MapArray<String, String> methodArgs = args.toMapArray(Object::toString);
        String stringArgs = Switch(methodArgs.size()).get(
            Value(0, ""),
            Value(1, v->"("+methodArgs.get(0).value+")"),
            Default(v->"("+methodArgs.toString()+")")
        );
        return format("%s%s", method, stringArgs);
    }
    static MapArray<String, Object> methodArgs(JoinPoint joinPoint, MethodSignature method) {
        return toMap(() -> new MapArray<>(method.getParameterNames(), getArgs(joinPoint)));
    }
    static MapArray<String, Object> toMap(JFunc<MapArray<String, Object>> getMap) {
        IGNORE_NOT_UNIQUE = true;
        MapArray<String, Object> map = getMap.execute();
        IGNORE_NOT_UNIQUE = false;
        return map;
    }
    static Object[] getArgs(JoinPoint jp) {
        Object[] args = jp.getArgs();
        if (args.length == 1 && args[0] == null)
            return new Object[] {};
        Object[] result = new Object[args.length];
        for (int i = 0; i< args.length; i++)
            result[i] = Switch(args[i]).get(
                Case(Objects::isNull, null),
                Case(arg -> arg.getClass().isArray(), PrintUtils::printArray),
                Case(arg -> isInterface(arg.getClass(), List.class),
                        PrintUtils::printList),
                Default(arg -> arg));
        return result;
    }
    static MapArray<String, Object> core(JoinPoint jp) {
        Class cl = jp.getSignature().getDeclaringType();
        if (jp.getThis() != null && isInterface(cl, ICoreElement.class)) {
            UIElement el = ((ICoreElement) jp.getThis()).core();
            return getAllFields(el);
        }
        return new MapArray<>();
    }
    static MapArray<String, Object> classFields(Object obj) {
        return obj != null ? getAllFields(obj) : new MapArray<>();
    }
    static String getElementName(JoinPoint jp) {
        try {
            Object obj = jp.getThis();
            if (obj == null) return jp.getSignature().getDeclaringType().getSimpleName();
            return isInterface(getJpClass(jp), INamed.class)
                    ? ((INamed) obj).getName()
                    : obj.toString();
        } catch (Exception ex) {
            throw exception(ex, "Can't get element name");
        }
    }
    static String getActionNameFromTemplate(MethodSignature method, String value, MapArray<String, Object>... args) {
        String result;
        try {
            if (isBlank(value)) {
                result = splitLowerCase(method.getMethod().getName());
                if (args[1].size() == 1)
                    result += " '" + args[1].values().get(0) + "'";
            } else {
                result = value;
                for (MapArray<String, Object> params : args)
                    result = msgFormat(result, params);
            }
            return result;
        } catch (Exception ex) {
            throw exception(ex, "Surround method issue: Can't get action name");
        }
    }
    //endregion

    public static RuntimeException exceptionJdiAround(ActionObject jInfo, String className, Throwable ex) {
        addFailedMethod(jInfo.jp());
        if (aroundCount(className) == 1) {
            logFailure(jInfo);
            reverse(failedMethods);
            logger.error("Failed actions chain: " + print(failedMethods, " > "));
        }
        return exception(ex, ACTION_FAILED.execute(jInfo.object(), getExceptionAround(ex, aroundCount(className) == 1)));
    }
    public static void addFailedMethod(ProceedingJoinPoint jp) {
        String[] s = jp.toString().split("\\.");
        String result = s[s.length-2]+"."+s[s.length-1].replaceAll("\\)\\)", ")");
        if (!failedMethods.contains(result))
            failedMethods.add(result);
    }
    public static List<String> failedMethods = new ArrayList<>();
    public static String getExceptionAround(Throwable ex, boolean top) {
        String result = safeException(ex);
        while (result.contains("\n\n"))
            result = result.replaceFirst("\\n\\n", LINE_BREAK);
        result = result.replace("java.lang.RuntimeException:", "").trim();
        if (top)
            result = "[" + nowTime("mm:ss.S") + "] " + result.replaceFirst("\n", "");
        return result;
    }
    private static List<StackTraceElement> arounds() {
        List<StackTraceElement> arounds = where(currentThread().getStackTrace(),
                s -> s.getMethodName().equals("jdiAround"));
        Collections.reverse(arounds);
        return arounds;
    }
    public static boolean notThisAround(String name) {
        return !arounds().get(0).getClassName().equals(name);
    }
    public static int aroundCount(String name) {
        return where(currentThread().getStackTrace(),
                s -> s.getMethodName().equals("jdiAround") && s.getClassName().equals(name))
                .size();
    }
    public static Object defaultAction(ActionObject jInfo) throws Throwable {
        jInfo.setElementTimeout();
        return jInfo.overrideAction() != null
                ? jInfo.overrideAction().execute(jInfo.object()) : jInfo.jp().proceed();
    }
    public static Object stableAction(ActionObject jInfo) {
        String exceptionMsg = "";
        jInfo.setElementTimeout();
        long start = currentTimeMillis();
        Throwable exception = null;
        do {
            try {
                Object result = jInfo.overrideAction() != null
                        ? jInfo.overrideAction().execute(jInfo.object()) : jInfo.jp().proceed();
                if (!condition(jInfo.jp())) continue;
                return result;
            } catch (Throwable ex) {
                exception = ex;
                try {
                    exceptionMsg = safeException(ex);
                    Thread.sleep(200);
                } catch (Exception ignore) {
                }
            }
        } while (currentTimeMillis() - start < jInfo.timeout() * 1000);
        throw exception(exception, getFailedMessage(jInfo, exceptionMsg));
    }
    static String getFailedMessage(ActionObject jInfo, String exception) {
        MethodSignature method = getJpMethod(jInfo.jp());
        try {
            String result = msgFormat(FAILED_ACTION_TEMPLATE, map(
                    $("exception", exception),
                    $("timeout", jInfo.timeout()),
                    $("action", method.getMethod().getName())
            ));
            return fillTemplate(result, jInfo.jp(), method);
        } catch (Exception ex) {
            throw exception(ex, "Surround method issue: Can't get failed message");
        }
    }
    static String getConditionName(ProceedingJoinPoint jp) {
        JDIAction ja = getJdiAction(jp);
        return ja != null ? ja.condition() : "";
    }
    public static MapArray<String, JFunc1<Object, Boolean>> CONDITIONS = map(
            $("", result -> true),
            $("true", result -> result instanceof Boolean && (Boolean) result),
            $("false", result -> result instanceof Boolean && !(Boolean) result),
            $("not empty", result -> result instanceof List && ((List) result).size() > 0),
            $("empty", result -> result instanceof List && ((List) result).size() == 0)
    );
    static boolean condition(ProceedingJoinPoint jp) {
        String conditionName = getConditionName(jp);
        return CONDITIONS.has(conditionName)
                ? CONDITIONS.get(conditionName).execute(jp)
                : true;
    }
}
