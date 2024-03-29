package sj.stack2queue;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class IsValidBracketL20 {
    public static boolean isValid(String s) {

        // TODO character 拼写错误
        Stack<Character> stack = new Stack();

        for (char ch : s.toCharArray()) {
            if ( ch =='(' || ch =='{' || ch =='['){
                stack.push(ch);
            }else{
                if (stack.isEmpty()) {
                    return false;
                }
                String combine = new String(new char[]{stack.pop(), ch});
                // TODO 字符串比较还是得用equals，用等于可能会出现问题
                if (!combine.equals("{}") && !combine.equals("[]") && !combine.equals("()")) {
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
