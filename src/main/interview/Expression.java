package interview;

import java.util.Stack;

/**
 * Created by steven on 18-3-16 下午3:01
 * shijia0620@126.com
 * 计算表达式的前缀中缀以及后缀 (3 + 4) × 5 - 6 就是中缀表达式
 */
public class Expression {
    //输入已经是一个可以方便计算的前缀表达式，求计算结果- × + 3 4 5 6
    public int formorExpression(String string) {
        // 将string转化为array
        char[] chars = string.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = string.length() - 1; i >= 0; i--) {
            char ch = chars[i];
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(calculate(a, b, ch));
            }
        }
        return stack.peek();
    }

    /*
    中缀表达式转后缀表达式的方法：
    1.遇到操作数：直接输出（添加到后缀表达式中）
    2.栈为空时，遇到运算符，直接入栈
    3.遇到左括号：将其入栈
    4.遇到右括号：执行出栈操作，并将出栈的元素输出，直到弹出栈的是左括号，括号不输出。
    5.遇到其他运算符：加减乘除：弹出所有优先级大于或者等于该运算符的栈顶元素，然后将该运算符入栈
    6.最终将栈中的元素依次出栈，输出。
     */
    public String transToFormer(String string) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = string.toCharArray();
        String operators = "*/+-";
        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
            } else if (stack.isEmpty() || ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                // 输出左括号
                stack.pop();
            } else {
                while (!stack.isEmpty() && stack.peek()!='(' && operators.indexOf(ch) >= operators.indexOf(stack.peek())){
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();

    }


    //3 4 + 5 × 6 - 后缀表达式
    public int postExpression(String string) {
        char[] chars = string.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = chars[i];
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(calculate(a, b, ch));
            }
        }
        return stack.peek();
    }


    int calculate(int a, int b, char ch) {
        switch (ch) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        String former = "-*+3456";
        String post = "34+5*6-";
        String mid = "(3+4)*5-6";
        Expression e = new Expression();
        System.out.println(e.transToFormer(mid));
//        System.out.println(e.postExpression(post));
    }
}
