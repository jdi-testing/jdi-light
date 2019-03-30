package com.epam.jdi.light.actions;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.base.JDIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.tools.PrintUtils;
import com.epam.jdi.tools.StringUtils;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import com.epam.jdi.tools.map.MapArray;
import io.qameta.allure.Step;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

import static com.epam.jdi.light.elements.base.OutputTemplates.DEFAULT_TEMPLATE;
import static com.epam.jdi.light.elements.base.OutputTemplates.STEP_TEMPLATE;
import static com.epam.jdi.light.elements.base.WindowsManager.getWindows;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.*;
import static com.epam.jdi.tools.map.MapArray.IGNORE_NOT_UNIQUE;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static java.lang.Character.toUpperCase;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;

@SuppressWarnings("unused")
@Aspect
public class ActionHelper {

    private static String getTemplate(LogLevels level) {
        return level.equalOrMoreThan(STEP) ? STEP_TEMPLATE : DEFAULT_TEMPLATE;
    }
    public static JFunc1<ProceedingJoinPoint, String> GET_ACTION_NAME = jp -> {
        try {
            MethodSignature method = getMethod(jp);
            String template = methodNameTemplate(method);
            return isBlank(template)
                ? getDefaultName(method.getName(), methodArgs(jp, method))
                : fillTemplate(template, jp, method);
        } catch (Exception ex) {
            throw new RuntimeException("Surround method issue: " +
                    "Can't get action name: " + ex.getMessage());
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
                MapArray<String, Object> fields = classFields(jp);
                return getActionNameFromTemplate(method, template, obj, args, fields);
            }
            return template;
        } catch (Exception ex) { throw new RuntimeException("Can't fill JDIAction template: " + template + "for method: " + method.getName()); }
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
        Class<?> cl = jp.getThis() != null
            ? jp.getThis().getClass()
            : jp.getSignature().getDeclaringType();
        if (!isInterface(cl, JDIElement.class)) return false;
        JDIAction ja = ((MethodSignature)jp.getSignature()).getMethod().getAnnotation(JDIAction.class);
        return ja != null && ja.logResult();
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

    private static void processNewPage(JoinPoint joinPoint) {
        getWindows();
        Object element = joinPoint.getThis();
        if (element != null) { // TODO support static pages
            WebPage page = getPage(element);
            String currentPage = getCurrentPage();
            if (currentPage != null && page != null) {
                if (!currentPage.equals(page.getName())) {
                    setCurrentPage(page);
                    BEFORE_NEW_PAGE.execute(page);
                }
                else BEFORE_EACH_PAGE.execute(page);
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
    static MethodSignature getMethod(JoinPoint joinPoint) {
        return (MethodSignature) joinPoint.getSignature();
    }

    static String methodNameTemplate(MethodSignature method) {
        try {
            Method m = method.getMethod();
            String result;
            if (m.isAnnotationPresent(JDIAction.class)) {
                return m.getAnnotation(JDIAction.class).value();
            }
            if (m.isAnnotationPresent(Step.class)) {
                return m.getAnnotation(Step.class).value();
            }
            return null;
        } catch (Exception ex) {
            throw new RuntimeException("Surround method issue: " +
                    "Can't get method name template: " + ex.getMessage());
        }
    }
    private static LogLevels logLevel(JoinPoint joinPoint) {
        Method m = getMethod(joinPoint).getMethod();
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

    static MapArray<String, Object> classFields(JoinPoint joinPoint) {
        return toMap(()->new MapArray<>(getThisFields(joinPoint), Field::getName, value -> getValueField(value, joinPoint.getThis())));
    }

    static String getElementName(JoinPoint jp) {
        if (classFields(jp).keys().contains("jdi_element"))
            return classFields(jp).get("jdi_element").toString();
        Object obj = jp.getThis();
        return obj != null
                ? obj.toString()
                //obj.toString().matches(".*\\.\\w++@\\w+")
                : jp.getSignature().getDeclaringType().getSimpleName();

    }
    static List<Field> getThisFields(JoinPoint joinPoint) {
        Object obj = joinPoint.getThis();
        return /*obj != null
                ? getFieldsDeep(obj)
                : */asList(joinPoint.getSignature().getDeclaringType().getFields());
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
            throw new RuntimeException("Surround method issue: " +
                    "Can't get action name: " + ex.getMessage());
        }
    }
    //endregion
}
