package sj.DP;

/**
 * Created by steven on 18-4-1 下午4:22
 * shijia0620@126.com
 *
 * 每次只能复制当前所有的字符，粘贴复制板上的内容，起始状态为一个‘A’，求生成n个A至少需要多少步。
 */
public class L650keyBoard {
    public int minStep(int n){
        if(n==1) return 0;
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++) dp[i] = i;
        for(int i=3; i<=n; i++){
            // todo 找最大公因子
            for(int j=i>>1; j>0; j--){
                if(i % j == 0){
                    dp[i] = dp[j] + i/j;
                    break;
                }
            }
        }
        return dp[n];
    }
}
