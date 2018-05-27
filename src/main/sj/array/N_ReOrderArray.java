package sj.array;

import resources.Util;

/**
 * Created by steven on 18-3-23 下午7:24
 * shijia0620@126.com
 *
 * 所有的奇数在数组的前半部分，相对位置不变。
 */
public class N_ReOrderArray {
    //todo 采用插入排序的思路。
    public void reOrderArray(int [] array) {
        for(int i=1;i<array.length;i++){
            if(array[i]%2 == 1){
                int j = i-1;
                while(j>=0 && array[j]%2 == 0){
                    Util.swap(array,j,j+1);
                    j--;
                }
            }
        }
    }
}
