package com.epam.jdi.light.vuetify.elements.complex.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.asserts.tables.DataIteratorAssert;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;
import com.epam.jdi.light.vuetify.interfaces.IsContainer;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.init.UIFactory.$$;

/**
 * To see an example of Data Iterator web element please visit https://vuetifyjs.com/en/components/data-iterators/
 */

public class DataIterator<T extends ICoreElement> extends UIBaseElement<DataIteratorAssert> implements IsContainer {
    private Class<T> contentClazz;
    private static final String TOOLBARS = "./header";
    public static String groupedDataIteratorLocator = "//code[text()='PARAMETER']/parent::p/following-sibling::div//div[text()='VALUE']/following-sibling::div//li";

    public DataIterator(Class<T> type) {
        this.contentClazz = type;
    }
    @Override
    public UIElement content() {
        return core().find("./div");
    }
    public WebList elements() {
        return finds("[class^='col']");
    }

    public T item(int cardNumber) {
        return elements().get(cardNumber).with(contentClazz);
    }

    @JDIAction("Get '{name}' header")
    public List<ToolBar> headers() {
        return finds(TOOLBARS).stream().map(t -> new ToolBar().setCore(ToolBar.class, t)).collect(Collectors.toList());
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
