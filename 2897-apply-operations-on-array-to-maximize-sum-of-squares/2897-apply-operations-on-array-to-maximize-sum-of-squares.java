class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long sum = 0;

        int[] nBits = new int[31]; // 10^9 ~ 2 ^ 30

        for (int n : nums) {
            for (int i = 0; i <= 30; i++) {
                if ((n & (1 << i)) != 0) {
                    nBits[i]++;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            long n = 0;
            for (int j = 30; j >= 0; j--) {
                if (nBits[j] != 0) {
                    n |= (1L << j);
                    nBits[j]--;
                }
            }

            sum = (sum + n * n) % 1_000_000_007L;
        }

        return (int) sum;
    }
}