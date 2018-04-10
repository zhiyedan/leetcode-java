package interview;

import java.util.Scanner;

/**
 * Created by steven on 18-4-9 下午8:58
 * shijia0620@126.com
 */
public class JingDong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        long[] arr = new long[count];
        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextLong();
        }
        for (int i = 0; i < count; i++) {
            //
            if ((arr[i] & 0x01) > 0) {
                System.out.println("No");
            } else {
                long y = 2;
                long x = arr[i] >> 1;
                while ((x & 0x01) == 0) {
                    y = y << 1;
                    x = x >> 1;
                }
                System.out.println(x + " " + y);
            }
        }
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int len = string.length();
        char[] chars = string.toCharArray();
        long[][] dp = new long[len][len];
        for(int j=0;j<len;j++){
            dp[j][j]=1;
            for(int i=j-1;i>=0;i--){
                dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                if(chars[i]==chars[j]) {
                    dp[i][j]+=1+dp[i+1][j-1];
                }
            }
        }
        System.out.println(dp[0][len-1]);
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kNum = scanner.nextInt();
        int xNum = scanner.nextInt();
        int yNum = scanner.nextInt();
        long[][][] helpArr = new long[9][9][100001];
        int[] arrX = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        int[] arrY = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
        int newX = 0;
        int newY = 0;
        helpArr[0][0][0] = 1;
        for (int z = 1; z <= kNum; z++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    helpArr[i][j][z] = 0;
                    for (int l = 0; l < 8; l++) {
                        newX = i + arrX[l];
                        newY = j + arrY[l];
                        if (newX < 0 || newY < 0 || newX > 8 || newY > 8) {
                            continue;
                        }
                        helpArr[i][j][z] += (helpArr[newX][newY][z - 1] % 1000000007);
                    }
                }
            }
        }
        System.out.println(helpArr[xNum][yNum][kNum] % 1000000007);
    }
}
