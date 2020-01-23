package com.epam.jdi.light.elements.composite;

import com.epam.jdi.light.common.FormFilters;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.pageobjects.annotations.Mandatory;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JAction4;
import com.epam.jdi.tools.func.JFunc3;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.common.FormFilters.*;
import static com.epam.jdi.light.common.UIUtils.GET_BUTTON;
import static com.epam.jdi.light.common.UIUtils.getMapFromObject;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.getElementName;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.hasAnnotation;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.LinqUtils.first;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.*;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static com.epam.jdi.tools.StringUtils.namesEqual;
import static java.lang.String.format;

/**
 * Created by Roman Iovlev on 29.03.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Form<T> extends Section {
    public static JAction4<Field, Object, Object, String> FILL_ACTION = (field, element, parent, setValue)
        -> ((SetValue) element).setValue(setValue);

    public static JFunc3<Field, Object, Object, String> GET_ACTION = (field, element, parent)
        -> ((HasValue) element).getValue().trim();

    public void fillAction(Field field, Object element, Object parent, String setValue) {
        logger.debug("Fill element '%s' with value '%s'", getFieldName(field, element), setValue);
        FILL_ACTION.execute(field, element, parent, setValue);
    }
    public String getAction(Field field, Object element, Object parent) {
        logger.debug("Try to get element '%s' value", getFieldName(field, element));
        return GET_ACTION.execute(field, element, parent);
    }
    private String getFieldName(Field field, Object element) {
        return field != null ? field.getName() :
                (element != null ? element.toString() : "");
    }

    private FormFilters filter = ALL;
    public FormFilters getFilter() {
        return filter;
    }
    public void setFilterAll() {
        filter = ALL;
    }
    public void setFilter(FormFilters filter) {
        this.filter = filter;
    }

    /**
     * @param map Specify entity as map
     *            Fills all elements on the form which implements SetValue interface and can be matched with fields in input entity
     */
    public void fill(MapArray<String, String> map) {
        List<Field> allFields = allFields();
        if (allFields.size() == 0) {
            for (Pair<String, String> pair : map) {
                UIElement element = new UIElement().setup(e->e
                    .setName(pair.key)
                    .setParent(this));
                fillAction(null, element, pageObject, pair.value);
            }
            return;
        }
        Field setField = null;
        for (Pair<String, String> pair : map)
            try {
                setField = first(allFields, f -> namesEqual(pair.key, getElementName(f)));
                if (setField == null)
                    continue;
                fillAction(setField, getValueField(setField, pageObject), pageObject, pair.value);
            } catch (Exception ex) {
                throw exception(ex, "Can't fill element '%s'",
                    setField != null ? setField.getName() : "UNKNOWN FIELD");
            }
        setFilterAll();
    }
    private Object pageObject = this;
    public Form<T> setPageObject(Object obj) {
        pageObject = obj;
        return this;
    }
    public List<Field> allFields() {
        return allFields(pageObject);
    }
    public List<Field> allFields(Object obj) {
        switch (getFilter()) {
            case MANDATORY:
                return LinqUtils.where(getFields(obj, SetValue.class),
                        field -> hasAnnotation(field, Mandatory.class));
            case OPTIONAL:
                return LinqUtils.where(getFields(obj, SetValue.class),
                        field -> !hasAnnotation(field, Mandatory.class));
            default:
                return getFieldsInterfaceOf(obj, SetValue.class);
        }
    }

    public Form<T> onlyMandatory() {
        setFilter(MANDATORY);
        return this;
    }
    public Form<T> onlyOptional() {
        setFilter(OPTIONAL);
        return this;
    }
    /**
     * @param entity Specify entity
     *               Fills all elements on the form which implements SetValue interface and can be matched with fields in input entity
     */
    @JDIAction("Fill '{name}' with {0}")
    public void fill(T entity) {
        fill(getMapFromObject(entity));
    }

    /**
     * @param map Specify entity as mapArray
     *            Fills all elements on the form which implements SetValue interface and can be matched with fields in input entity
     */
    protected List<String> verify(MapArray<String, String> map) {
        List<String> compareFalse = new ArrayList<>();
        for (Field field : allFields()) {
            String fieldValue = map.firstValue((name, value) ->
                    namesEqual(name, getElementName(field)));
            if (fieldValue == null) continue;
            String actual = getAction(field, getValueField(field, pageObject), pageObject);
            if (!actual.equals(fieldValue))
                compareFalse.add(format("Field '%s' (Actual: '%s' <> Expected: '%s')", field.getName(), actual, fieldValue));
        }
        setFilterAll();
        return compareFalse;
    }
    /**
     * @param entity Specify entity
     * Verify that form filled correctly. If not returns list of keys where verification fails
     */
    @JDIAction(value = "Verify that '{name}' values are: {0}", timeout = 0)
    public List<String> verify(T entity) {
        return verify(getMapFromObject(entity));
    }

    /**
     * @param map Specify entity as mapArray
     *            Verify that form filled correctly. If not throws error
     */
    @JDIAction(value = "Check that '{name}' values are: {0}", timeout = 0)
    public void check(MapArray<String, String> map) {
        List<String> result = verify(map);
        if (result.size() != 0)
            throw exception( "Check form failed:" + LINE_BREAK + print(result, LINE_BREAK));
    }
    /**
     * @param entity Specify entity
     *               Verify that form filled correctly. If not throws error
     */
    @JDIAction(value = "Check that '{name}' values are: {0}", timeout = 0)
    public void check(T entity) {
        check(getMapFromObject(entity));
    }

    /**
     * @param text Specify text
     *             Fill first setable field with value and click on Button “submit” <br>
     * @apiNote To use this option Form pageObject should have at least one SetValue element and only one IsButton Element
     */
    @JDIAction(value = "Submit '{name}' with value '{0}'", timeout = 0)
    public void submit(String text) {
        submit(text, "submit");
    }

    /**
     * @param text       Specify text
     * @param buttonName button name for form submiting
     *                   Fill first setable field with value and click on Button “buttonName” <br>
     * @apiNote To use this option Form pageObject should have at least one SetValue element <br>
     * Allowed different buttons to send one form e.g. save/ publish / cancel / search update ...
     */
    @JDIAction(value = "Submit '{name}' with value '{0}' and press '{1}' button", timeout = 0)
    public void submit(String text, String buttonName) {
        List<Field> fields = getFields(pageObject, SetValue.class);
        if (fields.isEmpty())
            throw exception("Can't submit '%s' in form %s", text, this);
        Field field = fields.get(0);
        FILL_ACTION.execute(field, getValueField(field, pageObject), pageObject, text);
        pressButton(buttonName);
    }

    /**
     * Allowed different buttons to send one form e.g. save/ publish / cancel / search update ...
     */
    @JDIAction(value = "Submit '{name}' and press '{0}' button", timeout = 0)
    public void pressButton(String buttonName) {
        IClickable button = GET_BUTTON.execute(pageObject, buttonName);
        button.click();
    }
    public void submit() {
        pressButton("submit");
    }
    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “submit” <br>
     */
    @JDIAction(value = "Submit '{name}' with {0}", timeout = 0)
    public void submit(T entity) {
        submit(entity, "submit");
    }

    /**
     * @param buttonName Specify Button Name
     * @param entity     Specify entity
     *                   Fill all SetValue elements and click on Button specified button e.g. "Publish" or "Save" <br>
     * @apiNote To use this option Form pageObject should have button names in specific format <br>
     * e.g. if you call "submit(user, "Publish") then you should have Element 'publishButton'. <br>
     * * Letters case in button name  no matters
     */
    @JDIAction(value = "Fill '{name}' with {0} and press '{1}'", timeout = 0)
    public void submit(T entity, String buttonName) {
        submit(getMapFromObject(entity), buttonName);
    }


    protected void submit(MapArray<String, String> objStrings, String name) {
        fill(objStrings);
        pressButton(name);
    }
    /**
     * @param objStrings Fill all SetValue elements and click on Button specified button e.g. "Publish" or "Save" <br>
     * @apiNote To use this option Form pageObject should have button names in specific format <br>
     * e.g. if you call "submit(user, "Publish") then you should have Element 'publishButton'. <br>
     * * Letters case in button name  no matters
     */
    @JDIAction(value = "Submit '{name}' with {0}", timeout = 0)
    public void submit(MapArray<String, String> objStrings) {
        submit(objStrings, "submit");
    }

    //region Business action with form
    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “login” or ”loginButton” <br>
     */
    @JDIAction(value = "Login as {0}", timeout = 0)
    public void login(T entity) {
        submit(entity, "login");
    }
    @JDIAction("Login")
    public void login() {
        pressButton("login");
    }
    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “login” or ”loginButton” <br>
     */
    @JDIAction(value = "Login as {0}", timeout = 0)
    public void loginAs(T entity) {
        login(entity);
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “send” or ”sendButton” <br>
     */
    @JDIAction(value = "Send {0} in '{name}'", timeout = 0)
    public void send(T entity) {
        submit(entity, "send");
    }

    @JDIAction(value = "Send '{name}'", timeout = 0)
    public void send() {
        pressButton("send");
    }
    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “add” or ”addButton” <br>
     */
    @JDIAction(value = "Add {0} in '{name}'", timeout = 0)
    public void add(T entity) {
        submit(entity, "add");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “publish” or ”publishButton” <br>
     */
    @JDIAction(value = "Publish {0} for '{name}'", timeout = 0)
    public void publish(T entity) {
        submit(entity, "publish");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “save” or ”saveButton” <br>
     */
    @JDIAction(value = "Save {0} in '{name}'", timeout = 0)
    public void save(T entity) {
        submit(entity, "save");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “update” or ”updateButton” <br>
     */
    @JDIAction(value = "Update {0} in '{name}'", timeout = 0)
    public void update(T entity) {
        submit(entity, "update");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “cancel” or ”cancelButton” <br>
     */
    @JDIAction(value = "Fill {0} and cancel '{name}'", timeout = 0)
    public void cancel(T entity) {
        submit(entity, "cancel");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “close” or ”closeButton” <br>
     */
    @JDIAction(value = "Fill {0} and close '{name}'", timeout = 0)
    public void close(T entity) {
        submit(entity, "close");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “back” or ”backButton” <br>
     */
    @JDIAction(value = "Fill '{name}' with {0} and go back", timeout = 0)
    public void back(T entity) {
        submit(entity, "back");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “select” or ”selectButton” <br>
     */
    @JDIAction(value = "Select {0} for '{name}'", timeout = 0)
    public void select(T entity) {
        submit(entity, "select");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “next” or ”nextButton” <br>
     */
    @JDIAction(value = "Fill '{name}' with {0} and go to next", timeout = 0)
    public void next(T entity) {
        submit(entity, "next");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “search” or ”searchButton” <br>
     */
    @JDIAction(value = "Search for {0} in '{name}'", timeout = 0)
    public void search(T entity) {
        submit(entity, "search");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “search” or ”searchButton” <br>
     */
    @JDIAction(value = "Create {0} in '{name}'", timeout = 0)
    public void create(T entity) {
        submit(entity, "create");
    }

    @Override
    public boolean isDisplayed() {
        try {
            if (core().isDisplayed())
                return true;
            if (base().locator.isEmpty()) {
                List<Field> fields = getFieldsInterfaceOf(pageObject, HasValue.class);
                if (fields.isEmpty() && core().isDisplayed())
                    return true;
                Object po = fields.get(0).get(pageObject);
                if (isInterface(po.getClass(), ICoreElement.class) && ((ICoreElement) po).core().isDisplayed())
                    return true;
            }
        } catch (Exception ignore) { }
        return false;
    }
    //endregion
    @JDIAction("Return if form valid")
    public boolean isValid() {
        Object res = core().js().executeScript("return arguments[0].checkValidity()", core().get());
        return (Boolean) res;
    }
}
