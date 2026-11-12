class Solution {

    public int longestMonotonicSubarray(int[] nums) {
        int max = 1;
        int up = 1;
        int down = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                down++;
                up = 1;
            } else if (nums[i] < nums[i + 1]) {
                up++;
                down = 1;
            } else {
                up = 1;
                down = 1;
            }
            max = Math.max(max, Math.max(up, down));
        }
        return max;
    }

}