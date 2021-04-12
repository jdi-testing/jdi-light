package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.generic.table.IGridAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.webList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JTable;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverByUtils.NAME_TO_LOCATOR;
import static com.epam.jdi.light.driver.WebDriverFactory.hasRunDrivers;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.LinqUtils.toList;
import static com.epam.jdi.tools.Timer.getByCondition;
import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Grid extends UIBaseElement<IGridAssert<Line, IGrid<Line>, ?>>
        implements IGrid<Line>, ISetup {
    protected String allCellsLocator = "tbody td";
    protected String cellTemplate = "//tbody//tr[{1}]/td[{0}]";
    protected String columnTemplate = "//tbody//tr/td[%s]";
    protected String rowTemplate = "//tbody//tr[%s]/td";
    protected String headerLocator = "th";
    protected String footerLocator = "tfoot td";
    protected List<String> header = new ArrayList<>();
    protected int size = -1;
    protected int count = -1;
    protected List<Integer> columnsMapping;
    protected boolean columnsValidated = false;
    protected boolean locatorsValidated = false;
    protected int startIndex = ELEMENT.startIndex;

    public webList webCells() {
        return core().finds(allCellsLocator)
            .setName(getName() + " webCells");
    }
    @Override
    public com.epam.jdi.light.elements.common.uiElement core() {
        com.epam.jdi.light.elements.common.uiElement core = super.core();
        if (hasRunDrivers() && !locatorsValidated) {
            try {
                locatorsValidated = true;
                validateLocators(core);
                logger.debug(getName() + ": Validation success");
            } catch (Throwable ex) {
                locatorsValidated = false;
            }
        }
        return core;
    }
    protected void validateLocators(com.epam.jdi.light.elements.common.uiElement core) {
        if (headerLocator.equals("th") && core.finds("th").isEmpty()) {
            if (core.finds("thead td").isNotEmpty()) {
                headerLocator = "thead td";
            } else {
                if (core.finds("//tr[1]//td").isNotEmpty()) {
                    headerLocator = "//tr[1]//td";
                }
            }
        }
    }

    @Override
    public List<String> header() {
        return ObjectUtils.isNotEmpty(header)
            ? header
            : IGrid.super.header();
    }
    protected int getColumnIndex(int index) {
        if (!columnsValidated) {
            validateColumns();
        }
        return ObjectUtils.isEmpty(columnsMapping)
            ? index : columnsMapping.get(index-1);
    }
    @Override
    public int count() {
        return count > -1 ? count : webColumn(1).size();
    }

    public List<Line> elements(int minAmount) {
        return getByCondition(this::rows, r -> r.size() >= minAmount);
    }
    public Line get(String value) {
        return row(value);
    }

    @Override
    public int size() {
        return size > -1 ? size : IGrid.super.size();
    }

    public void clear() {
        size = -1;
        count = -1;
    }

    @Override
    public com.epam.jdi.light.elements.common.uiElement webCell(int colNum, int rowNum) {
        return core().find(MessageFormat.format(cellTemplate, colNum, rowNum))
            .setName(format("%s cell(%s,%s)", getName(), colNum, rowNum));
    }
    @Override
    public webList webColumn(int colNum) {
        int index = getColumnIndex(colNum);
        validateColumnIndex(index);
        return core().finds(columnTemplate, index)
            .setName(format("%s column:%s", getName(), index));
    }
    @Override
    public webList webRow(int rowNum) {
        validateRowIndex(rowNum);
        return core().finds(rowTemplate, rowNum)
            .setName(format("%s row:%s", getName(), rowNum));
    }
    @Override
    public webList headerUI() {
        return core().finds(headerLocator)
            .setName(getName() + " headerUI");
    }
    @Override
    public webList footerUI() {
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
            core().setLocator(NAME_TO_LOCATOR.execute(j.root()));
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
        if (header.size() > 0) {
            this.header = header;
            this.size = header.size();
        }
        if (j.columnsMapping().length > 0) {
            this.columnsMapping = toList(j.columnsMapping());
            this.size = j.columnsMapping().length;
            this.columnsValidated = true;
        }
        if (j.size() != -1)
            this.size = j.size();
        if (j.count() != -1)
            this.count = j.count();
    }

    @Override
    public IGridAssert<Line, IGrid<Line>, ?> is() {
        return new IGridAssert<>(this);
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
    protected synchronized void validateColumns() {
        if (columnsValidated)
            return;
        try {
            webList header = headerUI();
            logger.debug("Start column validation");
            List<WebElement> visibleHeader = header.getAll();
            List<WebElement> fullHeader = header.getWebElements();
            if (visibleHeader.size() < fullHeader.size()) {
                columnsMapping = new ArrayList<>();
                int j = 0;
                String visibleValue = visibleHeader.get(j++).getText();
                for (int i = 0; i < fullHeader.size(); i++) {
                    String fullValue = fullHeader.get(i).getText();
                    if (fullValue.equals(visibleValue)) {
                        logger.debug("Column '%s' is %d (text is '%s')", visibleValue, i+1, fullValue);
                        columnsMapping.add(i + 1);
                        if (j < visibleHeader.size())
                            visibleValue = visibleHeader.get(j++).getText();
                    }
                }
                logger.debug("Columns mapping is %s", columnsMapping.toString());
            } else {
                logger.debug("Columns mapping is not required");
            }
            columnsValidated = true;
        } catch (Exception ex) {
            throw exception(ex, "Column validation failed. Please correct header locator or just setup correct 'columnsMapping' in @JTable");
        }
    }
    public int getStartIndex() {
        return startIndex;
    }
    public void setStartIndex(int index) {
        startIndex = index;
    }
    // endregion
}
