package interview;

import java.util.Scanner;

/**
 * Created by steven on 18-4-8 下午8:09
 * shijia0620@126.com
 */
public class Lianjia {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num<=3)
            System.out.println(0);
        else{
            int a = 1;
            int b = 2;
            int count = 2;
            while(b<num){
                int temp = b;
                b = a+b;
                a = temp;
                if(b<=num)count ++;
            }
            System.out.println(num-count);
        }
    }
}
