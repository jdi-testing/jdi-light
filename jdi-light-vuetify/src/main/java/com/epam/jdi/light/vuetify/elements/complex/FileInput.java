package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.elements.interfaces.common.IsInput;
import com.epam.jdi.light.vuetify.annotations.JDIFileInput;
import com.epam.jdi.light.vuetify.asserts.FileInputAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

/**
 * To see an example of File input web element please visit
 * https://vuetifyjs.com/en/components/file-inputs/
 */
public class FileInput extends UIBaseElement<FileInputAssert>
        implements HasLabel, HasPlaceholder, IsInput, ISetup {

    protected String filesLocator = ".v-chip";
    private final String INPUT = ".//input";
    private final String MESSAGE = ".v-messages__message";
    private final String COUNTER = ".v-counter";
    private final String PREPEND_OUTER = ".v-input__prepend-outer";
    private final String PREPEND_INNER = ".v-input__prepend-inner";
    private final String APPEND_OUTER = ".v-input__append-outer";
    private final String APPEND_INNER = ".v-input__append-inner";
    private final String PREFIX = ".v-text-field__prefix";
    private final String SUFFIX = ".v-text-field__suffix";

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
        return finds(filesLocator);
    }

    @JDIAction("Get '{name}' text input field")
    public UIElement textInputField() {
        return find(INPUT);
    }

    @JDIAction("Get '{name}' message")
    public UIElement message() {
        return find(MESSAGE);
    }

    @JDIAction("Get '{name}' counter")
    public UIElement counter() {
        return find(COUNTER);
    }

    @JDIAction("Get '{name}' prefix")
    public UIElement prefix() {
        return find(PREFIX);
    }

    @JDIAction("Get '{name}' suffix")
    public UIElement suffix() {
        return find(SUFFIX);
    }

    protected List<Icon> getIconByLocator(String locator) {
        return finds(locator)
                .stream()
                .map(icon -> icon.find(".v-icon"))
                .map(icon -> new Icon().setCore(Icon.class, icon))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' prepend outer icons")
    public List<Icon> prependOuterIcons() {
        return getIconByLocator(PREPEND_OUTER);
    }

    @JDIAction("Get '{name}' prepend inner icons")
    public List<Icon> prependInnerIcons() {
        return getIconByLocator(PREPEND_INNER);
    }

    @JDIAction("Get '{name}' append inner icons")
    public List<Icon> appendInnerIcons() {
        return getIconByLocator(APPEND_INNER);
    }

    @JDIAction("Get '{name}' append outer icons")
    public List<Icon> appendOuterIcons() {
        return getIconByLocator(APPEND_OUTER);
    }

    @JDIAction("Get '{name}' prepend outer icon")
    public Icon getPrependOuterIcon() {
        return prependOuterIcons().get(0);
    }

    @JDIAction("Get '{name}' prepend inner icons")
    public Icon getPrependInnerIcon() {
        return prependInnerIcons().get(0);
    }

    @JDIAction("Get '{name}' append inner icons")
    public Icon getAppendInnerIcon() {
        return appendInnerIcons().get(0);
    }

    @JDIAction("Get '{name}' append outer icons")
    public Icon getAppendOuterIcon() {
        return appendOuterIcons().get(0);
    }

    @Override
    public Label label() {
        return textInputField().label();
    }

    @Override
    @JDIAction("Get '{name}' label text")
    public String labelText() {
        return label().getText();
    }

    @Override
    @JDIAction("Get '{name}' placeholder")
    public String placeholder() {
        return textInputField().placeholder();
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
        this.setName(String.format("File input %s", field.getName()));
    }

    private void initializeLocators(JDIFileInput annotation) {
        if (!annotation.root().isEmpty()) {
            this.setCore(FileInput.class, $(annotation.root()));
        }
        if (!annotation.files().isEmpty()) {
            filesLocator = annotation.files();
        }
    }

    @Override
    public FileInputAssert is() {
        return new FileInputAssert().set(this);
    }
}
