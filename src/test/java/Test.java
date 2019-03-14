import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 小测试
 * @Author lilong
 * @Date 2019-02-27 15:12
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(3);
        map.put(null,null);
        System.out.println(map.size());
//
//
//        Map<Integer, String> table = new Hashtable<>();
//        table.put(1,"");
//
//        System.out.println("666");

//        Map<Integer, String> map = new ConcurrentHashMap<>();
//        map.put(1,"");

    }
}
