class Solution {
    public int numOfSubarrays(int[] arr) {
        // this is a hint 1 <= arr[i] <= 100?
        final int MOD = 1_000_000_000 + 7;
        int[] dp = new int[2]; // dp[odd / even]
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