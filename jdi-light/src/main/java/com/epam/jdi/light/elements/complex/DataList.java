package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.UIUtils;
import com.epam.jdi.light.elements.base.IListBase;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.PrintUtils;

import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.UIUtils.asEntity;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;

public class DataList<D, T extends IListBase> implements IList<D> {
    JList<T> list;
    Class<D> dataType;

    public DataList(Class<D> dataType, JList<T> list) {
        this.dataType = dataType;
        this.list = list;
    }

    public List<D> elements(int minAmount) {
        try {
            return LinqUtils.map(list.elements(minAmount), el -> asEntity(el, dataType));
        } catch (Exception ex) {
            throw exception("Can't get DataList data" + LINE_BREAK + ex.getMessage());
        }
    }

    public D get(String value) {
        return asEntity(list.get(value), dataType);
    }

    public List<String> values() {

    }
    public String getValue() {
        return list.getValue();
    }

    public void clear() {

    }

}