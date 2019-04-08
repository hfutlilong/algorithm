package designpattern.factory.factorymethod;

import designpattern.factory.simplefactory.Shape;
import designpattern.factory.simplefactory.Square;

/**
 * @Description 正方形工厂类
 * @Author lilong
 * @Date 2019-04-08 11:03
 */
public class SquareFactory implements ShapeFactory{
    @Override
    public Shape getShape() {
        return new Square();
    }
}

