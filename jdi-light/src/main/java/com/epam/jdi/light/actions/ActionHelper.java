package com.epam.jdi.light.actions;

import com.epam.jdi.light.asserts.generic.JAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.base.INamed;
import com.epam.jdi.light.elements.pageobjects.annotations.VisualCheck;
import com.epam.jdi.light.logger.AllureLogData;
import com.epam.jdi.light.logger.HighlightStrategy;
import com.epam.jdi.light.logger.JDILogger;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.tools.PrintUtils;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.*;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import io.qameta.allure.Step;
import org.apache.commons.lang3.ObjectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.epam.jdi.light.actions.ActionProcessor.jStack;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.OutputTemplates.*;
import static com.epam.jdi.light.common.VisualCheckAction.ON_VISUAL_ACTION;
import static com.epam.jdi.light.driver.ScreenshotMaker.takeScreen;
import static com.epam.jdi.light.driver.WebDriverFactory.*;
import static com.epam.jdi.light.elements.common.WindowsManager.getWindows;
import static com.epam.jdi.light.elements.composite.WebPage.setCurrentPage;
import static com.epam.jdi.light.elements.composite.WebPage.visualWindowCheck;
import static com.epam.jdi.light.logger.AllureLogger.*;
import static com.epam.jdi.light.logger.LogLevels.INFO;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.logger.Strategy.*;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.light.settings.WebSettings.VISUAL_ACTION_STRATEGY;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.*;
import static com.epam.jdi.tools.Timer.nowTime;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static io.qameta.allure.aspects.StepsAspects.getLifecycle;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;
import static java.util.Arrays.asList;
import static java.util.Collections.reverse;
import static org.apache.commons.lang3.StringUtils.*;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ActionHelper {
    public static JFunc1<JoinPoint, String> GET_ACTION_NAME = ActionHelper::getActionName;
    public static JFunc1<JoinPoint, MapArray<String, Object>> LOG_VALUES = ActionHelper::getLogOptions;
    public static Safe<Boolean> isAssert = new Safe<>(null);

    static String getTemplate(LogLevels level) {
        if (LOGS.logInfoDetails != null) {
            switch (LOGS.logInfoDetails) {
                case NONE: return STEP_TEMPLATE;
                case NAME: return NAME_TEMPLATE;
                case LOCATOR: return LOCATOR_TEMPLATE;
                case CONTEXT: return CONTEXT_TEMPLATE;
                case ELEMENT: return ELEMENT_TEMPLATE;
            }
        }
        return level.equalOrMoreThan(STEP) ? STEP_TEMPLATE : ELEMENT_TEMPLATE;
    }
    public static int CUT_STEP_TEXT = 70;
    public static String getActionName(JoinPoint jp) {
        logger.trace("getActionName()");
        try {
            MethodSignature method = getJpMethod(jp);
            String template = methodNameTemplate(method);
            String actionName = isBlank(template)
                ? getDefaultName(jp, method)
                : fillTemplate(template, jp, method);
            try {
                logger.trace("getActionName() => " + actionName);
            } catch (Throwable ignore) { }
            return actionName;
        } catch (Throwable ex) {
            try {
                takeScreen();
            } catch (Exception ignore) { }
            throw exception(ex, "Surround method issue: Can't get action name: " + getClassMethodName(jp));
        }
    }

    public static String fillTemplate(String template, JoinPoint jp, MethodSignature method) {
        logger.trace("fillTemplate(): " + template);
        String filledTemplate = template;
        try {
            if (filledTemplate.contains("{0")) {
                try {
                    Object[] args = getArgs(jp);
                    filledTemplate = msgFormat(filledTemplate, args);
                } catch (Throwable ex) {
                    throw exception(ex, "fillTemplate { 0 } failed");
                }
            } else if (filledTemplate.contains("%s")) {
                try {
                    filledTemplate = format(filledTemplate, getArgs(jp));
                } catch (Throwable ex) {
                    throw exception(ex, "fillTemplate % s  failed");
                }
            }
            if (filledTemplate.contains("{")) {
                MapArray<String, Object> obj;
                MapArray<String, Object> args;
                MapArray<String, Object> core;
                MapArray<String, Object> fields;
                MapArray<String, Object> methods;
                try {
                    obj = new MapArray<>("this", getElementName(jp));
                } catch (Throwable ex) {
                    throw exception(ex, "fillTemplate get 'obj' failed");
                }
                try {
                    args = methodArgs(jp, method);
                } catch (Throwable ex) {
                    throw exception(ex, "fillTemplate get 'args' failed");
                }
                try {
                    core = core(jp);
                } catch (Throwable ex) {
                    throw exception(ex, "fillTemplate get 'core' failed");
                }
                try {
                    fields = classFields(getJpInstance(jp));
                } catch (Throwable ex) {
                    throw exception(ex, "fillTemplate get 'fields' failed");
                }
                try {
                    methods = classMethods(getJpInstance(jp));
                } catch (Throwable ex) {
                    throw exception(ex, "fillTemplate get 'methods' failed");
                }
                try {
                    filledTemplate = getActionNameFromTemplate(method, filledTemplate, obj, args, core, fields, methods);
                } catch (Throwable ex) {
                    throw exception(ex, "fillTemplate getActionNameFromTemplate failed");
                }
                if (filledTemplate.contains("{{VALUE}}") && args.size() > 0) {
                    filledTemplate = filledTemplate.replaceAll("\\{\\{VALUE}}", args.get(0).toString());
                }
                if (filledTemplate.contains("{failElement}")) {
                    filledTemplate = filledTemplate.replaceAll("\\{failElement}", obj.get(0).value.toString());
                }
            }
            logger.trace("fillTemplate() => " + filledTemplate);
            return filledTemplate;
        } catch (Throwable ex) {
            throw exception(ex, "Surround method issue: Can't fill JDIAction template: " + template + " for method: " + getClassMethodName(jp));
        }
    }
    public static JFunc1<String, String> TRANSFORM_LOG_STRING = s -> s;
    static Safe<List<String>> allureSteps = new Safe<>(ArrayList::new);
    public static void beforeJdiAction(ActionObject jInfo) {
        try {
            logger.trace("beforeJdiAction(): " + jInfo.print());
        } catch (Throwable ignore) { }
        JoinPoint jp = jInfo.jp();
        String message = TRANSFORM_LOG_STRING.execute(getBeforeLogString(jp));
        if (LOGS.writeToAllure && logLevel(jInfo).equalOrMoreThan(INFO) && (allureSteps.get().isEmpty() || !allureSteps.get().contains(message))) {
            jInfo.stepUId = startStep(message);
            if (jInfo.topLevel()) {
                String details = "";
                if (jInfo.isBase()) {
                    details = jInfo.element().toString();
                }
                if (jInfo.isPage()) {
                    details = jInfo.page().details();
                }
                if (isNotBlank(details)) {
                    attachText("Details", "text/plain", details);
                }
            }
            if (!allureSteps.get().contains(message))
                allureSteps.get().add(message);
        }
        if (jInfo.topLevel()) {
            processBeforeAction(message, jInfo);
        }
    }
    protected static void processBeforeAction(String message, ActionObject jInfo) {
        allureSteps.reset();
        JoinPoint jp = jInfo.jp();
        if (LOGS.writeToLog) {
            logger.toLog(message, logLevel(jInfo));
        }
        if (jInfo.isCore() && ObjectUtils.isNotEmpty(ELEMENT.highlight) && !ELEMENT.highlight.contains(HighlightStrategy.OFF)
            && (ELEMENT.highlight.contains(HighlightStrategy.ACTION) && !isAssert(jInfo)
                || ELEMENT.highlight.contains(HighlightStrategy.ASSERT) && isAssert(jInfo))) {
                try {
                    jInfo.core().highlight();
                } catch (Throwable ignore) { }
        }
        processPage(jInfo);
        if (VISUAL_ACTION_STRATEGY == ON_VISUAL_ACTION) {
            visualValidation(jp, message);
        }
        if (isAssert(jInfo)) {
            performAssert(jInfo);
        } else {
            isAssert.set(false);
        }
    }
    private static void performAssert(ActionObject jInfo) {
        boolean lastActionIsNotAssert = isAssert.get() == null || !isAssert.get();
        isAssert.set(true);
        if (lastActionIsNotAssert && !LOGS.screenStrategy.contains(NEW_PAGE)) {
            AllureLogData logData = logDataToAllure(ASSERT,
            "Validate" + capitalize(jInfo.methodName()), jInfo.isAssert());
            attachDataToStep(logData);
        }
    }
    public static boolean isAssert(ActionObject jInfo) {
        return isInterface(jInfo.jpClass(), JAssert.class) || jInfo.isAssertAnnotation();
    }
    public static void beforeStepAction(ActionObject jInfo) {
        String message = TRANSFORM_LOG_STRING.execute(getBeforeLogString(jInfo.jp()));
        logger.toLog(message, logLevel(jInfo));
    }
    private static void visualValidation(JoinPoint jp, String message) {
        Object obj = getJpInstance(jp);
        if (obj == null) {
            if (getJpMethod(jp).getMethod().getAnnotation(VisualCheck.class) != null)
                try {
                    visualWindowCheck();
                } catch (Throwable ex) {
                    logger.debug("BEFORE: Can't do visualWindowCheck");
                }
        }
        else {
            if (isInterface(obj.getClass(), JAssert.class)) {
                JDIBase element = ((IBaseElement) obj).base();
                try {
                    element.visualCheck(message);
                } catch (Throwable ex) {
                    logger.debug("BEFORE: Can't do visualCheck for element");
                }
            }
        }
    }
    public static JAction1<ActionObject> BEFORE_JDI_ACTION = ActionHelper::beforeJdiAction;
    public static void afterStepAction(ActionObject jInfo, Object result) {
        afterAction(jInfo, result);
        passStep(jInfo.stepUId);
    }
    public static void afterJdiAction(ActionObject jInfo, Object result) {
        afterAction(jInfo, result);
        passStep(jInfo.stepUId);
    }
    static void afterAction(ActionObject jInfo, Object result) {
        JoinPoint jp = jInfo.jp();
        if (logResult(jp)) {
            LogLevels logLevel = logLevel(jInfo);
            if (result == null || isInterface(getJpClass(jp), JAssert.class)/* || isInterface(firstInfo(jInfo).jpClass(), JAssert.class)*/)
                logger.debug("Done");
            else {
                String text = result.toString();
                if (jInfo.topLevel()) {
                    String message = ">>> " + (logLevel == STEP && text.length() > CUT_STEP_TEXT + 5
                        ? text.substring(0, CUT_STEP_TEXT) + "..."
                        : text);
                    logger.toLog(message, logLevel);
                }
                if (LOGS.writeToAllure && isNotBlank(jInfo.stepUId)) {
                    attachText("Actual result", "text/plain", text);
                }
            }
        }
        waitAfterAction(jInfo);
        TIMEOUTS.element.reset();
    }
    private static void waitAfterAction(ActionObject jInfo) {
        JDIBase element = jInfo.element();
        if (element == null) return;
        Pair<String, Integer> waitAfter = element.waitAfter();
        if (isNotBlank(waitAfter.key) && jInfo.methodName().equalsIgnoreCase(waitAfter.key) && waitAfter.value > 0) {
            Timer.sleep(waitAfter.value * 1000);
        }
    }
    public static JAction2<ActionObject, Object> AFTER_STEP_ACTION = ActionHelper::afterStepAction;
    public static JAction2<ActionObject, Object> AFTER_JDI_ACTION = ActionHelper::afterJdiAction;

    static boolean logResult(JoinPoint jp) {
        if (!LOGS.writeToLog)
            return false;
        JDIAction ja = getJdiAction(jp);
        return ja != null && ja.logResult();
    }
    static JDIAction getJdiAction(JoinPoint jp) {
        return ((MethodSignature)jp.getSignature()).getMethod().getAnnotation(JDIAction.class);
    }
    public static Class<?> getJpClass(JoinPoint jp) {
        Object instance = getJpInstance(jp);
        return instance != null
                ? instance.getClass()
                : jp.getSignature().getDeclaringType();
    }
    //region Private
    public static String getBeforeLogString(JoinPoint jp) {
        logger.trace("getBeforeLogString()");
        String beforeLogString = capitalize(GET_ACTION_NAME.execute(jp));
        logger.trace("getBeforeLogString(): " + beforeLogString);
        if (isBlank(beforeLogString))
            return "";
        return beforeLogString;
    }
    public static MapArray<String, Object> getLogOptions(JoinPoint jp) {
        MapArray<String, Object> map = new MapArray<>();
        JFunc<String> elementName = () -> getElementName(jp);
        map.update("name", elementName);
        JFunc<String> element = () -> getFullInfo(jp);
        map.update("element", element);
        JFunc<String> context = () -> getElementContext(jp);
        map.update("context", context);
        JFunc<String> locator = () -> getElementLocator(jp);
        map.update("locator", locator);
        return map;
    }
    public static void processPage(ActionObject jInfo) {
        getWindows();
        Object element = jInfo.instance();
        if (element != null && !isClass(element.getClass(), WebPage.class)) {
            WebPage page = getPage(element);
            if (page != null) {
                setCurrentPage(page);
                PAGE.beforeEachStep.execute(page);
            }
        }
    }
    public static List<String> failedMethods = new ArrayList<>();
    public static RuntimeException actionFailed(ActionObject jInfo, Throwable ex) {
        addFailedMethod(jInfo.jp());
        if (jInfo.topLevel()) {
            logFailure(jInfo);
            reverse(failedMethods);
            List<String> chainActions = new ArrayList<>(failedMethods);
            try {
                logger.error("Url: " + WebPage.getUrl());
            } catch (Throwable ignore) { }
            logger.error("Failed actions chain: " + print(chainActions, " > "));
            try {
                ((JDILogger)logger).throwDebugInfo();
            } catch (Throwable ignore) { }
        } else {
            if (LOGS.writeToAllure && isNotBlank(jInfo.stepUId))
                getLifecycle().stopStep(jInfo.stepUId);
        }
        return exception(ex, getExceptionAround(ex, jInfo));
    }
    public static JFunc2<ActionObject, Throwable, RuntimeException> ACTION_FAILED = ActionHelper::actionFailed;

    public static void logFailure(ActionObject jInfo) {
        logger.error("!>>> " + jInfo.object().toString());
        if (ObjectUtils.isNotEmpty(ELEMENT.highlight) && !ELEMENT.highlight.contains(HighlightStrategy.OFF)) {
            if (ELEMENT.highlight.contains(HighlightStrategy.FAIL)) {
                try {
                    jInfo.core().highlight();
                } catch (Throwable ignore) { }
            }
        }
        AllureLogData logData = logDataToAllure(FAIL,
            "Failed" + capitalize(jInfo.methodName()), jInfo.isAssert());
        failStep(jInfo.stepUId, logData);
    }
    static WebPage getPage(Object element) {
        if (isInterface(element.getClass(), IBaseElement.class)) {
            JDIBase base = ((IBaseElement) element).base();
            if (base != null)
                return base.getPage();
        }
        if (isClass(element.getClass(), WebPage.class))
            return (WebPage) element;
        if (isClass(element.getClass(), DriverBase.class))
            return ((DriverBase)element).getPage();
        return null;
    }
    public static MethodSignature getJpMethod(JoinPoint joinPoint) {
        return (MethodSignature) joinPoint.getSignature();
    }
    public static String getMethodName(JoinPoint jp) {
        try {
            return getJpMethod(jp).getName();
        } catch (Throwable ignore) {
            return "Unknown method";
        }
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
        } catch (Throwable ex) {
            throw exception(ex, "Surround method issue: Can't get method name template");
        }
    }
    static LogLevels logLevel(ActionObject jInfo) {
        LogLevels currentLevel = logLevel(jInfo.jp());
        LogLevels topLevel = firstInfo(jInfo).logLevel();
        return currentLevel.equalOrLessThan(topLevel) ? currentLevel : topLevel;
    }
    static LogLevels logLevel(JoinPoint jp) {
        Method m = getJpMethod(jp).getMethod();
        return m.isAnnotationPresent(JDIAction.class)
                ? m.getAnnotation(JDIAction.class).level()
                : INFO;
    }
    static String getDefaultName(JoinPoint jp, MethodSignature method) {
        MapArray<String, Object> args = methodArgs(jp, method);
        String methodName = splitCamelCase(getMethodName(jp));
        if (args.size() == 0)
            return methodName;
        String argsAsString = argsToString(args);
        return format("%s%s", methodName, argsAsString);
    }
    static String argsToString(MapArray<String, Object> args) {
        return args.size() == 1
                ? argToString(args)
                : "("+args.toString()+")";
    }
    static String argToString(MapArray<String, Object> args) {
        return args.get(0).value.getClass().isArray()
            ? arrayToString(args.get(0).value)
            : "("+args.get(0).value+")";
    }
    static MapArray<String, Object> methodArgs(JoinPoint joinPoint, MethodSignature method) {
        String[] names = method.getParameterNames();
        Object[] args = getArgs(joinPoint);
        return new MapArray<>(names, args);
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
                Case(arg -> isInterface(arg.getClass(), IBaseElement.class),
                    arg -> ((IBaseElement)arg).base().toString()),
                Case(arg -> isInterface(arg.getClass(), List.class),
                    PrintUtils::printList),
                Default(arg -> arg));
        return result;
    }
    static MapArray<String, Object> core(JoinPoint jp) {
        Object instance = getJpInstance(jp);
        if (instance != null && isInterface(instance.getClass(), ICoreElement.class)) {
            UIElement el = ((ICoreElement) instance).core();
            return getAllFields(el);
        }
        return new MapArray<>();
    }
    static MapArray<String, Object> classFields(Object obj) {
        return obj != null ? getAllFields(obj) : new MapArray<>();
    }
    static MapArray<String, Object> classMethods(Object obj) {
        return obj != null ? getMethods(obj) : new MapArray<>();
    }
    private static MapArray<String, Object> getMethods(Object obj) {
        return new MapArray<>(obj.getClass().getMethods(),
                method -> method.getName() + "()", v -> func(obj, v), true);
    }
    private static JFunc<String> func(Object obj, Method m) {
        return () -> m.invoke(obj).toString();
    }

    static String getInfo(JoinPoint jp, JFunc1<JDIBase, String> baseInterface,
              JFunc1<Object, String> defaultName, String defaultText) {
        try {
            Object obj = getJpInstance(jp);
            if (obj == null)
                return jp.getSignature().getDeclaringType().getSimpleName();
            if (baseInterface != null && isInterface(getJpClass(jp), IBaseElement.class))
                return baseInterface.execute(((IBaseElement) obj).base());
            return isInterface(getJpClass(jp), INamed.class)
                ? ((INamed) obj).getName()
                : defaultName.execute(obj);
        } catch (Throwable ex) {
            return defaultText;
        }
    }
    static String getElementName(JoinPoint jp) {
        return getInfo(jp, null, Object::toString, "Can't get element name");
    }
    static String getFullInfo(JoinPoint jp) {
        return getInfo(jp, JDIBase::toString, o -> o.getClass().getSimpleName(), "Can't get full info");
    }
    static String getElementContext(JoinPoint jp) {
        return getInfo(jp, JDIBase::printFullLocator, Object::toString, "Can't get context");
    }
    static String getElementLocator(JoinPoint jp) {
        return getInfo(jp, b -> b.locator.toString(), Object::toString, "Can't get element locator");
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
        } catch (Throwable ex) {
            throw exception(ex, "Surround method issue: Can't get action name");
        }
    }
    //endregion
    public static void addFailedMethod(JoinPoint jp) {
        String[] s = jp.toString().split("\\.");
        String result = format("%s.%s%s", s[s.length-2], s[s.length-1].replaceAll("\\)\\)", ""),
                printArgs(getArgs(jp)));
        if (!failedMethods.contains(result))
            failedMethods.add(result);
    }
    private static String printArgs(Object[] args) {
        return args.length == 0 ? ")"
                : format(":'%s')", print(asList(args), Object::toString));
    }
    public static String getExceptionAround(Throwable ex, ActionObject jInfo) {
        String result = safeException(ex);
        while (result.contains("\n\n"))
            result = result.replaceFirst("\\n\\n", LINE_BREAK);
        result = result.replace("java.lang.RuntimeException:", "").trim();
        Object[] args = jInfo.jp().getArgs();
        if (result.contains("{{VALUE}}") && args.length > 0) {
            result = result.replaceAll("\\{\\{VALUE}}", args[0].toString());
        }
        if (jInfo.topLevel())
            result = "[" + nowTime("mm:ss.S") + "] " + result.replaceFirst("\n", "");
        return result;
    }
    private static List<StackTraceElement> arounds() {
        List<StackTraceElement> arounds = getArounds();
        Collections.reverse(arounds);
        return arounds;
    }
    public static boolean notThisAround(String name) {
        return !arounds().get(0).getClassName().equals(name);
    }
    public static int aroundCount() {
        return getArounds().size();
    }
    private static List<StackTraceElement> getArounds() {
        return where(currentThread().getStackTrace(), ActionHelper::isAround);
    }
    private static boolean isAround(StackTraceElement ste) {
        String methodName = ste.getMethodName();
        return methodName.equals("jdiAround") || methodName.equals("stepAround");
    }
    static String getClassMethodName(JoinPoint jp) {
        String className = getJpClass(jp).getSimpleName();
        String methodName = getMethodName(jp);
        return className + "." + methodName;
    }
    public static Object getJpInstance(JoinPoint jp) {
        Object result = jp.getThis();
        if (result == null)
            result = jp.getTarget();
        return result;
    }
    public static Object defaultAction(ActionObject jInfo) throws Throwable {
        logger.trace("defaultAction: " + getClassMethodName(jInfo.jp()));
        jInfo.setElementTimeout();
        return jInfo.overrideAction() != null
            ? jInfo.overrideAction().execute(jInfo.object())
            : jInfo.execute();
    }
    public static Object stableAction(ActionObject jInfo) {
        logger.trace("stableAction: " + getClassMethodName(jInfo.jp()));
        String exceptionMsg = "";
        jInfo.setElementTimeout();
        long start = currentTimeMillis();
        Throwable exception = null;
        do {
            try {
                logger.trace("do-while: " + getClassMethodName(jInfo.jp()));
                Object result = jInfo.overrideAction() != null
                        ? jInfo.overrideAction().execute(jInfo.object()) : jInfo.execute();
                if (!condition(jInfo.jp())) continue;
                return result;
            } catch (Throwable ex) {
                exception = ex;
                try {
                    exceptionMsg = safeException(ex);
                    Thread.sleep(200);
                } catch (Throwable ignore) { }
            }
        } while (currentTimeMillis() - start < jInfo.timeout() * 1000L);
        throw exception(exception, getFailedMessage(jInfo, exceptionMsg));
    }
    static String getFailedMessage(ActionObject jInfo, String exception) {
        MethodSignature method = getJpMethod(jInfo.jp());
        try {
            String result = msgFormat(FAILED_ACTION_TEMPLATE, map(
                $("exception", exception),
                $("timeout", jInfo.timeout()),
                $("action", getClassMethodName(jInfo.jp()))
            ));
            return fillTemplate(result, jInfo.jp(), method);
        } catch (Throwable ex) {
            throw exception(ex, "Surround method issue: Can't get failed message");
        }
    }
    static String getConditionName(JoinPoint jp) {
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
    static boolean condition(JoinPoint jp) {
        String conditionName = getConditionName(jp);
        return CONDITIONS.has(conditionName) && CONDITIONS.get(conditionName).execute(jp) || !CONDITIONS.has(conditionName) && true;
    }

    public static ActionObject newInfo(ProceedingJoinPoint jp, String name) {
        CHECK_MULTI_THREAD.execute();
        try {
            return newInfo(new ActionObject(jp, name));
        } catch (Throwable ex) {
            throw exception(ex, "Failed to init pjp aspect: ");
        }
    }
    private static long previousThread = -1;
    public static JAction CHECK_MULTI_THREAD = () -> {
        if (previousThread == -1)
            previousThread = currentThread().getId();
        else {
            if (previousThread != currentThread().getId()) {
                MULTI_THREAD = true;
                logger.trace("switch to getMultiThreadDriver");
                DRIVER.getFunc = WebDriverFactory::getMultiThreadDriver;
                CHECK_MULTI_THREAD = () -> {};
                if (GETTING_DRIVER) {
                    waitMultiThread();
                }
            }
        }
    };
    public static ActionObject newInfo(JoinPoint jp, String name) {
        try {
            return newInfo(new ActionObject(jp, name));
        } catch (Throwable ex) {
            throw exception(ex, "Failed to init jp aspect: ");
        }
    }
    public static ActionObject newInfo(ActionObject jInfo) {
        if (jInfo.topLevel()) {
            jStack.set(newList(jInfo));
        }
        else {
            if (!jStack.get().contains(jInfo)) {
                jStack.get().add(jInfo);
            }
        }
        try {
            logger.debug(jInfo.print());
        } catch (Throwable ignore) { }
        return jInfo;
    }
    public static ActionObject firstInfo(ActionObject jInfo) {
        try {
            return jStack.get().get(0);
        } catch (Throwable ignore) {
            return jInfo;
        }
    }
}
