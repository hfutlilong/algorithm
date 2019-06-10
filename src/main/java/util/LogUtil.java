package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description 控制台打印
 * @Author lilong
 * @Date 2019-06-10 16:15
 */
public class LogUtil {
    public static void print(String format, Object... arguments) {
        String source = "\\{\\}";

        Pattern p = Pattern.compile(source);
        Matcher m = p.matcher(format);

        int i = 0; // arguments
        while (m.find() && i < arguments.length) {
            format = format.replaceFirst(source, String.valueOf(arguments[i++]));
        }

        System.out.println(format);
    }

    public static void main(String[] args) {
        print("String:{}, Integer:{}, Boolean:{}, Double:{}", "aaa", 1, true, 2.333);
    }
}
