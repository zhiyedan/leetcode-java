package interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by steven on 18-3-27 下午9:25
 * shijia0620@126.com
 */
public class NetYi_1 {

    static int[] x1;
    static int[] y1;
    static int[] x2;
    static int[] y2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        x1 = new int[num];
        y1 = new int[num];
        x2 = new int[num];
        y2 = new int[num];
        for (int i = 0; i < num; i++) {
            x1[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            y1[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            x2[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            y2[i] = sc.nextInt();
        }
        int[] res = new int[num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (i == j) {
                    continue;
                }
                boolean flag = isLaped(x1[i], y1[i], x2[i], y2[i], x1[j], y1[j], x2[j], y2[j]);
                if (!flag) {
                    res[i]++;
                }
            }
        }
        Arrays.sort(res);
        System.out.println(res[num - 1] + 1);
    }

    public static boolean isLaped(int x1, int y1, int x2, int y2, int x_1, int y_1, int x_2, int y_2) {
        if (y2 > y_1 && y1 < y_2 && x2 > x_1 && x1 < x_2) {
            return false;
        }
        return true;
    }

}
