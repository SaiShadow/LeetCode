class Solution {
    public int minCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 1023 is exactly 10 bits of 1.
        boolean[][][] dp = new boolean[rows][cols][1024];
        dp[0][0][grid[0][0]] = true;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r == 0 && c == 0) {
                    continue;
                }

                int value = grid[r][c];

                // try out all xor combinations that you can get from left or up
                for (int i = 0; i < 1024; i++) {
                    // check edges
                    // up
                    if (r > 0 && dp[r - 1][c][i]) {
                        dp[r][c][value ^ i] = true;
                    }
                    // left
                    if (c > 0 && dp[r][c - 1][i]) {
                        dp[r][c][value ^ i] = true;
                    }

                }
            }
        }

        for (int i = 0; i < 1024; i++) {
            if (dp[rows - 1][cols - 1][i]) {
                return i;
            }
        }

        return -1;
    }
}