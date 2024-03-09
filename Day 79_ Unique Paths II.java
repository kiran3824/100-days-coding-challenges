class Solution {
    int paths = 0;
    int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return dfs(obstacleGrid, 0, 0);
    }

    int dfs(int[][] obstacleGrid, int row, int col) {
        if (row < 0 || col < 0 || row == obstacleGrid.length || col == obstacleGrid[0].length
                || obstacleGrid[row][col] == 1)
            return 0;
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
            paths++;
            return 1;
        }
        if (dp[row][col] > -1)
            return dp[row][col];
        dp[row][col] = dfs(obstacleGrid, row, col + 1) + dfs(obstacleGrid, row + 1, col);
        return dp[row][col];
    }
}
