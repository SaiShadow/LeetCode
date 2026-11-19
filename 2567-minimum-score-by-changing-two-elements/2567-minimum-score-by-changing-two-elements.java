class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.min(
                Math.min(
                        Math.abs(nums[1] - nums[n - 2]),
                        Math.abs(nums[2] - nums[n - 1])),
                Math.abs(nums[0] - nums[n - 3]));
    }
}
