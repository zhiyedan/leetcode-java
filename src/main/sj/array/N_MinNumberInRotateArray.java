package sj.array;

/**
 * Created by steven on 18-3-23 下午5:04
 * shijia0620@126.com
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 */
public class N_MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0) return 0;
        int left = 0;int right = array.length-1;
        while(left<right){
            //todo mid = left+(right-left)>>1 陷入死循环。。。。
            int mid = (right+left)>>1;
            if(array[mid]> array[left]){
                left = mid;
            }else if(array[mid] < array[left]){
                right = mid;
            }else
                left = mid+1;
        }
        return array[left];
    }
}
