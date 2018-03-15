package interview;

import resources.MyUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by steven on 18-3-15 下午8:54
 * shijia0620@126.com
 */
public class Shuffle {
    public void shuffle(int[] nums){
        if(nums.length <=1) return;
        Random random = new Random();
        for(int i=0; i< nums.length-1;i++){
            int swapIndex = random.nextInt(nums.length-i-1)+i+1;
            MyUtil.swap(nums,i,swapIndex);
        }
    }

    public static void main(String[] args) {
        Shuffle a = new Shuffle();
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        a.shuffle(array);
        System.out.println(Arrays.toString(array));
    }
}
