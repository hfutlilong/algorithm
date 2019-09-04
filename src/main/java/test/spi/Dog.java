package test.spi;

public class Dog implements Animal {
    @Override
    public void sayHello() {
        System.out.println("Hello, I'm a dog.");
    }
}
