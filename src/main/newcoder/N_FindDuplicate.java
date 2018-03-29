package newcoder;

import resources.Util;

/**
 * Created by steven on 18-3-29 下午3:43
 * shijia0620@126.com
 *
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 通过O(n)的时间复杂度,O(1)空间复杂度找到第一个重复的数字。
 */
public class N_FindDuplicate {
    // todo 很强的个性：所有数字都在0-n-1之间，明显的暗示用下标。
    public static int findDuplicate(int[] array){
        int i = 0;
        while (i<array.length){
            if(i == array[i]){
                i++;
                continue;
            }
            int num = array[i];
            if(array[num] == num){
                return num;
            }else {
                Util.swap(array,i,num);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{3,1,1,5,0,4}));
    }
}
