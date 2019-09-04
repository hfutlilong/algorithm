package test;

import test.spi.Animal;

import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) {
        ServiceLoader<Animal> serviceLoader = ServiceLoader.load(Animal.class);
        System.out.println("Java SPI TEST");
        serviceLoader.forEach(Animal::sayHello);
    }
}
