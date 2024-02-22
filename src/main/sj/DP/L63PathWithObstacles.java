package sj.DP;

public class L63PathWithObstacles {

    /**
     * 常规做法
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    //TODO 这里第一次写错了，写成了break；
                    dp[i][j] = 0;
                }
            }
        }

        return dp[row - 1][col - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int dp[] = new int[col];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[col-1];
    }
}
