class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if (n <= 3) {
            return 0;
        }

        Arrays.sort(nums);

        return Math.min(
                Math.min(
                        Math.abs(nums[1] - nums[n - 2]),
                        Math.abs(nums[n - 1] - nums[2])),
                Math.abs(nums[0] - nums[n - 3]));
    }
}
