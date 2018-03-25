package newcoder;

import java.util.HashMap;

/**
 * Created by steven on 18-3-25 下午8:37
 * shijia0620@126.com
 *
 * 丑数： 只能被2,3,5整除的数字
 */
public class UglyNum {
    //判断是否为丑数
    public static boolean isUglyNum(int num){
        while (num % 2 == 0)
            num /= 2;
        while (num % 3 == 0)
            num /= 3;
        while (num % 5 == 0)
            num /= 5;
        return num == 1?true:false;
    }

    // 获取第n个丑数 暴力解法
    public static int getUglyNum(int n){
        int num = 1;
        int count = 1;
        while (count<n){
            if(isUglyNum(++num))
                count++;
        }
        return num;
    }

    // todo dp方法，新的丑数一定是之前的数字乘以2/3/5得到的数字
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2=0,index3=0,index5=0;
        for(int i=1;i<n;i++){
            int minNum = Math.min(Math.min(dp[index2]*2,dp[index3]*3),dp[index5]*5);
            if(minNum == dp[index2]*2) index2++;
            if(minNum == dp[index3]*3) index3++;
            if(minNum == dp[index5]*5) index5++;
            dp[i] = minNum;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        return dp[n-1];
    }

    public static void main(String[] args) {
        for(int i=1;i<20;i++){
            if(isUglyNum(i))
                System.out.print(i+"\t");
        }
        System.out.println("\n"+getUglyNum(10));
        System.out.println(nthUglyNumber(10));
    }
}
