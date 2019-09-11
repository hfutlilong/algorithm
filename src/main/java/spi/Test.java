package spi;

import javassist.*;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.lang.reflect.Method;
import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) {
//        testJavaSPI();
        testDubboSPI();

//        testJavassist();
    }

    private static void testJavaSPI() {
        ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);
        serviceLoader.forEach(Animal::sayHello);
    }

    private static void testDubboSPI() {
        ExtensionLoader<Animal> extensionLoader =
                ExtensionLoader.getExtensionLoader(Animal.class);
        Animal dog = extensionLoader.getExtension("dog");
        dog.sayHello();
        Animal cat = extensionLoader.getExtension("cat");
        cat.sayHello();
    }

    private static void testJavassist() {
        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.makeClass("HelloWorld");
            CtMethod ctMethod = CtNewMethod.make("public static void test(){System.out.println(\"Hello World!\");}", ctClass);
            ctClass.addMethod(ctMethod);
            Class aClass = ctClass.toClass();

            Object object = aClass.newInstance();
            Method m = aClass.getDeclaredMethod("test", null);
            m.invoke(object, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
