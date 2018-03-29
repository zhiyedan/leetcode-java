package sj.string;

/**
 * Created by steven on 18-3-29 下午4:45
 * shijia0620@126.com
 * <p>
 * 字符串匹配问题，只包含 "." 和 "*" 两种匹配符
 */
public class N_RegrexPatternMatch {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        return isMatch(str, pattern, 0, 0);
    }

    public boolean isMatch(char[] str, char[] pattern, int index1, int index2) {
        if (index1 == str.length && index2 == pattern.length)
            return true;
        if (index1 != str.length && index2 == pattern.length)
            return false;
        // to judge the pattern's next char is '*' or not
        if (index2 + 1 < pattern.length && pattern[index2 + 1] == '*') {
            // TODO:java array 时候都要在用之间判断是否数组越界！！！
            // match
            if (index1 != str.length && (str[index1] == pattern[index2] || pattern[index2] == '.')) {
                return (isMatch(str, pattern, index1, index2 + 2) //todo 0个匹配
                        || isMatch(str, pattern, index1 + 1, index2)  //todo 多个匹配
                        || isMatch(str, pattern, index1 + 1, index2 + 2)); //todo 1个匹配
            }
            // not match
            else {
                return isMatch(str, pattern, index1, index2 + 2);
            }

        } else {
            if (index1 < str.length && (str[index1] == pattern[index2] || pattern[index2] == '.'))
                return isMatch(str, pattern, index1 + 1, index2 + 1);
            return false;
        }
    }

}
