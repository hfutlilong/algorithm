package designpattern.factory.factorymethod;

import designpattern.factory.simplefactory.Shape;

/**
 * @Description 测试工厂方法模式
 * @Author lilong
 * @Date 2019-04-08 11:03
 */
public class Test {
    public static void main(String[] args) {
        ShapeFactory factory = new CircleFactory();
        Shape shape = factory.getShape(); // 抽象的工厂生产抽象的产品
        shape.draw();
    }
}
