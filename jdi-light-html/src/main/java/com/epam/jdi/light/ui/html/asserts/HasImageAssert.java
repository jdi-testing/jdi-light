package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.IBaseAssert;
import com.epam.jdi.light.ui.html.interfaces.HasImage;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public interface HasImageAssert<A, E extends HasImage> extends IBaseAssert<HasImage> {

    default A hasImage(){
        jdiAssert(element().hasImage(), Matchers.is(true), "Image doesn't exists");
        return (A) this;
    }

    default A withoutImage(){
        jdiAssert(element().hasImage(), Matchers.is(true), "Image exists");
        return (A) this;
    }

}
