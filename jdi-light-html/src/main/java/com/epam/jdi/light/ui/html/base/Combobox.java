package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.ui.html.complex.ComboBox;
import com.epam.jdi.light.ui.html.complex.DataList;

import java.util.List;
import java.util.Objects;

import static com.epam.jdi.light.ui.html.HtmlFactory.$$;
import static com.epam.jdi.tools.LinqUtils.ifSelect;

public class Combobox extends HtmlElement implements DataList, ComboBox {
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
    public void select(int index) {
        setText(list().get(index-1));
    }
    public String selected() {
        return getAttribute("value");
    }

    public List<String> values() {
        return list();
    }

    public List<String> enabled() {
        return ifSelect(dataList(), HtmlElement::isEnabled, HtmlElement::getText);
    }
    public List<String> disabled() {
        return ifSelect(dataList(), HtmlElement::isDisabled, HtmlElement::getText);
    }
}
