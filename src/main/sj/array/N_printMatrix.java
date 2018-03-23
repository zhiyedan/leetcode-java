package sj.array;

import java.util.ArrayList;

/**
 * Created by steven on 18-3-23 下午9:10
 * shijia0620@126.com
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
public class N_printMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int rowLeft=0, rowRight = matrix.length-1;
        int colLeft=0, colRight = matrix[0].length-1;
        while (rowLeft<= rowRight && colLeft <= colRight){
            for(int j = colLeft;j<=colRight;j++){
                list.add(matrix[rowLeft][j]);
            }
            rowLeft++;
            if(colLeft>colRight) break;
            for(int i = rowLeft;i<=rowRight;i++){
                list.add(matrix[i][colRight]);
            }
            colRight--;
            //todo point!!!
            if(rowLeft>rowRight) break;
            for(int j = colRight;j>=colLeft;j--){
                list.add(matrix[rowRight][j]);
            }
            rowRight--;
            if(colLeft>colRight) break;
            for(int i = rowRight;i>= rowLeft; i--){
                list.add(matrix[i][colLeft]);
            }
            colLeft++;
        }
        return list;
    }

    public static void main(String[] args) {
//        int [][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int [][] matrix = new int[][]{{1,2,3},{5,6,7},{9,10,11},{13,14,15}};
        System.out.println(printMatrix(matrix).toString());
    }
}
