package com.CK;

public class Main {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution().minPathSum(grid));
    }
}

class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        if (r == 0 || c == 0) return 0;
        int[][] dp = new int[2][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else if (i == 0) {
                    dp[i % 2][j] = dp[i % 2][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] + grid[i][j];
                } else {
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]) + grid[i][j];
                }

            }
        }

        return dp[(r - 1) % 2][c - 1];
    }
}