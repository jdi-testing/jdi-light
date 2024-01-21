package io.github.com.pages;

import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

import java.lang.reflect.Field;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public abstract class NewAngularPage extends WebPage implements ISetup {
    protected String pageLink = "";
    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, Url.class, NewAngularPage.class)) {
            throw runtimeException("AngularPage does not have an Url annotation.");
        }
        pageLink = field.getAnnotation(Url.class).value().substring(1);
    }
}
