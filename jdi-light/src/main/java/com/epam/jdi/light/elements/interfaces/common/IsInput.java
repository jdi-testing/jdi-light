package com.epam.jdi.light.elements.interfaces.common;

import com.epam.jdi.light.common.NullUserInputValueException;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import org.apache.commons.lang.NullArgumentException;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface IsInput extends IsText, HasPlaceholder {
    default void sendKeys(CharSequence... value) {
        if (value == null) {
            throw new NullUserInputValueException();
        }
        for (CharSequence c :  value) {
            if (c == null) {
                throw new NullUserInputValueException();
            }
        }
        core().sendKeys(value);
    }

    default void setText(String value) {
        if (value == null) {
            throw new NullUserInputValueException();
        }
        core().setText(value);
    }
    default void clear() { core().clear(); }
    default void input(String value) {
        if(value==null){
            throw new NullUserInputValueException();
        }
        core().input(value);
    }
    default void focus() { core().focus(); }
}
