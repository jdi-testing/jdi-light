package com.epam.jdi.light.material.elements.displaydata.table;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.annotations.JMUITableHeader;
import com.epam.jdi.light.material.asserts.displaydata.table.MUITableHeaderAssert;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class MUITableHeader extends UIBaseElement<MUITableHeaderAssert> implements HasAssert<MUITableHeaderAssert> {

    private String headerRowLocator;
    private String columnHeaderLocator;
    private String buttonLocator;
//    private Text headerText;
    
    public MUITableHeader(JMUITableHeader tableHeader) {
        this.headerRowLocator = tableHeader.headerRow();
        this.columnHeaderLocator = tableHeader.columnHeaders();
        this.buttonLocator = tableHeader.button();
        base().setLocator(tableHeader.root());
    }

    @JDIAction("Get '{name}' text")
    public Text text() {
//        if (headerText == null) {
//            headerText = new Text().setCore(Text.class, core().find(tableHeader.text()));
//        }
        return new Text().setCore(Text.class, core().finds(columnHeaderLocator));
    }
    
    @JDIAction("Get '{name}' selected rows amount")
    public int selectedRows() {
        if (text().isExist()) {
            String value = text().getValue();
            try {
                return Integer.parseInt(value.substring(0, value.indexOf(" ")));
            } catch (NumberFormatException e) {
                return 0;
            }
        } else {
            return 0;
        }
    }

    @JDIAction("Get '{name}' button")
    public Button button() {
//        if (filterButton == null) {
//            filterButton = new Button().setCore(Button.class, core().find(tableHeader.button()));
//        }
        //html Button seems not working properly by using class field
        return new Button().setCore(Button.class, core().find(buttonLocator));
    }

    @Override
    public MUITableHeaderAssert is() {
        return new MUITableHeaderAssert().set(this);
    }
    
    private List<MUITableRow> headerRows(){
        List<UIElement> rowList = core().finds(headerRowLocator).stream()
            .map(element -> new UIElement().setCore(UIElement.class, element))
            .collect(Collectors.toList());
        return rowList.stream()
            .map(row -> new MUITableRow(rowList.indexOf(row), columnHeaderLocator).setCore(MUITableRow.class, row))
            .collect(Collectors.toList());
    }
    
    public <T extends MUITableCell<?>> T cell(String columnHeader, Class<T> cellType) {
        Optional<MUITableRow> matchedHeaderRow = headerRows().stream().filter(hRow -> {
            MUITableDefaultCell cell = hRow.cell(columnHeader);
            return cell.columnIndex() > -1 && cell.rowIndex() > -1;
        }).findFirst();
        if (matchedHeaderRow.isPresent()) {
            return matchedHeaderRow.get().cell(columnHeader, cellType);
        } else {
            throw new IllegalArgumentException(String.format("No column found with name '%s'", columnHeader));
        }
    }
    
    public List<Integer> headerCell(String columnName) {
        List<Integer> columnIndexes = new ArrayList<>();
        List<MUITableRow> headerRows = headerRows();
        for (int i = 1; i <= headerRows.size(); i++) {
            MUITableDefaultCell cell = headerRows.get(i - 1).cell(columnName);
            if(cell.columnIndex() > -1 && cell.rowIndex() > -1) {
                if(i < headerRows.size() && cell.hasAttribute("colspan")) {
                    int colspan = Integer.parseInt(cell.attr("colspan"));
                    for(int j = 0; j < colspan; j++) {
                        columnIndexes.add(cell.columnIndex() + j);
                    }
                } else {
                    int colspanSum = getColspanSumOnTheLeftFromTargetColumn(headerRows.get(i - 1), cell.columnIndex() - 1);
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
    
    public MUITableDefaultCell cell(int columnIndex) {
        List<MUITableRow> headerRows = headerRows();
        return headerRows.get(headerRows.size() - 1).cell(columnIndex);
    }

}
