package com.epam.jdi.light.mobile.interfaces;

public interface HasTouchActions extends IMobileCoreElement {
    default void tap() { core().tap(); }
    default void doubleTap() { core().doubleTap(); }
    default void longPress() { core().longPress(); }
    default void longPress(int seconds) { core().longPress(seconds); }
    default void dragAndDropTo(int xOffset, int yOffset) { core().dragAndDropTo(xOffset, yOffset); }
}
