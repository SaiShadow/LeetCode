class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = 0;
        for (int i = 0; i < nums.size(); i++) {
            int sum = 0;
            for (int index = i; index < i + r && index < nums.size(); index++) {
                sum += nums.get(index);
                int length = index - i + 1;
                if (length >= l && sum > 0) {
                    min = (min == 0) ? sum : Math.min(min, sum);
                }
            }
        }
        return min == 0 ? -1 : min;
    }
}