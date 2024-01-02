package myProject.utilities;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersRetryAnalyzer implements IAnnotationTransformer {
        // Bu sınıfın in amaci tüm testcaseleri otomatik olarak bir kez daha çalıştırmaktır.
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        // Bu sınıf ListenersRetry util class ına bağlıdır.
        annotation.setRetryAnalyzer(ListenersRetry.class);
    }
}
