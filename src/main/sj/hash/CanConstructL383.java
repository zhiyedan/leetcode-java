package sj.hash;
import java.util.*;

public class CanConstructL383 {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char curChar = magazine.charAt(i);
            map.put(curChar, map.getOrDefault(curChar, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char curChar = ransomNote.charAt(i);
            int count = map.getOrDefault(curChar, 0);
            if (count == 0) {
                return false;
            } else {
                map.put(curChar, count - 1);
            }
        }

        return true;
    }

    /**
     * 简化版：使用int数组；遍历string的方式使用api
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstructNew(String ransomNote, String magazine) {

        int[] map = new int[26];

        for (char c : magazine.toCharArray()) {
            map[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            map[c - 'a']--;
            if (map[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
