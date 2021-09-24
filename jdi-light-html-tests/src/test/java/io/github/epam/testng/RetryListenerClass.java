package io.github.epam.testng;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListenerClass implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation testAnnotation, Class testClass, Constructor testConstructor, Method testMethod)	{
<<<<<<< HEAD
        IRetryAnalyzer retry = testAnnotation.getRetryAnalyzer();
=======
        Class<? extends IRetryAnalyzer> retry = testAnnotation.getRetryAnalyzerClass();
>>>>>>> 32f04ff0abf700608512f6bbe3b8e21628b1121b
        if (retry == null)	{
            testAnnotation.setRetryAnalyzer(RetryFailedTestCases.class);
        }

    }
}
