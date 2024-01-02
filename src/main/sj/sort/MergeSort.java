package sj.sort;

import java.util.Arrays;

/**
 * Created by steven on 18-2-25 下午7:36
 * shijia0620@126.com
 */
public class MergeSort {
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

    //两路归并算法，两个排好序的子序列合并为一个子序列
    public void merge2(int []a,int left,int mid,int right){
        int []tmp=new int[a.length];//辅助数组
        int p1=left,p2=mid+1,k=left;//p1、p2是检测指针，k是存放指针
        while(p1<=mid && p2<=right){
            if(a[p1]<=a[p2])
                tmp[k++]=a[p1++];
            else
                tmp[k++]=a[p2++];
        }

        while(p1<=mid) tmp[k++]=a[p1++];//如果第一个序列未检测完，直接将后面所有元素加到合并的序列中
        while(p2<=right) tmp[k++]=a[p2++];//同上

        //复制回原素组
        for (int i = left; i <=right; i++)
            a[i]=tmp[i];
    }

    public void mergeSort2(int [] a,int start,int end){
        if(start<end){//当子序列中只有一个元素时结束递归
            int mid=(start+end)/2;//划分子序列
            mergeSort2(a, start, mid);//对左侧子序列进行递归排序
            mergeSort2(a, mid+1, end);//对右侧子序列进行递归排序
            merge(a, start, mid, end);//合并
        }
    }


    public static void main(String[] args) {
        MergeSort a = new MergeSort();
        int[] array = new int[]{1,5,3,2,5,10,9};
        a.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
