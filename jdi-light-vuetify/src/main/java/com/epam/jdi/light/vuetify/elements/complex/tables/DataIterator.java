package com.epam.jdi.light.vuetify.elements.complex.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.annotations.JDataIterator;
import com.epam.jdi.light.vuetify.asserts.tables.DataIteratorAssert;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;
import com.epam.jdi.light.vuetify.interfaces.IsContainer;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.jdiai.tools.ReflectionUtils.getGenericTypes;
import static com.epam.jdi.light.common.Exceptions.exception;

/**
 * To see an example of Data Iterator web element please visit https://vuetifyjs.com/en/components/data-iterators/
 */

public class DataIterator<T extends ICoreElement> extends UIBaseElement<DataIteratorAssert> implements IsContainer, ISetup {
    protected Class<T> contentClazz;
    private String toolbarsLocator = "./header";
    private String itemLocator = "[class^='col']";
    public static String groupedDataIteratorLocator = "//code[text()='PARAMETER']/parent::p/following-sibling::div//div[text()='VALUE']/following-sibling::div//li";

    public DataIterator() {
    }
    public DataIterator(Class<T> type) {
        this.contentClazz = type;
    }

    @Override
    public void setup(Field field) {
        setupInnerClasses(field);

        if (fieldHasAnnotation(field, JDataIterator.class, DataIterator.class)) {
            JDataIterator annotation = field.getAnnotation(JDataIterator.class);
            if (!annotation.root().isEmpty()) {
                setCore(DataIterator.class, $(annotation.root()));
            }
            if (!annotation.listItems().isEmpty()) {
                this.itemLocator = annotation.listItems();
            }
            if (!annotation.listItems().isEmpty()) {
                this.toolbarsLocator = annotation.headers();
            }
        }
    }

    protected void setupInnerClasses(Field field) {
        Type[] types = getGenericTypes(field);
        if (types.length != 1)
            return;
        try {
            contentClazz = types[0].toString().equals("?") ? null : (Class<T>) types[0];
        } catch (Exception ex) {
            throw exception(ex, "Can't get DataIterator %s entity class", getName());
        }
    }

    @Override
    public UIElement content() {
        return core().find("./div");
    }
    public WebList elements() {
        return finds(this.itemLocator);
    }

    public T item(int childIndex) {
        return elements().get(childIndex).with(contentClazz);
    }

    @JDIAction("Get '{name}' header")
    public List<ToolBar> headers() {
        return finds(toolbarsLocator).stream().map(t -> new ToolBar().setCore(ToolBar.class, t)).collect(Collectors.toList());
    }

    @Override
    public DataIteratorAssert is() {
        DataIteratorAssert dataIteratorAssert = new DataIteratorAssert();
        dataIteratorAssert.set(this);
        return dataIteratorAssert;
    }

    @Override
    public DataIteratorAssert assertThat() {
        return is();
    }

    @Override
    public DataIteratorAssert has() {
        return is();
    }

    public static WebList groupedElements(String groupingParameter, String parameterValue) {
        return $$(groupedDataIteratorLocator
                .replace("PARAMETER", groupingParameter)
                .replace("VALUE", parameterValue));
    }
}
