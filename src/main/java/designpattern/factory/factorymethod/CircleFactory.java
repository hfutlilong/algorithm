package designpattern.factory.factorymethod;

import designpattern.factory.simplefactory.Circle;
import designpattern.factory.simplefactory.Shape;

/**
 * @Description 圆形工厂类
 * @Author lilong
 * @Date 2019-04-08 11:01
 */
public class CircleFactory implements ShapeFactory {
    @Override
    public Shape getShape() {
        return new Circle();
    }
}
