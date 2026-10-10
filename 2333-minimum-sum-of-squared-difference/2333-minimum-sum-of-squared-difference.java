class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] freq = new int[100000 + 1];
        long sum = 0;
        long k = (long) k1 + k2;

        for (int i = 0; i < nums1.length; i++) {
            int s = Math.abs(nums1[i] - nums2[i]);
            freq[s]++;
            sum += s;
        }
        if (sum <= k) {
            return 0;
        }

        for (int max = 100000; max >= 0 && k > 0; max--) {
            int count = freq[max];
            if (count == 0) {
                continue;
            }

            int next = max - 1;
            if (count <= k) {
                freq[max] = 0;
                freq[next] += count;
                k -= count;
            } else {
                freq[max] -= k;
                freq[next] += k;
                k = 0;
            }
        }

        long result = 0;
        
        for (int i = 0; i <= 100000; i++) {
            result += (long) i * i * freq[i];
        }
        return result;
    }
}