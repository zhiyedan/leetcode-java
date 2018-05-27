package sj.bit;

/**
 * Created by steven on 18-3-23 下午6:05
 * shijia0620@126.com
 * <p>
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {

    // todo 对于负数陷入死循环
    public int NumberOf11(int n) {
        int count = 0;
        while(n!=0){
            if((n & 1) == 1)
                count++;
            n = n>>1;
        }
        return count;
    }

    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0){
            count ++;
            n = n & (n-1);
        }
        return count;
    }
}
