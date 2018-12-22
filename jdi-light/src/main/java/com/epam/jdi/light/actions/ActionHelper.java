package com.epam.jdi.light.actions;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.DriverBase;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.logger.LogLevels;
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
import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

import static com.epam.jdi.light.elements.base.OutputTemplates.DEFAULT_TEMPLATE;
import static com.epam.jdi.light.elements.base.OutputTemplates.SHORT_TEMPLATE;
import static com.epam.jdi.light.elements.base.WindowsManager.getWindows;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.logger.LogLevels.INFO;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.StringUtils.splitLowerCase;
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
        return level.equalOrMoreThan(STEP) ? SHORT_TEMPLATE : DEFAULT_TEMPLATE;
    }
    public static JFunc1<ProceedingJoinPoint, String> GET_ACTION_NAME = jp -> {
        try {
            MethodSignature method = getMethod(jp);
            String template = methodNameTemplate(method);
            if (isBlank(template))
                return getDefaultName(method.getName(), methodArgs(jp, method));
            return Switch(template).get(
                    Case(t -> t.contains("{0"), t -> {
                        Object[] args = jp.getArgs();
                        return MessageFormat.format(t, args);
                    }),
                    Case(t -> t.contains("{"), t -> {
                        MapArray<String, Object> obj = toMap(()->new MapArray<>("this", getElementName(jp)));
                        MapArray<String, Object> args = methodArgs(jp, method);
                        MapArray<String, Object> fields = classFields(jp);
                        return getActionNameFromTemplate(method, t, obj, args, fields);
                    }),
                    Case(t -> t.contains("%s"), t -> format(t, jp.getArgs())),
                    Default(t -> method.getName())
            );
        } catch (Exception ex) {
            throw new RuntimeException("Surround method issue: " +
                    "Can't get action name: " + ex.getMessage());
        }
    };

    public static JAction1<ProceedingJoinPoint> BEFORE_STEP_ACTION = jp -> {
        logger.toLog(getBeforeLogString(jp), logLevel(jp));
    };
    public static JAction1<ProceedingJoinPoint> BEFORE_JDI_ACTION = jp -> {
        BEFORE_STEP_ACTION.execute(jp);
        processNewPage(jp);
    };

    public static JFunc2<ProceedingJoinPoint, Object, Object> AFTER_STEP_ACTION = (jp, result) -> {
        if (result != null && logLevel(jp).equalOrMoreThan(INFO))
            logger.info(">>> " + result);
        logger.debug("Done");
        return result;
    };
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
    static String getActionName(JoinPoint joinPoint) {
        try {
            MethodSignature method = getMethod(joinPoint);
            String template = methodNameTemplate(method);
            return Switch(template).get(
                Case(t -> t.contains("{0"), t -> MessageFormat.format(t, joinPoint.getArgs())),
                Case(t -> t.contains("{"), t -> {
                    MapArray obj = toMap(()->new MapArray<>("this", getElementName(joinPoint)));
                    return getActionNameFromTemplate(method, t, obj, methodArgs(joinPoint, method), classFields(joinPoint));
                }),
                Case(t -> t.contains("%s"), t -> format(t, joinPoint.getArgs())),
                Default(t -> getDefaultName(t, methodArgs(joinPoint, method)))
            );
        } catch (Exception ex) {
            throw new RuntimeException("Surround method issue: " +
                    "Can't get action name: " + ex.getMessage());
        }
    }

    static String arrayToString(Object array) {
        String result = "";
        boolean first = true;
        for(Object a : (Object[])array) {
            if (first) first = false;
            else result += ",";
            result += a.toString();
        }
        return result;
    }
    static MapArray<String, Object> methodArgs(JoinPoint joinPoint, MethodSignature method) {
        return toMap(() -> new MapArray<>(method.getParameterNames(), getArgs(joinPoint.getArgs())));
    }

    static MapArray<String, Object> toMap(JFunc<MapArray<String, Object>> getMap) {
        IGNORE_NOT_UNIQUE = true;
        MapArray<String, Object> map = getMap.execute();
        IGNORE_NOT_UNIQUE = false;
        return map;
    }
    static Object[] getArgs(Object[] args) {
        if (args.length == 1 && args[0] == null)
            return new Object[] {};
        Object[] result = new Object[args.length];
        for (int i = 0; i< args.length; i++)
            result[i] = Switch(args[i]).get(
                Case(Objects::isNull, null),
                Case(arg -> arg.getClass().isArray(),
                    arg ->  printList(asList((Object[])arg))),
                Case(arg -> isInterface(arg.getClass(), List.class),
                    arg ->  printList((List<?>)arg)),
                Default(arg -> arg));
        return result;
    }

    static String printList(List<?> list) {
        String result = "";
        for (int i=0; i<list.size()-1;i++)
            result += list.get(i)+",";
        return result + list.get(list.size()-1);
    }

    static MapArray<String, Object> classFields(JoinPoint joinPoint) {
        return toMap(()->new MapArray<>(getThisFields(joinPoint), Field::getName, value -> getValueField(value, joinPoint.getThis())));
    }

    static String getElementName(JoinPoint joinPoint) {
        Object obj = joinPoint.getThis();
        return obj != null
                ? obj.toString()
                : joinPoint.getSignature().getDeclaringType().getSimpleName();
    }
    static List<Field> getThisFields(JoinPoint joinPoint) {
        Object obj = joinPoint.getThis();
        return obj != null
                ? getFieldsDeep(obj)
                : asList(joinPoint.getSignature().getDeclaringType().getFields());
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
