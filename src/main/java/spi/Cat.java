package spi;

public class Cat implements Animal {
    @Override
    public void sayHello() {
        System.out.println("Hello, I'm a cat.");
    }
}
