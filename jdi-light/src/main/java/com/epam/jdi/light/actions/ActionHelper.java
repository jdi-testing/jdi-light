package com.epam.jdi.light.actions;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.base.INamed;
import com.epam.jdi.light.elements.interfaces.base.JDIElement;
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

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.elements.base.OutputTemplates.DEFAULT_TEMPLATE;
import static com.epam.jdi.light.elements.base.OutputTemplates.STEP_TEMPLATE;
import static com.epam.jdi.light.elements.common.WindowsManager.getWindows;
import static com.epam.jdi.light.elements.composite.WebPage.BEFORE_NEW_PAGE;
import static com.epam.jdi.light.elements.composite.WebPage.BEFORE_THIS_PAGE;
import static com.epam.jdi.light.elements.composite.WebPage.getCurrentPage;
import static com.epam.jdi.light.elements.composite.WebPage.setCurrentPage;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.ReflectionUtils.getAllFields;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static com.epam.jdi.tools.StringUtils.arrayToString;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.StringUtils.splitLowerCase;
import static com.epam.jdi.tools.map.MapArray.IGNORE_NOT_UNIQUE;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static com.epam.jdi.tools.switcher.SwitchActions.Case;
import static com.epam.jdi.tools.switcher.SwitchActions.Default;
import static com.epam.jdi.tools.switcher.SwitchActions.Switch;
import static com.epam.jdi.tools.switcher.SwitchActions.Value;
import static java.lang.Character.toUpperCase;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class ActionHelper {

    private static String getTemplate(LogLevels level) {
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
            throw new RuntimeException("Surround method issue: " +
                    "Can't get action name: " + safeException(ex));
        }
    };
    public static String fillTemplate(String template,
        ProceedingJoinPoint jp, MethodSignature method) {

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
            throw new RuntimeException("Surround method issue: Can't fill JDIAction template: " + template + " for method: " + method.getName() +
                LINE_BREAK + "" + safeException(ex));
        }
    }

    public static JAction1<ProceedingJoinPoint> BEFORE_STEP_ACTION = jp -> {
        logger.toLog(getBeforeLogString(jp), logLevel(jp));
    };
    public static JAction1<ProceedingJoinPoint> BEFORE_JDI_ACTION = jp -> {
        BEFORE_STEP_ACTION.execute(jp);
        processNewPage(jp);
    };

    public static int CUT_STEP_TEXT = 70;
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
        return result;
    };
    private static boolean logResult(ProceedingJoinPoint jp) {
        Class<?> cl = getJpClass(jp);
        if (!isInterface(cl, JDIElement.class)) return false;
        JDIAction ja = ((MethodSignature)jp.getSignature()).getMethod().getAnnotation(JDIAction.class);
        return ja != null && ja.logResult();
    }
    protected static Class<?> getJpClass(JoinPoint jp) {
        return jp.getThis() != null
                ? jp.getThis().getClass()
                : jp.getSignature().getDeclaringType();
    }

    public static JFunc2<ProceedingJoinPoint, Object, Object> AFTER_JDI_ACTION =
        (jp, result) -> AFTER_STEP_ACTION.execute(jp, result);

    //region Private
    private static String getBeforeLogString(ProceedingJoinPoint jp) {
        String actionName = GET_ACTION_NAME.execute(jp);
        String logString = jp.getThis() == null
            ? actionName
            : msgFormat(getTemplate(logger.getLogLevel()), map(
                $("action", actionName),
                $("element", getElementName(jp))));
        return toUpperCase(logString.charAt(0)) + logString.substring(1);
    }

    public static void processNewPage(JoinPoint jp) {
        getWindows();
        Object element = jp.getThis();
        if (element != null) { // TODO support static pages
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
    private static WebPage getPage(Object element) {
        if (isClass(element.getClass(), DriverBase.class) &&
            !isClass(element.getClass(), WebPage.class))
            return ((DriverBase) element).getPage();
        return null;
    }
    public static MethodSignature getJpMethod(JoinPoint joinPoint) {
        return (MethodSignature) joinPoint.getSignature();
    }

    private static String methodNameTemplate(MethodSignature method) {
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
            throw new RuntimeException("Surround method issue: " +
                    "Can't get method name template: " + safeException(ex));
        }
    }
    private static LogLevels logLevel(JoinPoint joinPoint) {
        Method m = getJpMethod(joinPoint).getMethod();
        return m.isAnnotationPresent(JDIAction.class)
                ? m.getAnnotation(JDIAction.class).level()
                : STEP;
    }

    private static String getDefaultName(String method, MapArray<String, Object> args) {
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

    private static MapArray<String, Object> methodArgs(JoinPoint joinPoint, MethodSignature method) {
        return toMap(() -> new MapArray<>(method.getParameterNames(), getArgs(joinPoint)));
    }

    private static MapArray<String, Object> toMap(JFunc<MapArray<String, Object>> getMap) {
        IGNORE_NOT_UNIQUE = true;
        MapArray<String, Object> map = getMap.execute();
        IGNORE_NOT_UNIQUE = false;
        return map;
    }
    private static Object[] getArgs(JoinPoint jp) {
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

    private static MapArray<String, Object> core(JoinPoint jp) {
        Class cl = jp.getSignature().getDeclaringType();
        if (jp.getThis() != null && isInterface(cl, ICoreElement.class)) {
            UIElement el = ((ICoreElement) jp.getThis()).core();
            return getAllFields(el);
        }
        return new MapArray<>();
    }
    private static MapArray<String, Object> classFields(Object obj) {
        return obj != null ? getAllFields(obj) : new MapArray<>();
    }

    private static String getElementName(JoinPoint jp) {
        try {
            Object obj = jp.getThis();
            if (obj == null) return jp.getSignature().getDeclaringType().getSimpleName();
            return isInterface(getJpClass(jp), INamed.class)
                ? ((INamed) obj).getName()
                : obj.toString();
        } catch (Exception ex) {
            throw exception("Can't get element name");
        }
    }
    private static String getActionNameFromTemplate(MethodSignature method, String value,
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
            throw new RuntimeException("Surround method issue: " +
                    "Can't get action name: " + safeException(ex));
        }
    }
    //endregion
}
