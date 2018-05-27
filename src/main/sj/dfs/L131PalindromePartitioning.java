package sj.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steven on 18-5-27 下午4:35
 * shijia0620@126.com
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 */
public class L131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, path, s, result);
        return result;
    }

//  保证前面的substring是回文
    private void dfs(int startIndex, List<String> path, String s, List<List<String>> result) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i= startIndex; i<s.length(); i++){
            String subString = s.substring(startIndex,i+1);
            if(!isPalindrome(subString)) continue;
            path.add(subString);
            dfs(i+1,path,s, result);
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String subString) {
        for(int i=0,j=subString.length()-1;i<j;i++,j--){
            if(subString.charAt(i) != subString.charAt(j)) return false;
        }
        return true;
    }

}
