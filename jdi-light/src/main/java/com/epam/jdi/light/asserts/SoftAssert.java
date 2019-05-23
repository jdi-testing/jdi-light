package com.epam.jdi.light.asserts;

import com.epam.jdi.light.elements.init.rules.ErrorCollector;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.light.settings.WebSettings.IS_SOFT_ASSERT;
import static org.hamcrest.MatcherAssert.assertThat;

public class SoftAssert {
    private static ErrorCollector collector = new ErrorCollector();

    public static <T> void softAssertThat(T actual, Matcher<? super T> matcher) {
        try {
            assertThat(actual, matcher);
        } catch (Throwable error) {
            if (IS_SOFT_ASSERT) {
                collector.addError(error);
            } else if (error.getMessage().length() != 0){
                throw new AssertionError(error);
            }
        }
    }

    public static List<Throwable> getResults() {
        try {
            if (collector.showResults().size() > 0) {
                throw new AssertionError(collector.showResults());
            }
        } catch (AssertionError assertionError){
            collector.clear();
            throw new AssertionError(assertionError);
        }
        return null;
    }

    private static void clearResults(){
        collector.clear();
    }
}
