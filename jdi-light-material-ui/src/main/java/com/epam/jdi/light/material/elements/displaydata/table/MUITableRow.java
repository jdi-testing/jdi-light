package com.epam.jdi.light.material.elements.displaydata.table;

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

    public MUITableDefaultCell cell(int columnIndex) {
        return cell(columnIndex, MUITableDefaultCell.class);
    }

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

    public MUITableDefaultCell cell(String text) {
        return cell(text, MUITableDefaultCell.class);
    }

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

    public List<MUITableDefaultCell> cells() {
        return cells(MUITableDefaultCell.class);
    }

    @Override
    public MUITableRowAssert is() {
        return new MUITableRowAssert().set(this);
    }

}
