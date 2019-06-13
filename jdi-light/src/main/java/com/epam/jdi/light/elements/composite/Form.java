package com.epam.jdi.light.elements.composite;

import com.epam.jdi.light.common.FormFilters;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.BaseWebElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.elements.pageobjects.annotations.Mandatory;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JAction4;
import com.epam.jdi.tools.func.JFunc3;
import com.epam.jdi.tools.map.MapArray;
import com.epam.jdi.tools.pairs.Pair;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.FormFilters.*;
import static com.epam.jdi.light.common.UIUtils.GET_BUTTON;
import static com.epam.jdi.light.common.UIUtils.getMapFromObject;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.getElementName;
import static com.epam.jdi.light.elements.pageobjects.annotations.WebAnnotationsUtil.hasAnnotation;
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
        FILL_ACTION.execute(field, element, parent, setValue);
    }
    public String getAction(Field field, Object element, Object parent) {
        return GET_ACTION.execute(field, element, parent);
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
    protected void fill(MapArray<String, String> map) {
        List<Field> allFields = allFields();
        if (allFields.size() == 0) {
            for (Pair<String, String> pair : map) {
                UIElement element = new UIElement().setParent(this).setName(pair.key);
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
            } catch (Exception ex) { throw exception("Can't fill element '%s'. Exception: %s",
                    setField != null ? setField.getName() : "UNKNOWN FIELD", ex.getMessage()); }
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
    @JDIAction("Verify that '{name}' values are: {0}")
    public List<String> verify(T entity) {
        return verify(getMapFromObject(entity));
    }

    /**
     * @param map Specify entity as mapArray
     *            Verify that form filled correctly. If not throws error
     */
    protected void check(MapArray<String, String> map) {
        List<String> result = verify(map);
        if (result.size() != 0)
            throw exception( "Check form failed:" + LINE_BREAK + print(result, LINE_BREAK));
    }
    /**
     * @param entity Specify entity
     *               Verify that form filled correctly. If not throws error
     */
    @JDIAction("Check that '{name}' values are: {0}")
    public void check(T entity) {
        check(getMapFromObject(entity));
    }

    /**
     * @param text Specify text
     *             Fill first setable field with value and click on Button “submit” <br>
     * @apiNote To use this option Form pageObject should have at least one SetValue element and only one IButton Element
     */
    @JDIAction("Submit '{name}' with value '{0}'")
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
    @JDIAction("Submit '{name}' with value '{0}' and press '{1}' button")
    public void submit(String text, String buttonName) {
        List<Field> fields = getFields(pageObject, SetValue.class);
        if (fields.isEmpty())
            throw exception("Can't submit '%s' in form %s", text, this);
        Field field = fields.get(0);
        FILL_ACTION.execute(field, getValueField(field, pageObject), pageObject, text);
        GET_BUTTON.execute(pageObject, buttonName).click();
    }

    /**
     * Allowed different buttons to send one form e.g. save/ publish / cancel / search update ...
     */
    @JDIAction("Submit '{name}' and press '{0}' button")
    public void pressButton(String buttonName) {
        GET_BUTTON.execute(pageObject, buttonName).click();
    }
    public void submit() {
        pressButton("submit");
    }
    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “submit” <br>
     * @apiNote To use this option Form pageObject should have only one IButton Element
     */
    @JDIAction("Submit '{name}' with {0}")
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
    @JDIAction("Fill '{name}' with {0} and press '{1}'")
    public void submit(T entity, String buttonName) {
        submit(getMapFromObject(entity), buttonName);
    }


    protected void submit(MapArray<String, String> objStrings, String name) {
        fill(objStrings);
        GET_BUTTON.execute(pageObject, name).click();
    }
    /**
     * @param objStrings Fill all SetValue elements and click on Button specified button e.g. "Publish" or "Save" <br>
     * @apiNote To use this option Form pageObject should have button names in specific format <br>
     * e.g. if you call "submit(user, "Publish") then you should have Element 'publishButton'. <br>
     * * Letters case in button name  no matters
     */
    protected void submit(MapArray<String, String> objStrings) {
        submit(objStrings, "submit");
    }

    //region Business action with form
    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “login” or ”loginButton” <br>
     * @apiNote To use this option Form pageObject should have only one IButton Element
     */
    @JDIAction("Login as {0}")
    public void login(T entity) {
        submit(entity, "login");
    }
    @JDIAction("Login")
    public void login() {
        GET_BUTTON.execute(pageObject, "login").click();
    }
    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “login” or ”loginButton” <br>
     * @apiNote To use this option Form pageObject should have only one IButton Element
     */
    @JDIAction("Login as {0}")
    public void loginAs(T entity) {
        login(entity);
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “send” or ”sendButton” <br>
     * @apiNote To use this option Form pageObject should have only one IButton Element
     */
    @JDIAction("Send {0} in '{name}'")
    public void send(T entity) {
        submit(entity, "send");
    }

    @JDIAction("Send '{name}'")
    public void send() {
        GET_BUTTON.execute(pageObject, "send").click();
    }
    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “add” or ”addButton” <br>
     * @apiNote To use this option Form pageObject should have only one IButton Element
     */
    @JDIAction("Add {0} in '{name}'")
    public void add(T entity) {
        submit(entity, "add");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “publish” or ”publishButton” <br>
     * @apiNote To use this option Form pageObject should have only one IButton Element
     */
    @JDIAction("Publish {0} for '{name}'")
    public void publish(T entity) {
        submit(entity, "publish");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “save” or ”saveButton” <br>
     * @apiNote To use this option Form pageObject should have only one IButton Element
     */
    @JDIAction("Save {0} in '{name}'")
    public void save(T entity) {
        submit(entity, "save");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “update” or ”updateButton” <br>
     * @apiNote To use this option Form pageObject should have only one IButton Element
     */
    @JDIAction("Update {0} in '{name}'")
    public void update(T entity) {
        submit(entity, "update");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “cancel” or ”cancelButton” <br>
     * @apiNote To use this option Form pageObject should have only one IButton Element
     */
    @JDIAction("Fill {0} and cancel '{name}'")
    public void cancel(T entity) {
        submit(entity, "cancel");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “close” or ”closeButton” <br>
     * @apiNote To use this option Form pageObject should have only one IButton Element
     */
    @JDIAction("Fill {0} and close '{name}'")
    public void close(T entity) {
        submit(entity, "close");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “back” or ”backButton” <br>
     * @apiNote To use this option Form pageObject should have only one IButton Element
     */
    @JDIAction("Fill '{name}' with {0} and go back")
    public void back(T entity) {
        submit(entity, "back");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “select” or ”selectButton” <br>
     * @apiNote To use this option Form pageObject should have only one IButton Element
     */
    @JDIAction("Select {0} for '{name}'")
    public void select(T entity) {
        submit(entity, "select");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “next” or ”nextButton” <br>
     * @apiNote To use this option Form pageObject should have only one IButton Element
     */
    @JDIAction("Fill '{name}' with {0} and go to next")
    public void next(T entity) {
        submit(entity, "next");
    }

    /**
     * @param entity Specify entity
     *               Fill all SetValue elements and click on Button “search” or ”searchButton” <br>
     * @apiNote To use this option Form pageObject should have only one IButton Element
     */
    @JDIAction("Search for {0} in '{name}'")
    public void search(T entity) {
        submit(entity, "search");
    }

    @Override
    public boolean displayed() {
        try {
            if (webElement.hasValue())
                return webElement.get().isDisplayed();
            if (locator.isEmpty()) {
                List<Field> fields = getFieldsInterfaceOf(pageObject, SetValue.class);
                if (fields.isEmpty())
                    return get().isDisplayed();
                BaseWebElement first = (BaseWebElement) fields.get(0).get(pageObject);
                return first.isDisplayed();
            }
            List<WebElement> result = getAll();
            return result.size() == 1 && result.get(0).isDisplayed();
        } catch (Exception ex) { return false; }
    }
    //endregion
}
