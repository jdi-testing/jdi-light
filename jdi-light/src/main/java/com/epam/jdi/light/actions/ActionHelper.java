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
import com.epam.jdi.light.logger.AllureLoggerHelper;
import com.epam.jdi.light.logger.LogLevels;
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

import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.common.VisualCheckAction.ON_VISUAL_ACTION;
import static com.epam.jdi.light.driver.ScreenshotMaker.takeScreenOnFailure;
import static com.epam.jdi.light.elements.base.OutputTemplates.DEFAULT_TEMPLATE;
import static com.epam.jdi.light.elements.base.OutputTemplates.STEP_TEMPLATE;
import static com.epam.jdi.light.elements.common.WindowsManager.getWindows;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.logger.AllureLoggerHelper.*;
import static com.epam.jdi.light.logger.LogLevels.ERROR;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.*;
import static com.epam.jdi.tools.map.MapArray.IGNORE_NOT_UNIQUE;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static java.lang.Character.toUpperCase;
import static java.lang.String.format;
import static java.util.UUID.*;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ActionHelper {
    static String getTemplate(LogLevels level) {
        return level.equalOrMoreThan(STEP) ? STEP_TEMPLATE : DEFAULT_TEMPLATE;
    }
    public static JFunc1<ProceedingJoinPoint, String> GET_ACTION_NAME = jp -> {
        try {
            MethodSignature method = getJpMethod(jp);
            String template = methodNameTemplate(method);
            return isBlank(template)
                ? getDefaultName(method.getName(), methodArgs(jp, method))
                : fillTemplate(template, jp, method);
        } catch (Exception ex) {
            throw exception(ex, "Surround method issue: Can't get action name: ");
        }
    };
    public static String fillTemplate(String template,
        ProceedingJoinPoint jp, MethodSignature method) {
        try {
            if (template.contains("{0")) {
                Object[] args = getArgs(jp);
                template = msgFormat(template, args);
            } else if (template.contains("%s")) {
                template = format(template, getArgs(jp));
            }
            if (template.contains("{")) {
                MapArray<String, Object> obj = toMap(() -> new MapArray<>("this", getElementName(jp)));
                MapArray<String, Object> args = methodArgs(jp, method);
                MapArray<String, Object> core = core(jp);
                MapArray<String, Object> fields = classFields(jp.getThis());
                template = getActionNameFromTemplate(method, template, obj, args, core, fields);
                if (template.contains("{{VALUE}}") && args.size() > 0)
                    template = template.replaceAll("\\{\\{VALUE}}", args.get(0).toString());
                if (template.contains("{failElement}"))
                    template = template.replaceAll("\\{failElement}", obj.get(0).value.toString());
            }
            return template;
        } catch (Exception ex) {
            throw exception(ex, "Surround method issue: Can't fill JDIAction template: " + template + " for method: " + method.getName());
        }
    }

    public static JAction1<ProceedingJoinPoint> BEFORE_STEP_ACTION = jp -> {
        String message = getBeforeLogString(jp);
        logger.toLog(message, logLevel(jp));
        if (VISUAL_ACTION_STRATEGY == ON_VISUAL_ACTION) {
            Object obj = jp.getThis();
            if (obj == null) {
                if (getMethodFromJp(jp).getAnnotation(VisualCheck.class) != null)
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
    };
    public static JAction1<ProceedingJoinPoint> BEFORE_JDI_ACTION = jp -> {
        BEFORE_STEP_ACTION.execute(jp);
        processNewPage(jp);
    };

    public static int CUT_STEP_TEXT = 100;
    public static JFunc2<ProceedingJoinPoint, Object, Object> AFTER_STEP_ACTION = (jp, result) -> {
        if (!logResult(jp)) return result;
        LogLevels logLevel = logLevel(jp);
        if (result != null) {
            String text = result.toString();
            if (logLevel == STEP && text.length() > CUT_STEP_TEXT + 5)
                text = text.substring(0, CUT_STEP_TEXT) + "...";
            logger.toLog(">>> " + text, logLevel);
        } else
            logger.debug("Done");
        if (getJpMethod(jp).getName().equals("open"))
            BEFORE_NEW_PAGE.execute(getPage(jp.getThis()));
        TIMEOUT.reset();
        return result;
    };
    static boolean logResult(ProceedingJoinPoint jp) {
        Class<?> cl = getJpClass(jp);
        if (!isInterface(cl, JDIElement.class)) return false;
        JDIAction ja = getMethodFromJp(jp).getAnnotation(JDIAction.class);
        return ja != null && ja.logResult();
    }
    static Class<?> getJpClass(JoinPoint jp) {
        return jp.getThis() != null
                ? jp.getThis().getClass()
                : jp.getSignature().getDeclaringType();
    }

    public static JFunc2<ProceedingJoinPoint, Object, Object> AFTER_JDI_ACTION =
        (jp, result) -> AFTER_STEP_ACTION.execute(jp, result);

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

    public static void processNewPage(JoinPoint jp) {
        if (CHECK_AFTER_OPEN == PageChecks.NONE && VISUAL_PAGE_STRATEGY == VisualCheckPage.NONE)
            return;
        getWindows();
        Object element = jp.getThis();
        if (element != null && !isClass(element.getClass(), WebPage.class)) {
            WebPage page = getPage(element);
            String currentPage = getCurrentPage();
            if (currentPage != null && page != null) {
                if (!currentPage.equals(page.getName())) {
                    setCurrentPage(page);
                    BEFORE_NEW_PAGE.execute(page);
                }
                else BEFORE_THIS_PAGE.execute(page);
            }
        }
    }

    public static JFunc2<Object, String, String> ACTION_FAILED = (el, ex) -> ex;
    static void logFailure(Object el) {
        logger.toLog(">>> " + el.toString(), ERROR);
        String screenName = takeScreenOnFailure();
        String htmlSnapshot = takeHtmlCodeOnFailure();
        failStep(randomUUID().toString(), screenName, htmlSnapshot);
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
    public static Method getMethodFromJp(JoinPoint jp) {
        return getJpMethod(jp).getMethod();
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
        Method m = getMethodFromJp(joinPoint);
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
    static String getActionNameFromTemplate(MethodSignature method, String value,
                                            MapArray<String, Object>... args) {
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
}
