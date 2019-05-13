package com.epam.jdi.light.ui.html.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.complex.Combobox;

import java.util.List;

import static com.epam.jdi.light.ui.html.HtmlFactory.$$;
import static com.epam.jdi.tools.LinqUtils.ifSelect;

public class HtmlCombobox extends HtmlElement implements Combobox {
    HtmlList dataList() {
        return $$("#"+getAttribute("list")+" option")
            .noValidation().setName("list");
    }
    List<String> list() {
        return dataList().values();
    }

    /**
     * Selects the value
     * @param value String to select
     */
    @Override
    @JDIAction("Select '{0}' for '{name}''")
    public void select(String value) {
        super.setText(value);
    }

    /**
     * Selects the value based on its index
     * @param index int to search
     */
    @JDIAction("Select '{0}' for '{name}'")
    public void select(int index) {
        setText(list().get(index-1));
    }

    /**
     * Gets selected option
     * @return String
     */
    @JDIAction("Get selected in '{name}' option")
    public String selected() {
        return getAttribute("value");
    }

    /**
     * Gets all options
     * @return List<String>
     */
    @JDIAction("Get all '{name}' options")
    public List<String> values() {
        return list();
    }

    /**
     * Gets all enabled options
     * @return List<String>
     */
    @JDIAction("Get all '{name}' enabled options")
    public List<String> listEnabled() {
        return ifSelect(dataList(), HtmlElement::isEnabled, HtmlElement::getText);
    }


    /**
     * Gets all disabled options
     * @return List<String>
     */
    @JDIAction("Get all '{name}' disabled options")
    public List<String> listDisabled() {
        return ifSelect(dataList(), HtmlElement::isDisabled, HtmlElement::getText);
    }
}
