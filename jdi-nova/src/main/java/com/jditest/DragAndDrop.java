package com.jditest;

import org.openqa.selenium.WebElement;

public class DragAndDrop {
    private final JS dragElement;
    public DragAndDrop(JS dragElement) {
        this.dragElement = dragElement;
    }
    public void andDropTo(WebElement dropArea) {
        dragElement.dragAndDropTo(dropArea);
    }
}
