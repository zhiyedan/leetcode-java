package sj.search;

/**
 * Created by steven on 18-3-7 下午8:59
 * shijia0620@126.com
 * 二维矩阵寻找
 */
public class Mysearch {

    //TODO 将matrix视为一维数组
    public int[] matrixSearch(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        int begin = 0;
        int end = row*col;
        while (begin<end){
            int mid = (begin+end)>>1;
            int val = matrix[mid/col][mid%col];
            if(val < target) begin = mid+1;
            else end = mid;
        }
        return new int[]{begin/col,begin%col};
    }

    public int[] matrixSearch2(int[][] matrix, int target){
        // TODO 二维数组取一列
        int[] firstColunm = new int[matrix.length];
        for(int i=0;i<matrix.length;i++){
            firstColunm[i] = matrix[i][0];
        }
        int row = binSearch(firstColunm,target);
        row = (row == 0)?0:row-1;
//        if(matrix[row][0] == target) return new int[]{row,0};

        int[] secondRow = new int[matrix[0].length];
        for(int i=0; i< secondRow.length;i++){
            secondRow[i] = matrix[row][i];
        }
        int col = binSearch(secondRow,target);
        if(matrix[row][col] == target) return new int[]{row,col};
        return new int[]{-1,-1};
    }

    public int binSearch(int[] array, int target){
        int low = 0;
        int high = array.length;
        while (low < high){
            int mid = (low + high) >> 1;
            if(array[mid] < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
