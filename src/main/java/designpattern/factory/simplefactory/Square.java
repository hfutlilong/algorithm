package designpattern.factory.simplefactory;

/**
 * @Description 正方形
 * @Author lilong
 * @Date 2019-04-08 10:43
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Draw Square");
    }
}