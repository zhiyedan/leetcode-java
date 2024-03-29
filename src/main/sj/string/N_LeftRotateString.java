package sj.string;

/**
 * Created by steven on 18-3-27 下午4:12
 * shijia0620@126.com
 * 左旋字符串  abcdef 左旋两个为 cdefab
 */
public class N_LeftRotateString {

    //todo 字符串问题，很多可以用原始字符串拼接的方法处理
    public static String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n < 0) return "";
        String string = str.concat(str);
        //todo 还是有问题，如有n>str.length的话会出现数组越界的问题
        n = n % str.length();
        return string.substring(n, n + str.length());
    }

    public static String rightRotateString(String str, int n) {

        if (str == null || str.length() == 0 || n < 0) return "";

        String string = str.concat(str);

        //todo 还是有问题，如有n>str.length的话会出现数组越界的问题
        n = n % str.length();
        return string.substring( str.length() - n, string.length() - n);
    }


    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcdefg", 2));
        System.out.println(rightRotateString("abcdefg", 2));

    }
}
