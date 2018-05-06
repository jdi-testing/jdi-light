package com.epam.jdi.light.common;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.tools.func.JAction1;
import com.epam.jdi.tools.func.JAction2;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import ru.yandex.qatools.allure.annotations.Step;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.StringUtils.splitLowerCase;
import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static com.epam.jdi.tools.switcher.SwitchActions.*;
import static java.lang.Character.toUpperCase;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;

@SuppressWarnings("unused")
@Aspect
public class ActionProcessor {
    public static String SHORT_TEMPLATE = "{element} {action}";
    public static String DEFAULT_TEMPLATE = "{action} ({element})";

    private static String getTemplate(LogLevels level) {
        return level.equalOrMoreThan(STEP) ? SHORT_TEMPLATE : DEFAULT_TEMPLATE;
    }
    public static JAction1<WebPage> newPage = page -> {
        if (CHECK_AFTER_OPEN)
            page.checkOpened();
        logger.toLog("Page: " + page.getName());
    };
    public static JFunc1<JoinPoint, String> getActionName = (joinPoint) -> {
        try {
            MethodSignature method = getMethod(joinPoint);
            String template = methodNameTemplate(method);
            if (isBlank(template))
                return getDefaultName(method.getName(), methodArgs(joinPoint, method));
            return Switch(template).get(
                Case(t -> t.contains("{0"), t ->
                    MessageFormat.format(t, joinPoint.getArgs())),
                Case(t -> t.contains("{"), t -> getActionNameFromTemplate(method, t,
                    new MapArray<>("this", getElementName(joinPoint)),
                    methodArgs(joinPoint, method), classFields(joinPoint))
                ),
                Case(t -> t.contains("%s"), t -> format(t, joinPoint.getArgs())),
                Default(t -> method.getName())
            );
        } catch (Exception ex) {
            throw new RuntimeException("Surround method issue: " +
                    "Can't get action name: " + ex.getMessage());
        }
    };
    public static JAction1<JoinPoint> stepBefore = joinPoint -> {
        String actionName = getActionName.execute(joinPoint);
        String logString = joinPoint.getThis() == null
                ? actionName
                : msgFormat(getTemplate(logger.getLogLevel()), map(
                $("action", actionName),
                $("element", getElementName(joinPoint))));
        logString = toUpperCase(logString.charAt(0)) + logString.substring(1);
        logger.toLog(logString, logLevel(joinPoint));
    };
    public static JAction1<JoinPoint> jdiBefore = joinPoint -> {
        if (logger.getLogLevel() != OFF) {
            processNewPage(joinPoint);
            stepBefore.execute(joinPoint);
        }
        logger.logOff();
    };
    public static JAction2<JoinPoint, Object> stepAfter = (joinPoint, result) -> {
        if (result != null && logLevel(joinPoint).equalOrMoreThan(INFO))
            logger.info(">>> " + result);
        logger.debug("Done");
    };
    public static JAction2<JoinPoint, Object> jdiAfter = (joinPoint, result) -> {
        logger.logOn();
        if (logger.getLogLevel() == OFF) return;
        stepAfter.execute(joinPoint, result);
    };

    private static void processNewPage(JoinPoint joinPoint) {
        Object element = joinPoint.getThis();
        if (element != null) { //TODO support static pages
            WebPage page = getPage(element);
            if (getCurrentPage() != null && page != null) {
                if (!getCurrentPage().equals(page.getName())) {
                    setCurrentPage(page);
                    newPage.execute(page);
                }
            }
        }
    }
    private static WebPage getPage(Object element) {
        if (isClass(element.getClass(), JDIBase.class))
            return ((JDIBase) element).getPage();
        return null;
    }
    public static boolean ERROR_THROWN = false;
    public static JAction2<JoinPoint, Throwable> jdiError = (joinPoint, error) -> {
        if (!ERROR_THROWN) {
            ERROR_THROWN = true;
            throw exception("Action %s failed. Can't get result. Reason: %s", getActionName.execute(joinPoint), error.getMessage());
        }
    };

    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() { }
    @Pointcut("execution(* *(..)) && @annotation(ru.yandex.qatools.allure.annotations.Step)")
    protected void stepPointcut() { }

    @Before("jdiPointcut()")
    public void before(JoinPoint joinPoint) {
        if (jdiBefore != null)
            jdiBefore.execute(joinPoint);
    }

    @AfterReturning(pointcut = "jdiPointcut()", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        if (jdiAfter != null)
            jdiAfter.execute(joinPoint, result);
    }

    @AfterThrowing(pointcut = "jdiPointcut()", throwing = "error")
    public void error(JoinPoint joinPoint, Throwable error) {
        if (jdiError != null)
            jdiError.execute(joinPoint, error);
    }
    @Before("stepPointcut()")
    public void beforeStep(JoinPoint joinPoint) {
        if (stepBefore != null)
            stepBefore.execute(joinPoint);
    }

    @AfterReturning(pointcut = "stepPointcut()", returning = "result")
    public void afterStep(JoinPoint joinPoint, Object result) {
        if (stepAfter != null)
            stepAfter.execute(joinPoint, result);
    }

    @AfterThrowing(pointcut = "stepPointcut()", throwing = "error")
    public void errorStep(JoinPoint joinPoint, Throwable error) {
        if (jdiError != null)
            jdiError.execute(joinPoint, error);
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

    static LogLevels logLevel(JoinPoint joinPoint) {
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
        return new MapArray<>(method.getParameterNames(), getArgs(joinPoint.getArgs()));
    }
    static Object[] getArgs(Object[] args) {
        Object[] result = new String [args.length];
        for (int i = 0; i< args.length; i++)
            result[i] = Switch(args[i]).get(
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
        return new MapArray<>(getThisFields(joinPoint), Field::getName, value -> getValueField(value, joinPoint.getThis()));
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
                ? getFields(obj)
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
}
/*    private String processNameTemplate(
            String template, MapArray<String, Object> params, MapArray<String, Object> fields) {
        final Matcher matcher = Pattern.compile("\\{([^}]*)}").matcher(template);
        final StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            final String pattern = matcher.group(1);
            String replacement = processPattern(pattern, params);
            if (replacement == null)
                replacement = processPattern(pattern, fields);
            if (replacement == null) replacement = matcher.group();
            matcher.appendReplacement(sb, Matcher.quoteReplacement(replacement));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
    @SuppressWarnings("ReturnCount")
    private static String processPattern(String pattern, MapArray<String, Object> params) {
        final String[] parts = pattern.split("\\.");
        final String parameterName = parts[0];
        if (!params.keys().contains(parameterName))
            return null;
        final Object param = params.get(parameterName);
        return extractProperties(param, parts, 1);
    }

    @SuppressWarnings("ReturnCount")
    private static String extractProperties(final Object object, final String[] parts, final int index) {
        if (Objects.isNull(object)) {
            return "null";
        }
        if (index < parts.length) {
            if (object instanceof Object[]) {
                return Stream.of((Object[]) object)
                        .map(child -> extractProperties(child, parts, index))
                        .collect(JOINER);
            }
            if (object instanceof Iterable) {
                final Spliterator<?> iterator = ((Iterable) object).spliterator();
                return StreamSupport.stream(iterator, false)
                        .map(child -> extractProperties(child, parts, index))
                        .collect(JOINER);
            }
            final Object child = on(object).get(parts[index]);
            return extractProperties(child, parts, index + 1);
        }
        if (object instanceof Object[]) {
            return Arrays.toString((Object[]) object);
        }
        return String.valueOf(object);
    }
*/
