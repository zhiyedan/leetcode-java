package sj.string;

import java.util.LinkedHashMap;

/**
 * Created by steven on 18-3-25 下午11:50
 * shijia0620@126.com
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class N_FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if(str==null || str.length()==0) return -1;
        // 存放字符和对应的下标
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        int[] countArray = new int[str.length()];
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int index=i;
            if(map.containsKey(ch)){
                index = map.get(ch);
            }else {
                map.put(ch,i);
            }
            countArray[index]++;
        }
        int i=0;
        for(;i<str.length();i++){
            if(countArray[i] == 1)
                break;
        }
        return i;
    }
}
