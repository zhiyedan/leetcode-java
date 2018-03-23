package sj.string;

/**
 * Created by steven on 18-3-20 下午8:24
 * shijia0620@126.com
 */
public class Kmp {
    // 建立next数组,每个元素表示最长前后缀相同字符字串长度,前缀最后一个元素不能是后缀的最后一个元素
    // "ababcababa" 看最后一个a
    // todo 每一个串的两端都有相同的字串！！！
    public static int[] genNextArray(char[] chars) {
        int[] nextArray = new int[chars.length];
        nextArray[0] = 0;
        //TODO k:最长前缀长度，同时也是最长前缀的下一个字符的下标
        int k = 0;
        for (int i = 1; i < nextArray.length; i++) {
            k = nextArray[i - 1];
            while (k > 0 && chars[k] != chars[i]) {
                k = nextArray[k-1];
            }
            if (chars[k] == chars[i])
                nextArray[i] = k + 1;
            else
                nextArray[i] = 0;
        }
        return nextArray;
    }

    public static int kmp(String s1, String pattern){
        char[] ss1 = s1.toCharArray();
        char[] ss2 = pattern.toCharArray();
        int[] next = genNextArray(pattern.toCharArray());
        int i=0,j=0;
        while (i<s1.length() && j<pattern.length()){
            if(ss1[i] == ss2[j]){
                j++;
                i++;
            }else if(j == 0) {
                i++;
            }else{
                j = next[j-1];
            }
        }
        if(j>=pattern.length())
            return i-pattern.length();
        return -10;
    }

    public static int bluce(String s1, String s2){
        int start=0;
        while (start<s1.length()){
            int i=0;
            while (i<s2.length()){
                if(s1.charAt(i+start) != s2.charAt(i))
                    break;
                i++;
            }
            if(i == s2.length())
                return start;
            start++;
        }
        return -10;
    }

    public static void main(String[] args) {
        String a = "abcaaccab";
        String b = "acca";
        System.out.println(kmp(a,b));
        System.out.println(bluce(a,b));
    }
}
