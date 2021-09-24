package io.github.com.pages;

import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.tools.CacheValue;

import java.lang.reflect.Field;

import static com.epam.jdi.light.actions.ActionProcessor.isTop;
import static com.epam.jdi.light.elements.common.WindowsManager.getWindows;
import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.settings.WebSettings.init;

/**
 * Created by Nikita Nechepurenko on 15.09.2021
 * <p>
 *     Vue.js (and nuxt) is a front end JavaScript framework for building user interfaces and single-page applications.
 *     Those types of frameworks are not redirecting a user to another page, but re-render the main page.<br/>
 *     When you use @Url annotation with a page link like `@Url("/alerts")`, JDI will build a full URL
 *     `JSite-base/alerts` and you will probably get a 404 page error. At the same time when you open this page via
 *     main page you can see the same URL and it will work. <br/>
 *     There is no special magic there. Visual URL representation can be modified by such frameworks to look the way
 *     you want. So we need to somehow get to the required page but through the main one.<br/>
 *     There is a solution to proxying all WebPage descendants' `open()` method call via aspects but it requires you
 *     to recompile files (with aspect-support plugins) every time you change
 *     a content of test scenario that uses the page object.<br/>
 *     To have all test scenarios work the way we want (not to get a 404 error) all page objects
 *     should extend this class.
 * </p>
 */
public abstract class VuetifyPage extends WebPage implements ISetup {

    protected String PAGE_LINK = "";

    /**
     * Custom page object `open` code to support SPA provided by nuxt.
     * @param params are not supported in this particular implementation
     */
    @Override
    public void open(Object... params) {
        // navigate to the main page
        WebPage mainPage = new WebPage();
        mainPage.setName("Main page");
        mainPage.open();

        // navigate to a desired page and initialize it
        navigate();
        initializePage();
    }

    /**
     * In order to navigate through the "virtual" pages of SPA, official documentation of Vue.js recommends using
     * a `push` method of a router object.
     * https://router.vuejs.org/ru/guide/essentials/navigation.html
     *
     * As far as nuxt is a vue.js based framework, we can use the same commands.
     */
    private void navigate() {
        if (PAGE_LINK.isEmpty()) {
            throw new RuntimeException("VuetifyPage url has not been set.");
        }

        // use the described way to navigate
        // we take a `$nuxt` object from the global scope and call the page router `push` method with the desired url.
        js().executeScript("$nuxt.$router.push({'path': arguments[0]})", PAGE_LINK);
    }

    /**
     * JDI WebPage initialization code except of `driver navigate to` call
     */
    private void initializePage() {
        init();
        CacheValue.reset();
        getWindows();
        isTop.set(true);
        setCurrentPage(this);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, Url.class, VuetifyPage.class)) {
            throw new RuntimeException("VuetifyPage does not have an Url annotation.");
        }

        PAGE_LINK = field.getAnnotation(Url.class).value().substring(1);
    }
}