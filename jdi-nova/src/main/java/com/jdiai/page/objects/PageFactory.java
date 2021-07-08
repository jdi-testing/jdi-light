package com.jdiai.page.objects;

import com.jdiai.DataList;
import com.jdiai.JS;
import com.jdiai.WebPage;
import com.jdiai.annotations.Site;
import com.jdiai.interfaces.HasCore;
import com.jdiai.interfaces.HasName;
import com.jdiai.interfaces.ISetup;
import com.jdiai.jsbuilder.QueryLogger;
import com.jdiai.jsdriver.JDINovaException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static com.jdiai.JDI.domain;
import static com.jdiai.page.objects.CreateRule.cRule;
import static com.jdiai.page.objects.SetupRule.sRule;
import static java.lang.reflect.Modifier.isStatic;
import static java.util.Arrays.asList;

public class PageFactory {
    private static PagesFactory pageFactory = null;

    public static void initSite(Class<?> cl) {
        PagesFactory pageFactory = getFactory();
        pageFactory.initSite(cl);
    }
    public static <T> T initElements(Class<T> cl) {
        PagesFactory pageFactory = getFactory();
        return pageFactory.initElements(cl);
    }
    public static <T> T initPageElements(T pageObject) {
        PagesFactory pageFactory = getFactory();
        pageFactory.initElements(pageObject);
        return pageObject;
    }

    public static PagesFactory getFactory() {
        if (pageFactory != null) {
            return pageFactory;
        }
        pageFactory = new PagesFactory();
        pageFactory.initSiteFunc = cl -> {
            if (cl.isAnnotationPresent(Site.class)) {
                domain = cl.getAnnotation(Site.class).value();
            }
        };
        pageFactory.createPageFunc = PageFactoryUtils::createWithConstructor;
        pageFactory.isUIElementField = f ->
            isInterface(f.getType(), WebElement.class)
            || isInterface(f.getType(), HasCore.class)
            || isInterface(f.getType(), List.class);
        pageFactory.isUIObjectField = PageFactoryUtils::isUIObject;
        pageFactory.filterPages = f -> isStatic(f.getModifiers()) && (
            isClass(f.getType(), WebPage.class)
            || pageFactory.isUIObjectField.apply(f)
            || pageFactory.isUIElementField.apply(f)
        );
        pageFactory.createRules = map(
            $("WebElement", cRule(WebElement.class, cl -> new JS())),
            $("List", cRule(List.class, cl -> new DataList<>()))
        );
        pageFactory.setupRules.addAll(asList(
            $("JSElement", sRule(HasCore.class, PageFactoryUtils::setupCoreElement)),
            $("Name", sRule(HasName.class,
                    info -> ((HasName) info.instance).setName(pageFactory.getNameFunc.apply(info.field)))),
            $("Setup", sRule(ISetup.class, info -> ((ISetup)info.instance).setup(info.field)))
        ));
        pageFactory.logger = QueryLogger.logger;
        pageFactory.exceptionFunc = JDINovaException::new;
        pageFactory.reThrowException = JDINovaException::new;
        return pageFactory;
    }
}
