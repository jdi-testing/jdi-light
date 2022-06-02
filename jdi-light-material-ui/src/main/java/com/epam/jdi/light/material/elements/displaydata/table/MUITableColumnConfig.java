package com.epam.jdi.light.material.elements.displaydata.table;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.Exceptions;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.annotations.JMUITableColumnConfig;
import com.epam.jdi.light.material.asserts.displaydata.table.MUITableColumnConfigAssert;
import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.light.material.elements.inputs.TextField;
import com.epam.jdi.light.ui.html.elements.common.Button;

import java.util.List;
import java.util.stream.Collectors;

public class MUITableColumnConfig extends UIBaseElement<MUITableColumnConfigAssert> implements HasAssert<MUITableColumnConfigAssert> {

    private final JMUITableColumnConfig columnConfig;
    private TextField searchField;
//    private Button hideAllButton;
//    private Button showAllButton;

    public MUITableColumnConfig(JMUITableColumnConfig columnConfig) {
        this.columnConfig = columnConfig;
        base().setLocator(columnConfig.root());
    }

    @JDIAction("Get '{name}' search field")
    public TextField searchField() {
        if (searchField == null) {
            searchField = new TextField().setCore(TextField.class, core().find(columnConfig.searchField()));
        }
        return searchField;
    }

    @JDIAction("Get '{name}' switch '{0}'")
    public Switch getSwitch(String labelText) {
        return getSwitches().stream()
                .filter(switchElement -> switchElement.labelText().equals(labelText))
                .findFirst()
                .orElseThrow(() -> Exceptions.runtimeException(String.format("No switch '%s' found in column config", labelText)));
    }

    @JDIAction("Get '{name}' switches list")
    public List<Switch> getSwitches() {
        return core().finds(columnConfig.listItem()).stream()
                .map(switchElement -> new Switch().setCore(Switch.class, switchElement))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' 'Hide all' button ")
    public Button hideAllButton() {
//        if (hideAllButton == null) {
//            hideAllButton = new Button().setCore(Button.class, core().find(columnConfig.hideAllButton()));
//        }
        //html Button seems not working properly by using class field
        return new Button().setCore(Button.class, core().find(columnConfig.hideAllButton()));
    }

    @JDIAction("Get '{name}' 'Show all' button")
    public Button showAllButton() {
//        if (showAllButton == null) {
//            showAllButton = new Button().setCore(Button.class, core().find(columnConfig.showAllButton()));
//        }
        //html Button seems not working properly by using class field
        return new Button().setCore(Button.class, core().find(columnConfig.showAllButton()));
    }

    @Override
    public MUITableColumnConfigAssert is() {
        return new MUITableColumnConfigAssert().set(this);
    }

}
