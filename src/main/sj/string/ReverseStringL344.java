package sj.string;

public class ReverseStringL344 {

    /**
     * 简单的反转字符串
     *
     * @param s
     */
    public void reverseStringL344(char[] s) {

        //TODO for循环的写法可以更加灵活一些。
        for (int left = 0, right = s.length - 1; left < s.length / 2; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }

    }

    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     * @param s
     * @param k
     */
    public String reverseStr(String s, int k) {

        if (k <= 1) return s;

        int n = s.length();
        char[] chars = s.toCharArray();

        for (int start = 0; start < n; start += 2 * k) {
            int end = Math.min(start + k - 1, n - 1);
            swap(chars, start, end);
        }

        return new String(chars);

    }

    private void swap(char[] s, int left, int right) {
        for (; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }


}
