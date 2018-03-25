package sj.array;

/**
 * Created by steven on 18-3-24 下午3:28
 * shijia0620@126.com
 *
 * 找出出现的次数超过数组长度的一半的数字，没有返回0
 */
public class N_MoreThanHalfNum_Solution {

    //打雷的思想，一样则加，不一样则减
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0) return 0;
        int winner = array[0];
        int count = 0;
        for(int i=1;i<array.length;i++){
            if(count == 0){
                winner = array[i];
                count++;
            }else if(array[i] == winner){
                    count++;
            }else {
                count--;
            }
        }
        // 判断是否为真的擂主
        count = 0;
        for(int i=0;i<array.length;i++){
            if(array[i] == winner)
                count++;
        }
        return count*2>array.length?winner:0;
    }
}
