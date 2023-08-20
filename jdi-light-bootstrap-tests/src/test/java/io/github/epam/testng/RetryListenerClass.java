package io.github.epam.testng;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListenerClass implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation testAnnotation, Class testClass, Constructor testConstructor, Method testMethod)	{
        if (testAnnotation.getRetryAnalyzerClass() == null)	{
            testAnnotation.setRetryAnalyzer(RetryFailedTestCases.class);
        }

    }
}
