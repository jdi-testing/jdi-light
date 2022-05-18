package com.epam.jdi.light.material.elements.displaydata.table;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.table.MUITableRowAssert;

import java.util.List;
import java.util.stream.Collectors;

public class MUITableRow extends MUITableCellContainer<MUITableRowAssert> {

    private final String cellLocator;

    public MUITableRow(int index, String cellLocator) {
        super(index);
        this.cellLocator = cellLocator;
    }

    @Override
    @JDIAction("Check that '{name}' is exist")
    public boolean isExist() {
        if (index() < 0 || cellLocator.isEmpty()) {
            return false;
        } else {
            //super.isExist() works incorrect because of core().isExist()
            try {
                return base().getWebElement().isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }
    }

    @Override
    @JDIAction("Get '{name}' size")
    public int size() {
        return cells(MUITableDefaultCell.class).size();
    }

    public <T extends MUITableCell<?>> T cell(int columnIndex, Class<T> cellType) {
        List<T> cells = cells(cellType);
        try {
            return cells.get(columnIndex - 1);
        } catch (IndexOutOfBoundsException e) {
            return createCellInstance(-1, -1, cellType);
        }
    }

    @JDIAction("Get '{name}' cell '{0}'")
    public MUITableDefaultCell cell(int columnIndex) {
        return cell(columnIndex, MUITableDefaultCell.class);
    }

    @JDIAction("Get '{name}' cell with text '{0}' and type '{1}'")
    public <T extends MUITableCell<?>> T cell(String text, Class<T> cellType) {
        List<T> targetCells = cells(cellType).stream()
                .filter(cell -> cell instanceof IsText && ((IsText) cell).getText().equals(text))
                .collect(Collectors.toList());
        if (!targetCells.isEmpty()) {
            return targetCells.get(0);
        } else {
            return createCellInstance(-1, -1, cellType);
        }
    }

    @JDIAction("Get '{name}' cell with text '{0}'")
    public MUITableDefaultCell cell(String text) {
        return cell(text, MUITableDefaultCell.class);
    }

    @JDIAction("Get '{name}' cells list with type '{0}'")
    public <T extends MUITableCell<?>> List<T> cells(Class<T> cellType) {
        List<UIElement> cellList = core().finds(cellLocator).stream()
                .map(element -> new UIElement().setCore(UIElement.class, element))
                .collect(Collectors.toList());

        for (int i = 0; i < cellList.size(); i++) {
            UIElement cell = cellList.get(i);
            if (cell.core().hasAttribute("colspan")) {
                int colspan = Integer.parseInt(cell.attr("colspan"));
                for (int j = 0; j < colspan; j++) {
                    cellList.add(cellList.indexOf(cell), cell);
                    i++;
                }
            }
        }

        return cellList.stream()
                .map(cell ->  createCellInstance(index(), cellList.indexOf(cell) + 1, cellType).setCore(cellType, cell))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' cells list")
    public List<MUITableDefaultCell> cells() {
        return cells(MUITableDefaultCell.class);
    }

    public List<String> cellsText() {
        return cells().stream().map(MUITableDefaultCell::getText).collect(Collectors.toList());
    }

    @Override
    public MUITableRowAssert is() {
        return new MUITableRowAssert().set(this);
    }

}
