package com.epam.jdi.light.elements.complex;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.base.IListBase;

import java.util.List;

public class DataList<D, T extends IListBase> implements IList<D> {
    JList<T> list;
    public JList<T> list() {
        return list;
    }

    public List<D> elements(int minAmount) {
        return null;
    }

    public D get(String value) {
        return null;
    }

    public String getValue() {
        return null;
    }

    public void clear() {

    }
}