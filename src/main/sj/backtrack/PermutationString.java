package sj.backtrack;

import java.util.*;

/**
 * Created by steven on 18-3-24 上午11:51
 * shijia0620@126.com
 */
public class PermutationString {

    public ArrayList<String> Permutation(String str) {

        ArrayList<String> result = new ArrayList<>();
        if(str == null) return result;
        boolean[] flags = new boolean[str.length()];
        StringBuffer sb = new StringBuffer();
        backtrack(str.toCharArray(),result,sb,flags);
        return result;
    }
    public void backtrack(char[] chars,ArrayList<String> result,StringBuffer sb,boolean[] flags){
        if(sb.length() == chars.length){
            result.add(sb.toString());
            return;
        }
        for(int i=0;i<chars.length;i++){
            if(flags[i]) continue;
            sb.append(chars[i]);
            flags[i] = true;
            backtrack(chars,result,sb,flags);
            flags[i] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        PermutationString a = new PermutationString();
//        char[] chars = "bca".toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push('s');
        stack.push('b');
        String str = stack.toString();
        System.out.println(str);
        StringBuilder sb = new StringBuilder("asb");
        sb.append("44");
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
