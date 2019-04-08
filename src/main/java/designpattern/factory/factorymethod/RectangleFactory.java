package designpattern.factory.factorymethod;

import designpattern.factory.simplefactory.Rectangle;
import designpattern.factory.simplefactory.Shape;

/**
 * @Description 长方形工厂类
 * @Author lilong
 * @Date 2019-04-08 11:02
 */
public class RectangleFactory implements ShapeFactory {
    @Override
    public Shape getShape() {
        return new Rectangle();
    }
}
