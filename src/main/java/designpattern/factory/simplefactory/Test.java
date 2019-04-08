package designpattern.factory.simplefactory;

/**
 * @Description 测试简单工厂模式
 * @Author lilong
 * @Date 2019-04-08 10:56
 */
public class Test {
    public static void main(String[] args) {
        testByName();
        System.out.println("----------------------");
        testByClazz();
    }

    private static void testByName() {
        Shape circle = ShapeFactory.getShapeByName("CIRCLE");
        circle.draw();

        Shape rectangle = ShapeFactory.getShapeByName("RECTANGLE");
        rectangle.draw();

        Shape square = ShapeFactory.getShapeByName("SQUARE");
        square.draw();
    }

    private static void testByClazz() {
        Shape circle = ShapeFactory.getShapeByClazz(Circle.class);
        circle.draw();

        Shape rectangle = ShapeFactory.getShapeByClazz(Rectangle.class);
        rectangle.draw();

        Shape square = ShapeFactory.getShapeByClazz(Square.class);
        square.draw();
    }
}
