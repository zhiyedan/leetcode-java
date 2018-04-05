package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by steven on 18-3-31 下午7:02
 * shijia0620@126.com
 */
public class Inter360 {
    public static void fun1(){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for(int i=0; i<count; i++){
            int nodeCount = sc.nextInt();
            for(int j=0; j<nodeCount; j++){

            }
        }
    }
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        List<List<int[]>> lists = new ArrayList<>();
        for (int i = 0; i < count; i++){
            int nodeCount = sc.nextInt();
            List<int[]> nums = new ArrayList<>();
            for (int j = 0; j < nodeCount; j++){
                int[] rectangle = new int[4];
                for (int k = 0; k < 4; k++){
                    rectangle[k] = sc.nextInt();
                }
                nums.add(rectangle);
            }
            lists.add(nums);
        }
        for (List<int[]> list : lists){
            area1(list);
        }
    }
    private static void area1(List<int[]> nums){
        long result = 0;
        for (int[] xy : nums){
            result += Math.abs(xy[2] - xy[0] + 1) * Math.abs(xy[3] - xy[1] + 1);
        }
        System.out.println(result);
    }
}
