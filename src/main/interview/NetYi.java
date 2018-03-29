package interview;

import java.util.Scanner;

/**
 * Created by steven on 18-3-27 下午8:34
 * shijia0620@126.com
 */
public class NetYi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        for(int x=k;x<=n;x++){
            for(int y=k;y<=n;y++){
                if(x%y>=k){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
