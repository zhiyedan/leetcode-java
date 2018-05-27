package interview;

/**
 * Created by steven on 18-3-28 下午7:40
 * shijia0620@126.com
 *
 * 打印等腰三角形
 */
public class NetYiGame {
    public static void fun(int n){
        int start = n-1;
        int end = n-1;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<=end; j++){
                if(j != start && j!= end){
                    System.out.print(".");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
            start--;
            end++;
        }
        for(int i=0;i<=end;i++){
            System.out.print("*");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        fun(5);
    }
}
