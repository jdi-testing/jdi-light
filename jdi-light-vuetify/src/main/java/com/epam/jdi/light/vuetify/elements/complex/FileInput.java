package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.annotations.JDIFileInput;
import com.epam.jdi.light.vuetify.asserts.FileInputAssert;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class FileInput extends TextField implements ISetup {

    protected String ROOT_LOCATOR;
    protected String FILES_LOCATOR = ".v-chip";

    @JDIAction("Check that '{name}' can accept multiply files")
    public boolean isMultiply() {
        return textInputField().hasAttribute("multiple");
    }

    @Override
    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return !find(".v-input__control").attr("style").contains("display: none;");
    }

    @JDIAction("Get '{name}' files list")
    public WebList files() {
        return finds(FILES_LOCATOR);
    }

    @JDIAction("Get '{name}' accepted types")
    public String accept() {
        return textInputField().attr("accept");
    }

    @Override
    @JDIAction("Get '{name}' text")
    public String getText() {
        return find(".v-file-input__text").getText();
    }

    @JDIAction("Get '{name}' files list")
    public List<String> getFiles() {
        if (files().isNotEmpty()) {
            return files().map(UIElement::text);
        }
        return Collections.singletonList(getText());
    }

    @Override
    @JDIAction("Input '{0}' in '{name}'")
    public void sendKeys(CharSequence... value) {
        textInputField().getWebElement().sendKeys(value);
    }

    @Override
    @JDIAction("Input '{0}' in '{name}'")
    public void input(String value) {
        clear();
        sendKeys(value);
    }

    @Override
    @JDIAction("Set '{0}' in '{name}'")
    public void setText(String value) {
        clear();
        sendKeys(value);
    }

    @Override
    @JDIAction("Focus on '{name}'")
    public void focus() {
        core().click();
    }

    @Override
    @JDIAction("Clear '{name}' file input")
    public void clear() {
        if (!appendInnerIcons().isEmpty()) {
            getAppendInnerIcon().click();
        }
    }

    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFile(String path) {
        if (isDisabled())
            throw exception("FileInput '%s' is disabled. Can't upload file", getName());
        sendKeys(path);
    }

    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFiles(String... paths) {
        for (String path : paths) {
            uploadFile(path);
        }
    }

    public void uploadFiles(List<String> paths) {
        uploadFiles(paths.toArray(new String[0]));
    }

    @Override
    public void setup(Field field) {
        if (fieldHasAnnotation(field, JDIFileInput.class, FileInput.class)) {
            JDIFileInput annotation = field.getAnnotation(JDIFileInput.class);
            initializeLocators(annotation);
        }
        this.setCore(FileInput.class, $(ROOT_LOCATOR));
        this.setName(String.format("File input %s", field.getName()));
    }

    private void initializeLocators(JDIFileInput annotation) {
        if (!annotation.root().isEmpty()) {
            ROOT_LOCATOR = annotation.root();
        }
        if (!annotation.files().isEmpty()) {
            FILES_LOCATOR = annotation.files();
        }
    }

    @Override
    public FileInputAssert is() {
        FileInputAssert fileInputAssert = new FileInputAssert();
        fileInputAssert.set(this);
        return fileInputAssert;
    }

    @Override
    public FileInputAssert assertThat() {
        return is();
    }

    @Override
    public FileInputAssert has() {
        return is();
    }

    @Override
    public FileInputAssert waitFor() {
        return is();
    }

    @Override
    public FileInputAssert waitFor(int sec) {
        this.waitSec(sec);
        return is();
    }

    @Override
    public FileInputAssert shouldBe() {
        return is();
    }

    @Override
    public FileInputAssert verify() {
        assertSoft();
        return is();
    }
}
