package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import utility.configFailedCase;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class failListener implements IAnnotationTransformer {

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)	{
        Class<? extends IRetryAnalyzer> retry = annotation.getRetryAnalyzerClass();
        if (retry == null)	{
            annotation.setRetryAnalyzer(configFailedCase.class);
        }

    }
}
