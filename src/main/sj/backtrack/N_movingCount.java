package sj.backtrack;

/**
 * Created by steven on 18-4-1 下午12:28
 * shijia0620@126.com
 * <p>
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 */
public class N_movingCount {
    int max = 0;

    public int movingCount(int threshold, int rows, int cols) {
        max = 0;
        boolean[][] matrix = getMatrix(threshold, rows, cols);
        backtrack(matrix, 0, 0, 0);
        return max;
    }

    public void backtrack(boolean[][] matrix, int row, int col, int count) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || !matrix[row][col]) return;
        max = Math.max(count + 1, max);
        matrix[row][col] = false;
        backtrack(matrix, row + 1, col, count + 1);
        backtrack(matrix, row - 1, col, count + 1);
        backtrack(matrix, row, col + 1, count + 1);
        backtrack(matrix, row, col - 1, count + 1);
        matrix[row][col] = true;
    }

    public static void main(String[] args) {
        N_movingCount a = new N_movingCount();
        System.out.println(a.movingCount(5,10,10));
    }

    private boolean[][] getMatrix(int threshold, int rows, int cols) {
        boolean[][] matrix = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = getSum(i) + getSum(j) <= threshold;
            }
        }
        return matrix;
    }

    private int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
