package newcoder;

/**
 * Created by steven on 18-3-26 下午8:58
 * shijia0620@126.com
 *
 * 求数组中的逆序对
 */
public class N_InversePairs {
    int count = 0;
    public int InversePairs(int [] array) {
        count = 0;
        partation(array,0,array.length-1);
        return count;
    }
    public void partation(int[] array, int begin, int end){
        if(begin>=end) return;
        int mid = (begin + end)>>1;
        partation(array,begin,mid);
        partation(array,mid+1,end);
        merge(array,begin,mid,end);
    }
    public void merge(int[] array,int begin, int mid,int end){
        int[] newArray = new int[end-begin+1];
        int i=begin,j = mid+1,k=0;
        while (i<=mid && j<=end){
            if(array[j]<array[i]){
                newArray[k++] = array[j++];
                count += mid - i + 1;
            }else {
                newArray[k++] = array[i++];
            }
        }
        while (i<=mid)
            newArray[count++] = array[i++];
        while (j<=end)
            newArray[count++] = array[j++];
        for(i=begin;i<=end;i++){
            array[i] = newArray[i-begin];
        }
    }

    public static void main(String[] args) {
        N_InversePairs a = new N_InversePairs();
        System.out.println(a.InversePairs(new int[]{7,5,6,4}));
    }
}
