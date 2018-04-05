package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by steven on 18-3-31 下午8:04
 * shijia0620@126.com
 */
public class Qihu360_boollean {
    public static void fun(){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for(int i=0; i<count; i++){
            long[] array = new long[3];
            for(int j=0; j<3; j++){
                array[j] = sc.nextLong();
            }
            Arrays.sort(array);
            if(array[0] + array[1] > array[2]/2){
                System.out.println((array[0]+array[2]+array[1])/3);
            }else {
                System.out.println(array[0]+array[1]);
            }
        }
    }

    public static void main(String[] args) {

    }
}
