// Created by Rym on 11/03/2016

public class MaximalSquare {
    // dp[i][j] represents the length of
    // square whose lower-right corner is at matrix[i-1][j-1]
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, ans = 0;
        int[][] dp= new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                    ans = Math.max(dp[i][j], ans);
                }
            }
        }
        return ans*ans;        
    }
}
