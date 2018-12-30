package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.complex.Combobox;
import com.epam.jdi.light.ui.html.complex.DataList;

import java.util.List;
import java.util.Objects;

import static com.epam.jdi.light.ui.html.HtmlFactory.$$;
import static com.epam.jdi.tools.LinqUtils.ifSelect;

public class HtmlCombobox extends HtmlElement implements DataList, Combobox {
    HtmlList dataList() {
        HtmlList list = $$("#"+getAttribute("list")+" option");
        list.searchRule = Objects::nonNull;
        list.setName("list");
        return list;
    }
    List<String> list() {
        return dataList().values();
    }

    @Override
    public void select(String value) {
        super.setText(value);
    }

    /**
     * Selects the value based on its index
     * @param index int to search
     */
    @JDIAction
    public void select(int index) {
        setText(list().get(index-1));
    }
    @JDIAction
    public String selected() {
        return getAttribute("value");
    }

    @JDIAction
    public List<String> values() {
        return list();
    }

    @JDIAction
    public List<String> enabled() {
        return ifSelect(dataList(), HtmlElement::isEnabled, HtmlElement::getText);
    }
    @JDIAction
    public List<String> disabled() {
        return ifSelect(dataList(), HtmlElement::isDisabled, HtmlElement::getText);
    }
}
