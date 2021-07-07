package com.jdiai.page.objects;

import com.epam.jdi.tools.ILogger;
import com.epam.jdi.tools.func.JFunc3;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.epam.jdi.tools.LinqUtils.*;
import static com.epam.jdi.tools.ReflectionUtils.getFieldsDeep;
import static com.epam.jdi.tools.ReflectionUtils.getValueField;
import static com.epam.jdi.tools.StringUtils.splitCamelCase;
import static com.jdiai.page.objects.SetupRule.sRule;
import static java.lang.String.format;
import static java.lang.reflect.Modifier.isStatic;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

public class PagesFactory {
    public Consumer<Class<?>> initSiteFunc = cl -> {};
    public Function<Class<?>, Object> createPageFunc =
        PagesFactory::createWithConstructor;
    public Function<Field, Boolean> isUIElementField = f -> true;
    public Function<Field, Boolean> isUIObjectField =
        f -> any(getFieldsDeep(f), field -> isUIElementField.apply(field));
    public Function<Field, Boolean> fieldsFilter =
        f -> isUIElementField.apply(f) || isUIObjectField.apply(f);
    public Function<Field, Boolean> filterPages =
        f -> isStatic(f.getModifiers()) && fieldsFilter.apply(f);
    public Function<Field, String> getNameFunc =
        f -> splitCamelCase(f.getName());
    public MapArray<String, CreateRule> createRules = new MapArray<>();
    public MapArray<String, SetupRule> setupRules = new MapArray<>("UI Object",
        sRule(info -> isUIObjectField.apply(info.field), info -> initElements(info.instance)));
    public ILogger logger = new ConsoleLogger("PageFactory Logger");
    public JFunc3<Throwable, String, Object[], RuntimeException> reThrowException =
        (ex, msg, args) -> new RuntimeException(format(msg, args), ex);
    public Function<String, RuntimeException> exceptionFunc =
        RuntimeException::new;

    public PagesFactory() { }

    public void initSite(Class<?> cl) {
        initSiteFunc.accept(cl);
        Field[] allFields = cl.getDeclaredFields();
        List<Field> pages = filter(allFields, filterPages);
        for (Field field : pages) {
            createAndSetupField(null, field);
        }
    }

    public <T> T initElements(Class<T> cl) {
        Object page = createPageFunc.apply(cl);
        initElements(page);
        return (T) page;
    }

    public void initElements(Object page) {
        List<Field> pageFields = getFieldsDeep(page.getClass());
        List<Field> filteredFields = filter(pageFields, fieldsFilter);
        for (Field field : filteredFields) {
            createAndSetupField(page, field);
        }
    }

    protected void createAndSetupField(Object page, Field field) {
        Object instance = getValueField(field, page);
        if (instance == null) {
            instance = createInstance(field.getType());
        }
        InitInfo info = new InitInfo(page, field, instance);
        MapArray<String, SetupRule> rules = setupRules.filter(
            rule -> rule.condition.apply(info));
        for (Pair<String, SetupRule> rule : rules) {
            logger.debug("Setup rule '%s' for field %s", rule.key, field.getName());
            rule.value.action.accept(info);
        }
        setFieldValue(field, page, info.instance);
    }

    protected void setFieldValue(Field field, Object page, Object instance) {
        try {
            field.set(page, instance);
        } catch (Exception ex) {
            throw reThrowException.execute(ex, "Failed to set value to field %s", new String[] { getClassName(field)}) ;
        }
    }

    protected String getClassName(Field field) {
        try {
            return field.getType().getSuperclass().getSimpleName() + "." + field.getType();
        } catch (Exception ex) {
            return "NULL FIELD";
        }
    }

    protected <T> T createInstance(Class<?> fieldClass) {
        if (fieldClass == null) {
            throw exceptionFunc.apply("Can't init class. Class Type is null.");
        }
        if (fieldClass.isInterface()) {
            CreateRule rule = null;
            if (isNotEmpty(createRules)) {
                rule = createRules.firstValue(r -> r.condition.apply(fieldClass));
            }
            if (rule == null) {
                throw exceptionFunc.apply("Failed to find create rule for " + fieldClass.getSimpleName());
            }
            return (T) rule.createAction.apply(fieldClass);
        }
        return (T) createPageFunc.apply(fieldClass);
    }

    static <T> T createWithConstructor(Class<?> cs) {
        try {
            Constructor<?>[] constructors = cs.getDeclaredConstructors();
            if (isEmpty(constructors)) {
                throw new RuntimeException("no constructors found");
            }
            Constructor<?> constructor = constructors.length == 1
                ? constructors[0]
                : first(constructors, c -> c.getParameterCount() == 0);
            if (constructor.getParameterCount() > 0) {
                throw new RuntimeException("constructor has more than 0 parameters");
            }
            constructor.setAccessible(true);
            return (T) constructor.newInstance();
        } catch (Exception ex) {
            throw new RuntimeException(format("%s has no appropriate constructors", cs.getSimpleName()), ex);
        }
    }
}
