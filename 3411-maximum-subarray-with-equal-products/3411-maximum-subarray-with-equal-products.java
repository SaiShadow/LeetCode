class Solution {
    public int maxLength(int[] nums) {

        // find all subarrays and get the lcm and gcd and find the max length for this.
        int max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] subarray = Arrays.copyOfRange(nums, i, j + 1);
                int prod = 1;
                int lcm = 1;
                int gcd = 0;
                for (int num : subarray) {
                    prod *= num;
                    gcd = gcd(gcd, num);
                    lcm = (lcm * num) / gcd(lcm, num);
                }

                if (gcd * lcm == prod) {
                    max = Math.max(max, subarray.length);
                }
            }
        }
        return max;
    }

    private int gcd(int a, int b) {
        int small = Math.min(a, b);
        int big = Math.max(a, b);

        while (small != 0) {
            int temp = small;
            small = big % small;
            big = temp;
        }
        return big;
    }
}