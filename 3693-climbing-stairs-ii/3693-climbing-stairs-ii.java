class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = (dp[i - 1] + 1);
            if (i >= 2) {
                dp[i] = Math.min(dp[i - 2] + 4, dp[i]);
            }
            if (i >= 3) {
                dp[i] = Math.min(dp[i - 3] + 9, dp[i]);
            }

            dp[i] += costs[i - 1];
        }

        return dp[n];
    }
}