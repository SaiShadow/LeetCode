class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;

        int[] freq = new int[100001];
        long sum = 0;

        for (int i = 0; i < nums1.length; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
            sum += d;
        }

        if (sum <= k) {
            return 0;
        }

        for (int max = 100000; max > 0 && k > 0; max--) {
            if (freq[max] == 0) {
                continue;
            }

            int next = max - 1;
            long count = freq[max];

            if (count <= k) {
                freq[max] = 0;
                freq[next] += count;
                k -= count;
            } else {
                long div = k / count;
                long rem = k % count;

                freq[max] -= count;
                freq[max - (int) div] += count - rem;

                if (rem > 0) {
                    freq[max - (int) div - 1] += rem;
                }

                k = 0;
            }
        }

        long result = 0;

        for (int d = 1; d <= 100000; d++) {
            result += (long) d * d * freq[d];
        }

        return result;
    }
}