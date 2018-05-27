package newcoder;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by steven on 18-3-29 下午4:07
 * shijia0620@126.com
 *
 *
 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 不能使用除法。
 */
public class N_multiply {

    public int[] multiply(int[] A) {
        int[] b = new int[A.length];
        int curResult = 1;
        //todo i++ 放在b的位置上会出错？为什么？
        for(int i=0; i<A.length; curResult*=A[i++]){
            b[i] = curResult;
        }
        curResult = 1;
        for(int j = A.length-1; j>=0; curResult*=A[j--]){
            b[j] *= curResult;
        }
        return b;
    }

    public static void main(String[] args) {

        LinkedList<Character> list = new LinkedList<>();
        list.add('a');
        list.add('b');
        list.add('a');
        list.add('c');
        list.remove(list.indexOf('a'));

        System.out.println(Arrays.toString(list.toArray()));
    }
}
