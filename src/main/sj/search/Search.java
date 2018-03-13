package sj.search;

/**
 * Created by steven on 18-3-7 下午6:37
 * shijia0620@126.com
 */
public class Search {
    //二分查找
    public int binSearch(int[] array,int target){
        return binFun(array,target,0,array.length-1);
    }
    public int binFun(int[] array, int target , int begin, int end){
        if(begin>end) return -1;
        int mid = (begin+end)>>1;
        if(array[mid] == target) return mid;
        if(array[mid] < target) return binFun(array,target,mid+1,end);
        else return binFun(array,target,begin,mid-1);
    }
    //TODO 非递归，如果没有，返回应该有的位置，相当于找起点
    public int unRecursive(int[] array, int target){
        int low = 0;
        //TODO 注意high本身靠右，所以mid也是偏右的。
        int high = array.length;
        //TODO 没有==的坏处是可能多出log(n)次查找。。。。
        while (low<high){
            int mid = (low+high)>>1;
            if(array[mid] < target)
                //low会出边界
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }

    //相当于找起点
    public int unRecursive1(int[] array, int target){
        int low = 0;
        int high = array.length;
        while (low<high){
            int mid = (low+high)>>1;
            if(array[mid] < target)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        Search s = new Search();
        System.out.println(s.binSearch(new int[]{1,2,3,5,6,7},3));
    }
}
