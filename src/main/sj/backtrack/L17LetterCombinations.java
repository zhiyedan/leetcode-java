package sj.backtrack;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class L17LetterCombinations {

    String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        List<Charater> stack = new LinkedList<>();
        fun(digits, 0, stack);
        return res;

    }

    void fun(String digits, int startIndex, List<Charater> stack) {

        if (startIndex == digits.length() - 1) {
            String path = stack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            res.add(path);
        }

        String[] arr = dict[Integer.valueOf(digits.charAt(startIndex))]
        for (int i = 0; i < arr.length; i++) {
            stack.add(arr[i]);
            fun(digits, startIndex + 1, stack);
            stack.pop();
        }

    }


}
