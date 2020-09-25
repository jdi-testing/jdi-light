package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.table.ITableAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.defineLocator;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Grid extends UIBaseElement<ITableAssert<?,?>>
        implements IGrid, HasAssert<ITableAssert<?,?>>, ISetup {
    protected String allCellsLocator = "td";
    protected String cellTemplate = "//tr[{1}]/td[{0}]";
    protected String columnTemplate = "//tr/td[%s]";
    protected String rowTemplate = "//tr[%s]/td";
    protected String headerLocator = "th,thead td";
    protected String footerLocator = "tfoot td";
    protected List<String> header = null;
    protected int size = -1;
    protected int count = -1;

    public WebList webCells() {
        return core().finds(allCellsLocator)
            .setName(getName() + " webCells");
    }
    @Override
    public UIElement webCell(int colNum, int rowNum) {
        return core().find(MessageFormat.format(cellTemplate, colNum, rowNum))
            .setName(getName() + " webCell");
    }
    @Override
    public WebList webColumn(int colNum) {
        validateColumnIndex(colNum) ;
        return core().finds(columnTemplate, colNum)
            .setName(getName() + " webColumn");
    }
    @Override
    public WebList webRow(int rowNum) {
        validateRowIndex(rowNum) ;
        return core().finds(rowTemplate, rowNum)
            .setName(getName() + " webRow");
    }
    @Override
    public WebList headerUI() {
        return core().finds(headerLocator)
            .setName(getName() + " headerUI");
    }
    @Override
    public WebList footerUI() {
        return core().finds(footerLocator)
            .setName(getName() + " footerUI");
    }


    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JTable.class, Grid.class))
            return;
        JTable j = field.getAnnotation(JTable.class);
        List<String> header = asList(j.header());

        if (isNotBlank(j.root()))
            core().setLocator(defineLocator(j.root()));
        if (!j.row().equals("//tr[%s]/td") || !this.rowTemplate.equals("//tr[%s]/td"))
            this.rowTemplate = j.row();
        if (!j.column().equals("//tr/td[%s]") || !this.columnTemplate.equals("//tr/td[%s]"))
            this.columnTemplate = j.column();
        if (!j.cell().equals("//tr[{1}]/td[{0}]") || !this.cellTemplate.equals("//tr[{1}]/td[{0}]"))
            this.cellTemplate = j.cell();
        if (!j.allCells().equals("td") || !this.allCellsLocator.equals("td"))
            this.allCellsLocator = j.allCells();
        if (!j.headers().equals("th") || !this.headerLocator.equals("th"))
            this.headerLocator = j.headers();
        if (!j.footer().equals("tfoot") || !this.footerLocator.equals("tfoot"))
            this.footerLocator = j.footer();
        if (header.size() > 0)
            this.header = header;
        if (j.size() != -1)
            this.size = j.size();
        if (j.count() != -1)
            this.count = j.count();
    }

    @Override
    public ITableAssert<?,?> is() {
        return new ITableAssert<>().set(this);
    }
    // region Utilities
    protected void validateColumnIndex(int colNum) {
        if (colNum < 1)
            throw exception("Columns numeration starts from 1 (but requested index is %s)", colNum);
    }

    protected void validateRowIndex(int rowNum) {
        if (rowNum < 1)
            throw exception("Rows numeration starts from 1 (but requested index is %s)", rowNum);
    }
    // endregion
}
