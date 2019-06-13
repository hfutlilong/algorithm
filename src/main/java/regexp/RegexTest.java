package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2019-06-13 16:58
 */
public class RegexTest {
    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        // 去除单词与 , 和 . 之间的空格
        String str = "Hello , World .";
        Pattern p = Pattern.compile("(\\w)(\\s+)([.,])");
        // $0 匹配 `(\w)(\s+)([.,])` 结果为 `o空格,` 和 `d空格.`
        // $1 匹配 `(\w)` 结果为 `o` 和 `d`
        // $2 匹配 `(\s+)` 结果为 `空格` 和 `空格`
        // $3 匹配 `([.,])` 结果为 `,` 和 `.`
//        System.out.println(Str.replaceAll(pattern, "$1$3")); // Hello, World.
        Matcher m = p.matcher(str);

        while (m.find()) {
            System.out.println("group():" + m.group());
            System.out.println("group(0):" + m.group(0));
            System.out.println("group(1):" + m.group(1));
            System.out.println("group(2):" + m.group(2));
            System.out.println("group(3):" + m.group(3));
            System.out.println("#######################");
        }

    }

    private static void test2() {
        String str = "img.jpg";
        // 分组且创建反向引用
        Pattern pattern = Pattern.compile("(jpg|png)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
        }
    }

    private static void test3() {
        String str = "abcdebbcde";
        Pattern pattern = Pattern.compile("a(?!b)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    private static void test4() {
        String str = "@wxj 你好啊";
        Pattern pattern = Pattern.compile("@(?<first>\\w+\\s)"); // 保存一个副本
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
            System.out.println(matcher.group("first"));
        }
    }

    private static void test5() {
        String str = "1990\n2010\n2017";
        // 这里应用了 (?m) 的多行匹配模式，只为方便我们测试输出
        // "^1990$|^199[1-9]$|^20[0-1][0-6]$|^2017$" 为判断 1990-2017 正确的正则表达式
        Pattern pattern = Pattern.compile("(?m)^1990$|^199[1-9]$|^20[0-1][0-6]$|^2017$");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    private static void test6() {
        String str = "<img  src='aaa.jpg' /><img src=bbb.png/><img src=\"ccc.png\"/>" +
                "<img src='ddd.exe'/><img src='eee.jpn'/>";
        // 这里我们考虑了一些不规范的 img 标签写法，比如：空格、引号
        Pattern pattern = Pattern.compile("<img\\s+src=(?:['\"])?(?<src>\\w+.(jpg|png))(?:['\"])?\\s*/>");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group("src"));
        }
    }

    private static void test7() {
        String str = "<div>文章标题</div><div>发布时间</div>";
        // 贪婪模式
        Pattern pattern = Pattern.compile("<div>(?<title>.+)</div>");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group("title"));
        }

        System.out.println("--------------");

        // 非贪婪模式
        pattern = Pattern.compile("<div>(?<title>.+?)</div>");
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group("title"));
        }
    }
}
