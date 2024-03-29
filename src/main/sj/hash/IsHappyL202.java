package sj.hash;

import java.util.*;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 */
public class IsHappyL202 {
    public static boolean isHappy(int n) {

        HashSet<Integer> hashSet = new HashSet<>();

        int curNum = n;

        while (curNum != 1) {
            curNum = getSum(curNum);
            if (hashSet.contains(curNum)) {
                return false;
            } else {
                hashSet.add(curNum);
            }
        }

        return true;

    }

    /**
     * 简洁版本，思路是不能for循环，因为如果不是快乐数会无限死循环，所以得知道是否已经遍历过该数字了
     * @param n
     * @return
     */
    public static boolean isHappyNew(int n) {

        HashSet<Integer> hashSet = new HashSet<>();
        while (n != 1 && !hashSet.contains(n)) {
            n = getSum(n);
            hashSet.add(n);
        }

        return n == 1;
    }


    public static int getSum(int n) {

        int sum = 0;

        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }

        return sum;
    }

}
