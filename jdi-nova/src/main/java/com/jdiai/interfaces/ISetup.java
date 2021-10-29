package com.jdiai.interfaces;

import com.jdiai.page.objects.InitInfo;

import java.lang.reflect.Field;

public interface ISetup {
    default void setup(InitInfo info) {
        setup(info.field);
    }
    void setup(Field field);
}
