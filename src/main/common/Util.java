package common;

/**
 * Created by steven on 18-3-1 下午8:31
 * shijia0620@126.com
 */
public class Util {
    public static void swap(int[] array, int index1 ,int index2){
        if(array.length<2 ) return;
        if(index1<0 || index2<0 || index1>=array.length || index2>=array.length){
            System.out.println("out of index");
            return;
        }
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
