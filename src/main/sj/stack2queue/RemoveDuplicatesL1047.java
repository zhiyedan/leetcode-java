package sj.stack2queue;

import java.util.*;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */
public class RemoveDuplicatesL1047 {
    public String removeDuplicates(String s) {

        String result = "";

        Stack<Character> stack = new Stack();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }

        // TODO 字符串拼接的方法：
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }

    /**
     * 双指针的思路，很酷炫，有点难。
     *
     * @param s
     * @return
     */
    public String removeDuplicatesDoublePointer(String s) {
        char[] ch = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while (fast < s.length()) {
            // 直接用fast指针覆盖slow指针的值
            ch[slow] = ch[fast];
            // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
            if (slow > 0 && ch[slow] == ch[slow - 1]) {
                slow--;
            } else {
                slow++;
            }
            fast++;
        }
        return new String(ch, 0, slow);
    }
}
