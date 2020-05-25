package com.epam.jdi.light.elements.complex;

import java.util.List;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IMultiSelector extends ISelector  {
    List<String> checked();
}
