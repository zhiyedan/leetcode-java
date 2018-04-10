package sj.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steven on 18-4-10 下午11:34
 * shijia0620@126.com
 * <p>
 * 3个括号的所有可能
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class L22_generateParenthesis {


    public List<String> generateParenthesis1(int n) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> curList = new ArrayList<>();
        curList.add("");
        backtrack1(n, curList, res);
        return res;
    }

    //todo 错误：只考虑往外边/左边右边加，n==4,则(())(())就会被漏掉
    private void backtrack1(int n, List<String> list, List<String> res) {
        if (n == 0) {
            for (String s : list) {
                res.add(s);
            }
            return;
        }
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            String sOut = "(" + s + ")";
            String sLeft = "()" + s;
            String sRight = s + "()";
            if (!newList.contains(sOut)) newList.add(sOut);
            if (!newList.contains(sLeft)) newList.add(sLeft);
            if (!newList.contains(sRight)) newList.add(sRight);
        }
        backtrack1(n - 1, newList, res);
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generateOneByOne("", list, n, n);
        return list;
    }

    public void generateOneByOne(String sublist, List<String> list, int left, int right) {
        if (left > right) return;
        if (left > 0)
            generateOneByOne(sublist + "(", list, left - 1, right);
        if (right > 0)
            generateOneByOne(sublist + ")", list, left, right - 1);
        if (left == 0 && right == 0) {
            list.add(sublist);
            return;
        }
    }

    public static void main(String[] args) {
        L22_generateParenthesis a = new L22_generateParenthesis();
        List<String> res = a.generateParenthesis(3);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
