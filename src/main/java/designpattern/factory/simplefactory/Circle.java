package designpattern.factory.simplefactory;

/**
 * @Description 圆形
 * @Author lilong
 * @Date 2019-04-08 10:41
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }
}
