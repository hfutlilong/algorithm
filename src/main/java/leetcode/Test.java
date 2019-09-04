package leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
//        String test = "解读规则：该商品的效期解读规则如下：<br>1.该商品的效期要看失效日期，效期总共8位，效期格式为：YYYYMM**；<br>2.效期第1和2和3和4位代表年，年是明文展示的,位数直接对应年份明文，例：17=2017年，2017=2017年；<br>3.效期第5和6位代表月，月是明文展示的,位数直接对应月份明文，例：08=8月，12=12月；<br>";
//
//        Pattern p = Pattern.compile("^(<p>).*(</p>)$");
//        Matcher m = p.matcher(test);
//
//        System.out.println(m.matches());
//
//        ThreadLocal tl = new ThreadLocal();


        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        System.out.println(JSON.toJSONString(a.subList(0, 2)));


    }
}

