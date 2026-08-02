class Solution {

    int[][] dp;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {

        m = matrix.length;
        n = matrix[0].length;

        dp = new int[m][n];

        int ans = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int i, int j) {

        // Already computed
        if(dp[i][j] != 0)
            return dp[i][j];

        int best = 1;

        for(int[] d : dirs) {

            int ni = i + d[0];
            int nj = j + d[1];

            if(ni >= 0 && ni < m &&
               nj >= 0 && nj < n &&
               matrix[ni][nj] > matrix[i][j]) {

                best = Math.max(best,
                        1 + dfs(matrix, ni, nj));
            }
        }

        dp[i][j] = best;

        return best;
    }
}