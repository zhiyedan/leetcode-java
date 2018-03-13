package sj.sort;

import java.util.Arrays;

/**
 * Created by steven on 18-2-25 下午7:36
 * shijia0620@126.com
 */
public class Sort {
    //插入排序
    public void insertSort(int[] array){
        for(int i=1; i<array.length;i++){
            int temp = array[i];
            int j = i-1;
            while (j>=0 && array[j]>temp){
                array[j+1] = array[j--];
            }
            array[j+1] = temp;
        }
    }

    //归并排序
    public void mergeSort(int[] array){
        partition(array,0,array.length-1);
    }
    public void partition(int[] array, int begin ,int end){
        //TODO 这里应该为>= 而不是=
        if(begin>=end) return;
        int mid = (begin+end)>>1;
        partition(array,begin,mid);
        partition(array,mid+1,end);
        merge(array,begin,mid,end);
    }

    //TODO new 一个新的数组,merge之后再复制过去
    private void merge(int[] array, int begin, int mid, int end) {
        int[] newArray = new int[end-begin+1];
        int newIndex = 0;
        int leftIndex = begin;
        int rightIndex = mid+1;
        while (leftIndex<=mid && rightIndex<=end){
            newArray[newIndex++] = array[leftIndex]<array[rightIndex]?array[leftIndex++]:array[rightIndex++];
        }
        while (leftIndex<=mid){
            newArray[newIndex++] = array[leftIndex++];
        }
        while (rightIndex <= end){
            newArray[newIndex++] = array[rightIndex++];
        }
        for(int i=begin; i<=end;i++){
            array[i] = newArray[i-begin];
        }
    }


    public static void main(String[] args) {
        Sort a = new Sort();
        int[] array = new int[]{1,5,3,2,5,10,9};
        a.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
