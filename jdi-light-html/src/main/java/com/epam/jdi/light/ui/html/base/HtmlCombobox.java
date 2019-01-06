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
    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) {
        super.setText(value);
    }

    /**
     * Selects the value based on its index
     * @param index int to search
     */
    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
        setText(list().get(index-1));
    }
    @JDIAction("Get selected in '{name}' option")
    public String selected() {
        return getAttribute("value");
    }

    @JDIAction("Get all '{name}' options")
    public List<String> values() {
        return list();
    }

    @JDIAction("Get all '{name}' enabled options")
    public List<String> listEnabled() {
        return ifSelect(dataList(), HtmlElement::isEnabled, HtmlElement::getText);
    }

    @JDIAction("Get all '{name}' disabled options")
    public List<String> listDisabled() {
        return ifSelect(dataList(), HtmlElement::isDisabled, HtmlElement::getText);
    }
}
