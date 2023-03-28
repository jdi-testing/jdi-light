package com.epam.jdi.light.material.elements.displaydata.table;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.annotations.JMUITableHeader;
import com.epam.jdi.light.material.asserts.displaydata.table.MUITableHeaderAssert;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class MUITableHeader extends MUITableCellContainer<MUITableHeaderAssert> implements HasAssert<MUITableHeaderAssert> {

    private List<MUITableRow> rows;
    private final String headerRowLocator;
    private final String columnHeaderLocator;
    private final String buttonLocator;
    private final String selectedRowsLocator;
    
    public MUITableHeader(JMUITableHeader tableHeader) {
        super(0);
        this.headerRowLocator = tableHeader.headerRow();
        this.columnHeaderLocator = tableHeader.columnHeaders();
        this.buttonLocator = tableHeader.button();
        this.selectedRowsLocator = tableHeader.selectedRows();
        base().setLocator(tableHeader.root());
    }
    
    @JDIAction("Get '{name}' selected rows amount")
    public int selectedRows() {
        Text selectedRows = new Text().setCore(Text.class, core().find(selectedRowsLocator));
        if (selectedRows.isExist()) {
            String value = selectedRows.getValue();
            Matcher m = Pattern.compile("(\\d+)").matcher(value);
            return m.find() ? Integer.parseInt(m.group(1)) : 0;
        } else {
            return 0;
        }
    }

    @JDIAction("Get '{name}' button")
    public Button button() {
        return new Button().setCore(Button.class, core().find(buttonLocator));
    }

    @Override
    public MUITableHeaderAssert is() {
        return new MUITableHeaderAssert().set(this);
    }
    
    public List<MUITableRow> headerRows(){
        if(rows.isEmpty()) {
            List<UIElement> rowList = core().finds(headerRowLocator).stream()
                .map(element -> new UIElement().setCore(UIElement.class, element))
                .collect(Collectors.toList());
            rows = rowList.stream()
                .map(row -> new MUITableRow(rowList.indexOf(row), columnHeaderLocator).setCore(MUITableRow.class, row))
                .collect(Collectors.toList());
        }
        return rows;
    }
    
    public <T extends MUITableCell<?>> T cell(String columnHeader, Class<T> cellType) {
        Optional<MUITableRow> matchedHeaderRow = headerRows().stream().filter(hRow -> {
            MUITableDefaultCell cell = hRow.cell(columnHeader);
            return cell.columnIndex() > -1 && cell.rowIndex() > -1;
        }).findFirst();
        if (matchedHeaderRow.isPresent()) {
            return matchedHeaderRow.get().cell(columnHeader, cellType);
        } else {
            return createCellInstance(-1, -1, cellType);
        }
    }
    
    public MUITableDefaultCell cell(String columnName) {
        return cell(columnName, MUITableDefaultCell.class);
    }
    
    public MUITableDefaultCell cell(int columnNumber) {
        return headerRows().get(headerRows().size() - 1).cell(columnNumber);
    }
    
    public MUITableColumn<MUITableDefaultCell> column(String columnName) {
         MUITableDefaultCell cell = cell(columnName, MUITableDefaultCell.class);
        return new MUITableColumn<>(cell.columnIndex(), Collections.singletonList(cell), MUITableDefaultCell.class);
    }

    public MUITableColumn<MUITableDefaultCell> column(int columnNumber) {
        MUITableDefaultCell cell = cell(columnNumber);
       return new MUITableColumn<>(cell.columnIndex(), Collections.singletonList(cell), MUITableDefaultCell.class);
   }
    
    public List<Integer> subColumnsIndexes(String columnName) {
        List<Integer> columnIndexes = new ArrayList<>();
        for (int i = 1; i <= headerRows().size(); i++) {
            MUITableDefaultCell cell = headerRows().get(i - 1).cell(columnName);
            if(cell.columnIndex() > -1 && cell.rowIndex() > -1) {
                if(i < headerRows().size() && cell.hasAttribute("colspan")) {
                    int colspan = Integer.parseInt(cell.attr("colspan"));
                    for(int j = 0; j < colspan; j++) {
                        columnIndexes.add(cell.columnIndex() + j);
                    }
                } else {
                    int colspanSum = getColspanSumOnTheLeftFromTargetColumn(headerRows().get(i - 1), cell.columnIndex() - 1);
                    columnIndexes.add(cell.columnIndex() + colspanSum);
                }
                break;
            }
        }
        return columnIndexes;
    }
    
    private int getColspanSumOnTheLeftFromTargetColumn(MUITableRow row, int targetColumnIndex) {
        int sum = 0;
        List<MUITableDefaultCell> cells = row.cells();
        for(int i = 0; i < targetColumnIndex; i++) {
            if(cells.get(i).hasAttribute("colspan")) {
                sum += Integer.parseInt(cells.get(i).attr("colspan")) - 1;
            }
        }
        return sum;
    }

    @Override
    public int size() {
        return headerRows().size();
    }
}
