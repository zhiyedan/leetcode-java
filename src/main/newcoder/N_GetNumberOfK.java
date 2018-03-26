package newcoder;

import sj.search.Search;

/**
 * Created by steven on 18-3-26 下午11:23
 * shijia0620@126.com
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class N_GetNumberOfK {
    int count=0;
    public int GetNumberOfK(int [] array , int k) {
        count = 0;
        fun(array,k,0,array.length-1);
        return count;
    }
    public void fun(int[] array, int k, int begin, int end){
        if(begin>end) return;
        int mid = (begin+end)>>1;
        if(array[mid] == k){
            count++;
            fun(array,k,begin,mid-1);
            fun(array,k,mid+1,end);
        }else if(array[mid] > k){
            fun(array,k,begin,mid-1);
        }else{
            fun(array,k,mid+1,end);
        }
    }

    //todo 另外一种思路：求第一个出现的未知和最后一个出现的位置
    //todo 求应该出现的位置，也就是第一个位置
    public static int getFirstIndex(int[] array, int k){
        int begin = 0;
        //todo end需要越界。。。。。
        int end = array.length;
        while (begin<end) {
            int mid = (begin + end)>>1;
            if(array[mid]<k){
                begin = mid+1;
            }else {
                end = mid;
            }
        }
        return begin;
    }
    //todo 最后一个位置,不能找到应该的位置
    public static int getEndIndex(int[] array, int k){
        int begin = -1;
        int end = array.length-1;
        while (begin<end){
            int mid = (begin+end+1)>>1;
            if(array[mid] > k){
                end = mid-1;
            }else {
                begin = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println(getEndIndex(new int[]{1, 2, 2, 2, 3}, 2));
    }
}
