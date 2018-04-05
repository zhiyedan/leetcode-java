package sj.DP;

/**
 * Created by steven on 18-4-3 下午7:47
 * shijia0620@126.com
 * 股票问题，最多交易一次
 */
public class L121_stockSell {
    public static int maxProfit(int[] prices){
        if(prices.length<1) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i<prices.length; i++){
            maxProfit = Math.max(maxProfit,prices[i]-minPrice);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return maxProfit;
    }

    // todo 二分法 时间复杂度O(nlogn)
    public int maxProfit2(int[] prices){
        maxfit = 0;
        if(prices.length<1) return 0;
        recursive(prices,0,prices.length-1);
        return maxfit;
    }
    private int maxfit=0;
    public void recursive(int[] prices, int left, int right){
        if(left>=right) return;
        int mid = (left+right)>>1;
        maxfit = Math.max(maxfit,findMax(prices,mid+1,right)-findMin(prices,left,mid));
        recursive(prices,left,mid);
        recursive(prices,mid+1,right);
    }
    private int findMax(int[] prices, int left, int right){
        int max=prices[left];
        for(int i=left+1; i<=right; i++){
            max = Math.max(max,prices[i]);
        }
        return max;
    }
    private int findMin(int[] prices, int left, int right){
        int min=prices[left];
        for(int i=left+1; i<=right; i++){
            min = Math.min(min,prices[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,4,2,6}));
        L121_stockSell a = new L121_stockSell();
        System.out.println(a.maxProfit2(new int[]{7,1,4,2,6}));
    }
}
