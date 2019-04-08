package designpattern.factory.simplefactory;

/**
 * @Description 简单工厂模式
 * @Author lilong
 * @Date 2019-04-08 10:55
 */
public class ShapeFactory {
    // 使用 getShape 方法获取形状类型的对象
    public static Shape getShapeByName(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }

    public static Shape getShapeByClazz(Class<? extends Shape> clazz) {
        Shape shape = null;
        try {
            shape = (Shape)Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return shape;
    }
}
