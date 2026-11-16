class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_000 + 7;
        int[] dp = new int[2]; // count of the odd / even subarrays of only i - 1 
        int count = 0;

        for (int num : arr) {
            int parity = num % 2;
            if (parity == 0) {
                dp[0] = (dp[0] + 1) % MOD;
            } else {
                int currentOddNumbers = dp[1];
                dp[1] = (dp[0] + 1) % MOD;
                dp[0] = currentOddNumbers % MOD;
            }
            count = (count + dp[1]) % MOD;
        }
        return count;
    }
}