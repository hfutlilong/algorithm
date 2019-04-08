package designpattern.factory.simplefactory;

/**
 * @Description 长方形
 * @Author lilong
 * @Date 2019-04-08 10:42
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw Rectangle");
    }
}